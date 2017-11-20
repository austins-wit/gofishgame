package edu.wit.dcsn.comp2000.listapp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import edu.wit.dcsn.comp2000.listapp.GoFishGame.PlayerAction;
import javafx.util.Pair;

/**
 * Provides the methods required for playing and displaying
 * a GoFishGame in a console environment.
 * 
 * @author Scott Austin
 *
 */
public class GoFishConsole {

	private static Scanner sc;
	
	/**
	 * Display the hand of the current player. Displays index indicators
	 * above the actual card values.
	 * @param player
	 */
	public static void printCurrentPlayerHand(Player player) {
		System.out.printf("\nIt is %s's Turn!\n", player.toString());
		System.out.printf("%s's Hand: \n ", player.toString());
		
		Hand playerHand = player.getHand();
		for (int i = 1; i <= playerHand.getSize(); ++i) {
			System.out.printf(" %-2d ", i);
		}
		System.out.println("\n" + playerHand.toString());
		
		
	}

	/**
	 * Print a starting game message.
	 */
	public static void printGameStartMessage() {
		System.out.println("\nLet's play Go Fish!");
	}
	
	/**
	 * Display the current game status.
	 * Displays the round number, followed by the number of cards in the deck,
	 * followed by player status (cards in hand, pairs on table)
	 * @param game the GoFishGame object
	 */
	public static void printGameStatus(GoFishGame game) {
		System.out.println("\n\n\n\n");
		System.out.println("****************");
		System.out.printf ("    Round %d\n", game.getRoundNumber());
		System.out.println("****************\n");
		
		System.out.printf("Deck: (%d) cards remaining.\n", game.getDeck().getSize());
		for (int i = 1; i <= game.getNumberOfPlayers(); ++i) {
			Player player = game.getPlayer(i);
			System.out.printf("%d) %18s: (%d) cards\n", i, player.toString(), player.getHand().getSize());
			System.out.printf("%13s's Pairs: ", player.toString());
			for (Pair<Card,Card> pair : player.getPairs()) {
				System.out.printf("(%-3s,%-3s) ", pair.getKey().toString(), pair.getValue().toString());
			}
			System.out.println();
		}
	}
	
	/**
	 * Prints a title message.
	 */
	public static void printTitleMessage() {
		System.out.println("***********************");
		System.out.println("* Welcome to Go Fish! *");
		System.out.println("***********************");
	}
	
	/**
	 * Request input from the user to indicate what a player wants
	 * to do for their turn. The user inputs a player number followed
	 * by a card index representing the index of a card in their hand
	 * they want to request a card of. If the input supplied is invalid,
	 * an invalid PlayerAction object will be returned from this method.
	 * @param game the GoFishGame object.
	 * @return A PlayerAction object that indicates the action a player wants
	 *         to take on their turn.
	 */
	private static PlayerAction promptForPlayerTurnAction(GoFishGame game) {
		int playerNumber = 0;
		int cardNumber = 0;
		System.out.println("Ask a player for a card. Type a player number, followed" +
				" by the index of the card in your hand you wish to match:");
		if (sc.hasNextInt()) {
			playerNumber = sc.nextInt();
		}
		else {
			sc.next();
		}
		if (sc.hasNextInt()) {
			cardNumber = sc.nextInt();
		}
		else {
			sc.next();
		}
		sc.nextLine();
		
		Player chosenPlayer = (playerNumber >= 1 && playerNumber <= game.getNumberOfPlayers() && playerNumber != game.getCurrentPlayerNumber())
				? game.getPlayer(playerNumber) 
				: null;
		Rank chosenRank = (cardNumber >= 1 && cardNumber <= game.getCurrentPlayer().getHand().getSize()) 
				? game.getCurrentPlayer().getHand().getCardAtIndex(cardNumber - 1).rank 
				: null;
		
		return new GoFishGame.PlayerAction(chosenPlayer, chosenRank);
	}
	
	/**
	 * Request a name for a player from the user.
	 * @param playerNumber the player number of the player to get a name for.
	 * @return the player name.
	 */
	private static String promptForPlayerName(int playerNumber) {
		System.out.printf("Enter Player %d's name: ", playerNumber);
		sc.hasNextLine();
		return sc.nextLine();
	}
	
	/**
	 * Prompts the user for the number of computer controlled players.
	 * Must be between 0 and maxCPU.
	 * @param maxCPU the maximum number of CPU players allowed
	 * @return the number of CPU players
	 */
	private static int promptForNumberOfCPU(int maxCPU) {
		int numberOfCPU = -1;
		do {
			System.out.printf("How many of the players are CPU? (0-%d): ", maxCPU);
			if (sc.hasNextInt()) {
				numberOfCPU = sc.nextInt();
				sc.nextLine();
			}
			else {
				sc.nextLine();
				numberOfCPU = -1;
			}
			
			if (numberOfCPU < 0 || numberOfCPU > maxCPU) {
				System.out.printf("Invalid value! ");
			}
		} while (numberOfCPU < 0 || numberOfCPU > maxCPU);
		
		return numberOfCPU;
	}
	
	/**
	 * Prompt the user for the number of players in the game.
	 * Must be within 2 - maxPlayers, inclusive.
	 * @param the maximum number of players allowed in the game.
	 * @return the number of players in the game.
	 */
	private static int promptForNumberOfPlayers(int maxPlayers) {
		int numberOfPlayers = 0;
		do {
			System.out.printf("How many players are there? (2-%d): ", maxPlayers);
			if (sc.hasNextInt()) {
				numberOfPlayers = sc.nextInt();
				sc.nextLine();
			}
			else {
				sc.nextLine();
				numberOfPlayers = 0;
			}
			
			if (numberOfPlayers < 2 || numberOfPlayers > maxPlayers) {
				System.out.printf("Invalid value! ");
			}
		} while (numberOfPlayers < 2 || numberOfPlayers > maxPlayers);
		
		return numberOfPlayers;	
	}
	
	/**
	 * Driver for the console application of Go Fish
	 * @param args -unused-
	 */
	public static void main(String[] args) {
		sc = new Scanner(System.in);		
		GoFishGame game = new GoFishGame();
		game.initialize();
		
		printTitleMessage();
		System.out.println();
		
		int numberOfPlayers = promptForNumberOfPlayers(GoFishGame.MAX_PLAYERS);
		System.out.println();
		
		int numberOfCPU     = promptForNumberOfCPU(numberOfPlayers - 1);
		System.out.println();
		
		for (int i = 1; i <= numberOfPlayers - numberOfCPU; ++i) {
			game.addPlayer(promptForPlayerName(i));
		}
		for (int i = 1; i <= numberOfCPU; ++i) {
			game.addPlayer("CPU " + i);
		}
		game.setNumberOfCPU(numberOfCPU);
		
		printGameStartMessage();
		System.out.println("Press enter to continue.");
		sc.hasNextLine();
		sc.nextLine();
		
		game.startGame();
		while (game.isGameInProgress()) {
			GoFishGame.PlayerAction action;
			do {
				printGameStatus(game);
				printCurrentPlayerHand(game.getCurrentPlayer());
				
				if (game.isCurrentPlayerHuman()) {
					action = promptForPlayerTurnAction(game);
				}
				else {
					action = game.decideRandomAction();
				}
				if (action.playerSelection == null) {
					System.out.println("Invalid player selected! Press enter to continue.");
					sc.hasNextLine();
					sc.nextLine();
				}
				else if (action.rankSelection == null) {
					System.out.println("Invalid card selected! Press enter to continue.");
					sc.hasNextLine();
					sc.nextLine();
				}
			} while (action.playerSelection == null || action.rankSelection == null);
			
			System.out.printf("%s: \"%s, do you have any %ss?\"\n",
					game.getCurrentPlayer(),
					action.playerSelection.toString(),
					action.rankSelection.getDisplayName() );
			
			if (game.getCurrentPlayer().requestCardFromPlayer(action.playerSelection, action.rankSelection)) {
				System.out.printf("%s: \"Yes, here's a %s.\"",
						action.playerSelection.toString(),
						action.rankSelection.getDisplayName());
				game.getCurrentPlayer().findPairs();
			}
			else {
				System.out.printf("%s: \"Go fish!\"", action.playerSelection.toString());
				Card drawnCard = game.getCurrentPlayer().goFish(game.getDeck());
				System.out.printf("%s draws a %s.",
						game.getCurrentPlayer(),
						drawnCard.toString() );
				game.getCurrentPlayer().findPairs();
				game.endPlayerTurn();
			}
			
			sc.hasNextLine();
			sc.nextLine();
			game.checkForGameOver();
		}
		
		System.out.println("\n\n\n\nGame Over!");
		System.out.printf("%10s | Score\n", "Player");
		System.out.printf("-----------|-----\n");
		
		int maxScore = 0;
		LinkedList<Player> winners = new LinkedList<Player>();
		for (int i = 1; i <= game.getNumberOfPlayers(); ++i) {
			Player player = game.getPlayer(i);
			System.out.printf("%10s | %d\n", player.toString(), player.getPairs().size());
			if (player.getPairs().size() > maxScore) {
				winners.clear();
				winners.add(player);
				maxScore = player.getPairs().size();
			}
			else if (player.getPairs().size() == maxScore) {
				winners.add(player);
			}
		}
		
		System.out.printf("\n\nThe winner%s:", winners.size() > 1 ? "s are" : " is");
		for (Player winner : winners) {
			System.out.printf(" %s", winner.toString());
		}
		sc.close();
	}
}
