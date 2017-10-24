package com.route21.ws.types;

public enum PartyActivityTypeEnum {

	SKILLS(1), ACHIEVEMENTS(2), HOBBIESANDINTEREST(3), DREAM(4), COVERIMAGE(5);
	
	public long type; 
	
	private PartyActivityTypeEnum(long t)
	{
		this.type = t;
	}

	public long getType() {
		return type;
	}
	
	
}
