package com.proyectopracticojava.SCVSupermercado.service;

import com.proyectopracticojava.SCVSupermercado.dto.VentaDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService implements IVentaService {
    @Override
    public List<VentaDTO> traerVenta() {
        return List.of();
    }

    @Override
    public VentaDTO crearVenta(VentaDTO ventadto) {
        return null;
    }

    @Override
    public VentaDTO actualizarVenta(Long id, VentaDTO ventadto) {
        return null;
    }

    @Override
    public void eliminarVenta(Long id) {

    }
}
