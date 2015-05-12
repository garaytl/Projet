package fr.iutvalence.blancarayt.bataillenavale;

/**
 * Battleship's placement boat exception.
 *
 * @author léasilé
 * @version 2.0
 */

public class Occupated extends Exception {
    /* TODO This constructor should not be used. Prefer a message or a throwable. */
    public Occupated(String message) {
    	super(message);
    }
}
