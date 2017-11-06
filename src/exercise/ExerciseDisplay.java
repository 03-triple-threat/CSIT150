package exercise;

import  javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ExerciseDisplay extends JPanel {

    private ExerciseGame game;
    private final int START_X = 200;
    private final int START_Y = 100;
    private final int START_Width = 50;
    private final int START_Height= 100;

    public void  paintComponent (Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        g.fillOval(game.getCircleX(), game.getCircleY(), game.getCircleWidth(), game.getCircleHeight());
        g.setColor(Color.BLACK);
        g.drawOval(game.getCircleX(), game.getCircleY(), game.getCircleWidth(), game.getCircleHeight());
    }

    public ExerciseDisplay() {
        this.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent me) {
                game.processMove(me.getX() - 50, me.getY() - 50);
                System.err.print("\n mouse clicked");
                repaint();
            }

            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e){}
        });

        game = new ExerciseGame(START_X, START_Y, START_Width, START_Height);
    }
}
