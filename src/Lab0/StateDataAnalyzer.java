package Lab0;

import javax.swing.*;
import java.io.File;
import java.util.Scanner;

/**
 * Author - AJ Hurtado
 * Date Created - 08/23/17
 * <p>
 * The purpose of this program is to find minimums and maximums of various arrays.
 * The information for the arrays is loaded in through a separate file.
 * <p>
 * Loops are used to search for the minimum and maximum values within the arrays.
 * <p>
 * Based on CSIT 130 lab 14
 */

public class StateDataAnalyzer {

    private static int NUMBER_STATES = 50;

    /**
     * Load state names from the file
     *
     * @param fileName
     * @return array of strings with the state names
     * @throws Exception
     */
    public static String[] loadNamesFromFile(String fileName) throws Exception {
        File file = new File(fileName);
        String[] array = new String[NUMBER_STATES];

        Scanner fileScan = new Scanner(file);
        for (int row = 0; row < NUMBER_STATES; row++) {
            array[row] = fileScan.next();
            fileScan.nextLine();
        }
        return array;
    }

    /**
     * load the per capita income for each state
     *
     * @param fileName
     * @return array of doubles with the state per capita income
     * @throws Exception
     */
    public static double[] loadPercapitaFromFile(String fileName) throws Exception {
        File file = new File(fileName);
        double[] array = new double[NUMBER_STATES];

        Scanner fileScan = new Scanner(file);
        for (int row = 0; row < NUMBER_STATES; row++) {
            fileScan.next();
            array[row] = fileScan.nextDouble();
            fileScan.nextLine();
        }
        return array;
    }

    /**
     * load the state population from a file
     *
     * @param fileName
     * @return array of integers with each state population
     * @throws Exception
     */
    public static int[] loadPopulationFromFile(String fileName) throws Exception {
        File file = new File(fileName);
        int[] array = new int[NUMBER_STATES];

        Scanner fileScan = new Scanner(file);
        for (int row = 0; row < NUMBER_STATES; row++) {
            fileScan.next();
            fileScan.next();
            array[row] = fileScan.nextInt();
            fileScan.nextLine();
        }
        return array;
    }

    /**
     * load the land size from a file
     *
     * @param fileName
     * @return array of doubles with each states land size
     * @throws Exception
     */
    public static double[] loadLandSizeFromFile(String fileName) throws Exception {
        File file = new File(fileName);
        double[] array = new double[NUMBER_STATES];

        Scanner fileScan = new Scanner(file);
        for (int row = 0; row < NUMBER_STATES; row++) {
            fileScan.next();
            fileScan.next();
            fileScan.next();
            array[row] = fileScan.nextDouble();
        }
        return array;
    }


    /**
     * This method takes in an array of doubles as a parameter
     * and returns the index of the highest value within the array.
     *
     * @param array - an array of doubles
     * @return element - index of the highest value within the array
     */
    public static double findMaxIndex(double[] array) {

        double maxNum = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxNum)
                maxNum = array[i];
        }

        int index = 0;
        int element = -1;
        boolean found = false;

        while (!found && index < array.length) {
            if (array[index] == maxNum) {
                found = true;
                element = index;
            }
            index++;
        }

        return element;
    }

    /**
     * This method takes in an arry of doubles as a parameter
     * and returns the index of the lowest value within the array.
     *
     * @param array - an array of doubles
     * @return element - index of the lowest minimum value in the array
     */
    public static double findMinIndex(double[] array) {

        double minNum = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] < minNum)
                minNum = array[i];
        }

        int index = 0;
        int element = -1;
        boolean found = false;

        while (!found && index < array.length) {
            if (array[index] == minNum) {
                found = true;
                element = index;
            }
            index++;
        }

        return element;
    }

    /**
     * This method takes in an array of ints as a parameter
     * and returns the index of the highest value.
     *
     * @param array - an array of ints
     * @return element - index of the maximum value in the array
     */
    public static int findMaxIndex(int[] array) {

        int maxNum = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxNum)
                maxNum = array[i];
        }

        //pg. 451 in book
        int index = 0;
        int element = -1;
        boolean found = false;

        //search the array
        while (!found && index < array.length) {
            if (array[index] == maxNum) {
                found = true;
                element = index;
            }
            index++;
        }

        return element;
    }

    /**
     * This method takes in an array of doubles as a parameter
     * and returns the index of the lowest value.
     *
     * @param array - an array of doubles
     * @return element - index of the minimum value in the array
     */
    public static int findMinIndex(int[] array) {

        int minNum = array[0];


        for (int i = 1; i < array.length; i++) {
            if (array[i] < minNum)
                minNum = array[i];
        }

        int index = 0;
        int element = -1;
        boolean found = false;

        while (!found && index < array.length) {
            if (array[index] == minNum) {
                found = true;
                element = index;
            }
            index++;
        }

        return element;
    }

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        String fileName = "State_Data.csv";
        String[] stateNames = loadNamesFromFile(fileName);
        double[] percapitaData = loadPercapitaFromFile(fileName);
        int[] populationData = loadPopulationFromFile(fileName);
        double[] landSizeData = loadLandSizeFromFile(fileName);

        int arrayIndex = 0;

        String intro = "Hi! Welcome to the state information program\n" +
                "Below are six different categories you can search between.\n";

        String menu = "Enter the Letter corresponding to the task \n" +
                "you would like to complete, or Q to quit!\n" +
                "\nA – Find state with maximum land mass." +
                "\nB – Find state with minimum land mass." +
                "\nC – Find state with maximum population." +
                "\nD - Find state with minimum population." +
                "\nE - Find state with maximum average income." +
                "\nF - Find state with minimum average income." +
                "\n\nQ - to quit.";
        do {
            String response = JOptionPane.showInputDialog(null, intro + menu, "Menu", 1);
            char letter = response.toUpperCase().charAt(0);
            switch (letter) {
                case 'A':
                    int maxIndex = (int) findMaxIndex(landSizeData);
                    JOptionPane.showMessageDialog(null, "State with Maximum Land Mass: " + stateNames[maxIndex] +
                            "\nLand Mass: " + landSizeData[maxIndex] +
                            "\nPopulation: " + populationData[maxIndex] +
                            "\nAverage Income: " + percapitaData[maxIndex], "State with Maximum Land Mass", 1);
                    break;
                case 'B':
                    int minIndex = (int) findMinIndex(landSizeData);
                    JOptionPane.showMessageDialog(null, "State with Minimum Land Mass: " + stateNames[minIndex] +
                            "\nLand Mass: " + landSizeData[minIndex] +
                            "\nPopulation: " + populationData[minIndex] +
                            "\nAverage Income: " + percapitaData[minIndex], "State with Minimum Land Mass.", 1);
                    break;
                case 'C':
                    int maxIndex2 = findMaxIndex(populationData);
                    JOptionPane.showMessageDialog(null, "State with Maximum Population: " + stateNames[maxIndex2] +
                            "\nPopulation: " + populationData[maxIndex2] +
                            "\nLand Mass: " + landSizeData[maxIndex2] +
                            "\nAverage Income: " + percapitaData[maxIndex2], "State with Maximum Population.", 1);
                    break;
                case 'D':
                    int minIndex2 = findMinIndex(populationData);
                    JOptionPane.showMessageDialog(null, "State with Minimum Population: " + stateNames[minIndex2] +
                            "\nPopulation: " + populationData[minIndex2] +
                            "\nLand Mass: " + landSizeData[minIndex2] +
                            "\nAverage Income: " + percapitaData[minIndex2], "State with Minimum Population.", 1);
                    break;
                case 'E':
                    int maxIndex3 = (int) findMaxIndex(percapitaData);
                    JOptionPane.showMessageDialog(null, "State with Maximum Average Income: " + stateNames[maxIndex3] +
                            "\nAverage Income: " + percapitaData[maxIndex3] +
                            "\nLand Mass: " + landSizeData[maxIndex3] +
                            "\nPopulation: " + populationData[maxIndex3], "State with Maximum Average Income.", 1);
                    break;
                case 'F':
                    int minIndex3 = (int) findMinIndex(percapitaData);
                    JOptionPane.showMessageDialog(null, "State with Minimum Average Income: " + stateNames[minIndex3] +
                            "\nAverage Income: " + percapitaData[minIndex3] +
                            "\nLand Mass: " + landSizeData[minIndex3] +
                            "\nPopulation: " + populationData[minIndex3], "State with Minimum Average Income.", 1);
                    break;
                case 'Q':
                    JOptionPane.showMessageDialog(null, "Program terminating",
                            "Ending", 1);
                    System.exit(0);
                    break;
            }
        } while (true);
    }
}
