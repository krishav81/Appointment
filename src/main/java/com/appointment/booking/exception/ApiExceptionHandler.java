package com.appointment.booking.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.appointment.booking.model.ApiError;

@ControllerAdvice
public class ApiExceptionHandler {
	
   @ExceptionHandler(ToDateException.class)
   public ResponseEntity<?> handleToDateException(ToDateException exception, WebRequest request)
   {
	   ApiError apiError=new ApiError(new Date(),exception.getMessage(),request.getDescription(false));
	   return new ResponseEntity(apiError,HttpStatus.BAD_REQUEST);
   }
   
   @ExceptionHandler(GlobalException.class)
   public ResponseEntity<?> handleGlobalException(GlobalException exception, WebRequest request)
   {
	   ApiError apiError=new ApiError(new Date(),exception.getMessage(),request.getDescription(false));
	   return new ResponseEntity(apiError,HttpStatus.INTERNAL_SERVER_ERROR);
   }
   
   @ExceptionHandler(ValidDateException.class)
   public ResponseEntity<?> handleGlobalException(ValidDateException exception, WebRequest request)
   {
	   ApiError apiError=new ApiError(new Date(),exception.getMessage(),request.getDescription(false));
	   return new ResponseEntity(apiError,HttpStatus.BAD_REQUEST);
   }

}