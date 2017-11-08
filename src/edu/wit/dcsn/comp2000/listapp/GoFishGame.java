package edu.wit.dcsn.comp2000.listapp;

import java.util.LinkedList;

/**
 * A class to simulate a game of Go Fish.
 * 
 * @author NO AUTHOR
 *
 */
public class GoFishGame {

	private Deck deck;
	private LinkedList<Player> players;
	private boolean isGameWon;
	
	/**
	 * Create a GoFishGame
	 */
	public GoFishGame() {
		// TODO Implement
	}
	
	/**
	 * Initialize the game state based on prompted parameters.
	 * The game prompts the user for the number of players, how many
	 * of those players are CPU players, and the names of the players. 
	 */
	public void initialize() {
		// TODO Implement
	}
	
	/**
	 * Begins the playing of the game. Game play loops such that each player
	 * takes their turns one at a time. On their turn, a player is prompted to 
	 * identify a player and a rank, and they request a card of that rank 
	 * from that player. If the other player has that card in their hand, 
	 * they give it to the player and their turn continues. Otherwise, they
	 * are told to go fish: they draw a card from the deck, and their turn is
	 * over. Whenever a player has a pair (two cards with the same rank), they
	 * take the pair out of their hand and place it on the table, and they get
	 * a point. Play continues until a player hand is empty or the deck is empty.
	 * The player with the most points wins the game. 
	 */
	public void play() {
		// TODO Implement
	}
	
	/**
	 * Application starting point. Initializes the game class and tells the game
	 * to play.
	 * @param args -unused-
	 */
	public static void main(String[] args) {
		// TODO Implement
	}
}
