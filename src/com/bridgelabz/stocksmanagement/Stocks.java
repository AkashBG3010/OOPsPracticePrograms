package com.bridgelabz.stocksmanagement;

public class Stocks {
	static String nameOfShare;
	static int noOfShares;
	static int priceOfShare;
	
	public Stocks(String shareName, int noOfShare, int sharePrice) {
		super();
		
		this.nameOfShare = nameOfShare;
		this.noOfShares = noOfShares;
		this.priceOfShare = priceOfShare;
	}
	@Override
	public String toString() {
		return "Stocks [nameOfShare=" +nameOfShare + ", noOfShares=" + noOfShares + ", priceOfShare=" + priceOfShare + "]";
	}
}