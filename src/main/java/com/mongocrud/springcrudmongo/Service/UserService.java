package com.mongocrud.springcrudmongo.Service;

import com.mongocrud.springcrudmongo.Model.User;
import com.mongocrud.springcrudmongo.Repositories.UserRepositiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepositiory userRepositiory;

    @Autowired
    public UserService(UserRepositiory userRepositiory){
        this.userRepositiory = userRepositiory;
    }

    // Add user
    public void AddUser(User user){
        userRepositiory.save(user);
    }

    // View All
    public List<User> viewAll(){
        return userRepositiory.findAll();
    }

    // View User by id
    public User viewUserId(String id){
        return userRepositiory.findById(id).get();
    }

    // View User by name
//    public User viewUserName(String name){
//        return userRepositiory.findByName(name);
//    }

    // Update User
    public void updateUser(User user,String id){
        if(userRepositiory.findById(id).isPresent()){
            userRepositiory.save(user);
        }
    }

    //Delete All
    public void deleteAll(){
        userRepositiory.deleteAll();
    }

    //Delete by Id
    public String deleteUser(String id){
        if(userRepositiory.findById(id).isPresent()){
            userRepositiory.deleteById(id);
        }
        return "not found";
    }
}
