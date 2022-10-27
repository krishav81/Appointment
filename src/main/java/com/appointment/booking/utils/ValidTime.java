package com.appointment.booking.utils;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TimeValidator.class)
@Documented
public @interface ValidTime {
  String message() default "Time Format Not Valid";
  Class <?> [] groups() default {};
  Class <? extends Payload> [] payload() default {};
}