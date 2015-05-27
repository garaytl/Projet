package fr.iutvalence.blancarayt.battleship;

import java.util.Scanner;

import fr.iutvalence.blancarayt.battleship.model.Direction;
import fr.iutvalence.blancarayt.battleship.model.Occupied;
import fr.iutvalence.blancarayt.battleship.model.OutOfTheBoard;
import fr.iutvalence.blancarayt.battleship.model.Player;
import fr.iutvalence.blancarayt.battleship.model.ships.AircraftCarrier;
import fr.iutvalence.blancarayt.battleship.model.ships.BattleCruiser;
import fr.iutvalence.blancarayt.battleship.model.ships.Boat;
import fr.iutvalence.blancarayt.battleship.model.ships.Destroyer;
import fr.iutvalence.blancarayt.battleship.model.ships.Submarine;

/**
 * Battleship's game.
 *
 * @author léasilé
 * @version 2.0
 */
public final class Game
{
	/**
	 * Player 1.
	 */
	private final Player player1;

	/**
	 * Player 2.
	 */
	private final Player player2;

	/**
	 * the Scanner for the game's input.
	 */
	private final Scanner sc;

	/**
	 * Game's constructor.
	 * 
	 * @param pseudo1
	 *            the first player's pseudo
	 * @param pseudo2
	 *            the second player's pseudo
	 */
	public Game(String pseudo1, String pseudo2)
	{
		this.player1 = new Player(pseudo1);
		this.player2 = new Player(pseudo2);
		this.sc = new Scanner(System.in);
	}

	/**
	 * A method to start the game and play.
	 */
	public void start()
	{
		System.out.println("\n\n" + this.player1.board.toString());
		Boat aircraftCarrier1 = new AircraftCarrier();
		askBoat(aircraftCarrier1, this.player1);
		Boat submarine1 = new Submarine();
		askBoat(submarine1, this.player1);
		Boat submarine2 = new Submarine();
		askBoat(submarine2, this.player1);
		Boat battleCruiser1 = new BattleCruiser();
		askBoat(battleCruiser1, this.player1);
		Boat destroyer1 = new Destroyer();
		askBoat(destroyer1, this.player1);
		clearConsole();
		System.out.println(this.player2.board.toString());
		Boat aircraftCarrier2 = new AircraftCarrier();
		askBoat(aircraftCarrier2, this.player2);
		Boat submarine3 = new Submarine();
		askBoat(submarine3, this.player2);
		Boat submarine4 = new Submarine();
		askBoat(submarine4, this.player2);
		Boat battleCruiser2 = new BattleCruiser();
		askBoat(battleCruiser2, this.player2);
		Boat destroyer3 = new Destroyer();
		askBoat(destroyer3, this.player2);
		clearConsole();
		while (this.player1.isAlive() && this.player2.isAlive())
		{
			display(this.player1, this.player2);
			attack(this.player1, this.player2);
			display(this.player2, this.player1);
			attack(this.player2, this.player1);
		}
		System.out.println("End of the game :");
		if (this.player1.isAlive() == true)
		{
			System.out.print(this.player1);
		} else
		{
			System.out.print(this.player2);
		}
		System.out.print(" is the winner !");
		this.sc.close();

	}

	/**
	 * A method to display the attacking player's board and the attacked
	 * player's board.
	 * 
	 * @param attackPlayer
	 *            the attacking player
	 * @param hittedPlayer
	 *            the attacked player
	 */
	private static void display(Player attackPlayer, Player hittedPlayer)
	{
		clearConsole();
		System.out.println(attackPlayer.board.toString());
		System.out.println(hittedPlayer.board.toLimitedString());
	}

	/**
	 * A method to clear the console.
	 */
	private static void clearConsole()
	{
		try
		{
			final String os = System.getProperty("os.name");

			if (os.contains("Windows"))
			{
				Runtime.getRuntime().exec("clr");
			} else
			{
				Runtime.getRuntime().exec("clear");
			}
		}
		catch (final Exception e)
		{
			System.out
					.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		}
	}

	/**
	 * A method which convert a string like "left", "right", "up" or "down" to a
	 * direction.
	 * 
	 * @param dir
	 *            the string to convert
	 * @return the string dir convert to a direction
	 * @throws UnvalidInput
	 *             if the input isn't a correct direction
	 */
	private static Direction stringToDirection(String dir) throws UnvalidInput
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

	/**
	 * Check if the attacked player's case at x , y wasn't already hit.
	 * 
	 * @param x
	 * @param y
	 * @param hittedPlayer
	 *            the attacked player
	 * @return true if the case wasn't already hit and false if the case was
	 *         already hit
	 */
	private static boolean checkTirValid(int x, int y, Player hittedPlayer)
	{
		try
		{
			hittedPlayer.board.checkCoordinate(x, y);
		}
		catch (Occupied e)
		{
			// we don't have to know (has a attacking player) if the case is
			// empty or occupied when we attack
		}
		catch (OutOfTheBoard e)
		{
			System.err.println(e.getMessage());
			return false;
		}
		if (hittedPlayer.board.getCase(x, y).hitted() == true)
			System.out.println("Case already attacked");
		return !hittedPlayer.board.getCase(x, y).hitted();
	}

	/**
	 * Convert a "typical battelship's call" like A1 to an x and an y.
	 * 
	 * @param string
	 *            a "typical battelship's call" like A1
	 * @return an x and an y
	 * @throws UnvalidInput
	 *             if the string wasn't a valid "typical battelship's call"
	 */
	private static int[] stringToInt(String string) throws UnvalidInput
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
		}
		else if (coorUp.length() == 3)
		{
			stry = coorUp.substring(1, 3);
			y = ((stry.toCharArray()[0]) - 49) * 10 + (stry.toCharArray()[1])
					- 49;
		}
		else
			throw new UnvalidInput("Unvalid input");
		x = (strx.toCharArray()[0]) - 65;
		return new int[] { x, y };
	}

	/**
	 * A method to attack the other player.
	 * 
	 * @param attackPlayer
	 *            the attacking player
	 * @param hittedPlayer
	 *            the attacked player
	 */
	private void attack(Player attackPlayer, Player hittedPlayer)
	{

		int x = 0, y = 0;
		boolean Valid;
		System.out.println(attackPlayer
				+ " ! Tip the coordinate of your attack ! (Letter and number)");
		do
		{
			String coor = this.sc.next();
			try
			{
				x = stringToInt(coor)[0];
				y = stringToInt(coor)[1];
				Valid = checkTirValid(x, y, hittedPlayer);
			}
			catch (UnvalidInput e)
			{
				System.err.println(e.getMessage());
				Valid = false;
			}
		} while (!Valid);
		String result;
		if (hittedPlayer.board.getCase(x, y).getBoat() != null)
		{
			hittedPlayer.board.getCase(x, y).getBoat().hitted();
			if (hittedPlayer.board.getCase(x, y).getBoat().getCondition() == false)
			{
				result = "Sink ! " + (hittedPlayer.getPv() - 1) + " boat left";
				hittedPlayer.subPv();
			}
			else
			{
				result = "Hit !";
			}

		}
		else
		{
			result = "Miss..";
		}
		hittedPlayer.board.getCase(x, y).hit();
		System.out.println(hittedPlayer.board.toLimitedString());
		System.out.println(result);
	}

	/**
	 * A method to place a boat on a player's board the method will ask witch
	 * coordinate you want and check if what you tip is valid.
	 * 
	 * @param boat
	 *            the boat you want to place
	 * @param player
	 *            the owner of the boat
	 */
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
				String position = this.sc.next();
				try
				{
					y = stringToInt(position)[0];
					x = stringToInt(position)[1];
					Valid = true;
				}
				catch (UnvalidInput e)
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
				String Dir = this.sc.next();
				try
				{
					direction = stringToDirection(Dir);
				}
				catch (UnvalidInput e)
				{
					System.err.println(e.getMessage());
					correctDir = false;
				}
			} while (!correctDir);
			try
			{
				player.addBoat(x, y, direction, boat);
			}
			catch (OutOfTheBoard | Occupied f)
			{
				System.err.println(f.getMessage());
				correctPlace = false;
			}
		} while (!correctPlace);
		System.out.println(player.board.toString());
		player.addHp();

	}
}
