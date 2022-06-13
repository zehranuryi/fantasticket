package com.codecrew.fantasticket.enums;

import javax.accessibility.AccessibleSelection;

public enum EventSubType {
	// Music
	Pop(0),
	Hiphop(1),
	Rock(2),
	Funk(3),
	Folk(4),
	Jazz(5),
	Blues(6),
	Classical(7),
	Electronic(8),
	
	// Movie
	Action(9),
	Animation(10),
	Comedy(11),
	Drama(12),
	Horror(13),
	Mystery(14),
	Romance(15),
	Thriller(16),
	
	// Theater
	Child(17),
	Adult(18);
	
	private Integer type;
	
	public Integer getType() {
		return type;
	}
	
	EventSubType(Integer type){
		this.type = type;
	}
	
	public static EventSubType get(Integer type){
		switch (type){
			case 0:
				return Pop;
			case 1:
				return Hiphop;
			case 2:
				return Rock;
			case 3:
				return Funk;
			case 4:
				return Folk;
			case 5:
				return Jazz;
			case 6:
				return Blues;
			case 7:
				return Classical;
			case 8:
				return Electronic;
			case 9:
				return Action;
			case 10:
				return Animation;
			case 11:
				return Comedy;
			case 12:
				return Drama;
			case 13:
				return Horror;
			case 14:
				return Mystery;
			case 15:
				return Romance;
			case 16:
				return Thriller;
			case 17:
				return Child;
			case 19:
				return Adult;
			default:
				throw new IllegalArgumentException("No such a type "+ type);
		}
	}
}