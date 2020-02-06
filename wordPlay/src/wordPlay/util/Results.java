package wordPlay.util;
import java.lang.String;
import wordPlay.util.CalculateMetrics;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
public class Results implements FileDisplayInterface, StdoutDisplayInterface {
    double avgWordCountPerSentence;
    double avgCharCountPerSentence;
    String mostFreqWordUsed;
    String longestWord;
    CalculateMetrics calculateMetrics=new CalculateMetrics();
    String reverseStringsOfSentence(String data){
        calculateMetrics.calculateCharacters(data);
        String[] words=data.split(" ");
        calculateMetrics.addtoArraylist(words.length);
        String[] revWords=new String[words.length];
        String reverseString=new String();
        for(int i=0;i<words.length;i++){
            calculateMetrics.createWordMap(words[i]);
            revWords[i]=reverseWord(words[i]);
            reverseString+=" "+revWords[i];
        }
        System.out.println(reverseString);
        return reverseString;
    }
    void displayMetrics(){
        calculateMetrics.displaytoConsole();
        System.out.println("inside results: "+ calculateMetrics.calculateAvgWordCount()+calculateMetrics.calculateAvgCharCount()+calculateMetrics.calcMostFreqWord());
    }

    String reverseWord(String data){
	    StringBuilder sb=new StringBuilder();
	    int period=0;
        for(int i=data.length()-1; i >= 0; i--)
        {
            if(data.charAt(i)=='.') {
                period = 1;
                i--;
            }
            sb.append(data.charAt(i));
        }
        if (period==1){
            sb.append('.');
        }
        return sb.toString();
    }

    public void writeDatatoFile(String filename, String Line){
	    try {
	        File resultFile=new File(filename);
	        if (resultFile.exists()){
	            FileWriter fileWriter=new FileWriter(filename,true);
	            fileWriter.write(Line);
	            fileWriter.write(System.getProperty("line.separator"));
	            fileWriter.close();
            }
	        else{
                resultFile.createNewFile();
                System.out.println("File Created:"+resultFile.getName());
                writeDatatoFile(filename,Line);
            }
        }
	    catch (IOException e){
	       System.out.println("Error occured");
        }
    }



}
