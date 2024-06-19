package com.tabajofinal.bazar.service;

import com.tabajofinal.bazar.model.Cliente;
import com.tabajofinal.bazar.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService {
    @Autowired
    private IClienteRepository clienteRepository;

    @Override
    public List<Cliente> verClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente verCliente(Long idCliente) {
        return clienteRepository.findById(idCliente).orElse(null);
    }

    @Override
    public void crearCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public void editarCliente(Cliente cliente, Long idCliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public void eliminarCliente(Long idCliente) {
        clienteRepository.deleteById(idCliente);
    }
}
