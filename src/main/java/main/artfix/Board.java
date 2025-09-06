package main.artfix;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the tic-tac-toe game board
 * Handles board state management and game logic
 */
public class Board {
    private static final int BOARD_SIZE = 3;
    private final GameSymbol[][] grid;
    
    public Board() {
        this.grid = new GameSymbol[BOARD_SIZE][BOARD_SIZE];
        initializeBoard();
    }
    
    /**
     * Initialize empty board with all cells set to EMPTY
     */
    private void initializeBoard() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                grid[row][col] = GameSymbol.EMPTY;
            }
        }
    }
    
    /**
     * Make a move at the specified position
     * @param position the position to place the symbol
     * @param symbol the symbol to place
     * @return true if move was successful, false if position already occupied
     */
    public boolean makeMove(Position position, GameSymbol symbol) {
        if (!isValidPosition(position) || !isEmpty(position)) {
            return false;
        }
        
        grid[position.getRow()][position.getCol()] = symbol;
        return true;
    }
    
    /**
     * Check if position is within board bounds
     */
    public boolean isValidPosition(Position position) {
        return position.getRow() >= 0 && position.getRow() < BOARD_SIZE &&
               position.getCol() >= 0 && position.getCol() < BOARD_SIZE;
    }
    
    /**
     * Check if position is empty
     */
    public boolean isEmpty(Position position) {
        return isValidPosition(position) && 
               grid[position.getRow()][position.getCol()] == GameSymbol.EMPTY;
    }
    
    /**
     * Get symbol at specified position
     */
    public GameSymbol getSymbolAt(Position position) {
        if (!isValidPosition(position)) {
            return GameSymbol.EMPTY;
        }
        return grid[position.getRow()][position.getCol()];
    }
    
    /**
     * Get all available (empty) positions on the board
     */
    public List<Position> getAvailablePositions() {
        List<Position> available = new ArrayList<>();
        
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                if (grid[row][col] == GameSymbol.EMPTY) {
                    available.add(new Position(row, col));
                }
            }
        }
        
        return available;
    }
    
    /**
     * Check current game state
     */
    public GameState getGameState() {
        // Check for winner
        GameSymbol winner = getWinner();
        if (winner == GameSymbol.X) {
            return GameState.X_WINS;
        } else if (winner == GameSymbol.O) {
            return GameState.O_WINS;
        }
        
        // Check for draw (board full, no winner)
        if (getAvailablePositions().isEmpty()) {
            return GameState.DRAW;
        }
        
        return GameState.PLAYING;
    }
    
    /**
     * Determine the winner of the game
     * @return winning symbol or EMPTY if no winner
     */
    private GameSymbol getWinner() {
        // Check rows
        for (int row = 0; row < BOARD_SIZE; row++) {
            if (grid[row][0] != GameSymbol.EMPTY &&
                grid[row][0] == grid[row][1] && 
                grid[row][1] == grid[row][2]) {
                return grid[row][0];
            }
        }
        
        // Check columns
        for (int col = 0; col < BOARD_SIZE; col++) {
            if (grid[0][col] != GameSymbol.EMPTY &&
                grid[0][col] == grid[1][col] && 
                grid[1][col] == grid[2][col]) {
                return grid[0][col];
            }
        }
        
        // Check main diagonal (top-left to bottom-right)
        if (grid[0][0] != GameSymbol.EMPTY &&
            grid[0][0] == grid[1][1] && 
            grid[1][1] == grid[2][2]) {
            return grid[0][0];
        }
        
        // Check anti-diagonal (top-right to bottom-left)
        if (grid[0][2] != GameSymbol.EMPTY &&
            grid[0][2] == grid[1][1] && 
            grid[1][1] == grid[2][0]) {
            return grid[0][2];
        }
        
        return GameSymbol.EMPTY;
    }
    
    /**
     * Create a copy of the current board state
     */
    public Board copy() {
        Board copy = new Board();
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                copy.grid[row][col] = this.grid[row][col];
            }
        }
        return copy;
    }
    
    /**
     * Clear the board for a new game
     */
    public void reset() {
        initializeBoard();
    }
    
    /**
     * Display the board in a nice format
     */
    public void display() {
        System.out.println("\n   |   |   ");
        for (int row = 0; row < BOARD_SIZE; row++) {
            System.out.print(" ");
            for (int col = 0; col < BOARD_SIZE; col++) {
                GameSymbol symbol = grid[row][col];
                if (symbol == GameSymbol.EMPTY) {
                    // Show position number for empty cells
                    int displayNum = row * 3 + col + 1;
                    System.out.print(displayNum);
                } else {
                    System.out.print(symbol.getDisplay());
                }
                
                if (col < BOARD_SIZE - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println(" ");
            
            if (row < BOARD_SIZE - 1) {
                System.out.println("___|___|___");
                System.out.println("   |   |   ");
            }
        }
        System.out.println("\n");
    }
}
