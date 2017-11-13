package HW3;

public class RightHandRobot extends FacingRobot {

    int face;

    /**
     * Constructor for the RightHandRobot. This class inherits from the Robot class.
     * @param maze
     */
    public RightHandRobot(Maze maze) {
        super(maze);

        face = 2;

    }

    /**
     * The Robot's direction is determined by first checking the spot to the right of the
     * direction it is facing, if that spot is taken, the robot checks the spot to the right of that,
     * and so on until it finds an empty spot to move.
     * @return
     */
    public int chooseMoveDirection() {

        if (face == 2) {
            if (mazeTest.openCell(currentRow, currentCol - 1)) {
                face = 3;
            } else if (mazeTest.openCell(currentRow + 1, currentCol)) {
                face = 2;
            } else if (mazeTest.openCell(currentRow, currentCol + 1)) {
                face = 1;
            } else if (mazeTest.openCell(currentRow - 1, currentCol)) {
                face = 0;
            }

        } else if (face == 3) {
            if (mazeTest.openCell(currentRow - 1, currentCol)) {
                face = 0;
            } else if (mazeTest.openCell(currentRow, currentCol - 1)) {
                face = 3;
            } else if (mazeTest.openCell(currentRow + 1, currentCol)) {
                face = 2;
            } else if (mazeTest.openCell(currentRow, currentCol + 1)) {
                face = 1;
            }
        } else if (face == 0)

        {
            if (mazeTest.openCell(currentRow, currentCol + 1)) {
                face = 1;
            } else if (mazeTest.openCell(currentRow - 1, currentCol)) {
                face = 0;
            } else if (mazeTest.openCell(currentRow, currentCol - 1)) {
                face = 3;
            } else if (mazeTest.openCell(currentRow + 1, currentCol)) {
                face = 2;
            }
        } else if (face == 1)

        {
            if (mazeTest.openCell(currentRow + 1, currentCol)) {
                face = 2;
            } else if (mazeTest.openCell(currentRow, currentCol + 1)) {
                face = 1;
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
                    //move(direction);
                }
                break;
            case 1:
                if (mazeTest.openCell(currentRow, currentCol + 1)) {
                    mazeTest.setCell(currentRow, currentCol, ' ');
                    currentCol++;
                    mazeTest.setCell(currentRow, currentCol, 'r');
                    robotMove = true;
                }
                break;
            case 2:
                if (mazeTest.openCell(currentRow + 1, currentCol)) {
                    mazeTest.setCell(currentRow, currentCol, ' ');
                    currentRow++;
                    face = 2;
                    mazeTest.setCell(currentRow, currentCol, 'r');
                    robotMove = true;
                }
                break;
            case 3:
                if (mazeTest.openCell(currentRow, currentCol - 1)) {
                    mazeTest.setCell(currentRow, currentCol, ' ');
                    currentCol--;
                    mazeTest.setCell(currentRow, currentCol, 'r');
                    robotMove = true;
                }
                break;
        }
        return robotMove;
    }

}
