package fr.iutvalence.blancarayt.bataillenavale;

import java.util.Scanner;

import fr.iutvalence.blancarayt.bataillenavale.model.Occupated;
import fr.iutvalence.blancarayt.bataillenavale.model.OutOfTheBoard;

/**
 * Battleship's main class
 * 
 * @author garaytl
 *
 */
public final class Battleship
{	
	/* TODO JAVADOC */
	public static void main(String[] args) throws UnvalidInput, OutOfTheBoard,Occupated
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
