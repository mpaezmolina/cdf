package com.cdf.web.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

	@RequestMapping(value = "loginAction", method = RequestMethod.GET)
	public ModelAndView login_GET(Locale locale, HttpServletRequest request,
			@CookieValue("exampleCookie") String cookie) {

		logger.info("Welcome home! The client locale is {}.", locale);
		logger.info("Email Server port is " + emailServerPort);
		logger.info("Cookie: " + cookie);

		ModelAndView mav = new ModelAndView();

		int userId = 1;
		Username username = userService.loadUserByUsername(userId);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);

		mav.setViewName("login");
		mav.addObject("serverTime", formattedDate);
		mav.addObject("username", username);
		mav.addObject("loginForm", new LoginForm());

		HttpSession session = request.getSession(true);
		session.setAttribute("sessionUsername", username);

		return mav;
	}

	@RequestMapping(value = "loginAction", method = RequestMethod.POST)
	public ModelAndView login_POST(@Valid LoginForm form, BindingResult errors) {
		ModelAndView mav = new ModelAndView();

		// loginFormValidator.validate(form, errors);
		System.out.println("Username is " + form.getUsername());
		System.out.println("Password is " + form.getPassword());
		
		if (errors.hasErrors()) {
			// Handle errors.
			mav.setViewName("login");
		} else {
			mav.setViewName("redirect:/profileGet");
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
		username2.setEmail("johndoe@gmail.com");
		username2.setFavours(null);
		username2.setUsername("jd");
		username2.setFirstname("john");
		username2.setLastname("doe");

		List<Username> list = new ArrayList<Username>();
		list.add(username);
		list.add(username2);

		return list;
	}

	@RequestMapping(value = "/users/{userName}", method = RequestMethod.GET)
	public String findUser(@PathVariable String userName, Model model) {
		System.out.println("PathVariable= " + userName);
		return "end";
	}

	@RequestMapping(value = "/reqParam", method = RequestMethod.GET)
	public String requestParamExample(@RequestParam("petId") int petId,
			ModelMap model) {
		System.out.println(petId);
		return "end"; 
	}

	@RequestMapping(value = "testString", method = RequestMethod.GET)
	@ResponseBody
	public String testString(HttpServletResponse response) {
		return "{\"Students\": [{\"Name\": \"John\",\"Grade\": \"17\"}],\"TotalClass\": \"17\",\"TotalCount\": \"1\"}";
	}

	@RequestMapping("/addCookie")
	private ModelAndView exampleHandler(HttpServletResponse response) {
		response.addCookie(new Cookie("exampleCookie", "The cookie's value"));
		return new ModelAndView("redirect:/loginForm");
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
