package com.mastek;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastek.ParseSMSTemplate;
import dao.SMSSource;

@Component
public class ParserSMSTemplateFactory {

@Autowired
BookMyShowImpl bookMyshow;

@Autowired
IRCTCImpl irctc;

public ParseSMSTemplate buildParser(String msgData){
	JSONObject json = new JSONObject(msgData);
	SMSSource source =  SMSSource.valueOf(json.get("source").toString());
	
	switch (source) {
	case BOOKMYSHOW :
		return bookMyshow;
	case IRCTC:
		return irctc;

	default:
		return null;
	}
}	
}
