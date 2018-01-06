import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Utilities {
	/**
	 * This method gets the ArrayList of String Arrays of length 2 (so a 2xn ArrayList) of values
	 * from a CSV file that contains [question],[answer] on each line.
	 * 
	 * @param fileName
	 * @return data (an ArrayList of String arrays)
	 * @throws FileNotFoundException
	 */
	public static ArrayList getListFromCSV(String fileName) throws FileNotFoundException{
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
