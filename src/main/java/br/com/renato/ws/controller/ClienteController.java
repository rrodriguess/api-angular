package br.com.renato.ws.controller;

import br.com.renato.ws.model.Cliente;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ClienteController {

    Map<Integer, Cliente> clientes;

    Integer proximoId = 0;

    //Negocios
    private Cliente cadastrar(Cliente cliente) {

        if (clientes == null )
            clientes = new HashMap<>();

        cliente.setId(proximoId);
        proximoId++;

        clientes.put(cliente.getId(), cliente);

        return cliente;
    }

    private Collection<Cliente> buscaTodos(){
        return clientes.values();
    }

    //EndPoints
    @RequestMapping(method = RequestMethod.POST, value = "/clientes", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {
        Cliente clienteCadastrado = cadastrar(cliente);

        return new ResponseEntity<Cliente>(clienteCadastrado, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Cliente>> buscarTodosClientes() {
        Collection<Cliente> clientesBuscados = buscaTodos();

        return new ResponseEntity<>(clientesBuscados, HttpStatus.OK);
    }
}
