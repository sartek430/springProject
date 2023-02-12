package com.example.unicorns.service;

import com.example.unicorns.entity.Unicorn;
import com.example.unicorns.repository.UnicornRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnicornService {
    @Autowired
    private UnicornRepository repository;

    public Unicorn saveUnicorn(Unicorn unicorn) {
        return repository.save(unicorn);
    }

    public List<Unicorn> saveUnicorns(List<Unicorn> unicorns) {
        return repository.saveAll(unicorns);
    }

    public List<Unicorn> getUnicorns() {
        return repository.findAll();
    }

    public Unicorn getUnicornById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Unicorn getUnicornByName(String name) {
        return repository.findByName(name);
    }

    public String deleteUnicorn(int id) {
        repository.deleteById(id);
        return "Licorne supprimé !! " + id;
    }

    public Unicorn updateUnicorn(Unicorn unicorn) {
        Unicorn existingUnicorn = repository.findById(unicorn.getId()).orElse(null);
        existingUnicorn.setName(unicorn.getName());
        existingUnicorn.setPrice(unicorn.getPrice());
        existingUnicorn.setColor(unicorn.getColor());
        return repository.save(existingUnicorn);
    }


}
