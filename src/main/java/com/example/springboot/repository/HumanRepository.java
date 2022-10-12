package com.example.springboot.repository;

import com.example.springboot.entity.Human;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HumanRepository extends JpaRepository<Human,Long> {
}
