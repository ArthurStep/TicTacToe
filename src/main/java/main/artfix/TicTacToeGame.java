package main.artfix;

import java.util.Scanner;

/**
 * Main game controller that orchestrates the tic-tac-toe game flow
 * Handles player setup, game loop, and user interactions
 */
public class TicTacToeGame {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Scanner scanner;
    private GameStats gameStats;
    
    public TicTacToeGame() {
        this.scanner = new Scanner(System.in);
        this.gameStats = new GameStats();
        initialize();
    }
    
    /**
     * Initialize the game components
     */
    private void initialize() {
        this.board = new Board();
        showWelcomeMessage();
        setupPlayers();
        this.currentPlayer = player1; // X always goes first
    }
    
    /**
     * Display welcome message and game instructions
     */
    private void showWelcomeMessage() {
        // Read banner from file if it exists
        FileIng.read("banner");
        if (FileIng.ReadData != null && !FileIng.ReadData.trim().isEmpty()) {
            System.out.println(FileIng.ReadData);
        }
        
        System.out.println("========================================");
        System.out.println("    Welcome to Tic-Tac-Toe Game!       ");
        System.out.println("========================================");
        System.out.println();
        System.out.println("Game Rules:");
        System.out.println("• Players take turns placing X's and O's");
        System.out.println("• First to get 3 in a row wins!");
        System.out.println("• Enter numbers 1-9 to place your symbol");
        System.out.println();
    }
    
    /**
     * Setup game mode and players
     */
    private void setupPlayers() {
        System.out.println("Choose game mode:");
        System.out.println("1. Player vs AI (Easy)");
        System.out.println("2. Player vs AI (Hard)"); 
        System.out.println("3. Player vs Player");
        System.out.print("Enter your choice (1-3): ");
        
        int choice = getValidChoice(1, 3);
        
        switch (choice) {
            case 1:
                setupPlayerVsAI(false);
                break;
            case 2:
                setupPlayerVsAI(true);
                break;
            case 3:
                setupPlayerVsPlayer();
                break;
        }
        
        System.out.printf("\n%s (X) will go first!\n\n", player1.getName());
    }
    
    /**
     * Setup Player vs AI game mode
     */
    private void setupPlayerVsAI(boolean isHardMode) {
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine().trim();
        if (playerName.isEmpty()) {
            playerName = "Player";
        }
        
        String aiDifficulty = isHardMode ? "Hard" : "Easy";
        String aiName = String.format("AI (%s)", aiDifficulty);
        
        player1 = new HumanPlayer(playerName, GameSymbol.X, scanner);
        player2 = new AIPlayer(aiName, GameSymbol.O, isHardMode);
    }
    
    /**
     * Setup Player vs Player game mode
     */
    private void setupPlayerVsPlayer() {
        System.out.print("Enter name for Player 1 (X): ");
        String name1 = scanner.nextLine().trim();
        if (name1.isEmpty()) {
            name1 = "Player 1";
        }
        
        System.out.print("Enter name for Player 2 (O): ");
        String name2 = scanner.nextLine().trim();
        if (name2.isEmpty()) {
            name2 = "Player 2";
        }
        
        player1 = new HumanPlayer(name1, GameSymbol.X, scanner);
        player2 = new HumanPlayer(name2, GameSymbol.O, scanner);
    }
    
    /**
     * Main game loop
     */
    public void playGame() {
        while (true) {
            playRound();
            
            if (!askForRematch()) {
                break;
            }
            
            // Reset for new game
            board.reset();
            currentPlayer = player1; // X always starts
        }
        
        showFinalStats();
        System.out.println("Thanks for playing! Goodbye!");
        scanner.close();
    }
    
    /**
     * Play a single round of the game
     */
    private void playRound() {
        System.out.println("\n" + "=".repeat(40));
        System.out.printf("Starting new game: %s vs %s\n", player1.getName(), player2.getName());
        System.out.println("=".repeat(40));
        
        GameState gameState = GameState.PLAYING;
        
        while (gameState == GameState.PLAYING) {
            board.display();
            
            // Current player makes a move
            Position move = currentPlayer.makeMove(board);
            board.makeMove(move, currentPlayer.getSymbol());
            
            // Check game state
            gameState = board.getGameState();
            
            // Switch players for next turn
            if (gameState == GameState.PLAYING) {
                currentPlayer = (currentPlayer == player1) ? player2 : player1;
            }
        }
        
        // Show final board and results
        board.display();
        displayGameResult(gameState);
        gameStats.recordGame(gameState);
    }
    
    /**
     * Display the result of the completed game
     */
    private void displayGameResult(GameState gameState) {
        System.out.println("=".repeat(40));
        
        switch (gameState) {
            case X_WINS:
                System.out.printf("🎉 %s wins! 🎉\n", player1.getName());
                break;
            case O_WINS:
                System.out.printf("🎉 %s wins! 🎉\n", player2.getName());
                break;
            case DRAW:
                System.out.println("🤝 It's a draw! Good game! 🤝");
                break;
        }
        
        System.out.println("=".repeat(40));
    }
    
    /**
     * Ask user if they want to play again
     */
    private boolean askForRematch() {
        System.out.print("\nPlay again? (y/n): ");
        
        while (true) {
            String input = scanner.nextLine().trim().toLowerCase();
            
            if (input.equals("y") || input.equals("yes")) {
                return true;
            } else if (input.equals("n") || input.equals("no")) {
                return false;
            } else {
                System.out.print("Please enter 'y' for yes or 'n' for no: ");
            }
        }
    }
    
    /**
     * Show final game statistics
     */
    private void showFinalStats() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("           FINAL STATISTICS");
        System.out.println("=".repeat(40));
        
        gameStats.displayStats(player1.getName(), player2.getName());
        
        System.out.println("=".repeat(40));
    }
    
    /**
     * Get valid choice from user within specified range
     */
    private int getValidChoice(int min, int max) {
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                int choice = Integer.parseInt(input);
                
                if (choice >= min && choice <= max) {
                    return choice;
                } else {
                    System.out.printf("Please enter a number between %d and %d: ", min, max);
                }
            } catch (NumberFormatException e) {
                System.out.printf("Please enter a valid number between %d and %d: ", min, max);
            }
        }
    }
}
