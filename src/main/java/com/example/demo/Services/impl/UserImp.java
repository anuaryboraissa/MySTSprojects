package com.example.demo.Services.impl;

import java.io.File;

import java.util.Collection;
import java.util.List;


import javax.servlet.ServletContext;
import javax.transaction.Transactional;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.BeanDefinitionDsl.Role;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Entity.User;
import com.example.demo.Entity.UserFiles;
import com.example.demo.Exceptions.FileNotFound;
import com.example.demo.Exceptions.FileStorageException;
import com.example.demo.Repository.UserConnection;
import com.example.demo.Repository.UserFilesConn;
import com.example.demo.Services.UserService;

import antlr.StringUtils;

@Service
@Transactional
public class UserImp implements UserService{
  @Autowired
  private UserConnection userconn;
  @Autowired
  private FilesImpl filepath;
  @Autowired
  private UserFilesConn userdatabase;
  @Autowired
  private ServletContext context;
	@Override
	public List<User> selectAll() {
		// TODO Auto-generated method stub
		return userconn.findAll();
	}

	@Override
	public User SaveUsers(User user) {
		// TODO Auto-generated method stub
		User dbuser=userconn.save(user);
		if(dbuser!=null && user.getFiles()!=null && user.getFiles().size()>0) {
			for(MultipartFile file: user.getFiles()) {
				String filename=file.getOriginalFilename();
				String modifiedFilename=FilenameUtils.getBaseName(filename)+" "+
				System.currentTimeMillis()+"."+FilenameUtils.getExtension(filename);
				File storefile=filepath.getFilePath(modifiedFilename,"images");
				if(storefile!=null) {
					try {
						FileUtils.writeByteArrayToFile(storefile, file.getBytes());
					}
					catch(Exception a) {
						throw new FileStorageException(String.format("Failed to store file...", filename),a);
					}
				}
				UserFiles files=new UserFiles();
				files.setType(FilenameUtils.getExtension(filename));
				files.setModifiedFileName(modifiedFilename);
				files.setUser(dbuser);
				files.setName(filename);
				userdatabase.save(files);
			}
		}
		return dbuser;
	}

	@Override
	public User checkById(long id) {
		return userconn.findById(id).orElseThrow(() ->new FileNotFound("Data not found my friend"));
	}


	@Override
	public List<UserFiles> fileById(long user_id) {
		
		return userdatabase.findFilesById(user_id);
	}
	@Override
	public User updateUsers(User user) {
		User dbuser=userconn.save(user);
		if(dbuser!=null && user.getFiles()!=null && user.getFiles().size()>0) {
			for(MultipartFile file: user.getFiles()) {
				String filename=file.getOriginalFilename();
				String modifiedFilename=FilenameUtils.getBaseName(filename)+" "+
				System.currentTimeMillis()+"."+FilenameUtils.getExtension(filename);
				File storefile=filepath.getFilePath(modifiedFilename,"images");
				if(storefile!=null) {
					try {
						FileUtils.writeByteArrayToFile(storefile, file.getBytes());
					}
					catch(Exception a) {
						throw new FileStorageException(String.format("Failed to store file...", filename),a);
					}
				}
				UserFiles files=new UserFiles();
				files.setType(FilenameUtils.getExtension(filename));
				files.setModifiedFileName(modifiedFilename);
				files.setUser(dbuser);
				files.setName(filename);
				userdatabase.save(files);
			}
		}
		return dbuser;
	}
	@Override
	public void DeleteById(long uid) {
		// TODO Auto-generated method stub
		List<UserFiles> userfiles=userdatabase.findFilesById(uid);
		if(userfiles!=null && userfiles.size()>0) {
			for(UserFiles dbfiles : userfiles) {
				File Dbstorefile=new File(context.getRealPath("/images/"+File.separator+dbfiles.getModifiedFileName()));
				if(Dbstorefile.exists()) {
					Dbstorefile.delete();
				}
				
			}
			userdatabase.deleteFilesByUid(uid);
		}
	}
	@Override
	public void deleteUser(long uid) {
		// TODO Auto-generated method stub
		userconn.deleteById(uid);
	}

}
