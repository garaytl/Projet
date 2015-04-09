package fr.iutvalence.blancarayt.bataillenavale;

/** The player */
public class Joueur {
    /** Player's pseudo */
    private final String pseudo;
    /** Player's winned games */
    private int partiesGagnees;
	
    /**
	 * @param pseudo
	 */
	public Joueur(String pseudo)
	{
		this.pseudo = pseudo;
		this.partiesGagnees = 0;
	}

/*    public boolean attaque(case) {
        boolean touche = false;

        if (case.occupeParNavire == true)
        touche = true;
        return touche;
    } */
}
