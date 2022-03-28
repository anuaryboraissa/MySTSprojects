package com.example.demo.Services.impl;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.UserFiles;
import com.example.demo.Repository.UserFilesConn;
import com.example.demo.Services.FilesServices;
@Service
@Transactional
public class FilesImpl implements FilesServices{
	  @Autowired
	  ServletContext context;
	  @Autowired
	 private UserFilesConn files;
	@Override
	public File getFilePath(String modifiedFileName, String path) {
		// TODO Auto-generated method stub
		boolean exist=new File(context.getRealPath("/"+path)+"/").exists();
		if(!exist) {
			new File(context.getRealPath("/"+path)+"/").mkdir();
		}
		String modifiedFilePath=context.getRealPath("/"+path+"/"+File.separator+modifiedFileName);
		File file=new File(modifiedFilePath);
		return file;
	}
	@Override
	public void DeleteFile(long id) {
		List<UserFiles> userfiles=files.findFilesById(id);
		if(userfiles!=null && userfiles.size()>0) {
			for(UserFiles dbfiles : userfiles) {
				File Dbstorefile=new File(context.getRealPath("/images/"+File.separator+dbfiles.getModifiedFileName()));
				if(Dbstorefile.exists()) {
					Dbstorefile.delete();
				}
				
			}
		}
		files.deleteById(id);
	}

}
