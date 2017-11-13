package HW2;

public abstract class FacingRobot {

    protected int currentRow;
    protected int currentCol;
    protected Maze mazeTest;

    public FacingRobot (Maze maze){

        mazeTest = maze;
        currentRow = mazeTest.getStartRow();
        currentCol = mazeTest.getStartCol();

        mazeTest.setCell(currentRow, currentCol, 'r');
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
