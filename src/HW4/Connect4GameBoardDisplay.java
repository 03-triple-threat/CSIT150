package HW4;

        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.MouseEvent;
        import java.awt.event.MouseListener;

public class Connect4GameBoardDisplay extends JPanel {

    private int cellWidth = 40;
    private int dimensions;
    int width;
    int height;
    Color[] colors, chColors;
    Con4Game game;

    public Connect4GameBoardDisplay(int r, int c, int d) {

        dimensions = d;
        colors = new Color[2];
        colors[0] = Color.RED;
        colors[1] = Color.BLACK;

        width = dimensions * cellWidth;
        height = dimensions * cellWidth;
        game = new Con4Game(r, c);

        this.setSize(width, height);



    }

    public int[] calcRowCol(int x, int y) {
        int col = (x - x%cellWidth)/cellWidth;
        int row = (y - y%cellWidth)/cellWidth;
        int[] coor = {row, col};
        return coor;
    }
}
