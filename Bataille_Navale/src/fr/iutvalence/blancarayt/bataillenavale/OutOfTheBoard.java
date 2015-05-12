package fr.iutvalence.blancarayt.bataillenavale;

/**
 * Battleship's placement boat exception.
 *
 * @author léasilé
 * @version 2.0
 */

public class OutOfTheBoard extends Exception {
	/* TODO This constructor should not be used. Prefer a message or a throwable. */
	public OutOfTheBoard(String message) {
		super("Coodonate out of the board : "+message);
	}
}
