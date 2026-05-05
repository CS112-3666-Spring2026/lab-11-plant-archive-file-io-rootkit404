// Step 2 - Import file input statements here

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main 
{
	public static void main(String[] args) {
		//TEST FOR STEP 1 (you can delete/comment this out after completing step 1)
		Plant test = new Plant("Stinging Nettle,65,anti-inflammatory and culinary");
		System.out.println("test plant:\n" + test + "\n\n");

		//Step 2 - Declare + initialize variables for file input here
		Scanner inputFile = null;
		ArrayList<Plant> myPlants = new ArrayList<>();

		//Step 2 - Connect input stream to file (dont forget the try/catch!)
		try {
			inputFile = new Scanner(new FileInputStream("Forage.csv"));
		} catch (FileNotFoundException fnfe) {
			System.out.println("ERROR: Cannot open file: " + inputFile + " for input");
			System.exit(0);

		}

		//Step 2 - create loop to read through whole file
		while (inputFile.hasNext()) {

			//Step 3 - build Plant Objects and store into ArrayList
			String currentLine = inputFile.nextLine();
			Plant currentPlant = new Plant(currentLine);
			myPlants.add(currentPlant);

			System.out.println("New plant with the following info added: \n" + currentPlant.getName());
		}
		System.out.println("\nAdded a total of " + myPlants.size() + " records from file.\n");

		//Step 2 - close the input stream
		inputFile.close();

		//Step 3 - print contents of ArrayList
		System.out.println("Plants in my collection: \n");
		for (Plant p : myPlants) {
			System.out.println(p);
		}
	}
}