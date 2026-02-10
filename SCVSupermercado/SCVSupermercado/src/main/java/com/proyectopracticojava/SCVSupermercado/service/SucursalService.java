package com.proyectopracticojava.SCVSupermercado.service;

import com.proyectopracticojava.SCVSupermercado.dto.SucursalDTO;
import com.proyectopracticojava.SCVSupermercado.exception.NotFoundException;
import com.proyectopracticojava.SCVSupermercado.mapper.Mapper;
import com.proyectopracticojava.SCVSupermercado.model.Sucursal;
import com.proyectopracticojava.SCVSupermercado.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SucursalService implements ISucursalService {

    @Autowired
    private SucursalRepository sucursalRepository;

    @Override
    public List<SucursalDTO> traerSucursales() {
        return sucursalRepository.findAll()
                .stream()
                .map(Mapper::toDTO)
                .toList();
    }

    @Override
    public SucursalDTO crearSucursal(SucursalDTO sucursaldto) {
        Sucursal sucursal = Sucursal.builder()
                .nombre(sucursaldto.getNombre())
                .direccion(sucursaldto.getDireccion())
                .build();
        return Mapper.toDTO(sucursalRepository.save(sucursal));
    }

    @Override
    public SucursalDTO actualizarSucursal(Long id, SucursalDTO sucursaldto) {
        Sucursal sucursal = sucursalRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Sucursal no encontrado"));

        sucursal.setNombre(sucursaldto.getNombre());
        sucursal.setDireccion(sucursaldto.getDireccion());
        return Mapper.toDTO(sucursalRepository.save(sucursal));

    }


    @Override
    public void eliminarSucursal(Long id) {
        if (sucursalRepository.existsById(id))
            throw new NotFoundException("Sucursal no encontrado");

        sucursalRepository.deleteById(id);
    }
}
