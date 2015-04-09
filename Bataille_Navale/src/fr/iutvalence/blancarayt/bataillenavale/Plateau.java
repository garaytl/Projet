package fr.iutvalence.blancarayt.bataillenavale;

/**
 * Battleship's board
 *
 * @author léasilé
 * @version 2.0
 */

public class Plateau
{
	/** The number of line */
	private static final int NOMBRE_DE_LIGNES = 10;
	/** The number of column */
	private static final int NOMBRE_DE_COLONNES = 10;
	/** board's boxes */
	private final Case[][] cases;

	/** built a new empty board */
	public Plateau()
	{
		this.cases = new Case[NOMBRE_DE_LIGNES][NOMBRE_DE_COLONNES];
		for (int numeroDeLigne = 0; numeroDeLigne < NOMBRE_DE_LIGNES; numeroDeLigne++)
		{
			for (int numeroDeColonne = 0; numeroDeColonne < NOMBRE_DE_COLONNES; numeroDeColonne++)
			{
				this.cases[numeroDeLigne][numeroDeColonne] = new Case();

			}
		}
	}

	public void poserBateau(int x, int y, Direction direction, Navire navire) throws enDehorsDuTableau, caseOccupee
	{
		if (x > NOMBRE_DE_LIGNES)
		{
			throw new enDehorsDuTableau();
			}
		if (x < 0)
		{
			throw new enDehorsDuTableau();
			}
		if (y > NOMBRE_DE_COLONNES)
		{
			throw new enDehorsDuTableau();
			}
		if (y < 0)
		{
			throw new enDehorsDuTableau();
			}
		
		cases[x][y].boat = navire;
		int i;
		boolean b;
		for (i = 0; i < navire.taille; i++)
		{
			if (direction == Direction.GAUCHE)
			{
				if (cases[x-i][y].boat !=null)
				{
					throw new caseOccupee();
					}
				if (x-i > NOMBRE_DE_LIGNES)
				{
					throw new enDehorsDuTableau();
					}
			} 
			else if (direction == Direction.DROITE)
			{	
				if (cases[x+i][y].boat !=null)
				{
					throw new caseOccupee();
					}
				if (x+i > NOMBRE_DE_LIGNES)
				{
					throw new enDehorsDuTableau();
					}
			} 
			else if (direction == Direction.HAUT)
			{	
				if (cases[x][y-i].boat !=null)
				{
					throw new caseOccupee();
					}
				if (y-i > NOMBRE_DE_LIGNES)
				{
					throw new enDehorsDuTableau();
					}
			} 
			else if (direction == Direction.BAS)
			{
				if (cases[x][y+i].boat !=null)
				{
					throw new caseOccupee();
					}
				if (y+i > NOMBRE_DE_LIGNES)
				{
					throw new enDehorsDuTableau();
					}
			}
		}
		for (i = 0; i < navire.taille; i++)
		{
			if (direction == Direction.GAUCHE)
			{
				cases[x-i][y].boat =navire;
			} 
			else if (direction == Direction.DROITE)
			{	
				cases[x+i][y].boat =navire;
			} 
			else if (direction == Direction.HAUT)
			{	
				cases[x][y-i].boat =navire;
			} 
			else if (direction == Direction.BAS)
			{
				cases[x][y+i].boat =navire;
			}
		}
	}

	@Override
	public String toString()
	{
		/* TODO String vs StringBuffer vs StringBuilder. */
		String representationcase = "";

		for (int numeroDeLigne = 0; numeroDeLigne < NOMBRE_DE_LIGNES; numeroDeLigne++)
		{
			for (int numeroDeColonne = 0; numeroDeColonne < NOMBRE_DE_COLONNES; numeroDeColonne++)
			{
				representationcase += this.cases[numeroDeLigne][numeroDeColonne];
			}

			representationcase += "\n";
		}

		return representationcase;
	}
}
