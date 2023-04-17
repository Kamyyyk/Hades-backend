package com.example.funeralbackend.container;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Entity
@Table(name = "container")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Container {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String containerName;
    private String descriptionPlate;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private containerType containerType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Container container = (Container) o;
        return id == container.id && Objects.equals(containerName, container.containerName) && containerType == container.containerType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, containerName, containerType);
    }
}
