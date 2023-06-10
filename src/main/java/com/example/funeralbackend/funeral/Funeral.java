package com.example.funeralbackend.funeral;

import com.example.funeralbackend.container.Container;
import com.example.funeralbackend.morgue.Morgue;
import com.example.funeralbackend.placeOnCemetery.PlaceOnCemetery;
import com.example.funeralbackend.shipping.Shipping;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

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
    private LocalDate funeralDate;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusType status;
    private double price;
    @Enumerated(EnumType.STRING)
    private FuneralType funeralType;
    private boolean reportOrder;

    @ManyToOne
    @JoinColumn(name = "deceased_id")
    private Morgue morgue;

    @ManyToOne
    @JoinColumn(name = "container_id")
    private Container container;

    @ManyToOne
    @JoinColumn(name = "place_on_cemetery_id")
    private PlaceOnCemetery placeOnCemetery;

    @ManyToOne
    @JoinColumn(name= "shipping_id")
    private Shipping shipping;
}
