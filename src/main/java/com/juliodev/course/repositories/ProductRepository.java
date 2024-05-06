package com.juliodev.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juliodev.course.entities.Category;
import com.juliodev.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
