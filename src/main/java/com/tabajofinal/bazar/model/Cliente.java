package com.tabajofinal.bazar.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_cliente;
    private String nombre;
    private String apellido;
    private String dni;
    @OneToMany (mappedBy = "unCliente")
    private List<Venta> listaVentas;


    public Cliente() {
    }

    public Cliente(Long id_cliente, String nombre, String apellido, String dni, List<Venta> listaVentas) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.listaVentas = listaVentas;
    }
}
