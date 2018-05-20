import main.TicTacToe;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {


    @Test
    public void shouldAddCharsToTheTable(){
        TicTacToe testGame = new TicTacToe();

        // Checking different possible moves - out of array, wrong char, replaying into the same place
        assertTrue(testGame.makeMove('X',0,0), "assert1");
        assertFalse(testGame.makeMove('X',0,0), "assert2");
        assertTrue(testGame.makeMove('O',2,0), "assert3");
        assertFalse(testGame.makeMove('O',2,0), "assert4");
        assertFalse(testGame.makeMove('O',4,0), "assert5");
        assertFalse(testGame.makeMove('O',2,5), "assert6");
        assertFalse(testGame.makeMove('O',-2,0), "assert7");
        assertFalse(testGame.makeMove('O',2,-3), "assert8");
        assertFalse(testGame.makeMove(' ',2,0), "assert9");
        assertFalse(testGame.makeMove('s',2,0), "assert10");

    }

    @Test
    public void shouldFillBoardAndCheckIfFull(){
        TicTacToe testGame = new TicTacToe();
        // Checking if board full before and after filling it up
        assertFalse(testGame.isBoardFull(), "assert1");
        assertTrue(testGame.makeMove('X',0,0), "assert2");
        assertTrue(testGame.makeMove('X',0,1), "assert3");
        assertTrue(testGame.makeMove('O',0,2), "assert4");
        assertTrue(testGame.makeMove('O',1,0), "assert5");
        assertTrue(testGame.makeMove('O',1,1), "assert6");
        assertTrue(testGame.makeMove('O',1,2), "assert7");
        assertTrue(testGame.makeMove('O',2,0), "assert8");
        assertTrue(testGame.makeMove('O',2,1), "assert9");
        assertTrue(testGame.makeMove('X',2,2), "assert10");
        assertTrue(testGame.isBoardFull(), "assert11");
    }

    @Test
    public void shouldCheckIfSomeoneWon(){
        // filling up the board and checking win condition in some situations
        TicTacToe testGame1 = new TicTacToe();
        assertFalse(testGame1.checkWinCon(), "wincon 1");
        testGame1.makeMove('X',0,0);
        testGame1.makeMove('X',1,0);
        testGame1.makeMove('X',2,0);
        assertFalse(testGame1.checkWinCon(), "wincon 2");
        testGame1.makeMove('O',0,2);
        testGame1.makeMove('O',1,2);
        assertTrue(testGame1.checkWinCon(), "wincon 3");
        testGame1.makeMove('O',2,2);
        testGame1.makeMove('X',0,1);
        testGame1.makeMove('O',1,1);
        testGame1.makeMove('X',2,1);
        assertTrue(testGame1.checkWinCon(), "wincon 4");
    }

    @Test
    public void shouldChangeTheActivePlayer(){
        TicTacToe testGame = new TicTacToe();
        char oldPlayer;
        // Checking if the active player changed
        oldPlayer = testGame.getActivePlayerChar();
        testGame.changePlayer();
        assertTrue(oldPlayer != testGame.getActivePlayerChar());
    }

}

