package com.estudos.springboot_jpa_web.repositories;

import com.estudos.springboot_jpa_web.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
