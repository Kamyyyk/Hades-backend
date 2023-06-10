package com.example.funeralbackend.funeral;

import com.example.funeralbackend.errors.NotFoundException;
import com.example.funeralbackend.placeOnCemetery.PlaceOnCemetery;
import com.example.funeralbackend.placeOnCemetery.PlaceOnCemeteryRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class FuneralService {
    private final FuneralRepository funeralRepository;
    private final PlaceOnCemeteryRepository placeOnCemeteryRepository;

    public FuneralService(FuneralRepository funeralRepository, PlaceOnCemeteryRepository placeOnCemeteryRepository) {
        this.funeralRepository = funeralRepository;
        this.placeOnCemeteryRepository = placeOnCemeteryRepository;
    }

    public List<Funeral> getAllFunerals() {
        return funeralRepository.findAll();
    }

    public Funeral getFuneral(Long id) {
        return funeralRepository.findById(id).orElseThrow(() -> new NotFoundException("Cannot find funeral with id:" + id));
    }

    private double funeralFullPrice(Funeral funeral) {
        double finalPrice = 0;
        Funeral savedFuneral = funeralRepository.save(funeral);
        double shippingPrice = savedFuneral.getShipping().getPrice();
        double containerPrice = savedFuneral.getContainer().getPrice();
        double placeOnCemeteryPrice = savedFuneral.getPlaceOnCemetery().getPrice();
        return finalPrice + shippingPrice + containerPrice + placeOnCemeteryPrice;
    }

    public Funeral createFuneral(Funeral funeral) {
        funeral.setPrice(funeralFullPrice(funeral));
        Funeral savedFuneral = funeralRepository.save(funeral);
        PlaceOnCemetery placeOnCemetery = savedFuneral.getPlaceOnCemetery();
        placeOnCemetery.setCemeteryPlaceOccupied(true);
        placeOnCemeteryRepository.save(placeOnCemetery);
        return savedFuneral;
    }

    public Funeral editFuneral(Long id, Funeral funeral) {
        Funeral existingFuneral = getFuneral(id);
        existingFuneral.setFuneralDate(funeral.getFuneralDate());
        existingFuneral.setPrice(funeral.getPrice());
        existingFuneral.setContainer(funeral.getContainer());
        existingFuneral.setMorgue(funeral.getMorgue());
        existingFuneral.setStatus(funeral.getStatus());
        existingFuneral.setPlaceOnCemetery(funeral.getPlaceOnCemetery());
        existingFuneral.setShipping(funeral.getShipping());
        existingFuneral.setPrice(funeralFullPrice(funeral));
        return funeralRepository.save(existingFuneral);
    }

    public void deleteFuneral(Long id) {
        Funeral existingFuneral = getFuneral(id);
        funeralRepository.delete(existingFuneral);
    }
}
