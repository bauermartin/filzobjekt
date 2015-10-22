package de.mb.filzobjekt.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Servlet implementation class Master
 */
@Controller
public class MainController {
	
	@RequestMapping(value="/test")
	private ResponseEntity<String> test() {
		return new ResponseEntity<>("test", HttpStatus.OK);
	}

}
