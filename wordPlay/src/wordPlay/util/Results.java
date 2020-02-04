package wordPlay.util;
import java.lang.String;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
public class Results implements FileDisplayInterface, StdoutDisplayInterface {

	void reverseStringsOfSentence(String data){
        String[] words=data.split(" ");

        String[] revWords=new String[words.length];
        String reverseString=new String();
        for(int i=0;i<words.length;i++){
        revWords[i]=reverseWord(words[i]);
        reverseString+=" "+revWords[i];
        }

        calculatemetric(reverseString);
        writeDatatoFile("output.txt",reverseString);
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

    public void writeDatatoFile(String filename, String Line){
	    try {
	        File resultFile=new File(filename);
	        if (resultFile.exists()){
	            FileWriter fileWriter=new FileWriter(filename,true);
	            fileWriter.write(Line);
	            fileWriter.close();
	            System.out.println("Success");

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

    private void calculatemetric(String Line){

    }

}
