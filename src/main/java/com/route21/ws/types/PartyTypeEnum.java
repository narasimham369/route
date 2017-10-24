package com.route21.ws.types;

public enum PartyTypeEnum {

	Employer(1), Student(2);

	public long value; 
	
	private PartyTypeEnum(long v) {
		this.value = v;
	}

	public long getValue() {
		return value;
	}

	
}
