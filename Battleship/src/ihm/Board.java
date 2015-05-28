package ihm;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import fr.iutvalence.blancarayt.battleship.model.Player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JPanel implements ActionListener 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Player player;
	
	public Board(Player play)
	{
		super();
		this.player=play;
		this.setLayout(new GridLayout(11, 11));
		this.add(new JLabel(""));
		for (int i = 1; i < 11; i++)
		{
			JLabel label = new JLabel(((char) (64 + i) + ""));
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setVerticalAlignment(SwingConstants.BOTTOM);
			this.add(label);
		}
		for (int i = 1; i < 11; i++)
		{
			JLabel label = new JLabel(String.valueOf(i)+"  ");
			label.setHorizontalAlignment(SwingConstants.RIGHT);
			label.repaint();
			label.validate();
			this.add(label);
			for (int j = 0; j < 10; j++)
			{
				ImageIcon icon = new ImageIcon(new ImageIcon("src/ihm/goutte.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
				JButton button = new JButton(icon);
				button.setSize(20, 20);
				button.setBackground(Color.WHITE);
				this.add(button);
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		JButtonPosition src =(JButtonPosition) arg0.getSource();
		new DirectionInterface(src.getX(),src.getY(),player);
		
	}
}
