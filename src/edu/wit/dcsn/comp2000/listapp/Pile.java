package edu.wit.dcsn.comp2000.listapp;

import java.util.LinkedList;

/**
 * A class representing a generic pile of cards. Contains utility
 * methods such as sorting, shuffling, and searching.
 * 
 * @author NO AUTHOR
 *
 */
public class Pile {
	private LinkedList<Card> cards;
	
	/**
	 * Create a Pile of cards.
	 */
	public Pile() {
		// TODO Implement
	}
	
	/**
	 * Add a card to the Pile.
	 * @param card the card to add
	 */
	public void addCard(Card card) {
		// TODO Implement
	}
	
	/**
	 * Remove all cards in this pile and adds them into the discard pile.
	 * @param discardPile the pile to receive all this pile's discarded cards.
	 *                    if this is null, this pile's cards are only removed.
	 */
	public void discardAll(Pile discardPile) {
		// TODO Implement
	}
	
	/**
	 * Returns the size of the pile.
	 * @return the size of the pile.
	 */
	public int getSize() {
		// TODO Implement
		return 0;
	}
	/**
	 * Remove a card from the Pile
	 * @param index the indexed location of the card to remove.
	 * @return the card removed at the index
	 */
	public Card removeCard(int index) {
		// TODO Implement
		return null;
	}
	
	/**
	 * Remove a card from the Pile
	 * @param card the card to remove from the Pile
	 * @return true if the card was removed
	 *         false if the card could not be removed, i.e. it is not in the Pile
	 */
	public boolean removeCard(Card card) {
		// TODO Implement
		return false;
	}
	
	/**
	 * Group the cards in the pile by their rank.
	 */
	public void groupByRank() {
		// TODO Implement
	}
	
	/**
	 * Group the cards in the pile by their suit.
	 */
	public void groupBySuit() {
		// TODO Implement
	}
	
	/**
	 * Returns true if the pile has no cards.
	 * @return true if the pile has no cards.
	 */
	public boolean isEmpty() {
		// TODO Implement
		return false;
	}
	
	/**
	 * Randomly shuffles the cards in the pile.
	 */
	public void shuffle() {
		// TODO Implement
	}
	
	/**
	 * Find the index of the specified card in the Pile.
	 * @param card the card to search for
	 * @return the index of the specified card.
	 *         returns -1 if the card cannot be found.
	 */
	public int search(Card card) {
		// TODO Implement
		return -1;
	}
	
	/**
	 * Find the index of the first card with rank in the Pile.
	 * @param rank the rank to search for
	 * @return the index of the specified card.
	 *         returns -1 if the card cannot be found.
	 */
	public int search(Rank rank) {
		// TODO Implement
		return -1;
	}
	
	/**
	 * Find the index of the first card with suit in the Pile.
	 * @param suit the suit to search for
	 * @return the index of the specified card.
	 *         returns -1 if the card cannot be found.
	 */
	public int search(Suit suit) {
		// TODO Implement
		return -1;
	}
	
	/**
	 * Sorts the cards in the Pile.
	 */
	public void sort() {
		// TODO Implement
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Implement
		return null;
	}
	
	/**
	 * Unit test driver for Pile.
	 * @param args -unused-
	 */
	public static void main(String[] args) {
		// TODO Implement
	}
}
