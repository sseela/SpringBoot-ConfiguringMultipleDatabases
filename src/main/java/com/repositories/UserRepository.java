package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{

}
