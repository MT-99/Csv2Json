package com.mt99.service.process;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.mt99.service.model.Vacancy;

/**
 *	Unit tests on processing shift type of a list of vacancy. 
 **/
public class VacancyShiftTypeProcessorTest {
	/**	The class to be tested.	**/
	private VacancyProcessor processor;

	@Before
	public void setUp() throws Exception {
		processor = new VacancyProcessor();
	}	// setUp()

	/**	Test if having shift type.	**/
	@Test
	public void testShiftType() {
		//	Test data
		List<Vacancy> vacancies	= new ArrayList<Vacancy>();
		vacancies.add(new Vacancy("creator0", 0, "description0", "start0", "end0", null));
		vacancies.add(new Vacancy("creator1", 15, "description1", "start1", "end1", "shiftType"));
		vacancies.add(new Vacancy("creator2", 30, "description2", "start2", "end2", ""));
		vacancies.add(new Vacancy("creator3", 45, "description3", "start3", "end3", "         "));

		//	Process
		List<Vacancy> results	= processor.process(vacancies);

		//	Check results
		assertEquals("Size", 1, results.size());
		Vacancy aVacancy	= results.get(0);
		assertEquals("Col creator", "creator1", aVacancy.getCreator());
		assertEquals("Col break", 15, aVacancy.getRest());
		assertEquals("Col description", "description1", aVacancy.getDescription());
		assertEquals("Col start", "start1", aVacancy.getStart());
		assertEquals("Col end", "end1", aVacancy.getEnd());
		assertEquals("Col shiftType", "shiftType", aVacancy.getShiftType());
	}	// testShiftType()
}	// class VacancyShiftTypeProcessorTest