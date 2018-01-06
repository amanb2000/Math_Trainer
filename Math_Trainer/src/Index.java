import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

public class Index extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Index().setVisible(true);//setting the jFrame to being visible
	}

	/*Declaring variables that are needed in both actionlistener
	 * and Index class
	 */
	
	JComboBox<String> unitsMenu;
	
	private Index() {
		super("DOJO SKILL BUILDER - HOME");
		setSize(600, 800);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridBagLayout());//rows, columns
		GridBagConstraints gbc = new GridBagConstraints();
		
		
		/*Creating all labels, buttons, and menus*/
		JLabel welcome = new JLabel("<html><center><h1>Welcome!</h1><br>Please select"
				+ " the skill you want to practice.</center></html>");//making welcome label
		
		String[] unitChoices = { "--Select--", "Survival Kit","Fractions", "Algebra 1",
				"Exponents","Algebra 2","Algebra 3"};
	    unitsMenu = new JComboBox<String>(unitChoices);
	    unitsMenu.setVisible(true);//menu for selecting units
	    unitsMenu.addActionListener(this);
	    
	    JButton goButton = new JButton("Go");//Button for submitting and getting
	    								  //to a skill
//	    goButton.setPreferredSize(new Dimension(50, 40));
	    
	    goButton.addActionListener(this);
	    goButton.setActionCommand("Go");
	    
	    JLabel progress = new JLabel("<html><h3><center>Progress</center></h3><p>Survival Kit 0/5,</p> <p>Fractions: 0/5,</p><p>Algebra 1: 0/5,</p>"
	    		+ "<p>Exponents: 0/5, </p><p>Algebra 2: 0/5, </p><p>Algebra 3: 0/5</p></html>");
		
		/*Adding all labels, buttons, and menus to the jFrame*/
	    gbc.insets = new Insets(5, 5, 5, 5);//top, left, bottom, right
	    gbc.anchor = GridBagConstraints.NORTH;
	    
	    gbc.weightx = 1;
	    gbc.weighty = 1;
	    
	    gbc.gridx = 1;
	    gbc.gridy = 0;
	    gbc.gridwidth = 2;
		add(welcome, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		add(progress, gbc);
		
		gbc.gridwidth = 1;
		gbc.gridx = 1;
		gbc.gridy = 2;
		add(unitsMenu, gbc);
		
		gbc.gridwidth = 2;
		gbc.gridx = 1;
		gbc.gridy = 3;
		add(goButton, gbc);
	}
	
	
	
	
//	@Override
	String choice = " ";
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Go") && choice.equals("Survival Kit")) {
			new SurvivalKit_Index().setVisible(true);
		}
		if(e.getSource() == unitsMenu) {
			JComboBox bx = (JComboBox)e.getSource();
			choice = (String)bx.getSelectedItem();
			System.out.println(choice);
		}
	}		

}
