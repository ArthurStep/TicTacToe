package main.artfix;

/**
 * Represents a position on the tic-tac-toe board
 * Uses 0-based indexing for internal calculations
 */
public class Position {
    private final int row;
    private final int col;
    
    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }
    
    // Convert from user input (1-9) to Position object
    public static Position fromUserInput(int input) {
        if (input < 1 || input > 9) {
            throw new IllegalArgumentException("Position must be between 1 and 9");
        }
        
        int index = input - 1;  // Convert to 0-based
        return new Position(index / 3, index % 3);
    }
    
    // Convert Position to user display format (1-9)
    public int toUserDisplay() {
        return row * 3 + col + 1;
    }
    
    public int getRow() {
        return row;
    }
    
    public int getCol() {
        return col;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Position position = (Position) obj;
        return row == position.row && col == position.col;
    }
    
    @Override
    public int hashCode() {
        return row * 3 + col;
    }
    
    @Override
    public String toString() {
        return String.format("Position(%d,%d)", row, col);
    }
}
