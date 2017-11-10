package HW2;

/**
 * The following method is an abstract method
 * that creates the robot object. It is inherited in the RandomRobot,
 * LeftHandRobot, and RightHandRobot classes.
 */
public abstract class Robot {

    protected int currentRow;
    protected int currentCol;
    protected Maze mazeTest;

    /**
     * Constructor for the Robot object
     * @param maze
     */
    public Robot (Maze maze) {

        mazeTest = maze;
        currentRow = mazeTest.getStartRow();
        currentCol = mazeTest.getStartCol();

        mazeTest.setCell(currentRow, currentCol, 'r');
    }

    /**
     * Abstract method, the Robot chooses it's next move's direction
     * @return
     */
    public abstract int chooseMoveDirection();

    /**
     * Abstract method, the Robot moves in the direction that is set in the
     * chooseMoveDirection method
     * @param direction
     * @return exit
     */
    public abstract boolean move(int direction);
    
    public boolean solved() {
        boolean exit = false;

        if ((currentRow == mazeTest.getExitRow() && currentCol == mazeTest.getExitCol())) {
            exit = true;
        }
        return  exit;
    }

}
