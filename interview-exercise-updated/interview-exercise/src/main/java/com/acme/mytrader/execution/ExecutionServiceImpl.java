package com.acme.mytrader.execution;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.acme.mytrader.strategy.Order;

public class ExecutionServiceImpl implements ExecutionService {

	Map<String, List<Order>> buyOrders = new HashMap<>();
	Map<String, List<Order>> sellOrders = new HashMap<>();

	@Override
	public void buy(String security, double price, int volume) {
		Order order = new Order();
		order.setPrice(price);
		order.setSecurity(security);
		order.setSize(volume);

		if (null != sellOrders.get(security)) {
			sellOrders.remove(security);
		} else {
			List<Order> orders = buyOrders.get(security);
			orders.add(order);
			buyOrders.put(security, orders);
		}

	}

	@Override
	public void sell(String security, double price, int volume) {
		Order order = new Order();
		order.setPrice(price);
		order.setSecurity(security);
		order.setSize(volume);

		if (null != buyOrders.get(security)) {
			buyOrders.remove(security);
		} else {
			List<Order> orders = sellOrders.get(security);
			orders.add(order);
			sellOrders.put(security, orders);
		}

	}

}
