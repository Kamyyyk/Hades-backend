package com.example.funeralbackend.funeral;

import com.example.funeralbackend.container.Container;
import com.example.funeralbackend.morgue.Morgue;
import com.example.funeralbackend.placeOnCementary.PlaceOnCemetery;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Table
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Funeral {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private Date funeralDate;
    @Column(nullable = false)
    private Status status;
    @Column(nullable = false)
    private double price;

    @ManyToOne
    @JoinColumn(name = "deceased_id")
    private Morgue morgue;

    @ManyToOne
    @JoinColumn(name = "container_id")
    private Container container;

    @ManyToOne
    @JoinColumn(name = "place_on_cemetary_id")
    private PlaceOnCemetery placeOnCemetery;


}
