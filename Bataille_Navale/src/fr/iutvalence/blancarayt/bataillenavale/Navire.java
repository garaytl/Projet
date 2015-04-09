package fr.iutvalence.blancarayt.bataillenavale;

/* TODO Translate. */

/**
 * Battleship's boat.
 *
 * @author léasilé
 * @version TODO
 */
public abstract class Navire {
    /* TODO private/protected ? */
    /* TODO Translate. */
    /** Boat's size. */
    public final int     taille;
	/* TODO JAVADOC. */
	/* TODO Translate. */
    /** Boat's condition (dead or alive). */
    protected    boolean etat;
    /** Number of heal point. */
	/* TODO Translate. */
    protected    int     pv;

    /**
     * Built a floating boat with all his heal point.
     *
     * @param size boat's size
     */
    protected Navire(int size) {
        this.taille = size;
        this.etat = true;
        this.pv = size;
    }

    /* TODO Translate. */
    /**
     * The boat is hit.
     *
     * @return if the boat is still alive or not
     */
    public boolean estTouche() {
        this.pv--;
        if (this.pv == 0) {
            this.etat = false;
        }
        return etat;
    }
}
