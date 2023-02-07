package com.example.Backend.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Backend.pojo.Unicorn;
import com.example.Backend.service.UnicornService;

import java.util.List;

@RestController
@RequestMapping(value = ApiRegistration.UNICORN_WS)
public class UnicornWs {
    @Autowired
    private UnicornService unicornService;

    @GetMapping
    public List<Unicorn> getAllUnicorn() {
        return unicornService.getAllUnicorn();
    }

    @GetMapping("/{id}")
    public Unicorn getUnicornByLibelle(@PathVariable("id") Long id) {
        return unicornService.getUnicornById(id);
    }

    @PostMapping
    public void createUnicorn(@RequestBody Unicorn unicorn) {
        unicornService.createUnicorn(unicorn);
    }

    @PutMapping("/{id}")
    public void updateUnicorn(@RequestBody Unicorn unicorn,
            @PathVariable("id") Long id) {
        unicornService.updateUnicorn(unicorn, id);

    }

    @DeleteMapping("/{id}")
    public void deleteUnicorn(@PathVariable("id") Long id) {
        unicornService.deleteUnicorn(id);
    }
}
