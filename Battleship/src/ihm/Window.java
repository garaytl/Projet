package ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

import fr.iutvalence.blancarayt.battleship.model.Player;

public class Window extends JFrame  implements ActionListener, Runnable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Controller controller;
    public Window(Controller controller, Player player1, Player player2){
	 this.controller = controller;
	 this.setVisible(true);
	 this.setTitle("IHM");
	 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 this.setSize(500, 600);
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
	JPanel plateau1=new Board(player1);
	JPanel plateau2=new Board(player2);
//		 gbc.gridwidth = GridBagConstraints.REMAINDER;
/*	 northSouth.setLayout(new GridLayout(2, 2));
	 northSouth.add(new JLabel(""));
	 northSouth.add(panel);
	 northSouth.add(new JLabel(""));*/
	 northPanel.setDividerSize(0);
	 northPanel.setResizeWeight(0.9);
	 northPanel.setRightComponent(plateau1);
	 northPanel.setLeftComponent(new GameInterface());
	 northPanel.setEnabled(false);
	 
	 globalPanel.setOrientation(SwingConstants.HORIZONTAL);
	 globalPanel.setResizeWeight(0.2);
	 globalPanel.setDividerSize(0);
	 globalPanel.setBottomComponent(plateau2);
	 //globalPanel.setTopComponent(northPanel);
	 globalPanel.setTopComponent(new StartingInterface(player1));
	 this.getContentPane().add(globalPanel);
	 this.validate();
	 this.repaint();

	 //this.pack();
	 //this.getContentPane().add(content, BorderLayout.SOUTH);
 }
@Override
public void actionPerformed(ActionEvent arg0)
{
	// TODO Auto-generated method stub
	
}
@Override
public void run()
{
	// TODO Auto-generated method stub
	
}
}
