package com.cdf.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfileController {

	private static final Logger logger = LoggerFactory
			.getLogger(ProfileController.class);

	@RequestMapping(value = "/profileGet", method = RequestMethod.GET)
	public ModelAndView profile_GET(Locale locale, Model model) {
		ModelAndView mav = new ModelAndView();

		logger.info("In profile_GET");
		
		List<String> aList = new ArrayList<String>();
		aList.add("a");
		aList.add("b");
		aList.add("c");

		mav.setViewName("profile");
		mav.addObject("aList", aList);
		return mav;
	}

}
