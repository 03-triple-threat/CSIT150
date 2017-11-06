package exercise;

public class ExerciseGame {

    private int circleX = 200;
    private int circleY = 100;
    private int circleWidth = 50;
    private int circleHeight = 100;

    public int getCircleX() {
        return circleX;
    }

    public int getCircleY() {
        return circleY;
    }

    public int getCircleWidth() {
        return circleWidth;
    }

    public int getCircleHeight() {
        return circleHeight;
    }

    public void setCircleX(int circleX) {
        this.circleX = circleX;
    }

    public void setCircleY(int circleY) {
        this.circleY = circleY;
    }


    public void setCircleWidth(int circleWidth) {
        this.circleWidth = circleWidth;
    }

    public void setCircleHeight(int circleHeight) {
        this.circleHeight = circleHeight;
    }

    public ExerciseGame(int x, int y, int wid, int hei) {
        setCircleX(x);
        setCircleY(y);
        setCircleWidth(wid);
        setCircleHeight(hei);
    }

    public void processMove(int x, int y) {
        setCircleX(x);
        setCircleY(y);
    }

}
