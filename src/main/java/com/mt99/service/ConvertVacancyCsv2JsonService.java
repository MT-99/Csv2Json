package com.mt99.service;

import com.mt99.service.export.JsonDocumentExporter;
import com.mt99.service.extract.CsvExtractor;
import com.mt99.service.model.Vacancy;
import com.mt99.service.process.Processable;
import com.mt99.service.process.VacancyProcessor;

/**
 *	Convert vacancies from a CSV with {@link CsvExtractor} to a JSON Document with {@link JsonDocumentExporter} processed by {@link VacancyProcessor}.
 **/
public class ConvertVacancyCsv2JsonService extends ConvertService<Vacancy> {

	/**	Construct a default instance of this service.	**/
	public ConvertVacancyCsv2JsonService() {
		super();
	}	// ConvertCsv2JsonService()

	/**	Initialize this service.	**/
	protected void init() {
		//	Initialize the CSV extractor
		CsvExtractor<Vacancy> csvExtractor	= new CsvExtractor<Vacancy>();
		csvExtractor.setListObjectClass(Vacancy.class);
		setExtractor(csvExtractor);

		//	Initialize the Vacancy Processor
		Processable<Vacancy> processor	= new VacancyProcessor();
		setProcessor(processor);

		//	Initialize the JSON Document Exporter
		JsonDocumentExporter<Vacancy> exporter	= new JsonDocumentExporter<Vacancy>();
	//		To prevent file path traversal attacks
	//	exporter.setDestinationFile(new File(outputPath));
		exporter.setDestinationFile(java.nio.file.FileSystems.getDefault().getPath(outputPath).toFile());
		setExporter(exporter);
	}	// init()
}	// class ConvertVacancyCsv2JsonService