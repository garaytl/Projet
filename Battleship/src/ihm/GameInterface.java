package ihm;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameInterface extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GameInterface(){
		this.setLayout(new GridLayout(2, 1));
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 2));
		panel.add(new JLabel("Player's Pseudo"));
		panel.add(new JLabel("Enemy's Pseudo"));
		panel.add(new JLabel("Player's boat still alive"));
		panel.add(new JLabel("Enemy's boat still alive"));
		this.add(panel);
		JButton button = new JButton("Next Player");
		button.setSize(50, 20);
		button.setBackground(Color.cyan);
		this.add(button);
		
	}
}
