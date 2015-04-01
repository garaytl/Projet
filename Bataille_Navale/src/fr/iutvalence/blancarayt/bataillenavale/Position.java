package fr.iutvalence.blancarayt.bataillenavale;

/* TODO Cette classe est-elle immutable (i.e. peut-on changer de position ?). Si on ne peut changer de position les champs sont finaux. */
/**
 * Position sur le plateau.
 *
 * @author léasilé
 * @version TODO
 */
public class Position {
    /** Abscisse. */
    private int abscisse;
    /** Ordonnée. */
    private int ordonnee;

    /* TODO Aucune contrainte sur la position ? */
    /** Créer une nouvelle position. */
    public Position(int x, int y) {
        this.abscisse = x;
        this.ordonnee = y;
    }
}
