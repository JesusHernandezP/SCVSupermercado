package com.proyectopracticojava.SCVSupermercado.dto;

import jdk.jshell.Snippet;
import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductoDTO {

    private Long id;
    private String nombre;
    private String categoria;
    private double precio;
    private int cantidad;


}
