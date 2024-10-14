package com.example.restfull.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restfull.Entities.User;
import com.example.restfull.Repository.UserRepository;

@Service
public class UserImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User CreateUser(User user) {

        return userRepository.save(user);
        
    }

    @Override
    public List<User> getallUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getuserDetail(int id) {
        
        return userRepository.findById(id);
    }

    @Override
    public User updateuser(int id, User user) {
        User user2=userRepository.findById(id).orElse(null);
        if(user2 != null)
        {
            return userRepository.save(user);
        }else{
        throw new RuntimeException("Such User is not Found..."+id);
        }
    }

    @Override
    public boolean Deleteuser(int id) {
        Optional<User> optionals =getuserDetail(id);
        if(optionals.isPresent()){
            userRepository.deleteById(id);
        return true;
        }else{
            return false;
        }
    }

}
