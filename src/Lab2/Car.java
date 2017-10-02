package Lab2;

/**
 * Author: AJ Hurtado
 * Date: 09/07/17
 * <p>
 * The purpose of this class is to create a car object that takes in a various information.
 * The methods included in this class are accelerating, braking, and moving the object.
 */

public class Car {
    //declare private member variables here
    private String owner;
    private int currentSpeed;  //in terms of mph
    private double distanceTraveled;  // in terms of miles
    private int maxSpeed; //in terms of mph
    private static final int DEFAULTMAXSPEED = 100;

    /**
     * Constructor initializes a car
     *
     * @param newOwner    - owner of the car
     * @param newMaxSpeed - max speed of the car
     */
    public Car(String newOwner, int newMaxSpeed) {
        owner = newOwner;
        currentSpeed = 0;
        maxSpeed = newMaxSpeed;
        distanceTraveled = 0;
    }

    /**
     * Default constructor
     */
    public Car() {
        this("no owner", DEFAULTMAXSPEED);
    }

    /**
     * Move the car the distance it can travel at its current speed for 1 minute
     * (update the distance traveled variable)
     */
    public void move() {
        this.distanceTraveled += this.currentSpeed / 60.0;
    }

    /**
     * Add 5 miles per hour to current speed
     * Remember: The most the current speed can be is the maxSpeed of the car
     */
    public void accelerate() {
        if (this.currentSpeed <= this.maxSpeed - 5) {
            this.currentSpeed += 5;
        } else {
            this.currentSpeed = this.maxSpeed;
        }
    }

    /**
     * Subtracts 5 miles per hour from current speed
     * Remember: The minimum speed for the current speed is 0
     */
    public void brake() {
        if (this.currentSpeed > 0) {
            this.currentSpeed -= 5;
        } else {
            this.currentSpeed = 0;
        }
    }

    /**
     * This method returns the current speed of the car
     *
     * @return the current speed of the car
     */
    public int getCurrentSpeed() {
        return currentSpeed;
    }

    /**
     * @return the max speed of the car
     */
    public int getMaxSpeed() {
        return maxSpeed;
    }

    /**
     * This method returns the distance traveled by the car
     *
     * @return the distance traveled for the car
     */
    public double getdistanceTraveled() {
        return distanceTraveled;
    }

    public String getOwner() {
        return owner;
    }


    /**
     * This method returns the String carValue.
     * CarValue contains the information regarding the object
     * and how far it has traveled.
     *
     * @return the car values as a String
     */
    public String toString() {
        String carValue = "";

        carValue = String.format(owner + "'s car current speed: " + currentSpeed +
                " MPH, distance traveled: %.2f" + " miles", distanceTraveled);
        //String carValue = owner + "'s car current speed: " + currentSpeed +
        //        " MPH, distance traveled: " + distanceTraveled + " miles.";
        return carValue;
    }

    /**
     * reset the distance traveled, to start a new race.
     */
    public void resetDistance() {
        distanceTraveled = 0;
    }

    /**
     * reset the speed, to start a new race.
     */
    public void resetCurrentSpeed() {
        currentSpeed = 0;
    }
}
