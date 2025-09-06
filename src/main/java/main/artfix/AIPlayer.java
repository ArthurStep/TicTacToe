package main.artfix;

import java.util.List;
import java.util.Random;

/**
 * AI player implementation using minimax algorithm with alpha-beta pruning
 * Provides challenging gameplay while remaining beatable
 */
public class AIPlayer extends Player {
    private static final int MAX_DEPTH = 9; // Full depth for 3x3 board
    private final Random random = new Random();
    private final boolean isHardMode;
    
    public AIPlayer(String name, GameSymbol symbol, boolean isHardMode) {
        super(name, symbol);
        this.isHardMode = isHardMode;
    }
    
    @Override
    public Position makeMove(Board board) {
        System.out.printf("%s is thinking...\n", getName());
        
        // Add slight delay for realism
        try {
            Thread.sleep(500 + random.nextInt(1000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        Position bestMove;
        
        if (isHardMode) {
            bestMove = findBestMove(board);
        } else {
            // Easy mode: mix of smart and random moves
            if (random.nextInt(10) < 3) { // 30% random moves
                List<Position> available = board.getAvailablePositions();
                bestMove = available.get(random.nextInt(available.size()));
            } else {
                bestMove = findBestMove(board);
            }
        }
        
        System.out.printf("%s chooses position %d\n", getName(), bestMove.toUserDisplay());
        return bestMove;
    }
    
    /**
     * Find the best move using minimax algorithm with alpha-beta pruning
     */
    private Position findBestMove(Board board) {
        List<Position> availablePositions = board.getAvailablePositions();
        
        if (availablePositions.isEmpty()) {
            throw new IllegalStateException("No available positions on board");
        }
        
        // First move: prefer center or corners for better gameplay
        if (availablePositions.size() == 9) {
            return getStrategicFirstMove();
        }
        
        Position bestPosition = availablePositions.get(0);
        int bestScore = Integer.MIN_VALUE;
        
        for (Position position : availablePositions) {
            Board boardCopy = board.copy();
            boardCopy.makeMove(position, symbol);
            
            int score = minimax(boardCopy, 0, false, Integer.MIN_VALUE, Integer.MAX_VALUE);
            
            if (score > bestScore) {
                bestScore = score;
                bestPosition = position;
            }
        }
        
        return bestPosition;
    }
    
    /**
     * Minimax algorithm with alpha-beta pruning
     */
    private int minimax(Board board, int depth, boolean isMaximizing, int alpha, int beta) {
        GameState gameState = board.getGameState();
        
        // Terminal states
        if (gameState == GameState.X_WINS) {
            return symbol == GameSymbol.X ? (10 - depth) : (depth - 10);
        }
        if (gameState == GameState.O_WINS) {
            return symbol == GameSymbol.O ? (10 - depth) : (depth - 10);
        }
        if (gameState == GameState.DRAW || depth >= MAX_DEPTH) {
            return 0;
        }
        
        List<Position> availablePositions = board.getAvailablePositions();
        
        if (isMaximizing) {
            int maxEval = Integer.MIN_VALUE;
            
            for (Position position : availablePositions) {
                Board boardCopy = board.copy();
                boardCopy.makeMove(position, symbol);
                
                int eval = minimax(boardCopy, depth + 1, false, alpha, beta);
                maxEval = Math.max(maxEval, eval);
                alpha = Math.max(alpha, eval);
                
                if (beta <= alpha) {
                    break; // Alpha-beta pruning
                }
            }
            
            return maxEval;
        } else {
            int minEval = Integer.MAX_VALUE;
            GameSymbol opponentSymbol = symbol.getOpponent();
            
            for (Position position : availablePositions) {
                Board boardCopy = board.copy();
                boardCopy.makeMove(position, opponentSymbol);
                
                int eval = minimax(boardCopy, depth + 1, true, alpha, beta);
                minEval = Math.min(minEval, eval);
                beta = Math.min(beta, eval);
                
                if (beta <= alpha) {
                    break; // Alpha-beta pruning
                }
            }
            
            return minEval;
        }
    }
    
    /**
     * Get strategic first move (center or corner)
     */
    private Position getStrategicFirstMove() {
        Position center = new Position(1, 1);
        
        // 70% chance to take center if available
        if (random.nextInt(10) < 7) {
            return center;
        } else {
            // Take a random corner
            Position[] corners = {
                new Position(0, 0), new Position(0, 2),
                new Position(2, 0), new Position(2, 2)
            };
            return corners[random.nextInt(corners.length)];
        }
    }
}
