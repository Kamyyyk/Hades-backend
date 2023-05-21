package com.example.funeralbackend.shipping;

import com.example.funeralbackend.caravan.Caravan;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Entity
@Table
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Shipping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
    @ManyToOne
    @JoinColumn(name = "caravan_id")
    private Caravan caravan;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shipping shipping = (Shipping) o;
        return id == shipping.id && Objects.equals(caravan, shipping.caravan);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, caravan);
    }
}
