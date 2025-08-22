package com.api.unipar.controller;

import com.api.unipar.entidades.Cliente;
import com.api.unipar.service.ClienteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClientesController {

    private final ClienteService clienteService;

    public ClientesController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/listar")
    public List<Cliente> listarTodosClientes() {
        return clienteService.listarTodosCLientes();
    }
    
    @PostMapping("/salvar-cliente")
    public Cliente salvarCliente(@RequestBody Cliente cliente){
        return clienteService.salvarCliente(cliente);
    }
    
    @GetMapping("/buscar-cliente/{id}")
    public Cliente buscarClientePorId(@PathVariable Long id){
        return clienteService.buscarClientePorId(id);
    }
    
    @PutMapping("/atualizar-cliente/{id}")
    public Cliente atualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente){
        return clienteService.atualizarCliente(id, cliente);
    }
    
    @DeleteMapping("/deletar-cliente/{id}")
    public void deletarClientePorId(@PathVariable Long id)
    {
        clienteService.deletarClientePorId(id);
    }
}
