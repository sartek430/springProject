package com.example.Backend.service.impl;

import com.example.Backend.repository.UnicornRepository;
import com.example.Backend.pojo.Unicorn;
import com.example.Backend.service.UnicornService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnicornServiceImpl implements UnicornService {

    @Autowired
    private UnicornRepository unicornRepository;

    @Override
    public List<Unicorn> getAllUnicorn() {
        return unicornRepository.findAll();
    }

    @Override
    public Unicorn getUnicornById(Long id) {
        return unicornRepository.findById(id).orElse(null);
    }

    @Override
    public void createUnicorn(Unicorn unicorn) {
        unicornRepository.save(unicorn);
    }

    @Override
    public void updateUnicorn(Unicorn unicorn, Long id) {
        Unicorn maUnicorn = this.getUnicornById(id);
        maUnicorn.setPoid(unicorn.getPoid());
        maUnicorn.setLibelle(unicorn.getLibelle());
        unicornRepository.save(maUnicorn);
    }

    @Override
    public void deleteUnicorn(Long id) {
        unicornRepository.deleteById(id);
    }
}
