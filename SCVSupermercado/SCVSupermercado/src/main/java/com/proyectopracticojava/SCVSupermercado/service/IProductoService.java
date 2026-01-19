package com.proyectopracticojava.SCVSupermercado.service;

import com.proyectopracticojava.SCVSupermercado.dto.ProductoDTO;
import com.proyectopracticojava.SCVSupermercado.dto.VentaDTO;

import java.util.List;

public interface IProductoService {
    List<ProductoService> traerProducto();
    ProductoDTO crearProducto(  ProductoDTO productodto);
    ProductoDTO actualizarProducto(Long id, ProductoDTO productodto);
    void eliminarProducto(Long id);
}
