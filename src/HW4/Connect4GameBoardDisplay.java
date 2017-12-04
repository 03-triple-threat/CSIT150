package HW4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Connect4GameBoardDisplay extends JPanel {

    private int dimensions;
    private int cellWid = 50;
    int width;
    int height;
    Con4Game game;
    int[] selectedCol;
    Font font;
    Color[] colors, chColors;

    public Connect4GameBoardDisplay(int d, int c) {
        dimensions = d;
        colors = new Color[2];
        colors[0] = Color.RED;
        colors[1] = Color.BLACK;
        font = new Font("Arial", Font.BOLD, 8);

        chColors = new Color[2];
        chColors[0] = new Color(200, 0, 33);
        chColors[1] = new Color(100,100,100);

        width = dimensions*cellWid;
        height = dimensions *cellWid;
        game = new Con4Game(d, c);

        this.setSize(width, height);

        this.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pieceSelected(evt);
            }
            public void mouseRelated(java.awt.event.MouseEvent evt) {
                pieceMoved(evt);
            }
        });
    }

    public int[] calculateCol (int x, int y){
        int col = (x - x%cellWid/cellWid);
        int row = (y - y%cellWid/cellWid);
        int[] coor = {row, col};
        return coor;
    }

    public void pieceSelected(MouseEvent me) {
        selectedCol = calculateCol(me.getX(), me.getY());
        game.markSelectedToken(selectedCol[0], selectedCol)
    }
}
