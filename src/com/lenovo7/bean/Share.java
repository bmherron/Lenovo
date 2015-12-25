package com.lenovo7.bean;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Share {
	public static final String IP= "ip";
	public static final String PORT = "port";
	public static final String GUIDE = "guide";
	public static final String Lang = "lang";
	public static final String MUSIC = "music";
	
	public static final String PMup = "pmup";
	public static final String PMdown = "pmdown";
	public static final String COup = "coup";
	public static final String COdown = "codown";
	public static final String Lightup ="lightup";
	public static final String Lightdown = "lightdown";
	public static final String Humidup = "humidup";
	public static final String Humiddown = "humiddown";
	public static final String Tempup = "tempup";
	public static final String Tempdown = "tempdown";
	
	private SharedPreferences share;
	
	public Share(Context context){
		share = PreferenceManager.getDefaultSharedPreferences(context);
	}
	
	public void save(String key , Object values){
		if(values instanceof String){
			share.edit().putString(key, (String) values).commit();
		}else if(values instanceof Integer){
			share.edit().putInt(key, (Integer) values).commit();
		}else if(values instanceof Boolean){
			share.edit().putBoolean(key, (Boolean) values).commit();
		}
	}
	
	
	public void setIP(String ip){
		save(IP, ip);
	}
	public String getIP(){
		return share.getString(IP, "192.168.228.18");
	}
	
	public void setPORT(String port){
		save(PORT, port);
	}
	public String getPORT(){
		return share.getString(PORT, "8080");
	}
	
	public void setGuide(boolean is){
		save(GUIDE, is);
	}
	public boolean getGuide(){
		return share.getBoolean(GUIDE, true);
	}
	
	public void setLang(boolean is){
		save(Lang, is);
	}
	public boolean getLang(){
		return share.getBoolean(Lang, true);
	}
	
	public void setMUSIC(boolean is){
		save(MUSIC, is);
	}
	public boolean getMUSIC(){
		return share.getBoolean(MUSIC, true);
	}
	
	
	
	public void setPMup(int values){
		save(PMup, values);
	}
	public int getPMup(){
		return share.getInt(PMup, 5000);
	}
	
	public void setCOup(int values){
		save(COup, values);
	}
	public int getCOup(){
		return share.getInt(COup, 5000);
	}
	
	public void setLightup(int values){
		save(Lightup, values);
	}
	public int getLightup(){
		return share.getInt(Lightup, 5000);
	}
	
	public void setHumidup(int values){
		save(Humidup, values);
	}
	public int getHumidup(){
		return share.getInt(Humidup, 5000);
	}
	
	public void setTempup(int values){
		save(Tempup, values);
	}
	public int getTempup(){
		return share.getInt(Tempup, 5000);
	}
	
	
	
	public void setPMdown(int values){
		save(PMdown, values);
	}
	public int getPMdown(){
		return share.getInt(PMdown, 5000);
	}
	
	public void setCOdown(int values){
		save(COdown, values);
	}
	public int getCOdown(){
		return share.getInt(COdown, 5000);
	}
	
	public void setLightdown(int values){
		save(Lightdown, values);
	}
	public int getLightdown(){
		return share.getInt(Lightdown, 5000);
	}
	
	public void setHumiddown(int values){
		save(Humiddown, values);
	}
	public int getHumiddown(){
		return share.getInt(Humiddown, 5000);
	}
	
	public void setTempdown(int values){
		save(Tempdown, values);
	}
	public int getTempdown(){
		return share.getInt(Tempdown, 5000);
	}
}
