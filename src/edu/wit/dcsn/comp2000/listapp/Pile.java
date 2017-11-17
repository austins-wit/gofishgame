/*
 * Deck 
 * Hand 
 */
package edu.wit.dcsn.comp2000.listapp;

import java.util.LinkedList;

import javax.swing.plaf.synth.SynthSeparatorUI;

import java.util.Collections;
import java.util.Iterator;

/**
 * A class representing a generic pile of cards. Contains utility methods such
 * as sorting, shuffling, and searching.
 * 
 * @author Corey Pierce
 *
 */
public class Pile {

	private LinkedList<Card> cards;

	/**
	 * Create a Pile of cards.
	 */
	public Pile() {
		// TODO Implement
		cards = new LinkedList<>();
	}

	/**
	 * Add a card to the Pile.
	 * 
	 * @param card
	 *            the card to add
	 */
	public void addCard(Card card) {
		// TODO Implement
		cards.add(card);
	}

	/**
	 * Remove all cards in this pile and adds them into the discard pile.
	 * 
	 * @param discardPile
	 *            the pile to receive all this pile's discarded cards. if this
	 *            is null, this pile's cards are only removed.
	 */
	public void discardAll(Pile discardPile) {
		// TODO Implement
		Card discardCard;
		while (!cards.isEmpty()) {
			discardCard = cards.remove();
			discardPile.addCard(discardCard);
		}
	}
	
	public Card getCardAtIndex(int index) {
		// TODO Implement
		return cards.get(index);
	}
	
	/**
	 * Returns the size of the pile.
	 * 
	 * @return the size of the pile.
	 */
	public int getSize() {
		// TODO Implement
		int sizeOfDeck = cards.size();
		return sizeOfDeck;
	}

	/**
	 * Remove a card from the Pile
	 * 
	 * @param index
	 *            the indexed location of the card to remove.
	 * @return the card removed at the index
	 */
	public Card removeCard(int index) {
		// TODO Implement
		return cards.remove(index);
	}

	/**
	 * Remove a card from the Pile
	 * 
	 * @param card
	 *            the card to remove from the Pile
	 * @return true if the card was removed false if the card could not be
	 *         removed, i.e. it is not in the Pile
	 */
	public boolean removeCard(Card card) {
		// TODO Implement
		if (cards.size() == 0) {
			return false;
		}
		cards.remove(card);
		return true;
	}

	/**
	 * Returns true if the pile has no cards.
	 * 
	 * @return true if the pile has no cards.
	 */
	public boolean isEmpty() {
		// TODO Implement
		if (cards.size() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Randomly shuffles the cards in the pile.
	 */
	public void shuffle() {
		Collections.shuffle(cards);
	}

	/**
	 * Find the index of the specified card in the Pile.
	 * 
	 * @param card
	 *            the card to search for
	 * @return the index of the specified card. returns -1 if the card cannot be
	 *         found.
	 */
	public int search(Card card) {
		// TODO Implement
		if (cards.contains(card)) {
			return cards.indexOf(card);
		}
		return -1;
	}

	/**
	 * Find the index of the first card with rank in the Pile.
	 * 
	 * @param rank
	 *            the rank to search for
	 * @return the index of the specified card. returns -1 if the card cannot be
	 *         found.
	 */
	public int search(Rank rank) {
		Iterator<Card> searcher = cards.iterator();
		while (searcher.hasNext()) {
			Card searcedRank = searcher.next();
			if (rank.equals(searcedRank)) {
				return cards.indexOf(searcedRank);
			}
		}
		return -1;
	}

	/**
	 * Sorts the cards in the Pile.
	 */
	public void sort() {
		// TODO Implement
		Collections.sort(cards);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Implement
		String deck = "";
		for (Card card : cards) {
			deck += card.toString() + " ";
		}
		return "{ " + deck + " }";
	}

	/**
	 * Unit test driver for Pile.
	 * 
	 * @param args
	 *            -unused-
	 */
	//Got rid of something to allow me to commit this project
	public static void main(String[] args) {
		Pile testDeck = new Pile();
		System.out.println("Is deck empty? " + testDeck.isEmpty());
		Card spades = new Card(Suit.SPADES, Rank.KING);
		Card hearts = new Card(Suit.HEARTS, Rank.QUEEN);
		Card clubs = new Card(Suit.CLUBS, Rank.ACE);
		Card diamonds = new Card(Suit.DIAMONDS, Rank.JACK);
		testDeck.addCard(spades);
		testDeck.addCard(hearts);
		testDeck.addCard(clubs);
		testDeck.addCard(diamonds);
		System.out.println("Is deck empty? " + testDeck.isEmpty());
		System.out.println("Size of deck: " + testDeck.getSize() + " cards");
		System.out.println("Test Deck: " + testDeck.toString());
		testDeck.shuffle();
		System.out.println("Shuffled Deck: " + testDeck.toString());
		testDeck.sort();
		System.out.println("Sorted Deck: " + testDeck.toString());
		System.out.println("Removing a card from index 2...");
		testDeck.removeCard(2);
		System.out.println("Cards after index removal: " + testDeck.getSize() + " cards");
		System.out.println("Removing a card the King card...");
		testDeck.removeCard(spades);
		System.out.println("Cards remaining: " + testDeck.getSize() + " cards");
		System.out.println(testDeck.toString());
		System.out.println("Index of Ace: " + testDeck.search(clubs));
		System.out.println("Index of Queen: " + testDeck.search(Rank.QUEEN));
		System.out.println("Discarding cards...");
		Pile discardPile = new Pile();
		testDeck.discardAll(discardPile);
		System.out.println("Number of Cards in main pile: " + testDeck.getSize() + " cards");
		System.out.println("Number of Cards in discard pile: " + discardPile.getSize() + " cards");
	}
}
