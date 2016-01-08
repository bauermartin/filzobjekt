package de.mb.filzobjekt.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import de.mb.filzobjekt.bean.TextElement;
import de.mb.filzobjekt.business.ITextService;

@Controller
@RequestMapping("/rest")
public class RestController {

	@Autowired private ITextService text_service;

	@RequestMapping(value = "/test")
	private ResponseEntity<String> test() {
		return new ResponseEntity<>("test", HttpStatus.OK);
	}

	@RequestMapping(value = "/text")
	private ResponseEntity<HttpStatus> saveText(@RequestBody TextElement elem) {
		System.out.println(text_service.saveText(elem));
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
