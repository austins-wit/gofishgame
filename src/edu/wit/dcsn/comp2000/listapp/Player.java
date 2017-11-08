package edu.wit.dcsn.comp2000.listapp;

import java.util.LinkedList;

import javafx.util.Pair;

/**
 * A class representing a player in a game of Go Fish
 * 
 * @author NO AUTHOR
 *
 */
public class Player {

	private String name;
	private Hand hand;
	private int score;
	private LinkedList< Pair<Card,Card> > pairs;
	
	/** 
	 * Create a player
	 * @param name the name of the player
	 */
	public Player(String name) {
		// TODO Implement
	}
	
	/**
	 * Finds all the pairs in the players hand.
	 * For each pair found, adds it to the player's list of pairs
	 * and increase the player's score by 1.
	 */
	public void findPairs() {
		// TODO Implement
	}
	
	/**
	 * Ask the other player for a card with a specified rank.
	 * If the other player has the card, the card is removed from
	 * the other player's hand and is added to this player's hand.
	 * @param other the player being asked for a card
	 * @param rank the rank of card that is being asked for
	 * @return true if the other player had the card
	 *         false if the other player did not have the card
	 */
	public boolean requestCardFromPlayer(Player other, Rank rank) {
		// TODO Implement
		return false;
	}
	
	/**
	 * Searches the hand for a card with a specified rank.
	 * @param rank the rank to search for
	 * @return the first instance of Card in the hand with rank.
	 *         returns null if no such card exists.
	 */
	public Card giveCardWithRank(Rank rank) {
		// TODO Implement
		return null;
	}
	
	/**
	 * The player will draw a card from the deck and adds it their hand.
	 * @param deck the player draws from this deck
	 */
	public void goFish(Deck deck) {
		// TODO Implement
	}
	
	/**
	 * Unit test for Player
	 * @param args -unused-
	 */
	public static void main(String[] args) {
		// TODO Implement
	}
}
