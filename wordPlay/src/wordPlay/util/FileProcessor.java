package wordPlay.util;
import java.util.Scanner;
import wordPlay.util.Results;
import wordPlay.util.FileDisplayInterface;
import java.io.File;
import java.lang.String;
import java.io.FileNotFoundException;
public class FileProcessor {

    String inputFileName,outputFileName,metricsFileName;
    public void setInputFileName(String inputFile){
        inputFileName=inputFile;
    }
    public void setOutputFileName(String outputFile){
        outputFileName=outputFile;
    }
    public void setMetricsFileName(String metricsFile){
        metricsFileName=metricsFile;
    }
    private boolean validation(String sentence) {        //Referred from https://www.tutorialspoint.com/how-to-find-if-a-given-string-contains-only-letters-in-java
        sentence = sentence.toLowerCase();
        int valid=0;
        char[] charArray = sentence.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];
            if ((ch >= 'a' && ch <= 'z') || ch == ' ' || ch == '.') {
                valid = 1;
            } else valid = 0;
        }
        if (valid == 1)
            return true;
        else return false;
    }

    public void processInputFile() {
        try {
            String reversedSentence;
            Scanner sc = new Scanner(new File(inputFileName));
            Results results=new Results();
            FileDisplayInterface fileDisplayInterface=new Results();
            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                if (validation(data)) {
                    reversedSentence = results.sentenceProcessor(data);
                    fileDisplayInterface.writeDatatoFile(outputFileName, reversedSentence);
                } else
                    System.out.println("ERROR: Input File with Invalid Characters, Only Aa-Zz 0-9 white spaces and periods");
            }
            results.writeToMetricsFile(metricsFileName);
            results.displayMetrics();
        }
       catch (FileNotFoundException e){
            System.out.println("in catch, error:"+inputFileName);
            e.printStackTrace();
       }

    }
}
