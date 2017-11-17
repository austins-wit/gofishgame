package edu.wit.dcsn.comp2000.listapp;

import java.util.LinkedList;

import javafx.util.Pair;

/**
 * A class representing a player in a game of Go Fish
 * 
 * @cucuzzaj Joe Cucuzza
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
		
		this.name  = name;
		this.hand = new Hand();
		this.score = 0;
		this.pairs = new LinkedList< Pair<Card,Card> > ();
		
	}// end Player
	
	/**
	 * Finds all the pairs in the players hand.
	 * For each pair found, adds it to the player's list of pairs
	 * and increase the player's score by 1.
	 */
	public void findPairs() {
		// TODO Implement
		
		Pair<Card,Card> pair = this.hand.findPair();
		
		while(pair != null){
			
			this.pairs.add(pair);
			this.score++;
			
			pair = this.hand.findPair();
		
		}// end while
		
	}// end findPairs
	
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
		
		int cardIndex = other.hand.search(rank);
		
		if(cardIndex == -1){ // the other player doesn't have any cards with the specified rank
			
			return false;
			
		}// end if
		
		else{
			
			Card c = other.hand.removeCard(cardIndex); // remove the found card from the other player's hand
		
			this.hand.addCard(c); // add the card to the player's hand
			
			return true;
			
		}// end else
		
	}// end requestCardFromPlayer
	
	/**
	 * Searches the hand for a card with a specified rank.
	 * @param rank the rank to search for
	 * @return the first instance of Card in the hand with rank.
	 *         returns null if no such card exists.
	 */
	public Card giveCardWithRank(Rank rank) {
		// TODO Implement
		
		int cardIndex = this.hand.search(rank);
		
		if(cardIndex == -1){ //card with specified rank was not found in the hand
		
			return null;
		
		}// end if
		
		else{ 
			
			return this.hand.getCardAtIndex(cardIndex);
			
		}// end else
		
	}// end giveCardWithRank
	
	/**
	 * The player will draw a card from the deck and adds it their hand.
	 * @param deck the player draws from this deck
	 */
	public void goFish(Deck deck) {
		// TODO Implement
		
		this.hand.addCard(deck.draw());
		
	}// end goFish
	
	
	/**
	 * Returns a player's hand
	 * @return hand a player's hand
	 */
	public Hand getHand(){
		
		return hand;
		
	}// end getHand
	
	
	/**
	 * Returns a player's pairs
	 * @return pairs a player's list of pairs
	 */
	public LinkedList< Pair<Card,Card> > getPairs(){
		
		return pairs;
		
	}// end getPairs
	
	/**
	 * Resets a player's score, hand, and pairs
	 * @param player
	 */
	public void resetPlayer(){
		
		this.score = 0; //reset score
		
		//reset player's hand
		int i = 0;
		while(this.hand.getSize() != 0){
			
			this.hand.removeCard(i);
			i++;
		
		}// end while
		
		
		this.pairs.clear(); //reset pairs list
		
		
	}// end resetPlayer
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		
		return this.name; 
		
	}// end toString
	
	/**
	 * Unit test for Player
	 * @param args -unused-
	 */
	public static void main(String[] args) {
		// TODO Implement
		
		Deck deck = new Deck();
		
		Card card = new Card(Suit.DIAMONDS, Rank.FIVE);
		
		String[] names = {"Bob", "Jim"};
		
		int[] plyrHandSize = new int[2];
		
		Player[] players = new Player[2];
		
		for(int i = 0; i < players.length; i++){
			
			//testing Player constructor and toString
			System.out.println("Creating player" + i + "...");
			players[i] = new Player(names[i]);
			System.out.println("Player" + i + ">>> Name: " + players[i].toString() + " Score: " + players[i].score);
			System.out.println("Player" + i + "'s hand: " + players[i].hand.toString());
			
			//testing getHand
			System.out.println("Testing getHand for Player" + i + ": " + players[i].getHand());
			
			//testing giveCardWithRank
			System.out.println("Does Player" + i + " have a card with rank 5?"); //card with rank 5 may have 
			//been dealt to the player.
			
			Card c = players[i].giveCardWithRank(Rank.FIVE);
			
			if(c == null){
				
				System.out.println("Player" + i + " doesn't have a 5.");
				
			}
			
			else{
				
				System.out.println("Player" + i + " has a 5.");
				
			}
			
			players[i].hand.addCard(card); //card with rank 5 is now definitely in the players hand, 
			//giveCardWithRank should return the card.
			
			System.out.println("Does Player" + i + " have a card with rank 5?");
			c = players[i].giveCardWithRank(Rank.FIVE);
			
			if(c == null){
				
				System.out.println("Player" + i + " doesn't have a 5.");
				
			}
			
			else{
				
				System.out.println("Player" + i + " has a 5.");
				
			}
			
			//testing findPairs
			System.out.println("Finding pairs in player" + i + "'s hand...");
			plyrHandSize[i] = players[i].hand.getSize();
			players[i].findPairs();
		
			if(plyrHandSize[i]== players[i].hand.getSize()){
			
				if(players[i].score == 0){
			
					System.out.println("No pairs found!");
					System.out.println("Player" + i + "'s hand: " + players[i].hand.toString());
			
				}
			
				else {
				
					System.out.println("Error! No pairs found but, score is non-zero.");
					System.out.println("Player" + i + "'s hand: " + players[i].hand.toString());
					System.out.println("Player" + i + "'s score: " + players[i].score);
					
				}
			}// end if
		
			else if(plyrHandSize[i] < players[i].hand.getSize()){
			
				System.out.println("Error! Player's hand size should not be incremented.");
				System.out.println("Player" + i + "'s hand: " + players[i].hand.toString());
				System.out.println("Player" + i + "'s score: " + players[i].score);
				
			}// end else if
		
			else{
			
				if(players[i].score == 0){
					
					System.out.println("Error! Player" + i + " should be incremented.");
					
				}
				
				else{
				
				System.out.println("Player" + i + "'s hand after pairs found: " + players[i].hand.toString());
				System.out.println("Player" + i + "'s score: " + players[i].score);
			
				}
				
				
			}// end else
			
			//testing getPairs
			System.out.println("Testing getPairs for Player" + i + ": " + players[i].getHand());
		
			//testing goFish
			System.out.println("Player" + i + " go fish...");
			players[i].goFish(deck);
			System.out.println("Player" + i + "'s hand: " + players[i].hand.toString());
		
			}// end for
		
		//testing requestCardFromPlayer
		System.out.println("Player1 asks player2 for a 7.");
		boolean reqCard = players[0].requestCardFromPlayer(players[1], Rank.SEVEN);
		
		if((!reqCard) && (players[1].giveCardWithRank(Rank.SEVEN) != null)){

			System.out.println("Error! Player2 has a 7 but requestCardFromPlayer is returning false.");
			
		}
		
		else if ((!reqCard) && (players[1].giveCardWithRank(Rank.SEVEN) == null)){
			
			System.out.println("Player2 doesn't have a 7.");
			
		}
		
		else if ((reqCard == true) && (players[1].giveCardWithRank(Rank.SEVEN) == null)){
			
			System.out.println("Error! Player2 does NOT have a 7 but requestCardFromPlayer indicates otherwise.");
			
		}
		
		else if ((reqCard == true) && (players[1].giveCardWithRank(Rank.SEVEN) != null)){
			
			System.out.println("Player2 has a 7. The card is removed from Player2's hand and added to Player1's hand.");
			
		}
		
		//testing resetPlayer
		System.out.println("Resetting Player1...");
		players[0].resetPlayer();
		System.out.println("Player1's resetted score (should be 0): " + players[0].score);
		System.out.println("Player1's resetted hand: " + players[0].hand.toString());
		
	}// end main
	
}// end Player class
