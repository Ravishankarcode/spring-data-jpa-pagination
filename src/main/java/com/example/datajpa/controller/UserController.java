package com.example.datajpa.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.datajpa.service.UserService;
/**
 * 
 * @author Ravishankar.kumar
 *
 */
@RestController
public class UserController{
	
	@Autowired
	UserService userService;
	
    @GetMapping("/getUserDetailsbyFirstname/{firstname}/{lastname}")
    public Map<String, Object> getUserDetails(@Valid @PathVariable(value = "firstname") String firstname,
    		@Valid @PathVariable(value = "lastname") String lastname) {
        return userService.getUserDetailsbyFirstname(firstname,lastname);
    }

}
