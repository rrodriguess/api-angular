package br.com.renato.ws.service;

import br.com.renato.ws.domain.Cliente;
import br.com.renato.ws.domain.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    //*********************************************LOG. NEGÓCIOS*****************************
    public Cliente cadastrar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Collection<Cliente> buscaTodos(){
        return clienteRepository.findAll();
    }

    public void excluir (Cliente cliente) {
        clienteRepository.delete(cliente);
    }

    public Cliente buscaPorId(Integer id) {
        return clienteRepository.findOne(id);
    }

    public Cliente alterar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
}
