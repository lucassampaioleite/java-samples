package program;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		String path = "./in.txt";

		// Read: Example 1 (File)
		File file = new File(path);
		Scanner sc = null;
		System.out.println("Example 1: ");		
		try {
			sc = new Scanner(file);
			while (sc.hasNextLine())
				System.out.println(sc.nextLine());

		} catch (FileNotFoundException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			if (sc != null)
				sc.close();
		}

		// Read: Example 2 (BufferedReader)
		FileReader fr = null;
		BufferedReader bf = null;
		System.out.println("\nExample 2: ");	
		try {
			fr = new FileReader(path);
			bf = new BufferedReader(fr);
			String line = bf.readLine();
			while (line != null) {
				System.out.println(line);
				line = bf.readLine();
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			try {
				if (fr != null)
					fr.close();
				if (bf != null)
					bf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// Read: Example 3 (try-catch-resources)
		System.out.println("\nExample 3: ");	
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
