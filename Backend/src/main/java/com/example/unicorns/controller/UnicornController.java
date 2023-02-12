package com.example.unicorns.controller;

import com.example.unicorns.entity.Unicorn;
import com.example.unicorns.service.UnicornService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UnicornController {

    @Autowired
    private UnicornService service;
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/unicorns")
    public Unicorn addUnicorn(@RequestBody Unicorn unicorn) {
        return service.saveUnicorn(unicorn);
    }

    @GetMapping("/unicorns")
    public List<Unicorn> findAllUnicorns() {
        return service.getUnicorns();
    }

    @GetMapping("/unicorn/{id}")
    public Unicorn findUnicornById(@PathVariable int id) {
        return service.getUnicornById(id);
    }

    @GetMapping("/unicorn/{name}")
    public Unicorn findUnicornByName(@PathVariable String name) {
        return service.getUnicornByName(name);
    }

    @PutMapping("/unicorns")
    public Unicorn updateUnicorn(@RequestBody Unicorn unicorn) {
        return service.updateUnicorn(unicorn);
    }

    @DeleteMapping("/unicorn/{id}")
    public String deleteUnicorn(@PathVariable int id) {
        return service.deleteUnicorn(id);
    }
}
