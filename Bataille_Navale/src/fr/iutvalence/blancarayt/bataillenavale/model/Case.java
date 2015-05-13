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
	 * Box's constructor initialyse without any boat and safe
	 * 
	 */
	public Case()
	{
		hitted = false;
		boat = null;
	}
	
	/* TODO JAVADOC */
	public Boat getBoat(){
		return this.boat;
	}
	
	/* TODO JAVADOC */
	public void placeBoat(Boat boat){
		this.boat=boat;
	}
	
	/**
	 * Return if the box is occupated or not.
	 *
	 * @return true if the box is occupated and false if it's not
	 */
	public boolean occupated()
	{
		return this.boat != null;
	}

	/* TODO JAVADOC */
	public boolean hitted()
	{
		return hitted;
	}

	/* TODO JAVADOC */
	public void hit()
	{
		this.hitted = true;
	}

	/**
	 * return a text representation of the box representated with "[O]" if the
	 * box is occupated and safe, [T] if the box is occupated and was hited, [C]
	 * if the boat is dead, [X] if the box is empty and hitted and [ ] if the
	 * box is empty and safe.
	 */
	@Override
	public String toString()
	{
		if (boat != null)
		{
			if (boat.getCondition())
			{
				if (hitted)
				{
					return "[T]"; /* hitted boat */
				}
				return "[0]"; /* safe boat */
			}
			return "[C]"; /* dead boat */
		}
		if (hitted)
		{
			return "[X]"; /* empty hitted */
		}
		return "[ ]"; /* empty safe */
	}
}
