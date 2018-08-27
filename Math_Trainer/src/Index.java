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
/**
 * This is the main class for the Math Trainer computer program.
 * It is a selection screen for the user to move onto specific units.
 * 
 * The rest of the program is very formulaic. There are two main class types: Indexes and Utilities.
 * The Indexes are classes that actually show a JFrame on the screen and allow the user to select and work on
 * a given skill. 
 * The Utilities classes are what provide the questions and answers for each question in each skill.
 * See the SurvivalKit_Index and the SurvivalKit_Utilities classes to understand how they work.
 * 
 * @author abhargava
 *
 */
public class Index extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;//A tag that is necessary for the JFrame layout

	public static void main(String[] args) {
		new Index().setVisible(true);//setting the jFrame to being visible
	}

	/*
	 * Declaring variables that are needed in both action listener
	 * and Index class
	 */
	
	JComboBox<String> unitsMenu;
	
	JLabel progress;
	
	static int[] unitScores = {0,0,0,0};//This is for when caching of user progress is implemented
	
	private Index() {
		super("OPTIMUM - HOME");//setting the top bar title
		setSize(600, 800);//setting size
		setResizable(false);//making it impossible to resize (makes layout far easier)
		setDefaultCloseOperation(EXIT_ON_CLOSE);//When the window is closed, it will quit the program
		setLayout(new GridBagLayout());//setting the layout option to "gridbag" - allows for simple positioning of elements
		GridBagConstraints gbc = new GridBagConstraints();//this variable stores the settings for the layout
		
		
		/*Creating all labels, buttons, and menus*/
		JLabel welcome = new JLabel("<html><center><h1>Welcome to Optimum!</h1><br>Please select"
				+ " the skill you want to practice.</center></html>");//making welcome label, HTML is used for formatting
		
		String[] unitChoices = { "--Select--", "Survival Kit","Fractions", "Algebra 1",
				"Exponents"};//string array for the menu items
	    unitsMenu = new JComboBox<String>(unitChoices);//menu object creation
	    unitsMenu.setVisible(true);//menu for selecting units
	    unitsMenu.addActionListener(this);//action listeners basically allow you to run code whenever an action (e.g. a button press) happens
	    
	    JButton goButton = new JButton("Go");//Button for submitting and getting
	    								  //to a skill
	    goButton.setPreferredSize(new Dimension(50, 40));//preferred size (in pixels) for the button
	    
	    goButton.addActionListener(this);//adding the button to the actionlistener
	    goButton.setActionCommand("Go");//setting the command that the actionlistener "hears" when the button is pressed
	    
	    //displaying the progress on each unit on the screen
	    progress = new JLabel("<html><h3><center>Skills</center></h3><p>Survival Kit "+unitScores[0]+"/4,</p> <p>Fractions: "+unitScores[1]+"/6,"
	    		+ "</p><p>Algebra 1: "+unitScores[2]+"/4,</p>"
	    		+ "<p>Exponents: "+unitScores[3]+"/4");
		
		/*Adding all labels, buttons, and menus to the jFrame*/
	    gbc.insets = new Insets(5, 5, 5, 5);//top, left, bottom, right
	    gbc.anchor = GridBagConstraints.NORTH;//see gridbag documentation/tutorials for how gridbag works
	    
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
	
	
	
	
	String choice = " ";
	/**
	 * Auto-generated actionPerformed method.
	 * "Hears" which one of the units were selected and opens the corresponding unit index when "Go" is pressed
	 */
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

		progress.setText("<html><h3><center>Skills:</center></h3><p>Survival Kit "+unitScores[0]+"/5,</p> <p>Fractions: "+unitScores[1]+"/5,</p><p>Algebra 1: "+unitScores[2]+"/5,</p>"
	    		+ "<p>Exponents: "+unitScores[3]+"/5");
		
	}		

}
