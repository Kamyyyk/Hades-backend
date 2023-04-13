package com.example.funeralbackend.caravan;

import com.example.funeralbackend.errors.NotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class CaravanService {
    private final CaravanRepository caravanRepository;

    public CaravanService(CaravanRepository caravanRepository) {
        this.caravanRepository = caravanRepository;
    }

    public List<Caravan> getAllCaravan() {
        return caravanRepository.findAll();
    }

    public Caravan getCaravan(Long id) {
        return caravanRepository.findById(id).orElseThrow(() -> new NotFoundException("cannot found caravan with id: " + id));
    }

    public Caravan createCaravan(Caravan caravan) {
        return caravanRepository.save(caravan);
    }

    public Caravan editCaravan(Long id, Caravan caravan) {
        Caravan existingCaravan = getCaravan(id);
        existingCaravan.setBrand(caravan.getBrand());
        existingCaravan.setModel(caravan.getModel());
        existingCaravan.setDriver(caravan.getDriver());
        return caravanRepository.save(existingCaravan);
    }

    public void deleteCaravan(Long id) {
        Caravan existingDriver = getCaravan(id);
        caravanRepository.delete(existingDriver);
    }
}
