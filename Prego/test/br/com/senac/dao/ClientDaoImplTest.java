/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Client;
import org.junit.Test;
import static org.junit.Assert.*;
import util.Gerador;

/**
 *
 * @author jonathan.costa1
 */
public class ClientDaoImplTest {
    
    private Client client;
    private ClientDao clientDao;
    
    public ClientDaoImplTest() {
        clientDao = new ClientDaoImpl();
    }
    
    @Test
    public void testSalvar() throws Exception {
        System.out.println("salvar");
        client = new Client(
                Gerador.gerarNome(),
                Gerador.gerarCpf(),
                Gerador.gerarCep(),
                Double.valueOf(Gerador.gerarNumero(8))
        );
        clientDao.salvar(client);
        assertNotNull(client.getId());
    }
    
}
