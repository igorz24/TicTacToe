package main;

public class Main {

    public static void main(String[] args) {

        TicTacToe game = new TicTacToe();
        IO io = new IO();
        // Welcome message
        io.printMessage(IO.messageType.welcomePlayer.ordinal(), game.getActivePlayerChar());

        //Game Loop
        do {
            // Message informing who is the active player and a board print
            io.printMessage(IO.messageType.informWhoseTurnItIs.ordinal(), game.getActivePlayerChar());
            io.printMessage(IO.messageType.askForInput.ordinal(), game.getActivePlayerChar());
            io.printString(game.toString());
            // Getting input from user until correct
            if(!io.getInputFromUser())
                io.printMessage(IO.messageType.informAboutWrongInput.ordinal(), game.getActivePlayerChar());
            else{
                // If coordinates correct, but filed already occupied - inform the player and redo
                if(!game.makeMove(game.getActivePlayerChar(), io.getRow(), io.getColumn()))
                    io.printMessage(IO.messageType.informAboutWrongMove.ordinal(), game.getActivePlayerChar());
                // change active player
                else game.changePlayer();
            }


        }while(!(game.isBoardFull() || game.checkWinCon())); // Until no one won and there is no draw

        // change active player (game has ended and we go back to the player who won)
        game.changePlayer();
        // print final state of the game
        io.printGameBoard(game.getGameBoard());
        // if a player won
       if(game.checkWinCon()) io.printMessage(IO.messageType.informWhoWon.ordinal(),game.getActivePlayerChar());
       // if there was a tie
       else io.printMessage(IO.messageType.informAboutTie.ordinal(),game.getActivePlayerChar());
    }
}
