package com.mastek;

import java.io.IOException;

import com.mastek.MyDataOperator;
import com.mastek.event.BookMyShow;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.dataflow.EPDataFlowInstance;
import com.espertech.esper.client.deploy.EngineInitializer;

/**
 * Esper Quick Start Demo Class with HTTP Input/Output Adapter.
 * <p/>
 * <p/>See http://esper.codehaus.org/tutorials/tutorial/quickstart.html
 * <p/>See http://esper.codehaus.org/esperio-4.3.0/doc/reference/en/html/adapter_http.html
 * <p/>HTTP Request URI Sample: http://localhost:8079/sendevent?stream=MyFirewallEvent&name=Joe&changed=true
 *
 * @author <a href=mailto:iamtedwon@gmail.com">Ted Won</a>
 * @version 1.0
 */
public class InitializeCBank {

 public final static Log log = LogFactory.getLog(InitializeCBank.class);

	@EngineInitializer
	public static void initEngine(String engineName) {
/*	   EPServiceProvider engine = EPServiceProviderManager.getProvider("MyBankEngine");
	   engine.getEPAdministrator().getConfiguration().addImport(MyDataOperator.class);
	   engine.getEPAdministrator().getConfiguration().addImport("com.mastek.event.*");
	   engine.getEPAdministrator().getConfiguration().addEventType("BookMyShow",BookMyShow.class);
	   engine.getEPAdministrator().createEPL("select * from BookMyShow");
	   engine.getEPAdministrator().createEPL("create dataflow ChoosePromotion BeaconSource -> BookMyShowStream<BookMyShow>{}  MyDataOperator(BookMyShowStream) -> Promotion{} LogSink(Promotion) {}");
	   EPDataFlowInstance dfinstance =  engine.getEPRuntime().getDataFlowRuntime().instantiate("ChoosePromotion");
*/	   //dfinstance.start();
	   
	}
	
}