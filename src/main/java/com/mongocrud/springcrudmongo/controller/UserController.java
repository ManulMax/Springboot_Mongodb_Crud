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
//@RequestMapping(value = "/user")
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
            return new ResponseEntity<User>(user1,HttpStatus.OK);
        }catch (BusinessException e){
            logger.info("catch business exception");
            ControllerException ce = new ControllerException(e.getErrorCode(),e.getErrorMessage());
            return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/view")
    public List<User> getUser(){
        logger.info("Get All Users Controller");
        return userService.viewAll();
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<?> getById(@PathVariable String id){
        try{
            User user = userService.viewUserId(id);
            logger.info("Get Single User Controller");
            return new ResponseEntity<User>(user,HttpStatus.OK);
        }catch (BusinessException e){
            logger.info("catch business exception");
            ControllerException ce = new ControllerException(e.getErrorCode(),e.getErrorMessage());
            return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            logger.info("catch general exception");
            ControllerException ce = new ControllerException("610","Something Not Right In Controller");
            return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
        }
    }

//    @GetMapping("/view/{name}")
//    public User getByName(@PathVariable String name){
//        logger.info("Get User By Name Controller");
//        return userService.viewUserName(name);
//    }

    @PutMapping("/update/{id}")
    public void editUser(@RequestBody User user, @PathVariable String id){
        logger.info("Edit User Controller");
        userService.updateUser(user,id);
    }

    @DeleteMapping("/delete/{id}")
    public String removeUser(@PathVariable String id){
        logger.info("Delete Single User Controller");
        return userService.deleteUser(id);
    }

    @DeleteMapping("/delete")
    public void removeAll(){
        logger.info("Delete All Users Controller");
        userService.deleteAll();
    }
}
