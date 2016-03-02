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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;


@Path("promotionservice")
@Component
public class PromotionService {
   
	HttpRequest request;
	
	@Autowired
	CustomerProfileService customerProfileService;
	

	@Path("/getPromotions")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
	public Response getPromotions(@Context UriInfo info){
		JSONObject jobj = new JSONObject();
		for (Map.Entry<String,List<String>> e : info.getQueryParameters().entrySet() ) {
	        jobj.put(e.getKey(), e.getValue().get(0));
	    } 

		System.out.println( jobj.toString() );
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date startdt=null;
		Date todt=null;
		try {
			if (jobj.has("startdt"))
				if (!jobj.getString("startdt").isEmpty())
					startdt = simpleDateFormat.parse(jobj.getString("startdt"));
			if (jobj.has("todt"))
				if (!jobj.getString("startdt").isEmpty())
					todt = simpleDateFormat.parse(jobj.getString("todt"));
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String customerdemo = customerProfileService.getCustDemographic(jobj.toString());
		String customerPref = customerProfileService.getCustomerPreference(jobj.getString("customerId"));

		System.out.println(startdt);
		System.out.println(todt);
		System.out.println(customerdemo);
		System.out.println(customerPref);
		//System.out.println(custDetails.toString());
		return Response.status(201).build();
    
    }

   }

//http://localhost:9090/PromotionProcessor-0.1/spring/promotionservice/getPromotions?promotionData=value1&field1=somefieldvalue1&field2=somefieldvalue2
//http://localhost:9090/PromotionProcessor-0.1/spring/promotionservice/getPromotions?customerId=1