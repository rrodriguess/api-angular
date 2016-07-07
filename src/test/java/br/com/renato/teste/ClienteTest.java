package br.com.renato.teste;

import br.com.renato.ws.domain.Cliente;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by renato on 04/07/16.
 */
public class ClienteTest {

    Map<Integer, Cliente> clientes;

    Integer proximoId = 0;

    Cliente cliente;

    @Before
    public void novoCliente() {
        cliente = new Cliente();
        cliente.setId(1);
        cliente.setNome("Jão");
    }

    @Test
    public void testaListaCliente() {
        Cliente clienteCadastrado = cadastrar(cliente);
    }

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

}
