package dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import util.TypeSerializer;

@JsonSerialize(using = TypeSerializer.class)
public enum Preference {

	SMS(0,"SMS"), EMAIL(1,"EMAIL"),INAPP(2,"INAPP");
	
	private final int id;
	private final String name;
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	private Preference(int id, String name) {
		this.id = id;
		this.name = name;
	}
}
