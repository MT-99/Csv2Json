package com.mt99.service.export;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *	Export the given list to a JSON string.
 **/
public class JsonExporter<T> implements Exportable<T> {
	/**	JSON string exported.	**/
	private String jsonString;

	/**	Export the given list to JSON string.
	 *	@return	Whether export successfully.	**/
	public boolean export(List<T> list) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			writeValue(objectMapper, list);
		}
		catch (Exception e) {
			return false;
		}

		return true;
	}	// export()

	/**	Compose JSON value.	**/
	protected void writeValue(ObjectMapper objectMapper, List<T> list) throws Exception {
		jsonString	= objectMapper.writeValueAsString(list);		
	}	// writeValue()

	/**	Get {@link #jsonString}.	**/
	public String getJsonString() {
		return jsonString;
	}
}	// class JsonExporter