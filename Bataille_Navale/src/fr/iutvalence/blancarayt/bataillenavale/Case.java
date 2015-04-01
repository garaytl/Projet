package fr.iutvalence.blancarayt.bataillenavale;

/**
 * Case du plateau.
 *
 * @author léasilé
 * @version TODO
 */
public class Case {
    /* TODO JAVADOC. */
    public static final boolean ABSENCE_DE_BATEAU_PAR_DEFAUT = false;
    /* TODO JAVADOC. */
    private final Position posi;
    /* TODO JAVADOC. */
    private final boolean  occupeParNavire;

    /**
     * Construire à la position indiquée, occupée ou non par un navire.
     *
     * @param posi1      TODO
     * @param occupation Etat d'occupation
     */
    public Case(Position posi1, boolean occupation) {
        this.posi = posi1;
        /* TODO Voir pour une ternaire. */
        if (!occupation) { this.occupeParNavire = ABSENCE_DE_BATEAU_PAR_DEFAUT; }
        else { this.occupeParNavire = occupation; }
    }

    /**
     * Obtenir si la case est occupée ou non.
     *
     * @return occupe ou non
     */

    public boolean estOccupee() {
        return this.occupeParNavire;
    }

    /**
     * Retourne une représentation texte de la case, sous la forme d'un symbole
     * "[O]" si la case est occupée, [ ] si la case est vide.
     */
    @Override
    public String toString() {
        /* TODO ternaire ? */
        if (this.occupeParNavire) { return "[0]"; }
        return "[ ]";
    }
}
