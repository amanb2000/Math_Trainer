import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.Dimension;

import javax.script.ScriptException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Exponents_Index extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int superScore = 0;//integer representing the number of skills in which the student has a score of 5 or more in
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Exponents_Index().setVisible(true);
	}
	
	JComboBox<String> skillMenu;
	JTextField ans = new JTextField(10);//textbox for answering questions
	JLabel prompt;
	JLabel selectReminder;
	JLabel progress;
	
	String[] skills = {"--Unselected--", "Explicit", "FOIL", "Exponent Laws", "Fractional Exponents", 
	};
	
	String[] qa = {"", ""};

	public Exponents_Index() {
		super("EXPONENTS - INDEX");
		setSize(600, 800);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridBagLayout());//rows, columns
		GridBagConstraints gbc = new GridBagConstraints();
		
		skillMenu = new JComboBox<String>(skills);
		skillMenu.setVisible(true);
		skillMenu.addActionListener(this);
		
		/*Creating all labels, buttons, and menus*/
		JLabel title = new JLabel("<html><center><h1>Exponents</h1></html>");
		progress = new JLabel("Progress on " + skills[curUnit] + ": "+sessionScore[curUnit]+"/5");
		
		prompt = new JLabel("<Question comes here>");//the question
		
		selectReminder = new JLabel("Skill Select: ");
		
		JButton answerButton = new JButton("Answer");
		answerButton.setPreferredSize(new Dimension(200, 30));
		
		answerButton.addActionListener(this);
		answerButton.setActionCommand("Answer");
		
		
		/*Adding all labels, buttons, and menus*/
		gbc.insets = new Insets(0, 0, 0, 0);//top, left, bottom, right
	    gbc.anchor = GridBagConstraints.CENTER;
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		add(title, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		add(progress, gbc);
		
		gbc.gridwidth = 1;
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.EAST;
		add(selectReminder, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.WEST;
		add(skillMenu, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		add(prompt, gbc);
		
				
		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.CENTER;
		add(answerButton, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridwidth = 2;
		add(ans, gbc);
		
		
	}
	
	int[] sessionScore = new int[skills.length]; //array of integers to keep track of the student's score on each exercise in this unit
	
	String choice = "";
	int curUnit = 0;
	public void actionPerformed(ActionEvent e) {
		Index.unitScores[0]++;
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Answer") && !prompt.getText().equals("Please select skill")) {
			if(!choice.equals("Unselected")) {
				if((Utilities.removeSpaces(ans.getText())).equals(Utilities.removeSpaces(qa[1]))) {
					System.out.println("CORRECT!");
					
					sessionScore[curUnit]++;
					if(sessionScore[curUnit] < 0) {
						sessionScore[curUnit] = 0;
					}
				}
				else {
					System.out.println("INCORRECT!");
					sessionScore[curUnit]--;
					if(sessionScore[curUnit] < 0) {
						sessionScore[curUnit] = 0;
					}
				}
				
				ans.setText("");
				
				try {
					updateQuestion();
				} catch (FileNotFoundException | ScriptException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				updateAllFields();
			}
		}
		if(e.getSource() == skillMenu) {
			JComboBox bx = (JComboBox)e.getSource();
			choice = (String)bx.getSelectedItem();
			System.out.println(choice);
			
			updateCurUnit();
			
			try {
				updateQuestion();
			} catch (FileNotFoundException | ScriptException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			updateAllFields();
			
			
		}
		
		//incrementing superScore
		superScore = 0;
		for(int i = 0; i < sessionScore.length; i++) {
			if(sessionScore[i] >= 5) {
				superScore ++;
			}
		}
		
	}
	/**
	 * 
	 */
	public void updateCurUnit() {
		for(int i = 0; i < skills.length; i++) {
			if(choice.equals(skills[i])) {
				curUnit = i;
			}
		}
	}
	/**
	 * TODO: Update the get expressions
	 * @throws FileNotFoundException
	 * String[] skills = {"--Unselected--", "Explicit", "FOIL", "Exponent Laws", "Fractional Exponents"}
	 * @throws ScriptException 
	 */
	public void updateQuestion() throws FileNotFoundException, ScriptException {
//		if(choice.equals("Addition/Subtraction")) {
		if(curUnit == 1) {
			qa = Exponents_Utilities.getExplicit();
		}
		else if(curUnit == 2) {
			qa = Exponents_Utilities.getFOIL();
		}
		else if(curUnit == 3) {
			qa = Exponents_Utilities.getExponent_Laws();
		}
		else if(curUnit == 4) {
			qa = Exponents_Utilities.getFractional_Exponents();
		}
		else {
			qa[0] = "<<Unit not found>>";
			qa[1] = "<<Unit not found>>";
			curUnit = 0;
		}
		
		System.out.println("QA: " + qa[0] + ", " + qa[1]);
	}
	//for updating the text of all buttons/fields based on local variables.
	public void updateAllFields() {
		prompt.setText("<html><b>Question: " + qa[0] + "</b></html>");
		String progText = "<html>";
		
		for(int i = 1; i < skills.length; i++) {
			progText += "<p>";
			progText += "Progress on "+skills[i]+": "+sessionScore[i]+"/5";
			if(sessionScore[i] >= 5) {
				progText += " :D";
			}
			progText += "</p>";
		}
		
		progText += "</html>";
		
		progress.setText(progText);
	}

}
