package template_design_pattern;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Main {
	public static void main(String[] args) {
		System.out.println("Aur batao kyaa haal hai jaane mann");
		Logger logs = MyLogger.getLogger();
		Scanner sc = new Scanner(System.in);
		logs.log(Level.INFO,"Creating an instance of textFielProcessing");
		//Creating an instance of textFileProcessing
		FileHandling txtProcessor = new TextFileProcessing();
		
		//Asking for which file to be read
//		System.out.print("Enter the file name: ");
//		String file_name = sc.nextLine();
		logs.log(Level.INFO,"File name is give to read data inside main function");
		String file_name  = "file1.txt";
		logs.log(Level.INFO,"Text File Processing methods starts");
		txtProcessor.fileProcessing(file_name);
		//logs.info("Closing the main() method...");
		sc.close();
	}
}
