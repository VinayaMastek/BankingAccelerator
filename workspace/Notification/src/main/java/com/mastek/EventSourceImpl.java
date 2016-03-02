/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2013 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * http://glassfish.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */
package com.mastek;

import java.io.IOException;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import util.GenerateNotification;

/**
 * serviceimplementation to get source events
 * 
 * @author vinaya
 */
@Component("eventSource")
public class EventSourceImpl implements EventSource {

	@Autowired
	public GenerateNotification generateNotification;

	@Override
	public String getMessage(String srcevent) {
		JSONObject json = new JSONObject(srcevent);
		String result = getUserDetail(json.getString("customerId"));
		
		generateNotification.setDataAttributes(jsonToMap(json));
		generateNotification
				.setCustAttributes(jsonToMap(new JSONObject(result)));
		
		JSONObject acctDetail = new JSONObject(
				getOtherDetails(json.getString("customerId")));
		JSONArray accounts = acctDetail.getJSONArray("accounts");
		
		if (!json.isNull("accountNumber")) {
			for (Object object : accounts) {
				JSONObject account = (JSONObject) object;
				if (account.get("accountCode")
						.equals(json.get("accountNumber"))) {
					Map<String, Object> dataAttributes = generateNotification
							.getDataAttributes();
					dataAttributes.put("productType",
							account.get("productType"));
					dataAttributes.put("accountType",
							account.get("accountType"));
					generateNotification.setDataAttributes(dataAttributes);
				}
			}
		}
		try {
			generateNotification.generateNotification();
		} catch (IOException e) {
			System.out.println("exception raised");
			e.printStackTrace();
		}
		return srcevent;
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

	// Service to get Customer Details for notification.
	private String getUserDetail(String custid) {
		String link = "http://104.131.44.187:8081/CxfRestService/rest/customerservices/getcustomerdetails";
		Client client = ClientBuilder.newClient(new ClientConfig());
		String userDetail = client.target(link)
				.queryParam("customerId", custid)
				.request(MediaType.APPLICATION_JSON).get(String.class);
		return userDetail;
	}

	// Service to get Customer Details for notification.
	private String getOtherDetails(String custid) {
		String link = "http://104.131.44.187:8081/CxfRestService/rest/customerservices/getcustomeraccountdetails";
		Client client = ClientBuilder.newClient(new ClientConfig());
		String otherDetail = client.target(link)
				.queryParam("customerId", custid)
				.request(MediaType.APPLICATION_JSON).get(String.class);
		return otherDetail;
	}

}
