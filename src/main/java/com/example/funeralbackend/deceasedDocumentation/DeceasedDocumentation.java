package com.example.funeralbackend.deceasedDocumentation;

import com.example.funeralbackend.morgue.Morgue;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Entity
@Table(name = "documentation")
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class DeceasedDocumentation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;

    @OneToOne
    @JoinColumn(name = "deceased_id")
    private Morgue morgue;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeceasedDocumentation that = (DeceasedDocumentation) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(morgue, that.morgue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, morgue);
    }
}
