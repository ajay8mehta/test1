package com.application;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controllers {
	@RequestMapping(value="/",method = RequestMethod.GET)
    public String homepage(){
        return "views/login";
    }
	
	@RequestMapping(value="/document",method = RequestMethod.GET)
    public String users(){
        return "views/document";
    }
	
	/*@RequestMapping(value="/login",method = RequestMethod.GET)
    public String login(){
        return "views/login";
    }*/
    
    
}
