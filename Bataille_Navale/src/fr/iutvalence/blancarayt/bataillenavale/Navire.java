package fr.iutvalence.blancarayt.bataillenavale;

/**
 * Battleship's boat
 *
 * @author léasilé
 * @version TODO
 */
public abstract class Navire
{
	/** boat's size */
	public final int taille;
	/** boat's condition (dead or alive) */
	protected boolean etat;
	/** Number of heal point */
	protected int pv;

	/**
	 * Built a floating boat with all his heal point
	 *
	 * @param taill
	 *            boat's size
	 **/
	protected Navire(int taill)
	{
		this.taille = taill;
		this.etat = true;
		this.pv = taill;
	}

	/**
	 * the boat is hit
	 * 
	 * @return if the boat is still alive or not
	 **/
	public boolean estTouche()
	{
		this.pv--;
		if (this.pv == 0)
		{
			this.etat = false;
		}
		return etat;
	}

}
