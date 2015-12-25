package com.lenovo7.db;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.lenovo7.bean.Config;
import com.lenovo7.bean.Sensor;
import com.lenovo7.bean.SensorXY;
import com.lenovo7.bean.Sensorname;

public class Databases {
	private OpenHelper helper ;
	private static Databases db;
	private ArrayList<Integer> pmList = new ArrayList<Integer>();
	private ArrayList<Integer> coList = new ArrayList<Integer>();
	private ArrayList<Integer> lightList = new ArrayList<Integer>();
	private ArrayList<Integer> humidList = new ArrayList<Integer>();
	private ArrayList<Integer> tempList = new ArrayList<Integer>();
	
	private Databases(Context context){
		helper = new OpenHelper(context, Config.dbname, null, 1);
	}
	
	public Databases getInstance(Context context){
		if(db == null){
			db = new Databases(context);
		}
		return db;
	}
	
	public void saveToDatabases(Sensor sensor){
		insert(Sensorname.PM25, sensor.getPm(), sensor.getTime());
		insert(Sensorname.CO2, sensor.getCo(), sensor.getTime());
		insert(Sensorname.Light, sensor.getLight(), sensor.getTime());
		insert(Sensorname.Humid, sensor.getHumid(), sensor.getTime());
		insert(Sensorname.Temp, sensor.getTemp(), sensor.getTime());
	}
	
	public ArrayList<SensorXY> query60(String sensorname){
		SQLiteDatabase db = helper.getReadableDatabase();
		ArrayList<SensorXY> list = new ArrayList<SensorXY>();
		if(db.isOpen()){
			Cursor cursor = db.query(Config.table60, null, Config.sensorname + "=?", new String[]{sensorname}, null, null, null);
			if(cursor != null && cursor.getCount() > 0){
				SensorXY sensor;
				while(cursor.moveToNext()){
					sensor = new SensorXY();
					sensor.setValues(cursor.getInt(cursor.getColumnIndex(Config.sensorvalues)));
					sensor.setTime(cursor.getString(cursor.getColumnIndex(Config.time)));
					list.add(sensor);
				}
				cursor.close();
			}
			db.close();
		}
		return list;
	}
	
	public ArrayList<SensorXY> query5(String sensorname){
		SQLiteDatabase db = helper.getReadableDatabase();
		ArrayList<SensorXY> list = new ArrayList<SensorXY>();
		if(db.isOpen()){
			Cursor cursor = db.query(Config.table5, null, Config.sensorname + "=?", new String[]{sensorname}, null, null, null);
			if(cursor != null && cursor.getCount() > 0){
				SensorXY sensor;
				while(cursor.moveToNext()){
					sensor = new SensorXY();
					sensor.setValues(cursor.getInt(cursor.getColumnIndex(Config.sensorvalues)));
					sensor.setTime(cursor.getString(cursor.getColumnIndex(Config.time)));
					list.add(sensor);
				}
				cursor.close();
			}
			db.close();
		}
		return list;
	}
	
	public void insert(String sensorname ,int values , String time){
		SQLiteDatabase db = helper.getWritableDatabase();
		if(db.isOpen()){
			ContentValues v = new ContentValues();
			v.put(Config.sensorname, sensorname);
			v.put(Config.sensorvalues, values);
			v.put(Config.time, time);
			
			db.insert(Config.table60, null, v);
			
			if(Sensorname.PM25.equals(sensorname)){
				pmList.add(values);
				if(pmList.size() >= 60){
					int tol = 0;
					for (int i = 0; i < 60; i++) {
						tol = tol + pmList.get(i);
					}
					pmList.clear();
					insert5(db, sensorname, tol / 60, time);
				}
			}else if(Sensorname.CO2.equals(sensorname)){
				coList.add(values);
				if(coList.size() >= 60){
					int tol = 0;
					for (int i = 0; i < 60; i++) {
						tol = tol + coList.get(i);
					}
					coList.clear();
					insert5(db, sensorname, tol / 60, time);
				}
			}else if(Sensorname.Light.equals(sensorname)){
				lightList.add(values);
				if(lightList.size() >= 60){
					int tol = 0;
					for (int i = 0; i < 60; i++) {
						tol = tol + lightList.get(i);
					}
					lightList.clear();
					insert5(db, sensorname, tol / 60, time);
				}
			}else if(Sensorname.Humid.equals(sensorname)){
				humidList.add(values);
				if(humidList.size() >= 60){
					int tol = 0;
					for (int i = 0; i < 60; i++) {
						tol = tol + humidList.get(i);
					}
					humidList.clear();
					insert5(db, sensorname, tol / 60, time);
				}
			}else if(Sensorname.Temp.equals(sensorname)){
				tempList.add(values);
				if(tempList.size() >= 60){
					int tol = 0;
					for (int i = 0; i < 60; i++) {
						tol = tol + tempList.get(i);
					}
					tempList.clear();
					insert5(db, sensorname, tol / 60, time);
				}
			}
			
			Cursor cursor = db.query(Config.table60, null, Config.sensorname + "=?", new String[]{sensorname}, null, null, "_id");
			if(cursor.moveToFirst()){
				if(cursor.getCount() > 60){
					String delete = "delete from " + Config.table60 + " where _id = ?";
					db.execSQL(delete, new String[]{cursor.getString(cursor.getColumnIndex("_id"))});
				}
				cursor.close();
			}
			db.close();
		}
	}
	
	
	private void insert5(SQLiteDatabase db , String sensorname , int values , String time){
		ContentValues v = new ContentValues();
		v.put(Config.sensorname, sensorname);
		v.put(Config.sensorvalues, values);
		v.put(Config.time, time);
		
		db.insert(Config.table5, null, v);
		
		Cursor cursor = db.query(Config.table5, null, Config.sensorname + "=?", new String[]{sensorname}, null, null, "_id");
		if(cursor.moveToFirst()){
			if(cursor.getCount() > 5){
				String delete = "delete from " + Config.table5 + " where _id = ?";
				db.execSQL(delete, new String[]{cursor.getString(cursor.getColumnIndex("_id"))});
			}
			cursor.close();
		}
	}
}
