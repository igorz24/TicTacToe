package main;


import java.util.Arrays;

// Game Class
public class TicTacToe {

    private char[][] gameBoard;
    private final int size = 3;
    //active player's char
    private char activePlayerChar;
    // Variable which helps in win condition checking
    private int noFilledSpaces;
    // Default Constructor
    public TicTacToe() {
        // Creating the Board and Filling it with blank spaces ( '.' )
        this.gameBoard = new char[size][size];
        for (int i = 0; i < size; i++)
            for(int j = 0; j < size; j++)
            gameBoard[i][j] = '.';

        // Board is empty
        noFilledSpaces = 0;
        activePlayerChar = 'X';

    }

    // Get active player's char
    public char getActivePlayerChar() {
        return activePlayerChar;
    }

    // Size getter
    public int getSize() {
        return size;
    }

    // GameBoard getter
    char[][] getGameBoard() {
        return gameBoard;
    }

    // Get number of already filled spaces
    public int getFilledSpaces() {
        return noFilledSpaces;
    }

    // Fills the given space in board with a provided char
    public boolean makeMove(char XO, int column, int row){
        // if out of board range - return false
        if(row < 0 || column < 0 || row >= size || column >= size)
            return false;
        // if unexpected char - return false
        if(XO != 'X' && XO != 'O')
            return false;
        // if field already set - return false
        if(gameBoard[row][column] != '.')
            return false;
        // if move is correct, fill the board and return true
        gameBoard[row][column] = XO;
        noFilledSpaces++;
        return true;
    }

    // Check if any player won
    public boolean checkWinCon(){
        // No one could have won by now
        if(noFilledSpaces < 5) return false;

        // Check all vertical lines
        for(int i =0; i< size; i++){
            if(checkSingleLine(i,0,0,1))
                return true;
        }

        // Check all horizontal lines
        for(int i =0; i< size; i++){
            if(checkSingleLine(0,i,1,0))
                return true;
        }

        // Check both diagonals
        return checkSingleLine(0, 0, 1, 1) || checkSingleLine(size - 1, 0, -1, 1);

        // No one won yet
    }

    /* Checks if all the chars in a given line are the same. Returns True if they are, False otherwise.
       Check starts with point (x,y) and iterates to positions provided with dx,dy
     */
    private boolean checkSingleLine(int x, int y, int dx, int dy){
        // assign char which will be checked
        char charToCheck = gameBoard[x][y];
        // if char is a blank space - return false
        if(charToCheck == '.')
            return false;
        // if provided arguments would result in leaving the array - return false
        if(x+dx*(size-1) >= size || y+dy*(size-1) >= size || x+dx*(size-1) < 0 || y+dy*(size-1) < 0 )
            return false;
        // check all the other fields in a given line
        for(int i = 1; i < size; i++){
            int tempX = x + i*dx;
            int tempY = y + i*dy;
            // if fields that are being checked are not the same as initial one - return false
            if(gameBoard[tempX][tempY] != charToCheck)
                return false;
        }
        // All the fields are the same - someone won
        return true;
    }

    // Checks if board is full. Returns true fs there is no space left to play.
    public boolean isBoardFull(){
        return noFilledSpaces >= size * size;
    }

    // Changes the active player
    public void changePlayer(){
        if( activePlayerChar == 'X')
            activePlayerChar = 'O';
        else activePlayerChar = 'X';
    }

    // Return board as a single String
    @Override
    public String toString() {
        if (gameBoard == null) return "board empty";

        else{
            String tempString = "";
            final char a = 'a';
            //Display column numbers
           tempString += "  1 2 3\n";

            // For each row
            for(int i = 0; i < size; i++){
                // Display row letters
                tempString += (char)(i+a);
                // for each field in this row
                for(int j = 0; j < size; j++)
                    tempString += " " + gameBoard[i][j];
                tempString += "\n";
            }
            tempString += "\n";


           return tempString;
        }
    }
}
