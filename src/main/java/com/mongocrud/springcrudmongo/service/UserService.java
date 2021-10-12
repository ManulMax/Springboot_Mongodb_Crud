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
import java.util.NoSuchElementException;

@Service
public class UserService {
    private final UserRepositiory userRepositiory;

    Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    public UserService(UserRepositiory userRepositiory){
        this.userRepositiory = userRepositiory;
    }

    // Add user
    public User AddUser(User user){
        if(userRepositiory.findById(user.getId()).isPresent()){
            logger.info("User Already In Database");
            throw new BusinessException("601","User Alredy Added");
        }
        try {
            logger.info("Adding User to db");
            return userRepositiory.save(user);
        }
        catch (Exception e){
            throw new BusinessException("602","Something Went Wrong"+ e);
        }
    }

    // View All
    public List<User> viewAll(){
        List<User> userList = userRepositiory.findAll();
        if (userList.isEmpty()){
            logger.info("No Data in database");
            throw new BusinessException("603","No data In Database");
        }
        try{
            logger.info("View All Users Service");
            return userList;
        }catch (Exception e){
            throw new BusinessException("602","Something Went Wrong"+e);
        }
    }

    // View User by id
    public User viewUserId(String id){
//        if(userRepositiory.findById(id).isEmpty()){
//            logger.info("User not found in database");
//            throw new BusinessException("604","User Not Found");
//        }
        try {
            logger.info("View Single User Service");
            return userRepositiory.findById(id).get();
        }catch (IllegalArgumentException e){
            throw new BusinessException("605","Given Id Is Null "+ e.getMessage());
        }catch (NoSuchElementException e){
            throw new BusinessException("606","Id does not exist "+e.getMessage());
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
        if(userRepositiory.findById(id).isEmpty()){
            logger.info("User Not Found to delete");
            throw new BusinessException("608","Not Found To Delete");
        }
        try {
            userRepositiory.deleteById(id);
        }catch (Exception e){
            throw new BusinessException("602","Something Went Wrong"+e);
        }
        return "not found";
    }
}
