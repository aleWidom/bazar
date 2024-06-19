package com.tabajofinal.bazar.service;

import com.tabajofinal.bazar.dto.VentaDTO;
import com.tabajofinal.bazar.dto.VentaFechaDTO;
import com.tabajofinal.bazar.dto.VentaMayorDTO;
import com.tabajofinal.bazar.model.Venta;

import java.time.LocalDate;
import java.util.List;

public interface IVentaService {
    List<Venta> verVentas();

    Venta verVenta(Long codigoVenta);

    void crearVenta(Venta venta);

    void editarVenta(Venta venta, Long codigoVenta);

    void eliminarVenta(Long codigoVenta);

    VentaDTO verVentaListaProductos(Long codigoVenta);

    VentaFechaDTO verFechaVenta(LocalDate fechaVenta);

    VentaMayorDTO mayorVenta();
}
