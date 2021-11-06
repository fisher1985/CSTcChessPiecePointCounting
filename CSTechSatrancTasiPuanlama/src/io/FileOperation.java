package io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileOperation {
	// dosyadan okuma fonksiyonu
	public static ArrayList<String> readFromFile(String fileName) throws IOException {
		ArrayList<String> lstLines = new ArrayList<String>();
		Scanner scanner;
		scanner = new Scanner(new File(fileName));

		while (scanner.hasNext()) {
			lstLines.add(scanner.next());
		}
		scanner.close();
		return lstLines;
	}

	// dosyaya yazdýrma fonksiyonu
	public static void writeToFile(String fileName, String text) throws IOException {
		BufferedWriter bWriter;
		bWriter = new BufferedWriter(new FileWriter(fileName, true));
		bWriter.write(text);
		bWriter.close();
	}
}
