package com.bridgelabz.deckofcards;

public class DeckMain {
	public static void main(String[] args) {
		
        String player[][]= new String[4][13];
        Cards card = new Cards();
        card.displayDeck();
        card.shuffleCards(player);
        card.display(player);
    }
}