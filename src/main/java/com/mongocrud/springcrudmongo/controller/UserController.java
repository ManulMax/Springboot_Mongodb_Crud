package com.mongocrud.springcrudmongo.controller;

import com.mongocrud.springcrudmongo.exception.BusinessException;
import com.mongocrud.springcrudmongo.exception.ControllerException;
import com.mongocrud.springcrudmongo.model.User;
import com.mongocrud.springcrudmongo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    private final UserService userService;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody User user){
        try{
            User user1 = userService.AddUser(user);
            return new ResponseEntity<>(user1,HttpStatus.CREATED);
        }catch (BusinessException e){
            logger.info("catch business exception in Add User Controller");
            ControllerException ce = new ControllerException(e.getErrorCode(),e.getErrorMessage());
            return new ResponseEntity<>(ce,HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            ControllerException ce = new ControllerException("710","Something Went Wrong In Controller");
            return new ResponseEntity<>(ce,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/view")
    public ResponseEntity<?> getUser(){
        try{
            logger.info("Get All Users Controller");
            List<User> getUser = userService.viewAll();
            return new ResponseEntity<>(getUser,HttpStatus.OK);
        }catch (BusinessException e){
            logger.info("catch business exception in View all User Controller");
            ControllerException ce = new ControllerException(e.getErrorCode(),e.getErrorMessage());
            return new ResponseEntity<>(ce,HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            ControllerException ce = new ControllerException("710","Something Went Wrong In Controller");
            return new ResponseEntity<>(ce,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<?> getById(@PathVariable String id){
        try{
            User user = userService.viewUserId(id);
            logger.info("Get Single User Controller");
            return new ResponseEntity<>(user,HttpStatus.OK);
        }catch (BusinessException e){
            logger.info("catch business exception in get user by id");
            ControllerException ce = new ControllerException(e.getErrorCode(),e.getErrorMessage());
            return new ResponseEntity<>(ce,HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            logger.info("catch general exception in get user by id");
            ControllerException ce = new ControllerException("610","Something Not Right In Controller");
            return new ResponseEntity<>(ce,HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> editUser(@RequestBody User user, @PathVariable String id){
        try{
            logger.info("Edit User Controller");
            User user1 = userService.updateUser(user,id);
            return new ResponseEntity<>(user1,HttpStatus.OK);
        }catch (BusinessException e){
            logger.info("catch business exception in update user");
            ControllerException ce = new ControllerException(e.getErrorCode(),e.getErrorMessage());
            return new ResponseEntity<>(ce,HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            logger.info("catch general exception in get update");
            ControllerException ce = new ControllerException("610","Something Not Right In Controller");
            return new ResponseEntity<>(ce,HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void removeUser(@PathVariable String id){
        logger.info("Delete Single User Controller");
        userService.deleteUser(id);
    }

    @DeleteMapping("/delete")
    public void removeAll(){
        logger.info("Delete All Users Controller");
        userService.deleteAll();
    }

//    @GetMapping("/view/{name}")
//    public User getByName(@PathVariable String name){
//        logger.info("Get User By Name Controller");
//        return userService.viewUserName(name);
//    }
}
