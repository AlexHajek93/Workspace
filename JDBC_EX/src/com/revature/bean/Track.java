package com.revature.bean;

public class Track {
	private int trackid;
	private String name;
//Use objects when referencing other tables
//	private Album album;
//	private MediaType mediaType;
//	private Genre genre;
	private String composer;
	private int milliseconds;
	private int bytes;
	private double unitPrice;
	public int getTrackid() {
		return trackid;
	}
	public void setTrackid(int trackid) {
		this.trackid = trackid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComposer() {
		return composer;
	}
	public void setComposer(String composer) {
		this.composer = composer;
	}
	public int getMilliseconds() {
		return milliseconds;
	}
	public void setMilliseconds(int milliseconds) {
		this.milliseconds = milliseconds;
	}
	public int getBytes() {
		return bytes;
	}
	public void setBytes(int bytes) {
		this.bytes = bytes;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public Track() {
		super();
	}
	public Track(int trackid, String name, String composer, int milliseconds, int bytes, double unitPrice) {
		super();
		this.trackid = trackid;
		this.name = name;
		this.composer = composer;
		this.milliseconds = milliseconds;
		this.bytes = bytes;
		this.unitPrice = unitPrice;
	}
	@Override
	public String toString() {
		return "Track [trackid=" + trackid + ", name=" + name + ", composer=" + composer + ", milliseconds=" + milliseconds
		    + ", bytes=" + bytes + ", unitPrice=" + unitPrice + "]";
	}
}
