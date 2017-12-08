package HW4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Connect4Window extends JFrame {

    int titleBarHeight = 20;
    Connect4GameBoardDisplay board;
    JTextField colCountText;

    /**
     * Constructor
     */

    public Connect4Window(){
        this.setTitle("Connect 4");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        board = new Connect4GameBoardDisplay(8, 4, 1);
        int width = board.getSize().width+10000;
        int height = board.getSize().height+titleBarHeight+10000;
        this.setSize(width, height);
        this.add(board, BorderLayout.CENTER);
        initButs();
        this.setVisible(true);
    }

    public void initButs(){
        JPanel buttonPan = new JPanel(new GridLayout(4,8));
        JPanel topPan = new JPanel();
        JPanel botPan = new JPanel();

        buttonPan.add(topPan);
        buttonPan.add(botPan);

        JLabel colCountLab = new JLabel("Columns in Game: ");
        topPan.add(colCountLab);
        colCountText = new JTextField("8");
        topPan.add(colCountText);

        this.add(buttonPan, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        Connect4Window c4 = new Connect4Window();
    }
}
