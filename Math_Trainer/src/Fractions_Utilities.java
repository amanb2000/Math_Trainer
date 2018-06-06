import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Fractions_Utilities {
	int abc;
	public Fractions_Utilities() {
		
		
	}
	/**
	 * Returns a String[2] containing a same-denominator fraction addition/subtraction problem and its answer.
	 * @return String[] problem and answer
	 * @author Jayden Lefebvre
	 */
	public static String[] getBasicAddSub() {

		//Denominator and numerators between 1 and 10
		int denom = (int)(Math.random()*10+1);
		int num1 = (int)(Math.random()*10+1);
		int num2 = (int)(Math.random()*10+1);

		double operation = Math.random();	//Addition or subtraction? (0-0.9), 50/50 chance) 

		String question = num1+"/"+denom+" "+ (operation > 0.5 ? "+" : "-") +" "+num2+"/"+denom; //Construct problem string

		//Adds or subtracts to find new numerator
		int num3 = (operation > 0.5) ? num1 + num2 : num1 - num2;

		//Fully reduces to an improper fraction
		int gcf = gcf(Math.abs(num3), Math.abs(denom));
		num3 /= gcf;
		denom /= gcf;

		//Constructs answer. If numerator is 0, answer is 0. If divisor is 1, no divisor.
		String answer = (num3 == 0 ? "0" : (denom == 1 ? ""+num3 : num3+"/"+denom));		

		String [] result = {question, answer};
		return result;
	}

	/**
	 * Recursively finds the greatest common factor of two integers
	 * @param a - First integer
	 * @param b - Second integer
	 * @return Greatest common factor
	 */
	public static int gcf(int a, int b) {
		return b==0 ? a : gcf(b, a%b); 
	}
	
	/**
	 * TxDO: Get on Traugott's and Gallagher's case about these.
	 * @return
	 */
	public static String[] getLCM() {
		int a = (int)(Math.random()*10) + 1;
		int b = (int)(Math.random()*10) + 1;
		
		int c = (a*b)/gcf(a, b);
		
		String question = "LCM of " + a + " and " + b + "?";
		String answer = c+"";
		
		String [] result = {question, answer};//creating question/answer String array
		
		return result;//returning question/answer String array.
	}
	public static String[] getGCF() {
		int a = (int)(Math.random()*10) + 1;
		int b = (int)(Math.random()*10) + 1;
		
		int c = gcf(a, b);
		
		String question = "GCF of " + a + " and " + b + "?";
		String answer = c+"";
		
		String [] result = {question, answer};//creating question/answer String array
		
		return result;//returning question/answer String array.
		
	}
	public static String[] getAddSub() {
		//generating numerator and denominator for the first fraction
		int a=(int)(Math.random()*(10)+1);
		int b=(int)(Math.random()*(10)+1);
		while(a==b) {//ensuring that the fraction is not 1/1
			b=(int)(Math.random()*(10)+1);
		}
		//repeating the same process for the second fraction
		int c=(int)(Math.random()*(10)+1);
		int d=(int)(Math.random()*(10)+1);
		while(c==d) {
			d=(int)(Math.random()*(10)+1);
		}
		
		//creating new instances of the fraction class with each randomly generated number
		Fraction f1=new Fraction(a,b);
		Fraction f2=new Fraction(c,d);
		
		boolean add = true;
		if(Math.random() < 0.5) {
			add = false;
		}
		
		Fraction ans;
		
		if(add) {
			ans=f2.add(f1);//calculating the product
		}
		else {
			ans=f1.subtract(f2);//calculating the product
		}
		
		String question = f1.toString() + " + " + f2.toString();//converting fractions to strings to make question string
		
		if(!add) {
			question = f1.toString() + " - " + f2.toString();//converting fractions to strings to make question string
		}
		
		String answer = ans.toString();//creating answer string
		
		String [] result = {question, answer};//creating question/answer String array
		
		return result;//returning question/answer String array.
		//TODO: Make answers that are n/1 just be n
	}
	public static String[] getMultiplication() {
		//generating numerator and denominator for the first fraction
		int a=(int)(Math.random()*(10)+1);
		int b=(int)(Math.random()*(10)+1);
		while(a==b) {//ensuring that the fraction is not 1/1
			b=(int)(Math.random()*(10)+1);
		}
		//repeating the same process for the second fraction
		int c=(int)(Math.random()*(10)+1);
		int d=(int)(Math.random()*(10)+1);
		while(c==d) {
			d=(int)(Math.random()*(10)+1);
		}
		
		//creating new instances of the fraction class with each randomly generated number
		Fraction f1=new Fraction(a,b);
		Fraction f2=new Fraction(c,d);
		Fraction product=f1.multiply(f2);//calculating the product
		
		String question = f1.toString() + " * " + f2.toString();//converting fractions to strings to make question string
		
		String answer = product.toString();//creating answer string
		
		answer  = fixFractionString(answer);
		
		String [] result = {question, answer};//creating question/answer String array
		
		return result;//returning question/answer String array.
	}
	public static String[] getDivision() {
		//generating numerator and denominator for the first fraction
		int a=(int)(Math.random()*(10)+1);
		int b=(int)(Math.random()*(10)+1);
		while(a==b) {//ensuring that the fraction is not 1/1
			b=(int)(Math.random()*(10)+1);
		}
		//repeating the same process for the second fraction
		int c=(int)(Math.random()*(10)+1);
		int d=(int)(Math.random()*(10)+1);
		while(c==d) {
			d=(int)(Math.random()*(10)+1);
		}
		
		//creating new instances of the fraction class with each randomly generated number
		Fraction f1=new Fraction(a,b);
		Fraction f2=new Fraction(c,d);
		Fraction quotient=f2.divide(f1);//calculating the product
		
		String question = f1.toString() + " ÷ " + f2.toString();//converting fractions to strings to make question string
		
		String answer = quotient.toString();//creating answer string
		
		answer  = fixFractionString(answer);
		
		String [] result = {question, answer};//creating question/answer String array
		
		return result;//returning question/answer String array.
	}
	public static String fixFractionString(String fract) {
		
		int n = fract.indexOf('/');
		
		if(fract.substring(n+1).equals("1")) {
			return(fract.substring(0, n));
		}
		
		
		return fract;
	}
	
}
