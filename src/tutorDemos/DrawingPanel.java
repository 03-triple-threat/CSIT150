package tutorDemos;

import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Graphics;

/**
 *
 * @author canderson
 */
public class DrawingPanel extends JPanel{

    int [][] circles;
    int [][] rects;
    int [][] twRects;

    public DrawingPanel(int[][] c, int [][] r, int[][] twistedR)
    {
        circles = c;
        rects = r;
        twRects = twistedR;
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        this.setBackground(Color.white);

        //  System.err.print("\ncircles length:"+circles.length+" \n");
        if(circles != null && circles.length > 0 )
            for(int dex = 0; dex < circles.length; dex++)
            {
                g.setColor(Color.black);
                g.drawOval(circles[dex][0],circles[dex][1],circles[dex][2],circles[dex][3]);
                g.setColor(new Color(circles[dex][4],circles[dex][5],circles[dex][6]));
                g.fillOval(circles[dex][0],circles[dex][1],circles[dex][2],circles[dex][3]);

            }

        if(rects != null && rects.length >0)
        {
            // System.err.print("Inside rec draw");
            for(int dex = 0; dex < rects.length; dex++)
            {

                g.setColor(new Color(rects[dex][3],rects[dex][5],rects[dex][6]));
                g.fillRect(rects[dex][0],rects[dex][1]+200,rects[dex][2],rects[dex][3]);
                g.setColor(Color.black);
                g.drawRect(rects[dex][0],rects[dex][1]+200,rects[dex][2],rects[dex][3]);
            }
        }
    }
}