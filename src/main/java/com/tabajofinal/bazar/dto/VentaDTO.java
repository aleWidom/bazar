package com.tabajofinal.bazar.dto;

import com.tabajofinal.bazar.model.Producto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class VentaDTO {
    private Long codigo_venta;
    private List<Producto> listaProductos;

    public VentaDTO() {
    }

    public VentaDTO(Long codigo_venta, List<Producto> listaProductos) {
        this.codigo_venta = codigo_venta;
        this.listaProductos = listaProductos;
    }
}
