package com.proyectopracticojava.SCVSupermercado.service;

import com.proyectopracticojava.SCVSupermercado.dto.SucursalDTO;
import com.proyectopracticojava.SCVSupermercado.dto.VentaDTO;
import com.proyectopracticojava.SCVSupermercado.model.Sucursal;

import java.util.List;

public interface IVentaService {

    List<VentaDTO> traerVenta();
    VentaDTO crearVenta(VentaDTO ventadto);
    VentaDTO actualizarVenta(Long id, VentaDTO ventadto);
    void eliminarVenta(Long id);
}
