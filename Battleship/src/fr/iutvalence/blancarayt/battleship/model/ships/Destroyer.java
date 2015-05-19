package fr.iutvalence.blancarayt.battleship.model.ships;

/**
 * Battleship's destroyer (extend of boat's class).
 *
 * @author léasilé
 * @version 2.0
 */

public final class Destroyer extends Boat
{
	/**
	 * Size of a battle cruiser.
	 */
	private static final int SIZE = 2;

	/**
	 * Method to see the size of the boat.
	 */
	public Destroyer()
	{
		super(SIZE);
	}

	/**
	 * Over ride of "to string", return the type of the boat and his size.
	 */
	@Override
	public String toString()
	{
		return ("Destroyer (" + SIZE + " case)");
	}
}
