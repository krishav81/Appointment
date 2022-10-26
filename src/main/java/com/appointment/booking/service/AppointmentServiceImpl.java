package com.appointment.booking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appointment.booking.dao.AppointmentRepository;
import com.appointment.booking.exception.AppException;
import com.appointment.booking.exception.ErrorCodes;
import com.appointment.booking.model.Appointment;
import com.appointment.booking.model.DateRange;

@Component("appointmentService")
public class AppointmentServiceImpl implements AppointmentService {

	org.jboss.logging.Logger logger = LoggerFactory.logger(AppointmentServiceImpl.class);
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Override
	public Optional<Appointment> findById(int Id) {
		logger.info("Inside find By Id Method Requested Id is " +Id);
		Optional<Appointment> apoint;
		try {
			apoint=appointmentRepository.findById(Id);
		}
		catch(Exception e)
		{
			logger.error("Find By Id method Failed");
		}
		 return appointmentRepository.findById(Id);
	}

	@Override
	public List<Appointment> findAll() {
		logger.info("Inside Find All Appointments");
		List<Appointment> appointMent=new ArrayList();
		try
		{
			appointMent=appointmentRepository.findAll();
		}
		catch(Exception e){
			logger.error("Create Appointment Failed. ");
			throw new AppException(ErrorCodes.INTERNAL_ERROR);	
		}
		return appointMent;
	}

	@Override
	public List<Appointment> findByDateRange(DateRange dateRange) {
		logger.info("Inside Find By Date Range Method Date Requested From : " +dateRange.getStartDate()+" to : "+dateRange.getEndDate());
		return appointmentRepository.findAllByAppointmentDateBetween(dateRange.getStartDate(), dateRange.getEndDate());
	}

	@Override
	public Appointment create(Appointment appointment) {
		logger.info("Inside Create Appointment Method ");
		try {
			appointmentRepository.save(appointment);
		}
		catch(Exception e)
		{
			logger.error("Create Appointment Failed. ");
		}
		
		return appointment;
	}

	@Override
	public Appointment update(Appointment appointment) {
		logger.info("Inside Update Appointment Method");
		try {
		appointmentRepository.save(appointment);
		}
		catch(Exception e){
			logger.error("Update Appointment Failed. ");
		}
		return appointment;
	}

	@Override
	public String deleteById(int Id) {
		logger.info("Inside Delete Appointment Method");
		try {
		appointmentRepository.deleteById(Id);
		}
		catch(Exception e){
			logger.error("Delete Appointment Failed. ");
		}
		return "Deleted Successfully";
	}

}
