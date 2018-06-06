 import java.util.Scanner;
public class getMultiplication {
	static Scanner in = new Scanner (System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=(int)(Math.random()*(10+1));
		int b=(int)(Math.random()*(10+1));
		while(a==b) {
			b=(int)(Math.random()*(10+1));
		}
		int c=(int)(Math.random()*(10+1));
		int d=(int)(Math.random()*(10+1));
		while(c==d) {
			d=(int)(Math.random()*(10+1));
		}
		Fraction f1=new Fraction(a,b);
		Fraction f2=new Fraction(c,d);
		Fraction product=f1.multiply(f2);
		System.out.println(f1+" * "+f2+" = "+product);
	}

}
