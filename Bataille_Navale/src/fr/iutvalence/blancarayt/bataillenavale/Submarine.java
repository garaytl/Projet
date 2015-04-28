package fr.iutvalence.blancarayt.bataillenavale;

/**
* Battleship's submarine (extend of boat's class).
*
* @author léasilé
* @version 2.0
*/

public class Submarine extends Boat {
    /**
     * Size of a submarine.
     */
    private static final int SIZE = 3;

    /**
     * Method to see the size of the boat.
     */
    public Submarine() {
        super(SIZE);
    }
}
