package br.com.renato.ws.service;

import br.com.renato.ws.domain.Cliente;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ClienteService {

    Map<Integer, Cliente> clientes = new HashMap<>();
    Integer proximoId = 0;

    //*********************************************LOG. NEGÓCIOS*****************************
    public Cliente cadastrar(Cliente cliente) {
        cliente.setId(proximoId);
        proximoId++;

        clientes.put(cliente.getId(), cliente);

        return cliente;
    }

    public Collection<Cliente> buscaTodos(){
        return clientes.values();
    }

    public void excluir (Cliente cliente) {
        clientes.remove(cliente.getId());
    }

    public Cliente buscaPorId(Integer id) {
        return clientes.get(id);
    }

    public Cliente alterar(Cliente cliente) {
        clientes.put(cliente.getId(), cliente);
        return cliente;
    }
}
