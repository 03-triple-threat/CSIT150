package HW3;

public abstract class FacingRobot extends Robot {

    int face;

    public FacingRobot (Maze maze){

        super(maze);

        face = 2;

    }

    public abstract int chooseMoveDirection();

    public abstract boolean move(int direction);

    public boolean solved() {
        boolean exit = false;

        if ((currentRow == mazeTest.getExitRow() && currentCol == mazeTest.getExitCol())) {
            exit = true;
        }
        return  exit;
    }
}
