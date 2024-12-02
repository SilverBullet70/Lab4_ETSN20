import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SearchFile {

	public static void main(String[] args) {
		try {

			Scanner input = new Scanner(System.in);
			String[] command = input.nextLine().split(" ");

			if (!command[0].equals("search"))
				return;

			String keyword = command[1];
			String filename = command[2];
			
			
			
			File file = new File("src/main/resources/" + filename);
			Scanner sc = new Scanner(file);

			boolean flag = false;
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				if (line.contains(keyword)) {
					System.out.println(line);
					flag = true;
				}
			}
			
			if(!flag)
				System.out.println(keyword + " Not Found in " + filename + ".");
			
			sc.close();
		} catch (FileNotFoundException e) {
			System.err.println("File Not Found.");
			e.printStackTrace();
		}

	}

}
