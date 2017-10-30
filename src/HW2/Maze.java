package HW2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Maze {

    private double[][] maze;
    int rows;
    int cols;
    int startPoint1;
    int startPoint2;
    int endPoint1;
    int endPoint2;

    public Maze (File fileName) throws IOException {

        Scanner inputScanner = new Scanner (fileName);

        while(inputScanner.hasNext()) {
            rows = inputScanner.nextInt();
            cols = inputScanner.nextInt();
            inputScanner.hasNextLine();
            startPoint1 = inputScanner.nextInt();
            startPoint2 = inputScanner.nextInt();
            inputScanner.hasNextLine();
            endPoint1 = inputScanner.nextInt();
            endPoint2 = inputScanner.nextInt();
            inputScanner.hasNextLine();
            for (int i = 0; i < rows; i++) {
                String line = inputScanner.nextLine();
                System.out.println(line);
                for (int j = 0; j < cols; j ++) {
                    maze[i][j] = line.charAt(j);
                }
            }
        }
    }

    public int getRows() {return rows;}

    public int getCols() {return cols;}

    public int getStartRow() {return startPoint1;}

    public int getStartCol() {return startPoint2;}

    public int getExitRow() {return endPoint1;}

    public int getExitCol() {return endPoint2;}

    public char getCell(int row, int col) {}

    
}
