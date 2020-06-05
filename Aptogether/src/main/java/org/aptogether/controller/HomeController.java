package org.aptogether.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.aptogether.domain.MemberVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
//	@Autowired
//	BCryptPasswordEncoder encoder;
//	

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "index";
	}
	
	@GetMapping("/signin")
	public String signin() {
		return "signin";
	}
	
	
	@GetMapping("/signup")
	public String signup() {
		return "signup";
	}
	
//	@PostMapping("/signup")
//	public String signUpPost(MemberVO member) {
//		
//		logger.info("sign up " + member);
//		int result = 
//	}
	
	@GetMapping("/createApt")
	public String createApt() {
		return "createApt";
	}
	
		
	
}
