package main.artfix;

/**
 * Entry point for the Tic-Tac-Toe game
 * @author Arthur Stepanyan
 * @version 2.0
 */
public class Main {
    public static void main(String[] args) {
        try {
            TicTacToeGame game = new TicTacToeGame();
            game.playGame();
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
            System.err.println("Please restart the game.");
        }
    }
}
