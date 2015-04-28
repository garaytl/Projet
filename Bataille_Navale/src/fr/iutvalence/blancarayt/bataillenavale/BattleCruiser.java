package fr.iutvalence.blancarayt.bataillenavale;

/**
* Battleship's Battle cruiser (extend of boat's class).
*
* @author léasilé
* @version 2.0
*/

public class BattleCruiser extends Boat {
    /**
     * Size of a battle cruiser.
     */
    private static final int SIZE = 4;

    /**
     * Method to see the size of the boat.
     */
    public BattleCruiser() {
        super(SIZE);
    }
}
