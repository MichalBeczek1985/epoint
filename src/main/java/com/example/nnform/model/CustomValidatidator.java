package com.example.nnform.model;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomValidatidator implements 
ConstraintValidator<RequestAnnotation, ContactForm> {

@Override
public void initialize(RequestAnnotation constraintAnnotation) {

}


@Override
public boolean isValid(ContactForm value, ConstraintValidatorContext context) {
	if (value.getMail().isEmpty() && value.getPhone().isEmpty()) {
		context.buildConstraintViolationWithTemplate( "Jedno z tych pol musi byc wypelnione" )
        .addPropertyNode("mail")
        .addConstraintViolation();
		context.buildConstraintViolationWithTemplate( "Jedno z tych pol musi byc wypelnione" )
        .addPropertyNode("phone")
        .addConstraintViolation();
		return false;}
	return true;
}


}
