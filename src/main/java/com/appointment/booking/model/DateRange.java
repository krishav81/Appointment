package com.appointment.booking.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import com.appointment.booking.utils.ValidDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DateRange {
	@NotNull(message = "Start Date Cannot be null")
	@ValidDate
	private String startDate;
	@NotNull(message = "End Date Cannot be null")
	@ValidDate
    private String endDate;
	public String getStartDate() {
		return startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
    
}
