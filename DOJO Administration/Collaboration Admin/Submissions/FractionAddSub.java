
public class FractionAddSub {

	public static void main(String[] args) {
		String[] prob = getBasicAddSub();
		System.out.println(prob[0] + " = "+prob[1]);
	}

	/**
	 * Returns a String[2] containing a same-denominator fraction addition/subtraction problem and its answer.
	 * @return String[] problem and answer
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
}
