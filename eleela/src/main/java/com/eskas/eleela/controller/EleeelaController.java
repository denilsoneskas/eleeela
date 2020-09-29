package com.eskas.eleela.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eskas.eleela.model.Post;
import com.eskas.eleela.service.EleeelaService;

@Controller
public class EleeelaController {
	
	@Autowired
	EleeelaService eleeelaService;
	
	@RequestMapping(value = "/posts", method = RequestMethod.GET)
	public ModelAndView getPosts() {
		ModelAndView mv = new ModelAndView("posts");
		List<Post> posts = eleeelaService.findAll();
		mv.addObject("posts", posts);
		return mv;		
	}
}
