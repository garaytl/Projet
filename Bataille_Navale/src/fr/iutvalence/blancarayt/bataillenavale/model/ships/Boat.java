package fr.iutvalence.blancarayt.bataillenavale.model.ships;

/**
 * Battleship's boat.
 *
 * @author léasilé
 * @version 2.0
 */
public abstract class Boat
{
	/** Boat's size. */
	private final int size;

	/** Boat's condition (dead or alive). */
	private boolean condition;

	/** Number of heal point. */
	private int hp;
	
	/* TODO JAVADOC */
	public final boolean getCondition(){
		return condition;
	}
	
	/* TODO JAVADOC */
	public final int getSize(){
		return size;
	}

	/**
	 * Built a floating boat with all his heal point.
	 *
	 * @param size
	 *            boat's size
	 */
	protected Boat(int size)
	{
		this.size = size;
		this.condition = true;
		this.hp = size;
	}

	/**
	 * The boat is hit.
	 *
	 * @return if the boat is still alive or not
	 */
	public final void hitted()
	{
		this.hp--;
		if (this.hp == 0)
		{
			this.condition = false;
		}
	}
}
