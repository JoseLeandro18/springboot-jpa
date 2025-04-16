package com.estudos.springboot_jpa_web.repositories;

import com.estudos.springboot_jpa_web.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
