# Csv2Json
Convert CSV File to JSON Document File for list of Vacancy by excluding missing shiftType.


# Assumptions
The given CSV has a header and the following columns with comma separated:
Column Name	Data Type
-----------	---------
creator		String
break		Number
description	String
start		String
end			String
shiftType	String

Compile: Java 1.8.
Runtime: Java 1.8.


# How to build with Eclipse
1. Import the project into Eclipse.
2. Select the project in Project Explorer.
3. Select "Project" from the top menu. If "Build Automatically" is not selected, click "Build Project".
4. Right click the project and select Export.
5. Select Java JAR file.
6. Select a destination e.g. C:\Users\userName\Desktop\csv2json-services.jar and click the "Finish" button.


# How to build with Maven
1. Launch Command Prompt and browse to the project folder.
2. Execute
	mvn compile


# How to execute the application with Eclipse
1. Import the project into Eclipse and make sure the project has been built.
2. Select the project in Project Explorer.
3. Right click the project. Select "Run As". Select "Run Configuration...".
4. Select "ConvertVacancyApplication" under Java Application.
5. In Arguments tag, input the CSV source file path and JSON destination file path. For example:
	"C:\input.csv" "C:\output.json" 

	ConvertVacancyApplication [input-path][output-path]
		input-path		File path and name of the input file
		output-path		File path and name of the output file
6. Click the "Run" button.


# How to execute the application with Maven
1. Launch Command Prompt and browse to the project folder. Make sure the project has been built.
2. Execute
	mvn exec:java -Dexec.mainClass=com.mt99.service.ConvertVacancyApplication -Dexec.args="'C:\input.csv' 'C:\output.json'"

	where "C:\input.csv" and "C:\output.json" are the arguments of input and output paths.