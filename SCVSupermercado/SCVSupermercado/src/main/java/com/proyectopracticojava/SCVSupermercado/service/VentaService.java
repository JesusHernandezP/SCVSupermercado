package com.proyectopracticojava.SCVSupermercado.service;

import com.proyectopracticojava.SCVSupermercado.dto.DetalleVentaDTO;
import com.proyectopracticojava.SCVSupermercado.dto.VentaDTO;
import com.proyectopracticojava.SCVSupermercado.exception.NotFoundException;
import com.proyectopracticojava.SCVSupermercado.mapper.Mapper;
import com.proyectopracticojava.SCVSupermercado.model.DetalleVenta;
import com.proyectopracticojava.SCVSupermercado.model.Producto;
import com.proyectopracticojava.SCVSupermercado.model.Sucursal;
import com.proyectopracticojava.SCVSupermercado.model.Venta;
import com.proyectopracticojava.SCVSupermercado.repository.ProductoRepository;
import com.proyectopracticojava.SCVSupermercado.repository.SucursalRepository;
import com.proyectopracticojava.SCVSupermercado.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VentaService implements IVentaService {

    @Autowired
    private VentaRepository ventaRepository;
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private SucursalRepository sucursalRepository;

    @Override
    public List<VentaDTO> traerVenta() {

        List<Venta> ventas = ventaRepository.findAll();
        List<VentaDTO> ventasDTO = new ArrayList<>();

        for (Venta venta : ventas) {
            VentaDTO ventaDTO = Mapper.toDTO(venta);
            ventasDTO.add(ventaDTO);
        }
        return ventasDTO;

    }

    @Override
    public VentaDTO crearVenta(VentaDTO ventadto) {

        //Validaciones
        if (ventadto == null) throw new RuntimeException("El ventaDTO es null.");
        if (ventadto.getIdSucursal() == null) throw new RuntimeException("Debe indicar la sucursal");
        if (ventadto.getDetalle() == null || ventadto.getDetalle().isEmpty())
            throw new RuntimeException("Debe incluir al menos un producto.");

        //Buscar la sucursal
        Sucursal sucursal = sucursalRepository.findById(ventadto.getIdSucursal()).orElse(null);
        if (sucursal == null) {
            throw new NotFoundException("La sucursal no existe");
        }

        //Crear la venta
        Venta venta = new Venta();
        venta.setFecha(ventadto.getFecha());
        venta.setEstado(ventadto.getEstado());
        venta.setSucursal(sucursal);
        venta.setTotal(ventadto.getTotal());


        //La lista de detalles
        //Productos

        List<DetalleVenta> detalles = new ArrayList<>();

        for (DetalleVentaDTO detalleVentaDTO : ventadto.getDetalle()) {
            //Buscar producto por id
            Producto p = productoRepository.findByNombre(detalleVentaDTO.getNombreProducto()).orElse(null);
            if (p == null)
                throw new RuntimeException("No existe el producto" +  detalleVentaDTO.getNombreProducto());

        //Crear detalle
        DetalleVenta detalle = new DetalleVenta();
        detalle.setProducto(p);
        detalle.setPrecio(detalleVentaDTO.getPrecio());
        detalle.setCantidad(detalleVentaDTO.getCantidad());
        detalle.setVenta(venta);

        detalles.add(detalle);
        }

        venta.setDetalle(detalles);

        //Guardamos a la BD
        ventaRepository.save(venta);

        //Mapeo de salida

        VentaDTO ventaSalida = Mapper.toDTO(venta);
        return ventaSalida;
    }

    @Override
    public VentaDTO actualizarVenta(Long id, VentaDTO ventadto) {
        Venta venta = ventaRepository.findById(id).orElse(null);
        if (venta == null) throw new RuntimeException("La venta no existe");

        if (ventadto.getFecha() != null){
            venta.setFecha(ventadto.getFecha());
        }
        if (ventadto.getEstado() != null){
            venta.setEstado(ventadto.getEstado());
        }
        if (ventadto.getTotal() != null){
            venta.setTotal(ventadto.getTotal());
        }
        if (ventadto.getIdSucursal() != null){
            Sucursal sucursal = sucursalRepository.findById(ventadto.getIdSucursal()).orElse(null);
            if (sucursal == null) throw new NotFoundException("La sucursal no existe");
            venta.setSucursal(sucursal);

        }
        ventaRepository.save(venta);
        VentaDTO ventaSalida = Mapper.toDTO(venta);

        return null;
    }

    @Override
    public void eliminarVenta(Long id) {

        Venta venta = ventaRepository.findById(id).orElse(null);
        if (venta == null) throw new RuntimeException("La venta no existe");
        ventaRepository.delete(venta);



    }
}
