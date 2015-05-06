package fr.iutvalence.blancarayt.bataillenavale;
import java.util.Scanner;

/**
 * Battleship's game.
 *
 * @author léasilé
 * @version 2.0
 */
public class Game
{
	/**
	 * Player 1.
	 */
	private Player player1;

	/**
	 * Player 2.
	 */
	private Player player2;

	public void start()
	{
		// TODO sysout de la grid
		
		Scanner sc = new Scanner(System.in);
		Boat boat = new AircraftCarrier();
		System.out.println("tip the depart's x of your "+boat+" :");
		int x = sc.nextInt();
		System.out.println("tip the depart's y of your "+boat+" :");
		int y = sc.nextInt();
		System.out.println("tip the direction of your "+boat+" :");
		Direction direction = sc.next();
		player1.addBoat(x, y, direction, boat);

		boat = new Submarine();
		System.out.println("tip the depart's x of your "+boat+" :");
		x = sc.nextInt();
		System.out.println("tip the depart's y of your "+boat+" :");
		y = sc.nextInt();
		System.out.println("tip the direction of your "+boat+" :");
		direction = sc.nextLine();
		player1.addBoat(x, y, direction, boat );
		
	}
	

	private void askBoat(Boat boat) {
		Scanner sc = new Scanner(System.in);
		System.out.println("tip the depart's x of your "+boat+" :");
		String x = sc.nextLine();
		System.out.println("tip the depart's y of your "+boat+" :");
		String y = sc.nextLine();
		System.out.println("tip the direction of your "+boat+" :");
		String direction = sc.nextLine();
	}
	
	public Game(String pseudo1, String pseudo2){
		this.player1 = new Player(pseudo1);
		this.player2 = new Player(pseudo2);
		
	}
}
