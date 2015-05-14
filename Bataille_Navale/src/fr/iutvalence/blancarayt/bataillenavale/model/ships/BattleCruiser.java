package fr.iutvalence.blancarayt.bataillenavale.model.ships;

/**
 * Battleship's Battle cruiser (extend of boat's class).
 *
 * @author léasilé
 * @version 2.0
 */

public final class BattleCruiser extends Boat
{
	/**
	 * Size of a battle cruiser.
	 */
	private static final int SIZE = 4;

	/**
	 * Method to see the size of the boat.
	 */
	public BattleCruiser()
	{
		super(SIZE);
	}

	/**
	 * over ride of "to string", return the type of the boat
	 */
	@Override
	public String toString()
	{
		return ("BattleCruiser (" + SIZE + " case)");
	}
}
