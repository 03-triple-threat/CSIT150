package HW2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Maze {

    char[][] maze;
    int rows;
    int cols;
    int startPoint1;
    int startPoint2;
    int endPoint1;
    int endPoint2;


    public Maze(File fileName) throws IOException {

        Scanner inputScanner = new Scanner(fileName);

        while (inputScanner.hasNext()) {
            rows = inputScanner.nextInt();
            cols = inputScanner.nextInt();
            inputScanner.nextLine();
            startPoint1 = inputScanner.nextInt();
            startPoint2 = inputScanner.nextInt();
            inputScanner.nextLine();
            endPoint1 = inputScanner.nextInt();
            endPoint2 = inputScanner.nextInt();
            inputScanner.nextLine();
            maze = new char[rows][cols];

            for (int i = 0; i < rows; i++) {
                String line = inputScanner.nextLine();
                for (int j = 0; j < cols; j++) {
                    maze[i][j] = line.charAt(j);
                }
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public int getStartRow() {
        return startPoint1;
    }

    public int getStartCol() {
        return startPoint2;
    }

    public int getExitRow() {
        return endPoint1;
    }

    public int getExitCol() {
        return endPoint2;
    }

    public char getCell(int row, int col) {
        return maze[row][col];
    }

    public boolean openCell(int row, int col) {

        //Validate row/col is within boundaries
        boolean freeCell = false;

        if (row < 0 || row >= getRows() || col < 0 || col >= getCols()) {
            return freeCell;
        } else {
            if (maze[row][col] != '*') {
                freeCell = true;
            } else {
                freeCell = false;
            }
            return freeCell;
        }
    }

    //Validate that openCell is true before setting Cell
    public void setCell(int row, int col, char newCh) {

        if (openCell(row, col)) {
            maze[row][col] = newCh;
        }
    }

    public String toString() {

        String mazeOutput = "";

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                mazeOutput += maze[i][j];
            }
            mazeOutput += "\n";
        }
        return mazeOutput;
    }
}
