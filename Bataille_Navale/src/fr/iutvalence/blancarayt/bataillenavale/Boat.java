package fr.iutvalence.blancarayt.bataillenavale;

/**
 * Battleship's boat.
 *
 * @author léasilé
 * @version 2.0
 */
public abstract class Boat {
    /** Boat's size. */
    protected final int size;
    
    /** Boat's condition (dead or alive). */
    protected boolean condition;
    
    /** Number of heal point. */
    protected int hp;

    /**
     * Built a floating boat with all his heal point.
     *
     * @param size boat's size
     */
    protected Boat(int size) {
        this.size = size;
        this.condition = true;
        this.hp = size;
    }

    /**
     * The boat is hit.
     *
     * @return if the boat is still alive or not
     */
    public boolean hitted() {
        this.hp--;
        if (this.hp == 0) {
            this.condition = false;
        }
        return condition;
    }
}
