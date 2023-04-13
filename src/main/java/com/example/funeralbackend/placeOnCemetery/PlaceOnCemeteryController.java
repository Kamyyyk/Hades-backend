package com.example.funeralbackend.placeOnCemetery;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/place-on-cemetery")
public class PlaceOnCemeteryController {
    private final PlaceOnCemeteryService placeOnCemeteryService;

    public PlaceOnCemeteryController(PlaceOnCemeteryService placeOnCemeteryService) {
        this.placeOnCemeteryService = placeOnCemeteryService;
    }

    @GetMapping
    public List<PlaceOnCemetery> getListCemeteryPlaces() {
        return placeOnCemeteryService.getAllPlaceOnCemetery();
    }

    @GetMapping("/{id}")
    public PlaceOnCemetery getCemeteryPlaceById(@PathVariable Long id) {
        return placeOnCemeteryService.getPlaceOnCemetery(id);
    }

    @PostMapping
    public PlaceOnCemetery createPlaceOnCemetery(@RequestBody PlaceOnCemetery placeOnCemetery) {
        return placeOnCemeteryService.createPlaceOnCemetery(placeOnCemetery);
    }

    @PutMapping("/{id}")
    public PlaceOnCemetery editPlaceOnCemeteryById(@PathVariable Long id, @RequestBody PlaceOnCemetery placeOnCemetery) {
        return placeOnCemeteryService.updatePlaceOnCemetery(id, placeOnCemetery);
    }

    @DeleteMapping("/{id}")
    public void deleteCemeteryPlaceById(@PathVariable Long id) {
        placeOnCemeteryService.deletePlaceOnCemetery(id);
    }
}
