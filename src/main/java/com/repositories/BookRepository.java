package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entities.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, Integer>{

}
