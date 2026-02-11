package com.proyectopracticojava.SCVSupermercado.controller;

import com.proyectopracticojava.SCVSupermercado.dto.VentaDTO;
import com.proyectopracticojava.SCVSupermercado.service.IVentaService;
import com.proyectopracticojava.SCVSupermercado.service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/ventas")
public class VentaController {

    @Autowired
    private IVentaService ventaService;
    @Autowired
    private SucursalService sucursalService;

    @GetMapping
    public ResponseEntity<List<VentaDTO>> traerVentas(){
        return ResponseEntity.ok(ventaService.traerVenta());

    }

    @PostMapping
    public ResponseEntity<VentaDTO> create(@RequestBody VentaDTO ventaDTO){
        VentaDTO created = ventaService.crearVenta(ventaDTO);
        return ResponseEntity.created(URI.create("/api/ventas" + created.getId()))
                .body(created);
    }

    @PutMapping("{id}")
    public VentaDTO actualizar(@PathVariable Long id, @RequestBody VentaDTO ventaDTO){
        return ventaService.actualizarVenta(id, ventaDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<VentaDTO> delete(@PathVariable Long id){
        ventaService.eliminarVenta(id);
        return ResponseEntity.noContent().build();
    }

}
