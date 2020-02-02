package wordPlay.util;
import java.util.Scanner;
import wordPlay.util.Results;
import java.io.File;
import java.io.FileNotFoundException;
public class FileProcessor {

    String inputFileName;
    String pwd="/Users/kapil/Desktop/Sem-2/Design Patterns/csx42-spring-2020-assign1-kapil97/wordPlay/src/";

    public FileProcessor(String filename){
        inputFileName=filename;
    }

    public void processInputFile() {
        try {
            Scanner sc = new Scanner(new File(pwd+inputFileName));
            Results reverseSentence=new Results();
            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                reverseSentence.reverseStringsOfSentence(data);
            }
        }
       catch (FileNotFoundException e){
            System.out.println("in catch, error:"+inputFileName);
            e.printStackTrace();
       }
    }

}
