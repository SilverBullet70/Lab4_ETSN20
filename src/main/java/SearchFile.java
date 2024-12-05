import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SearchFile {

	public static void main(String[] args) throws IOException {
		try {

			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			String[] command = input.readLine().split(" ");

			if (!command[0].equals("search"))
				return;

			String keyword = command[1];
			String filename = command[command.length - 1];

			BufferedReader sc = new BufferedReader(new FileReader("src/main/resources/" + filename));

			StringBuilder sb = new StringBuilder();
			String line = sc.readLine();
			while (line != null) {

				if (line.contains(keyword))
					sb.append(line + "\n");
				line = sc.readLine();
			}

			if (sb.toString().equals("") || sb.toString() == (null))
				System.out.println(keyword + " Not Found in " + filename + ".");
			else
				System.out.println(sb.toString());

			sc.close();
		} catch (FileNotFoundException e) {
			System.err.println("File Not Found.");
			e.printStackTrace();
		}

	}

}
