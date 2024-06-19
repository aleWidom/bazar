package com.tabajofinal.bazar.controller;

import com.tabajofinal.bazar.model.Producto;
import com.tabajofinal.bazar.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @GetMapping("/productos")
    public List<Producto> verProductos() {
        return productoService.verProductos();
    }

    @GetMapping("/productos/{codigoProducto}")
    public Producto verProducto(@PathVariable Long codigoProducto) {
        return productoService.verProducto(codigoProducto);
    }

    @PostMapping("/productos/crear")
    public void crearProducto(@RequestBody Producto producto) {
        productoService.crearProducto(producto);
    }

    @PutMapping("/productos/editar/{codigoProducto}")
    public void editarProducto(@RequestBody Producto producto, @PathVariable Long codigoProducto) {
        productoService.editarProducto(producto,codigoProducto);
    }

    @DeleteMapping("/productos/eliminar/{codigoProducto}")
    public void eliminarProducto(@PathVariable Long codigoProducto) {
        productoService.eliminarProducto(codigoProducto);
    }

    @GetMapping("/productos/falta_stock")
    public List<Producto> verProductosConPocoStock() {
        return productoService.verProductosConPocoStock();
    }


}
