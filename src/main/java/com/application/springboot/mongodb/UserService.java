package com.application.springboot.mongodb;

import java.util.List;
public interface UserService {

	UserDTO create(UserDTO todo);
	 
	UserDTO delete(String id);
 
    List<UserDTO> findAll();
 
    UserDTO findById(String id);
 
    UserDTO update(UserDTO todo);
}
