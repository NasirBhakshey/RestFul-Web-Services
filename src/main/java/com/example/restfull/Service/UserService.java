package com.example.restfull.Service;

import com.example.restfull.Entities.User;

import java.util.*;

public interface UserService {

    public User CreateUser(User user);
    public List<User> getallUser();
    public Optional<User> getuserDetail(int id);
    public User updateuser(int id,User user);

    public boolean Deleteuser(int id);
}
