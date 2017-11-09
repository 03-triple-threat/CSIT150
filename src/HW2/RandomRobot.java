package HW2;

public class RandomRobot extends Robot {

    public RandomRobot(Maze maze) {

        super(maze);

    }

    public int chooseMoveDirection() {
        return (int) (Math.random() * 4);
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
