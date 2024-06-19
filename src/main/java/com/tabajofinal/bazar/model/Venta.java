package com.tabajofinal.bazar.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@Entity
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long codigo_venta;
    private LocalDate fecha_venta;
    private Double total;
    @ManyToOne
    @JoinColumn(name="cliente_id")
    private Cliente unCliente;
    @ManyToMany
    @JoinTable(
            name = "venta_producto",
            joinColumns = { @JoinColumn(name = "venta_id") },
            inverseJoinColumns = { @JoinColumn(name = "producto_id") }
    )
    private List<Producto> listaProductos;

    public Venta() {
    }

    public Venta(Long codigo_venta, LocalDate fecha_venta, Double total, List<Producto> listaProductos, Cliente unCliente) {
        this.codigo_venta = codigo_venta;
        this.fecha_venta = fecha_venta;
        this.total = total;
        this.listaProductos = listaProductos;
        this.unCliente = unCliente;
    }


}
