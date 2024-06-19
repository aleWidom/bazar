package com.tabajofinal.bazar.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VentaFechaDTO {
    private Double monto;
    private int cantidad;

    public VentaFechaDTO() {
    }

    public VentaFechaDTO(Double monto, int cantidad) {
        this.monto = monto;
        this.cantidad = cantidad;
    }
}
