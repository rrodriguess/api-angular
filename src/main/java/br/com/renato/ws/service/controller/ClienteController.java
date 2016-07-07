package br.com.renato.ws.service.controller;

import br.com.renato.ws.domain.Cliente;
import br.com.renato.ws.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService service;

    //************************************* END POINTS **************************************************************
    @RequestMapping(method = RequestMethod.POST, value = "/clientes", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {
        Cliente clienteCadastrado = service.cadastrar(cliente);

        return new ResponseEntity<Cliente>(clienteCadastrado, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Cliente>> buscarTodosClientes() {
        Collection<Cliente> clientesBuscados = service.buscaTodos();

        return new ResponseEntity<>(clientesBuscados, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/clientes/{id}")
    public ResponseEntity<Cliente> removerCliente(@PathVariable Integer id) {
        Cliente clienteEncontrado = service.buscaPorId(id);

        if (clienteEncontrado == null)
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);

        service.excluir(clienteEncontrado);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/clientes", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> alterarCliente(@RequestBody Cliente cliente) {
        Cliente clienteAlterado = service.alterar(cliente);

        return new ResponseEntity<Cliente>(clienteAlterado, HttpStatus.OK);
    }

}
