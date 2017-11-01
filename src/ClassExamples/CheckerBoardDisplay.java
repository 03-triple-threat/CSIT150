package ClassExamples;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

/**
 * This program draws a checkerboard of red and black squares
 * along with one green checker.
 * @author harmssk
 *
 */
public class CheckerBoardDisplay extends JPanel {

    private  int startX = 50;
    private  int startY = 50;
    private  int cellWid = 50;
    private final int cellHei= 50;

    private int  rows = 8;
    private int  columns = 8;

    private int row, col;//change based on user's click

    public CheckerBoardDisplay()
    {
        /**
         * Figure out where the mouse was clicked so
         * we can draw the checker there
         */
        this.addMouseListener(new MouseListener(){

            public void mouseClicked(MouseEvent me)
            {
                interpretClick( me);
            }
            public void mousePressed(MouseEvent me){}
            public void mouseReleased(MouseEvent me){}
            public void mouseEntered(MouseEvent me){}
            public void mouseExited(MouseEvent me){}
        });
    }

    public void interpretClick(MouseEvent me)
    {
        int clickedX = me.getX();
        int clickedY = me.getY();
        row = (clickedY -startY)/cellHei;
        col = (clickedX -startX)/cellWid;
        repaint();
    }

    public void paintComponent(Graphics g)
    {
        for(int r = 0; r< rows; r++)
        {
            for(int c = 0; c< columns; c++)
            {
                g.setColor(Color.BLACK);
                if((r+c)%2 == 0)
                    g.setColor(Color.RED);
                g.fillRect(startX+c*cellWid,startX+r*cellHei ,cellWid, cellHei );
            }
        }
        //draw the checker where the user clicks
        g.setColor(Color.GREEN);
        g.fillOval(startX+col*cellWid,startX+row*cellHei ,cellWid, cellHei );
    }




}