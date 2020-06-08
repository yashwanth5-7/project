package com.acme.mytrader.price;

public class PriceListenerImpl implements PriceListener {
	private String security;
	private double price;
	private PriceSource source = new PriceSourceImpl();

	@Override
	public void priceUpdate(String security, double price) {
		this.security = security;
		source.addPriceListener(this);

	}

	public String getSecurity() {
		return security;
	}

	public void setSecurity(String security) {
		this.security = security;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
