package com.acme.mytrader.strategy;

import com.acme.mytrader.price.PriceListener;
import com.acme.mytrader.price.PriceListenerImpl;
import com.acme.mytrader.price.PriceSource;
import com.acme.mytrader.price.PriceSourceImpl;

/**
 * <pre>
 * User Story: As a trader I want to be able to monitor stock prices such
 * that when they breach a trigger level orders can be executed automatically
 * </pre>
 */
public class TradingStrategy {

	PriceListener listener = new PriceListenerImpl();
	
	PriceSource priceSource = new PriceSourceImpl();

	public void buyStock(String security, double price) {
		listener.priceUpdate(security, price);
	}
	
	public void existPriceWatch(String security, double price) {
		
		priceSource.removePriceListener(listener);
	}
	
	
	
	
	

}
