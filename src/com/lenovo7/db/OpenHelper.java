package com.lenovo7.db;

import com.lenovo7.bean.Config;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class OpenHelper extends SQLiteOpenHelper {

	public OpenHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase arg0) {
		String sql5 = "create table " + Config.table5 + " ("
				+ "_id integer primary key autoincrement , " + Config.sensorname + 
				" varchar(20) , " + Config.sensorvalues + " varchar(20) , " + 
				Config.time + " varchar(20))";
		String sql60 = "create table " + Config.table60 + " ("
				+ "_id integer primary key autoincrement , " + Config.sensorname + 
				" varchar(20) , " + Config.sensorvalues + " varchar(20) , " + 
				Config.time + " varchar(20))";
		
		arg0.execSQL(sql60);
		arg0.execSQL(sql5);
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}
