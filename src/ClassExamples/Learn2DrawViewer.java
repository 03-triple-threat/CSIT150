package ClassExamples;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Generates the Window on which to display drawn graphics
 * Hardcoded size
 * @author canderson
 */
public class Learn2DrawViewer extends JFrame{

    int WINDOW_WIDTH = 600;
    int WINDOW_HEIGHT = 300;
    int ROWS = 1;
    int COLUMNS = 1;

    public Learn2DrawViewer()
    {
        this.setTitle("Learn to draw graphics");
        this.setLayout(new GridLayout(ROWS,COLUMNS));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Learn2DrawPanel dPanel = new Learn2DrawPanel();
        //notice: the "paint component" method is never called.
        //it is automatically called when you construct a panel.

        this.add(dPanel);

        this.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        Learn2DrawViewer myViewer = new Learn2DrawViewer();
    }
}