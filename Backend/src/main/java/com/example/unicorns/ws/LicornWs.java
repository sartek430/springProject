package com.example.unicorns.ws;

import com.example.unicorns.pojo.Licorn;
import com.example.unicorns.service.LicornService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = ApiRegistration.UNICORNS_WS)
public class LicornWs {

    @Autowired
    private LicornService licornService;

    @GetMapping
    public List<Licorn> getAllLicorn(){
        return licornService.getAllLicorn();
    }

    @GetMapping("/{id}")
    public Licorn getLicornByLibelle(@PathVariable("id") Integer id){
        return licornService.getLicornById(id);
    }

    @PostMapping
    public void createLicorn(@RequestBody Licorn licorn){
        licornService.createLicorn(licorn);
    }

    @PutMapping("/{id}")
    public void updateLicorn(@RequestBody Licorn licorn, @PathVariable("id") Integer id){
        licornService.updateLicorn(licorn,id);

    }

    @DeleteMapping("/{id}")
    public void deleteLicorn(@PathVariable("id") Integer id){
        licornService.deleteLicorn(id);
    }
}