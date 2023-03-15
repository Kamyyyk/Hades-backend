package com.example.funeralbackend.morgue;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Date;
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
    private String name;
    private String surname;
    private Date dateArrived;
    private String sex;
    private Date birthDate;
    private Date deathDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Morgue morgue = (Morgue) o;
        return getId() != null && Objects.equals(getId(), morgue.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

