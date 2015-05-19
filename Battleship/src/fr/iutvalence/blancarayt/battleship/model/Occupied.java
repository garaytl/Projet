package fr.iutvalence.blancarayt.battleship.model;

/**
 * Battleship's placement boat exception.
 *
 * @author léasilé
 * @version 2.0
 */

public final class Occupied extends Exception
{
	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Occupied constructor.
	 * 
	 * @param message
	 */
	public Occupied(String message)
	{
		super(message);
	}
}
