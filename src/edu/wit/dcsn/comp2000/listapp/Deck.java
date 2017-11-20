package edu.wit.dcsn.comp2000.listapp;

import java.util.Collections;
import java.util.LinkedList;

/**
 * A class representing a deck of cards.
 * 
 * @author Leslie Vongphakdy
 *
 */
public class Deck extends Pile {

	private static LinkedList<Card> deck;
	private static Player[] player;
	private static Card card;
	private static LinkedList<Card> hand;
	
	/**
	 * Create a Deck
	 * @param x 
	 */
	public Deck() {
		deck = new LinkedList<>();
		for (Suit s : Suit.values())
			for (Rank v : Rank.values())
				deck.add(new Card(s, v));
		Collections.shuffle(deck);
	}

	/**
	 * deals a hand of 7 cards to players
	 * @param players
	 * @param handSize
	 * @return
	 */
	public int deal(Player[] players, int handSize ) {
	
		hand = new LinkedList<>();
		handSize = hand.size();
		for(int x = 0; x < hand.size(); x++) {
			deck.add(card);
		}
		return handSize;
	}

	/**
	 * Draws a card from the top of the deck
	 * @return the card at the top of the deck
	 */
	public static Card draw() {
		// TODO Implement
		if(deck.size() > 0) {
			return deck.poll();
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
		Player[] player = new Player[2];
		System.out.println("Creating new hand...");
		testDeck.deal(player, 7);
		System.out.println("Hand has: " + testDeck.deal(player, 7));
		System.out.println("Please take another card.");
		System.out.println("Card drawn is " + Deck.draw());
	}
}
