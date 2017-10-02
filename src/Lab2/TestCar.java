package Lab2;

import java.util.Scanner;

/**
 * Author: AJ Hurtado
 * Date: 09/07/17
 * <p>
 * The purpose of this program is to call the Car class and create car objects.
 * By using various methods within the Car class, the objects are moved.
 * Two objects are hardcoded into the program, while one object requires user input.
 */

public class TestCar {
    public static void main(String[] args) {
        Car sherriCar = new Car("Dr. Harms", 90);
        // Get on the interstate at 75 mph
        for (int i = 0; i * 5 < 75; i++)
            sherriCar.accelerate(); //we accelerate 5 mph at a time

        //Drive Dr. Harms to see her kids in Lincoln - 110 minutes at 75 mph
        for (int i = 0; i < 110; i++)
            sherriCar.move();

        //Output the car information at this point of the drive
        System.out.println(sherriCar);

        //when she gets to the Lincoln city limits, slow her car to 65 mph and then drive for 10 minutes
        for (int i = 0; i < 2; i++)
            sherriCar.brake();
        for (int i = 0; i < 10; i++)
            sherriCar.move();

        //output car information - showing how far she drove
        System.out.println(sherriCar);

        //ask the user for input data and create a car for one CSIT 150 student
        Car ajCar = new Car("AJ Hurtado", 100);

        //Getting on highway at 65 mph
        for (int i = 0; i * 5 < 65; i++)
            ajCar.accelerate();

        //Drive from Kearney to Norton - 120 minutes at 65 mph
        for (int i = 0; i < 120; i++)
            ajCar.move();

        //Output car information at this point of the drive
        System.out.println("\n" + ajCar);

        //Slow down to 45 mph in the Norton city limits for 5 minutes
        for (int i = 0; i < 4; i++)
            ajCar.brake();

        for (int i = 0; i < 100; i++)
            ajCar.move();

        //Output deceleration of car
        System.out.println(ajCar);

        //Accelerate back to 65 mph outside of Norton
        for (int i = 0; i * 5 < 20; i++)
            ajCar.accelerate();

        //Output acceleration
        System.out.println(ajCar);

        //Drive from Norton to GC - 120 minutes at 65 mph
        for (int i = 0; i < 125; i++)
            ajCar.move();

        //output total drive info
        System.out.println(ajCar + "\n");

        //ask the user for input data and create a car for a second CSIT 150 student
        System.out.println("Please enter a third name");

        Scanner keyboard = new Scanner(System.in);
        String thirdPerson = keyboard.nextLine();

        Car userCar = new Car(thirdPerson, 100);

        //Get on interstate at 75 mph
        for (int i = 0; i * 5 < 75; i++)
            userCar.accelerate();

        //Output start of drive
        System.out.println(userCar);

        //Drive for Kearney to North Platte - 100 minutes at 75 mph
        for (int i = 0; i < 100; i++)
            userCar.move();

        //Output drive info at this point
        System.out.println(userCar);

        //Slow down to 55 mph in North Platte city limits for 10 minutes
        for (int i = 0; i < 4; i++)
            userCar.brake();
        for (int i = 0; i < 10; i++)
            userCar.move();

        //Output deceleration
        System.out.println(userCar);

        //Accelerate back to 75 mph and drive for 5 minutes
        for (int i = 0; i * 5 < 20; i++)
            userCar.accelerate();
        for (int i = 0; i < 15; i++)
            userCar.move();

        //Output Acceleration
        System.out.println(userCar);

        //Drive from north Platte to Denver - 225 minutes at 75 mph
        for (int i = 0; i < 225; i++)
            userCar.move();

        //output car info
        System.out.println(userCar + "\n");

        //check to see who drove the farthest (in code)

        String largestDistance1 = "";
        String largestDistance2 = "";
        String largestDistance3 = "";


        largestDistance1 = String.format("The car that drove most was " + sherriCar.getOwner() + "'s, " +
                "with a total of %.2f" + " miles.", sherriCar.getdistanceTraveled());

        largestDistance2 = String.format("The car that drove most was " + ajCar.getOwner() + "'s, " +
                "with a total of %.2f" + " miles.", ajCar.getdistanceTraveled());

        largestDistance3 = String.format("The car that drove most was " + userCar.getOwner() + "'s, " +
                "with a total of %.2f" + " miles.", userCar.getdistanceTraveled());

        if (sherriCar.getdistanceTraveled() > ajCar.getdistanceTraveled() && sherriCar.getdistanceTraveled() > userCar.getdistanceTraveled()) {
            System.out.println(largestDistance1);
        } else {
            if (ajCar.getdistanceTraveled() > sherriCar.getdistanceTraveled() && ajCar.getdistanceTraveled() > userCar.getdistanceTraveled()) {
                System.out.println(largestDistance2);
            } else {
                if (userCar.getdistanceTraveled() > sherriCar.getdistanceTraveled() && userCar.getdistanceTraveled() > ajCar.getdistanceTraveled()) {
                    System.out.println(largestDistance3);
                }
            }
        }

        System.out.println("\nThe following information is for the trip back to the user's original starting point.\n");

        //now, reset each car's distance traveled and speed, and drive them back to Kearney
        sherriCar.resetDistance();
        sherriCar.resetCurrentSpeed();

        //Get Dr. Harm's car on interstate at 65 mph
        for (int i = 0; i * 5 < 65; i++)
            sherriCar.accelerate();

        //Output the start of the drive
        System.out.println(sherriCar);

        //Drive for 10 minutes through Lincoln
        for (int i = 0; i < 10; i++)
            sherriCar.move();

        //Output the drive through this point
        System.out.println(sherriCar);

        //Accelerate to 75 mph after passing Lincoln
        for (int i = 0; i * 5 < 10; i++)
            sherriCar.accelerate();

        //output the acceleration:
        System.out.println(sherriCar);

        //Drive from Lincoln to Kearney - 110 minutes at 75 mph
        for (int i = 0; i < 110; i++)
            sherriCar.move();

        //print out results of drive back
        System.out.println(sherriCar + "\n");

        ajCar.resetDistance();
        ajCar.resetCurrentSpeed();
        ajCar.getCurrentSpeed();

        //Get on highway at 65 mph
        for (int i = 0; i * 5 < 65; i++)
            ajCar.accelerate();

        //Output the start of the drive
        System.out.println(ajCar);

        //Drive from GC to Norton - 120 minutes at 65 mph
        for (int i = 0; i < 120; i++)
            ajCar.move();

        //Output the car at this point
        System.out.println(ajCar);

        //Slow down to 45 mph once in Norton and drive 5 minutes
        for (int i = 0; i < 4; i++)
            ajCar.brake();
        for (int i = 0; i < 5; i++)
            ajCar.move();

        //Output the deceleration
        System.out.println(ajCar);

        //Accelerate back to 65 mph once past Norton
        for (int i = 0; i * 5 < 20; i++)
            ajCar.accelerate();

        //Output the acceleration
        System.out.println(ajCar);

        //Drive from Norton to Kearney - 120 minutes at 65 mph
        for (int i = 0; i < 120; i++)
            ajCar.move();

        //Print out the results of the drive back
        System.out.println(ajCar + "\n");

        userCar.resetDistance();
        userCar.resetCurrentSpeed();

        //Get on interstate at 75 mph
        for (int i = 0; i * 5 < 75; i++)
            userCar.accelerate();

        //output the start of the drive
        System.out.println(userCar);

        //Drive from Denver to North Platte - 225 minutes at 75 mph
        for (int i = 0; i < 225; i++)
            userCar.move();

        //Output the car at this point
        System.out.println(userCar);

        //Slow down to 55 mph once in North Platte for 10 minutes
        for (int i = 0; i < 4; i++)
            userCar.brake();
        for (int i = 0; i < 10; i++)
            userCar.move();

        //Output the deceleration
        System.out.println(userCar);

        //Accelerate back to 75 mph after North Platte
        for (int i = 0; i * 5 < 20; i++)
            userCar.accelerate();

        //Output the acceleration
        System.out.println(userCar);

        //Drive from North Platte to Kearney - 100 minutes at 75 mph
        for (int i = 0; i < 100; i++)
            userCar.move();

        //Print out results of the drive back
        System.out.println(userCar);

        //Bonus: test the car's copy constructor

    }
}
