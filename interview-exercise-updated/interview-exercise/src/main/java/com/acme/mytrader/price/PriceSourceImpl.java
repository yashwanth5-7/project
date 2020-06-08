package com.acme.mytrader.price;

import java.util.HashMap;
import java.util.Map;

import com.acme.mytrader.execution.ExecutionService;
import com.acme.mytrader.execution.ExecutionServiceImpl;

public class PriceSourceImpl implements PriceSource {

	private ExecutionService execution = new ExecutionServiceImpl();
	Map<String, Integer> stock = new HashMap<>();

	@Override
	public void addPriceListener(PriceListener listener) {
		if (listener.getClass().isAssignableFrom(PriceListenerImpl.class)) {
			PriceListenerImpl priceListenerImpl = (PriceListenerImpl) listener;
			if (stock.containsKey(priceListenerImpl.getSecurity())) {
				stock.put(priceListenerImpl.getSecurity(), stock.get(priceListenerImpl.getSecurity()) + 1);
			} else {
				stock.put(priceListenerImpl.getSecurity(), 1);
			}

			if (stock.get(priceListenerImpl.getSecurity()) >= 100) {
				execution.buy(priceListenerImpl.getSecurity(), priceListenerImpl.getPrice(), 100);
			}
		}
	}

	@Override
	public void removePriceListener(PriceListener listener) {
		if (listener.getClass().isAssignableFrom(PriceListenerImpl.class)) {
			PriceListenerImpl priceListenerImpl = (PriceListenerImpl) listener;
			if (stock.containsKey(priceListenerImpl.getSecurity())) {
				stock.put(priceListenerImpl.getSecurity(), stock.get(priceListenerImpl.getSecurity()) + 1);
			} else {
				stock.put(priceListenerImpl.getSecurity(), 1);
			}

			if (stock.get(priceListenerImpl.getSecurity()) >= 100) {
				execution.sell(priceListenerImpl.getSecurity(), priceListenerImpl.getPrice(), 100);
			}
		}
	}

}
