package com.example.Backend.service;

import com.example.Backend.pojo.Unicorn;

import java.util.List;

public interface UnicornService {

    List<Unicorn> getAllUnicorn();

    Unicorn getUnicornById(Long id);

    void createUnicorn(Unicorn unicorn);

    void updateUnicorn(Unicorn unicorn, Long id);

    void deleteUnicorn(Long id);
}