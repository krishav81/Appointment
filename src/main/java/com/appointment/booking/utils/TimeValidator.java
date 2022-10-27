package com.appointment.booking.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.appointment.booking.exception.ValidDateException;


public class TimeValidator implements ConstraintValidator<ValidTime, String>
{
    
	@Override
	public void initialize(ValidTime  constraintAnnotation)
	{
		ConstraintValidator.super.initialize(constraintAnnotation);
	}
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value==null)
		{
			throw new ValidDateException("Time Cannot be Null");
		}
		  String regex = "([01]?[0-9]|2[0-3]):[0-5][0-9]";
	        Pattern p = Pattern.compile(regex);
	        Matcher m = p.matcher(value);
	        if(m.matches())
	        {
	        	return true;
	        }
	        else
	        {
			throw new ValidDateException("Time Format Not Valid");
	        }
	}
	
}
