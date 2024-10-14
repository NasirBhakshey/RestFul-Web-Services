package com.example.restfull.Controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.restfull.Entities.User;
import com.example.restfull.Service.UserImpl;

@RestController
public class mycontroller {

    @Autowired
    private UserImpl userImpl;

    @PostMapping("/user")
    public User insertdetails(@RequestBody User user){
        return userImpl.CreateUser(user);
    }

    @GetMapping("user")
    public List<User> getalldetails()
    {
        return userImpl.getallUser();
    }

    @GetMapping("user/{id}")
    public ResponseEntity<User> getuserDetails(@PathVariable int id){
        User user=userImpl.getuserDetail(id).orElse(null);
        if(user != null){
            return ResponseEntity.ok().body(user);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id,@RequestBody User user){
        User updatedUser=userImpl.updateuser(id, user);
        if(updatedUser != null){
            return ResponseEntity.ok().body(user);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){

        String str=" User Deleted SuccessFully...";
        String str2="Such User is NotFound::";
        boolean status=userImpl.Deleteuser(id);
        if(status){
            return new ResponseEntity<>(str, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(str2, HttpStatus.OK);
        }
    }

}
