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
@Component("bookmyshow")
public class BookMyShowImpl implements ParseSMSTemplate{

	public static void main(String[] args) {
		String stext ="Please click on the below link to get your QR Code. Just scan and pickup your tickets from the Venue kiosk(s) - http://bmsurl.co/4piJ4vMr "+  
				  "Hi Customer, Booking ID: FMMA0000252585. Seats: SL-C12,C11,C10, 3 seat(s) for The Martian (3D) (U/A) on Sun, 4 Oct, 2015 4:55pm at INOX: Inorbit Mall, Malad (W) (SCREEN 1            ). Please carry your CC/DC card which was used for booking tickets.Please use your Conf. No. 252585 and TPIN No./Kiosk Pick-up Code : 7614 to collect tickets at INOX: Inorbit Mall, Malad (W)"; 
		
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

	private String getText(String msgText, String regex,int pos) {
		Pattern pattern = Pattern.compile(regex);
		Matcher m = pattern.matcher(msgText);
		String textfound[] = new String[pos+1];
		int i =0;
		
		while (m.find () && i <=pos)
	      {
	         textfound[i]= m.group();
	         i++;
	      }
		return textfound[pos];
	}
	@Override
	public String getSMSData(String msgData) {
		// sample msgData = {"customerId" : "1","source" :"BOOKMYSHOW" ,"msgText" : "The message sent by sms"}
		JSONObject input = new JSONObject(msgData);
		String message = input.getString("message");
		
		String url = getText(message, "(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]");
		String bookingId = getText(message,"(?<=Booking ID:)\\s*[A-Z0-9]*");
		String movieName = getText(message,"(?<=for )(\\s*[\\w])+",0);
		String movieType=getText(message,"(?<=\\()(\\s*[\\w\\/\\s]{2,})",1);
		String movieDt = getText(message,"(\\w{3}),\\s(\\d){1,2}\\s(\\w{3}),\\s\\d{4}\\s");
		String movieTime = getText(message,"\\d{1,2}:\\d{1,2}(am|pm)");
		String place[] = getText(message,"(?<=at\\s)(\\w*[\\s,()\\-:]*)*",1).split(",");;
		String theater = place[0];
		String location = place[1];
		
		JSONObject bookmyshow = new JSONObject();
		bookmyshow.put("customerId", input.getString("customerId"));
		bookmyshow.put("smsType", "BOOKMYSHOW");
		bookmyshow.put("url", url);
		bookmyshow.put("bookingId", bookingId);
		bookmyshow.put("movieName", movieName.trim());
		bookmyshow.put("movieType", movieType.trim());
		bookmyshow.put("movieDt", movieDt.trim());
		bookmyshow.put("movieTime", movieTime.trim());
		bookmyshow.put("theater", theater.trim());
		bookmyshow.put("location", location.trim());

		//System.out.println(bookmyshow.toString());
		/*
		(\w*)(?>,)
		Please click on the below link to get your QR Code. Just scan and pickup your tickets from the Venue kiosk(s) - http://bmsurl.co/4piJ4vMr 
		Hi Customer, Booking ID: FMMA0000252585. Seats: SL-C12,C11,C10, 3 seat(s) for The Martian (3D) (U/A) on Sun, 4 Oct, 2015 4:55pm at INOX: Inorbit Mall, Malad (W) (SCREEN 1            ). Please carry your CC/DC card which was used for booking tickets.Please use your Conf. No. 252585 and TPIN No./Kiosk Pick-up Code : 7614 to collect tickets at INOX: Inorbit Mall, Malad (W)
	
		bookingId : 
		seats
		seatcount
		movie :
		date
		time
		theater
		location
		screen
		*/

		// find url
		
		
		return bookmyshow.toString();
	}

}
