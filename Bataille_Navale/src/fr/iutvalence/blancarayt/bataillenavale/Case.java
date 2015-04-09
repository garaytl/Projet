package fr.iutvalence.blancarayt.bataillenavale;

/**
 * board's box
 *
 * @author léasilé
 * @version 2.0
 **/

public class Case
{
	/** default value : the box isn't occupated by a boat */
	public static final boolean ABSENCE_DE_BATEAU_PAR_DEFAUT = false;
	/** boolean who care about the occupation of a boat in a box or not */
	private boolean hitted;
	/** boat's reference */
	public Navire refNavire;

	/**
	 * Built a box at the position given and place a boat or not
	 * 
	 * @param posi1
	 *            position of the box
	 * @param occupation
	 *            if the box is occupated by a boat or not
	 **/

	public Case()
	{
		hitted = false;
		refNavire = null;
	}

	/**
	 * Return if the box is occupated or not
	 *
	 * @return true if the box is occupated and false if it's not
	 */

	public boolean estOccupee()
	{
		return this.refNavire != null;
	}

	/**
	 * return a text representation of the box representated with "[O]" if the
	 * box is occupated and [ ] if the box is empty.
	 **/
	@Override
	public String toString()
	{
		if (refNavire != null)
		{
			if (refNavire.etat)
			{
				if (hitted)
				{
					return "[T]"; /*case du bateau touché */
				}
				return "[0]"; /* case du  bateau sain */
			}
			return "[C]"; /* bateau coulé */

		}
		if (hitted)
		{
			return "[X]"; /* tire dans l'eau */
		}
		return "[ ]"; /* case vide saine */
	}
}
