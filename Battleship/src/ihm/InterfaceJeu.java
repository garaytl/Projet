package ihm;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InterfaceJeu extends JPanel
{
	public InterfaceJeu(){
		this.setLayout(new GridLayout(2, 1));
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 2));
		panel.add(new JLabel("Pseudo Joueur"));
		panel.add(new JLabel("Pseudo enemis"));
		panel.add(new JLabel("nb bateaux left joueur"));
		panel.add(new JLabel("nb bateaux left enemy"));
		this.add(panel);
		JButton button = new JButton("Joueur suivant");
		button.setSize(50, 20);
		button.setBackground(Color.cyan);
		this.add(button);
		
	}
}
