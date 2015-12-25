package com.lenovo7.bean;

public class Sensor {
	private int pm;
	private int co;
	private int light;
	private int humid;
	private int temp;
	private String time;
	public int getPm() {
		return pm;
	}
	public void setPm(int pm) {
		this.pm = pm;
	}
	public int getCo() {
		return co;
	}
	public void setCo(int co) {
		this.co = co;
	}
	public int getLight() {
		return light;
	}
	public void setLight(int light) {
		this.light = light;
	}
	public int getHumid() {
		return humid;
	}
	public void setHumid(int humid) {
		this.humid = humid;
	}
	public int getTemp() {
		return temp;
	}
	public void setTemp(int temp) {
		this.temp = temp;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
}
