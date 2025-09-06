package main.artfix;

import java.util.Scanner;

/**
 * Human player implementation that gets moves from console input
 */
public class HumanPlayer extends Player {
    private final Scanner scanner;
    
    public HumanPlayer(String name, GameSymbol symbol, Scanner scanner) {
        super(name, symbol);
        this.scanner = scanner;
    }
    
    @Override
    public Position makeMove(Board board) {
        while (true) {
            System.out.printf("%s, enter your move (1-9): ", getName());
            
            try {
                String input = scanner.nextLine().trim();
                
                // Validate input is a number
                int moveNumber = Integer.parseInt(input);
                
                // Convert to position and validate
                Position position = Position.fromUserInput(moveNumber);
                
                if (board.isEmpty(position)) {
                    return position;
                } else {
                    System.out.println("That position is already taken! Try again.");
                }
                
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number between 1 and 9.");
            } catch (IllegalArgumentException e) {
                System.out.println("Please enter a number between 1 and 9.");
            }
        }
    }
}
