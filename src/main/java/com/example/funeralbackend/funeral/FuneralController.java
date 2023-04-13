package com.example.funeralbackend.funeral;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/funeral")
public class FuneralController {

    private final FuneralService funeralService;

    public FuneralController(FuneralService funeralService) {
        this.funeralService = funeralService;
    }

    @GetMapping
    public List<Funeral> getAllFunerals() {
        return funeralService.getAllFunerals();
    }

    @GetMapping("/{id}")
    public Funeral getFuneralById(@PathVariable Long id) {
        return funeralService.getFuneral(id);
    }

    @PostMapping
    public Funeral createFuneral(@RequestBody Funeral funeral) {
        return funeralService.createFuneral(funeral);
    }

    @PutMapping("/{id}")
    public Funeral updateFuneralById(@PathVariable Long id, @RequestBody Funeral funeral) {
        return funeralService.editFuneral(id, funeral);
    }

    @DeleteMapping("/{id}")
    public void deleteFuneralById(@PathVariable Long id) {
        funeralService.deleteFuneral(id);
    }
}
