package fr.iutvalence.blancarayt.bataillenavale;

import java.util.Scanner;

import fr.iutvalence.blancarayt.bataillenavale.model.Direction;
import fr.iutvalence.blancarayt.bataillenavale.model.Occupated;
import fr.iutvalence.blancarayt.bataillenavale.model.OutOfTheBoard;
import fr.iutvalence.blancarayt.bataillenavale.model.Player;
import fr.iutvalence.blancarayt.bataillenavale.model.ships.AircraftCarrier;
import fr.iutvalence.blancarayt.bataillenavale.model.ships.BattleCruiser;
import fr.iutvalence.blancarayt.bataillenavale.model.ships.Boat;
import fr.iutvalence.blancarayt.bataillenavale.model.ships.Destroyer;
import fr.iutvalence.blancarayt.bataillenavale.model.ships.Submarine;

/**
 * Battleship's game.
 *
 * @author léasilé
 * @version 2.0
 */
final class Game
{
	/**
	 * Player 1.
	 */
	private final Player player1;

	/**
	 * Player 2.
	 */
	private final Player player2;
	
	/* TODO JAVADOC */
	private final Scanner sc;
	
	/* TODO JAVADOC */
	public Game(String pseudo1, String pseudo2)
	{
		this.player1 = new Player(pseudo1);
		this.player2 = new Player(pseudo2);
		this.sc = new Scanner(System.in);
	}
	
	/* TODO JAVADOC */
	public void start()
	{
		Boat aircraftCarrier1 = new AircraftCarrier();
		askBoat(aircraftCarrier1, player1);
		Boat submarine1 = new Submarine();
		askBoat(submarine1, player1);
		Boat submarine2 = new Submarine();
		askBoat(submarine2, player1);
		Boat battleCruiser1 = new BattleCruiser();
		askBoat(battleCruiser1, player1);
		Boat destroyer1 = new Destroyer();
		askBoat(destroyer1, player1);
		clearConsole();
		Boat aircraftCarrier2 = new AircraftCarrier();
		askBoat(aircraftCarrier2, player2);
		Boat submarine3 = new Submarine();
		askBoat(submarine3, player2);
		Boat submarine4 = new Submarine();
		askBoat(submarine4, player2);
		Boat battleCruiser2 = new BattleCruiser();
		askBoat(battleCruiser2, player2);
		Boat destroyer3 = new Destroyer();
		askBoat(destroyer3, player2);
		clearConsole();
		while (player1.isAlive() && player2.isAlive())
		{
			display(player1, player2);
			attack(player1, player2);
			display(player2, player1);
			attack(player2, player1);
		}
		System.out.println("End of the game :");
		if (player1.isAlive() == true)
		{
			System.out.print(player1);
		} else
		{
			System.out.print(player2);
		}
		System.out.print(" is the winner !");
		sc.close();

	}

	/* TODO JAVADOC */
	private void display(Player attackPlayer, Player hittedPlayer)
	{
		clearConsole();
		System.out.println(attackPlayer.board.toString());
		System.out.println(hittedPlayer.board.toLimitedString());
	}
	
	/* TODO JAVADOC */
	private static void clearConsole()
	{
		try
		{
			final String os = System.getProperty("os.name");

			if (os.contains("Windows"))
			{
				Runtime.getRuntime().exec("clear");
			} else
			{
				Runtime.getRuntime().exec("clear");
			}
		} catch (final Exception e)
		{
			// Handle any exceptions.
		}
	}
	
	/* TODO JAVADOC */
	private Direction stringToDirection(String dir) throws UnvalidInput
	{
		Direction direction;
		String dirUp = dir.toUpperCase().trim();
		switch (dirUp)
		{
		case "LEFT":
			direction = Direction.LEFT;
			break;
		case "RIGHT":
			direction = Direction.RIGHT;
			break;
		case "UP":
			direction = Direction.UP;
			break;
		case "DOWN":
			direction = Direction.DOWN;
			break;
		default:
			throw new UnvalidInput("The direction " + dir
					+ " is invalid please type LEFT, RIGHT, UP or DOWN");
		}
		return direction;
	}

	/* TODO JAVADOC */
	private boolean checkTirValid(int x, int y, Player hittedPlayer)
	{
		try
		{
			hittedPlayer.board.checkCoordinate(x, y);
		} catch (Occupated e)
		{
		} catch (OutOfTheBoard e)
		{
			System.err.println(e.getMessage());
			return false;
		}
		if (hittedPlayer.board.getCase(x,y).hitted() == true)
			System.out.println("Case already attacked");
		return !hittedPlayer.board.getCase(x,y).hitted();
	}
	
	/* TODO JAVADOC */
	private int[] stringToInt(String string) throws UnvalidInput
	{
		String stry = null;
		String strx = null;
		int x, y;
		String coorUp = string.toUpperCase().trim();
		strx = coorUp.substring(0, 1);
		if (coorUp.length() == 2)
		{
			stry = coorUp.substring(1, 2);
			y = (stry.toCharArray()[0]) - 49;
		} else if (coorUp.length() == 3)
		{
			stry = coorUp.substring(1, 3);
			y = ((stry.toCharArray()[0]) - 49) * 10 + (stry.toCharArray()[1])
					- 49;
		} else
			throw new UnvalidInput("Unvalid input");
		x = (strx.toCharArray()[0]) - 65;
		return new int[] { x, y };
	}
	
	/* TODO JAVADOC */
	private void attack(Player attackPlayer, Player hittedPlayer)
	{
		
		int x = 0, y = 0;
		boolean Valid;
		System.out.println(attackPlayer+ " ! Tip the coordonee of your attack ! (Letter and number)");
		do
		{
			String coor = sc.next();
			try
			{
				x = stringToInt(coor)[0];
				y = stringToInt(coor)[1];
				Valid = checkTirValid(x, y, hittedPlayer);
			} catch (UnvalidInput e)
			{
				System.err.println(e.getMessage());
				Valid = false;
			}
		} while (!Valid);
		String result;
		if (hittedPlayer.board.getCase(x,y).getBoat() != null)
		{
			hittedPlayer.board.getCase(x,y).getBoat().hitted();
			if (hittedPlayer.board.getCase(x,y).getBoat().getCondition() == false)
			{
				result = "Coulé ! " + (hittedPlayer.getPv() - 1) + " boat left";
				hittedPlayer.subPv();
			} else
			{
				result = "Touché !";
			}

		} else
		{
			result = "A l'eau..";
		}
		hittedPlayer.board.getCase(x,y).hit();
		System.out.println(hittedPlayer.board.toLimitedString());
		System.out.println(result);
	}

	/* TODO JAVADOC */
	private void askBoat(Boat boat, Player player)
	{
		boolean correctPlace = true;
		do
		{
			correctPlace = true;
			System.out.println("tip the depart position of "
					+ player.getPseudo() + "'s " + boat
					+ " : (letter + number)");
			int x = 0, y = 0;
			boolean Valid = true;
			do
			{
				String position = sc.next();
				try
				{
					y = stringToInt(position)[0];
					x = stringToInt(position)[1];
					Valid = true;
				} catch (UnvalidInput e)
				{
					System.err.println(e.getMessage());
					Valid = false;
				}
			} while (!Valid);
			boolean correctDir = true;
			Direction direction = null;
			do
			{
				correctDir = true;
				System.out.println("tip the direction of " + player.getPseudo()
						+ "'s " + boat + " :");
				String Dir = sc.next();
				try
				{
					direction = stringToDirection(Dir);
				} catch (UnvalidInput e)
				{
					System.err.println(e.getMessage());
					correctDir = false;
				}
			} while (!correctDir);
			try
			{
				player.addBoat(x, y, direction, boat);
			} catch (OutOfTheBoard | Occupated f)
			{
				System.err.println(f.getMessage());
				correctPlace = false;
			}
		} while (!correctPlace);
		System.out.println(player.board.toString());
		player.addPv();
		
	}
}
