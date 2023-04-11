package com.example.funeralbackend.placeOnCemetery;

import com.example.funeralbackend.errors.NotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class PlaceOnCemeteryService {

    private final PlaceOnCemeteryRepository placeOnCemeteryRepository;

    public PlaceOnCemeteryService(PlaceOnCemeteryRepository placeOnCemeteryRepository) {
        this.placeOnCemeteryRepository = placeOnCemeteryRepository;
    }

    public List<PlaceOnCemetery> getAllPlaceOnCemetery() {
        return placeOnCemeteryRepository.findAll();
    }

    public PlaceOnCemetery getPlaceOnCemetery(Long id) {
        return placeOnCemeteryRepository.findById(id).orElseThrow(() -> new NotFoundException("cannot find cementary place with id:" + id));
    }

    public PlaceOnCemetery createPlaceOnCemetery(PlaceOnCemetery placeOnCemetery) {
        return placeOnCemeteryRepository.save(placeOnCemetery);
    }

    public PlaceOnCemetery updatePlaceOnCemetery(Long id, PlaceOnCemetery placeOnCemetery) {
        PlaceOnCemetery existingPlaceOnCemetery = getPlaceOnCemetery(id);
        existingPlaceOnCemetery.setCemeteryName(placeOnCemetery.getCemeteryName());
        existingPlaceOnCemetery.setNumber(placeOnCemetery.getNumber());
        existingPlaceOnCemetery.setAddress(placeOnCemetery.getAddress());
        return placeOnCemeteryRepository.save(existingPlaceOnCemetery);
    }

    public void deletePlaceOnCemetery(Long id) {
        PlaceOnCemetery existingPlaceOnCemetery = getPlaceOnCemetery(id);
        placeOnCemeteryRepository.delete(existingPlaceOnCemetery);
    }

}
