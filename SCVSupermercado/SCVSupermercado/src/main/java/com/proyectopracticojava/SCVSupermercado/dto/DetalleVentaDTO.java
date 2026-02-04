package com.proyectopracticojava.SCVSupermercado.dto;

import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetalleVentaDTO {

    private Long id;
    private String nombreProducto;
    private Double cantidad;
    private Double precio;
    private Double subtotal;
}
