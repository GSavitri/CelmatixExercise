# ToDoExercise


Pre-requisites:
We should have Java and Maven installed and configured to run the test cases. If not configured already, please see the steps given towards the end of this document.  

Please run the suite on Mac OS, as the browser drivers used are particular to the Mac OS.  

Steps for execution:
1.	To view the source code, please open the project in Eclipse.
2.	(Skip this step if Chrome browser is present in your machine). Tests are configured to run either on Chrome browser or Firefox browser. By default test suite is configured to run on Chrome browser. In order to change to Firefox, please change browser type in data.properties file. Steps are as follows.
a.	Go to file   	ToDoApp/src/main/java/Celmatix/ToDoApp/data.properties

b.	Change “Browser =FireFox “ for the FireFox Browser.

3.	Go to terminal and change directory to the project folder.
		Example:  cd   Users/Savitri /ToDoApp

4.	Run the test cases by executing following command.
		mvn test

5.	With the above command, test case execution begins. Progress of test execution can be seen on the command prompt. Tests are executed by launching the browser, navigating to the website, executing all the requirements and ends by closing the browser. After successful execution, BUILD SUCCESS message is shown with execution summary as shown in the screenshot.  
6.	View Reports
	To view reports please go to the following folder
	projectpath/target/surefire-reports/ExtentReportTestNG.html
	Note: projectpath for me is: Users/Savitri /ToDoApp
	Open the ExtentReportTestNG.html file in the browser to view the detailed     	reports as shown in the screen shot below.

 


Steps to Install and Configure Java on Mac Machine.
1.	Go to link http://www.oracle.com/technetwork/java/javase/downloads/index.html
2.	Download the latest version of JDK for Mac machine.
3.	Install Java by running the JDK.
4.	Open Terminal.
5.	Type: vim  ~/.bash_profile 
6.	Press “i” in order to edit the bash_profile file.
7.	Add this to the end of the bash.profile file:
	Export JAVA_HOME = $(/usr/libexec/java_home)
8.	Press :wq to save the file and exit .
9.	Type : source  .bash_profile  
	


Steps to Install and Configure Maven on Mac Machine:
1.	Go to link https://maven.apache.org/download.cgi
2.	Download   apache-maven-3.5.3-bin.tar.gz for the Mac machine.
3.	Unzip the downloaded files.
4.	Copy the path of the downloaded maven folder.
5.	Open Terminal.
6.	Type: vi  ~/.bash_profile 
7.	Press “i” in order to edit the file.
8.	Add maven folder directory path to the end of bash.Profile file:
	For Example:
	export PATH="/Users/ Savitri/Library/apache-maven-3.5.2/bin:$PATH"
9.	Press  :wq to save the file and exit                                            

General Info:
Please clone the project from here:   https://github.com/GSavitri/ToDoExercise.git  
•	R1: Enter an item with the text “purchase shampoo”
•	R2: Verify the text appears in the list of to-dos
•	R3: Enter two additional items, “wash cat” and “purchase band-aids”
•	R4: Verify the new items appear in the list
•	R5: Verify the number at the left side of the list footer correctly indicates 3 items
•	R6: Check the box next to “wash cat” (marking it complete) and verify that the total in the list footer correctly indicates 2 items
•	R7: Click “clear completed” and verify that the “wash cat” item is no longer present in the list
•	R8: Add more items (as many as you feel you need) to attempt to perform a code injection exploit on the application. (NOTE that it is expected that this application will not be vulnerable.)








		


