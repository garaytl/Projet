package ihm;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.iutvalence.blancarayt.battleship.Game;
import fr.iutvalence.blancarayt.battleship.model.Player;

public class Controller extends Thread
{
	// Lien controller => Vue 
		private Window view;
		// Lien controller => Modele
		private Game game;
		
		public void start() {
			JFrame param = new NicknameEntry(this);
		}

		public void initParty(String pseudo1, String pseudo2) {
			/* Modèle. */
			Player player1 = new Player(pseudo1);
			Player player2 = new Player(pseudo2);
			SwingUtilities.invokeLater(new Window(this, player1, player2));
		}
}
