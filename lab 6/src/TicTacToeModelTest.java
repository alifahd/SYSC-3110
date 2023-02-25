import static org.junit.Assert.*;
import org.junit.Test;

public class TicTacToeModelTest {

    TicTacToeModel ttt;

    @Test
    public void testInitialStatus() {
        ttt = new TicTacToeModel();
        assertEquals(TicTacToeModel.Status.UNDECIDED, ttt.getStatus());
    }

    @Test
    public void testXWinStatus() {
        ttt = new TicTacToeModel();
        assertEquals(ttt.getTurn(), true);
        ttt.play(0,0);
        assertEquals(ttt.getTurn(), false);
        ttt.play(0,1);
        assertEquals(ttt.getTurn(), true);
        ttt.play(1,0);
        assertEquals(ttt.getTurn(), false);
        ttt.play(1,1);
        assertEquals(ttt.getTurn(), true);
        ttt.play(2,0);
        assertEquals(ttt.getTurn(), false);
        assertEquals(TicTacToeModel.Status.X_WON, ttt.getStatus());
    }

    @Test
    public void testOWinStatus() {
        ttt = new TicTacToeModel();
        assertEquals(ttt.getTurn(), true);
        ttt.play(0,1);
        assertEquals(ttt.getTurn(), false);
        ttt.play(0,0);
        assertEquals(ttt.getTurn(), true);
        ttt.play(1,0);
        assertEquals(ttt.getTurn(), false);
        ttt.play(1,1);
        assertEquals(ttt.getTurn(), true);
        ttt.play(2,0);
        assertEquals(ttt.getTurn(), false);
        ttt.play(2,2);
        assertEquals(ttt.getTurn(), true);
        assertEquals(TicTacToeModel.Status.O_WON, ttt.getStatus());
    }

    @Test
    public void testTieStatus() {
        ttt = new TicTacToeModel();
        assertEquals(ttt.getTurn(), true);
        ttt.play(0,0);
        assertEquals(ttt.getTurn(), false);
        ttt.play(1,1);
        assertEquals(ttt.getTurn(), true);
        ttt.play(2,2);
        assertEquals(ttt.getTurn(), false);
        ttt.play(2,1);
        assertEquals(ttt.getTurn(), true);
        ttt.play(0,1);
        assertEquals(ttt.getTurn(), false);
        ttt.play(0,2);
        assertEquals(ttt.getTurn(), true);
        ttt.play(2,0);
        assertEquals(ttt.getTurn(), false);
        ttt.play(1,0);
        assertEquals(ttt.getTurn(), true);
        ttt.play(1,2);
        assertEquals(ttt.getTurn(), false);
        assertEquals(TicTacToeModel.Status.TIE, ttt.getStatus());
    }

    @Test
    public void properTurnChange() {
        ttt = new TicTacToeModel();
        assertEquals(ttt.getTurn(), true);
        ttt.play(0,1);
        assertEquals(ttt.getTurn(), false);
        ttt.play(0,1);
        assertNotEquals(ttt.getTurn(), true);
        assertEquals(ttt.getTurn(), false);
        ttt.play(2,2);
        assertEquals(ttt.getTurn(), true);
        assertEquals(TicTacToeModel.Status.UNDECIDED, ttt.getStatus());
    }

}