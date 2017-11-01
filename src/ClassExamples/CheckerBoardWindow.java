package ClassExamples;

import javax.swing.*;
import java.awt.*;

/**
 * Shows a checkerboard with one checker
 * that can be moved anywhere on the board
 * @author harmssk
 *
 */
public class CheckerBoardWindow extends JFrame{

    private int win_width = 500;
    private int win_height = 500;
    private CheckerBoardDisplay panel;

    public CheckerBoardWindow(){
        this.setTitle("Exercise  Window");
        this.setSize(win_width,win_height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inititalizeWindow();
        this.setVisible(true);
    }

    public void inititalizeWindow()
    {
        panel = new CheckerBoardDisplay();
        this.add(panel, BorderLayout.CENTER);
    }


    public static void main(String[] args)
    {
        CheckerBoardWindow ew = new CheckerBoardWindow();
    }

}