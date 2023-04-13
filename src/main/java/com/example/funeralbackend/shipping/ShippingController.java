package com.example.funeralbackend.shipping;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/shipping")
public class ShippingController {
    private final ShippingService shippingService;

    public ShippingController(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    @GetMapping
    public List<Shipping> getAllShipping() {
        return shippingService.getAllShipping();
    }

    @GetMapping("/{id}")
    public Shipping getShippingById(@PathVariable Long id) {
        return shippingService.getShipping(id);
    }

    @PostMapping
    public Shipping createShipping(@RequestBody Shipping shipping){
        return shippingService.createShipping(shipping);
    }

    @PutMapping("/{id}")
    public Shipping updateShippingById(@PathVariable Long id, @RequestBody Shipping shipping){
        return shippingService.updateShipping(id, shipping);
    }

    @DeleteMapping("/{id}")
    public void deleteShippingById(@PathVariable Long id) {
        shippingService.deleteShipping(id);
    }
}
