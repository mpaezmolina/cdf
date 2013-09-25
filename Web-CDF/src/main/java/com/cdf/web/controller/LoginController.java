package com.cdf.web.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cdf.dao.entity.Username;
import com.cdf.web.form.LoginForm;
import com.cdf.web.form.validator.LoginFormValidator;
import com.cdf.web.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@Autowired
	private LoginFormValidator loginFormValidator;

	private String emailServerPort;

	private static final Logger logger = LoggerFactory
			.getLogger(LoginController.class);

	@RequestMapping(value = "/loginForm", method = RequestMethod.GET)
	public ModelAndView login_GET(Locale locale) {
		logger.info("Welcome home! The client locale is {}.", locale);
		logger.info("Email Server port is " + emailServerPort);

		ModelAndView mav = new ModelAndView();

		Username username = userService.loadUserByUsername(31);
		mav.addObject("username", username);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		mav.setViewName("login");
		mav.addObject("serverTime", formattedDate);
		mav.addObject("username", username);

		return mav;
	}

	@RequestMapping(value = "loginForm", method = RequestMethod.POST)
	public ModelAndView login_POST(@Valid LoginForm form, BindingResult errors) {
		ModelAndView mav = new ModelAndView();

		loginFormValidator.validate(form, errors);

		mav.setViewName("redirect:/profileGet");
		System.out.println("Username is " + form.getUsername());

		if (errors.hasErrors()) {
			// Handle errors.
		}

		return mav;
	}

	@RequestMapping(value = "testJson", method = RequestMethod.GET)
	@ResponseBody
	public List<Username> testJson(HttpServletResponse response) {
		Username username = new Username();
		username.setEmail("paezmolina@gmail.com");
		username.setFavours(null);
		username.setUsername("omp");
		username.setFirstname("Matias");
		username.setLastname("Paez");

		Username username2 = new Username();
		username2.setEmail("sergiobanus@gmail.com");
		username2.setFavours(null);
		username2.setUsername("ban");
		username2.setFirstname("Sergio");
		username2.setLastname("Banus");
		
		List<Username> list = new ArrayList<Username>();
		list.add(username);
		list.add(username2);
		
		return list;
	}

	
	@RequestMapping(value = "testString", method = RequestMethod.GET)
	@ResponseBody
	public String testString(HttpServletResponse response) {
		return "{\"Students\": [{\"Name\": \"John\",\"Grade\": \"17\"}],\"TotalClass\": \"17\",\"TotalCount\": \"1\"}";
	}
	
	public void setLoginFormValidator(LoginFormValidator loginFormValidator) {
		this.loginFormValidator = loginFormValidator;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Value("${email.server.port}")
	public void setEmailServerPort(String emailServerPort) {
		this.emailServerPort = emailServerPort;
	}

}
