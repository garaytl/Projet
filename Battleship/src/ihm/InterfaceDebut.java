package ihm;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

/**
 * 
 * @author Elisa
 *
 */
public class InterfaceDebut extends JSplitPane
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
		public InterfaceDebut(){
			this.setDividerSize(0);
			this.setResizeWeight(0.9);
			this.setEnabled(false);
			JPanel pan = new JPanel();
			pan.setLayout(new GridLayout(2, 1));
			JLabel lab = new JLabel("Posez un xxxxx en choisissant une case de départ puis une direction");
			lab.setHorizontalAlignment(SwingConstants.CENTER);
			pan.add(lab);
			JPanel panel = new JPanel();
			panel.setLayout(new GridLayout(1, 4));
			panel.add(new JButton("Left"));
			panel.add(new JButton("Right"));
			panel.add(new JButton("Up"));
			panel.add(new JButton("Down"));
			pan.add(panel);
			this.setLeftComponent(pan);
			JPanel pan1 = new JPanel();
			pan1.setLayout(new GridLayout(2, 1));
			pan1.add(new JLabel(""));
			pan1.add(new JButton("Next"));
			this.setRightComponent(pan1);
			
			
		}
	}

