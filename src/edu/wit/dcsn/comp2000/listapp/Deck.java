package edu.wit.dcsn.comp2000.listapp;

import java.util.LinkedList;

/**
 * A class representing a deck of cards.
 * 
 * @author Leslie Vongphakdy
 *
 */
public class Deck extends Pile {

	private static LinkedList<Card> deck;
	private static int deckSize = 52;
	int x;
	/**
	 * Create a Deck
	 * @param x 
	 */
	public Deck() {
		Pile deck = new Pile();
		for (x = 0; x < deckSize; x++) {
			deck.addCard(draw());
		}
	}


	/**
	 * deals a hand of 7 cards to players
	 * @param players
	 * @param handSize
	 * @return
	 */
	public int deal(Player players, int handSize ) {
		handSize = 7;
		Hand hand = new Hand();
		for(int x = 0; x < handSize; x++) {
			hand.addCard(draw());
		}
		return 0;
	}

	/**
	 * Draws a card from the top of the deck
	 * @return the card at the top of the deck
	 */
	public static Card draw() {
		// TODO Implement
		if(deckSize > 0) {
			return deck.remove(0);
		} 
		else
		{
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * @see edu.wit.dcsn.comp2000.listapp.Pile#toString()
	 */
	@Override
	public String toString() {
		// TODO Implement
		return deck.toString();
	}
	
	/**
	 * Unit test driver for Deck.
	 * @param args -unused-
	 */
	public static void main(String[] args) {
		// TODO Implement
		Deck testDeck = new Deck();
		System.out.println("Adding cards to new deck...");
		System.out.println("Deck has: " + testDeck.toString());
		Player[] players = new Player[2];
		System.out.println("Creating new hand...");
		System.out.println("Hand has: " + testDeck.deal(players[2], deckSize));
		System.out.println("Please take another card.");
		System.out.println("Card drawn is " + Deck.draw());
	}
}
