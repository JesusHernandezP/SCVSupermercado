package com.proyectopracticojava.SCVSupermercado.repository;

import com.proyectopracticojava.SCVSupermercado.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    //Buscar un producto por nombre


        Optional<Producto> findByNombre(String nombre);
}

