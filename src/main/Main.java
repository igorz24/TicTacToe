package main;

public class Main {

    public static void main(String[] args) {

        TicTacToe game = new TicTacToe();
        IO io = new IO();
        // Welcome message
        io.printMessage(0, game.getActivePlayerChar());

        //Game Loop
        do {
            // Message informing who is the active player and a board print
            io.printMessage(2, game.getActivePlayerChar());
            io.printMessage(1, game.getActivePlayerChar());
            io.printGameBoard(game.getGameBoard());
            // Getting input from user until correct
            if(!io.getInputFromUser())
                io.printMessage(3, game.getActivePlayerChar());
            else{
                // If coordinates correct, but filed already occupied - inform the player and redo
                if(!game.makeMove(game.getActivePlayerChar(), io.getRow(), io.getColumn()))
                    io.printMessage(4, game.getActivePlayerChar());
                // change active player
                else game.changePlayer();
            }


        }while(!(game.isBoardFull() || game.checkWinCon())); // Until no one won and there is no draw

        // change active player (game has ended and we go back to the player who won)
        game.changePlayer();
        // print final state of the game
        io.printGameBoard(game.getGameBoard());
        // if a player won
       if(game.checkWinCon()) io.printMessage(5,game.getActivePlayerChar());
       // if there was a tie
       else io.printMessage(6,game.getActivePlayerChar());
    }
}
