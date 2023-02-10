package com.example.unicorns.service;

import com.example.unicorns.pojo.Licorn;
import java.util.List;

public interface LicornService {
    List<Licorn> getAllLicorn();

    Licorn getLicornById(Integer id);

    void createLicorn(Licorn licorn);

    void updateLicorn(Licorn licorn, Integer id);

    void deleteLicorn(Integer id);

}
