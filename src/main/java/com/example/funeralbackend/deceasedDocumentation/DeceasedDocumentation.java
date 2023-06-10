package com.example.funeralbackend.deceasedDocumentation;

import com.example.funeralbackend.morgue.Morgue;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "deceased_documentation")
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class DeceasedDocumentation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String documentationNumber;
    @Column(nullable = false)
    private LocalDate documentationCreateDate;
    private LocalDate documentationEditDate;

    @OneToOne
    @JoinColumn(name = "deceased_id")
    private Morgue morgue;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeceasedDocumentation that = (DeceasedDocumentation) o;
        return id == that.id && Objects.equals(documentationNumber, that.documentationNumber) && Objects.equals(morgue, that.morgue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, documentationNumber, morgue);
    }
}
