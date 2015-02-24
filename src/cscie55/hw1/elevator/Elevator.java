package cscie55.hw1.elevator;

/**
 * This initial version of the Elevator class will keep track of the number of
 * passengers on each floor destined for each floor, and whether a stop on that
 * floor is required. Any number of passengers may board the elevator.
 *
 * @author Derm Duncan
 * @version 1.0
 */
public class Elevator {

    /** The number of floors the elevator goes up. */
    public static final int NUM_OF_FLOORS = 7;

    /** The elevators ground floor. */
    public static final int GROUND_FLOOR = 1;

    /** The elevators current location which defaults to the ground floor. */
    private int currentFloor = GROUND_FLOOR;

    /** Boolean to depict the direction the elevator is moving. */
    private Boolean goingUp = true;

    /** Array list which shows the amount of passengers destined for
     * each floor. */
    private int[] listOfPassengerDestinations;

    /** Array list which shows a true flag if the elevator should stop
     * on that floor. */
    private Boolean[] listOfFloorsToStop;

    /** Int to hold the total number of passengers in the elevator. */
    private int totalNumOfPassengers = 0;

    /** Constructor to set up the Elevators state. */
    public Elevator() {
        /** Initialize the passenger array to be the size of the num of floors. */
        listOfPassengerDestinations = new int[NUM_OF_FLOORS + 1];
        listOfFloorsToStop = new Boolean[NUM_OF_FLOORS + 1];

        /** Initialize each floor to have zero passengers. */
        for (int i = GROUND_FLOOR; i < NUM_OF_FLOORS; i++) {
            listOfPassengerDestinations[i] = 0;
            listOfFloorsToStop[i] = false;
        }
    }

    /**
     * Method which modifies the elevators state, moving it floor by floor in a
     * certain direction and clears the number of passengers destined for a
     * floor when a floor is reached. If it hits the ground or top floor it
     * switches direction.
     */
    public final void move() {
        /** Check the direction the elevator is moving. */
        if (goingUp) {
            if (currentFloor == NUM_OF_FLOORS) {
                currentFloor--;
                goingUp = false;
            } else {
                currentFloor++;
            }
        } else {
            if (currentFloor == GROUND_FLOOR) {
                currentFloor++;
                goingUp = true;
            } else {
                currentFloor--;
            }
        }

        /** Confirm that there are passengers on the floor. */
        if (listOfPassengerDestinations[currentFloor] > 0) {
            /** Remove all passengers getting off at this floor from the total number of passengers. */
            for (int i = 0; i < listOfPassengerDestinations[currentFloor]; i++) {
                totalNumOfPassengers--;
            }
        }

        /** Clear the lists of passengers on the current floor. */
        listOfPassengerDestinations[currentFloor] = 0;
        listOfFloorsToStop[currentFloor] = false;
    }

    /**
     * Method to add a passenger to the elevator and specify the floor they're
     * going to.
     *
     * @param floor The floor the passenger is going to.
     */
    public final void boardPassenger(final int floor) {
        /** Check to make sure the floor is valid. */
        if (floor > GROUND_FLOOR && NUM_OF_FLOORS > floor) {
            listOfPassengerDestinations[floor]++;
            totalNumOfPassengers++;
            listOfFloorsToStop[floor] = true;
        }
    }

    /**
     * Override the toString method to show the total number of passengers
     * in the elevator and the current floor the elevator is on.
     * @return sb.toString()
     */
    @Override public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Floor ");
        sb.append(currentFloor);
        sb.append(": ");
        sb.append(totalNumOfPassengers);
        sb.append(" passengers");

        return  sb.toString();
    }
}
