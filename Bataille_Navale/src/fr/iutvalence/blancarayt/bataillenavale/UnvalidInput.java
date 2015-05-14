package fr.iutvalence.blancarayt.bataillenavale;

/**
 * Battleship's exception
 *
 * @author léasilé
 * @version 2.0
 */

public final class UnvalidInput extends Exception
{
	/**
	 * serial version UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * UnvalidInput constructor
	 * 
	 * @param message
	 */
	public UnvalidInput(String message)
	{
		super(message);
	}
}
