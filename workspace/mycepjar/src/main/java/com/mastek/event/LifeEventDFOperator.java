package com.mastek.event;

import com.espertech.esper.dataflow.annotations.OutputTypes;

import java.util.Iterator;

import com.espertech.esper.dataflow.annotations.DataFlowContext;
import com.espertech.esper.dataflow.annotations.DataFlowOperator;
import com.espertech.esper.dataflow.annotations.DataFlowOpParameter;
import com.espertech.esper.dataflow.annotations.OutputType;
import com.espertech.esper.dataflow.interfaces.DataFlowOpCloseContext;
import com.espertech.esper.dataflow.interfaces.DataFlowOpInitializateContext;
import com.espertech.esper.dataflow.interfaces.DataFlowOpInitializeResult;
import com.espertech.esper.dataflow.interfaces.DataFlowOpOpenContext;
import com.espertech.esper.dataflow.interfaces.DataFlowSourceOperator;
import com.espertech.esper.dataflow.interfaces.EPDataFlowEmitter;
import com.espertech.esper.dataflow.annotations.DataFlowOpProvideSignal;

import com.mastek.event.LifeEvent;
import com.mastek.event.Promotion;



@DataFlowOperator
@DataFlowOpProvideSignal
public class LifeEventDFOperator implements DataFlowSourceOperator {
	
	
	@DataFlowContext
	private EPDataFlowEmitter dfemitter;
	
	@DataFlowOpParameter
	private String myStringParameter;
	
	
	private final Iterator<LifeEvent> lifeevents ;
	
	
	public LifeEventDFOperator(Iterator<LifeEvent> lifeevents) {
		super();
		this.lifeevents = lifeevents;
	}
	public LifeEventDFOperator() {
		this.lifeevents = null;
 	}



	@Override
	public void close(DataFlowOpCloseContext arg0) {
		// TODO Auto-generated method stub

	}

	
	@Override
	public DataFlowOpInitializeResult initialize(DataFlowOpInitializateContext arg0) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void open(DataFlowOpOpenContext arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void next() throws InterruptedException {
		if (lifeevents.hasNext()){
			LifeEvent le =  lifeevents.next();
			dfemitter.submit(getPromotion(le));
		}
	}

	private Promotion getPromotion(LifeEvent le) {
		// TODO Auto-generated method stub
		Promotion promotion = new Promotion();
		if (le.getLifeEventType().equals("Marriage"))
		{
			promotion.setCustomerId(le.getCustomerId());
			promotion.setLocation(le.getLocation());
			promotion.setPromotionActivity("purchase");
			promotion.setPromotionOutletName("Sywamwar");
			promotion.setPromotionOutletType("SHOP");
			promotion.setPromotionType("discount");
			promotion.setPromotionURL("www.google.com");
			promotion.setReference("10-percent");
		}
		
		if (le.getLifeEventType().equals("Birthday"))
		{
			promotion.setCustomerId(le.getCustomerId());
			promotion.setLocation(le.getLocation());
			promotion.setPromotionActivity("dinner");
			promotion.setPromotionOutletName("Olive");
			promotion.setPromotionOutletType("RESTUARANT");
			promotion.setPromotionType("coupons");
			promotion.setPromotionURL("www.google.com");
			promotion.setReference("500 off");
		}
		return promotion;
	}

}

