package com.example.funeralbackend.funeral;

import com.example.funeralbackend.errors.NotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class FuneralService {
    private final FuneralRepository funeralRepository;

    public FuneralService(FuneralRepository funeralRepository) {
        this.funeralRepository = funeralRepository;
    }

    public List<Funeral> getAllFunerals() {
        return funeralRepository.findAll();
    }

    public Funeral getFuneral(Long id) {
        return funeralRepository.findById(id).orElseThrow(() -> new NotFoundException("Cannot find funeral with id:" + id));
    }

    public Funeral createFuneral(Funeral funeral) {
        return funeralRepository.save(funeral);
    }

    public Funeral editFuneral(Long id, Funeral funeral) {
        Funeral existingFuneral = getFuneral(id);
        existingFuneral.setFuneralDate(funeral.getFuneralDate());
        existingFuneral.setPrice(funeral.getPrice());
        existingFuneral.setContainer(funeral.getContainer());
        existingFuneral.setMorgue(funeral.getMorgue());
        existingFuneral.setStatus(funeral.getStatus());
        existingFuneral.setPlaceOnCemetery(funeral.getPlaceOnCemetery());
        return funeralRepository.save(existingFuneral);
    }

    public void deleteFuneral(Long id) {
        Funeral existingFuneral = getFuneral(id);
        funeralRepository.delete(existingFuneral);
    }
}
