package com.mt99.service.export;

import java.util.List;

/**
 *	<p>Interface for exporting a list to destination.</p>
 *
 *	<p>Exporter could be {@link JsonDocumentExtractor JSON Document}, CSV, Excel, and Text, etc.
 *	Could further extended for API call and DB INSERT.</p>
 **/
public interface Exportable<T> {
	/**	Export the given list to destination.	**/
	public boolean export(List<T> list);
}	// interface Exportable