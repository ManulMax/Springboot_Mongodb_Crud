package com.mongocrud.springcrudmongo.Repositories;

import com.mongocrud.springcrudmongo.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepositiory extends MongoRepository<User, String> {

    public User findByName(String name);
}
