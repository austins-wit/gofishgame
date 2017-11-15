/*
 * Deck 
 * Hand 
 */
package edu.wit.dcsn.comp2000.listapp;

import java.util.LinkedList;
import java.util.Collections;
import java.util.Iterator;

/**
 * A class representing a generic pile of cards. Contains utility methods such
 * as sorting, shuffling, and searching.
 * 
 * @author piercec5
 *
 */
public class Pile {
	
	private boolean initialized = false; // ill ask Scott
	/*
	 * Reason: 
	 * This is here because in order for a card game to start the game
	 * you need a deck cards.
	 */
	private LinkedList<Card> cards;

	/**
	 * Create a Pile of cards.
	 */
	public Pile() {
		// TODO Implement
		initialized = true;
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
		while(!cards.isEmpty()){
			discardCard = cards.remove();
			discardPile.addCard(discardCard);
		}
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
		return true;
	}

	/**
	 * Returns true if the pile has no cards.
	 * 
	 * @return true if the pile has no cards.
	 */
	public boolean isEmpty() {
		// TODO Implement
		if(cards.size() == 0){
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
		if(cards.contains(card)){
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
		while(searcher.hasNext()){
			Card searcedRank = searcher.next();
			if(rank.equals(searcedRank)){
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
		
		return null;
	}

	/**
	 * Unit test driver for Pile.
	 * 
	 * @param args
	 *            -unused-
	 */
	public static void main(String[] args) {
		// TODO Implement
	}
}
