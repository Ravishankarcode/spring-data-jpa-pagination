/*
 * Copyright 2013-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.datajpa.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
/**
 * 
 * @author Ravishankar.kumar
 *
 */
@Data
@Entity
@NamedQuery(name = "User.findByFirstnameNamed",
        query = "SELECT p FROM User p WHERE p.firstname = ?1")
@NamedNativeQuery(name = "User.findByLastnameNativeNamed",
        query = "SELECT * FROM User p WHERE p.lastname = :lastname")
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class User implements Serializable{

	private static final long serialVersionUID = -2952735933715107252L;

	@Id
	private int userId;
	private String firstname;
	private String lastname;
	private int age;
	private boolean active;
	
	public User() {
		super();
	}
	
	

}
