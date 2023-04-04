package com.example.funeralbackend.caravan;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/caravan")
public class CaravanController {
    private final CaravanService caravanService;

    public CaravanController(CaravanService caravanService) {
        this.caravanService = caravanService;
    }

    @GetMapping()
    public List<Caravan> getAllCaravans() {
        return caravanService.getAllCaravan();
    }
}
