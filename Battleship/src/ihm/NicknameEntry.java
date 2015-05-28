package ihm;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NicknameEntry extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Controller controller;
	private final JTextField pseudo1;
	private final JTextField pseudo2;
	
	public NicknameEntry(Controller control) {
		this.controller = control;
		this.setTitle("Saisie Pseudos");
		this.setSize(300, 150);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		JPanel pan = new JPanel();
		JPanel pan2 = new JPanel();
		pan.setLayout(new GridLayout(2, 1));
		pan2.setLayout(new GridLayout(2, 2));
		pan2.setSize(300, 70);

		pseudo1 = new JTextField("Pseudo 1");
		JLabel labelPseudo = new JLabel("Player 1 :");

		pseudo2 = new JTextField("Pseudo 2");
		JLabel labelLevel = new JLabel("Player 2 :");

		JButton valideLevel = new JButton("Valider");
		valideLevel.addActionListener(this);

		pan2.add(labelPseudo);
		pan2.add(pseudo1);

		pan2.add(labelLevel);
		pan2.add(pseudo2);
		pan.add(pan2);
		pan.add(valideLevel);

		
		this.setContentPane(pan);
		this.validate();

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		controller.initParty(pseudo1.getText(), pseudo2.getText());
		this.dispose();
	}
}
