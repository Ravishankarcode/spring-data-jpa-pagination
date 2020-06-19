package com.example.datajpa.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.datajpa.model.User;
import com.example.datajpa.repo.UserRepo;
/**
 * 
 * @author Ravishankar.kumar
 *
 */
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepo userRepo;

	@Override
	public Map<String, Object> getUserDetailsbyFirstname(String firstname, String lastname) {
		
		Map<String, Object> map = new HashMap<String, Object>();

		// get all users by last name
		Pageable pageable = PageRequest.of(0, 3);
		
		Page<User> users = userRepo.findByFirstname(firstname, pageable);
		
		// get all users sorted by their age in the descending order
		Pageable pageable2 = PageRequest.of(0, 5, Sort.by("age").descending());
		Page<User> personPage2 = userRepo.findAll(pageable2);
		
		// get all users sorted by their age in the descending order and sorted by their lastname in the ascending order
		Pageable pageable3 = PageRequest.of(0, 5, Sort.by("age").descending()
		        .and(Sort.by("lastName").ascending()));
		
		// skip pagination
        Slice<User> userSlice = userRepo.findByAgeBetween(20, 40, Pageable.unpaged());
        
		//map.put("Users Details", users);
		map.put("Users Vlaues::", userSlice);
		return map;
	}




}
