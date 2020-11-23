package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.services.CommonService;
import com.viewmodels.BookVm;
import com.viewmodels.UserVm;

@RestController
public class MainController {

	@Autowired
	private CommonService service;
	
	@PostMapping(value="/saveBook")
	public void saveBook(BookVm book) {
		this.service.saveBook(book);
	}
	
	@PostMapping(value="/saveUser")
	public void saveUser(UserVm user) {
		this.service.saveUser(user);
	}
}
