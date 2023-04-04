package com.example.funeralbackend.morgue;

import jakarta.persistence.*;
import jakarta.validation.constraints.AssertTrue;
import lombok.*;
import org.hibernate.Hibernate;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name="morgue")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Morgue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false)
    private LocalDate dateArrived;
    @Column(nullable = false)
    private String sex;
    @Column(nullable = false)
    private LocalDate birthDate;
    @Column(nullable = false)

    private LocalDate deathDate;

    @AssertTrue(message = "Death date must be before arrival date")
    public boolean isDeceasedArrivalAfterDeathDate() {
        return dateArrived.isAfter(deathDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Morgue morgue = (Morgue) o;
        return getId() != null && Objects.equals(getId(), morgue.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, dateArrived, sex, birthDate, deathDate);
    }
}

