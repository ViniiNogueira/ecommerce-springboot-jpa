package com.vinicius.ecommerce.resource;

import com.vinicius.ecommerce.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll() {
        User user = new User(1L, "Maria" , "maria@gmail.com" , "40028922" , "123456");
        return ResponseEntity.ok().body(user);
    }

}
