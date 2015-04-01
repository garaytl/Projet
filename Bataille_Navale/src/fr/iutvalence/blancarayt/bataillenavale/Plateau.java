package fr.iutvalence.blancarayt.bataillenavale;

/**
 * Classe permettant de représenter un plateau de bataille navale
 * 
 * @author léasilé
 * 
 * 
 */
public class Plateau
{
	/**
	 * Le nombre de lignes
	 */
	private static final int NOMBRE_DE_LIGNES = 10;

	/**
	 * Le nombre de colonnes
	 */
	private static final int NOMBRE_DE_COLONNES = 10;

	/**
	 * Les cases du plateau
	 */
	private Case[][] cases;

	/**
	 * Construire un nouveau plateau, vide
	 */
	public Plateau()
	{
		this.cases = new Case[NOMBRE_DE_LIGNES][NOMBRE_DE_COLONNES];
		for (int numeroDeLigne = 0; numeroDeLigne < NOMBRE_DE_LIGNES; numeroDeLigne++)
			for (int numeroDeColonne = 0; numeroDeColonne < NOMBRE_DE_COLONNES; numeroDeColonne++)
			{
				Position posi = new Position(numeroDeLigne, numeroDeColonne);
				this.cases[numeroDeLigne][numeroDeColonne] = new Case(posi,false);

			}
	}

	/**
	 * Obtenir une représentation du plateau.
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		String representationcase = "";

		for (int numeroDeLigne = 0; numeroDeLigne < NOMBRE_DE_LIGNES; numeroDeLigne++)
		{
			for (int numeroDeColonne = 0; numeroDeColonne < NOMBRE_DE_COLONNES; numeroDeColonne++)
				representationcase += this.cases[numeroDeLigne][numeroDeColonne];

			representationcase += "\n";
		}

		return representationcase;
	}
}
