package com.bridgelabz.moneywithdraw;

import java.util.Scanner;

public class AccountMain {
    static LinkedList<Stock> myLinkedList = new LinkedList<Stock>();
    Scanner sc = new Scanner(System.in);

    public void printReport(){
        if(myLinkedList.size()==0){
            System.out.println("Currently person have no share");
        }else {
            System.out.println("Portfolio of person");
            for (int j = 0; j < myLinkedList.size(); j++) {
                System.out.println(myLinkedList.get(j));
            }
        }
        particularStock();
        totalValueOfStock();
    }
    public int accountBalance(int balance){
        System.out.println("Current balance is:"+balance);
        StockPortfolio.value=balance;
        return balance;

    }
    public void sellStock(int bal){
        if(myLinkedList.size()<=0){
            System.err.println("Person have no portfolio");
        }
        else {
            int currentBalance =bal;
            printReport();
            System.out.println("Which stock you want to sell");
            int indexOfStock = sc.nextInt();
            myLinkedList.remove(indexOfStock);
            Stock stock =myLinkedList.get(indexOfStock);
            System.out.println(stock.getShareName()+" sold successfully");
            int credit = stock.getNoOfShare() *stock.getSharePrice();
            currentBalance = currentBalance + credit ;
            accountBalance(currentBalance);
            Date date = java.util.Calendar.getInstance().getTime();
            System.out.println("Date of Transaction: "+date);
        }

    }
    public void buyStock(int bal) {
        int flag = 0;
        String a[] = {"HDFC", "ICICI", "TCS", "SBI", "INFOSYS"};
        int currentBalance = bal;
        System.out.println("Which stock you want to buy");
        String shareName = sc.next();
        for (int i = 0; i < a.length; i++) {
            if (shareName.equals(a[i])) {
                System.out.println("how many share you want to buy");
                int noOfShare = sc.nextInt();
                System.out.println("price of each share");
                int sharePrice = sc.nextInt();
                Stock stock = new Stock(shareName, noOfShare, sharePrice);
                int debit = stock.getNoOfShare() * stock.getSharePrice();
                flag = 2;
                if (debit < currentBalance) {
                    myLinkedList.add(stock);
                    currentBalance = currentBalance - debit;
                    accountBalance(currentBalance);
                    Date date = Calendar.getInstance().getTime();
                    System.out.println("Date of Transaction: " + date);
                    flag = 1;
                }
            }
        }
            if (flag == 0) {
                System.out.println("Share is not available");
            } else if (flag == 2) {
                System.out.println("Account balance less than debit amt requested");
            } else {
                System.out.println("Share Added");
            }

    }}