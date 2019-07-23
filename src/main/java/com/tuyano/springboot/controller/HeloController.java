package com.tuyano.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.Optional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import javax.annotation.PostConstruct;

import com.tuyano.springboot.data.MyData;
import com.tuyano.springboot.repositories.MyDataRepository;
 

@Controller
public class HeloController {
	
	@Autowired
	MyDataRepository repository;

	/*@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView index(
			@ModelAttribute("formModel") MyData mydata, 
			ModelAndView mav) {
		mav.setViewName("create");
		mav.addObject("msg","this is sample content.");
		Iterable<MyData> list = repository.findAll();
		mav.addObject("datalist",list);
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@Transactional(readOnly=false)
	public ModelAndView form(
			@ModelAttribute("formModel") MyData mydata, 
			ModelAndView mav) {
		repository.saveAndFlush(mydata);
		return new ModelAndView("redirect:/");
	}*/
	

	@RequestMapping(value = {"/home", "/"}, method = RequestMethod.GET)
	public ModelAndView view(
			@ModelAttribute("formModel") MyData mydata, 
			ModelAndView mav) {
		mav.setViewName("home");
		mav.addObject("msg","this is sample content.");
		Iterable<MyData> list = repository.findAll();
		mav.addObject("datalist",list);		
		return mav;
	}

	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public ModelAndView view_id(@ModelAttribute MyData mydata, 
			@PathVariable int id,ModelAndView mav) {
		mav.setViewName("view");
	mav.addObject("title","edit mydata.");
		Optional<MyData> data = repository.findById((long)id);
		Iterable<MyData> list = repository.findAll();
		mav.addObject("formModel",data.get());
		mav.addObject("datalist",list);	
		return mav;
	}

	
	/*@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView edit(@ModelAttribute MyData mydata, 
			@PathVariable int id,ModelAndView mav) {
		mav.setViewName("edit");
		mav.addObject("title","edit mydata.");
		Optional<MyData> data = repository.findById((long)id);
		mav.addObject("formModel",data.get());
		return mav;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@Transactional(readOnly=false)
	public ModelAndView update(@ModelAttribute MyData mydata, 
			ModelAndView mav) {
		repository.saveAndFlush(mydata);
		return new ModelAndView("redirect:/");
	}

@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
public ModelAndView delete(@PathVariable int id,
		ModelAndView mav) {
	mav.setViewName("delete");
	mav.addObject("title","delete mydata.");
	Optional<MyData> data = repository.findById((long)id);
	mav.addObject("formModel",data.get());
	return mav;
}

@RequestMapping(value = "/delete", method = RequestMethod.POST)
@Transactional(readOnly=false)
public ModelAndView remove(@RequestParam long id, 
		ModelAndView mav) {
	repository.deleteById(id);
	return new ModelAndView("redirect:/");
}
	@RequestMapping("/login")
	public ModelAndView login(ModelAndView mav) {
		return mav;
	}
	@RequestMapping("/hello")
	public ModelAndView hello(ModelAndView mav) {
		return mav;
	}
	@RequestMapping(value = {"/design"}, method = RequestMethod.GET)
	public ModelAndView design(
			@ModelAttribute("formModel") MyData mydata, 
			ModelAndView mav) {
		mav.setViewName("design");
		mav.addObject("msg","this is sample content.");
		Iterable<MyData> list = repository.findAll();
		mav.addObject("datalist",list);		
		return mav;
	}
	*/
}