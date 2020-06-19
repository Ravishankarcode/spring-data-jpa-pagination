package com.example.datajpa.service;

import java.util.Map;
/**
 * 
 * @author Ravishankar.kumar
 *
 */
public interface UserService {

	Map<String, Object> getUserDetailsbyFirstname(String firstname, String lastname);


}
