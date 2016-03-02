package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.client.ClientConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component("vendorservice")
public class VendorService {

	// Service to get Customer Details for notification.
	public String getVendorList() {
		String link = "http://demo9439206.mockable.io/getvendorslist";
		Client client = ClientBuilder.newClient(new ClientConfig());
		String vendors = client.target(link)
				.request(MediaType.APPLICATION_JSON).get(String.class);
		
		//System.out.println(vendors);
		return vendors;
	}


	public Map<String,List> getVendorMap(){
		Map<String,List> vendorcatmap = new HashMap<String, List>();
		JSONObject vendors= new JSONObject(getVendorList());
		for (Object json : vendors.getJSONArray("vendorlist"))
		{
			JSONObject vendor = (JSONObject) json;
			vendorcatmap.put(vendor.getString("vendorname"), toList(vendor.getJSONArray("category")));
		}
		return vendorcatmap;
	}
	
	
	public static Map<String, Object> jsonToMap(JSONObject json)
			throws JSONException {
		Map<String, Object> retMap = new HashMap<String, Object>();
		if (json != JSONObject.NULL) {
			retMap = toMap(json);
		}
		return retMap;
	}

	public static Map<String, Object> toMap(JSONObject object)
			throws JSONException {
		Map<String, Object> map = new HashMap<String, Object>();
		Iterator<String> keysItr = object.keys();
		while (keysItr.hasNext()) {
			String key = keysItr.next();
			Object value = object.get(key);

			if (value instanceof JSONArray) {
				value = toList((JSONArray) value);
			}

			else if (value instanceof JSONObject) {
				value = toMap((JSONObject) value);
			}
			map.put(key, value);
		}
		return map;
	}

	public static List<Object> toList(JSONArray array) throws JSONException {
		List<Object> list = new ArrayList<Object>();
		for (int i = 0; i < array.length(); i++) {
			Object value = array.get(i);
			if (value instanceof JSONArray) {
				value = toList((JSONArray) value);
			}

			else if (value instanceof JSONObject) {
				value = toMap((JSONObject) value);
			}
			list.add(value);
		}
		return list;
	}

/*	
Data currently returned by the mock service
{"vendorlist":[
    {"vendorname":"Music Library Pvt Ltd", "category":["Music","Music Memoriables","Books","Books and Media"]},
    {"vendorname":"Big-Bazaar", "category":["Apparels","Home-Appliance","Groceries"]},
    {"vendorname":"Lotus Cafe", "category":["Fine-Dining"]},
    {"vendorname":"SeaSongs", "category":["Luxury","5-Star","Beach Resort","Spa"]},
    {"vendorname":"Hobby Ideas", "category":["Hobby","Stationary","School","Art"]},
    {"vendorname":"Sparky", "category":["Flowers","Home-Decorations","Gifts"]},
    {"vendorname":"MayLine", "category":["Gadgets","Mobile","Devices"]},
    {"vendorname":"E Car Pvt Ltd", "category":["Car-Accessories","Car","Devices"]},
    {"vendorname":"Phillipo", "category":["Apparels"]},
    {"vendorname":"Star Cruise", "category":["Travel","Cruise"]},
    {"vendorname":"Vijay Sales", "category":["Gadgets","Home-Appliance","Electronics"]},
]
}
*/}
