package fr.iutvalence.blancarayt.bataillenavale;

/**
 * Classe représentant une case du plateau
 * 
 * @author léasilé
 * 
 */
public class Case
{
	private final Position posi;
	private final boolean occupeParNavire;
	public final static boolean DEFAUT_occupeParNavire = false;

	/**
	 * Construire une case occupée ou non par un navire
	 * 
	 * @param occupation
	 *            si occupée ou non
	 */
	public Case(Position posi1, boolean occupation)
	{
		this.posi=posi1;
		if (occupation == false)
			this.occupeParNavire = DEFAUT_occupeParNavire;
		else
			this.occupeParNavire = occupation;
	}

	/**
	 * Obtenir si la case est occupée ou non
	 * 
	 * @return occupe ou non
	 */

	public boolean obtenirOccupation()
	{
		return this.occupeParNavire;
	}

	/**
	 * Retourne une représentation texte de la case, sous la forme d'un symbole
	 * "[O]" si la case est occupée, [ ] si la case est vide.
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		if (this.occupeParNavire == true)
			return "[0]";
		return "[ ]";
	}
}
