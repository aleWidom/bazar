package com.tabajofinal.bazar.controller;

import com.tabajofinal.bazar.model.Cliente;
import com.tabajofinal.bazar.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    @GetMapping("/clientes")
    public List<Cliente> verClientes() {
         return clienteService.verClientes();
    }

    @GetMapping("/clientes/{idCliente}")
    public Cliente verCliente(@PathVariable Long idCliente) {
        return clienteService.verCliente(idCliente);
    }

    @PostMapping("/clientes/crear")
    public void crearCliente(@RequestBody Cliente cliente) {
        clienteService.crearCliente(cliente);
    }

    @PutMapping("/clientes/editar/{idCliente}")
    public void editarCliente(@RequestBody Cliente cliente, @PathVariable Long idCliente) {
        clienteService.editarCliente(cliente,idCliente);
    }

    @DeleteMapping("/clientes/eliminar/{idCliente}")
    public void eliminarCliente(@PathVariable Long idCliente) {
        clienteService.eliminarCliente(idCliente);
    }


}
