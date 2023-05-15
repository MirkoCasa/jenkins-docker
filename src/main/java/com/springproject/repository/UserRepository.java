package com.springproject.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springproject.model.User;

public interface UserRepository extends MongoRepository<User, Integer>{

}
