package de.mb.filzobjekt.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	private static ModelAndView index() {
		final ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("template", "home");
		return mv;
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

	@RequestMapping(value = "/seat_pad")
	private static ModelAndView seat_pad() {
		final ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("template", "seat_pad");
		return mv;
	}

	@RequestMapping(value = "/shoes")
	private static ModelAndView shoes() {
		final ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("template", "shoes");
		return mv;
	}
	
	@RequestMapping(value = "/gabi")
	private static ModelAndView gabi() {
		final ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("template", "gabi");
		return mv;
	}
	
	@RequestMapping(value = "/orders")
	private static ModelAndView orders() {
		final ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("template", "orders");
		return mv;
	}
	
	@RequestMapping(value = "/markets")
	private static ModelAndView markets() {
		final ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("template", "markets");
		return mv;
	}
	
	@RequestMapping(value = "/impressum")
	private static ModelAndView impressum() {
		final ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("template", "impressum");
		return mv;
	}
}
