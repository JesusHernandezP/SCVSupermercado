package com.proyectopracticojava.SCVSupermercado.controller;


import com.proyectopracticojava.SCVSupermercado.dto.SucursalDTO;
import com.proyectopracticojava.SCVSupermercado.service.ISucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/sucursales")

public class SucursalController {

    @Autowired
    private ISucursalService sucursalService;

    @GetMapping
    public ResponseEntity<List<SucursalDTO>> traerSucursales(){
        return ResponseEntity.ok(sucursalService.traerSucursales());

    }

    @PostMapping
    public ResponseEntity<SucursalDTO> crearSucursal(@RequestBody SucursalDTO sucursalDTO){
        SucursalDTO created = sucursalService.crearSucursal(sucursalDTO);
                return ResponseEntity.created(URI.create("/api/sucursales" + created.getId()))
                        .body(created);
    }

    @PutMapping("{id}")
    public ResponseEntity<SucursalDTO> update(@PathVariable Long id, @RequestBody SucursalDTO sucursalDTO){
        return ResponseEntity.ok(sucursalService.actualizarSucursal(id, sucursalDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        sucursalService.eliminarSucursal(id);
        return ResponseEntity.noContent().build();
    }
}
