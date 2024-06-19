package com.tabajofinal.bazar.service;

import com.tabajofinal.bazar.model.Producto;
import com.tabajofinal.bazar.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService implements IProductoService {
    @Autowired
    private IProductoRepository productoRepository;

    @Override
    public List<Producto> verProductos() {
         return productoRepository.findAll();
    }

    @Override
    public Producto verProducto(Long codigoProducto) {
        return productoRepository.findById(codigoProducto).orElse(null);
    }

    @Override
    public void crearProducto(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public void editarProducto(Producto producto, Long codigoProducto) {
        productoRepository.save(producto);
    }

    @Override
    public void eliminarProducto(Long codigoProducto) {
        productoRepository.deleteById(codigoProducto);
    }

    @Override
    public List<Producto> verProductosConPocoStock() {
        List<Producto> listaProductos = this.verProductos();
        List<Producto> listaProductosPocoStock = new ArrayList<Producto>();

        for(Producto producto: listaProductos) {
            if(producto.getCantidad_disponible() < 5) {
                listaProductosPocoStock.add(producto);
            }
        }

        return  listaProductosPocoStock;
    }
}
