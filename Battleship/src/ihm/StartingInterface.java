package ihm;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

import fr.iutvalence.blancarayt.battleship.model.Player;

/**
 * 
 * @author Elisa
 *
 */
public class StartingInterface extends JSplitPane
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
		public StartingInterface(Player player){
			this.setDividerSize(0);
			this.setResizeWeight(0.9);
			this.setEnabled(false);
			JPanel pan = new JPanel();
			pan.setLayout(new GridLayout(2, 1));
			JLabel lab = new JLabel("Posez un xxxxx en choisissant une case de d�part puis une direction");
			lab.setHorizontalAlignment(SwingConstants.CENTER);
			pan.add(new JLabel(player.getPseudo()+" : "));
			pan.add(lab);
			this.setLeftComponent(pan);
			JPanel pan1 = new JPanel();
			pan1.setLayout(new GridLayout(2, 1));
			pan1.add(new JLabel(""));
			pan1.add(new JLabel(""));
			this.setRightComponent(pan1);
				
		}
			
	}

