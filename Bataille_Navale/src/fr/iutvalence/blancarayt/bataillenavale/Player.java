package fr.iutvalence.blancarayt.bataillenavale;

/**
 * The player.
 *
 * @author léasilé
 * @version 2.0
 */
public class Player {

    /** Player's pseudo. */
    private final String pseudo;
    
    /** Player's winned games. */
    private int winnedGames;

    /**player's constructor initialyse with 0 winned games
     * 
     * @param a selected pseudo
     * 
     */
    public Player(String pseudo) {
        this.pseudo = pseudo;
        this.winnedGames = 0;
    }
}
