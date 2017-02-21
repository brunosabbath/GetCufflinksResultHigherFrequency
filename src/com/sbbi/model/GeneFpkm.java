package com.sbbi.model;

public class GeneFpkm {

	private String id;
	private String frequency;
	
	
	public GeneFpkm(String transctiptId, String frequency) {
		this.id = transctiptId;
		this.frequency = frequency;
	}
	public String getIdSimple() {
		String query[] = id.split("\\.");
		return query[0];
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	
	
	
}
