package fr.iutvalence.blancarayt.bataillenavale;

/**
* Battleship's aircraft carrier (extend of boat's class).
*
* @author léasilé
* @version 2.0
*/

public class AircraftCarrier extends Boat {
    /**
     * Size of an aircraft carrier.
     */
    private static final int SIZE = 5;

    /**
     * Method to see the size of the boat.
     */
    public AircraftCarrier() {
        super(SIZE);
    }
    public String toString(){
		return ("AircraftCarrier (" +SIZE+ " case)");
    }
}
