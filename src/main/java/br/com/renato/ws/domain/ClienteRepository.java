package br.com.renato.ws.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by renato on 08/07/16.
 * Classe Reponsável por controlar acessos ao Banco
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
}
