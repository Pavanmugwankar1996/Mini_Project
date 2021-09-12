package com.Model;

import java.time.LocalTime;

public class Restaurant {
private int id;
private String name;
private LocalTime opentime;
private LocalTime closetime;
private long phone_no;
private String address;
private String cuisine;
private int activeStatus;
public Restaurant(int id, String name, LocalTime opentime, LocalTime closetime, long phone_no, String address,
		String cuisine, int activeStatus) {
	super();
	this.id = id;
	this.name = name;
	this.opentime = opentime;
	this.closetime = closetime;
	this.phone_no = phone_no;
	this.address = address;
	this.cuisine = cuisine;
	this.activeStatus = activeStatus;
}




public Restaurant() {
	
}




public int getId() {
	return id;
}




public void setId(int id) {
	this.id = id;
}




public String getName() {
	return name;
}




public void setName(String name) {
	this.name = name;
}




public LocalTime getOpentime() {
	return opentime;
}




public void setOpentime(LocalTime opentime) {
	this.opentime = opentime;
}




public LocalTime getClosetime() {
	return closetime;
}




public void setClosetime(LocalTime closetime) {
	this.closetime = closetime;
}




public long getPhone_no() {
	return phone_no;
}




public void setPhone_no(long phone_no) {
	this.phone_no = phone_no;
}




public String getAddress() {
	return address;
}




public void setAddress(String address) {
	this.address = address;
}




public String getCuisine() {
	return cuisine;
}




public void setCuisine(String cuisine) {
	this.cuisine = cuisine;
}




@Override
public String toString() {
	return "Restaurant Id= " + id + ", Name= " + name + ", Opening Time= " + opentime + ", Closing Time= " + closetime
			+ ", Phone Number= " + phone_no + ", Address= " + address + ", Cuisine= " + cuisine + ", Activation Status= " + activeStatus ;
}



}
