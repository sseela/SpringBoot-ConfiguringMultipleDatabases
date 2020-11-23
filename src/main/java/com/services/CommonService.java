package com.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.BookEntity;
import com.entities.UserEntity;
import com.repositories.BookRepository;
import com.repositories.UserRepository;
import com.viewmodels.BookVm;
import com.viewmodels.UserVm;

@Service
public class CommonService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private BookRepository bookRepo;
	
	@Transactional
	public void saveBook(BookVm book) {
		BookEntity entity = new BookEntity();
		entity.setBookId(book.getBookId());
		entity.setBookName(book.getBookName());
		this.bookRepo.save(entity);
	}
	
	@Transactional
	public void saveUser(UserVm user) {
		UserEntity e = new UserEntity();
		e.setUid(user.getId());
		e.setName(user.getName());
		this.userRepo.save(e);
	}
}
