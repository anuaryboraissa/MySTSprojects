package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.Entity.Business;
import com.example.demo.Entity.User;
import com.example.demo.Entity.UserFiles;
import com.example.demo.Services.impl.UserImp;

@Controller
@RequestMapping("/ufile")
public class UploadController {
	@Autowired
	private UserImp userdata;

	public UploadController(UserImp userdata) {
		super();
		this.userdata = userdata;
	}
	  @RequestMapping("/user")
	   public String viewUser(Model m,@RequestHeader("first-request") String header) {
			 System.out.println(header);
		   List<User> mylist=(List<User>) userdata.selectAll();
		   m.addAttribute("mylist", mylist);
		   User user=new User();
		   m.addAttribute("user", user);
		   m.addAttribute("isAdd", true);
		   m.addAttribute("userfiles",new ArrayList<UserFiles>());
		return "user";
		   
	   }
	  @PostMapping("/savee")
	   public String saveUser(@ModelAttribute User user,RedirectAttributes redirect,Model model) {
		  User myuser=userdata.SaveUsers(user);
		  if(myuser!=null) {
			  redirect.addFlashAttribute("successmessage","User Is Saved Successfully..") ;
			  return "redirect:/ufile/user";
		  }
		  else {
			  model.addAttribute("errormessage", "user Is not saved successfully.. please try again");
			  model.addAttribute("user", user);
			  return "user";
		  }
		 
	  }
	   @RequestMapping("/update/{id}")
	   public String EditUser(@PathVariable(name="id") long id,Model m) {
		      userdata.DeleteById(id);
		   User user=userdata.checkById(id);
		   List<User> mylist=(List<User>) userdata.selectAll();
		   List<UserFiles> userfiles=userdata.fileById(id);
		   ((Model) m).addAttribute("mylist", mylist);
		   ((Model) m).addAttribute("user", user);
		   ((Model) m).addAttribute("userfiles",userfiles);
		   m.addAttribute("isAdd", false);
		    
		    return "user";   
	   }
	   @PostMapping("/update")
	   public String updateUser(@ModelAttribute User user,RedirectAttributes redirect,Model model) {
		  User myuser=userdata.updateUsers(user);
		  if(myuser!=null) {
			  redirect.addFlashAttribute("successmessage","User Is update Successfully..") ;
			  return "redirect:/ufile/user";
		  }
		  else {
			  model.addAttribute("errormessage", "user Is not update successfully.. please try again");
			  model.addAttribute("user", user);
			  return "user";
		  }
		 
	  }
	   @RequestMapping("/deletee/{uid}")
	   public String deleteUser(@PathVariable(name="uid") long uid,RedirectAttributes redirect) {
		  userdata.DeleteById(uid);
		  userdata.deleteUser(uid);
		  redirect.addFlashAttribute("successmessage","User Is deleted Successfully..") ;
		   return "redirect:/ufile/user";
		   }
}
