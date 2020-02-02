package wordPlay.util;
import java.lang.String;
import java.io.File;
public class Results implements FileDisplayInterface, StdoutDisplayInterface {
	void reverseStringsOfSentence(String data){
        String[] words=data.split(" ");
        String[] revWords=new String[words.length];
        String reverseString=new String();
        for(int i=0;i<words.length;i++){
        revWords[i]=reverseWord(words[i]);
        reverseString+=" "+revWords[i];
        }
        System.out.println(reverseString);
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

}
