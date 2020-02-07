package wordPlay.util;
import java.util.Scanner;
import java.util.ArrayList;
import wordPlay.util.Results;
import java.lang.Math;
import java.util.HashMap;
import java.lang.String;
import java.util.Map;

public class CalculateMetrics{
    /*
    Local Variable Declaration.
     */
    static ArrayList<Integer> wordCountPerSentence=new ArrayList<Integer>();
    static ArrayList<Integer> charPerSentence=new ArrayList<Integer>();
    HashMap<String, Integer> wordWithCount = new HashMap<String, Integer>();
    String mostFreqWord;
    String longestWord;
    static int longestWordLength=0;
    double averageWordCount,averageCharCount;
    int mostFreqWordvalue = 0;

    /**
     *
     * @param numberOfWords
     * @return null
     */
    void addtoArraylist(int numberOfWords){
        wordCountPerSentence.add(numberOfWords);
    }

    /**
     *
     * @param line
     * @return null
     */
    void calculateCharacters(String line){
    int sum=0;
    char[] lineArray=line.toCharArray();
    for(int i=0;i<lineArray.length;i++){
        sum++;
    }
    charPerSentence.add(sum);
    }

    /**
     * @param null
     * @return Average Character Count
     */
    double calculateAvgCharCount(){
        double sum=0,count=0;
        double avg=0;
        for(int i=0;i<charPerSentence.size();i++){
            sum+=charPerSentence.get(i);
            count++;
        }
        avg=sum/count;
        avg=Math.floor(avg * 100) / 100;
        averageCharCount=avg;
        return avg;
    }

    /**
     * @param null
     * @return Average Word Count
     */
    double calculateAvgWordCount(){
        double sum=0,count=0;
        double avg=0.00;
        for (int i=0; i<wordCountPerSentence.size(); i++){
            sum+=wordCountPerSentence.get(i);
            count++;
        }
        avg=sum/count;
        avg=Math.floor(avg * 100) / 100;
        averageWordCount=avg;

        return avg;
    }

    /**
     *
     * @param word
     * @return null
     */
    void createWordMap(String word){
        if(wordWithCount.containsKey(word)){
            wordWithCount.put(word,wordWithCount.get(word)+1);
        }
        else
            wordWithCount.put(word,1);
    }

    /**
     *
     * @param null
     * @return Maximum Frequently Used Word
     */
    String calcMostFreqWord(){
        for (Map.Entry mapElement : wordWithCount.entrySet()) {
            if((int)mapElement.getValue()>mostFreqWordvalue){
                mostFreqWord=(String)mapElement.getKey();
                mostFreqWordvalue=(int)mapElement.getValue();
            }
        }
        return mostFreqWord;
    }
    /*
    Calculate Longest Word
     */

    /**
     *
     * @param word
     * @return null
     */
    void longestWord(String word){
        if(word.contains(".")){
            word= word.replace(".","");
            if(longestWordLength<word.length()) {
                longestWordLength = word.length();
                longestWord=word;
            }
        }

    }

    /**
     *
     * @param null
     * @return Longest Word
     */
    String getLongestWord(){
        return longestWord;
    }

    /**
     *
     * @param null
     * @return null
     */
    void displaytoConsole(){
        System.out.println("AVG_NUMBER_WORDS_PER_SENTENCE = "+ calculateAvgWordCount());
        System.out.println("AVG_NUM_CHARS_PER_SENTENCE = "+ calculateAvgCharCount());
        System.out.println("Most Frequent Word Used = "+calcMostFreqWord());
        System.out.println("Longest Word: "+longestWord);
    }

}