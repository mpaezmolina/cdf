package com.cdf.web.form.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.cdf.web.form.LoginForm;

@Component
public class LoginFormValidator extends GlobalValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return LoginForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		LoginForm form = (LoginForm) target;

		validateUsername("username", form.getUsername(), errors);
		validatePassword("password", form.getPassword(), errors);

	}

}
