package com.bridgelabz.stocksmanagement;

import java.util.Scanner;
import java.util.LinkedList;

public class StockAccountManagement {
	static int noOfData;
	static String nameOfShare;
	static int noOfShares;
	static int priceOfShare;
	static LinkedList<Stocks> myLinkedList = new LinkedList<>();
	static int[] price = new int[10];

	public static void main(String[] args) {	
		getData();
		totalValueOfStocks();
	}
	public static void getData() {
		
		int noOfData1;
		int i=0;
		Scanner sc= new Scanner(System.in);
	
		System.out.println("Enter the number of stocks data to be entered:");
		noOfData = sc.nextInt();
		noOfData1=noOfData;
		for(int m = 0; noOfData1 > 0;m++) {
			System.out.println("Enter the name of Stock:");
			nameOfShare  = sc.next();
			
			System.out.println("Enter the price of each share:");
			priceOfShare  = sc.nextInt();
			
			System.out.println("Enter the total number of shares:");
			noOfShares  = sc.nextInt();
			
			Stocks stocks = new Stocks(nameOfShare,noOfShares,priceOfShare);
			myLinkedList.add(stocks);
		
			price[i++]=Stocks.priceOfShare*Stocks.noOfShares;
			noOfData1--;
		}
		System.out.println(myLinkedList);
		}
	
	public static void totalValueOfStocks() {
		int sumOfShares=0;
		for(int i = 0; i< noOfData;i++) {
			sumOfShares= sumOfShares + price[i];

		}
		System.out.println("Total Share Price: "+sumOfShares);
	}
}