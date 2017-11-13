package HW3;

public class LookAheadRobot extends FacingRobot {

    int face;

    /**
     * Constructor for the LookAheadRobot. This class inherits from the FacingRobot class
     * @param maze
     */
    public LookAheadRobot(Maze maze) {
        super(maze);

        face = 2;
    }

    /**
     * This method determines the next direction the LookAheadRobot will move to next.
     * The robot will look to go straight as long as it can, if the robot cannot continue
     * straight, it will look to go right. If it cannot go right, it will look to go left,
     * and if it cannot go left, it will go backwards as a last resort.
     * @return
     */
    public int chooseMoveDirection() {

        if (face == 2) {
            if (mazeTest.openCell(currentRow + 1, currentCol)) {
                face = 2;
            } else if (mazeTest.openCell(currentRow, currentCol - 1)) {
                face = 3;
            } else if (mazeTest.openCell(currentRow, currentCol + 1)) {
                face = 1;
            } else if (mazeTest.openCell(currentRow - 1, currentCol)) {
                face = 0;
            }
        } else if (face == 3) {
            if (mazeTest.openCell(currentRow, currentCol - 1)) {
                face = 3;
            } else if (mazeTest.openCell(currentRow - 1, currentCol)) {
                face = 0;
            } else if (mazeTest.openCell(currentRow + 1, currentCol)) {
                face = 2;
            } else if (mazeTest.openCell(currentRow, currentCol + 1)) {
                face = 1;
            }
        } else if (face == 0) {
            if (mazeTest.openCell(currentRow - 1, currentCol)) {
                face = 0;
            } else if (mazeTest.openCell(currentRow, currentCol + 1)) {
                face = 1;
            } else if (mazeTest.openCell(currentRow, currentCol - 1)) {
                face = 3;
            } else if (mazeTest.openCell(currentRow + 1, currentCol)) {
                face = 2;
            }
        } else if (face == 1) {
            if (mazeTest.openCell(currentRow, currentCol + 1)) {
                face = 1;
            } else if (mazeTest.openCell(currentRow + 1, currentCol)) {
                face = 2;
            } else if (mazeTest.openCell(currentRow - 1, currentCol)) {
                face = 0;
            } else if (mazeTest.openCell(currentRow, currentCol - 1)) {
                face = 3;
            }
        }

        return face;
    }

    /**
     * This method moves the robot in the direction determined in the
     * chooseMoveDirection method.
     * @param direction
     * @return
     */
    public boolean move(int direction) {
        boolean robotMove = false;


        switch (direction) {
            case 0:
                if (mazeTest.openCell(currentRow - 1, currentCol)) {
                    mazeTest.setCell(currentRow, currentCol, ' ');
                    currentRow--;
                    mazeTest.setCell(currentRow, currentCol, 'r');
                    robotMove = true;
                    move(direction);
                }
                break;
            case 1:
                if (mazeTest.openCell(currentRow, currentCol + 1)) {
                    mazeTest.setCell(currentRow, currentCol, ' ');
                    currentCol++;
                    mazeTest.setCell(currentRow, currentCol, 'r');
                    robotMove = true;
                    move(direction);
                }
                break;
            case 2:
                if (mazeTest.openCell(currentRow + 1, currentCol)) {
                    mazeTest.setCell(currentRow, currentCol, ' ');
                    currentRow++;
                    face = 2;
                    mazeTest.setCell(currentRow, currentCol, 'r');
                    robotMove = true;
                    move(direction);
                }
                break;
            case 3:
                if (mazeTest.openCell(currentRow, currentCol - 1)) {
                    mazeTest.setCell(currentRow, currentCol, ' ');
                    currentCol--;
                    mazeTest.setCell(currentRow, currentCol, 'r');
                    robotMove = true;
                    move(direction);
                }
                break;
        }
        return robotMove;
    }
}
