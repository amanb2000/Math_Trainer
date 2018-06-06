import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Index extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		new Index().setVisible(true);//setting the jFrame to being visible
	}

	/*Declaring variables that are needed in both action listener
	 * and Index class
	 */
	
	JComboBox<String> unitsMenu;
	
	JLabel progress;
	
	static int[] unitScores = {0,0,0,0};
	
	private Index() {
		super("OPTIMUM - HOME");
		setSize(600, 800);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridBagLayout());//rows, columns
		GridBagConstraints gbc = new GridBagConstraints();
		
		
		/*Creating all labels, buttons, and menus*/
		JLabel welcome = new JLabel("<html><center><h1>Welcome to Optimum!</h1><br>Please select"
				+ " the skill you want to practice.</center></html>");//making welcome label
		
		String[] unitChoices = { "--Select--", "Survival Kit","Fractions", "Algebra 1",
				"Exponents"};
	    unitsMenu = new JComboBox<String>(unitChoices);
	    unitsMenu.setVisible(true);//menu for selecting units
	    unitsMenu.addActionListener(this);
	    
	    JButton goButton = new JButton("Go");//Button for submitting and getting
	    								  //to a skill
	    goButton.setPreferredSize(new Dimension(50, 40));
	    
	    goButton.addActionListener(this);
	    goButton.setActionCommand("Go");
	    
	    progress = new JLabel("<html><h3><center>Skills</center></h3><p>Survival Kit "+unitScores[0]+"/4,</p> <p>Fractions: "+unitScores[1]+"/6,"
	    		+ "</p><p>Algebra 1: "+unitScores[2]+"/4,</p>"
	    		+ "<p>Exponents: "+unitScores[3]+"/4");
		
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
		if(e.getActionCommand().equals("Go") && choice.equals("Survival Kit")) {
			new SurvivalKit_Index().setVisible(true);
		}
		else if(e.getActionCommand().equals("Go") && choice.equals("Fractions")) {
			new Fractions_Index().setVisible(true);
		}
		else if(e.getActionCommand().equals("Go") && choice.equals("Algebra 1")) {
			new Algebra_1_Index().setVisible(true);
		}
		else if(e.getActionCommand().equals("Go") && choice.equals("Exponents")) {
			new Exponents_Index().setVisible(true);
		}
		if(e.getSource() == unitsMenu) {
			JComboBox bx = (JComboBox)e.getSource();
			choice = (String)bx.getSelectedItem();
			System.out.println(choice);
		}
		//TODO: Get skill incrementing to work
		progress.setText("<html><h3><center>Skills:</center></h3><p>Survival Kit "+unitScores[0]+"/5,</p> <p>Fractions: "+unitScores[1]+"/5,</p><p>Algebra 1: "+unitScores[2]+"/5,</p>"
	    		+ "<p>Exponents: "+unitScores[3]+"/5");
		
	}		

}
