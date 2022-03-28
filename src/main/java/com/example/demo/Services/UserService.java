package com.example.demo.Services;

import java.util.List;

import com.example.demo.Entity.User;
import com.example.demo.Entity.UserFiles;

public interface UserService {
	 List<User> selectAll();
	 User SaveUsers(User user);
	 User checkById(long id);
	 List<UserFiles> fileById(long user_id);
	 User updateUsers(User user);
	 void DeleteById(long uid);
	 void deleteUser(long uid);
}
