package ihm;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.iutvalence.blancarayt.battleship.Game;
import fr.iutvalence.blancarayt.battleship.model.Player;

public class Controle extends Thread
{
	// Lien controller => Vue 
		private Fenetre view;
		// Lien controller => Modele
		private Game game;
		
		public void start() {
			JFrame param = new SaisiePseudo(this);
		}

		public void initParty(String pseudo1, String pseudo2) {
			/* Modèle. */
			Player player1 = new Player(pseudo1);
			Player player2 = new Player(pseudo2);
			SwingUtilities.invokeLater(new Fenetre(this, player1.getPseudo()));
		}
}
