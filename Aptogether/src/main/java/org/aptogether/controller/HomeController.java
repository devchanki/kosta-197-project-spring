package org.aptogether.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.aptogether.domain.JoinVO;
import org.aptogether.domain.MemberVO;
import org.aptogether.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	BCryptPasswordEncoder encoder;
	@Autowired
	MemberService memberService;

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
	@GetMapping("/tenant/a")
	public String test() {
		return "test";
	}
	@GetMapping("/admin/a")
	public String test1() {
		return "test";
	}
	@GetMapping("/signin")
	public String signin() {
		return "signin";
	}
	
	
	@GetMapping("/signup")
	public String signup() {
		return "signup";
	}
	
	@PostMapping(value = "/signup", produces="text/plain;charset=UTF-8")
	public String signUpPost(JoinVO member, RedirectAttributes rttr) {
		logger.info("sign up " + member);
		member.setPassword(encoder.encode(member.getPassword()));
		int result = memberService.joinService(member);
		System.out.println(member);
		if (result == -1) {
			rttr.addFlashAttribute("status", "값이 중복되었습니다.");
			return "redirect:signup";
		} else if (result == 0) {
			rttr.addFlashAttribute("status", "문제가 일어났습니다. 잠시후 시도해주세요.");
			return "redirect:signup";
		} else {
			rttr.addFlashAttribute("status", "성공적으로 회원가입 되었습니다 로그인 해주세요.");
			return "redirect:/signin";
		}
			
		
		
	}
	
	@GetMapping("/createApt")
	public String createApt() {
		return "createApt";
	}
	
		
	
}
