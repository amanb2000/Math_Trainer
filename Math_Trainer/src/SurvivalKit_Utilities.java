
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
	public static String[] getBEDMAS() {
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
	
}
