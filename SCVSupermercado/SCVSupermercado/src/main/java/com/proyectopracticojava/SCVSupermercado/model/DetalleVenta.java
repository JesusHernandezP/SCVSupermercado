package com.proyectopracticojava.SCVSupermercado.model;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor

public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Venta
    @ManyToOne
    private Venta venta;

    //Producto
    @ManyToOne
    private Producto producto;
    private double cantidad;
    private double precio;


}
