package com.example.epoint.model;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomValidatidator implements 
ConstraintValidator<RequestAnnotation, Products> {

@Override
public void initialize(RequestAnnotation constraintAnnotation) {

}


@Override
public boolean isValid(Products value, ConstraintValidatorContext context) {
		/*
		 * if (value.getMail().isEmpty() && value.getPhone().isEmpty()) {
		 * context.buildConstraintViolationWithTemplate(
		 * "Jedno z tych pol musi byc wypelnione" ) .addPropertyNode("mail")
		 * .addConstraintViolation(); context.buildConstraintViolationWithTemplate(
		 * "Jedno z tych pol musi byc wypelnione" ) .addPropertyNode("phone")
		 * .addConstraintViolation(); return false;}
		 */
	return true;
}


}
