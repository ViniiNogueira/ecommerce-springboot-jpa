package com.vinicius.ecommerce.repositories;

import com.vinicius.ecommerce.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
