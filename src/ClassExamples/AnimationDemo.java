package ClassExamples;

 // Creates a window to hold the board where the ball is moving


import javax.swing.*;
import java.awt.*;

public class AnimationDemo extends JFrame {

    private int WIDTH = 520;
    private int HEIGHT = 540;

    public AnimationDemo()
    {
        this.setTitle("Animation Demonstration");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);

        DrawingBoard db = new DrawingBoard();
        this.add( db, BorderLayout.CENTER);
        this.setVisible(true);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AnimationDemo ad = new AnimationDemo();
    }
}