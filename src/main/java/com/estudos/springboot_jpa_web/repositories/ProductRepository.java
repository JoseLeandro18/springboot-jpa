package com.estudos.springboot_jpa_web.repositories;

import com.estudos.springboot_jpa_web.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
