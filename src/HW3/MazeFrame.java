package HW3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

public class MazeFrame extends JFrame {

    private File inputFile;
    private Maze mazeWin;
    private Robot botWindow;
    private MazePanel panel;
    private boolean botRunning;

    private int CELL_SIZE = 25;

    JMenuItem fileSolveMenuItem;
    JMenuItem fileExitMenuItem;
    JMenuItem loadMazeMenuItem;
    JMenuItem loadRobotMenuItem;
    JMenuItem loadFacingRobotMenuItem;
    JMenuItem loadLeftHandRobotMenuItem;
    JMenuItem loadRightHandRobotMenuItem;
    JMenuItem loadLookAheadRobotMenuItem;
    JMenuItem loadRandomRobotMenuItem;

    MazeFrame() {

        setTitle("Maze Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create the menu bar and set in window
        JMenuBar bar = buildMenuBar();
        setJMenuBar(bar);

        //Set the Solve button to disabled until maze/robot is loaded
        fileSolveMenuItem.setEnabled(false);

        //Set the layout of the window
        setLayout(new BorderLayout());

        //Show the window
        pack();
        setVisible(true);
    }

    /**
     * Create a menu bar
     *
     */
    private JMenuBar buildMenuBar(){
        //Create a menu bar
        JMenuBar menuBar = new JMenuBar();

        //Call buildFileMenu() to create a menu and and it into the menu bar
        JMenu fileMenu = buildFileMenu();
        menuBar.add(fileMenu);

        //put space between the File and the Maze menus
        Label whiteSpace = new Label(" ");
        menuBar.add(whiteSpace);

        //Create the Maze menu
        JMenu mazeMenu = buildMazeMenu();
        menuBar.add(mazeMenu);

        //put space between Maze / Robot Menus
        Label whiteSpace2 = new Label(" ");
        menuBar.add(whiteSpace2);

        //Create the Robot Menu
        JMenu robotMenu = buildRobotMenu();
        menuBar.add(robotMenu);

        return menuBar;
    }

    /**
     * Create the File Menu
     *
     * @return the created File menu
     */
    private JMenu buildFileMenu(){
        //Create
        JMenu fileMenu = new JMenu("File");

        //Create the menu items
        fileSolveMenuItem = new JMenuItem("Solve");
        fileExitMenuItem = new JMenuItem("Exit");

        //Add the menu items into the fileMenu
        fileMenu.add(fileSolveMenuItem);
        fileMenu.add(fileExitMenuItem);

        //Hook up the menu items with the listener
        MyListener listener = new MyListener();
        fileExitMenuItem.addActionListener(listener);
        fileSolveMenuItem.addActionListener(listener);

        return fileMenu;
    }

    /**
     * Creates the Maze Menu
     *
     * @return the created Maze menu
     */
    private JMenu buildMazeMenu(){
        //Create
        JMenu mazeMenu = new JMenu("Maze");

        //Create the menu items
        loadMazeMenuItem = new JMenuItem("Load Maze");

        //Add the menu item into the mazeMenu
        mazeMenu.add(loadMazeMenuItem);

        //Hook up ht e menu items with the listener
        MyMazeListener mazeListener = new MyMazeListener();
        loadMazeMenuItem.addActionListener(mazeListener);

        return mazeMenu;
    }

    private JMenu buildRobotMenu(){
        //Create
        JMenu robotMenu = new JMenu("Robot");

        //Create the menu items
        loadRobotMenuItem = new JMenuItem("Robot");
        loadFacingRobotMenuItem = new JMenuItem("Facing Robot");
        loadLeftHandRobotMenuItem = new JMenuItem("Left Hand Robot");
        loadRightHandRobotMenuItem = new JMenuItem("Right Hand Robot");
        loadLookAheadRobotMenuItem = new JMenuItem("Look Ahead Robot");
        loadRandomRobotMenuItem = new JMenuItem("Random Robot");

        //Hook up the menu items with the listener
        MyRobotListener robotListener = new MyRobotListener();
        loadRobotMenuItem.addActionListener(robotListener);
        loadFacingRobotMenuItem.addActionListener(robotListener);
        loadLeftHandRobotMenuItem.addActionListener(robotListener);
        loadRightHandRobotMenuItem.addActionListener(robotListener);
        loadLookAheadRobotMenuItem.addActionListener(robotListener);
        loadRandomRobotMenuItem.addActionListener(robotListener);

        return robotMenu;
    }


    private class MyListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == fileExitMenuItem)
                System.exit(0);
            else (e.getSource() == fileSolveMenuItem) {
                //add code
            }
        }
    }

    private class MyMazeListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == loadMazeMenuItem) {
            }
        }
    }

    private class MyRobotListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == loadRobotMenuItem) {
                //Add code
            } else if(e.getSource() == loadFacingRobotMenuItem) {
                //add Code
            } else if(e.getSource() == loadLeftHandRobotMenuItem) {
                //add code
            } else if(e.getSource() == loadRightHandRobotMenuItem) {
                //add code
            } else if(e.getSource() == loadLookAheadRobotMenuItem) {
                //add code
            } else if(e.getSource() == loadRandomRobotMenuItem) {
                //add code
            }
        }
    }
}
