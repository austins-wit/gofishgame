package edu.wit.dcsn.comp2000.listapp;

import java.util.Collections;
import java.util.LinkedList;

/**
 * A class representing a card with a rank and suit.
 * 
 * @author Scott Austin
 *
 */
public class Card implements Comparable<Card> {
	
	public final Suit suit;
	public final Rank rank;
	
	/**
	 * Create a card
	 * @param suit the card's suit
	 * @param rank the card's rank
	 */
	public Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Card other) {
		int rankComparison = this.rank.compareTo(other.rank);
		if (rankComparison != 0) {
			return rankComparison;
		}
		return this.suit.compareTo(other.suit);
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Card other) {
		return this.rank.equals(other.rank) && this.suit.equals(other.suit);
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.suit.toString() + this.rank.toString();
	}
	
	/**
	 * Unit test driver for Card class
	 * @param args -unused-
	 */
	public static void main(String[] args) {
		LinkedList<Card> cards = new LinkedList<Card>();
		
		// Print all card rank/suit combinations
		System.out.printf("%-5s %-5s %-5s%n", "Card", "Suit", "Rank");
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				Card card = new Card(suit, rank);
				System.out.printf("%-5s %-5s %-5s%n", card.toString(), card.suit.toString(), card.rank.toString());
				cards.add(card);
			}
		}
		
		// Check that all the cards are distinct. equals method 
		// should return true only if it is comparing to itself,
		// i.e. they have the same index in the list.
		boolean areAllNotEqual = true;
		int firstIndex = 0;
		for (Card card : cards) {
			int secondIndex = 0;
			
			for (Card compareCard : cards) {
				
				if (card.equals(compareCard)) {
					if (firstIndex != secondIndex) {
						areAllNotEqual = false;
					}
				}
				else {
					if (firstIndex == secondIndex) {
						areAllNotEqual = false;
					}
				}
				++secondIndex;
			}
			++firstIndex;
		}
		System.out.println("\nAll cards are distinct: " + areAllNotEqual);
		
		// Sort the cards and print their sorted order
		System.out.println("\nSorted card list");
		Collections.sort(cards);
		int column = 0;
		for (Card card : cards) {
			System.out.printf("%-3s%s", 
					card.toString(), 
					(column = (column + 1) % 10) != 0 ? " " : "\n");
		}
	}
}
