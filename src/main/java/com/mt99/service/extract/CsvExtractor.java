package com.mt99.service.extract;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

/**
 *	Extract a given CSV file into a list of object T.
 **/
public class CsvExtractor<T> implements Extractable<T> {
	/**	Class instance of the list of object T.	**/
	private Class<T> listObjectClass;

	/**	Extract the given source file to a list of object T.	**/
	public List<T> extract(File sourceFile) throws IOException, FileNotFoundException {
		Reader reader	= null;
		try {
			reader = new InputStreamReader(new FileInputStream(sourceFile), "UTF-8");

			//	Create CSV bean reader
			CsvToBean<T> csvToBean = new CsvToBeanBuilder<T>(reader).withType(listObjectClass).withIgnoreLeadingWhiteSpace(true).build();

			//	Convert to list
			return csvToBean.parse();
		}
		finally {
			if (reader != null)
				reader.close();
		}
	}	// extract()

	/**	Set class instance of the list of object T into {@link #listObjectClass}.	**/
	public void setListObjectClass(Class<T> listObjectClass) {
		this.listObjectClass = listObjectClass;
	}
}	// class CsvExtractor
