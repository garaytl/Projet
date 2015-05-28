package ihm;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import fr.iutvalence.blancarayt.battleship.model.Direction;
import fr.iutvalence.blancarayt.battleship.model.Occupied;
import fr.iutvalence.blancarayt.battleship.model.OutOfTheBoard;
import fr.iutvalence.blancarayt.battleship.model.Player;
import fr.iutvalence.blancarayt.battleship.model.ships.AircraftCarrier;
import fr.iutvalence.blancarayt.battleship.model.ships.Boat;
import fr.iutvalence.blancarayt.battleship.model.Board;

public class DirectionInterface extends JFrame  implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int x,y;
	private Player player;

	public DirectionInterface(int x, int y, Player player){
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 4));
		panel.add(new JButtonDirection(Direction.LEFT, "Left"));
		panel.add(new JButtonDirection(Direction.RIGHT, "Right"));
		panel.add(new JButtonDirection(Direction.UP, "Up"));
		panel.add(new JButtonDirection(Direction.DOWN, "Down"));
		this.add(panel);
		this.x=x;
		this.y=y;
		this.player=player;
	}
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		JButtonDirection src =(JButtonDirection) arg0.getSource();
		Board board = new Board();
		Boat aircraftCarrier1 = new AircraftCarrier();
		try
		{
			board.placeBoat(src.getX(), src.getY(), src.getDir(), aircraftCarrier1);
		} catch (OutOfTheBoard | Occupied e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
