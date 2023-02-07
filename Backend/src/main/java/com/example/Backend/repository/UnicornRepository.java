package com.example.Backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Backend.pojo.Unicorn;

public interface UnicornRepository extends JpaRepository<Unicorn, Long> {

    // SELECT * FROM Unicorn WHERE Libelle=libelle
    List<Unicorn> findUnicornByLibelle(String libelle);

}
