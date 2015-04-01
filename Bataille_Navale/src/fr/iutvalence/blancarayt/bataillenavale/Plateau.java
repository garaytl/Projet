package fr.iutvalence.blancarayt.bataillenavale;

/**
 * Plateau de bataille navale.
 *
 * @author léasilé
 * @version TODO
 */
public class Plateau {
    /** Le nombre de lignes. */
    private static final int NOMBRE_DE_LIGNES   = 10;
    /** Le nombre de colonnes. */
    private static final int NOMBRE_DE_COLONNES = 10;
    /* TODO Final ? */
    /** Les cases du plateau. */
    private Case[][] cases;

    /** Construire un nouveau plateau, vide. */
    public Plateau() {
        this.cases = new Case[NOMBRE_DE_LIGNES][NOMBRE_DE_COLONNES];
        for (int numeroDeLigne = 0; numeroDeLigne < NOMBRE_DE_LIGNES; numeroDeLigne++) {
            for (int numeroDeColonne = 0; numeroDeColonne < NOMBRE_DE_COLONNES; numeroDeColonne++) {
                Position posi = new Position(numeroDeLigne, numeroDeColonne);
                this.cases[numeroDeLigne][numeroDeColonne] = new Case(posi, false);

            }
        }
    }

    @Override
    public String toString() {
        /* TODO String vs StringBuffer vs StringBuilder. */
        String representationcase = "";

        for (int numeroDeLigne = 0; numeroDeLigne < NOMBRE_DE_LIGNES; numeroDeLigne++) {
            for (int numeroDeColonne = 0; numeroDeColonne < NOMBRE_DE_COLONNES; numeroDeColonne++) {
                representationcase += this.cases[numeroDeLigne][numeroDeColonne];
            }

            representationcase += "\n";
        }

        return representationcase;
    }
}
