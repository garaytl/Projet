package fr.iutvalence.blancarayt.bataillenavale.model.ships;

/**
* Battleship's aircraft carrier (extend of boat's class).
*
* @author léasilé
* @version 2.0
*/

public final class AircraftCarrier extends Boat {
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
    
    /* TODO JAVADOC */
    public String toString(){
		return ("AircraftCarrier (" + SIZE + " case)");
    }
}
