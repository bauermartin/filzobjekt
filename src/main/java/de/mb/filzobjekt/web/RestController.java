package de.mb.filzobjekt.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import de.mb.filzobjekt.bean.TextElement;
import de.mb.filzobjekt.business.IAuthorizationService;
import de.mb.filzobjekt.business.ITextService;

@Controller
@RequestMapping("/rest")
public class RestController {

	@Autowired private ITextService text_service;
	@Autowired private IAuthorizationService auth_service;

	@RequestMapping(value = "/login", method = RequestMethod.PUT)
	private static ResponseEntity<HttpStatus> login(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("Login");
		return new ResponseEntity<HttpStatus>(HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/text")
	private ResponseEntity<HttpStatus> saveText(@RequestBody TextElement elem) {
		System.out.println(text_service.saveText(elem));
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
