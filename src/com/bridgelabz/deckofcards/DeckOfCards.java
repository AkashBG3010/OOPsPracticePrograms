package com.bridgelabz.deckofcards;

import java.util.Random;

public  class DeckOfCards {
	
    String combinedArray[][] = new String[4][13];
    String [] ranks ={"2","3","4","5","6","7","8","9","10","King","Queen","Jack","Ace"};
    String [] suits ={"Clubs","Diamonds","Hearts","Spades"};
    String player[][] = new String[4][52];
    String[][] player1 = new String[4][52];

    public static void main(String[] args) {

        DeckOfCards ds = new DeckOfCards();
        String array[][] = ds.card();
        ds.shuffle(array);
        ds.playerWithCards(array);
        ds.cardShuffle(array);
        ds.printCards();
    }
    public String[][] card() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                combinedArray[i][j] = "["+suits[i] +" "+ ranks[j]+"]";
            }
        }
        return combinedArray;
    }

    public String[][] shuffle(String[][] combinedArray) {
        Random random = new Random();
        for (int j = combinedArray.length - 1; j > 0; j--) {
            for (int k = combinedArray[j].length - 1; k > 0; k--) {
                int m = random.nextInt(j + 1);
                int n = random.nextInt(k + 1);
                String temp = combinedArray[j][k];
                combinedArray[j][k] = combinedArray[m][n];
                combinedArray[m][n] = temp;
            }
        }
        return combinedArray;
    }

    public String[][] cardShuffle(String[][] combinedArray){
        for (int i = 0; i < suits.length ; i++) {
            for (int j = 0; j < ranks.length ; j++) {
                player1[i][j]=combinedArray[i][j];
            }
        }
        return player1;
    }

    public String[][] playerWithCards(String[][] player){
        for (int i = 0; i < suits.length ; i++) {
            for (int j = 0; j < ranks.length ; j++) {
                    player[i][j]= combinedArray[i][j];
                }
            }
        return player;
        }
    public void printCards() {
        for (int i = 0; i < suits.length; i++) {
            System.out.println("For player "+(i+1));
            for (int j = 0; j < ranks.length-4; j++) {
                System.out.println(player1[i][j]);
            }
            System.out.println();
        }
        System.out.println("Remaining cards are: ");
        for (int i = 0; i < suits.length; i++) {
            for (int j = 9; j < ranks.length; j++) {
                System.out.println(player1[i][j]);
            }

        }
    }
}