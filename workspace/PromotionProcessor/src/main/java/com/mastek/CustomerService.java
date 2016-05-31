package com.mastek;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.glassfish.jersey.client.ClientConfig;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dao.CustomerDetails;
import util.VendorService;
import dao.CustomerDetails;

//http://localhost:8080/PromotionProcessor-0.1/spring/customerservice/gettransactions?customerId=1

@Path("customerservice")
@Component
public class CustomerService {

	@Autowired
	VendorService vendorservice;

	// Service to get all transactions for a customer
	@Path("/gettransactions")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getCustomerTransactions(@Context UriInfo info) {
		/*
		 * JSONObject jobj = new JSONObject();
		 * 
		 * for (Map.Entry<String, List<String>> e : info.getQueryParameters()
		 * .entrySet()) { jobj.put(e.getKey(), e.getValue().get(0)); }
		 * 
		 * JSONObject transactions = new JSONObject(
		 * getTransactions(jobj.getString("customerId")));
		 */
		JSONObject transactions = new JSONObject(getTransactions(getCustomerId(info)));
		return transactions.toString();
	}

	private String getCustomerId(UriInfo info) {
		JSONObject jobj = new JSONObject();
		for (Map.Entry<String, List<String>> e : info.getQueryParameters()
				.entrySet()) {
			jobj.put(e.getKey(), e.getValue().get(0));
		}
		return jobj.getString("customerId");
	}

	// Get transactions for a customerid
	public String getTransactions(String customerId) {
		// for a customer id find the accounts
		JSONObject customerAcctDet = new JSONObject(getOtherDetails(customerId));
		JSONObject transactions = new JSONObject();
		for (int i = 0; i < customerAcctDet.getJSONArray("accounts").length(); i++) {

			// loop through the accounts and get all the transactions for each
			// account
			String accountId = customerAcctDet.getJSONArray("accounts")
					.getJSONObject(i).getString("id");
			// System.out.println(accountId);
			String accountTransactions = getAccountTransactions(customerId,
					accountId);

			if (!accountTransactions.isEmpty()) {
				JSONObject acctTransactions = new JSONObject(
						accountTransactions);
				for (Object j : acctTransactions.getJSONArray("transactions")) {
					transactions.accumulate("transactions", j);
				}
			}
		}
		System.out.println(transactions.toString());
		return transactions.toString();
	}

	// Get all transactions accounts for a given customer and account id
	public String getAccountTransactions(String customerId, String accountId) {
		String transactions = "";
		if (accountId.equals("1") || accountId.equals("100001")) {
			String link = "https://demo9439206.mockable.io/banks/CBANK/views/"
					+ "customer/" + customerId + "/account/" + accountId
					+ "/transactions";
			Client client = ClientBuilder.newClient(new ClientConfig());
			transactions = client.target(link)
					.queryParam("accountId", accountId)
					.request(MediaType.APPLICATION_JSON).get(String.class);
		}
		return transactions;
	}

	// Service to get Customer demographics
	public String getCustomerDetails(String customerId) {
		String link = "http://104.131.44.187:8081/CxfRestService/rest/customerservices/getcustomerdetails";
		Client client = ClientBuilder.newClient(new ClientConfig());
		String userDetail = client.target(link)
				.queryParam("customerId", customerId)
				.request(MediaType.APPLICATION_JSON).get(String.class);
		return userDetail;
	}

	// Service to get Customer account details
	public String getOtherDetails(String customerId) {
		String link = "http://104.131.44.187:8081/CxfRestService/rest/customerservices/getcustomeraccountdetails";
		Client client = ClientBuilder.newClient(new ClientConfig());
		String otherDetail = client.target(link)
				.queryParam("customerId", customerId)
				.request(MediaType.APPLICATION_JSON).get(String.class);
		return otherDetail;
	}

	
	// Service to get all transactions for a customer
	@Path("/getCustomerPersona")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getCustomerPersonaService(@Context UriInfo info) {
		return getCustomerPersona(getCustomerId(info)).toString();
	}
	
	/*
	 * Get Customer Persona with spends
	 */
	@SuppressWarnings("unchecked")
	private String getCustomerPersona(String customerId) {
		JSONObject jobj = new JSONObject(getvendorwisespend(customerId));
		
		
		CustomerDetails customerDetails = new CustomerDetails();
		customerDetails.setSpendMap("spends", (Collection<JSONObject>) jobj.get("vendorspend"));
		customerDetails.setPersona(customerDetails.derivePersona());
		
		return new JSONObject(customerDetails).toString();
	}
	
	
	// Service to get vendorwise spend
	@Path("/getvendorwisespend")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getvendorwisespendservice(@Context UriInfo info) {
		return getvendorwisespend(getCustomerId(info));
	}	
		
	private String getvendorwisespend(String customerId) {
		Map<String, JSONObject> vendorlist = new HashMap<String, JSONObject>();
		Map<String, List> vendorCategoryMap = vendorservice.getVendorMap();

		// get transactions for the customer across all accounts
		// account
		JSONObject acctTransactions = new JSONObject(getTransactions(customerId));
		if (haskey(acctTransactions, "transactions")) {
			JSONArray transactions = acctTransactions
					.getJSONArray("transactions");
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
					List<String> vendorCat = vendorCategoryMap.containsKey(key) ? vendorCategoryMap
							.get(key) : (List<String>) Arrays.asList("UnKnown");

					// construct json with details of the vendor with
					// categories, count of transactions and transaction amount
					JSONObject vendordet = new JSONObject();
					vendordet.put("vendor", key);
					vendordet.put("count", value);
					vendordet.put("categories", vendorCat);
					vendordet.put("tranamt", tranamt);
					vendorlist.put(key, vendordet);
				}
			}
		}
		String json = "{" + "vendorspend" + ":"
				+ vendorlist.values().toString() + "}";
		return new JSONObject(json).toString();
	}

	// Service to get categorywise spend
	@Path("/getcategorywisespend")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getcategorywisespendservice(@Context UriInfo info) {
		return getCategoryWiseSpend(getCustomerId(info));
	}
	
	private String getCategoryWiseSpend(String customerId) {
		Map<String, JSONObject> categorylist = new HashMap<String, JSONObject>();
		Map<String, List> vendorCategoryMap = vendorservice.getVendorMap();

		// get transactions for the customer across all accounts
		// account
		JSONObject acctTransactions = new JSONObject(
				getTransactions(customerId));

		double tranamt = 0;
		if (haskey(acctTransactions, "transactions")) {

			// loop through the transactions list to get vendors and count of
			// transactions
			for (Object obj : acctTransactions.getJSONArray("transactions")) {
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

					System.out.println(key);
					// update categories
					List<String> vendorCat = vendorCategoryMap.containsKey(key) ? vendorCategoryMap
							.get(key) : (List<String>) Arrays.asList("UnKnown");

					System.out.println(vendorCat.toArray().toString());

					for (String cat : vendorCat) {
						// calculate number of transactions for the vendor and
						// total
						// transaction amount
						if (categorylist.containsKey(cat)) {
							value = categorylist.get(cat).getInt("count") + 1;
							tranamt = tranamt
									+ Math.abs(categorylist.get(cat).getDouble(
											"tranamt"));
							categorylist.remove(cat);
						}
						JSONObject categorydet = new JSONObject();
						categorydet.put("category", cat);
						categorydet.put("count", value);
						categorydet.put("tranamt", tranamt);
						categorylist.put(cat, categorydet);
					}

				}
			}
		}
		String json = "{" + "spendcategories" + ":"
				+ categorylist.values().toString() + "}";
		return new JSONObject(json).toString();
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
