package com.tabajofinal.bazar.service;

import com.tabajofinal.bazar.dto.VentaDTO;
import com.tabajofinal.bazar.dto.VentaFechaDTO;
import com.tabajofinal.bazar.dto.VentaMayorDTO;
import com.tabajofinal.bazar.model.Venta;
import com.tabajofinal.bazar.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VentaService implements IVentaService {
    @Autowired
    private IVentaRepository ventaRepository;

    @Override
    public List<Venta> verVentas() {
        return ventaRepository.findAll();
    }

    @Override
    public Venta verVenta(Long codigoVenta) {
        return ventaRepository.findById(codigoVenta).orElse(null);
    }

    @Override
    public void crearVenta(Venta venta) {
        ventaRepository.save(venta);
    }

    @Override
    public void editarVenta(Venta venta, Long codigoVenta) {
        ventaRepository.save(venta);
    }

    @Override
    public void eliminarVenta(Long codigoVenta) {
        ventaRepository.deleteById(codigoVenta);
    }

    @Override
    public VentaDTO verVentaListaProductos(Long codigoVenta) {
        Venta verVenta = this.verVenta(codigoVenta);

        VentaDTO verVentaConListaProductos= new VentaDTO();

        verVentaConListaProductos.setCodigo_venta(verVenta.getCodigo_venta());
        verVentaConListaProductos.setListaProductos(verVenta.getListaProductos());

        return verVentaConListaProductos;
    }

    @Override
    public VentaFechaDTO verFechaVenta(LocalDate fechaVenta) {

        VentaFechaDTO ventaFechaDTO = new VentaFechaDTO();

        List<Venta> listadoVentas= this.verVentas();

        Double monto = 0.0;
        int cantidad = 0;

        for(Venta venta: listadoVentas) {
            if (venta.getFecha_venta().equals(fechaVenta)) {
                monto +=  venta.getTotal();
                cantidad += 1;
            }
        }

        ventaFechaDTO.setMonto(monto);
        ventaFechaDTO.setCantidad(cantidad);

        return ventaFechaDTO;
    }

    @Override
    public VentaMayorDTO mayorVenta() {
        VentaMayorDTO ventaMayorDTO = new VentaMayorDTO();

        List<Venta> listaVentas = this.verVentas();

        for(int i = 0; i < listaVentas.size(); i++) {
            if(i==0) {
                ventaMayorDTO.setCodigoVenta(listaVentas.get(i).getCodigo_venta());
                ventaMayorDTO.setTotal(listaVentas.get(i).getTotal());
                ventaMayorDTO.setCantidadProudctos(listaVentas.get(i).getListaProductos().size());
                ventaMayorDTO.setNombreCliente(listaVentas.get(i).getUnCliente().getNombre());
                ventaMayorDTO.setApellidoCliente(listaVentas.get(i).getUnCliente().getApellido());
            } else {
                if(listaVentas.get(i).getTotal() > listaVentas.get(i-1).getTotal()) {
                    ventaMayorDTO.setCodigoVenta(listaVentas.get(i).getCodigo_venta());
                    ventaMayorDTO.setTotal(listaVentas.get(i).getTotal());
                    ventaMayorDTO.setCantidadProudctos(listaVentas.get(i).getListaProductos().size());
                    ventaMayorDTO.setNombreCliente(listaVentas.get(i).getUnCliente().getNombre());
                    ventaMayorDTO.setApellidoCliente(listaVentas.get(i).getUnCliente().getApellido());
                }
            }

        }

        return ventaMayorDTO;

    }
}
