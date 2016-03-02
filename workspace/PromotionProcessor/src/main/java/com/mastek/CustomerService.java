package com.mastek;

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
import org.json.JSONObject;
import org.springframework.stereotype.Component;

//http://localhost:8080/PromotionProcessor-0.1/spring/customerservice/gettransactions?customerId=1

@Path("customerservice")
@Component
public class CustomerService {

	// Service to get Customer Details for notification.
	@Path("/gettransactions")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getCustomerTransactions(@Context UriInfo info) {
		JSONObject jobj = new JSONObject();

		for (Map.Entry<String, List<String>> e : info.getQueryParameters()
				.entrySet()) {
			jobj.put(e.getKey(), e.getValue().get(0));
		}

		JSONObject transactions = new JSONObject(
				getTransactions(jobj.getString("customerId")));
		return transactions.toString();
	}

	public String getTransactions(String customerId) {
		// for a customer id find the accounts
		JSONObject customerAcctDet = new JSONObject(getOtherDetails(customerId));
		JSONObject transactions = new JSONObject();
		for (int i = 0; i < customerAcctDet.getJSONArray("accounts").length(); i++) {
			
			// loop through the accounts and get all the transactions for each
			// account
			String accountId = customerAcctDet.getJSONArray("accounts")
					.getJSONObject(i).getString("id");
			System.out.println(accountId);
			String accountTransactions = getAccountTransactions(customerId, accountId);

			if (!accountTransactions.isEmpty()) {
				JSONObject acctTransactions = new JSONObject(accountTransactions);
				for (Object j : acctTransactions.getJSONArray("transactions"))
				{
					transactions.accumulate("transactions",j);
				}
			}
		}
		System.out.println(transactions.toString());
		return transactions.toString();
	}

	/*
	 * // Service to get Customer Details for notification. public String
	 * getAccountTransactions(String accountId) { String link =
	 * "https://demo9439206.mockable.io/banks/CBANK/views/transactions"; Client
	 * client = ClientBuilder.newClient(new ClientConfig()); String transactions
	 * = client.target(link) .queryParam("accountId", accountId)
	 * .request(MediaType.APPLICATION_JSON).get(String.class); return
	 * transactions; }
	 */
	// Service to get Customer Details for notification.
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
	public String getCustomerDetails(String custid) {
		String link = "http://104.131.44.187:8081/CxfRestService/rest/customerservices/getcustomerdetails";
		Client client = ClientBuilder.newClient(new ClientConfig());
		String userDetail = client.target(link)
				.queryParam("customerId", custid)
				.request(MediaType.APPLICATION_JSON).get(String.class);
		return userDetail;
	}

	// Service to get Customer account details
	public String getOtherDetails(String custid) {
		String link = "http://104.131.44.187:8081/CxfRestService/rest/customerservices/getcustomeraccountdetails";
		Client client = ClientBuilder.newClient(new ClientConfig());
		String otherDetail = client.target(link)
				.queryParam("customerId", custid)
				.request(MediaType.APPLICATION_JSON).get(String.class);
		return otherDetail;
	}

	/*
	 * Data currently returned by the mock transaction api
	 */
}
