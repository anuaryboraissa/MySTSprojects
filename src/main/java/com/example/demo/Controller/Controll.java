package com.example.demo.Controller;


import java.util.List;
import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Entity.Business;
import com.example.demo.Services.impl.Business_Impl;


@Controller
@RequestMapping("/crud")
public class Controll {
	@Autowired
 private Business_Impl serviceimp;

org.slf4j.Logger logg=LoggerFactory.getLogger(Controll.class);
public Controll(Business_Impl serviceimp) {
	super();
	this.serviceimp = serviceimp;
}

   @RequestMapping("/home")
   public String viewHome(Model m,@RequestHeader("first-request") String header) {
	   System.out.println(header);
	   List<Business> list=(List<Business>) serviceimp.selectAll();
	   m.addAttribute("list", list);
	return "index";
	   
   }
   /*
   //restTemplate
   @RequestMapping("/data")
   public List<Business> view() {  
	return serviceimp.selectAll();   
   }
   */
   @RequestMapping("/new")
   public String AddArtifact(Model m) {
	   Business business=new Business();
	   m.addAttribute("business", business);
	return "new";
	   
   }
   @RequestMapping(value="/save", method=RequestMethod.POST)
   public String saveArtifact(@ModelAttribute("business") Business business) {
	   serviceimp.SaveBusiness(business);
	return "redirect:/crud/home";
	   
   }
   @RequestMapping("/edit")
   public ModelAndView EditArtifact(@RequestParam long businessid) {
	   Business business=serviceimp.getById(businessid);
	   ModelAndView m=new ModelAndView("edit");
	   m.addObject("business", business);
	   return m;   
   }
   @RequestMapping("/delete/{id}")
   public String deleteArtifact(@PathVariable(name="id") long id) {
	   serviceimp.Delete(id); 
	return "redirect:/crud/home";   
   }
   @GetMapping("/interceptor")
   public String intercept() {    
	return "inter";   
   }
   @GetMapping("/filter")
   public String filter() {    
	return "myfilter";   
   }
}
