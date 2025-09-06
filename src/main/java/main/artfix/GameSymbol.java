package main.artfix;

/**
 * Enum representing the symbols used in the game
 */
public enum GameSymbol {
    X("X"), 
    O("O"), 
    EMPTY(" ");
    
    private final String display;
    
    GameSymbol(String display) {
        this.display = display;
    }
    
    public String getDisplay() {
        return display;
    }
    
    public GameSymbol getOpponent() {
        switch (this) {
            case X: return O;
            case O: return X;
            default: return EMPTY;
        }
    }
    
    @Override
    public String toString() {
        return display;
    }
}
