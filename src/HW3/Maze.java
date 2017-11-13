package HW3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


/**
 * The following class creates an object Maze by reading a .txt file.
 * The file lists the number of rows/cols, the starting / ending point, and
 * a maze consisting of spaces and '*' characters
 */
public class Maze {

    char[][] maze;
    int rows;
    int cols;
    int startPoint1;
    int startPoint2;
    int endPoint1;
    int endPoint2;


    /**
     * Reads in a file and creates an array to store the maze
     * @param fileName
     * @throws IOException
     */
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

    /**
     * Accessor for number of rows in the array / maze
     * @return rows - number of rows in the array
     */
    public int getRows() {
        return rows;
    }

    /**
     * Accessor for the number of cols in the array / maze
     * @return cols - number of cols in the array
     */
    public int getCols() {
        return cols;
    }

    /**
     * Accessor for the starting row index of the array
     * @return startPoint1 - starting row index of the array
     */
    public int getStartRow() {
        return startPoint1;
    }

    /**
     * Accessor for the starting col index of the array
     * @return startPoint2 - starting col index of the array
     */
    public int getStartCol() {
        return startPoint2;
    }

    /**
     * Accessor for the ending row index of the array
     * @return endPoint1 - ending row index of the array
     */
    public int getExitRow() {
        return endPoint1;
    }

    /**
     * Accessor for the ending col index of the array
     * @return endPoint2 - ending col index of the array
     */
    public int getExitCol() {
        return endPoint2;
    }

    /**
     * Accessor for the spot the robot is sitting in the array
     * @param row
     * @param col
     * @return maze[row][col] - location of the robot
     */
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

    /**
     * Accessor that validates the next location of the robot and sets the
     * robot in that location
     * @param row
     * @param col
     * @param newCh
     */
    public void setCell(int row, int col, char newCh) {

        if (openCell(row, col)) {
            maze[row][col] = newCh;
        }
    }

    /**
     * Prints the maze out
     * @return mazeOutput - maze
     */
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