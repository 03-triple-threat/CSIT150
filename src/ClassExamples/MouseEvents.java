package ClassExamples;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

/**
 * Show mouse events as they occur
 * As you use the mouse to move, click, drag, release,etc,
 * the corresponding text will be highlighted in yellow.
 */
public class MouseEvents extends JFrame
{
    private JTextField[] mouseStates;
    private JPanel topPanel;
    private JPanel mouseStatePanel;
    private JPanel bottomPanel;

    /**
     * Create the interface, and hook it up with the mouse listener
     */
    public MouseEvents() {

        setTitle("Show mouse events as they occur");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the layout of the window
        setLayout(new BorderLayout());
        setSize(1000, 1000);
        topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(5,1));
        JLabel myLabel = new JLabel ("Keep your mouse in this text box.");
        JLabel myLabel1 = new JLabel("As you use the mouse to move,");
        JLabel myLabel2 = new JLabel ("click, drag, release,etc");
        JLabel myLabel3 = new JLabel("the corresponding operation below");
        JLabel myLabel4 = new JLabel("will be highlighted in yellow.");
        topPanel.add(myLabel);
        topPanel.add(myLabel1);
        topPanel.add(myLabel2);
        topPanel.add(myLabel3);
        topPanel.add(myLabel4);
        add(topPanel, BorderLayout.NORTH);

        mouseStatePanel = new JPanel();
        mouseStatePanel.setLayout(new GridLayout(8,1));
        // Create the array of text fields.
        String[] text = {"Pressed", "Clicked", "Released",
                "Entered", "Exited", "Dragged",
                "X:", "Y:" };
        mouseStates = new JTextField[8];
        for (int i = 0; i < mouseStates.length; i++) {
            mouseStates[i] = new JTextField(text[i], 10);
            mouseStates[i].setEditable(false);
            mouseStatePanel.add(mouseStates[i],BorderLayout.CENTER);
        }

        add(mouseStatePanel,BorderLayout.CENTER);
        // Add a mouse listener to this program.
        addMouseListener(new MyMouseListener());
        // Add a mouse motion listener to this program.
        addMouseMotionListener(new MyMouseMotionListener());

        bottomPanel = new JPanel();
        bottomPanel.setSize(400, 400);
        bottomPanel.setLayout(new BorderLayout());
        JTextArea myArea = new JTextArea(20,1);
        bottomPanel.add(myArea,BorderLayout.EAST);
        add(bottomPanel,BorderLayout.SOUTH);
        pack();
    }

    /**
     * Reset the background of all text fields to be gray
     */
    public void clearTextFields() {
        for (int i = 0; i < 6; i++)
            mouseStates[i].setBackground(Color.lightGray);
    }

    /**
     * Response to mouse events
     */
    private  class MyMouseListener implements MouseListener {
        public void mousePressed(MouseEvent e) {
            clearTextFields();
            mouseStates[0].setBackground(Color.yellow);
        }

        public void mouseClicked(MouseEvent e) {
            clearTextFields();
            mouseStates[1].setBackground(Color.yellow);
        }

        public void mouseReleased(MouseEvent e) {
            clearTextFields();
            mouseStates[2].setBackground(Color.yellow);
        }

        public void mouseEntered(MouseEvent e) {
            clearTextFields();
            mouseStates[3].setBackground(Color.yellow);
        }

        public void mouseExited(MouseEvent e) {
            clearTextFields();
            mouseStates[4].setBackground(Color.yellow);
        }
    }

    /**
     * Response to mouse motion events
     */
    private class MyMouseMotionListener implements MouseMotionListener {
        public void mouseDragged(MouseEvent e) {
            clearTextFields();
            mouseStates[5].setBackground(Color.yellow);
        }

        public void mouseMoved(MouseEvent e) {
            mouseStates[6].setText("X: " + e.getX());
            mouseStates[7].setText("Y: " + e.getY());
        }
    }
    public static void main(String[] args)
    {
        MouseEvents me = new MouseEvents();
        me.setVisible(true);

    }
}
