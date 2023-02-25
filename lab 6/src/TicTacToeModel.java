import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class TicTacToeModel {


    public static final int SIZE = 3;
    public static final boolean X = true;
    public static final boolean O = false;

    public enum Status {X_WON, O_WON, TIE, UNDECIDED};

    private char[][] grid;
    private boolean turn;
    private Status status;

    private List<TicTacToeView> ticTacToeViews;


    public TicTacToeModel() {
        grid = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = ' ';
            }
        }
        turn = X;
        status = Status.UNDECIDED;

        ticTacToeViews = new ArrayList<>();

    }

    public void addTicTacToeView(TicTacToeView tttv){
        ticTacToeViews.add(tttv);
    }

    public void removeTicTacToeView(TicTacToeView tttv){
        ticTacToeViews.remove(tttv);
    }

    private void changeTurn() {
        turn = !turn;
    }

    public Status getStatus() {return status;}

    private void updateStatus() {
        if ( grid[0][0] != ' ' && grid[0][0] == (grid[0][1]) && grid[0][0] == (grid[0][2]) ){
            status = turn? Status.X_WON : Status.O_WON;
            return;
        }
        if ( grid[1][0] != ' ' && grid[1][0] == (grid[1][1]) && grid[1][1] == (grid[1][2]) ){
            status = turn? Status.X_WON : Status.O_WON;
            return;
        }
        if ( grid[2][0] != ' ' && grid[2][0] == (grid[2][1]) && grid[2][0] == (grid[2][2]) ){
            status = turn? Status.X_WON : Status.O_WON;
            return;
        }
        if ( grid[0][0] != ' ' && grid[0][0] == (grid[1][0]) && grid[0][0] == (grid[2][0]) ){
            status = turn? Status.X_WON : Status.O_WON;
            return;
        }
        if ( grid[0][1] != ' ' && grid[0][1] == (grid[1][1]) && grid[0][1] == (grid[2][1]) ){
            status = turn? Status.X_WON : Status.O_WON;
            return;
        }
        if ( grid[0][2] != ' ' && grid[0][2] == (grid[1][2]) && grid[0][2] == (grid[2][2]) ){
            status = turn? Status.X_WON : Status.O_WON;
            return;
        }
        if ( grid[0][0] != ' ' && grid[0][0] == (grid[1][1]) && grid[0][0] == (grid[2][2]) ){
            status = turn? Status.X_WON : Status.O_WON;
            return;
        }
        if ( grid[0][2] != ' ' && grid[0][2] == (grid[1][1]) && grid[0][2] == (grid[2][0]) ){
            status = turn? Status.X_WON : Status.O_WON;
            return;
        }

        int count = 0;
        for(int i=0; i < TicTacToeModel.SIZE; i++){
            for(int j=0; j<TicTacToeModel.SIZE; j++){
                if (grid[i][j] != ' '){
                    count++;
                }
            }
        }

        if (count == 9) {status = Status.TIE;}

    }

    public boolean getTurn() {return turn;}

    public void play(int x, int y) {
        if (grid[x][y] != ' ') return;
        grid[x][y] = turn? 'X' : 'O';
        updateStatus();
        for(TicTacToeView tttv: ticTacToeViews)
            tttv.handleTicTacToeUpdate(new TicTacToeEvent(this, status, x, y));
        changeTurn();
    }
}

