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

	public Game(String pseudo1, String pseudo2)
	{
		this.player1 = new Player(pseudo1);
		this.player2 = new Player(pseudo2);
	}

	public void start()
	{
		Boat aircraftCarrier1 = new AircraftCarrier();
		askBoat(aircraftCarrier1, player1);
		/*Boat submarine1 = new Submarine();
		askBoat(submarine1, player1);
		Boat submarine2 = new Submarine();
		askBoat(submarine2, player1);
		Boat battleCruiser1 = new BattleCruiser();
		askBoat(battleCruiser1, player1);
		Boat destroyer1 = new Destroyer();
		askBoat(destroyer1, player1);*/
		clearConsole();
		/*Boat aircraftCarrier2 = new AircraftCarrier();
		askBoat(aircraftCarrier2, player2);
		Boat submarine3 = new Submarine();
		askBoat(submarine3, player2);
		Boat submarine4 = new Submarine();
		askBoat(submarine4, player2);
		Boat battleCruiser2 = new BattleCruiser();
		askBoat(battleCruiser2, player2);*/
		Boat destroyer3 = new Destroyer();
		askBoat(destroyer3, player2);
		clearConsole();
		while (Alive(player1) && Alive(player2))
		{
			display(player1, player2);
			attack(player1, player2);
			display(player2, player1);
			attack(player2, player1);
		}
		System.out.println("End of the game :");
		if (Alive(player1)==true)
		{
			System.out.print(player1);
		}
		else
		{
			System.out.print(player2);
		}
		System.out.print(" have win !");

	}
	
	private boolean Alive(Player player){
		return !(player.getPv()==0);
	}
	
	public void display(Player attackPlayer, Player hittedPlayer){
		clearConsole();
		System.out.println(attackPlayer.board.toString());
		System.out.println(hittedPlayer.board.toLimitedString());
	}
	
	public final static void clearConsole()
	{
	    try
	    {
	        final String os = System.getProperty("os.name");

	        if (os.contains("Windows"))
	        {
	            Runtime.getRuntime().exec("cls");
	        }
	        else
	        {
	            Runtime.getRuntime().exec("clear");
	        }
	    }
	    catch (final Exception e)
	    {
	        //  Handle any exceptions.
	    }
	}

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
	
	/*TODO poser bateau = en lettre+ chiffre*/
	
	/*TODO JAVADOC*/
	private boolean checkTirValid(int x, int y, Player hittedPlayer){
			try
			{
				hittedPlayer.board.checkCoordinate(x, y);
			}
			catch (Occupated e)
			{
			}
			catch (OutOfTheBoard e)
			{
				System.err.println(e.getMessage());
				return false;
			}
			if (hittedPlayer.board.cases[x][y].hitted() == true)
					System.out.println("Case already attacked");
		return !hittedPlayer.board.cases[x][y].hitted();
	}
	
	private int[] stringToInt(String string)throws UnvalidInput{
		String stry=null;
		String strx=null;
		int x,y;
		String coorUp = string.toUpperCase().trim();
		strx= coorUp.substring(0,1);
		if (coorUp.length()==2){
			stry= coorUp.substring(1,2);
		}
		else if (coorUp.length()==3){
			stry= coorUp.substring(1,3);
		}
		else 
			throw new UnvalidInput("Unvalid input");
		y = (Integer.parseInt(stry))-1;
		x = (strx.toCharArray()[0])-65;
		return new int[] {x,y};
	}
	
	private void attack(Player attackPlayer, Player hittedPlayer){
		Scanner sc = new Scanner(System.in);
		int x=0;
		int y=0;
		boolean Valid;
		System.out.println(attackPlayer+" ! Tip the coordonee of your attack ! (Letter and number)");
		do{
			String coor = sc.next();
			try{
			x=stringToInt(coor)[0];
			y=stringToInt(coor)[1];
			Valid=checkTirValid(x, y, hittedPlayer);
			}
			catch (UnvalidInput e){
				System.err.println(e.getMessage());
				Valid=false;
			}
		}while(!Valid);
		String result;
		if (hittedPlayer.board.cases[x][y].boat!=null)
		{
			hittedPlayer.board.cases[x][y].boat.hitted();
			if (hittedPlayer.board.cases[x][y].boat.condition == false)
			{
				result = "Coulé ! "+(hittedPlayer.getPv()-1)+" boat left";
				hittedPlayer.subPv();
			}
			else
			{
				result = "Touché !";
			}
			
		}
		else
		{
			result = "A l'eau..";
		}
		hittedPlayer.board.cases[x][y].hit();
		System.out.println(hittedPlayer.board.toLimitedString());
		System.out.println(result);
	}

	
	private void askBoat(Boat boat, Player player)
	{
		Scanner sc = new Scanner(System.in);
		boolean correctPlace = true;
		do
		{
			correctPlace = true;
			System.out.println("tip the depart x of "+player.getPseudo()+"'s "+ boat + " :");
			int x = sc.nextInt()-1;
			System.out.println("tip the depart y of "+player.getPseudo()+"'s " + boat + " :");
			int y = sc.nextInt()-1;
			boolean correctDir = true;
			Direction direction = null;
			do
			{
				correctDir = true;
				System.out.println("tip the direction of "+player.getPseudo()+"'s " + boat + " :");
				String Dir = sc.next();
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
			catch (OutOfTheBoard | Occupated f)
			{
				System.err.println(f.getMessage());
				correctPlace = false;
			}
		} while (!correctPlace);
		System.out.println(player.board.toString());
		player.addPv();
	}
}
