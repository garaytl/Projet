package fr.iutvalence.blancarayt.battleship;

import java.util.Scanner;

/**
 * Battleship's main class.
 * 
 * @author léasilé
 * @version 2.0
 *
 */
public final class Battleship
{
	/**
	 * The main method of the game.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Type the first player's pseudo");
		String pseudo1 = sc.nextLine();
		System.out.println("Type the second player's pseudo");
		String pseudo2 = sc.nextLine();
		Game game = new Game(pseudo1, pseudo2);
		game.start();
		sc.close();
	}
}
