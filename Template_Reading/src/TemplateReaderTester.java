import javax.script.ScriptEngineManager;

import java.util.ArrayList;

import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class TemplateReaderTester {
	public static char[] nonVars = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '+', '-', '*',
			'/', '^', 'x', 'y', '='
	};

	public static  char[] operators = {'+', '-', '*',
			'/', '^', '='
	};	
	public static void main(String[] args) throws ScriptException {
		// TODO Auto-generated method stub
		String inp = "ax + b = c";//template input
		String inp2 = "(c-b)/a";//expression for getting x from random variables (in CSV)
		
		inp = inp.replaceAll("\\s+","");
		
		ScriptEngineManager mgr = new ScriptEngineManager();
	    ScriptEngine engine = mgr.getEngineByName("JavaScript");
	    String foo = "40+2/Math.pow(2, 4)";
	    
	    ArrayList<char[]> vals = new ArrayList();//['a', '2']
	    
	    for(int i = 0; i < inp.length(); i++) {
	    		char curChar = inp.charAt(i);
	    		if(! contains(nonVars, curChar)) {
//	    			System.out.println("CURCHAR: " + curChar);
	    			int rand = (int) (Math.random()*10) + 1;
	    			String randy = ""+rand;
	    			char randyy = randy.charAt(0);
	    			char[] addIn = {curChar, randyy};
//	    			System.out.println("value: " + addIn[1]);
	    			vals.add(addIn);
	    		}
	    }
	    
	    
	    
	    //creating an integer (float) from a char
//	    char one = '1';
//	    float o = (int)one - 48;
//	    System.out.print(o);
	    
	    display2xn(vals);//this is our dictionary for variables.
	    
	    //OK now we're going to be trying to use the inp2 expression to get an answer.
	    
	    String exp = "";
	    
	    for(int i = 0; i < inp2.length(); i++) {
	    		int index = valsContains(vals, inp2.charAt(i));
	    		if( index != -1 ) {
	    			exp += vals.get(index)[1];
	    		}
	    		else {
	    			exp += inp2.charAt(i);
	    		}
	    }
	    System.out.println(exp);
	    System.out.println(engine.eval(exp));
	    
	    String test = "Math.pow(3, 2)";
	    String end = engine.eval(test) + "";
	    System.out.println("Test: " + test + " = " + engine.eval(test));
	    
	    System.out.println("===================================");
	    
	    System.out.print(stripPower("3^2"));
	}
	
	/*
	 * This method will take a string of an equation and convert all '^' signs
	 * to Math.pow() expressions.
	 */
	public static String stripPower(String str) {
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '^') {
				int firstIndex = -1;
				int lastIndex = str.length();
				
				for(int j = i-1; j >= 0; j--) {
					if(contains(operators, str.charAt(j))) {//this character is an operator
						firstIndex = j;
						break;
					}
				}
				for(int j = i+1; j < str.length(); j++) {
					if(contains(operators, str.charAt(j))) {//this character is an operator
						lastIndex = j;
						break;
					}
				}
//				firstIndex++;
				System.out.print(str.substring(firstIndex, lastIndex));
				
			}
		}
		return "";
	}
	public static int valsContains(String str, char needle) {
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == needle) {
				return i;
			}
		}
		return -1;
	}
	public static int valsContains(ArrayList<char[]> vals, char needle) {
		for(int i = 0; i < vals.size(); i++) {
			if(vals.get(i)[0] == needle) {
//				return vals.get(i)[1];
				return i;
			}
		}
		return -1;
	}
	public static void display2xn (ArrayList<char[]> a) {
		System.out.println("=================");
		for(char[] i : a) {
			System.out.println(i[0]+":"+i[1]);
		}
		System.out.println("=================");
	}
	public static boolean contains(char[] a, char b) {
		for(int i = 0; i < a.length; i++) {
			if(a[i] == b) {
				return true;
			}
		}
		return false;
	}

}
