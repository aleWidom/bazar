package com.tabajofinal.bazar.service;

import com.tabajofinal.bazar.model.Producto;

import java.util.List;

public interface IProductoService {
    List<Producto> verProductos();

    Producto verProducto(Long codigoProducto);

    void crearProducto(Producto producto);

    void editarProducto(Producto producto, Long codigoProducto);

    void eliminarProducto(Long codigoProducto);

    List<Producto> verProductosConPocoStock();
}
