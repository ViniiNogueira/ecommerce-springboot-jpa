package com.vinicius.ecommerce.services;

import com.vinicius.ecommerce.entities.User;
import com.vinicius.ecommerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

//    findAll
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

//    findById
    public User findById(Long id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.get();
    }
}
