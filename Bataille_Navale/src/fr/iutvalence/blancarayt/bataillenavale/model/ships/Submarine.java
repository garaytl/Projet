package fr.iutvalence.blancarayt.bataillenavale.model.ships;

/**
 * Battleship's submarine (extend of boat's class).
 *
 * @author léasilé
 * @version 2.0
 */

public final class Submarine extends Boat
{
	/**
	 * Size of a submarine.
	 */
	private static final int SIZE = 3;

	/**
	 * Method to see the size of the boat.
	 */
	public Submarine()
	{
		super(SIZE);
	}

	/**
	 * over ride of "to string", return the type of the boat
	 */
	@Override
	public String toString()
	{
		return ("Submarine (" + SIZE + " case)");
	}
}
