package de.mb.filzobjekt.web;

import java.io.IOException;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import de.mb.filzobjekt.bean.ImageBundle;
import de.mb.filzobjekt.bean.ImageContainer;
import de.mb.filzobjekt.business.IImageService;
import de.mb.filzobjekt.business.ImageService;
import de.mb.filzobjekt.repository.file_repository.ImageRepository;

/**
 * Servlet implementation class Master
 */
@Controller
public class ViewController {

	@Autowired private IImageService image_service;

	private boolean isAdmin;

	@RequestMapping(value = "/handbag")
	private ModelAndView handbag() throws IOException {
		final ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("template", "handbag");
		ImageContainer img_cont = image_service.getImages(ImageService.HANDBAG);
		ImageBundle handbag_bundle = img_cont.getBundleByID("handbags");
		mv.addObject("handbags", handbag_bundle.getAll());
		System.out.println(Arrays.toString(handbag_bundle.getAll()));
		return mv;
	}

	@RequestMapping(value = "/home")
	private ModelAndView home() {
		final ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("template", "home");
		return mv;
	}

	@RequestMapping("/login")
	private ModelAndView login() {
		final ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}

	@RequestMapping("/")
	private ModelAndView index() {
		final ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("template", "home");
		return mv;
	}

	@RequestMapping(value = "/object")
	private ModelAndView object() {
		final ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("template", "object");
		return mv;
	}

	@RequestMapping(value = "/wall_hanging")
	private ModelAndView wall_hanging() {
		final ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("template", "wall_hanging");
		return mv;
	}

	@RequestMapping(value = "/seat_pad")
	private ModelAndView seat_pad() {
		final ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("template", "seat_pad");
		return mv;
	}

	@RequestMapping(value = "/shoes")
	private ModelAndView shoes() throws IOException {
		final ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("template", "shoes");
		ImageContainer img_cont = image_service.getImages(ImageService.SHOES);
		ImageBundle shoes_table_bundle = img_cont.getBundleByID("shoes_table");
		mv.addObject("shoes_table", shoes_table_bundle.getAll());
		return mv;
	}

	@RequestMapping(value = "/gabi")
	private ModelAndView gabi() {
		final ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("template", "gabi");
		return mv;
	}

	@RequestMapping(value = "/orders")
	private ModelAndView orders() {
		final ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("template", "orders");
		return mv;
	}

	@RequestMapping(value = "/events")
	private ModelAndView events() {
		final ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("template", "events");
		return mv;
	}

	@RequestMapping(value = "/impressum")
	private ModelAndView impressum() {
		final ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("template", "impressum");
		return mv;
	}
}
