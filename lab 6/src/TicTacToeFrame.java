import javax.swing.*;
import java.awt.*;

public class TicTacToeFrame extends JFrame implements TicTacToeView{

    private JButton[][] buttons;

    public  TicTacToeFrame(){
        super("Tic Tac Toe");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(TicTacToeModel.SIZE, TicTacToeModel.SIZE));
        TicTacToeModel tttm = new TicTacToeModel();
        tttm.addTicTacToeView(this);
        TicTacToeController tttc = new TicTacToeController(tttm);
        buttons = new JButton[TicTacToeModel.SIZE][TicTacToeModel.SIZE];
        for(int i=0; i < TicTacToeModel.SIZE; i++){
            for(int j=0; j<TicTacToeModel.SIZE; j++){
                JButton b = new JButton(" ");
                int x = i;
                int y = j;
                buttons[i][j] = b;
                b.addActionListener(new TicTacToeController(tttm));
                b.setActionCommand(i + " " + j);
                this.add(b);
            }
        }
        this.setSize(300, 300);
        this.setVisible(true);
    }

    /**
     * handles updates from model
     * @param e the event
     */
    @Override
    public void handleTicTacToeUpdate(TicTacToeEvent e){
        int x = e.getX();
        int y = e.getY();
        TicTacToeModel tttm = (TicTacToeModel) e.getSource();
        String label = tttm.getTurn()? "X" : "O";
        buttons[x][y].setText(label);
        if (tttm.getStatus() != TicTacToeModel.Status.UNDECIDED){
            String result = "";
            if(tttm.getStatus() == TicTacToeModel.Status.X_WON){
                result = "X Wins!";
            }
            if(tttm.getStatus() == TicTacToeModel.Status.O_WON){
                result = "O Wins!";
            }
            if(tttm.getStatus() == TicTacToeModel.Status.TIE){
                result = "It's a tie!";
            }
            JOptionPane.showMessageDialog(this,"Game Over! " + result);
            this.dispose();
        }
    }

    public static void main(String[] args) {
        new TicTacToeFrame();
    }
}
