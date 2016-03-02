package com.mastek;


import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dao.CustPrefRepository;
import dto.CustPref;
import dto.Language;
import dto.Preference;


@Path("preference")
@Component
public class CustPreferenceService {


	@Autowired
	private CustPrefRepository custPrefRepo;

    @GET
    @Path("/acctPref")
    @Produces(MediaType.TEXT_PLAIN)
	public Response getCustPref(@Context HttpHeaders headers, @QueryParam("customerId") String customerId){
		List<CustPref> acctPref = custPrefRepo.findByCustomerId(customerId);
		String result = acctPref.get(0).getEmail();
		return Response.status(201).entity(result).build();
	}

	
	@POST
	@Path("/accpref")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addCustPref(String data) {
		JSONObject json = new JSONObject(data);
		System.out.println(data);
		CustPref custPref = new CustPref();
		custPref.setCustomerId(json.getString("customerId"));
		custPref.setEmail(json.getString("email"));
		custPref.setLanguage((Language) json.get("language"));
		custPref.setNotify(json.getBoolean("notify"));
		JSONArray prefs = json.getJSONArray("prefs");
		List<Preference> prefList = new ArrayList<Preference>();
		String result = "Data post : " + custPref.toString();
		custPrefRepo.save(custPref);
		
		return Response.status(201).entity(result).build();
	}

//http://localhost:8080/tekathon/spring/preference/accpref
//srcevent={"acctNo": "AC1","email": "a.k@gmail.com", "id": "A1","language": "ENGLISH",	"notify": true, "prefs":[{"id":1,"name":"EMAIL"},{"id":0 ,"name":"SMS"}], "sms": "9850486166"}

}