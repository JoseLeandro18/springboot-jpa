package com.estudos.springboot_jpa_web.config;

import com.estudos.springboot_jpa_web.entities.Order;
import com.estudos.springboot_jpa_web.entities.User;
import com.estudos.springboot_jpa_web.repositories.OrderRepository;
import com.estudos.springboot_jpa_web.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        User us1 = new User(null, "José Leandro", "jose@gmail.com", "11935041945", "123");
        User us2 = new User(null, "Isabele Fernandes", "isa@gmail.com", "35928453202", "321");

        Order or1 = new Order(null, Instant.parse("2025-04-14T10:55:07Z"), us1);
        Order or2 = new Order(null, Instant.parse("2025-04-14T13:55:13Z"), us2);
        Order or3 = new Order(null, Instant.parse("2025-04-14T22:55:22Z"), us1);

        userRepository.saveAll(Arrays.asList(us1, us2));
        orderRepository.saveAll(Arrays.asList(or1, or2, or3));
    }
}
