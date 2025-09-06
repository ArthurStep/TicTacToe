# Tic-Tac-Toe Game

## Architecture

### Core Classes
- **`TicTacToeGame`**: the game controller and managing the flow of the game
- **`Board`**: the board state and logic
- **`Player`**: tbstract base class for all player classes
- **`HumanPlayer`**: tandle console input for human players  
- **`AIPlayer`**: trtificial intelligence player that uses minimax
- **`GameStats`**: gather, show, and store game statistics


## Development

### Project Structure
```
src/main/java/main/artfix/
├── Main.java              # Main entry point of the game
├── TicTacToeGame.java     # Handle game play
├── Board.java             # Handle game board logic
├── Player.java            # Abstract player
├── HumanPlayer.java       # Handle human player
├── AIPlayer.java          # Handle AI player using minimax
├── Position.java          # Handle board location
├── GameSymbol.java        # X, O, Empty 
├── GameState.java         # Win/Draw/Playing  
├── GameStats

```

## 👨‍💻 Author

**Arthur Stepanyan**
- GitHub: [ArthurStep](https://github.com/ArthurStep)
- Version: 2.0

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

---

*Built with ☕ and lots of strategic thinking!*
