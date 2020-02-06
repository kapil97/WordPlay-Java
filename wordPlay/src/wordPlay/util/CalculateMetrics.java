package wordPlay.util;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Math;

public class CalculateMetrics{
    String line;
    static ArrayList<Integer> wordCountPerSentence=new ArrayList<Integer>();
    static ArrayList<Integer> charPerSentence=new ArrayList<Integer>();
    double averageWordCount;
    void getString(String string){
        line=string;
    }
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
    void displaytoConsole(){
        System.out.println("AVG_NUMBER_WORDS_PER_SENTENCE = "+ calculateAvgWordCount());
        System.out.println("AVG_NUM_CHARS_PER_SENTENCE = "+ calculateAvgCharCount());
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
        averageWordCount=avg;
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
        return avg;
    }

}