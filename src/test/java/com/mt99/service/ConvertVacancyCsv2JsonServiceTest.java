package com.mt99.service;

import java.io.File;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mt99.service.model.Vacancy;

/**
 *	Unit tests on {@link ConvertVacancyCsv2JsonService}.
 **/
public class ConvertVacancyCsv2JsonServiceTest {
	/**
	 *	Test generated vacancy JSON document with entity missing shiftType excluded.
	 **/
	@Test
	public void testConvertVacancyShiftTypeExcluded() throws URISyntaxException {
		//	Test Data
		ConvertService<Vacancy> service	= new ConvertVacancyCsv2JsonService();
		File inputFile = new File(this.getClass().getClassLoader().getResource("testConvertService1.csv").toURI());
		service.setInputPath(inputFile.getAbsolutePath());
		File outputFile = new File(inputFile.getParent(), "testConvertService1.json");
		service.setOutputPath(outputFile.getAbsolutePath());
		service.init();

		//	Execute the test
		if (!service.execute()) {
			//	Unable to convert ==> Fail
			Assert.fail("Unable to cnovert");
			return;
		}

		//	Check the results
		try {
			ObjectMapper mapper	= new ObjectMapper();
			Vacancy[] outList	= mapper.readValue(outputFile, Vacancy[].class);
			Assert.assertEquals("size", 71, outList.length);

			for (int i=0; i<outList.length; i++) {
				Assert.assertTrue("Missing shiftType at row #" +i, (outList[i].getShiftType() != null && !outList[i].getShiftType().trim().equals("")));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Unable to read the JSON file");
		}
	}	// testConvertVacancyShiftTypeExcluded()


	/**
	 *	Test generated vacancy JSON document with unicode.
	 **/
	@Test
	public void testConvertVacancyWithUnicode() throws URISyntaxException {
		//	Test Data
		ConvertService<Vacancy> service	= new ConvertVacancyCsv2JsonService();
		File inputFile = new File(this.getClass().getClassLoader().getResource("testConvertWithUnicode.csv").toURI());
		service.setInputPath(inputFile.getAbsolutePath());
		File outputFile = new File(inputFile.getParent(), "testConvertWithUnicode.json");
		service.setOutputPath(outputFile.getAbsolutePath());
		service.init();

		//	Execute the test
		if (!service.execute()) {
			//	Unable to convert ==> Fail
			Assert.fail("Unable to cnovert");
			return;
		}

		//	Check the results
		try {
			ObjectMapper mapper	= new ObjectMapper();
			Vacancy[] outList	= mapper.readValue(outputFile, Vacancy[].class);
			Assert.assertEquals("size", 1, outList.length);

			Assert.assertEquals("Unicode", "\u3042\u308B\u5730\u57DF\u770B\u8B77\u5E2B\u306E\u6C42\u4EBA - \u5348\u524D\u4E2D\u52E4\u52D9 - W1 - 16:04", outList[0].getDescription());
		}
		catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Unable to read the JSON file");
		}
	}	// testConvertVacancy()

}	// class ConvertVacancyCsv2JsonServiceTest