package wordPlay.util;
import java.util.Scanner;
import java.util.ArrayList;
import wordPlay.util.Results;
import java.lang.Math;
import java.util.HashMap;
import java.util.Map;

public class CalculateMetrics{

    static ArrayList<Integer> wordCountPerSentence=new ArrayList<Integer>();
    static ArrayList<Integer> charPerSentence=new ArrayList<Integer>();
    HashMap<String, Integer> wordWithCount = new HashMap<String, Integer>();
     String mostFreqWord;
     double averageWordCount,averageCharCount;
   // Results results=new Results();
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
        //System.out.println("Average Character per Word : "+ avg);
        avg=Math.floor(avg * 100) / 100;
        averageCharCount=avg;
        //results.setAvgCharCount(averageCharCount);
        return avg;
    }
    double calculateAvgWordCount(){
        double sum=0,count=0;
        double avg=0.00;
        for (int i=0; i<wordCountPerSentence.size(); i++){
            sum+=wordCountPerSentence.get(i);
            count++;
        }
        //System.out.println("sum :"+ sum);
        //System.out.println("count:"+ count);
        avg=sum/count;
        //System.out.println("average:"+ avg);
        avg=Math.floor(avg * 100) / 100;
        averageWordCount=avg;
       // results.setAvgWordCount(averageWordCount);
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
        //results.setMostFreqWord(mostFreqWord);
        return mostFreqWord;
    }
    void displaytoConsole(){
        System.out.println("AVG_NUMBER_WORDS_PER_SENTENCE = "+ calculateAvgWordCount());
        System.out.println("AVG_NUM_CHARS_PER_SENTENCE = "+ calculateAvgCharCount());
        System.out.println("Most Frequent Word Used = "+calcMostFreqWord());
        //System.out.println("Whole line:"+allStrings);
    }
}