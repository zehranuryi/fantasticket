package com.codecrew.fantasticket.enums;

public enum EventType {
	MUSIC(0),
	THEATER(1),
	CINEMA(2);

	private Integer type;

	public Integer getType() {
		return type;
	}

	EventType(Integer type){
		this.type = type;
	}

	EventType(){}

	public static EventType get(Integer type){
		switch (type){
			case 0:
				return MUSIC;
			case 1:
				return THEATER;
			case 2:
				return CINEMA;
			default:
				throw new IllegalArgumentException("No such a type "+ type);
		}
	}
}