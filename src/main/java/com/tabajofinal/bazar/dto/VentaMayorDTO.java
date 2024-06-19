package com.tabajofinal.bazar.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VentaMayorDTO {
    private Long codigoVenta;
    private double total;
    private int cantidadProudctos;
    private String nombreCliente;
    private String apellidoCliente;

    public VentaMayorDTO() {
    }

    public VentaMayorDTO(Long codigoVenta, double total, int cantidadProudctos, String nombreCliente, String apellidoCliente) {
        this.codigoVenta = codigoVenta;
        this.total = total;
        this.cantidadProudctos = cantidadProudctos;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
    }
}
