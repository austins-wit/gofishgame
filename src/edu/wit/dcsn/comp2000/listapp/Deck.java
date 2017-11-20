package edu.wit.dcsn.comp2000.listapp;

import java.util.ArrayList;
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
	private static ArrayList<Card> hand;
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
	 * @param hand 
	 * @return 
	 * @return
	 */
	public ArrayList<Card> deal(Player players, int handSize) {

		hand = new ArrayList<>();
		for (Suit s : Suit.values())
			for (Rank v : Rank.values()) 
			{
				if(hand.size() < 7){
					deck.size();
					Collections.shuffle(hand);
					hand.add(new Card(s,v));
				}
			}
		return hand;

	}

	/**
	 * Draws a card from the top of the deck
	 * @return the card at the top of the deck
	 */
	public static Card draw() {
		// TODO Implement
		if(deck.size() > 0) {
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
		System.out.println("Dealing new hand...");
		Player players = new Player("Jim");
		testDeck.deal(players, 7);
		System.out.println("Hand has: " + testDeck.deal(players, 7));
		System.out.println("Please take another card.");
		System.out.println("Card drawn is " + Deck.draw());
	}
}
