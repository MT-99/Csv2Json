package com.mt99.service.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.opencsv.bean.CsvBindByName;

/**
 *	Bean object of a vacancy.
 **/
public class Vacancy {
	/**	Creator unique id. (e.g. ea2da28f-9dae-430c-be68-9c35f06e0ff1)	**/
	@CsvBindByName
	private String creator;

	/**	Break in minute.	**/
	@CsvBindByName(column = "break")
	private int rest;

	/**	Description of the vacancy.	**/
	@CsvBindByName
	private String description;
	
	/**	Start date time.	**/
	@CsvBindByName
	private String start;

	/**	End date time.	**/
	@CsvBindByName
	private String end;
	
	/**	Shift type. If this is missing, would not include in the JSON output.	**/
	@CsvBindByName
	private String shiftType;

	/**	Construct a default instance of vacancy.	**/
	public Vacancy() {
		//	Do nothing
	}	// Vacancy()

	/**	Construct an instance of vacancy with specific values.	**/
	public Vacancy(String creator, int rest, String description, String start, String end, String shiftType) {
		this.creator = creator;
		this.rest = rest;
		this.description = description;
		this.start = start;
		this.end = end;
		this.shiftType = shiftType;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	@JsonGetter("break")
	public int getRest() {
		return rest;
	}

	public void setRest(int rest) {
		this.rest = rest;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getShiftType() {
		return shiftType;
	}

	public void setShiftType(String shiftType) {
		this.shiftType = shiftType;
	}

	public boolean equals(Vacancy vacancy) {
		if ((this.creator == null && vacancy.getCreator() != null) ||
			(this.creator != null && vacancy.getCreator() == null))
			return false;
		if (this.creator != null && vacancy.getCreator() != null && !this.creator.equals(vacancy.getCreator()))
			return false;

		if (this.rest != vacancy.getRest())
			return false;

		if ((this.description == null && vacancy.getDescription() != null) ||
			(this.description != null && vacancy.getDescription() == null))
			return false;
		if (this.description != null && vacancy.getDescription() != null && !this.description.equals(vacancy.getDescription()))
			return false;

		if ((this.start == null && vacancy.getStart() != null) ||
			(this.start != null && vacancy.getStart() == null))
			return false;
		if (this.start != null && vacancy.getStart() != null && !this.start.equals(vacancy.getStart()))
			return false;

		if ((this.end == null && vacancy.getEnd() != null) ||
			(this.end != null && vacancy.getEnd() == null))
			return false;
		if (this.end != null && vacancy.getEnd() != null && !this.end.equals(vacancy.getEnd()))
			return false;

		if ((this.shiftType == null && vacancy.getShiftType() != null) ||
			(this.shiftType != null && vacancy.getShiftType() == null))
			return false;
		if (this.shiftType != null && vacancy.getShiftType() != null && !this.shiftType.equals(vacancy.getShiftType()))
			return false;
		
		return true;
	}
}	// class Vacancy
