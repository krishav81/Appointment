package com.appointment.booking.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.appointment.booking.exception.AppException;
import com.appointment.booking.exception.ErrorCodes;
import com.appointment.booking.utils.ValidDate;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
	@Id
	@GeneratedValue
	private int id;
	@NotNull(message = "Appointment Date Cannot be null")
	@ValidDate
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate appointmentDate;
	@NotNull(message = "Appointment Time Cannot be null")
	@JsonFormat(pattern = "HH:mm:ss")
    private LocalTime appointmentTime;
	@NotNull(message = "Duration Cannot be null")
    @JsonFormat(pattern = "HH:mm")
    private LocalTime duration;
    @NotNull(message = "Description Cannot be null")
	@Size(min=2,message = "Description too Short")
    @Size(max=50,message = "Description too Long")
	private String description;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public LocalTime getAppointmentTime() {
		return appointmentTime;
	}
	public void setAppointmentTime(LocalTime appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
	public LocalTime getDuration() {
		return duration;
	}
	public void setDuration(LocalTime duration) {
		this.duration = duration;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		if(description==null)
		throw new AppException(ErrorCodes.INTERNAL_ERROR);	
		this.description = description;
	}
	
}
