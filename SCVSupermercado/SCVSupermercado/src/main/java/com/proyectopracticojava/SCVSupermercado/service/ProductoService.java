package com.proyectopracticojava.SCVSupermercado.service;

import com.proyectopracticojava.SCVSupermercado.dto.ProductoDTO;
import com.proyectopracticojava.SCVSupermercado.mapper.Mapper;
import com.proyectopracticojava.SCVSupermercado.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private ProductoRepository repositorio;

    @Override
    public List<ProductoService> traerProducto() {
        return repositorio.findAll().stream().map(Mapper::toDTO).toList();
    }

    @Override
    public ProductoDTO crearProducto(ProductoDTO productodto) {
        return null;
    }

    @Override
    public ProductoDTO actualizarProducto(Long id, ProductoDTO productodto) {
        return null;
    }

    @Override
    public void eliminarProducto(Long id) {

    }
}
