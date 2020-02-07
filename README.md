# CSX42: Assignment 1
## Name: Kamleshwar Ragava

-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in wordPlay/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile wordPlay/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile wordPlay/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: ant -buildfile wordPlay/src/build.xml run -Darg0="input.txt" -Darg1="output.txt" -Darg2="metrics.txt"

Note: Arguments accept the absolute path of the files.


-----------------------------------------------------------------------
## Description:

Flow of Control:

The Driver Class will send arguments(Filenames) to the FileProcessor Class.<br>
FileProcessor validates the file contents and parses the input file sentence by sentence to the result class.<br>
Result Class has SentenceHandler method which reverses the Sentence as well as it passes the sentence to the Calculate Metrics Class.<br>
The reversed String is sent back to the fileprocessor class.<br>
The fileprocessor writes this sentence to the output.txt file.<br>
File Processor loops through the sentences until it reaches end of the file.<br>
File Processor later writes to metrics file by calling writeToMetricsFile on ResultsObject.<br>

FileDisplayInterface has one method:<br>
	writetoFile
Implementation of this method is present in results file.<br>
StdoutDisplayInterface has two methods:<br>
	printToConsole<br>
	displayMetrics<br>
Implementation of this methods is present in results file.<br>

<h4>Whats could not be included:</h4>
<ul>
	<li>Validation not done as taught.</li>
	<li>overriding toString() for the purpose of debugging in every class.</li>
	<li>Exception Handled Partially.</li>

</ul>

<h5>References used from </h5>
<ul>
	<li>https://www.techiedelight.com/ :<i>for validation</i></li> 
	<li>https://www.geeksforgeeks.org/ :<i>for HashMap</i></li>  
</ul>	

-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: 02/06/2020


