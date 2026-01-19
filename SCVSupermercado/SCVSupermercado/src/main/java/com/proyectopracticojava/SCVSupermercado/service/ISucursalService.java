package com.proyectopracticojava.SCVSupermercado.service;

import com.proyectopracticojava.SCVSupermercado.dto.SucursalDTO;
import com.proyectopracticojava.SCVSupermercado.model.Sucursal;


import java.util.List;

public interface ISucursalService {

    List<SucursalDTO> traerSucursales();
    SucursalDTO crearSucursal(SucursalDTO sucursaldto);
    SucursalDTO actualizarSucursal(Long id, SucursalDTO sucursaldto);
    void eliminarSucursal(Long id);
}
