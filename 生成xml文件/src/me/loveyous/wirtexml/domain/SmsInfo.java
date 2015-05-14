package me.loveyous.wirtexml.domain;



public class SmsInfo {
	private long date;
	private int type;
	private String body;
	private String address;
	
	
	public SmsInfo(long date, int type, String body, String address) {
		super();
		this.date = date;
		this.type = type;
		this.body = body;
		this.address = address;
	}
	
	public SmsInfo() {
		
	}
	
	public long getDate() {
		return date;
	}
	public void setDate(long date) {
		this.date = date;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
