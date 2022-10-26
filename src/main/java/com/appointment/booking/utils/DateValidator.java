package com.appointment.booking.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

import javax.persistence.Temporal;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.format.annotation.DateTimeFormat;


public class DateValidator implements ConstraintValidator<ValidDate, LocalDate>
{
	static DateTimeFormatter dateFormatter =
		      DateTimeFormatter.ofPattern("MM-dd-yyyy")
		          .withResolverStyle(ResolverStyle.STRICT);
	@Override
	public void initialize(ValidDate  constraintAnnotation)
	{
		ConstraintValidator.super.initialize(constraintAnnotation);
	}
	@Override
	public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
		try {
			value.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
}
