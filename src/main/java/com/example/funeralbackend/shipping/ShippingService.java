package com.example.funeralbackend.shipping;

import com.example.funeralbackend.errors.NotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class ShippingService {
    private final ShippingRepository shippingRepository;

    public ShippingService(ShippingRepository shippingRepository) {
        this.shippingRepository = shippingRepository;
    }

    public List<Shipping> getAllShipping() {
        return shippingRepository.findAll();
    }

    public Shipping getShipping(Long id) {
        return shippingRepository.findById(id).orElseThrow(() -> new NotFoundException("cannot find shipping with id: " + id
        ));
    }

    public Shipping createShipping(Shipping shipping) {
        return shippingRepository.save(shipping);
    }

    public Shipping updateShipping(Long id, Shipping shipping) {
        Shipping existedShipping = getShipping(id);
        existedShipping.setCaravan(shipping.getCaravan());
        return shippingRepository.save(existedShipping);
    }

    public void deleteShipping(Long id) {
        Shipping existedShipping = getShipping(id);
        shippingRepository.delete(existedShipping);
    }

}
