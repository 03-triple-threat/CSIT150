package tutorDemos;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUIExamples extends JFrame {

    private int win_wid = 800;
    private int win_hei = 800;
    private int arraySize = 12;
    private int arraySize2 = 10;
    private JLabel[] labs;
    private JTextField[] txts;

    public GUIExamples(){

        this.setSize(win_wid, win_hei);
        this.setTitle("Gui Demo");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initNorth();
        initCenter();
        initWest();
        initSouth();

        this.setVisible(true);
    }

    private void initCenter(){

        JPanel centerPanel = new JPanel(new GridLayout(arraySize, 1));
        JLabel[] labs = new JLabel[arraySize];
        JTextField[] txts = new JTextField[arraySize];

        for(int i = 0; i < arraySize; i++){
            JPanel tempPan = new JPanel();
            labs[i] = new JLabel("Label " + (i + 1) + ": ");
            labs[i].setForeground(Color.MAGENTA);
            labs[i].setHorizontalAlignment(JLabel.RIGHT);
            txts[i] = new JTextField(20);
            tempPan.add(labs[i]);
            tempPan.add(txts[i]);
            centerPanel.add(tempPan);
        }

        this.add(centerPanel, BorderLayout.CENTER);
    }

    private void initWest(){

        JPanel westPanel = new JPanel(new GridLayout(arraySize2, 2));
        labs = new JLabel[arraySize];
        txts = new JTextField[arraySize2];
        for(int i = 0; i < arraySize2; i++){
            labs[i] = new JLabel("Label " + (i + 1) + ": ");
            txts[i] = new JTextField(20);
            westPanel.add(labs[i]);
            westPanel.add(txts[i]);
        }

        this.add(westPanel, BorderLayout.WEST);
    }

    private void initSouth(){

        JPanel southPanel = new JPanel();
        JButton but1 = new JButton("Short");
        but1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                String mess = "hello " + txts[0].getText();
                JOptionPane.showMessageDialog(null, mess, "button clicked", 1);
                txts[1].setText("You forgot to enter your last name");
            }
        });

        JButton but2 = new JButton("really really long button name");
        JButton but3 = new JButton("another really really long button name");
        JButton but4 = new JButton("S");

        southPanel.add(but1);
        southPanel.add(but2);
        southPanel.add(but3);
        southPanel.add(but4);

        this.add(southPanel, BorderLayout.SOUTH);
    }

    private void initNorth(){

        JPanel northPan = new JPanel();
        JLabel northLab = new JLabel("North Label for demo purposes");
        JLabel northLab2 = new JLabel("Second Label");
        northPan.add(northLab);
        northPan.add(northLab2);

        this.add(northPan, BorderLayout.NORTH);
    }

    public static void main(String[] args) {
        new GUIExamples();
    }

}
