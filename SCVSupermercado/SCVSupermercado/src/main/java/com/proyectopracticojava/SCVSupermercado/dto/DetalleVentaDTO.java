package com.proyectopracticojava.SCVSupermercado.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetalleVentaDTO {

    private Long id;
    private String nombreProducto;
    private Double cantidad;
    private Double precio;
    private Double subtotal;
}
