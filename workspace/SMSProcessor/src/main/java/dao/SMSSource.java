package dao;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import util.TypeSerializer;

@JsonSerialize(using = TypeSerializer.class)
public enum SMSSource {

	BOOKMYSHOW(0,"BOOKMYSHOW"),
	IRCTC(0,"IRCTC");
	
	private final int id;
	private final String name;
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	private SMSSource(int id, String name) {
		this.id = id;
		this.name = name;
	}
}
