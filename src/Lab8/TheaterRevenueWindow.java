package Lab8;

/*
 * LAb 8 starter code
 * Theater revenue problem
  * This demonstrates a GUI program, with a Model/View/Controller architecture
 *  * comments intensionally left out to shorten code for printout
 *
 * written by C.Anderson,  CSIS150 fall 2013
 *
 * modified by Sherri Harms, CSIT 150 Fall 2017
 *  @author canderson
 * @author harmssk
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TheaterRevenueWindow extends JFrame {

    TheaterRevenues theaterRev;
    JTextField pricePerAdultTxt, numberAdultTxt, pricePerChildTxt, numberChildTxt;
    JTextField grossAdultRevTxt, netAdultRevTxt, grossChildRevTxt, netChildRevTxt;
    JTextField totalGrossRevTxt, totalNetRevTxt;
    JLabel pricePerAdultLab, numberAdultsLab, pricePerChildLab, numberChildLab;
    JButton calcButton, clearButton;


    public TheaterRevenueWindow()
    {
        theaterRev = new TheaterRevenues();
        initalizeWindow();
        addButtonListener();
    }

    private void initalizeWindow()
    {
        this.setTitle("Theater Revenue Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.createDisplay();
        pack();
        this.setVisible(true);
    }

    /* creates the nexted panels that make up the display, than adds the
     * components to them
     */
    private void createDisplay()
    {
        Font boldFont = new Font("Arial", Font.BOLD, 14);
        Font norFont = new Font("Verdana", Font.PLAIN, 4);
        // ticket panel
        JPanel tickPanel = new JPanel(new GridLayout(5,2));

        JLabel lab = new JLabel();
        lab = new JLabel();

        lab.setFont(boldFont);
        lab.setText("Tickets sold");
        tickPanel.add(lab);
        lab = new JLabel();
        tickPanel.add(lab);

        pricePerAdultLab = new JLabel("   Adult ticket price");
        tickPanel.add(pricePerAdultLab);
        pricePerAdultTxt = new JTextField(""+theaterRev.getDefaultAdultPrice());
        pricePerAdultTxt.setToolTipText("Price per adult ticket, must be whole positive number!\n");
        tickPanel.add(pricePerAdultTxt);
        numberAdultsLab = new JLabel("   Number adult tickets sold");
        tickPanel.add(numberAdultsLab);
        numberAdultTxt = new JTextField(""+theaterRev.getDefaultAdultTickets());
        tickPanel.add(numberAdultTxt);

        pricePerChildLab = new JLabel("   Child ticket price");
        tickPanel.add(pricePerChildLab);
        pricePerChildTxt = new JTextField(""+theaterRev.getDefaultChildPrice());
        tickPanel.add(pricePerChildTxt);
        numberChildLab = new JLabel("   Number child tickets sold");
        tickPanel.add(numberChildLab);
        numberChildTxt = new JTextField(""+theaterRev.getDefaultAdultTickets());
        tickPanel.add(numberChildTxt);
        tickPanel.setBorder(BorderFactory.createBevelBorder(1));

        this.getContentPane().add(tickPanel,BorderLayout.WEST);

        // revenu panel
        JPanel revPanel = new JPanel(new GridLayout(5,2));
        lab = new JLabel("         Revenues");
        lab.setFont(boldFont);
        revPanel.add(lab);
        clearButton = new JButton("Clear");
        revPanel.add(clearButton);

        // adult rev
        lab = new JLabel("      Gross Rev. Adult");
        revPanel.add(lab);
        grossAdultRevTxt = new JTextField();
        grossAdultRevTxt.setEditable(false);
        revPanel.add(grossAdultRevTxt);
        lab = new JLabel("      Net Rev. Adult");
        revPanel.add(lab);
        netAdultRevTxt = new JTextField();
        netAdultRevTxt.setEditable(false);
        revPanel.add(netAdultRevTxt);

        // child rev
        lab = new JLabel("      Gross Revenues Child");
        revPanel.add(lab);
        grossChildRevTxt = new JTextField();
        grossChildRevTxt.setEditable(false);
        revPanel.add(grossChildRevTxt);
        lab = new JLabel("      Net Rev. Child");
        revPanel.add(lab);
        netChildRevTxt = new JTextField();
        netChildRevTxt.setEditable(false);
        revPanel.add(netChildRevTxt);
        //      revPanel.setBorder(BorderFactory.createEtchedBorder(1));
        this.getContentPane().add(revPanel,BorderLayout.EAST);

        JPanel southPanel = new JPanel();
        calcButton = new JButton("Calculate Revenues");
        southPanel.add(calcButton);

        lab = new JLabel("      Total Gross Rev:");
        southPanel.add(lab);
        totalGrossRevTxt = new JTextField(8);
        totalGrossRevTxt.setEditable(false);
        southPanel.add(totalGrossRevTxt);
        lab = new JLabel("      Total Net Rev:");
        southPanel.add(lab);
        totalNetRevTxt = new JTextField(8);
        totalNetRevTxt.setEditable(false);
        southPanel.add(totalNetRevTxt);
        //    southPanel.setBorder(BorderFactory.createEtchedBorder());

        this.getContentPane().add(southPanel,BorderLayout.SOUTH);
    }

    private void addButtonListener()
    {
        // Hook up the radio buttons with the event listener
        MyListener listener = new MyListener();
        calcButton.addActionListener(listener);
        clearButton.addActionListener(listener);
    }

    private void clearAllFields()
    {
        pricePerAdultTxt.setText(""+theaterRev.getDefaultAdultPrice());
        numberAdultTxt.setText(""+theaterRev.getDefaultAdultTickets());
        pricePerChildTxt.setText(""+theaterRev.getDefaultChildPrice());
        numberChildTxt.setText(""+theaterRev.getDefaultChildTickets());
        grossAdultRevTxt.setText("");
        netAdultRevTxt.setText("");
        grossChildRevTxt.setText("");
        netChildRevTxt.setText("");
        totalGrossRevTxt.setText("");
        totalNetRevTxt.setText("");
    }


    private void calcAdultRevs()
    {
        //Set the TicketRevenue object values from the textfield values
        //call the TicketRevenue methods to calculate revenue
        //Update the window's textfields to show the revenue value
        theaterRev.calcGrossAdultSales();
    }

    private void calcChildRevs()
    {
    }

    private void calcRevs()
    {
    }

    private boolean validateFields()
    {
        String errorMessage = "";
        errorMessage += validateAdultPrice();
        errorMessage += validateNumberAdult();

        errorMessage += validateChildPrice();
        errorMessage += validateNumberChild();

        if(!errorMessage.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Error in Data Entry:\n"+
                    errorMessage,"Data Entry Errors",1);
            return false;
        }
        return true;
    }

    private String validateNumberChild()
    {
        int cTicks = 0;
        String errorMessage = "";
        numberChildLab.setForeground(Color.black);
        if(numberChildTxt.getText().equals(""))
        {   numberChildLab.setForeground(Color.red);
            errorMessage+="\nChild tickets field needs a value:\n"+
                    "      positive whole number ";
        }
        else
        {   try
        {   cTicks = Integer.parseInt(numberChildTxt.getText());
            if (cTicks < 0)
            {   numberChildLab.setForeground(Color.red);
                errorMessage += "\nNumber in child tickets field is"+
                        " negative\n"
                        + "     enter a positive whole number \n";
            }
        }catch(NumberFormatException nme)
        {   numberChildLab.setForeground(Color.red);
            errorMessage+="\nNumber in child tickets field contains an"+
                    " invalid 'integer'\n"+
                    "     enter a positive whole number \n";
        }
        }
        return errorMessage;
    }

    private String validateNumberAdult()
    {
        int aTicks = 0;
        String errorMessage = "";
        numberAdultsLab.setForeground(Color.black);
        if(numberAdultTxt.getText().equals(""))
        {   numberAdultsLab.setForeground(Color.red);
            errorMessage+="\nAdult tickets field needs a value:\n"+""
                    + "      enter a positive whole number\n";
        }
        else
        {   try
        {   aTicks = Integer.parseInt(numberAdultTxt.getText());
            if (aTicks < 0)
            {   numberAdultsLab.setForeground(Color.red);
                errorMessage += "\nNumber in adult tickets field is negative\n"
                        + "     enter a positive whole number \n";
            }
        }catch(NumberFormatException nme)
        {   numberAdultsLab.setForeground(Color.red);
            errorMessage+="\nNumber in adult tickets field contains an"+""
                    + " invalid 'integer'\n"+
                    "     enter a positive whole number \n";
        }
        }
        return errorMessage;
    }

    private String validateAdultPrice()
    {
        double aPrice = 0;
        String errorMessage = "";
        pricePerAdultLab.setForeground(Color.black);
        if(pricePerAdultTxt.getText().equals(""))
        {   pricePerAdultLab.setForeground(Color.red);
            errorMessage+="\nAdult price fields needs a value:\n    positive"+""
                    + " dollar amount\n";
        }
        else
        {   try
        {   aPrice = Double.parseDouble(pricePerAdultTxt.getText());

            if (aPrice < 1)
            {   pricePerAdultLab.setForeground(Color.red);
                errorMessage += "\nprice of adult tickets field is zero"+""
                        + " or less\n"
                        + "     enter a positive whole number \n";
            }
        }catch(NumberFormatException nme)
        {   errorMessage+="\nAdult price fields contains an invalid"+""
                + " dollar amount\n"+
                "      enter a positive dollar amount \n";
            pricePerAdultLab.setForeground(Color.red);
        }
        }
        return errorMessage;
    }

    private String validateChildPrice()
    {
        double cPrice = 0;
        String errorMessage = "";
        pricePerChildLab.setForeground(Color.black);
        if(pricePerChildTxt.getText().equals(""))
        {   pricePerChildLab.setForeground(Color.red);
            errorMessage+="\nChild price fields needs a value:\n"+
                    "     positive dollar amount\n";
        }
        else
        {   try
        {   cPrice = Double.parseDouble(pricePerChildTxt.getText());
            if (cPrice < 1)
            {   pricePerChildLab.setForeground(Color.red);
                errorMessage += "\nprice of child tickets field is"+
                        " zero or less\n"
                        + "     enter a positive whole number \n";
            }
        }catch(NumberFormatException nme)
        {   pricePerChildLab.setForeground(Color.red);
            errorMessage+="\nChild price fields contains an invalid"+""
                    + " dollar amount\n"+
                    "     enter a positive dollar amount \n";
        }
        }
        return errorMessage;
    }

    /**
     * The listener to respond to  button events
     ** @author Sherri Harms
     *     */
    private class MyListener implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if(e.getSource() == calcButton)
            {
                //validate the fields and calculate revenues
                validateAdultPrice();
                calcAdultRevs();
            } else if(e.getSource() == clearButton){
                //clear the fields
                clearAllFields();
            }
        }
    }

    public static void main(String[] agrs)
    {
        TheaterRevenueWindow trw = new TheaterRevenueWindow();
    }

}
