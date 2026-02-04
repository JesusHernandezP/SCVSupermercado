package com.proyectopracticojava.SCVSupermercado.service;

import com.proyectopracticojava.SCVSupermercado.dto.ProductoDTO;

import java.util.List;

public interface IProductoService {
    List<ProductoDTO> traerProducto();
    ProductoDTO crearProducto(  ProductoDTO productodto);
    ProductoDTO actualizarProducto(Long id, ProductoDTO productodto);
    void eliminarProducto(Long id);
}
