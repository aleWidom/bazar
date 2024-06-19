package com.tabajofinal.bazar.service;

import com.tabajofinal.bazar.model.Cliente;

import java.util.List;

public interface IClienteService {
    List<Cliente> verClientes();

    Cliente verCliente(Long idCliente);

    void crearCliente(Cliente cliente);

    void editarCliente(Cliente cliente, Long idCliente);

    void eliminarCliente(Long idCliente);
}
