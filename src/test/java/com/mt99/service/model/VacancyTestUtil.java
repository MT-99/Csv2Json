package com.mt99.service.model;

import static org.junit.Assert.assertEquals;

public class VacancyTestUtil {
	/**	Validate the processed results and expected values.
	 *	@param	index		Index of the list
	 *	@param	aVacancy	Vacancy object processed
	 *	@param	creator		Expected value of "creator"
	 *	@param	rest		Expected value of "break"
	 *	@param	description	Expected value of "description"
	 *	@param	start		Expected value of "start"
	 *	@param	end			Expected value of "end"
	 *	@param	shiftType	Expected value of "shiftType"	**/
	public static void validate(int index, Vacancy aVacancy, String creator, int rest, String description, 
			String start, String end, String shiftType) {
		assertEquals("Row #" +index + " Col creator", creator, aVacancy.getCreator());
		assertEquals("Row #" +index + " Col break", rest, aVacancy.getRest());
		assertEquals("Row #" +index + " Col description", description, aVacancy.getDescription());
		assertEquals("Row #" +index + " Col start", start, aVacancy.getStart());
		assertEquals("Row #" +index + " Col end", end, aVacancy.getEnd());
		assertEquals("Row #" +index + " Col shiftType", shiftType, aVacancy.getShiftType());
	}	// validate()
}	// class VacancyTestUtil