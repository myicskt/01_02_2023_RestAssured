package com.inetbanking.testCase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CreateFiles {
	static String folderPath = "/Users/mr.gobindachapai/eclipse-workspace/selenium_01_03/src/main/java/data/";

	public static void main(String[] args) throws IOException {
		System.out.print("This is the file create ");
		createFiles();
		writeFile1();
		readFile();
		getFileInformation();

	}

// Create the file method
	public static void createFiles() throws IOException {

		File myobj = new File(folderPath + "DemoData1.txt");
		if (myobj.createNewFile()) {
			System.out.println("File created: " + myobj.getName());
		} else {
			System.out.println("File already exists.");
		}
	}

	// write a file
	public static void writeFile1() throws IOException {
		FileWriter myWriter = new FileWriter(
				"/Users/mr.gobindachapai/eclipse-workspace/selenium_01_03/src/main/java/data/DemoData.txt");
		myWriter.write("Files in Java might be tricky, but it is fun enough!");
		myWriter.close();
		System.out.println("Successfully wrote to the file.");
	}
     
	// Read a file
	public static void readFile() throws FileNotFoundException {

		File myObj = new File(folderPath + "DemoData.txt");
		Scanner myReader = new Scanner(myObj);
		while (myReader.hasNextLine()) {
			String data = myReader.nextLine();
			System.out.println(data);
		}
	}
	// get File Information

	public static void getFileInformation() throws FileNotFoundException {
		File myobj = new File(folderPath);
		if (myobj.exists()) {
			System.out.println("File Name is : " + myobj.getName());
			System.out.println("File Patha is : " + myobj.getParentFile());
			System.out.println("File Patha is : " + myobj.getAbsolutePath());
			System.out.println("File getAbsoluteFile is : " + myobj.getAbsoluteFile());
			System.out.println("File Patha is : " + myobj.canRead());
			System.out.println("File canWrite is : " + myobj.canWrite());
			System.out.println("File lastModified is : " + myobj.lastModified());
		}
	}

}