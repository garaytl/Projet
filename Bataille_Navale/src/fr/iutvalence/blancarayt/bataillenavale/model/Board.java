package fr.iutvalence.blancarayt.bataillenavale.model;

import fr.iutvalence.blancarayt.bataillenavale.model.ships.Boat;

/**
 * Battleship's board
 *
 * @author léasilé
 * @version 2.0
 */

public final class Board
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

	/* TODO JAVADOC */
	public Case getCase(int x, int y){
		return this.cases[x][y];
	}
	
	/* TODO JAVADOC */
	public void checkCoordinate(int x, int y) throws Occupated,
			OutOfTheBoard
	{
		if (x > NUMBER_OF_LINE)
		{
			throw new OutOfTheBoard(String.format("x: %d > %d", x + 1,
					NUMBER_OF_LINE));
		}
		if (x < 0)
		{
			throw new OutOfTheBoard(String.format("x: %d < 1", x + 1));
		}
		if (y > NUMBER_OF_COLUMN)
		{
			throw new OutOfTheBoard(String.format("y: %d > %d", y + 1,
					NUMBER_OF_COLUMN));
		}
		if (y < 0)
		{
			throw new OutOfTheBoard(String.format("y: %d < 1", y + 1));
		}
		if (cases[x][y].getBoat() != null)
		{
			throw new Occupated("Occupated Case");
		}

	}

	/* TODO JAVADOC */
	public void placeBoat(int x, int y, Direction direction, Boat boat)
			throws OutOfTheBoard, Occupated
	{
		checkCoordinate(x, y);
		for (int i = 0; i < boat.getSize(); i++)
		{
			switch (direction)
			{
			case LEFT:
				checkCoordinate(x, y - i);
				break;
			case RIGHT:
				checkCoordinate(x, y + i);
				break;
			case UP:
				checkCoordinate(x - i, y);
				break;
			case DOWN:
				checkCoordinate(x + i, y);
				break;
			}
		}

		for (int i = 0; i < boat.getSize(); i++)
		{
			switch (direction)
			{
			case LEFT:
				cases[x][y - i].placeBoat(boat);
				break;
			case RIGHT:
				cases[x][y + i].placeBoat(boat);
				break;
			case UP:
				cases[x - i][y].placeBoat(boat);
				break;
			case DOWN:
				cases[x + i][y].placeBoat(boat);
				break;
			}
		}
	}

	/* TODO JAVADOC */
	@Override
	public String toString()
	{
		StringBuilder casesRepresentation = new StringBuilder(NUMBER_OF_LINE
				* (NUMBER_OF_COLUMN + 1));
		casesRepresentation.append("Our board : \n");
		casesRepresentation.append("   ");
		for (int columnsNumber = 0; columnsNumber < NUMBER_OF_COLUMN; columnsNumber++)
		{
			casesRepresentation.append(" " + (char) (65 + columnsNumber) + " ");
		}
		casesRepresentation.append("\n");
		for (int linesNumber = 0; linesNumber < NUMBER_OF_LINE; linesNumber++)
		{
			if (linesNumber > 8)
			{
				casesRepresentation.append((linesNumber + 1) + " ");
			} else
			{
				casesRepresentation.append(" " + (linesNumber + 1) + " ");
			}
			for (int columnsNumber = 0; columnsNumber < NUMBER_OF_COLUMN; columnsNumber++)
			{
				casesRepresentation
						.append(this.cases[linesNumber][columnsNumber]);
			}

			casesRepresentation.append("\n");
		}

		return casesRepresentation.toString();
	}

	/* TODO JAVADOC */
	public String toLimitedString()
	{
		StringBuilder casesRepresentation = new StringBuilder(3
				* NUMBER_OF_LINE * (NUMBER_OF_COLUMN + 1));
		casesRepresentation.append("Ennemy's board : \n");
		casesRepresentation.append("   ");
		for (int columnsNumber = 0; columnsNumber < NUMBER_OF_COLUMN; columnsNumber++)
		{
			casesRepresentation.append(" " + (char) (65 + columnsNumber) + " ");
		}
		casesRepresentation.append("\n");
		for (int linesNumber = 0; linesNumber < NUMBER_OF_LINE; linesNumber++)
		{
			if (linesNumber > 8)
			{
				casesRepresentation.append((linesNumber + 1) + " ");
			} else
			{
				casesRepresentation.append(" " + (linesNumber + 1) + " ");
			}
			for (int columnsNumber = 0; columnsNumber < NUMBER_OF_COLUMN; columnsNumber++)
			{
				Case c = cases[linesNumber][columnsNumber];
				casesRepresentation
						.append((c.occupated() && !c.hitted()) ? "[ ]" : c);
			}
			casesRepresentation.append("\n");
		}
		return casesRepresentation.toString();
	}
}
