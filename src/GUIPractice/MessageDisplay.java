package GUIPractice;

import javax.swing.*;
import java.awt.event.*;

public class MessageDisplay extends JFrame{

    private JPanel panel;
    private JLabel messageLabel;
    private JTextField messageTxtField;
    private JButton button;
    private final int WINDOW_WID = 500;
    private final int WINDOW_HEI = 500;

    /**
     * Constructor
     */
    public MessageDisplay() {
        //Set the window title
        setTitle("Greeting");

        //set the size of window
        setSize(WINDOW_WID, WINDOW_HEI);

        //specify what happens when you close
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Build the panel
        buildPanel();

        //Add the panel to the frame's content pane
        add(panel);

        //display the window
        setVisible(true);

    }

    private void buildPanel() {
        //Create a label to display instructions
        messageLabel = new JLabel("Enter your name");

        //Chreate a text field 10 characters wide
        messageTxtField = new JTextField(10);

        //Create a button witht he caption "Greeting"
        button = new JButton("Greeting");

        //Add actionListener to Greeting button
        button.addActionListener(new ButtonListener());

        //Create a Jpanel object and let the panel field reference it
        panel = new JPanel();

        //add the label, text field, and button to the panel
        panel.add(messageLabel);
        panel.add(messageTxtField);
        panel.add(button);
    }

    private class ButtonListener implements ActionListener {
        /**
         * Action is performed when "greeting" button is clicked"
         */

        public void actionPerformed(ActionEvent e) {

            String input;

            input = messageTxtField.getText();

            JOptionPane.showMessageDialog(null, "Oh hi " + messageTxtField);
        }
    }

    public static void main(String[] args) {
        new MessageDisplay();
    }
}
