package ihm;

import javax.swing.JOptionPane;

/**
 * Display
 * @author Elisa
 *
 */
public class Display
{
	/**
	 * Main.
	 * @param args
	 */
	public static void main(String[] args)
	{
		
		JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
		String player1 = jop.showInputDialog(null, "Saisir le pseudo du joueur 1 !", JOptionPane.QUESTION_MESSAGE);
		String player2 = jop2.showInputDialog(null, "Saisir le pseudo du joueur 2 !", JOptionPane.QUESTION_MESSAGE);
		//Fenetre fenetre = new Fenetre();
	}

}