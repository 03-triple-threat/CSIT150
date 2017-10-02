package Lab5;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Author: AJ Hurtado
 * Created: 09/29/17
 *
 * The purpose of this program is to compare the use of iteration and recursive functions.
 * A file is read into a string and both the iterative and recursive methods are run to check
 * that each line is palindrome. If the line is a palindrome, the program returns a message stating so.
 */

public class Lab5 {

    public static void main(String[] args) throws IOException {
        File inputFile = getInputFile();
        readFile(inputFile);

    }

    /**
     * Method allows user to choose file to read in.
     *
     * @return
     * @throws IOException
     */
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

    /**
     * Method reads in input file and calls isPal recursive method as well as isPalIterative
     * method to compare each line of the file and check if it is palindrome.
     *
     * @param inputFile
     * @throws IOException
     */
    private static void readFile(File inputFile) throws IOException {
        Scanner inputScanner = new Scanner(inputFile);
        while (inputScanner.hasNext()) {
            String test = inputScanner.nextLine();
            if (isPal(test))
                System.out.println(test + " is a palindrome.");
            if (isPalIterative(test))
                System.out.println(test + " is a palindrome.");
        }
        inputScanner.close();
    }

    /**
     * This method uses recursion to check if the line in the file is a palindrome.
     *
     * @param test - string with the contents of the input file
     * @return
     */
    private static boolean isPal(String test) {
        test = test.toLowerCase();

        if (test.length() > 1) {
            if (test.charAt(0) == test.charAt(test.length() - 1)) {
                return isPal(test.substring(1, test.length() - 1));
            } else
                return false;
        } else
            return true;
    }

    /**
     * This method uses iteration to check if the line in the file is a palindrome.
     *
     * @param test - string with the contents of the input file
     * @return
     */
    private static boolean isPalIterative(String test) {
        test = test.toLowerCase();
        boolean isPal = true;

        while (isPal && test.length() > 1) {
            if (test.charAt(0) != test.charAt(test.length()-1))
                isPal = false;
            else
                test = (test.substring(1, test.length()-1));
        }
        return isPal;
    }
}
