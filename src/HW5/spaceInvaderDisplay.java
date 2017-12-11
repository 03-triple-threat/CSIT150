package HW5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class spaceInvaderDisplay extends JPanel implements ActionListener, KeyListener {

    Timer t = new Timer(5, this);

    int player = 310;

    int maxX, maxY, minX, minY;
    int x = 0, y = 0, velx = 0, vely = 0;
    int step = 1;
    int ballSize = 40;
    int totalShips = 15;

    private invaderFleet bots;

    /**
     * Constructor
     */
    public spaceInvaderDisplay(int x, int y) {
        maxX = x;
        minX = 0;
        minY = 0;
        maxY = y;

        t.start();

        bots = new invaderFleet();

        this.addKeyListener(this);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

//        Graphics2D g2 = (Graphics2D) g;

        //background
//        g.fillRect(1,1,1000,1000);

        bots.drawFleet(g);

//        //Paddle
//        g2.setColor(Color.red);
//        g.fillRect(x, 902, 100, 50);
//
//        //bullets
//        g2.setColor(Color.BLUE);
//        g2.fillOval(250,250,20,20);
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
        if (code == KeyEvent.VK_SPACE) {
            //TODO - uncomment
            //shootBullet();
        }
    }

    public void keyReleased(KeyEvent ke) {
    }

    public void keyTyped(KeyEvent ke) {
    }
}

