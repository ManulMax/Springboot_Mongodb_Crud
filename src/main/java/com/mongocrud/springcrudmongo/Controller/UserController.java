package com.mongocrud.springcrudmongo.Controller;

import com.mongocrud.springcrudmongo.Model.User;
import com.mongocrud.springcrudmongo.Repositories.UserRepositiory;
import com.mongocrud.springcrudmongo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/add")
    public void addUser(@RequestBody User user){
        userService.AddUser(user);
    }

    @GetMapping("/view")
    public List<User> getUser(){
        return userService.viewAll();
    }

    @GetMapping("/view/{id}")
    public User getById(@PathVariable String id){
        return userService.viewUserId(id);
    }

//    @GetMapping("/view/{name}")
//    public User getByName(@PathVariable String name){
//        return userService.viewUserName(name);
//    }

    @PutMapping("/update/{id}")
    public void editUser(@RequestBody User user, @PathVariable String id){
        userService.updateUser(user,id);
    }

    @DeleteMapping("/delete/{id}")
    public String removeUser(@PathVariable String id){
        return userService.deleteUser(id);
    }

    @DeleteMapping("/delete")
    public void removeAll(){
        userService.deleteAll();
    }
}
