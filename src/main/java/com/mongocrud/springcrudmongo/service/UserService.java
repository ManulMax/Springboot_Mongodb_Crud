package com.mongocrud.springcrudmongo.service;

import com.mongocrud.springcrudmongo.controller.UserController;
import com.mongocrud.springcrudmongo.exception.BusinessException;
import com.mongocrud.springcrudmongo.model.User;
import com.mongocrud.springcrudmongo.repositories.UserRepositiory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepositiory userRepositiory;

    Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    public UserService(UserRepositiory userRepositiory){
        this.userRepositiory = userRepositiory;
    }

    // Add user
    public void AddUser(User user){
        logger.info("Add User Service");
        userRepositiory.save(user);
    }

    // View All
    public List<User> viewAll(){
        logger.info("View All Users Service");
        return userRepositiory.findAll();
    }

    // View User by id
    public User viewUserId(String id){
        if(userRepositiory.findById(id).isEmpty()){
            logger.info("User not found in database");
            throw new BusinessException("601","User Not Found");
        }
        try {
            logger.info("View Single User Service");
            return userRepositiory.findById(id).get();
        }catch (Exception e){
            throw new BusinessException("602","Something Went Wrong"+ e);
        }
    }

    // View User by name
//    public User viewUserName(String name){
//        logger.info("Get User By Name Controller");
//        return userRepositiory.findByName(name);
//    }

    // Update User
    public void updateUser(User user,String id){
        if(userRepositiory.findById(id).isPresent()){
            logger.info("Update Single User Service");
            userRepositiory.save(user);
        }
    }

    //Delete All
    public void deleteAll(){
        logger.info("Delete All User Service");
        userRepositiory.deleteAll();
    }

    //Delete by Id
    public String deleteUser(String id){
        if(userRepositiory.findById(id).isPresent()){
            logger.info("Delete Single User Service");
            userRepositiory.deleteById(id);
        }
        return "not found";
    }
}
