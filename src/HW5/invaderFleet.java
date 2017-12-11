package HW5;

import java.awt.*;


/**
 * This was my second attempt at creating a space invaders game.
 * In this class I attempted to create a separate class that creates an array of Invaders.
 * The goal of this was to get the invaders to move from the top of the window towards the bottom
 * Each row of invaders would have moved from the left side to the right, and when the invader
 * hit the boundary, the direction of the invaders would switch. The error I run into when executing
 * this class is that it run an infinite loop somewhere in the draw method.
 */
public class invaderFleet {

    //Create rows of invaders
    Invaders row1[] = new Invaders[10];
    Invaders row2[] = new Invaders[10];
    Invaders row3[] = new Invaders[10];

    //Direction fleet moves in
    private boolean movingRight = true;

    //Number of pixels to move at a time
    private int moveDist = 25;

//    createFleet();
//    setStartPos();

    private void setStartPos() {
        int rowHei = 35;
        int leftStart = 35;
        for (int i = 0; i < 10; i++) {
            row1[i].setShipPos(leftStart, rowHei);
            leftStart += 40;
        }
        rowHei += 50;
        leftStart = 35;

        for (int i = 0; i < 10; i++) {
            row2[i].setShipPos(leftStart, rowHei);
            leftStart += 40;
        }
        rowHei += 50;
        leftStart = 35;

        for (int i = 0; i < 10; i++) {
            row3[i].setShipPos(leftStart, rowHei);
            leftStart += 40;
        }
    }

    public void moveFleet() {
        if (movingRight) {
            for (int i = 9; i >= 0; i--) {
                if (!row1[i].hasBeenHit()) {
                    if (row1[i].getxPos() > (Invaders.shipWidth - 15)) {
                        movingRight = false;

                        for (int y = 0; y < 10; y++) {
                            row1[y].setShipPos(row1[y].getxPos(), row1[y].getyPos() + moveDist);
                            row2[y].setShipPos(row2[y].getxPos(), row2[y].getyPos() + moveDist);
                            row3[y].setShipPos(row3[y].getxPos(), row3[y].getyPos() + moveDist);
                        }
                        return;
                    }
                }
                if (!row2[i].hasBeenHit()) {
                    if (row2[i].getxPos() > (Invaders.shipWidth - 15)) {
                        movingRight = false;

                        for (int y = 0; y < 10; y++) {
                            row1[y].setShipPos(row1[y].getxPos(), row1[y].getyPos() + moveDist);
                            row2[y].setShipPos(row2[y].getxPos(), row2[y].getyPos() + moveDist);
                            row3[y].setShipPos(row3[y].getxPos(), row3[y].getyPos() + moveDist);
                        }
                        return;
                    }
                }
                if (!row3[i].hasBeenHit()) {
                    if (row3[i].getxPos() > (Invaders.shipWidth - 15)) {
                        movingRight = false;

                        for (int y = 0; y < 10; y++) {
                            row1[y].setShipPos(row1[y].getxPos(), row1[y].getyPos() + moveDist);
                            row2[y].setShipPos(row2[y].getxPos(), row2[y].getyPos() + moveDist);
                            row3[y].setShipPos(row3[y].getxPos(), row3[y].getyPos() + moveDist);
                        }
                        return;
                    }
                }
            }
            for (int i = 0; i < 10; i ++) {
                row1[i].setShipPos(row1[i].getxPos() + moveDist, row1[i].getyPos());
                row2[i].setShipPos(row2[i].getxPos() + moveDist, row2[i].getyPos());
                row3[i].setShipPos(row3[i].getxPos() + moveDist, row3[i].getyPos());
            }
        } else {
            for (int i = 0;  i < 10; i++) {
                if (!row1[i].hasBeenHit()){
                    if (row1[i].getxPos() < Invaders.shipWidth) {
                        movingRight = true;
                        for(int y = 0; y < 10; y++) {
                            row1[y].setShipPos(row1[y].getxPos(), row1[y].getyPos()+moveDist);
                            row2[y].setShipPos(row2[y].getxPos(), row2[y].getyPos()+moveDist);
                            row3[y].setShipPos(row3[y].getxPos(), row3[y].getyPos()+moveDist);
                        }
                        return;
                    }
                }
                if (!row2[i].hasBeenHit()){
                    if (row2[i].getxPos() < Invaders.shipWidth) {
                        movingRight = true;
                        for(int y = 0; y < 10; y++) {
                            row1[y].setShipPos(row1[y].getxPos(), row1[y].getyPos()+moveDist);
                            row2[y].setShipPos(row2[y].getxPos(), row2[y].getyPos()+moveDist);
                            row3[y].setShipPos(row3[y].getxPos(), row3[y].getyPos()+moveDist);
                        }
                        return;
                    }
                }
                if (!row3[i].hasBeenHit()){
                    if (row3[i].getxPos() < Invaders.shipWidth) {
                        movingRight = true;
                        for(int y = 0; y < 10; y++) {
                            row1[y].setShipPos(row1[y].getxPos(), row1[y].getyPos()+moveDist);
                            row2[y].setShipPos(row2[y].getxPos(), row2[y].getyPos()+moveDist);
                            row3[y].setShipPos(row3[y].getxPos(), row3[y].getyPos()+moveDist);
                        }
                        return;
                    }
                }
            }
            for (int i = 0; i < 10; i ++) {
                row1[i].setShipPos(row1[i].getxPos()-moveDist, row1[i].getyPos());
                row2[i].setShipPos(row2[i].getxPos()-moveDist, row2[i].getyPos());
                row3[i].setShipPos(row3[i].getxPos()-moveDist, row3[i].getyPos());
            }
        }
    }

    public void drawFleet(Graphics g) {
        for (int i = 0; i < 10; i++) {
            row1[i].drawInvaders(g);
            row2[i].drawInvaders(g);
            row3[i].drawInvaders(g);
        }
    }
}
