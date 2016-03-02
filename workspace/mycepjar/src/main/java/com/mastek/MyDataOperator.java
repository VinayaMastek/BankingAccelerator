package com.mastek;

import com.espertech.esper.dataflow.annotations.DataFlowContext;
import com.espertech.esper.dataflow.annotations.DataFlowOperator;
import com.espertech.esper.dataflow.annotations.OutputType;
import com.espertech.esper.dataflow.annotations.OutputTypes;
import com.espertech.esper.dataflow.interfaces.EPDataFlowEmitter;
import com.mastek.event.BookMyShow;
import com.mastek.event.Promotion;

// Annotate with DataFlowOperator so the engine knows its a data flow operator
@DataFlowOperator
@OutputTypes({ @OutputType(name = "Promotion", type = Promotion.class) })

public class MyDataOperator {
	@DataFlowContext
	private EPDataFlowEmitter dataFlowEmitter;
	private final Promotion p = new Promotion();
	
	
	public MyDataOperator() {
		// TODO Auto-generated constructor stub
	}
	
	
	public MyDataOperator(EPDataFlowEmitter dataFlowEmitter) {
		super();
		this.dataFlowEmitter = dataFlowEmitter;
	}


	// Name the method that receives data onInput(...)
	public void onInput(BookMyShow bookmyshow) {
		
		if (bookmyshow.getLocation().contains("Malad")) {
			p.setVendor("Sigree");
			p.setPromotionType("Discount");
			p.setPercent("10");
		}

		if (bookmyshow.getLocation().contains("Delhi")) {
			p.setVendor("Narulas");
			p.setPromotionType("Discount");
			p.setPercent("5");
		} else {
			p.setVendor(bookmyshow.getLocation());
			p.setPromotionType(bookmyshow.getMovieName());
			p.setPercent("5");
		}
		
		dataFlowEmitter.submit(new Object[] {p.getVendor(),p.getPromotionType(),p.getPercent()});
	}
	
	
}