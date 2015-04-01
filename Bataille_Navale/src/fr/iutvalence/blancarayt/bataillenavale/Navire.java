package fr.iutvalence.blancarayt.bataillenavale;

/**
 * Navire de bataille navale
 *
 * @author léasilé
 * @version TODO
 */
public class Navire {
    /* TODO Coordonnées ? */
    /** Taille du bateau. */
    protected int     taille;
    /** L'état du bateau (mort ou vivant). */
    protected boolean etat;
    /** Nombre de fois où il peut être touché. */
    protected int     pv;

    /**
     * Construit un navire "vivant" avec tous ses PVs.
     *
     * @param taill taille du bateau
     */
    public Navire(int taill) {
        this.taille = taill;
        this.etat = true;
        this.pv = taill;
    }

    /* TODO JAVADOC. */
    public boolean estTouche() {
        if (--this.pv == 0) { this.etat = false; }
        return etat;
    }

}
