package de.mb.filzobjekt.web;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import de.mb.filzobjekt.bean.ImageBundle;
import de.mb.filzobjekt.bean.ImageContainer;
import de.mb.filzobjekt.business.IImageService;
import de.mb.filzobjekt.business.ImageService;

/**
 * Servlet implementation class Master
 */
@Controller
public class ViewController {

	@Autowired
	private IImageService image_service;

	@RequestMapping(value = { "/handbag", "/handbag.html" })
	public ModelAndView handbag() throws IOException {
		final ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("template", "handbag");
		ImageContainer img_cont = image_service.getImages(ImageService.HANDBAG);
		ImageBundle handbag_bundle = img_cont.getBundleByID("handbags");
		mv.addObject("handbags", handbag_bundle.getImages());
		return mv;
	}

	@RequestMapping(value = { "/home", "/home.html" })
	public ModelAndView home() {
		final ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("template", "home");
		return mv;
	}

	@RequestMapping("/login")
	public ModelAndView login() {
		final ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}

	@RequestMapping(value = { "/", "/index", "/index.html" })
	public ModelAndView index() {
		final ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("template", "home");
		return mv;
	}

	@RequestMapping(value = { "/object", "/object.html" })
	public ModelAndView object() throws IOException {
		final ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("template", "object");
		ImageContainer img_cont = image_service.getImages(ImageService.OBJECT);
		ImageBundle handbag_bundle = img_cont.getBundleByID("objects");
		mv.addObject("objects", handbag_bundle.getImages());
		return mv;
	}

	@RequestMapping(value = { "/wall_hanging", "/wall_hanging.html" })
	public ModelAndView wall_hanging() throws IOException {
		final ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("template", "wall_hanging");
		ImageContainer img_cont = image_service.getImages(ImageService.WALL_HANGING);
		ImageBundle handbag_bundle = img_cont.getBundleByID("wall_hangings");
		mv.addObject("wall_hangings", handbag_bundle.getImages());
		return mv;
	}

	@RequestMapping(value = { "/seat_pad", "/seat_pad.html", "/sitzkissen" })
	public ModelAndView seat_pad() throws IOException {
		final ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("template", "seat_pad");
		ImageContainer img_cont = image_service.getImages(ImageService.SEAT_PAD);
		ImageBundle row = img_cont.getBundleByID("row1");
		mv.addObject("row1", row.getImages());
		row = img_cont.getBundleByID("row2");
		mv.addObject("row2", row.getImages());
		row = img_cont.getBundleByID("row3");
		mv.addObject("row3", row.getImages());
		return mv;
	}

	@RequestMapping(value = { "/shoes", "/shoes.html" })
	private ModelAndView shoes() throws IOException {
		final ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("template", "shoes");
		ImageContainer img_cont = image_service.getImages(ImageService.SHOES);
		ImageBundle shoes_table_bundle = img_cont.getBundleByID("shoes_table");
		mv.addObject("shoes_table", shoes_table_bundle.getImages());
		return mv;
	}

	@RequestMapping(value = { "/gabi", "/gabi.html" })
	public ModelAndView gabi() throws IOException {
		final ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("template", "gabi");
		ImageContainer img_cont = image_service.getImages(ImageService.GABI);
		if (img_cont != null) {
			ImageBundle profileBundle = img_cont.getBundleByID("profile");
			if (profileBundle != null) {
				mv.addObject("gabi", profileBundle.getImages()[0]);
			}
		}
		return mv;
	}

	@RequestMapping(value = { "/orders", "/orders.html" })
	public ModelAndView orders() {
		final ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("template", "orders");
		return mv;
	}

	@RequestMapping(value = { "/events", "/events.html" })
	public ModelAndView events() {
		final ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("template", "events");
		return mv;
	}

	@RequestMapping(value = { "/impressum", "/impressum.html" })
	public ModelAndView impressum() {
		final ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("template", "impressum");
		return mv;
	}
}
