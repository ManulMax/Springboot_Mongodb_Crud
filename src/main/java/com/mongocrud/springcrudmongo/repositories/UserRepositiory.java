package com.mongocrud.springcrudmongo.repositories;

import com.mongocrud.springcrudmongo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositiory extends MongoRepository<User, String> {

    User findByName(String name);
}
