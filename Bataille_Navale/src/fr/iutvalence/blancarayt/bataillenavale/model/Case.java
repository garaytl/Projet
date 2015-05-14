package fr.iutvalence.blancarayt.bataillenavale.model;

import fr.iutvalence.blancarayt.bataillenavale.model.ships.Boat;

/**
 * Board's box.
 *
 * @author léasilé
 * @version 2.0
 */

public final class Case
{
	/** Boat's reference. */
	private Boat boat;

	/**
	 * boolean : if the box was hit or not
	 */
	private boolean hitted;

	/**
	 * Box's constructor initialize without any boat and safe
	 * 
	 */
	public Case()
	{
		this.hitted = false;
		this.boat = null;
	}

	/**
	 * a method to show which boat if on the case
	 * 
	 * @return the reference of the boat
	 */
	public Boat getBoat()
	{
		return this.boat;
	}

	/**
	 * a method to place a boat on this case
	 * 
	 * @param boat
	 */
	public void placeBoat(Boat boat)
	{
		this.boat = boat;
	}

	/**
	 * Return if the box is occupied or not.
	 *
	 * @return true if the box is occupied and false if it's not
	 */
	public boolean occupated()
	{
		return this.boat != null;
	}

	/**
	 * a method to know if the case was hit or not
	 * 
	 * @return true if the case was hit and false if not
	 */
	public boolean hitted()
	{
		return this.hitted;
	}

	/**
	 * a method to hit the case
	 */
	public void hit()
	{
		this.hitted = true;
	}

	/**
	 * return a text representation of the box represented with "[O]" if the box
	 * is occupied and safe, [T] if the box is occupied and was hit, [C] if the
	 * boat is dead, [X] if the box is empty and hit and [ ] if the box is empty
	 * and safe.
	 */
	@Override
	public String toString()
	{
		if (this.boat != null)
		{
			if (this.boat.getCondition())
			{
				if (this.hitted)
				{
					return "[T]"; /* an already hit boat */
				}
				return "[0]"; /* safe boat */
			}
			return "[C]"; /* dead boat */
		}
		if (this.hitted)
		{
			return "[X]"; /* empty hit */
		}
		return "[ ]"; /* empty safe */
	}
}
