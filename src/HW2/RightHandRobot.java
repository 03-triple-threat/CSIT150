package HW2;

public class RightHandRobot extends Robot {

    int face;


    public RightHandRobot(Maze maze) {
        super(maze);

        face = 2;

    }

    public int chooseMoveDirection() {

        if (face == 2) {
            if (mazeTest.openCell(currentRow, currentCol - 1)) {
                face = 3;
                return face;
            } else if (mazeTest.openCell(currentRow + 1, currentCol)) {
                face = 2;
                return face;
            } else if (mazeTest.openCell(currentRow, currentCol + 1)) {
                face = 1;
                return face;
            } else if (mazeTest.openCell(currentRow - 1, currentCol)) {
                face = 0;
                return face;
            }

        } else if (face == 3) {
            if (mazeTest.openCell(currentRow - 1, currentCol)) {
                face = 0;
                return face;
            } else if (mazeTest.openCell(currentRow, currentCol - 1)) {
                face = 3;
                return face;
            } else if (mazeTest.openCell(currentRow + 1, currentCol)) {
                face = 2;
            } else if (mazeTest.openCell(currentRow, currentCol + 1)) {
                face = 1;
                return face;
            }
        } else if (face == 0)

        {
            if (mazeTest.openCell(currentRow, currentCol + 1)) {
                face = 1;
                return face;
            } else if (mazeTest.openCell(currentRow - 1, currentCol)) {
                    face = 0;
                    return face;
                }
            } else if (mazeTest.openCell(currentRow, currentCol - 1)) {
                    face = 3;
                    return face;
                }
             else if (mazeTest.openCell(currentRow + 1, currentCol)) {
                    face = 2;
                    return face;
                }
        } else if (face == 1)

        {
            if (mazeTest.openCell(currentRow + 1, currentCol)) {
                face = 2;
                return face;
            } else if (!mazeTest.openCell(currentRow + 1, currentCol)) {
                if (mazeTest.openCell(currentRow, currentCol + 1)) {
                    face = 1;
                    return face;
                }
            } else if (!(mazeTest.openCell(currentRow + 1, currentCol) && (mazeTest.openCell(currentRow, currentCol + 1)))) {
                if (mazeTest.openCell(currentRow - 1, currentCol)) {
                    face = 0;
                    return face;
                }
            } else if (!(mazeTest.openCell(currentRow + 1, currentCol) && (mazeTest.openCell(currentRow, currentCol + 1) &&
                    (mazeTest.openCell(currentRow - 1, currentCol))))) {
                face = 3;
                return face;
            }
        }
        return face;
    }

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

