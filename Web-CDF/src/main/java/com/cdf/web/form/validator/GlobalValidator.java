package com.cdf.web.form.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

public class GlobalValidator {

	protected void validateUsername(String property, String username,
			Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, property, "error.form.username.empty");
	}

	protected void validatePassword(String property, String password,
			Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, property, "error.form.password.empty");
	}

}
