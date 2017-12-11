package HW5;

import java.awt.*;

public class Invaders {

    public static int shipWidth = 25;
    public static int shipHeight = 25;

    private int leftPos = 0;
    private int heiPos = 0;

    private boolean shipHit = false;

    public boolean hasBeenHit(){return shipHit;}

    public void setShipPos(int x, int y) {
        leftPos = x;
        heiPos = y;
    }

    public int getxPos(){return leftPos;}

    public int getyPos(){return heiPos;}

    public boolean invaderShot(int x, int y) {
        if (shipHit) {
            return false;
        }

        if((x>=leftPos) && (x<=(leftPos+shipWidth))) {
            if((y>=heiPos) && (y<=(heiPos+shipHeight))) {
                shipHit = true;
                return true;
            }
        }
        return false;
    }

    public void drawInvaders(Graphics g) {
        if(!shipHit){
            g.setColor(Color.GREEN);
            g.fillRect(leftPos, heiPos, shipWidth, shipHeight);
        }
    }
}

