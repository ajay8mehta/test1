package com.application.springboot.mongodb;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/user")
final class TodoController {
 
    private final UserService service;
 
    @Autowired
    TodoController(UserService service) {
        this.service = service;
    }
 
    @RequestMapping(value="/createuser",method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody UserDTO create(@RequestBody @Valid UserDTO userEntry) {
    	System.out.println("success");
        return service.create(userEntry);
    }
 
    @RequestMapping(value = "/deleteuser/{id}", method = RequestMethod.DELETE)
    UserDTO delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
 
    @RequestMapping(method = RequestMethod.GET)
    List<UserDTO> findAll() {
        return service.findAll();
    }
 
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    UserDTO findById(@PathVariable("id") String id) {
        return service.findById(id);
    }
 
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    UserDTO update(@RequestBody @Valid UserDTO userEntry) {
        return service.update(userEntry);
    }
 
    /*@ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleUserNotFound(UserNotFound ex) {
    }*/
}