package fr.iutvalence.blancarayt.bataillenavale.model;

/**
 * Battleship's placement boat exception.
 *
 * @author léasilé
 * @version 2.0
 */

public final class Occupated extends Exception
{
	/**
	 * serial version UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Occupated constructor
	 * @param message
	 */
	public Occupated(String message)
	{
		super(message);
	}
}
