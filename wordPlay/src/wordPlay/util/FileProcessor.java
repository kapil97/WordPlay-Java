package wordPlay.util;
import java.util.Scanner;
import wordPlay.util.Results;
import wordPlay.util.FileDisplayInterface;
import java.io.File;
import java.lang.String;
import java.io.FileNotFoundException;
public class FileProcessor {
    /*
    Setters for File Names
     */
    String inputFileName,outputFileName,metricsFileName;
    /**
     *
     * @param inputFile
     *
     */
    public void setInputFileName(String inputFile){
        inputFileName=inputFile;
    }
    /**
     *
     * @param outputFile
     */
    public void setOutputFileName(String outputFile){
        outputFileName=outputFile;
    }
    /**
     *
     * @param metricsFile
     */
    public void setMetricsFileName(String metricsFile){
        metricsFileName=metricsFile;
    }
    /**
     *
     * @param sentence
     * @return boolean value whether String is valid or not
     */
    private boolean validation(String sentence) {
        if (sentence == null) {
            return false;
        }
        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            if (!(c >= 'A' && c <= 'Z') && !(c >= 'a' && c <= 'z')&&!(c >= '0' && c <= '9') && !(c==' ') && !(c=='.')){
                return false;
            }
        }
        return true;
    }
    /*
    Processing Input File
     */

    /**
     * @param null
     * @return null
     * @throws FileNotFound Exception
     */
    public void processInputFile() {
        try {
            String reversedSentence;
            Scanner sc = new Scanner(new File(inputFileName));
            Results results=new Results();
            FileDisplayInterface fileDisplayInterface=new Results();        //casting object to FileDisplayInterface
            StdoutDisplayInterface stdoutDisplayInterface=new Results();
            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                if (validation(data)) {                                     //Validating Data in the File
                    reversedSentence = results.sentenceProcessor(data);     //Sentence by Sentence Processing
                    fileDisplayInterface.writeDatatoFile(outputFileName, reversedSentence); // Writing to Result File
                } else {
                   results.printToConsole("ERROR: Input File with Invalid Characters, Only Aa-Zz 0-9 white spaces and periods"); // Error
                    System.exit(0);
                }
            }
            results.writeToMetricsFile(metricsFileName);
            results.displayMetrics();
        }
       catch (FileNotFoundException e){
            System.out.println("File not found"); //Catching Exception
            e.printStackTrace();
       }

    }
}
