package fr.iutvalence.blancarayt.bataillenavale.model;

import fr.iutvalence.blancarayt.bataillenavale.model.ships.Boat;

/**
 * The player.
 *
 * @author léasilé
 * @version 2.0
 */
public final class Player
{
	/** Player's pseudo. */
	public final String pseudo;
	/** The player's board with his boats. */
	public Board board;
	/** The player's boats alive */
	public int hp;

	/**
	 * player's constructor initialize with 0 hp
	 * 
	 * @param pseudo
	 */
	public Player(String pseudo)
	{
		this.pseudo = pseudo;
		this.board = new Board();
		this.hp = 0;
	}

	/**
	 * a method to know if the player is alive or not
	 * 
	 * @return true if the player is alive and false if he is dead
	 */
	public boolean isAlive()
	{
		return this.hp > 0;
	}

	/**
	 * a method to see the player's hp
	 * 
	 * @return the player's hp
	 */
	public int getPv()
	{
		return this.hp;
	}

	/**
	 * a method to add an hp to the player
	 */
	public void addHp()
	{
		this.hp++;
	}

	/**
	 * a method to subtract an hp to the player
	 */
	public void subPv()
	{
		this.hp--;
	}

	/**
	 * Method to get the player's pseudo.
	 * 
	 * @return
	 */
	public String getPseudo()
	{
		return this.pseudo;
	}

	/**
	 * a method to place a Boat
	 * 
	 * @param x
	 * @param y
	 * @param direction
	 * @param boat
	 * @throws OutOfTheBoard
	 * @throws Occupied
	 */
	public void addBoat(int x, int y, Direction direction, Boat boat) throws OutOfTheBoard, Occupied
	{
		this.board.placeBoat(x, y, direction, boat);
	}

	/**
	 * over ride of "to string", return the player's pseudo
	 */
	@Override
	public String toString()
	{
		return (this.pseudo);
	}
}
