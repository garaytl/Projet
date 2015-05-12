package fr.iutvalence.blancarayt.bataillenavale;

/**
* Battleship's destroyer (extend of boat's class).
*
* @author léasilé
* @version 2.0
*/

public class Destroyer extends Boat {
    /**
     * Size of a battle cruiser.
     */
    private static final int SIZE = 2;

    /**
     * Method to see the size of the boat.
     */
    public Destroyer() {
        super(SIZE);
    }

    public String toString(){
		return ("Destroyer (" +SIZE+ " case)");
    }
}
