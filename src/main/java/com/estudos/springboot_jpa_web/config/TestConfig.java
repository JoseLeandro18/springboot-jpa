package com.estudos.springboot_jpa_web.config;

import com.estudos.springboot_jpa_web.entities.*;
import com.estudos.springboot_jpa_web.entities.enums.OrderStatus;
import com.estudos.springboot_jpa_web.repositories.*;
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

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

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

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);

        OrderItem oi1 = new OrderItem(or1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(or1, p3, 1, p3.getPrice());
        OrderItem oi3 = new OrderItem(or2, p3, 2, p3.getPrice());
        OrderItem oi4 = new OrderItem(or3, p5, 2, p5.getPrice());

        userRepository.saveAll(Arrays.asList(us1, us2));
        orderRepository.saveAll(Arrays.asList(or1, or2, or3));
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));

        Payment pay1 = new Payment(null, Instant.parse("2025-04-14T12:55:07Z"), or1);
        or1.setPayment(pay1);
        orderRepository.save(or1);
    }
}
