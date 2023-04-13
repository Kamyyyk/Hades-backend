package com.example.funeralbackend.driver;

import com.example.funeralbackend.errors.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
@RequiredArgsConstructor
public class DriverService {
    private final DriverRepository driverRepository;

    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    public Driver createDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    public Driver getDriver(Long id) {
        return driverRepository.findById(id).orElseThrow(() -> new NotFoundException("Cannot find driver with id: " + id));
    }

    public Driver updateDriver(Long id, Driver driver) {
        Driver existingDriver = getDriver(id);
        existingDriver.setName(driver.getName());
        existingDriver.setSurname(driver.getSurname());
        return driverRepository.save(existingDriver);
    }

    public void deleteDriver(Long id) {
        Driver existingDriver = getDriver(id);
        driverRepository.delete(existingDriver);
    }
}
