package HW4;

import javax.swing.*;
import java.awt.*;

public class Connect4Window extends JFrame {

    int titleBarHeight = 20;
    Connect4GameBoardDisplay board;
    JTextField rowCountTxt;

    /**
     * Constructor
     */

    public Connect4Window(){
        this.setTitle("Connect 4");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        board = new Connect4GameBoardDisplay(8, 8);
        int width = board.getSize().width;
        int height = board.getSize().height+titleBarHeight+80;
        this.setSize(width, height);
        this.add(board, BorderLayout.CENTER);
        initButs();
        this.setVisible(true);
    }

    public void initButs() {
        JPanel butPan = new JPanel(new GridLayout(8,8));
        JPanel topPan = new JPanel();
        JPanel botPan = new JPanel();

        butPan.add(topPan);
        butPan.add(botPan);

        JLabel rowCountLab = new JLabel("Cells per side: ");
        topPan.add(rowCountLab);
        rowCountTxt = new JTextField("8");
        topPan.add(rowCountTxt);
        JButton rowCountBut = new JButton("Set New Row-Columns");
        botPan.add(rowCountBut);

        rowCountBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent me) {
                rowButClicked(me);
            }
        });

        this.add(butPan, BorderLayout.SOUTH);
    }

    public void rowButClicked(MouseEvent me) {
        board.setDimensions(Integer.parseInt(rowCountTxt.getText()));
    }

    public static void main(String[] args) {
        Connect4Window c4 = new Connect4Window();
    }
}
