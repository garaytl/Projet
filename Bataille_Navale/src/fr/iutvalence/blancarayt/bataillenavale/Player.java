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
    /** The player's board with his boats.*/
    protected Board board;
    
    /**player's constructor initialyse with 0 winned games
     * 
     * @param a selected pseudo
     * 
     */
    public Player(String pseudo) {
        this.pseudo = pseudo;
        this.winnedGames = 0;
        this.board = new Board();
    }
    
    /** Method to get the player's pseudo. */
    public String getPseudo()
	{
		return pseudo;
	}
    
    public void addBoat(int x, int y, Direction direction, Boat boat) throws OutOfTheBoard, Occupated {
    	board.placeBoat(x, y, direction, boat);
    }
    // TODO Afficher l'état du joueur et éventuellement sur deux méthodes selon le choix pour l'affichage de la board de l'autre joueur.
    
}
