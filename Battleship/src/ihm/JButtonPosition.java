package ihm;

import javax.swing.JButton;

public class JButtonPosition extends JButton
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final int x, y ;
	
	public JButtonPosition(int x, int y){
		this.x=x;
		this.y=y;
	}

	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
}
