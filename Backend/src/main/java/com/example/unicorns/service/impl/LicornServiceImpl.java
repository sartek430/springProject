package com.example.unicorns.service.impl;

import com.example.unicorns.pojo.Licorn;
import com.example.unicorns.repository.LicornRepository;
import com.example.unicorns.service.LicornService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LicornServiceImpl implements LicornService {

    @Autowired
    private LicornRepository licornRepository;

    @Override
    public List<Licorn> getAllLicorn() {
        return null;
    }

    @Override
    public Licorn getLicornById(Integer id) {
        return licornRepository.findById(id).orElse(null);
    }

    @Override
    public void createLicorn(Licorn licorn) {
        licornRepository.save(licorn);
    }

    @Override
    public void updateLicorn(Licorn licorn, Integer id) {
        Licorn maLicorn = this.getLicornById(id);
        maLicorn.setColor(licorn.getName());
        maLicorn.setName(licorn.getName());
        maLicorn.setPrice(licorn.getPrice());
        licornRepository.save(maLicorn);
    }

    @Override
    public void deleteLicorn(Integer id) {
        licornRepository.deleteById(id);
    }
}
