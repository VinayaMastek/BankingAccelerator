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

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Path;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import util.VendorService;
import dao.CustomerDetails;

@Path("customerprofileservice")
@Component
public class CustomerProfileService {
	@Autowired
	CustomerService customerservice;

	@Autowired
	VendorService vendorservice;

	public String getCustDemographic(String custstr) {
		JSONObject jobj = new JSONObject(custstr);

		CustomerDetails custDetails = new CustomerDetails();

		// bookmyshow has location
		if (jobj.has("location"))
			custDetails.setLocation(jobj.getString("location"));

		// irctc has destination
		if (jobj.has("destination"))
			custDetails.setLocation(jobj.getString("destination"));

		String result = customerservice.getCustomerDetails(jobj
				.getString("customerId"));

		JSONObject cust = new JSONObject(result);
		custDetails.setCustomerId(jobj.getString("customerId"));
		custDetails.setAgeGroup(cust.getString("dob"));

		// currently the customer service does not provide income and
		// qualification details
		// irctc has destination
		custDetails.setIncomeGroup(jobj.has("income") ? jobj
				.getDouble("income") : 0);

		// sample values for qualification "EMPTY", "B.Sc", "B.Com","BE","MCA",
		// "MBA", "H.S.C","S.S.C"
		custDetails.setQualificationGroup(jobj.has("qualification") ? jobj
				.getString("qualification") : "EMPTY");
		custDetails.setEmploymentGroup(jobj.has("employment") ? jobj
				.getString("employment") : "EMPTY");
		return new JSONObject(custDetails).toString();
	}

	public String getCustomerPreference(String customerId) {

		Map<String, JSONObject> vendorlist = new HashMap<String, JSONObject>();
		Map<String, List> vendorCategoryMap = vendorservice.getVendorMap();


		
		// get transactions for the customer across all accounts
		// account
		JSONObject acctTransactions = new JSONObject(
				customerservice.getTransactions(customerId));
		JSONArray transactions = acctTransactions.getJSONArray("transactions");
		
		
		double tranamt = 0;
		// loop through the transactions list to get vendors and count of
		// transactions
		for (Object obj : transactions) {
			JSONObject transaction = (JSONObject) obj;

			if (haskey(transaction, "other_account.holder.name",
					"details.value.amount")) {
				// transaction amount
				tranamt = transaction.getJSONObject("details")
						.getJSONObject("value").getDouble("amount");

				// vendor details
				String key = transaction.getJSONObject("other_account")
						.getJSONObject("holder").getString("name");
				Integer value = 1;

				// calculate number of transactions for the vendor and total
				// transaction amount
				if (vendorlist.containsKey(key)) {
					value = vendorlist.get(key).getInt("count") + 1;
					tranamt = tranamt
							+ vendorlist.get(key).getDouble("tranamt");
					vendorlist.remove(key);
				}

				// update categories
				List<String> vendorCat = vendorCategoryMap.containsKey(key) ? (List) vendorCategoryMap
						.get(key) : (List) Arrays.asList("UnKnown");

				// construct json with details of the vendor with
				// categories, count of transactions and transaction amount
				JSONObject vendordet = new JSONObject();
				vendordet.put("count", value);
				vendordet.put("categories", vendorCat);
				vendordet.put("tranamt", tranamt);
				vendorlist.put(key, vendordet);
			}
		}

		CustomerDetails customerDetails = new CustomerDetails();
		customerDetails.setSpendMap("spends", vendorlist.values());
		customerDetails.setPersona(customerDetails.derivePersona());

		return new JSONObject(customerDetails).toString();
	}

	private boolean haskey(JSONObject originaljson, String... keystocheck) {
		// check for all the keys in the json object for existence
		// since the keys can have hierarchy check for nested existence
		boolean has = true;
		for (String key : keystocheck) {
			JSONObject json = originaljson;
			String[] keys = key.split("\\.");
			if (keys.length > 1) {
				int i = 0;
				while (has) {
					has = json.has(keys[i]);
					if (i < keys.length - 1)
						json = json.getJSONObject(keys[i]);
					i++;
					if (i > keys.length - 1)
						break;
				}
			} else
				has = json.has(keys[0]);
		}
		return has;
	}

}