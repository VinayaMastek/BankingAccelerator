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
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastek.ParserSMSTemplateFactory;

@Path("parserservice")
@Component
public class MsgParserService {

    @Autowired
    private ParserSMSTemplateFactory parserFactory;

    @Path("/getParsedSMS")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getParsedSMS(@Context HttpHeaders headers, @QueryParam("smsData") String smsData){
    	System.out.println(smsData);
    	String result = parserFactory.buildParser(smsData).getSMSData(smsData);
    	
    	System.out.println(result);
    	String output = sendEvent(result);
    	System.out.println("*****" + output + "********");
    	
    	return Response.status(201).build();
    	
    }

    
    @Path("/getjson")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getjson(@Context HttpHeaders headers){
    	String nval="vinaya";
    	String nval2="mallik";
    	
    	//String jsonstr = "{\"name\":"+"\\\""+nval+"\\\""+"}";
    	
    	JSONArray jsonarray = new JSONArray();
    	JSONObject name = new JSONObject();
    	name.put("name", nval);
    	
    	JSONObject name2 = new JSONObject();
    	name2.put("name", nval2);

    	jsonarray.put(name);
    	jsonarray.put(name2);
    	
    	JSONObject obj = new JSONObject();
    	obj.put("names", jsonarray);
    	
    	System.out.println(obj.toString());
    	System.out.println(jsonarray.toString());
    
    	
    	
    	//return obj.toString();
    	return jsonarray.toString();
    }
    

    @Path("/getjsonobj")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getjsonobj(@Context HttpHeaders headers){
		String link = "http://172.16.221.176:88/EarnedLeave/getLeave/6571/2015-01-01/2015-01-31";
		Client client = ClientBuilder.newClient(new ClientConfig());
		
/*		XML transactions = client.target(link)
				.request(MediaType.APPLICATION_XML).get( XML.class);
*/	

		JSONArray transactions = client.target(link)
				.request(MediaType.APPLICATION_JSON).get( JSONArray.class);
		
		
		String slash = "\\";
		
		//transactions = transactions.replaceAll(slash, "");
		return transactions.toString();
    }

    

    
    
    
    
    // Raise an SMS event in esper
 	private String sendEvent(String  eventpayload) {
 		Client client = ClientBuilder.newClient(new ClientConfig());
 		String link = "http://localhost:8090/sendevent?";
 		WebTarget target = client.target(link).queryParam("stream","SMSEvents");
 		JSONObject payload = new JSONObject(eventpayload);
 		Iterator<?> json_keys = payload.keys();
 		while (json_keys.hasNext())
 		{	
 			String key = json_keys.next().toString();
 			try {
				target = target.queryParam(key,URLEncoder.encode(payload.getString(key), "UTF-8"));
 			} catch (UnsupportedEncodingException | JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 		}
		System.out.println(target.getUri().toString());
 		target.request().get();
 		return Response.ok().toString();
 	}

   }

//http://localhost:8080/SMSProcessor-0.1/spring/parserservice/getParsedSMS?smsData={"customerId": "1", "source" : "BOOKMYSHOW","message":"Please click on the below link to get your QR Code. Just scan and pickup your tickets from the Venue kiosk(s) - http://bmsurl.co/4piJ4vMr Hi Customer, Booking ID: FMMA0000252585. Seats: SL-C12,C11,C10, 3 seat(s) for The Martian (3D) (U/A) on Sun, 4 Oct, 2015 4:55pm at INOX: Inorbit Mall, Malad (W) (SCREEN 1). Please carry your CC/DC card which was used for booking tickets.Please use your Conf. No. 252585 and TPIN No./Kiosk Pick-up Code : 7614 to collect tickets at INOX: Inorbit Mall, Malad (W)"}http://localhost:8080/SMSProcessor-0.1/spring/parserservice/getParsedSMS?smsData={"customerId": "1", "source" : "BOOKMYSHOW","message":"Please click on the below link to get your QR Code. Just scan and pickup your tickets from the Venue kiosk(s) - http://bmsurl.co/4piJ4vMr Hi Customer, Booking ID: FMMA0000252585. Seats: SL-C12,C11,C10, 3 seat(s) for The Martian (3D) (U/A) on Sun, 4 Oct, 2015 4:55pm at INOX: Inorbit Mall, Malad (W) (SCREEN 1). Please carry your CC/DC card which was used for booking tickets.Please use your Conf. No. 252585 and TPIN No./Kiosk Pick-up Code : 7614 to collect tickets at INOX: Inorbit Mall, Malad (W)"}
//http://localhost:8080/SMSProcessor-0.1/spring/parserservice/getParsedSMS?smsData={"customerId": "1", "source" : "IRCTC","message":"Congrates!! Your ticket booked successfully. PNR is: 2345678901 Ticket No: :0672261674 Booking Status: Rakesh CONFIRM C1 76 WS Sarita CONFIRM C1 77 Ticket Amt: 900 SC: 20 Src: New delhi Dst: Chandigard Date of Journey: 14/04/2013 Sch Dep 07:40 hrs"}