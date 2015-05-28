package ihm;

import javax.swing.JButton;

import fr.iutvalence.blancarayt.battleship.model.Direction;

public class JButtonDirection extends JButton
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Direction dir;
	
	public JButtonDirection(Direction d, String label){
		this.dir=d;
		new JButton(label);
	}

	public Direction getDir()
	{
		return dir;
	}
	
	
}
