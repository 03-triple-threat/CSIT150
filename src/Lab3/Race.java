package Lab3;

/**
 * Race class used to simulate a race of cars
 * the cars are stored in an array
 * Uses a dice to decide which car and what action to take as the race progresses
 * <p>
 * CSIT 150 lab 3
 *
 * Date Created: 09/18/2017
 * @author AJ Hurtado
 */

public class Race {
    private static final double DEFAULTRACEDISTANCE = 500;
    private Car[] raceCars;
    private double distance;
    private String raceType;
    private Car winner;
    private int carCount;

    /**
     * Make a default array of cars
     * Be careful - each car is NULL at this point.
     */
    public Race(int numOfCars) {
        raceCars = new Car[numOfCars];
        carCount = 0;
    }

    /**
     * This method creates a race that takes in the number of cars
     * in the race and the distance of the race.
     *
     * @param inCarCount - number of cars in the race
     * @param distance - distance of the race
     */
    public Race(int inCarCount, double distance) {
        this(inCarCount);
        setDistance(distance);
    }

    /**
     * This method sets the distance of the race by taking
     * in a double.
     *
     * @param inDistance - distance of the race
     */
    public void setDistance(double inDistance) {
        distance = inDistance;
    }

    /**
     * This method sets the race type by taking in a String
     *
     * @param inType - type of race
     */
    public void setRaceType(String inType) {
        raceType = inType;
    }


    /**
     * this is a private method only called from other methods in this class
     *
     * @param winningCarNumber
     */
    private void setWinner(int winningCarNumber) {
        winner = raceCars[winningCarNumber];
    }

    /**
     * This method returns the winner of the race
     *
     * @return winner - winner of the race
     */
    public String getWinner() {
        if (winner == null) {
            return "No Winner";
        } else
            return winner.toString();
    }

    /**
     * This method returns the number of cars in the race
     *
     * @return carCount - number of cars in the race
     */
    public int getCarCount() {
        return carCount;
    }

    /**
     * This method adds a car to the array of Cars
     * by taking in a new Car object. The increaseSize
     * method is called within to add the object
     *
     * @param car - new car object
     */
    public void addCar(Car car) {

        //Adds race car into ArrayList raceCars
        if (raceCars == null || carCount == raceCars.length)
            increaseSize();

        raceCars[carCount] = new Car(car);
        carCount++;
    }

    /**
     * This method returns the distance of the race
     *
     * @param car - car object
     * @return getDistance - distance the specific car traveled
     */
    public double getDistance(Car car) {
        return getDistance(car);
    }

    /**
     * This method returns the type of race
     *
     * @param raceType - type of race
     * @return raceType - type of race
     */
    public String getRaceType(String raceType) {
        return raceType;
    }

    /**
     * DEEP copy
     */
    public Car[] getCars() {

        Car[] temp = new Car[carCount];
        for (int i = 0; i < carCount; i++)
            temp[i] = new Car(raceCars[i]);
        return temp;
    }

    /**
     * This method outputs the results and information on the race
     *
     * @return result - Information on the race
     */
    public String toString() {

        String result = "";

        if (raceCars != null && carCount > 0) {
            result += "Winner of the race: " + getWinner();

            result += "\n\nRace Information:\n\n";

            result += "Type of Race: " + raceType + "\n";
            result += "Number of Cars: " + carCount + "\n";
            result += "Race Distance: " + distance + "\n";

            result += "\n\nCars in the race:\n";

            for (int i = 0; i < carCount; i++)
                result += raceCars[i].toString() + "\n";
        } else
            result = "No Race";

        return result;
    }

    /**
     * This method runs the race by using the Dice class.
     * Each roll of the dice decides the next move of the car
     */
    public void runRace() {

        boolean raceOver = false;

        while (raceOver == false) {


            Dice raceDie = new Dice(carCount * 3);

            int diceRoll = raceDie.roll();
            int carToMove = (diceRoll - 1) / 3;
            int action = (diceRoll - 1) % 3;

            if (action == 0) {
                raceCars[carToMove].move();
                if (raceCars[carToMove].getdistanceTraveled() > distance) {
                    setWinner(carToMove);
                    raceOver = true;
                }
            } else if (action == 1)
                raceCars[carToMove].brake();
            else
                raceCars[carToMove].accelerate();
        }
    }

    /**
     * This method creates a new array by doubling the array of Cars and copying
     * the existing objects into the new array.
     */
    //-----------------------------------------------------------------
    //  Doubles the size of the collection by creating a larger array
    //  and copying the existing collection into it.
    //-----------------------------------------------------------------
    private void increaseSize() {
        if (raceCars == null) {
            raceCars = new Car[2];
            for (int i = 0; i < 2; i++)
                raceCars[i] = new Car();
        } else {
            Car[] temp = new Car[raceCars.length * 2];

            for (int car = 0; car < raceCars.length; car++)
                temp[car] = raceCars[car];

            raceCars = temp;
        }
    }


}
