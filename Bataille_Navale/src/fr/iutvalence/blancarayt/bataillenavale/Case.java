package fr.iutvalence.blancarayt.bataillenavale;

/**
 * Board's box.
 *
 * @author léasilé
 * @version 2.0
 */

public class Case {
    /** Default value : the box isn't occupated by a boat. */
    private static final boolean NO_DEFAULT_BOAT = false;
    /** Boat's reference. */
    protected  Boat  boat;
    /**
     * boolean : if the box was hit or not
     */
    private boolean hitted;

    /**
     * Box's constructor initialyse without any boat and safe
     * 
     */
    public Case() {
        hitted = false;
        boat = null;
    }

    /**
     * Return if the box is occupated or not.
     *
     * @return true if the box is occupated and false if it's not
     */
    public boolean occupated() {
        return this.boat != null;
    }

    public boolean hitted() {
    	return hitted;
    }
    /**
     * return a text representation of the box representated with "[O]" if the
     * box is occupated and safe, [T] if the box is occupated and was hited,
     * [C] if the boat is dead, [X] if the box is empty and hitted and [ ] 
     * if the box is empty and safe.
     */
    @Override
    public String toString() {
        if (boat != null) {
            if (boat.condition) {
                if (hitted) {
                    return "[T]"; /*hitted boat */
                }
                return "[0]"; /* safe boat */
            }
            return "[C]"; /* dead boat */
        }
        if (hitted) {
            return "[X]"; /* empty hitted */
        }
        return "[ ]"; /* empty safe */
    }
}
