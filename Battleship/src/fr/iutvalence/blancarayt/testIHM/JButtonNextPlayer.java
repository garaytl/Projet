package fr.iutvalence.blancarayt.testIHM;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

/**
 * Bouton évolué affichant (en guise de contenu texte) le nombre de clics
 * effectués depuis sa mise en activité. Cette classe est réalisée par extension
 * de la classe JButton. Les évenements (clic) sont capturés par le bouton
 * lui-même par implémentation de l'interface ActionListener
 * 
 * @author sebastienjean
 * 
 */
@SuppressWarnings("serial")
public class JButtonNextPlayer extends JButton implements ActionListener
{

	public JButtonNextPlayer()
	{
		// Alignement du texte centré en bas du bouton
		// (par défaut, c'est le cas pour l'icone, l'alignement
		// vertical/horizontal vaut CENTER)
		this.setVerticalTextPosition(SwingConstants.BOTTOM);
		this.setHorizontalTextPosition(SwingConstants.RIGHT);
		this.setSize(30, 15);
	}
	
	//ce que ça fait quand on clic dessus
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
}
