package com.mt99.service;

import com.mt99.service.model.Vacancy;

/**
 *	<p>Java application for converting vacancy document.</p>
 *
 *	<p>Usage:
<pre>
	ConvertVacancyApplication [input-path][output-path]
		input-path		File path and name of the input file
		output-path		File path and name of the output file
</pre>
 *	</p>
 **/
public class ConvertVacancyApplication {
	/**
	 *	Execute this application.
	 *	@param	args	Arguments
<pre>
	ConvertVacancyApplication [input-path][output-path]
	input-path		File path and name of the input file
	output-path		File path and name of the output file
</pre>	
	 **/
	public static void main(String args[]) {
		String inputPath	= args != null && args.length > 0? args[0] : null;
		String outputPath	= args != null && args.length > 1? args[1] : null;

		//	Validate arguments
		if (inputPath == null || inputPath.trim().equals("")) {
			System.out.println("Missing [input-path]");
			printUsage();
			System.exit(-1);
			return;
		}

		if (outputPath == null || outputPath.trim().equals("")) {
			System.out.println("Missing [output-path]");
			printUsage();
			System.exit(-1);
			return;
		}

		//	Initialize the service
		ConvertService<Vacancy> service	= new ConvertVacancyCsv2JsonService();
		service.setInputPath(inputPath);
		service.setOutputPath(outputPath);
		service.init();

		//	Execute the service
		if (!service.execute()) {
			System.out.println("Fail to execute.");
			printUsage();
			System.exit(-1);
		}
		else {
			System.out.println("Convert successfully.");
			System.exit(1);
		}
	}	// main()

	/**	Display the usage of using this application.	**/
	private static void printUsage() {
		System.out.println("Usage:");
		System.out.println("	ConvertVacancyApplication [input-path][output-path]");
		System.out.println("		input-path		File path and name of the input file");
		System.out.println("		output-path		File path and name of the output file");
	}	// printUsage()
}	// class ConvertVacancyApplication