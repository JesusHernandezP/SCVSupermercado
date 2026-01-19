package com.proyectopracticojava.SCVSupermercado.repository;

import com.proyectopracticojava.SCVSupermercado.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
