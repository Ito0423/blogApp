package com.tuyano.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tuyano.springboot.data.MyData;
import com.tuyano.springboot.form.CreateForm;
import com.tuyano.springboot.form.SignupForm;
import com.tuyano.springboot.repositories.MyDataRepository;
import com.tuyano.springboot.repositories.UserDataRepository;

@Controller
public class ManageController {

	@Autowired 
	MyDataRepository repository;
	
	@RequestMapping(value="/manage", method=RequestMethod.GET)
	public ModelAndView getHome(@ModelAttribute("formModel") MyData mydata,Model model,
	ModelAndView mav) {
		mav.setViewName("manageLayout");
		Iterable<MyData> list=repository.findAll();
		mav.addObject("contents","manage::manage_contents");
		mav.addObject("datalist",list);
		return mav;
	}
	@RequestMapping(value="/manage", method=RequestMethod.POST)
	@Transactional(readOnly=false)
	public ModelAndView form(
			@ModelAttribute("formModel")@Validated CreateForm form,BindingResult bindingResult, MyData mydata, 
			ModelAndView mav) {
	    mav.addObject("contents","manage::manage_contents");
		if(bindingResult.hasErrors()) {
			mav.setViewName("manageLayout");
			return mav;
		}
		System.out.println(form);
		repository.saveAndFlush(mydata);
		return new ModelAndView("redirect:/");
	}
	@PostMapping("/logout")
	 public	String postLogout() {
			return "redirect:/login";
	}
	@RequestMapping(value="/blogList", method=RequestMethod.GET)
	public ModelAndView getblogList(@ModelAttribute("formModel") MyData mydata,Model model,
			ModelAndView mav) {
				mav.setViewName("manageLayout");
				Iterable<MyData> list=repository.findAll();
				mav.addObject("contents","blogList::blogList_contents");
				mav.addObject("datalist",list);
				return mav;
			}
}