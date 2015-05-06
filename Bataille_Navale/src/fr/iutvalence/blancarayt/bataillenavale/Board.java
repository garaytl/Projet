package fr.iutvalence.blancarayt.bataillenavale;

/**
 * Battleship's board
 *
 * @author léasilé
 * @version 2.0
 */

public class Board
{
	/** The number of line */
	private static final int NUMBER_OF_LINE = 10;
	/** The number of column */
	private static final int NUMBER_OF_COLUMN = 10;
	/** board's boxes */
	private final Case[][] cases;

	/** built a new empty board */
	public Board()
	{
		this.cases = new Case[NUMBER_OF_LINE][NUMBER_OF_COLUMN];
		for (int linesNumber = 0; linesNumber < NUMBER_OF_LINE; linesNumber++)
		{
			for (int columnsNumber = 0; columnsNumber < NUMBER_OF_COLUMN; columnsNumber++)
			{
				this.cases[linesNumber][columnsNumber] = new Case();

			}
		}
	}

	private void checkCoordinate(int x, int y) throws Occupated, OutOfTheBoard {
		if (x > NUMBER_OF_LINE)
		{
			throw new OutOfTheBoard(String.format("x: %d > %d", x, NUMBER_OF_LINE));
			}
		if (x < 0)
		{
			throw new OutOfTheBoard(String.format("x: %d < 0", x));
			}
		if (y > NUMBER_OF_COLUMN)
		{
			throw new OutOfTheBoard(String.format("y: %d > %d", y, NUMBER_OF_COLUMN));
			}
		if (y < 0)
		{
			throw new OutOfTheBoard(String.format("y: %d < 0", y));
		}
		if (cases[x][y].boat != null)
		{
			throw new Occupated();
		}
		
	}
	public void placeBoat(int x, int y, Direction direction, Boat boat) throws OutOfTheBoard, Occupated
	{
		checkCoordinate(x, y);
		for (int i = 0; i < boat.size; i++)
		{
			switch(direction) {
				case LEFT: 
					checkCoordinate(x-i, y);
					break;
				case RIGHT:
					checkCoordinate(x+i, y);
					break;
				case UP:
					checkCoordinate(x, y-i);
					break;
				case DOWN:
					checkCoordinate(x, y+i);
					break;
			}
		}
			
		for (int i = 0; i < boat.size; i++)
		{
			switch(direction) {
			case LEFT: 
				cases[x-i][y].boat =boat;
				break;
			case RIGHT:
				cases[x+i][y].boat =boat;
				break;
			case UP:
				cases[x][y-i].boat =boat;
				break;
			case DOWN:
				cases[x][y+i].boat =boat;
				break;
			}
		}
	}

	@Override
	public String toString()
	{
		StringBuilder casesRepresentation = new StringBuilder(NUMBER_OF_LINE*(NUMBER_OF_COLUMN+1));

		for (int linesNumber = 0; linesNumber < NUMBER_OF_LINE; linesNumber++)
		{
			for (int columnsNumber = 0; columnsNumber < NUMBER_OF_COLUMN; columnsNumber++)
			{
				casesRepresentation.append(this.cases[linesNumber][columnsNumber]);
			}

			casesRepresentation.append("\n");
		}

		return casesRepresentation.toString();
	}
	
	public String toLimitedString()
	{
		StringBuilder casesRepresentation = new StringBuilder(3*NUMBER_OF_LINE*(NUMBER_OF_COLUMN+1));

		for (int linesNumber = 0; linesNumber < NUMBER_OF_LINE; linesNumber++)
		{
			for (int columnsNumber = 0; columnsNumber < NUMBER_OF_COLUMN; columnsNumber++)
			{
				Case c = cases[linesNumber][columnsNumber];
				casesRepresentation.append((c.occupated() && !c.hitted()) ? "[ ]" : c);	
			}
			casesRepresentation.append("\n");
		}
		return casesRepresentation.toString();
	}
}
