package fr.iutvalence.blancarayt.bataillenavale;

/**
 * Board's box.
 *
 * @author léasilé
 * @version 2.0
 */
public class Case {
    /* TODO Translate attribute name. */
    /** Default value : the box isn't occupated by a boat. */
    private static final boolean ABSENCE_DE_BATEAU_PAR_DEFAUT = false;
    /* TODO Should be private… */
    /** Boat's reference. */
    public  Navire  boat;
    /* TODO JAVADOC. */
    private boolean hitted;

    /* TODO JAVADOC. */
    public Case() {
        hitted = false;
        boat = null;
    }

    /* TODO Translate attribute name. */
    /**
     * Return if the box is occupated or not.
     *
     * @return true if the box is occupated and false if it's not
     */
    public boolean estOccupee() {
        return this.boat != null;
    }

    /* TODO Update JAVADOC. */
    /**
     * return a text representation of the box representated with "[O]" if the
     * box is occupated and [ ] if the box is empty.
     */
    @Override
    public String toString() {
        if (boat != null) {
            if (boat.etat) {
                if (hitted) {
                    return "[T]"; /*case du bateau touché */
                }
                return "[0]"; /* case du  bateau sain */
            }
            return "[C]"; /* bateau coulé */
        }
        if (hitted) {
            return "[X]"; /* tire dans l'eau */
        }
        return "[ ]"; /* case vide saine */
    }
}
