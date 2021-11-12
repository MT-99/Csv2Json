package com.mt99.service.export;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.mt99.service.model.Vacancy;
import com.mt99.service.model.VacancyTestUtil;

/**
 *	Unit tests on {@link JsonExporter}.
 **/
public class JsonExporterTest {
	/**	The class to be tested.	**/
	private JsonExporter<Vacancy> exporter;

	@Before
	public void setUp() throws Exception {
		exporter = new JsonExporter<Vacancy>();
	}	// setUp()

	/**
	 *	Test generating vacancy JSON string.
	 **/
	@Test
	public void testVacancyJsonString() throws JsonMappingException, JsonProcessingException {
		//	Test data
		List<Vacancy> vacancies	= new ArrayList<Vacancy>();
		vacancies.add(new Vacancy("ea2da28f-9dae-430c-be68-9c35f06e0ff1", 60, "Community Nurse Required - Early - W1 - 16:04", "2018-03-20T07:00:00.000Z" ,"2018-03-20T15:30:00.000Z", "early"));
		vacancies.add(new Vacancy("ea2da28f-9dae-430c-be68-9c35f06e0ff1", 60, "Community Nurse Required, Urgent - Early - W1 - 10:57", "2018-03-21T07:00:00.000Z", "2018-03-21T15:30:00.000Z", "early"));
		vacancies.add(new Vacancy("ea2da28f-9dae-430c-be68-9c35f06e0ff1", 99, "NOV TEST", "2018-11-22T06:00:00.000Z", "2018-11-22T21:00:00.000Z", "long day"));

		//	Execute
		exporter.export(vacancies);

		//	Check results
		System.out.println(exporter.getJsonString());

		ObjectMapper objectMapper	= new ObjectMapper();
		List<Vacancy> parsedList	= objectMapper.readValue(exporter.getJsonString(), List.class);
		int i = 0;
		Vacancy aVacancy = vacancies.get(i);
		VacancyTestUtil.validate(i, aVacancy, "ea2da28f-9dae-430c-be68-9c35f06e0ff1", 60, "Community Nurse Required - Early - W1 - 16:04", 
				"2018-03-20T07:00:00.000Z", "2018-03-20T15:30:00.000Z", "early");

		i++;
		aVacancy = vacancies.get(i);
		VacancyTestUtil.validate(i, aVacancy, "ea2da28f-9dae-430c-be68-9c35f06e0ff1", 60, "Community Nurse Required, Urgent - Early - W1 - 10:57", 
				"2018-03-21T07:00:00.000Z", "2018-03-21T15:30:00.000Z", "early");

		i++;
		aVacancy = vacancies.get(i);
		VacancyTestUtil.validate(i, aVacancy, "ea2da28f-9dae-430c-be68-9c35f06e0ff1", 99, "NOV TEST", 
				"2018-11-22T06:00:00.000Z", "2018-11-22T21:00:00.000Z", "long day");
	}	// testVacancyJsonString()

	/**
	 *	Test generating vacancy JSON string with unicode.
	 **/
	@Test
	public void testVacancyJsonStringWithUnicode() throws JsonMappingException, JsonProcessingException {
		//	Test data
		List<Vacancy> vacancies	= new ArrayList<Vacancy>();
		vacancies.add(new Vacancy("ea2da28f-9dae-430c-be68-9c35f06e0ff1", 60, "\u3042\u308B\u5730\u57DF\u770B\u8B77\u5E2B\u306E\u6C42\u4EBA - \u5348\u524D\u4E2D\u52E4\u52D9 - W1 - 16:04", "2018-03-20T07:00:00.000Z" ,"2018-03-20T15:30:00.000Z", "early"));

		//	Execute
		exporter.export(vacancies);

		//	Check results
		System.out.println(exporter.getJsonString());

		ObjectMapper objectMapper	= new ObjectMapper();
		List<Vacancy> parsedList	= objectMapper.readValue(exporter.getJsonString(), List.class);
		int i = 0;
		Vacancy aVacancy = vacancies.get(i);
		VacancyTestUtil.validate(i, aVacancy, "ea2da28f-9dae-430c-be68-9c35f06e0ff1", 60, "\u3042\u308B\u5730\u57DF\u770B\u8B77\u5E2B\u306E\u6C42\u4EBA - \u5348\u524D\u4E2D\u52E4\u52D9 - W1 - 16:04", 
				"2018-03-20T07:00:00.000Z", "2018-03-20T15:30:00.000Z", "early");
	}
}	// class JsonExporterTest