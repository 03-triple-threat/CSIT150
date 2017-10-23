package MidTerm;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;


/**
 * Author: AJ Hurtado
 * Date: 10/20/2017
 */
public class Midterm {

    public static void main(String[] args) throws IOException {

        TwoDPoint coordinate = new TwoDPoint();


        System.out.println(coordinate.getArea((coordinate.getLen(1, 4)) , coordinate.getWid(1, 5)));
    }

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

//    private static TwoDPoint[] readFile(File inputFile) throws IOException {
//        Scanner inputScanner = new Scanner(inputFile);
//        int h = 0;
//        int numberOfCoordinates = inputScanner.nextInt();
//        inputScanner.nextLine();
//        TwoDPoint[] coordinates = new TwoDPoint[numberOfCoordinates];
//        while (inputScanner.hasNext()) {
//            String line = inputScanner.nextLine();
//            StringTokenizer tokenizer = new StringTokenizer(line, ":(,) ");
//            tokenizer.nextToken();
//            double x = Double.parseDouble(tokenizer.nextToken());
//            double y = Double.parseDouble(tokenizer.nextToken());
//            coordinates[h] = new TwoDPoint(x,y);
//            h++;
//        }
//
//        inputScanner.close();
//        return coordinates;
//    }
}
