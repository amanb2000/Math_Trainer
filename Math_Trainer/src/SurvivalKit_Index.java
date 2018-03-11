import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SurvivalKit_Index extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SurvivalKit_Index().setVisible(true);
	}
	
	JComboBox<String> skillMenu;
	JTextField ans = new JTextField(10);//textbox for answering questions
	JLabel prompt;
	JLabel selectReminder;
	JLabel progress;
	
//	String[] skills = {"Unselected", "Addition/Subtraction", 
//			"Multiplication/Division", "Negatives", 
//			"BEDMAS", "Translating Expressions"};
	String[] skills = {"--Unselected--", "Addition/Subtraction", 
			"Multiplication/Division", "Negatives", 
			"BEDMAS"};
	
	int bedmasNum = (int)(Math.random()*16);
	
	String[] qa = {"", ""};

	public SurvivalKit_Index() {
		super("SURVIVAL KIT - INDEX");
		setSize(600, 800);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridBagLayout());//rows, columns
		GridBagConstraints gbc = new GridBagConstraints();
		
		skillMenu = new JComboBox<String>(skills);
		skillMenu.setVisible(true);
		skillMenu.addActionListener(this);
		
		/*Creating all labels, buttons, and menus*/
		JLabel title = new JLabel("<html><center><h1>Survival Kit</h1></html>");
		progress = new JLabel("Progress on " + skills[curUnit] + ": "+sessionScore[curUnit]+"/5");
		
		prompt = new JLabel("<Question comes here>");//the question
		
		selectReminder = new JLabel("Skill Select: ");
		
		JButton answerButton = new JButton("Answer");
		answerButton.setPreferredSize(new Dimension(200, 30));
		
		answerButton.addActionListener(this);
		answerButton.setActionCommand("Answer");
		
		
		/*Adding all labels, buttons, and menus*/
		gbc.insets = new Insets(5, 5, 5, 5);//top, left, bottom, right
	    gbc.anchor = GridBagConstraints.CENTER;
//		gbc.weightx = 1;
//		gbc.weighty = 1;
		
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
		gbc.anchor = GridBagConstraints.EAST;
		add(prompt, gbc);
		
				
		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.WEST;
		add(answerButton, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridwidth = 2;
		add(ans, gbc);
		
		
	}

	int[] sessionScore = new int[6];
	String choice = "";
	int curUnit = 0;
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Answer") && !prompt.getText().equals("Please select skill")) {
			if(!choice.equals("Unselected")) {
				if( ans.getText().equals(qa[1]) ) {
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
				} catch (FileNotFoundException e1) {
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
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			updateAllFields();
			System.out.println("QA: " + qa[0] + ", " + qa[1]);
			
		}
	}
	
	public void updateQuestion() throws FileNotFoundException {
//		if(choice.equals("Addition/Subtraction")) {
		if(curUnit == 1) {
			qa = SurvivalKit_Utilities.getAdditionSubtraction();
		}
		else if(curUnit == 2) {
			qa = SurvivalKit_Utilities.getMultiplicationDivision();
		}
		else if(curUnit == 3) {
			qa = SurvivalKit_Utilities.getNegative();
		}
		else if(curUnit == 4) {
			qa = SurvivalKit_Utilities.getBEDMAS(bedmasNum);
			bedmasNum ++;
		}
		else {
			qa[0] = "<<Unit not found>>";
			qa[1] = "<<Unit not found>>";
			curUnit = 0;
		}
	}
	public void updateCurUnit() {
		curUnit = -1;
		for(int i = 0; i < skills.length; i++) {
			if(choice.equals(skills[i])) {
				curUnit = i;
			}
		}
	}
	
	//for updating the text of all buttons/fields based on local variables.
	public void updateAllFields() {
		prompt.setText("Question: What is " + qa[0] + "?");
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
