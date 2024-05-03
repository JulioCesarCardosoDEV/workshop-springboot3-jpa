package com.juliodev.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juliodev.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
