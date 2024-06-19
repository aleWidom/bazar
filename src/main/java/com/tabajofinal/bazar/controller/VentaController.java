package com.tabajofinal.bazar.controller;

import com.tabajofinal.bazar.dto.VentaDTO;
import com.tabajofinal.bazar.dto.VentaFechaDTO;
import com.tabajofinal.bazar.dto.VentaMayorDTO;
import com.tabajofinal.bazar.model.Producto;
import com.tabajofinal.bazar.model.Venta;
import com.tabajofinal.bazar.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class VentaController {

    @Autowired
    private IVentaService ventaService;

    @GetMapping("/ventas")
    public List<Venta> verVentas() {
       return ventaService.verVentas();
    }

    @GetMapping("/ventas/{codigoVenta}")
    public Venta verVenta(@PathVariable Long codigoVenta) {
        return ventaService.verVenta(codigoVenta);
    }

    @GetMapping("/ventas/fecha/{fechaVenta}")
    public VentaFechaDTO verFechaVenta(@PathVariable LocalDate fechaVenta) {
        return ventaService.verFechaVenta(fechaVenta);
    }

    @GetMapping("/ventas/mayorVenta")
    public VentaMayorDTO mayorVenta() {
        return ventaService.mayorVenta();
    }


    @GetMapping("/ventas/productos/{codigoVenta}")
    public VentaDTO verVentaListaProductos(@PathVariable Long codigoVenta) {
        return ventaService.verVentaListaProductos(codigoVenta);
    }

    @PostMapping("/ventas/crear")
    public void crearVenta(@RequestBody Venta venta) {
        ventaService.crearVenta(venta);
    }

    @PutMapping("/ventas/editar/{codigoVenta}")
    public void editarVenta(@RequestBody Venta venta, @PathVariable Long codigoVenta) {
        ventaService.editarVenta(venta,codigoVenta);
    }

    @DeleteMapping("/ventas/eliminar/{codigoVenta}")
    public void eliminarVenta(@PathVariable Long codigoVenta) {
        ventaService.eliminarVenta(codigoVenta);
    }


}
