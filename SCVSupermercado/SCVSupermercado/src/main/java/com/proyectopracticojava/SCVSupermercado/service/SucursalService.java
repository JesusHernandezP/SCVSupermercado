package com.proyectopracticojava.SCVSupermercado.service;

import com.proyectopracticojava.SCVSupermercado.dto.SucursalDTO;
import com.proyectopracticojava.SCVSupermercado.model.Sucursal;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SucursalService implements ISucursalService {
    @Override
    public List<SucursalDTO> traerSucursales() {
        return List.of();
    }

    @Override
    public SucursalDTO crearSucursal(SucursalDTO sucursaldto) {
        return null;
    }

    @Override
    public SucursalDTO actualizarSucursal(Long id, SucursalDTO sucursaldto) {
        return null;
    }

    @Override
    public void eliminarSucursal(Long id) {

    }
}
