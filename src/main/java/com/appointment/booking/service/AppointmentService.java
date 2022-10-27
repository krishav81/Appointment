package com.appointment.booking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.appointment.booking.model.Appointment;
import com.appointment.booking.model.DateRange;

@Service
public interface AppointmentService {

	Optional<Appointment> findById(int Id);

	List<Appointment> findAll();

	List<Appointment> findByDateRange(DateRange dateRange);

	Appointment create(Appointment appointment);

	Appointment update(Appointment appointment);

	String deleteById(int Id);

}