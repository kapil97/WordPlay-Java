package wordPlay.util;
import java.util.Scanner;
import wordPlay.util.Results;
import java.io.File;
import java.lang.String;
import java.io.FileNotFoundException;
public class FileProcessor {

    String inputFileName;


    public FileProcessor(String filename){
        inputFileName=filename;
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
            Scanner sc = new Scanner(new File(inputFileName));
            Results reverseSentence=new Results();
            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                if(validation(data))
                reverseSentence.reverseStringsOfSentence(data);
                else
                    System.out.println("ERROR: Input File with Invalid Characters, Only Aa-Zz 0-9 white spaces and periods");
            }
        }
       catch (FileNotFoundException e){
            System.out.println("in catch, error:"+inputFileName);
            e.printStackTrace();
       }

    }

}
