package com.example.unicorns.repository;

import com.example.unicorns.pojo.Licorn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LicornRepository extends JpaRepository<Licorn, Integer> {
    List<Licorn> findByName(String name);
}