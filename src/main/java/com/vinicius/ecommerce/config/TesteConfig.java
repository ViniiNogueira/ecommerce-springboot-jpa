package com.vinicius.ecommerce.config;

import com.vinicius.ecommerce.entities.User;
import com.vinicius.ecommerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Vinicius" , "vinicius@gmail.com" , "999999999","123456");
        User u2 = new User(null,"Joao" , "joao@gmail.com" , "9999999999" , "123456");

        userRepository.saveAll(Arrays.asList(u1,u2));
    }

    @Autowired
    private UserRepository userRepository;
}
