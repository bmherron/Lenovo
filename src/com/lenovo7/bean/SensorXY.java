package com.lenovo7.bean;

public class SensorXY {
	private int values ;
	private String time;
	public int getValues() {
		return values;
	}
	public void setValues(int values) {
		this.values = values;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public SensorXY(int values, String time) {
		super();
		this.values = values;
		this.time = time;
	}
	public SensorXY() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
