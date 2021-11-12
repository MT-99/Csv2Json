package com.mt99.service.extract;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.mt99.service.model.Vacancy;
import com.mt99.service.model.VacancyTestUtil;

/**
 *	Unit tests on {@link CsvExtractor}.
 **/
public class CsvExtractorTest {
	/**	The class to be tested.	**/
	private CsvExtractor<Vacancy> extractor;

	@Before
	public void setUp() throws Exception {
		extractor = new CsvExtractor<Vacancy>();
		extractor.setListObjectClass(Vacancy.class);
	}	// setUp()

	/**
	 *	Test to load "testExtractor1.csv".
	 **/
	@Test
	public void testLoadCsv() throws IOException, URISyntaxException {
		//	Test Data
		List<Vacancy> vacancies = extractor.extract(new File(this.getClass().getClassLoader().getResource("testExtractor1.csv").toURI()));

		//	Check Results
		int i = 0;
		Vacancy aVacancy = vacancies.get(i);
		VacancyTestUtil.validate(i, aVacancy, "ea2da28f-9dae-430c-be68-9c35f06e0ff1", 60, "Community Nurse Required - Early - W1 - 16:04", 
				"2018-03-20T07:00:00.000Z", "2018-03-20T15:30:00.000Z", "early");

		i++;
		aVacancy = vacancies.get(i);
		VacancyTestUtil.validate(i, aVacancy, "b20dc8fc-2db6-4469-8608-a5413357822e", 30, "CCU Nurse Required", 
				"2018-03-20T12:58:36.000Z", "2018-03-20T13:58:36.000Z", "");

		i++;
		aVacancy = vacancies.get(i);
		VacancyTestUtil.validate(i, aVacancy, "ea2da28f-9dae-430c-be68-9c35f06e0ff1", 60, "NEW - Nurse Required - Night - W2 - 15:46",
				"2018-03-21T19:00:00.000Z", "2018-03-22T08:30:00.000Z", "night");

		i++;
		aVacancy = vacancies.get(i);
		VacancyTestUtil.validate(i, aVacancy, "ea2da28f-9dae-430c-be68-9c35f06e0ff1", 60, "Community Nurse Required, Urgent - Early - W1 - 10:57",
				"2018-03-21T07:00:00.000Z", "2018-03-21T15:30:00.000Z", "early");
	}	// testLoadCsv()


	/**
	 *	Test to load "testExtractor2.csv" with unicode.
	 **/
	@Test
	public void testLoadCsvWithUnicode() throws IOException, URISyntaxException {
		//	Test Data
		List<Vacancy> vacancies = extractor.extract(new File(this.getClass().getClassLoader().getResource("testExtractor2WithUnicode.csv").toURI()));

		//	Check Results
		int i = 0;
		Vacancy aVacancy = vacancies.get(i);
		VacancyTestUtil.validate(i, aVacancy, "ea2da28f-9dae-430c-be68-9c35f06e0ff1", 60, "\u3042\u308B\u5730\u57DF\u770B\u8B77\u5E2B\u306E\u6C42\u4EBA - \u5348\u524D\u4E2D\u52E4\u52D9 - W1 - 16:04", 
				"2018-03-20T07:00:00.000Z", "2018-03-20T15:30:00.000Z", "early");
	}	// testLoadCsvWithUnicode()


	/**
	 *	Test to load a file not exist.
	 **/
	@Test
	public void testLoadCsvNotExist() {
		try {
			//	Test Data
			List<Vacancy> vacancies = extractor.extract(new File("file-not-exist.xyz"));
			Assert.fail("Missing to throw FileNotFoundException");
		}
		catch (FileNotFoundException e) {
			//	Do nothing
		}
		catch (Exception e) {
			//	Other exceptions caught instead of FileNotFoundException
			e.printStackTrace();
			Assert.fail("Missing to throw FileNotFoundException");
		}
	}	// testLoadCsvNotExist()
}	// class CsvExtractorTest