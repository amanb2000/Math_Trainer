import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CSV_Test {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		String fileName = "BEDMAS_QUESTIONS.csv";
		
		ArrayList<String[]> asdf = getList("BEDMAS_QUESTIONS.csv");
		
		for(int i = 0; i < asdf.size(); i++) {
			System.out.println(asdf.get(i)[0] + " = " + asdf.get(i)[1]);
		}
		
	}

	public static ArrayList getList(String fileName) throws FileNotFoundException{
		File file = new File(fileName);
		Scanner in = new Scanner(file);
		ArrayList<String[]> data = new ArrayList();
		
		
		while(in.hasNext()) {
			String d = in.nextLine();
			String[] qat = d.split(",");
			data.add(qat);
		}
		return data;
	}

}