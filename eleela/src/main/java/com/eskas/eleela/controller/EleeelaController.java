package com.eskas.eleela.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
	public ModelAndView getPostDetails(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("postDetails");
		Post post = eleeelaService.findById(id);
		mv.addObject("post", post);
		return mv;		
	}
	
	@RequestMapping(value = "/newpost", method = RequestMethod.GET)
	public String getPostForm() {
		return "postForm";
	}
	
	@RequestMapping(value = "/newpost", method = RequestMethod.POST)
	public String savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes) {
		System.out.println(result);
		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos!");
			return "redirect:/newpost";
		}
		post.setData(LocalDate.now());
		eleeelaService.save(post);
		return "redirect:/posts";
	}
	
	@GetMapping(path = "editpost/{id}")
	public String editPost(@PathVariable Long id, Model model) {
		Post post = eleeelaService.findById(id);
		model.addAttribute("post", post);
//		return "editPostForm";
		return "postForm";
	}
	
	@RequestMapping(value = "/editpost/{id}", method = RequestMethod.POST)
	public String editPostSave(@Valid Post post, BindingResult result, RedirectAttributes attributes) {
		System.out.println(result);
		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos!");
			return "redirect:/posts";
		}
		post.setData(LocalDate.now());
		eleeelaService.save(post);
		return "redirect:/posts";
	}
	
	@RequestMapping(value = "/deletepost/{id}", method = RequestMethod.GET)
	public String deletePost(@PathVariable Long id) {
		Post post = eleeelaService.findById(id);
		eleeelaService.delete(post);
		return "redirect:/posts";
	}
}

