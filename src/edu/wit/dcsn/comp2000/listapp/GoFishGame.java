package edu.wit.dcsn.comp2000.listapp;
 
import java.util.LinkedList;
import java.util.Random;
 
/**
 * A class to simulate a game of Go Fish.
 */
public class GoFishGame {
 
 	private Deck deck;
 	private LinkedList<Player> players;
	private boolean gameInProgress;
	private boolean initialized;
	private int roundNumber;
	private int currentPlayer;
	private int numberOfCPU;
	
	public static final int MAX_PLAYERS = 4;
 	
 	/**
 	 * Create a GoFishGame
 	 */
 	public GoFishGame() {
		// TODO Implement
		initialized = false;
	}
	
	/**
	 * Adds a new player to the game, if the maximum number of players
	 * are not already in the game.
	 * @param playerName the name of the player to add.
	 * @return true if the player is added
	 *         false otherwise
	 */
	public boolean addPlayer(String playerName) {
		if (!initialized) {
			return false;
		}
		if (players.size() < MAX_PLAYERS) {
			return players.add(new Player(playerName));
		}
		return false;
	}
	
	/**
	 * Check if the conditions indicating the game is over have been met,
	 * that is either the deck is empty, or any of the players' hands are empty.
	 */
	public void checkForGameOver() {
		if (deck.isEmpty()) {
			gameInProgress = false;
		}
		for (Player player : players) {
			if (player.getHand().isEmpty()) {
				gameInProgress = false;
			}
		}
	}
	
	/**
	 * Randomly decide an action for the current player.
	 * @return a valid PlayerAction
	 */
	public PlayerAction decideRandomAction() {
		Random rand = new Random();
		Player playerSelection;
		Player currentPlayer = getCurrentPlayer();
		Hand currentPlayerHand = currentPlayer.getHand();
		Rank rankSelection;
		do {
			playerSelection = players.get( rand.nextInt( players.size() ) );
		} while (playerSelection == currentPlayer);
		rankSelection = currentPlayerHand.getCardAtIndex( rand.nextInt( currentPlayerHand.getSize() ) ).rank;
		return new PlayerAction(playerSelection, rankSelection);
	}
	
	/**
	 * End the current player's turn and set the current player to
	 * the next in the rotation. If the current player has looped back
	 * to the first player, increment the round counter.
	 */
	public void endPlayerTurn() {
		currentPlayer = (currentPlayer % players.size()) + 1;
		if (currentPlayer == 1) {
			roundNumber++;
		}
	}
	
	/**
	 * Return the Player object of the current player's turn.
	 * @return the current player object.
	 */
	public Player getCurrentPlayer() {
		return this.getPlayer(currentPlayer);
	}
	
	/**
	 * Get the player number of the current player.
	 * @return the number of the current player.
	 */
	public int getCurrentPlayerNumber() {
		return currentPlayer;
	}
	
	/**
	 * Returns the game deck.
	 * @return the game deck.
	 */
	public Deck getDeck() {
		return deck;
	}
	
	/**
	 * Returns the number of players in the game
	 * @return the number of players in the game
	 */
	public int getNumberOfPlayers() {
		return players.size();
	}
	
	/**
	 * Return the player object associated with a player number
	 * @param playerNumber the player number
	 * @return the Player object.
	 */
	public Player getPlayer(int playerNumber) {
		return players.get(playerNumber - 1);
	}
	
	/**
	 * Gets the current round number of the game.
	 * @return the round number
	 */
	public int getRoundNumber() {
		return roundNumber;
	}
	
	/**
	 * Check if the game is currently in progress.
	 * @return true if the game is in progress.
	 *         false if the game hasn't started or if the game is over
	 */
	public boolean isGameInProgress() {
		return gameInProgress;
	}
	
	/**
	 * Check if the current player is a human.
	 * @return true if the player is a human.
	 *         false if the player is a CPU.
	 */
	public boolean isCurrentPlayerHuman() {
		return (currentPlayer <= players.size() - numberOfCPU);
	}
	
	/**
	 * Start the game. Shuffles the deck, deals a hand to each player,
	 * finds all the pairs in the players' hands and sorts the hand.
	 */
	public void startGame() {
		gameInProgress = true;
		deck.shuffle();
		deck.deal(players, 7);
		for (Player player : players) {
			player.findPairs();
			player.getHand().sort();
		}
 	}
	
	/**
	 * Set the number of CPU players in the game. The CPU are always
	 * the last players in the player list.
	 * @param num the number of CPU players.
	 */
	public void setNumberOfCPU(int num) {
		this.numberOfCPU = num;
	}
 	
 	/**
	 * Initialize the game state based on prompted parameters.
	 * The game prompts the user for the number of players, how many
	 * of those players are CPU players, and the names of the players. 
	 * Initializes all game data to default state.
 	 */
 	public void initialize() {
		deck = new Deck();
		players = new LinkedList<Player>();
		gameInProgress = false;
		roundNumber = 1;
		currentPlayer = 1;
		initialized = true;
 	}
 	
 	/**
	 * A class to represent the selection made on a player's turn.
	 * Selections are assumed to be valid if they are supplied to this class.
	 * Invalid selections should be indicated by passing in a null argument.
	 * @author Scott Austin
	 *
 	 */
	static class PlayerAction {
		/** The selection for which player the current player will ask for a card */
		public final Player playerSelection;
		
		/** The selection for which rank of card the current player wishes to ask for */
		public final Rank rankSelection;
		
		/**
		 * Create a PlayerAction. The PlayerAction identifies which player the
		 * current player wishes to ask for a card and the rank of the card
		 * they are asking for. If either playerSelection or rankSelection are null,
		 * then this indicates that the choice was invalid.
		 * @param playerSelection the player that is being asked for a card.
		 *                        Passing in null indicates the choice of player
		 *                        was invalid and this is an invalid action.
		 * @param rankSelection the rank of card being asked for.
		 *                      Passing in null indicates the choice of rank
		 *                      was invalid and this is an invalid action.
		 */
		public PlayerAction(Player playerSelection, Rank rankSelection) {
			this.playerSelection = playerSelection;
			this.rankSelection = rankSelection;
		}
 	}
 }