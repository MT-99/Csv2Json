package com.mt99.service.export;

import java.io.File;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *	Export the given list to a JSON document.
 **/
public class JsonDocumentExporter<T> extends JsonExporter<T> {
	/**	Destination location to be exported.	**/
	private File destinationFile;
	
	/**	Compose JSON value.	**/
	@Override
	protected void writeValue(ObjectMapper objectMapper, List<T> list) throws Exception {
		objectMapper.writeValue(destinationFile, list);
	}	// writeValue()

	/**	Set destination into {@link #destinationFile}.	**/
	public void setDestinationFile(File destinationFile) {
		this.destinationFile = destinationFile;
	}
}	// class JsonDocumentExporter
