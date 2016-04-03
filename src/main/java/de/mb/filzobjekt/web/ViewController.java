package de.mb.filzobjekt.web;

import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import de.mb.filzobjekt.bean.Image;

/**
 * Servlet implementation class Master
 */
@Controller
public class ViewController {

	private boolean isAdmin;

	@RequestMapping(value = "/handbag")
	private static ModelAndView handbag(
			@CookieValue(value = "authorisation", defaultValue = "") String fooCookie) {
		System.out.println("Cookie: " + fooCookie);
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

	@RequestMapping("/login")
	private static ModelAndView login() {
		final ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
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

	@RequestMapping(value = "/wall_hanging")
	private static ModelAndView wall_hanging() {
		final ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("template", "wall_hanging");
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
		List<Image> images = new LinkedList<>();
		images.add(new Image(0, "image/schuhe mit punkten.jpg", "Schuhe mit punkten"));
		images.add(new Image(1, "image/Schuhe grau.jpg", "Schuhe grau"));
		mv.addObject(images);
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

	@RequestMapping(value = "/events")
	private static ModelAndView events() {
		final ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("template", "events");
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
