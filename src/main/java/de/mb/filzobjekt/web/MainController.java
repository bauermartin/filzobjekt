package de.mb.filzobjekt.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Servlet implementation class Master
 */
@Controller
public class MainController {

	private String currentPage = "";

	@RequestMapping("/")
	private String index() {
		return "index";
	}

	@RequestMapping(value = "/test")
	private ResponseEntity<String> test() {
		return new ResponseEntity<>("test", HttpStatus.OK);
	}

	@RequestMapping(value = "/home")
	private String home() {
		currentPage = "home";
		return "index";
	}
	@RequestMapping(value = "/shoes")
	private String shoes() {
		currentPage = "shoes";
		return "index";
	}

	@ModelAttribute("ishome")
	private boolean ishome() {
		return "home".equals(currentPage);
	}
	@ModelAttribute("isshoes")
	private boolean isshoes() {
		return "shoes".equals(currentPage);
	}
}
