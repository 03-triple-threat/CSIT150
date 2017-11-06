package exercise;

import oracle.jrockit.jfr.JFR;

import javax.swing.*;
import java.awt.*;

public class ExerciseWindow extends JFrame {

    private int win_width = 400;
    private int win_height = 300;
    private ExerciseDisplay panel;

    public static void main(String[] args) {
        ExerciseWindow ew = new ExerciseWindow();
    }

    public ExerciseWindow() {

        this.setTitle("Exercise Window");
        this.setSize(win_width, win_height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inititalizeWindow();
        this.setVisible(true);
    }

    public void inititalizeWindow(){
        panel = new ExerciseDisplay();
        this.add(panel, BorderLayout.CENTER);

    }

}
