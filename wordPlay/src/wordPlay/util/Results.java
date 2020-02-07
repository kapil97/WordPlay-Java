package wordPlay.util;
import java.lang.String;
import wordPlay.util.CalculateMetrics;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileWriter;
public class Results implements FileDisplayInterface, StdoutDisplayInterface {
    double avgWordCountPerSentence;
    double avgCharCountPerSentence;
    String mostFreqWordUsed;
    ArrayList<String> resultMetrics=new ArrayList<String>();
    String longestWord;
    CalculateMetrics calculateMetrics=new CalculateMetrics();

    String sentenceProcessor(String data){
        calculateMetrics.calculateCharacters(data);
        String[] words=data.split(" ");
        calculateMetrics.addtoArraylist(words.length);
        String[] revWords=new String[words.length];
        String reverseString=new String();
        for(int i=0;i<words.length;i++){
            calculateMetrics.createWordMap(words[i]);
            calculateMetrics.longestWord(words[i]);
            revWords[i]=reverseWord(words[i]);
            reverseString+=" "+revWords[i];
        }
        System.out.println(reverseString);
        return reverseString;
    }
    void getMetrics(){
        avgCharCountPerSentence=calculateMetrics.calculateAvgCharCount();
        avgWordCountPerSentence=calculateMetrics.calculateAvgWordCount();
        mostFreqWordUsed=calculateMetrics.calcMostFreqWord();
        longestWord=calculateMetrics.getLongestWord();
    }
    void stringToWriteinFile(){
        String addToMetricsList="AVG_NUMBER_WORDS_PER_SENTENCE = "+ avgWordCountPerSentence;
        resultMetrics.add(addToMetricsList);
        addToMetricsList="AVG_NUM_CHARS_PER_SENTENCE = "+ avgCharCountPerSentence;
        resultMetrics.add(addToMetricsList);
        addToMetricsList="MAX_FREQ_WORD = " + mostFreqWordUsed;
        resultMetrics.add(addToMetricsList);
        addToMetricsList="LONGEST_WORD = " + longestWord;
        resultMetrics.add(addToMetricsList);
    }
    void writeToMetricsFile(String metricsFileName)
    {
        this.getMetrics();
        this.stringToWriteinFile();
        for(int i=0;i<resultMetrics.size();i++){
            writeDatatoFile(metricsFileName,resultMetrics.get(i));
        }
    }
    void displayMetrics(){
        calculateMetrics.displaytoConsole();
        System.out.println("inside results: "+ avgWordCountPerSentence+" "+avgCharCountPerSentence+" "+ mostFreqWordUsed+ " "+ longestWord);
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
