package com.example.funeralbackend.documentation;

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
public class Documentation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @OneToOne
    @JoinColumn(name = "deceased_id")
    private Morgue morgue;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Documentation that = (Documentation) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(morgue, that.morgue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, morgue);
    }
}