package HW2;

/**
 * Created by ajhurtado3 on 11/2/17.
 */
public abstract class Robot {

    private int currentRow;
    private int currentCol;

    public Robot (Maze maze) {

//        Robot r = new Robot(maze);
    }

    public abstract int chooseMoveDirection();

    public abstract boolean move(int direction);
    
//    public boolean solved() {}

}
