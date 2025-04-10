package com.estudos.springboot_jpa_web.config;

import com.estudos.springboot_jpa_web.entities.User;
import com.estudos.springboot_jpa_web.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User us1 = new User(null, "José Leandro", "jose@gmail.com", "11935041945", "123");
        User us2 = new User(null, "Isabele Fernandes", "isa@gmail.com", "35928453202", "321");

        userRepository.saveAll(Arrays.asList(us1,us2));
    }
}
