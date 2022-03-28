package com.example.demo.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.Entity.User;
import com.example.demo.Entity.UserFiles;
import com.example.demo.Exceptions.FileNotFound;
import com.example.demo.Repository.UserFilesConn;
import com.example.demo.Services.impl.FilesImpl;
import com.example.demo.Services.impl.UserImp;

@Controller
@RequestMapping("/dfile")
public class DownloadController {
	@Autowired
	private ServletContext context;
	@Autowired
	private UserFilesConn repo;
	@Autowired
	private FilesImpl file;
	 @GetMapping("/download")
	 public String downloadPage(Model model,@RequestHeader("first-request") String header) {
		 System.out.println(header);
		 List<UserFiles> listdocs=repo.findAll();
		 model.addAttribute("listdocs", listdocs);
		return "dowload"; 
	 }
	  @RequestMapping("/deletefile/{id}")
	   public String deleteArtifact(@PathVariable(name="id") long id,RedirectAttributes redirect) {
		  System.out.println("imefikaa.....");
		  file.DeleteFile(id);
		  redirect.addFlashAttribute("successmessage","File Deleted Successfully..") ;
		return "redirect:/dfile/download";   
	   }
	 
	 @GetMapping(value="/downloadfile/{name}/{ModifiedFileName}")
	 public void downloadFile(@PathVariable(name="name") String fileName,@PathVariable(name="ModifiedFileName") 
	 String modified,HttpServletResponse response) {
		 
		 String fullpath=context.getRealPath("/images/"+File.separator+modified);
		 File file=new File(fullpath);
		 final int BUFFER_SIZE=4096;
		 if(file.exists()){
			 try {
				 
				 FileInputStream fin=new FileInputStream(file);
				 String mimitype=context.getMimeType(fullpath);
				 response.setContentType(mimitype);
				 response.setHeader("content-disposition", "attachment;filename="+fileName);
				 OutputStream outputstream=response.getOutputStream();
				 byte[] buffer=new  byte[BUFFER_SIZE];
				 int byteread=-1;
				 while((byteread=fin.read(buffer))!=-1) {
					 outputstream.write(buffer,0,byteread);
				 }
				 fin.close();
				 outputstream.close();
			 }
			 catch(Exception a) {
				 throw new FileNotFound("Error while downloading file...",a);
			 }
		 }
	 }
}
