package main.artfix;

/**
 * Abstract base class for all players in the game
 */
public abstract class Player {
    protected final GameSymbol symbol;
    protected final String name;
    
    public Player(String name, GameSymbol symbol) {
        this.name = name;
        this.symbol = symbol;
    }
    
    /**
     * Make a move on the board
     * @param board the current board state
     * @return the position where the player wants to move
     */
    public abstract Position makeMove(Board board);
    
    public GameSymbol getSymbol() {
        return symbol;
    }
    
    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        return String.format("%s (%s)", name, symbol.getDisplay());
    }
}
