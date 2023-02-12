package com.example.unicorns.repository;

import com.example.unicorns.entity.Unicorn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnicornRepository extends JpaRepository<Unicorn,Integer> {
    Unicorn findByName(String name);
}

