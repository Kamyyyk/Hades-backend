package com.example.funeralbackend.placeOnCemetery;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Entity
@Table(name = "place_on_cemetery")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class PlaceOnCemetery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String cemeteryName;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private boolean isCemeteryPlaceOccupied;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlaceOnCemetery that = (PlaceOnCemetery) o;
        return Objects.equals(id, that.id) && Objects.equals(cemeteryName, that.cemeteryName) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cemeteryName, address);
    }
}
