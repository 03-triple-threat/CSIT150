package HW2;

public class RandomRobot extends Robot {

    /**
     * RandomRobot constructor. This inherits from the Robot class.
     * @param maze
     */
    public RandomRobot(Maze maze) {

        super(maze);

    }

    /**
     * This method overrides the abstract method in Robot class.
     * The Robot's next direction is determined at random by searching for an empty spot
     * in the array.
     * @return
     */
    public int chooseMoveDirection() {
        return (int) (Math.random() * 4);
    }

    /**
     * This method overrides the abstract method in the Robot class.
     * The Robot moves in the direction determined from the chooseMoveDirection
     * method. Before moving, the current spot is cleared.
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
