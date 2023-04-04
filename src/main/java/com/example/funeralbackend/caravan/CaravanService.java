package com.example.funeralbackend.caravan;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
@RequiredArgsConstructor
public class CaravanService {
    private final CaravanRepository caravanRepository;

    public List<Caravan> getAllCaravan() {
        return caravanRepository.findAll();
    }
}
