package com.mt99.service.extract;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 *	<p>Interface for extracting a file to a list of object T.</p>
 *
 *	<p>File extraction could be {@link CsvExtractor CSV}, Excel, and Text, etc.
 *	Could further extended for API call and DB SELECT.</p>
 **/
public interface Extractable<T> {
	/**	Extract the given source file to a list of object T.
	 *	@param	sourceFile		source file to be extracted.
	 *	@return	a list of object T extracted from the source file.	**/
	public List<T> extract(File sourceFile) throws IOException, FileNotFoundException;
}	// interface Extractable