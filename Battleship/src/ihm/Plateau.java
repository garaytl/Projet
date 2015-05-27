package ihm;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Plateau extends JPanel
{
	public Plateau()
	{
		super();
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
			label.setBackground(Color.cyan);
			label.repaint();
			label.validate();
			this.add(label);
			for (int j = 0; j < 10; j++)
			{
				ImageIcon icon = new ImageIcon(new ImageIcon("src/ihm/goutte.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
				JButton button = new JButton(icon);
				button.setSize(20, 20);
				button.setBackground(Color.yellow);
				this.add(button);
			}
		}
	}
}
