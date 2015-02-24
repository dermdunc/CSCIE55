package cscie55.hw1.elevatortest;

import cscie55.hw1.elevator.Elevator;

/**
 * Test which creates an Elevator object,
 * boards two passengers for the 3nd floor,
 * and one for the 5th floor. Then moves the
 * Elevator from the ground floor to the top
 * floor, and then back to the ground floor.
 */
public class ElevatorTest {

    /**
     * Main test method.
     * @param args
     */
    private static void main(final String[] args) {
        int thirdFloor = 3;
        int fifthFloor = 5;

        Elevator elevator = new Elevator();
        /** Board 2 passengers for the 3rd floor.
         * */
        elevator.boardPassenger(thirdFloor);
        elevator.boardPassenger(thirdFloor);

        /** Board 1 passenger for the 5th floor.
         * */
        elevator.boardPassenger(fifthFloor);

        /**
         * Want to go from the ground floor to the
         * top floor and back down to the ground
         * floor again.
         * */
        for (int i = Elevator.GROUND_FLOOR;
             i < (Elevator.NUM_OF_FLOORS * 2); i++) {

            System.out.println(elevator.toString());
            elevator.move();
        }
    }
}
