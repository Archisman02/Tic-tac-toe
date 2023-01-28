package Games;

import java.util.Scanner;

public class TicTacToe {
	
	private Player player1, player2;
	private Board board;
	private int numPlayers;

	public static void main(String args[]) {
		TicTacToe t = new TicTacToe();
		t.startGame();
	}
	
	public void startGame() {
		Scanner s = new Scanner(System.in);
		// Take player input.
		player1 = takePlayerInput(++numPlayers);
		player2 = takePlayerInput(++numPlayers);
		while(player1.getSymbol() == player2.getSymbol()) {
			System.out.println("Sysmbol already taken. Please enter the symbol again.");
			player2.setSymbol(s.next().charAt(0));
		}
		// Build the board.
		board = new Board(player1.getSymbol(), player2.getSymbol());
		// Play the game.
		boolean player1Turn = true;
		int status = 4;
		while(status == 4 || status == 5) {
			if(player1Turn == true) {
				System.out.println("Player 1 - " + player1.getName() + "'s turn");
				System.out.println("Enter x: ");
				int x = s.nextInt();
				System.out.println("Enter y: ");
				int y = s.nextInt();
				status = board.move(player1.getSymbol(), x, y);
				if(status == 5) {
					System.out.println("Invalid move. Please try again.");
					continue;
				}
			}else {
				System.out.println("Player 2 - " + player2.getName() + "'s turn");
				System.out.println("Enter x: ");
				int x = s.nextInt();
				System.out.println("Enter y: ");
				int y = s.nextInt();
				status = board.move(player2.getSymbol(), x, y);
				if(status == 5) {
					System.out.println("Invalid move. Please try again.");
					continue;
				}
			}
			board.print();
			player1Turn = !player1Turn;
		}
		
		if(status == 1) {
			System.out.println("Player 1 - " + player1.getName() + " wins !!!" );
		}else if(status == 2) {
			System.out.println("Player 2 - " + player2.getName() + " wins !!!" );
		}else {
			System.out.println("It is a draw !!!");
		}
	}

	private Player takePlayerInput(int numPlayer) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter name of player " + numPlayer + ":");
		String name = s.next();
		System.out.println("Enter symbol of player " + numPlayer + ":");
		char symbol = s.next().charAt(0);
		Player p = new Player(name, symbol);
		return p;
	}

	
}
