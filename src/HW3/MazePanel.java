package HW3;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class MazePanel extends JPanel {

    private Maze course;
    private Robot bot;
    private int rows;
    private int cols;
    private final int CELL_SIZE = 25;
    private final int BOT_SIZE = 15;

    public void setMaze(Maze inMaze){
        course = inMaze;
    }

    public void setRobot(Robot inRobot){
        bot = inRobot;
    }

    public int getRows() {return course.getRows();}

    public int getCols() {return course.getCols();}

    /**
     * Constructor
     */
    public MazePanel() {}


    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if(course != null) {
            for(int r = 0; r < course.getRows(); r++) {
                for(int c = 0; c < course.getCols(); c++) {
                    char cell = course.getCell(r, c);
                    if(cell == '*'){
                        g.setColor(Color.BLACK);
                        g.fillRect(c * CELL_SIZE, r *CELL_SIZE, CELL_SIZE, CELL_SIZE);
                    } else if(cell == ' ') {
                        g.setColor(Color.WHITE);
                        g.fillRect(c * CELL_SIZE, r *CELL_SIZE, CELL_SIZE, CELL_SIZE);
                    } else if(cell == 'S') {
                        g.setColor(Color.GREEN);
                        g.fillRect(c * CELL_SIZE, r *CELL_SIZE, CELL_SIZE, CELL_SIZE);
                    } else if(cell == 'X') {
                        g.setColor(Color.RED);
                        g.fillRect(c * CELL_SIZE, r *CELL_SIZE, CELL_SIZE, CELL_SIZE);
                    }
                }
            }
        }

        if(bot != null){
            g.setColor(Color.BLUE);
            g.fillRect(bot.currentCol, bot.currentRow, BOT_SIZE, BOT_SIZE);
        }


    }
}
