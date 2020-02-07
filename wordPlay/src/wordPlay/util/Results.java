package wordPlay.util;
import java.lang.String;
import wordPlay.util.CalculateMetrics;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileWriter;
public class Results implements FileDisplayInterface, StdoutDisplayInterface {
    /*
    Local variable declarations
     */
    double avgWordCountPerSentence;
    double avgCharCountPerSentence;
    String mostFreqWordUsed;
    ArrayList<String> resultMetrics=new ArrayList<String>();
    String longestWord;
    /*
    Object Creation of Metrics
     */
    CalculateMetrics calculateMetrics=new CalculateMetrics();
    /**
     *
     * @param data
     * @return Reversed String
     */
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
        printToConsole(reverseString);
        return reverseString;
    }
    /**
     * @param null
     * @return null
     */
    void getMetrics(){
        avgCharCountPerSentence=calculateMetrics.calculateAvgCharCount();
        avgWordCountPerSentence=calculateMetrics.calculateAvgWordCount();
        mostFreqWordUsed=calculateMetrics.calcMostFreqWord();
        longestWord=calculateMetrics.getLongestWord();
    }
    /**
     * @param null
     * @return null
     */
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
    /**
     *
     * @param metricsFileName
     * @return null
     */
    void writeToMetricsFile(String metricsFileName)
    {
        this.getMetrics();
        this.stringToWriteinFile();
        for(int i=0;i<resultMetrics.size();i++){
            writeDatatoFile(metricsFileName,resultMetrics.get(i));
        }
    }
    /**
     * @param null
     * @return null
     */
    public void displayMetrics(){
        calculateMetrics.displaytoConsole();
    }
    /**
     *
     * @param data
     * @return reversed string in local class
     */
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
    /**
     *
     * @param data
     * @return null
     */
    public void printToConsole(String data){
        System.out.println(data);
    }
    /**
     *
     * @param filename
     * @param Line
     * @retrun null
     */
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
