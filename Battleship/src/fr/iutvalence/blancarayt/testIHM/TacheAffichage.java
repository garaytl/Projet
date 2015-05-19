package fr.iutvalence.blancarayt.testIHM;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

	/**
	 * Tâche gérant l'IHM (création, affichage) 
	 * 
	 * @author sebastienjean
	 *
	 */
	public class TacheAffichage implements Runnable
	{
		@Override
		public void run()
		{
			// Création du composant graphique associé à la fenêtre
			// (à ce stade rien n'est affiché)
			JFrame fenetre = new JFrame();

			// Modification des propriétés de la fenêtre
			// Titre, dimensions (en pixel)
			fenetre.setTitle("Battleship");
			fenetre.setSize(500, 800);

			// Affichage de la fenêtre
			fenetre.setVisible(true);
			
			JButton bouton = new JButton();
			
			fenetre.getContentPane().add(bouton);
			
			//Termine le processus lorsqu'on clique sur la croix rouge
		    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

}
