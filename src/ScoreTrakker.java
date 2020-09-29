//Ryan Rumana
//Alejandro Martinez Gonzalez


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;			// imports
import java.io.*;

public class ScoreTrakker {			// ScoreTrakker class
	private String[] files = {"scores.txt", "badscore.txt", "nofile.txt" };  // code provided by assignment

	private ArrayList<Student> Students = new ArrayList<Student>();			// Arraylist of students

	public void loadDataFromFile(String fileName) throws FileNotFoundException { 
		FileReader Reader = new FileReader(fileName);  	// using a filereader to parse the input file
		Scanner in = new Scanner(Reader);			   	// using scanner to interface with filereader
		int score = 0;
		String error = "";								// variable used to capture the incorrect score in the case that an exception is thrown
		String name = "";
		while(in.hasNextLine()) {						// while loop to parse through the whole .txt file
			name = in.nextLine();						// get the entire name string
			try {
				error = in.nextLine();					// set a variable to the value of the expected score in the case it throws an error
				score = Integer.parseInt(error);
			}
			catch(NumberFormatException e) {			// catch statement for error
				System.out.println("Incorrect format for " + name + " not a valid score: " + error); 		// message for error output as per instructions
				System.out.println("");					// newline
				continue;								// continue so that the incorrect name is not printed and the while loop automatically goes top the next iteration
			}
			Student temp = new Student(name, score);	// making a new instance of student to add to the arraylist
			Students.add(temp);
		}
	}

	public void printInOrder() {
		Collections.sort(Students);						// glad I googled this.
		for(Student i : Students) System.out.println(i);// for each loop to print each student
		System.out.println("");							// newline
	}

	public void processFiles() throws FileNotFoundException {
		for(String i : files)							// loop to automatically try to read in each file no matter how many there are
			try {
				loadDataFromFile(i);					// methods requested by instructions
				printInOrder();
				Students.clear();						// Clearing the arraylist of students after each set has been printed
			}
		catch(FileNotFoundException e) {				// Catch in case an exception is thrown
			System.out.println("can't open file: " + i);// message for error output as per instructions
			System.out.println("");						// newline
		}
	}

	public static void main(String[] args) throws FileNotFoundException { //main as per instructions
		ScoreTrakker List = new ScoreTrakker();
		List.processFiles();
	}

}
