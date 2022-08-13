/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

//    @Test
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

    @Test
    public void testPesquisarPorId() throws Exception {
        System.out.println("pesquisarPorId");
        buscarUsuarioBD();
        Client usuarioPesquisado = clientDao.pesquisarPorId(client.getId());
        assertNotNull(usuarioPesquisado);
        System.out.println(client.toString());
    }

    public Client buscarUsuarioBD() throws Exception {
        String sql = "select * from client";
        Connection conn = FabricaConexao.abrirConexao();
        PreparedStatement prepara = conn.prepareStatement(sql);
        ResultSet rs = prepara.executeQuery();

        if (rs.next()) {
            client = new Client();
            client.setId(rs.getInt("id"));
            client.setNome(rs.getString("nome"));
            client.setCpf(rs.getString("cpf"));
            client.setRg(rs.getString("rg"));
            client.setSalario(rs.getDouble("salario"));
        } else {
            testSalvar();
        }
        return client;
    }
}
