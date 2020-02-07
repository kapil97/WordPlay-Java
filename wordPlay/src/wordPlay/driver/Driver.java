package wordPlay.driver;
import wordPlay.util.FileProcessor;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * @author Kamleshwar Ragava
 *
 */
public class Driver {
	/**
	 *
	 * @param args
	 * @return null
	 */
	public static void main(String[] args) {

		/*
		 * As the build.xml specifies the arguments as argX, in case the
		 * argument value is not given java takes the default value specified in
		 * build.xml. To avoid that, below condition is used
		 */

		if ((args.length != 3) || (args[0].equals("${arg0}")) || (args[1].equals("${arg1}")) || (args[2].equals("${arg2}"))) {
			System.err.println("Error: Incorrect number of arguments. Program accepts 3 arguments.");
			System.exit(0);
		}
		/*
		Creating object of FileProcessor class
		 */
		FileProcessor fileProcessor=new FileProcessor();
		/*
		Passing the arguments to FileProcessor
		 */
			fileProcessor.setInputFileName(args[0]);
			fileProcessor.setOutputFileName(args[1]);
			fileProcessor.setMetricsFileName(args[2]);
		/*
		Initiating the Process of Input File
		 */

			fileProcessor.processInputFile();
	}
}
