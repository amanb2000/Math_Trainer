import java.math.RoundingMode;
import java.text.DecimalFormat;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Algebra_1_Utilities {

	public static String[] getAddInverse() {
		int a = (int)(Math.random()*20 + 1)-10;
		String question = "What is the additional"
				+ " inverse of " + a;
		int b = a*-1;
		String answer = b+""; 
		
		return new String[] {question, answer};
	}
	public static String[] getMultInverse() {
		
		if(Math.random() < 0.8) {
			int a=(int)(Math.random()*(10)+1);
			int b=(int)(Math.random()*(10)+1);
			while(a==b) {//ensuring that the fraction is not 1/1
				b=(int)(Math.random()*(10)+1);
			}
			
			Fraction f1=new Fraction(a,b);
			Fraction one = new Fraction(1);
			String question = "What times " + f1.toString() + " equals 1?";
			String answer = (f1.divide(one)).toString();
			
			return new String[] {question, answer};//TODO: Get it to reduce the expected answer if it is n/1
			
		}
		else {
			int n = (int)(Math.random()*(10)+1);
			String question = "What times " + n + " equals 1?";
			String answer = "1/" + n;
			return new String[] {question, answer};
		}
		
	}
	/**
	 * TODO: Create/add functionality to .csv/import for substitution questions (see notebook for layout)
	 * TODO: Make it round to the nearest two decimal places
	 * @return
	 * @throws ScriptException 
	 */
	public static String[] getSubstitution() throws ScriptException {
		
		String template;
		String dictionary;
		
		//TODO: Implement CSV reading and a longer list of templates and dictionaries
		double randy = Math.random();
		
		if(randy < 0.3) {
			template = "m - h/(i+n)";
			dictionary = "mnhi";
		}
		else if(randy < 0.7) {
			template = "(m-h)/(i+n)";
			dictionary = "mnhi";
		}
		else {
			template = "4m + nh/i";
			dictionary = "mnhi";
		}
		
		String templates = template;
		
		int[] values = new int[dictionary.length()];
		
		ScriptEngineManager mgr = new ScriptEngineManager();
	    ScriptEngine engine = mgr.getEngineByName("JavaScript");
	    
	    for(int i = 0; i < values.length; i++) {
	    		values[i] = (int)(Math.random()*10 + 1);
	    }
		
	    String expression = "";
	    
	    for(int i = 0; i < template.length(); i++) {
	    		boolean need = true;
	    		for(int j = 0; j < dictionary.length(); j++) {
	    			if(template.charAt(i) == dictionary.charAt(j)) {
	    				expression += values[j];
	    				need = false;
	    				break;
	    			}
	    		}
	    		if(need) {
	    			expression += template.charAt(i);
	    		}
	    }
	    double answer;
	    if(engine.eval(expression) instanceof Integer) {
	    		answer = (double) ((Integer) engine.eval(expression));
	    }
	    else {
	    		answer = (double) engine.eval(expression);
	    }
	    
	    
	    String strans = "";
	    
	    DecimalFormat df = new DecimalFormat("#.##");
	    df.setRoundingMode(RoundingMode.CEILING);
	    
	    strans = df.format(answer);
	    
	    
	    
	    String question = "If ";
	    
	    for(int i = 0; i < dictionary.length(); i++) {
	    		question += dictionary.charAt(i) + " represents <br>" + values[i];
	    		if(i != dictionary.length()-1) {
	    			question += " and ";
	    		}
	    }
	    
	    question += ", what does <br>" + template + " equal?";
	    
	    return new String[] {question, strans};
	    
	    
	}
	public static String[] getAlgebra() throws ScriptException {
		String template;
		String dictionary;
		String solutionEquation;
		
		//TODO: Implement CSV reading and a longer list of templates, dictionaries, and solutionEquations
		//TODO: Make sure these aren't too hard - consult academic support for a set of equations to use.
		double randy = Math.random();
		
		if(randy < 0.3) {
			template = "mx = h/(i+n)";
			dictionary = "mnhi";
			solutionEquation = "(h/(i+n))/m";
		}
		else if(randy < 0.7) {
			template = "m(h + x) = i + n";
			dictionary = "mnhi";
			solutionEquation = "(i+n-mh)/m";
		}
		else {
			template = "nm = h/(i+x)";
			dictionary = "mnhi";
			solutionEquation = "(h-nmi)/(nm)";
		}
		
		int[] values = new int[dictionary.length()];
		
		ScriptEngineManager mgr = new ScriptEngineManager();
	    ScriptEngine engine = mgr.getEngineByName("JavaScript");
	    
	    for(int i = 0; i < values.length; i++) {
	    		values[i] = (int)(Math.random()*10 + 1);
	    }
		
	    String expression = "";
	    
	    for(int i = 0; i < solutionEquation.length(); i++) {
	    		boolean need = true;
	    		for(int j = 0; j < dictionary.length(); j++) {
	    			if(solutionEquation.charAt(i) == dictionary.charAt(j)) {
	    				expression += values[j];
	    				need = false;
	    				break;
	    			}
	    		}
	    		if(need) {
	    			expression += solutionEquation.charAt(i);
	    		}
	    }
	    
	    String substitutedTemplate = "";
	    for(int i = 0; i < template.length(); i++) {
		    	boolean need = true;
	    		for(int j = 0; j < dictionary.length(); j++) {
	    			if(template.charAt(i) == dictionary.charAt(j)) {
	    				substitutedTemplate += values[j];
	    				need = false;
	    				break;
	    			}
	    		}
	    		if(need) {
	    			substitutedTemplate += template.charAt(i);
	    		}
	    }
	    double answer;
	    if(engine.eval(expression) instanceof Integer) {
	    		answer = (double) ((Integer) engine.eval(expression));
	    }
	    else {
	    		answer = (double) engine.eval(expression);
	    }
	    
	    DecimalFormat df = new DecimalFormat("#.##");
	    df.setRoundingMode(RoundingMode.CEILING);
	    
	    String strans = df.format(answer);
	    
	    String question = "If " + substitutedTemplate + ", what is x?";
	    
	    return new String[] {question, strans};
		
	}
	

}
