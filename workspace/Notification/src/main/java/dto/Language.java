package dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import util.TypeSerializer;

@JsonSerialize(using = TypeSerializer.class)
public enum Language {
	ENGLISH(1,"ENGLISH"), FRENCH(1,"FRENCH");
/*	@SerializedName("0") ENGLISH(0),
	@SerializedName("1") FRENCH(1);

*/	
	private Integer id;
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private Language(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	    
	    
}
