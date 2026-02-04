package com.proyectopracticojava.SCVSupermercado.service;

import com.proyectopracticojava.SCVSupermercado.dto.ProductoDTO;
import com.proyectopracticojava.SCVSupermercado.exception.NotFoundException;
import com.proyectopracticojava.SCVSupermercado.mapper.Mapper;
import com.proyectopracticojava.SCVSupermercado.model.Producto;
import com.proyectopracticojava.SCVSupermercado.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private ProductoRepository repositorio;

    @Override
    public List<ProductoDTO> traerProducto() {
        return repositorio.findAll().stream().map(Mapper::toDTO).toList();
    }

    @Override
    public ProductoDTO crearProducto(ProductoDTO productoDto) {
        Producto prod = Producto.builder()
                .nombre(productoDto.getNombre())
                .categoria(productoDto.getCategoria())
                .precio(productoDto.getPrecio())
                .cantidad(productoDto.getCantidad())
                .build();
        return Mapper.toDTO(repositorio.save(prod));

    }

    @Override
    public ProductoDTO actualizarProducto(Long id, ProductoDTO productodto) {
        Producto prod = repositorio.findById(id)
                .orElseThrow(() -> new NotFoundException("Producto no encontrado"));

        prod.setNombre(productodto.getNombre());
        prod.setCategoria(productodto.getCategoria());
        prod.setCantidad(productodto.getCantidad());
        prod.setPrecio(productodto.getPrecio());

        return Mapper.toDTO(repositorio.save(prod));
    }

    @Override
    public void eliminarProducto(Long id) {

        if (!repositorio.existsById(id)) {
            throw new NotFoundException("Producto no encontrado para ser eliminado");
        }
        repositorio.deleteById(id);

    }
}
