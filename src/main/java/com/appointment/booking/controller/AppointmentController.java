package com.appointment.booking.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.appointment.booking.model.Appointment;
import com.appointment.booking.model.DateRange;
import com.appointment.booking.service.AppointmentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;
	
	org.jboss.logging.Logger logger = LoggerFactory.logger(AppointmentController.class);

	/** GET request to return specific appointments **/
	@Operation(summary="Get Appointment By Id")
	@RequestMapping(path = "/{Id}", method = RequestMethod.GET)
	public Optional<Appointment> findById(@PathVariable int Id) {
		logger.info("Calling findById Function");
		return appointmentService.findById(Id);
	}

	/** POST request to add new appointments **/
	@Operation(summary="Create New Appointments")
	@PostMapping("/create")
	@ApiResponses(value= {
			@ApiResponse(responseCode="200",description="OK",content= {@Content(mediaType="application/json",schema=@Schema(implementation=Appointment.class))}),
			@ApiResponse(responseCode="400",description="Error",content=@Content)
	})
	public ResponseEntity<Appointment> createAppointment(@Valid @RequestBody Appointment appointment) {
		logger.info("Calling Create Function");
		return ResponseEntity.ok().body(appointmentService.create(appointment));
	}

	/** GET request to return all appointments **/
	@Operation(summary="Get All Appointments")
	@GetMapping("/")
	public List<Appointment> getAll() {
		logger.info("Calling findAll Function");
		return appointmentService.findAll();
	}

	/** PUT request to edit new appointments **/
	@Operation(summary="Update Appointment")
	@PutMapping("/updateAppointment")
	public Appointment updateAppointment(@RequestBody Appointment appointment) {
		logger.info("Calling update Function");
		return appointmentService.update(appointment);
	}

	/** Delete request to delete new appointments **/
	@Operation(summary="Delete Appointment")
	@DeleteMapping("/{Id}")
	public ResponseEntity deleteAppointment(@PathVariable int Id) {
		logger.info("Calling deleteById Function");
		return ResponseEntity.ok().body(appointmentService.deleteById(Id));
	}

	/** Get request to get appointments in a date range **/
	@Operation(summary="Get Appointment in a Date Range")
	@PostMapping("/getRange")
	public List<Appointment> getRangeAppointment(@RequestBody DateRange dateRange) {
		logger.info("Calling findByDateRange Function");
		return appointmentService.findByDateRange(dateRange);
	}

}
