package de.mb.filzobjekt.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import de.mb.filzobject.repository.IRepositoryService;

/**
 * Servlet implementation class Master
 */
@Controller
public class ViewController {

	@RequestMapping(value = "/handbag")
	private static ModelAndView handbag() {
		final ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("template", "handbag");
		return mv;
	}

	@RequestMapping(value = "/home")
	private static ModelAndView home() {
		final ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("template", "home");
		return mv;
	}

	@RequestMapping("/")
	private static String index() {
		return "index";
	}

	@RequestMapping(value = "/object")
	private static ModelAndView object() {
		final ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("template", "object");
		return mv;
	}

	@RequestMapping(value = "/scarf")
	private static ModelAndView scarf() {
		final ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("template", "scarf");
		return mv;
	}

	@RequestMapping(value = "/seat_pat")
	private static ModelAndView seat_pat() {
		final ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("template", "seat_pat");
		return mv;
	}

	@RequestMapping(value = "/shoes")
	private static ModelAndView shoes() {
		final ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("template", "shoes");
		return mv;
	}
}
