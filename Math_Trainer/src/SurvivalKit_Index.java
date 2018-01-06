import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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
	JLabel progress;
	
	String[] qa = {"", ""};

	public SurvivalKit_Index() {
		super("SURVIVAL KIT - INDEX");
		setSize(600, 800);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		String[] skills = {"Unselected", "Addition/Subtraction", 
				"Multiplication/Division", "Negatives", 
				"BEDMAS", "Translating Expressions"};
		
		skillMenu = new JComboBox<String>(skills);
		skillMenu.setVisible(true);
		skillMenu.addActionListener(this);
		
		/*Creating all labels, buttons, and menus*/
		JLabel title = new JLabel("<html><center><h1>Survival Kit</h1><br>Please Select Skill:</center></html>");
		progress = new JLabel("Progress - " + skills[curUnit] + ": "+sessionScore[curUnit]+"/5");
		
		prompt = new JLabel("Please select skill");
		
		JButton answerButton = new JButton("Answer");
		answerButton.addActionListener(this);
		answerButton.setActionCommand("Answer");
		
		
		/*Adding all labels, buttons, and menus*/
		
		add(title);
		add(progress);
		add(skillMenu);
		add(answerButton);
		add(prompt);
		add(ans);
		
		
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
				}
				else {
					System.out.println("INCORRECT!");
					sessionScore[curUnit]--;
				}
				
				ans.setText("");
				
				updateQuestion();
				
				updateAllFields();
			}
		}
		if(e.getSource() == skillMenu) {
			JComboBox bx = (JComboBox)e.getSource();
			choice = (String)bx.getSelectedItem();
			System.out.println(choice);
			
			if(choice.equals("Addition/Subtraction")) {
				curUnit = 1;	
			}
			else if(choice.equals("Multiplication/Division")) {
				curUnit = 2;
			}
			else if(choice.equals("Negatives")) {
				curUnit = 3;
			}
			else {
				curUnit = 0;
			}
			
			updateQuestion();
			updateAllFields();
			System.out.println("QA: " + qa[0] + ", " + qa[1]);
			
		}
	}
	
	public void updateQuestion() {
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
		else {
			qa[0] = "";
			qa[1] = "";
			curUnit = 0;
		}
	}
	//for updating the text of all buttons/fields based on local variables.
	public void updateAllFields() {
		prompt.setText(qa[0]);
		progress.setText("Progress: Addition/Subtraction: "+sessionScore[curUnit]+"/5");
	}

}
