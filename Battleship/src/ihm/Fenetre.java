package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

public class Fenetre extends JFrame
{
 public Fenetre(){
	 this.setVisible(true);
	 this.setTitle("IHM");
	 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 this.setSize(800, 1000);
	 JSplitPane northPanel = new JSplitPane();
	 JSplitPane globalPanel= new JSplitPane();

	 //pan.setBackground(Color.cyan);
	 //pan.add(bouton)
	 
	 
	/*    //On ajoute le bouton au content pane de la JFrame
	 JPanel cell[][] = new JPanel[9][9];
	 JPanel content = new JPanel();
	 content.setLayout(new GridLayout(10, 10));
	 GridBagConstraints gbc = new GridBagConstraints();
			
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    gbc.gridheight = 1;
	    gbc.gridwidth = 1;*/
	JPanel plateau1=new Plateau();
	JPanel plateau2=new Plateau();
//		 gbc.gridwidth = GridBagConstraints.REMAINDER;
/*	 northSouth.setLayout(new GridLayout(2, 2));
	 northSouth.add(new JLabel(""));
	 northSouth.add(panel);
	 northSouth.add(new JLabel(""));*/
	 northPanel.setDividerSize(0);
	 northPanel.setResizeWeight(0.9);
	 northPanel.setRightComponent(plateau1);
	 northPanel.setLeftComponent(new InterfaceJeu());
	 northPanel.setEnabled(false);
	 
	 globalPanel.setOrientation(SwingConstants.HORIZONTAL);
	 globalPanel.setResizeWeight(0.2);
	 globalPanel.setDividerSize(0);
	 globalPanel.setBottomComponent(plateau2);
	 globalPanel.setTopComponent(northPanel);
	 this.getContentPane().add(globalPanel);
	 this.validate();
	 this.repaint();

	 //this.pack();
	 //this.getContentPane().add(content, BorderLayout.SOUTH);
 }
}
