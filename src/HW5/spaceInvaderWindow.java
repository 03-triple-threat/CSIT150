package HW5;


import javax.swing.*;

public class spaceInvaderWindow extends JFrame {

    private int startX = 1000;
    private int startY = 1000;


    /**
     * Constructor
     */
    public spaceInvaderWindow() {

        setTitle("Space Invaders!");
        spaceInvaderDisplay test = new spaceInvaderDisplay(startX,startY);
        add(test);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(startX, startY);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                spaceInvaderWindow sIWin = new spaceInvaderWindow();
            }
        });
    }
}
