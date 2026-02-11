package com.proyectopracticojava.SCVSupermercado.model;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Venta
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name="ventaId")
    private Venta venta;

    //Producto
    @ManyToOne  (fetch = FetchType.LAZY)
    @JoinColumn(name = "productoId")
    private Producto producto;
    private double cantidad;
    private double precio;


}
