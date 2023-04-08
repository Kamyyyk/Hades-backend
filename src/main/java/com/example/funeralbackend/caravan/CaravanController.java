package com.example.funeralbackend.caravan;

import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public Caravan getCaravanById(@PathVariable Long id) {
        return caravanService.getCaravan(id);
    }

    @PostMapping()
    public Caravan createCaravan(@RequestBody Caravan caravan){
        return caravanService.createCaravan(caravan);
    }

    @PutMapping("/{id}")
    public Caravan updateCaravanById(@PathVariable Long id, @RequestBody Caravan caravan) {
        return caravanService.editCaravan(id, caravan);
    }

    @DeleteMapping("/{id}")
    public void deleteCaravanById(@PathVariable Long id) {
        caravanService.deleteCaravan(id);
    }
}
