package com.tuyano.springboot.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.tuyano.springboot.data.MyData;
import com.tuyano.springboot.data.UserData;
import com.tuyano.springboot.form.CreateForm;
import com.tuyano.springboot.form.SignupForm;
import com.tuyano.springboot.repositories.AccountRepository;
import com.tuyano.springboot.repositories.MyDataRepository;
import com.tuyano.springboot.repositories.UserDataRepository;

@Controller
public class ManageController {

	@Autowired 
	MyDataRepository repository;
	@Autowired
	AccountRepository accountrepository;
	
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
		return new ModelAndView("redirect:/blogList");
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
	@RequestMapping(value="/blogdetail/{id}",method=RequestMethod.GET)
	public ModelAndView getblogdetail(@ModelAttribute MyData mydata,Model model,
			@PathVariable int id,ModelAndView mav) {
		mav.setViewName("manageLayout");
		mav.addObject("contents","blogDetail::blogDetail_contents");
		Optional<MyData> data=repository.findById((long)id);
		mav.addObject("formModel",data.get());
		return mav;
	}
	
	@RequestMapping(value="/blogdetail", params = "delete",method=RequestMethod.POST)
	@Transactional(readOnly=false)
	public ModelAndView remove(@RequestParam long id,ModelAndView mav) {
		repository.deleteById(id);
		return new ModelAndView("redirect:/blogList");
	}
	@RequestMapping(value="/blogdetail", params = "updata",method=RequestMethod.POST)
	@Transactional(readOnly=false)
	public ModelAndView updatablog(@ModelAttribute MyData mydata
			,ModelAndView mav) {
		repository.saveAndFlush(mydata);
		return new ModelAndView("redirect:/blogList");
	}
	
	@Autowired
	UserDataRepository repository_user;
	@RequestMapping(value="/userList", method=RequestMethod.GET)
	public ModelAndView getuserList(@ModelAttribute("formModel") UserData userdata,Model model,
			ModelAndView mav) {
				mav.setViewName("manageLayout");
				Iterable<UserData> userlist=accountrepository.findAll();
				mav.addObject("contents","userList::userList_contents");
				mav.addObject("datalist",userlist);
				return mav;
			}
	@RequestMapping(value="/userdetail/{id}",method=RequestMethod.GET)
	public ModelAndView getuserdetail(@ModelAttribute UserData userdata,Model model,
			@PathVariable int id,ModelAndView mav) {
		mav.setViewName("manageLayout");
		mav.addObject("contents","userDetail::userDetail_contents");
		Optional<UserData> data=accountrepository.findById((long)id);
		mav.addObject("formModel",data.get());
		return mav;
	}
	@RequestMapping(value="/userdetail", params = "delete",method=RequestMethod.POST)
	@Transactional(readOnly=false)
	public ModelAndView user_remove(@RequestParam long id,ModelAndView mav) {
		repository_user.deleteById(id);
		return new ModelAndView("redirect:/userList");
	}
	@RequestMapping(value="/userdetail", params = "updata",method=RequestMethod.POST)
	@Transactional(readOnly=false)
	public ModelAndView user_updata(
			@ModelAttribute("formModel") @Validated SignupForm form,
			BindingResult bindingResult,UserData userdata,@RequestParam long id			,ModelAndView mav) {
		mav.addObject("contents","userDetail::userDetail_contents");
		if(bindingResult.hasErrors()) {
			mav.setViewName("manageLayout");
			Optional<UserData> data=repository_user.findById((long)id);
			mav.addObject("formModel",data.get());
			return mav;
		}
		repository_user.saveAndFlush(userdata);
		return new ModelAndView("redirect:/userList");
	}
}
