package com.appointment.booking.model;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.appointment.booking.utils.ValidDate;
import com.appointment.booking.utils.ValidTime;
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
	private String appointmentDate;
	@ValidTime
    private String appointmentTime;
	@ValidTime
    private String duration;
    @NotNull(message = "Description Cannot be null")
	@Size(min=2,message = "Description too Short")
    @Size(max=50,message = "Description too Long")
	private String description;
	public int getId() {
		return id;
	}
	public String getAppointmentDate() {
		return appointmentDate;
	}
	public String getAppointmentTime() {
		return appointmentTime;
	}
	public String getDuration() {
		return duration;
	}
	public String getDescription() {
		return description;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
