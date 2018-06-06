import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Exponents_Utilities {

	public static String[] getExplicit() {
		int a = (int) (Math.random()*10);
		int b = (int) (Math.random()*7);
		
		String question = "What is " + a + "^" + b + "?";
		
		int c = (int) Math.pow(a, b);
		
		String answer = c+"";
		
		return new String[] {question, answer};
	}
	public static String[] getFOIL() {
		String question;
		String answer;
		//TODO: Add functionality to include equations like (x+y)(x+z)
//		if(Math.random() > 1) {//(x+n)^2
		int n = (int)(Math.random()*20-10);
		if(n==0)
			n = 1;
		if(n > 0) {
			question = "Simplify (x + " + n + ")^2";
			answer = "x^2 + " + 2*n + "x + " + n*n;
		}
		else {
			question = "Simlify (x - " + Math.abs(n) +")^2";
			answer = "x^2 - " + Math.abs(2*n) + "x + " + n*n;
		}
//		}
		
		return new String[] {question, answer};
	}
	public static String[] getExponent_Laws() {
		
		String question = "";
		String answer = "";
		
		double randy = Math.random();
		//5 possibilities - multiply, divide, power of power, negative exponent, 0 power
		//12% of 0 power, 22% of rest
		
		if(randy < 22) {//multiply
			int a = (int) (Math.random() * 5);
			int b = (int) (Math.random() * 4);
			
			question = "What is x^"+a+" * x^"+b+" in terms of x?";
					
			int newExp = a*b;
		    
		    answer = "x^"+newExp;
		}
		else if(randy < 44) {//divide
			int a = (int) (Math.random() * 5);
			int b = (int) (Math.random() * 4);
			
			question = "What is x^"+a+" ÷ x^"+b+" in terms of x?";
					
			double newExp = a/((double)b);
					
			DecimalFormat df = new DecimalFormat("#.##");
		    df.setRoundingMode(RoundingMode.CEILING);
		    
		    String newExps = df.format(newExp);
		    
		    answer = "x^"+newExps;
		}
		else if(randy < 66) {//power of a power
			int a = (int) (Math.random() * 9);
			int b = (int) (Math.random() * 9);
			question = "What is (x^" + a + ")^b in terms of x?";
			answer = "x^" + a*b;
		}
		else if(randy < 88) {//negative exponent
			int a = (int) (Math.random() * 5);
			int b = (int) (Math.random() * 4);
			question = "What is " + a + "^(-" + b + ")?";
			double ans = 1/Math.pow(a, b);
			
			DecimalFormat df = new DecimalFormat("#.##");
		    df.setRoundingMode(RoundingMode.CEILING);
		    
		    answer = df.format(ans);
			
		}
		else {//0 power
			int a = (int) (Math.random()*20);
			question = "What is " + a + "^0?";
			answer = "1";
		}
		
		return new String[] {question, answer};
	}
	public static String[] getFractional_Exponents() {
		int startNum = (int) (Math.random() * 5) + 1;
		
		int topOfFract = (int) (Math.random() * 5) + 1;
		int bottomOfFract = (int) (Math.random() * 5) + 1;
		
		int base = (int) Math.pow(startNum, bottomOfFract);
		
		String question = "What is " + base + "^(" + topOfFract + "/" + bottomOfFract + ")";
		
		String answer = ((int)Math.pow(startNum, topOfFract))+"";
		
		return new String[] {question, answer};
	}
}
