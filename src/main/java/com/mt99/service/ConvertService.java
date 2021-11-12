package com.mt99.service;

import java.util.List;

import com.mt99.service.export.Exportable;
import com.mt99.service.extract.Extractable;
import com.mt99.service.process.Processable;

/**
 *	Abstract class for converting object T by
 *	<ul><li>Extract the list of object T from a source.</li>
 *		<li>Process the extracted list of object T.</li>
 *		<li>Output the processed list of object T.</li>
 *	</ul>
 **/
public abstract class ConvertService<T> {
	/**	Input path of the source.	**/
	protected String inputPath;
	/**	Output path of the destination.	**/
	protected String outputPath;

	/**	Extractor to extract source list.	**/
	private Extractable<T> extractor;
	/**	Processor to process extracted list.	**/
	private Processable<T> processor;
	/**	Exporter to export processed list.	**/
	private Exportable<T> exporter;

	/**	Initialize this service after setting all the properties.
	 *	Please construct your own {@link #extractor}, {@link #processor}, and {@link #exporter}.	**/
	protected abstract void init();

	/**	Create a default instance of this service.	**/
	public ConvertService() {
		//	Do nothing
	}	// ConvertService()

	/**	Execute this service for converting object T by
	 *	<ul><li>Validate the given parameters.</li>
	 *		<li>Extract the list of object T from a source.</li>
	 *		<li>Process the extracted list of object T.</li>
	 *		<li>Output the processed list of object T.</li>
	 *	</ul>
	 *
	 *	@return	Whether the execution is success.
	 *	@return	<code>false</code> for any exceptions.
	 **/
	public boolean execute() {
		if (!validate())
			return false;

		try {
		//		To prevent file path traversal attacks
		//	List<T> extractedList	= extractor.extract(new File(inputPath));
			List<T> extractedList	= extractor.extract(java.nio.file.FileSystems.getDefault().getPath(inputPath).toFile());
			List<T> processedList	= processor.process(extractedList);
			return exporter.export(processedList);
		}
		catch (Exception e) {
			return false;
		}
	}	// execute()

	/**
	 *	Validate the given parameters.
	 **/
	private boolean validate() {
		if (inputPath == null || inputPath.trim().equals(""))
			return false;
		if (outputPath == null || outputPath.trim().equals(""))
			return false;

		return true;
	}	// validate()

	/**	Return {@link #inputPath}.	**/
	public String getInputPath() {
		return inputPath;
	}
	/**	Set input path into {@link #inputPath}.	**/
	public void setInputPath(String inputPath) {
		this.inputPath = inputPath;
	}
	/**	Return {@link #outputPath}.	**/
	public String getOutputPath() {
		return outputPath;
	}
	/**	Set output path into {@link #outputPath}.	**/
	public void setOutputPath(String outputPath) {
		this.outputPath = outputPath;
	}
	/**	Set extractor into {@link #extractor}.	**/
	public void setExtractor(Extractable<T> extractor) {
		this.extractor = extractor;
	}
	/**	Set processor into {@link #processor}.	**/
	public void setProcessor(Processable<T> processor) {
		this.processor = processor;
	}
	/**	Set exporter into {@link #exporter}.	**/
	public void setExporter(Exportable<T> exporter) {
		this.exporter = exporter;
	}
}	// abstract class ConvertService