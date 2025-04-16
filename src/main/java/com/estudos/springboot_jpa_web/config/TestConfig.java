package com.estudos.springboot_jpa_web.config;

import com.estudos.springboot_jpa_web.entities.Category;
import com.estudos.springboot_jpa_web.entities.Order;
import com.estudos.springboot_jpa_web.entities.User;
import com.estudos.springboot_jpa_web.entities.enums.OrderStatus;
import com.estudos.springboot_jpa_web.repositories.CategoryRepository;
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

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        User us1 = new User(null, "José Leandro", "jose@gmail.com", "11935041945", "123");
        User us2 = new User(null, "Isabele Fernandes", "isa@gmail.com", "35928453202", "321");

        Order or1 = new Order(null, Instant.parse("2025-04-14T10:55:07Z"), OrderStatus.PAID, us1);
        Order or2 = new Order(null, Instant.parse("2025-04-14T13:55:13Z"), OrderStatus.WAITING_PAYMENT, us2);
        Order or3 = new Order(null, Instant.parse("2025-04-14T22:55:22Z"), OrderStatus.WAITING_PAYMENT, us1);

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        userRepository.saveAll(Arrays.asList(us1, us2));
        orderRepository.saveAll(Arrays.asList(or1, or2, or3));
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
    }
}
