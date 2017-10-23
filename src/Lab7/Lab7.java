package Lab7;

import javax.swing.*;
import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Lab7 {


    /**
     * Prompts the user to enter the name of the file they wish to analyze
     *
     * @return file name to analyze
     */
    public static String getFileName() {
        boolean typeFlag = false;
        String fileName = "";
        while (!typeFlag) {
            String prompt = "Please input the name of the file you wish\n"
                    + "to analyse. You will be asked to enter a\n"
                    + "file name until a valid file name is provided.\n"
                    + "The file name must have a '.dat' or '.csv' extension.\n";
            fileName = JOptionPane.showInputDialog(null, prompt,
                    "Enter File Name", 1);
            if (fileName.endsWith("dat") || fileName.endsWith("csv")) {
                typeFlag = true;
            }
        }
        return fileName;
    }

    /**
     * This method accepts .dat file type and attempts to establish a connection
     * with the file and will prompt the user to enter another file name if the file is not found.
     * Uses a try/catch block to catch "FileNotFoundException".
     * @param inputFile file name to establish connection to
     * @return the data input stream to read the contents of the binary file
     */
    public static DataInputStream openBinaryFile() {
        boolean fileFound = false;
        DataInputStream fileDIS = null;
        File file;
        Scanner inputFile;
        String fileName;

        try
        {
            file = new File(getFileName());
            inputFile = new Scanner(file);
            JOptionPane.showMessageDialog(null, "The file was found.");
        }
        catch (FileNotFoundException e)
        {
            JOptionPane.showMessageDialog(null, "File not found.");
        }
        return fileDIS;
    }

    /**
     * This method reads a .dat file and assigns each double to an array or array list - your choice
     * use a try/catch block and catch the "EOFException" to stop reading the numbers from the file.
     * you will need to catch other errors as well.
     * If you use an array, you will earn bonus points.
     * @param numbers   array list to assign contents of file to
     * @param inputFile object that reads the .dat file
     * @return array list or array containing the doubles in the .dat file
     */
    public static ArrayList<Double> getNumbers(DataInputStream inputFile) {
        // public static double[] getDatNumbers(DataInputStream inputFile) {   //bonus option
        boolean endOfFile = false;
        ArrayList<Double> numbers = new ArrayList<Double> ();

        try {
            while (!endOfFile) {
                numbers.add(inputFile.readDouble());
            }
        } catch (EOFException e) {
            endOfFile = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numbers;
    }

    /**

     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //determines which methods to run based on file type
        DataInputStream dataInputFile = openBinaryFile();
        ArrayList<Double> numbers = new ArrayList<Double>();
        numbers = getNumbers(dataInputFile);
        //output the numbers and their average.
        for (double n: numbers)
            System.out.println(n);
        // Use methods appropriately
    }

}
