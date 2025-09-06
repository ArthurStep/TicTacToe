package main.artfix;

/**
 * Tracks game statistics across multiple rounds
 */
public class GameStats {
    private int xWins = 0;
    private int oWins = 0;
    private int draws = 0;
    private int totalGames = 0;
    
    /**
     * Record the result of a completed game
     */
    public void recordGame(GameState result) {
        totalGames++;
        
        switch (result) {
            case X_WINS:
                xWins++;
                break;
            case O_WINS:
                oWins++;
                break;
            case DRAW:
                draws++;
                break;
        }
    }
    
    /**
     * Display current statistics
     */
    public void displayStats(String player1Name, String player2Name) {
        if (totalGames == 0) {
            System.out.println("No games played yet!");
            return;
        }
        
        System.out.printf("Total games played: %d\n", totalGames);
        System.out.printf("%s (X) wins: %d (%.1f%%)\n", 
                         player1Name, xWins, (double)xWins / totalGames * 100);
        System.out.printf("%s (O) wins: %d (%.1f%%)\n", 
                         player2Name, oWins, (double)oWins / totalGames * 100);
        System.out.printf("Draws: %d (%.1f%%)\n", 
                         draws, (double)draws / totalGames * 100);
    }
    
    // Getters for individual stats
    public int getXWins() { return xWins; }
    public int getOWins() { return oWins; }
    public int getDraws() { return draws; }
    public int getTotalGames() { return totalGames; }
}
