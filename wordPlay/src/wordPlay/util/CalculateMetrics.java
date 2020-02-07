package wordPlay.util;
import java.util.Scanner;
import java.util.ArrayList;
import wordPlay.util.Results;
import java.lang.Math;
import java.util.HashMap;
import java.lang.String;
import java.util.Map;

public class CalculateMetrics{

    static ArrayList<Integer> wordCountPerSentence=new ArrayList<Integer>();
    static ArrayList<Integer> charPerSentence=new ArrayList<Integer>();
    HashMap<String, Integer> wordWithCount = new HashMap<String, Integer>();
    String mostFreqWord;
    String longestWord;
    static int longestWordLength=0;
    double averageWordCount,averageCharCount;
    int mostFreqWordvalue = 0;

    void addtoArraylist(int numberOfWords){
        wordCountPerSentence.add(numberOfWords);
    }
    void calculateCharacters(String line){
    int sum=0;
    char[] lineArray=line.toCharArray();
    for(int i=0;i<lineArray.length;i++){
        sum++;
    }
    charPerSentence.add(sum);
    }
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
    void createWordMap(String word){
        if(wordWithCount.containsKey(word)){
            wordWithCount.put(word,wordWithCount.get(word)+1);
        }
        else
            wordWithCount.put(word,1);
    }
    String calcMostFreqWord(){
        for (Map.Entry mapElement : wordWithCount.entrySet()) {
            if((int)mapElement.getValue()>mostFreqWordvalue){
                mostFreqWord=(String)mapElement.getKey();
                mostFreqWordvalue=(int)mapElement.getValue();
            }
        }
        return mostFreqWord;
    }

    void longestWord(String word){
        if(word.contains(".")){
            word= word.replace(".","");
            if(longestWordLength<word.length()) {
                longestWordLength = word.length();
                longestWord=word;
            }
        }

    }
    String getLongestWord(){
        return longestWord;
    }
    void displaytoConsole(){
        System.out.println("AVG_NUMBER_WORDS_PER_SENTENCE = "+ calculateAvgWordCount());
        System.out.println("AVG_NUM_CHARS_PER_SENTENCE = "+ calculateAvgCharCount());
        System.out.println("Most Frequent Word Used = "+calcMostFreqWord());
        System.out.println("Longest Word: "+longestWord);
    }
}