package HW5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.security.Key;

public class spaceInvaderDisplay extends JPanel implements ActionListener, KeyListener {

    Timer t = new Timer(5, this);

    int player = 310;

    int maxX, maxY, minX, minY;
    int x = 0, y = 0, velx = 0, vely = 0;
    int step = 1;
    int ballSize = 40;

    /**
     * Constructor
     */
    public spaceInvaderDisplay(int x, int y) {
        maxX = x;
        minX = 0;
        minY = 0;
        maxY = y;

        t.start();

        this.addKeyListener(this);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("Click arrow keys to start ball and change direction!!", 200, 200);
        Graphics2D g2 = (Graphics2D) g;
        g2.fillRect(x, 902, 100, 50);
    }

    public void right() {
        vely = minY;
        velx = step;
    }

    public void left() {
        vely = minY;
        velx = -step;
    }


    //Attempt at boundaries
    public void checkOOB() {
        if (x < 0)
            x = 0;
        if (x > 880)
            x = 880;
        if (y < 0)
            y = 0;
        if (y > 368)
            y = 368;
    }

    public void actionPerformed(ActionEvent ae) {
        repaint();
        x += velx;
        y += vely;
        if (x > maxX)
            x = minX;
        if (x < minX - ballSize)
            x = maxX;
        if (y > maxY)
            y = minY;

        if (y < minY - ballSize)
            y = maxY;
        checkOOB();
    }

    public void keyPressed(KeyEvent ke) {
        int code = ke.getKeyCode();
        if (code == KeyEvent.VK_RIGHT) {
            if (x >= 1000) {
                x = 1000;
            } else {
                right();
            }
        }
        if (code == KeyEvent.VK_LEFT) {
            if (x < 10) {
                x = 02;
            } else {
                left();
            }
        }
    }

    public void keyReleased(KeyEvent ke) {
    }

    public void keyTyped(KeyEvent ke) {
    }
}

