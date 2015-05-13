package fr.iutvalence.blancarayt.bataillenavale.model;

import fr.iutvalence.blancarayt.bataillenavale.model.ships.Boat;

/**
 * The player.
 *
 * @author léasilé
 * @version 2.0
 */
public final class Player {
    /** Player's pseudo. */
	public final String pseudo;
    /** The player's board with his boats.*/
    public Board board;
    /** The player's boats alive*/
    public int hp;
    
    /**player's constructor initialyse with 0 hp
     * 
     * @param a selected pseudo
     * 
     */
    public Player(String pseudo) {
        this.pseudo = pseudo;
        this.board = new Board();
        this.hp=0;
    }
    
    /* TODO JAVADOC */
    public boolean isAlive() {
    	return this.hp > 0;
    }
    
    /* TODO JAVADOC */
    public int getPv(){
    	return this.hp;
    }
    
    /* TODO JAVADOC */
    public void addPv(){
    	this.hp++;
    }
    
    /* TODO JAVADOC */
    public void subPv(){
    	this.hp--;
    }

    /** Method to get the player's pseudo. */
    public String getPseudo()
	{
		return pseudo;
	}
    
    /* TODO JAVADOC */
    public void addBoat(int x, int y, Direction direction, Boat boat) throws OutOfTheBoard, Occupated {
    	board.placeBoat(x, y, direction, boat);
    }
    
    /* TODO JAVADOC */
    public String toString() {
    	return (pseudo);
    }
}
