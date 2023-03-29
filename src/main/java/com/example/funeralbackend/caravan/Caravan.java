package com.example.funeralbackend.caravan;

import com.example.funeralbackend.driver.Driver;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Table(name = "caravan")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Caravan {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String licenceNumber;
    private String brand;
    private String model;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Caravan caravan = (Caravan) o;
        return getId() != null && Objects.equals(getId(), caravan.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
