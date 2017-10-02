package Lab1;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Author: AJ Hurtado
 * Created: 08/29/17
 *
 * The purpose of this program is to output a display of temperature data from a
 * file by reading the data from the file into a 2D array and an array of strings.
 * Various methods will calculate the averages of the rows and the columns of the
 * 2D arrays.
 *
 */

public class Lab1Start {

    final static int MONTHS = 12;
    final static int NUMYEARS = 6;

    private static File getInputFile() throws IOException {
        //Get the INPUT filename
        JFileChooser chooser = new JFileChooser();
        File home = new File(System.getProperty("user.home"));
        chooser.setCurrentDirectory(home);
        int status = chooser.showOpenDialog(null);

        if (status != JFileChooser.APPROVE_OPTION) {
            System.out.println("No File Chosen");
            System.exit(0);
        }

        //Open the file
        return chooser.getSelectedFile();
    }

    public static void main(String[] args) throws IOException {
        DecimalFormat formatter = new DecimalFormat("0.0");
        File inputFile = getInputFile();

        //Store the month names
        String[] months = {"January", "February", "March", "April", "May",
                "June", "July", "August", "September", "October",
                "November", "December"};

        double [][] tempData = readFile(inputFile);

        String introMessage = "Hi, welcome to the Temperature Data Program.\n" +
                "This program will display average data temperature over a six year period.\n";

        System.out.println(introMessage);

        String label = "Month\t\t\tTemperatures\t\t\t\t\t\t\t\t\t\t\t\tAverage";

        System.out.println(label);

        /**
         * I used the String.format after researching best way to align columns.
         * Various examples were given via Stack Overflow
         */
        for (int i = 0; i < months.length; i++){
            String outAvg = String.format("%10.2f", calcRowAverage(tempData[i]) );
            System.out.println(String.format("%-10s", months[i] + ":") + "\t" + getMonthValues(tempData, i) + outAvg);
        }

        //Starting output message
        System.out.println("Average yearly temperatures");

        for (int i = 0; i < NUMYEARS; i++) {
            System.out.print("\t" + String.format("%5.2f", calcColumnAverage(tempData, i)) + "\t");
        }

        //for each month (create and call methods as needed)
        //calculate the monthly average of the temperatures in the array
        //bonus: calculate the monthly standard deviation of the temperatures in the array
        //output the month name, the average temperature and for bonus the standard deviation
        //output the column averages = create methods as needed
        System.out.println("\nThank you");
    }

    /**
     * Method takes in a double array and calculates the average of the values
     * within the array. The average is then returned.
     *
     * @param monthTemps - an array of doubles
     * @return average of the values within the array
     */
    private static double calcRowAverage(double[] monthTemps) {
        double sum = 0;
        for (int i = 0; i < monthTemps.length; i++) {
            sum += monthTemps[i];
        }
        return sum/monthTemps.length;
    }

    /**
     * Method takes in a file and stores the values within the file into
     * a 2D array of doubles.
     *
     * @param inputFile - file of values
     * @return 2D array of doubles
     * @throws IOException
     */
    private static double[][] readFile(File inputFile) throws IOException {
        Scanner inputScanner = new Scanner (inputFile);
        int m = 0; //Current month value to store temperatures
        double [][] temperatures = new double [MONTHS][NUMYEARS];
        while (inputScanner.hasNext()) {
            String monthData = inputScanner.nextLine();
            String [] splitData = monthData.split(",");

            //Finish
            //For each temperature
            //Read temperature value from the splitData and store into correct spot in the array
            for (int i = 0; i < NUMYEARS; i++) {
                temperatures[m][i] = Double.parseDouble(splitData[i + 1]);
            }

            m++;

        }
        inputScanner.close();

        return temperatures;
    }

    /**
     * Method takes in a 2D array of doubles and an int. The int is a specifc column
     * within the 2D array. The average of the column is calcuated and returned
     *
     * @param monthTemps - 2D array of doubles
     * @param col - int value of a specific column within 2D array
     * @return Average of specified column
     */
    private static double calcColumnAverage(double[][] monthTemps, int col){
        double sum = 0;

        for (int row = 0; row < monthTemps.length; row++)
            sum += monthTemps[row][col];

        return sum/monthTemps.length;
    }

    /**
     * Method takes in a 2D array of doubles and a specific row within the 2D array as
     * an int. The values stored within the specified row are then converted to a String
     *
     * @param monthTemps - 2D array of doubles
     * @param row - int value of specific row within the 2D array
     * @return String of values within the specified row
     */
    private static String getMonthValues(double [][] monthTemps, int row) {

        String monthData = "";

        for (int i = 0; i < monthTemps[row].length; i++) {
            monthData += String.format("%10.2f",monthTemps[row][i]);
        }

        return monthData;
    }
}
