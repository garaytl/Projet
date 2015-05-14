package fr.iutvalence.blancarayt.bataillenavale.model;

/**
 * Battleship's placement boat exception.
 *
 * @author léasilé
 * @version 2.0
 */

public final class Occupied extends Exception
{
	/**
	 * serial version UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Occupied constructor
	 * 
	 * @param message
	 */
	public Occupied(String message)
	{
		super(message);
	}
}
