package com.appointment.booking.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

import javax.persistence.Temporal;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.format.annotation.DateTimeFormat;

import com.appointment.booking.exception.ValidDateException;


public class DateValidator implements ConstraintValidator<ValidDate, String>
{
    
	@Override
	public void initialize(ValidDate  constraintAnnotation)
	{
		ConstraintValidator.super.initialize(constraintAnnotation);
	}
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate date = LocalDate.parse(value, formatter);
			return true;
		}
		catch(Exception e)
		{
			throw new ValidDateException("Date Not Valid");
		}
	}
	
}
