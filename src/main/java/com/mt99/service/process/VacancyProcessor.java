package com.mt99.service.process;

import java.util.ArrayList;
import java.util.List;

import com.mt99.service.model.Vacancy;

/**
 *	Process the shift type of list of vacancy.
 *	Exclude from the list for missing values for the "shiftType".
 **/
public class VacancyProcessor implements Processable<Vacancy> {
	/**	Process the given list of vacancy.
	 *	@param	vacancies	List of vacancy to be processed.	**/
	public List<Vacancy> process(List<Vacancy> list) {
		if (list == null || list.size() == 0)
			return list;

		List<Vacancy> results	= new ArrayList<Vacancy>();
		for (Vacancy aElement: list) {
			//	Exclude missing "shiftType"
			if (aElement.getShiftType() != null && !aElement.getShiftType().trim().equals(""))
				results.add(aElement);
		}	// end of looping the given list

		return results;
	}	// process()
}	// class VacancyProcessor