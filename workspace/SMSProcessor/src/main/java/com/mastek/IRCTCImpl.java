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



import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONObject;
import org.springframework.stereotype.Component;
import com.mastek.ParseSMSTemplate;

/**
 * serviceimplementation to get source events
 * 
 * @author vinaya
 */
@Component("irctc")
public class IRCTCImpl implements ParseSMSTemplate{

	public static void main(String[] args) {
		String stext ="Ticket booked successfully. PNR: 8502618225 Ticket No: 0728109603 Booking Status: Rakesh CONFIRM D2 0084 WS Class: 2S Ticket Amt: 85.0 SC: 22.80 Src Stn: KALYAN JN Dst: PUNE JN DOJ: 30/08/2013 Shd Dep: 06:37" ;
		//String stext2 ="Congrates!! Your ticket booked successfully. PNR is: 2345678901 Ticket No: :0672261674 Booking Status: Rakesh CONFIRM C1 76 WS Sarita CONFIRM C1 77 Ticket Amt: 900 SC: 20 Src: New delhi Dst: Chandigarh Date of Journey: 14/04/2013 Sch Dep 07:40 hrs"; 

				
		String quote = "\"";		
		String msgData =String
				.format("{%scustomerId%s:%s%s%s, %smsgText%s:%s%s%s}",
						quote,quote,quote,"3",quote,quote,quote,quote,stext,quote); 
				
		System.out.println(msgData);
		
	}
	
	private String getText(String msgText, String regex) {
		Pattern pattern = Pattern.compile(regex);
		Matcher m = pattern.matcher(msgText);
		String textfound="";
		while (m.find ())
	      {
	         textfound= m.group();
	      }
		return textfound;
	}

	@Override
	public String getSMSData(String msgData) {
		// sample msgData = {"customerId" : "1","source" :"BOOKMYSHOW" ,"msgText" : "The message sent by sms"}
		JSONObject input = new JSONObject(msgData);
		String message = input.getString("message");
		
		String pnr = getText(message, "(?<=PNR is:)(\\s[\\d]*)*").trim();
		String ticketno = getText(message,"(?<=Ticket No: :)([\\d]*)*").trim();
		String booking[] = getText(message,"(?<=Booking Status:\\s)([\\w\\s]*)+").split("Ticket Amt");
		String bookingdetails = booking[0].trim();
		
		String ticketAmt = getText(message,"(?<=Ticket Amt:\\s)([\\d]*)+").trim();
		String src[] = getText(message,"(?<=Src:\\s)(\\w+\\s)+\\bDst").split("Dst");
		String source = src[0].trim();
		String dest[] = getText(message,"(?<=Dst:\\s)(\\w+\\s)*\\bDate").split("Date"); // split at date
		String destination =dest[0].trim();
		
		String journeyDt = getText(message,"(?<=Journey:\\s)((\\d{1,2})\\/(\\d{1,2})\\/(\\d{4}))").trim();
		String depatureTime = getText(message,"(?<=Dep\\s)((\\d{1,2}):(\\d{1,2}))").trim();
		
		JSONObject irctc = new JSONObject();
		irctc.put("customerId", input.getString("customerId"));
		irctc.put("smsType", "IRCTC");
		irctc.put("pnr", pnr);
		irctc.put("ticketNo", ticketno);
		irctc.put("bookingDetails",bookingdetails);
		irctc.put("ticketAmt", ticketAmt);
		irctc.put("source", source);
		irctc.put("destination", destination);
		irctc.put("journeyDt", journeyDt);
		irctc.put("depatureTime", depatureTime);
		System.out.println(irctc.toString());
		/*
		Congrates!! Your ticket booked successfully. PNR is: 2345678901 Ticket No: :0672261674 Booking Status: Rakesh CONFIRM C1 76 WS Sarita CONFIRM C1 77 Ticket Amt: 900 SC: 20 Src: New delhi Dst: Chandigard Date of Journey: 14/04/2013 Sch Dep 07:40 hrs	
		*/
		return irctc.toString();
	}

}
