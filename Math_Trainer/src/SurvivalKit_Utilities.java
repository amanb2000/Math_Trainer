import java.io.FileNotFoundException;
import java.util.ArrayList;


/**
 * This is the SurvivalKit_Utilities class and it forms the template for all utilities class.
 * It is simply a collection of methods that return a string array of length 2, with the first element
 * being the question and the second element being the answer.
 * 
 * 
 * @author abhargava
 *
 */
public class SurvivalKit_Utilities {
	int abc;
	public SurvivalKit_Utilities() {
	}
	public static String[] getAdditionSubtraction() {
		String[] retVal = new String[2];
		int a = (int)(Math.random()*10)+1;
		int b = (int)(Math.random()*10)+1;
		double plusminus = (Math.random())-0.5;
		if(plusminus > 0) {
			retVal[0] = a + " + " + b; 
			retVal[1] = ""+(a+b);
		}
		else {
			retVal[0] = a + " - " + b;
			retVal[1] = ""+(a-b);
		}
		
		return retVal;
	}
	public static String[] getMultiplicationDivision() {
		String[] retVal = new String[2];
		int a = (int)(Math.random()*10)+1;
		int b = (int)(Math.random()*10)+1;
		double divMult = (Math.random())-0.5;
		if(divMult > 0) {
			retVal[0] = a + " * " + b;
			retVal[1] = ""+(a*b);
		}
		else {
			retVal[0] = (a*b) + " / " + b;
			retVal[1] = ""+(a);
		}
		
		return retVal;
	}
	
	public static String[] getNegative() {
		String[] retVal = new String[2];
		int a = (int)(Math.random()*10)+1;
		int b = (int)(Math.random()*10)+1;
		
		double rand = Math.random();
		
		if(rand < 0.33) {
			a*=-1;
		}
		else if(rand < 0.66) {
			b*=-1;
		}
		else {
			a *= -1;
			b *= -1;
		}
		
		double divMult = (Math.random())-0.5;
		if(divMult > 0) {
			retVal[0] = a + " * " + b;
			retVal[1] = ""+(a*b);
		}
		else {
			retVal[0] = (a*b) + " / " + b;
			retVal[1] = ""+(a);
		}
		
		return retVal;
	}
	public static String[] getBEDMAS(int qNum) throws FileNotFoundException {
		ArrayList<String[]> qas = Utilities.getListFromCSV("BEDMAS_QUESTIONS.csv");
		qNum = qNum % (qas.size()-1);
		
		return qas.get(qNum);
	}
	
}
