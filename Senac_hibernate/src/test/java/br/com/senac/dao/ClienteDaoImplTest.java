/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Cliente;
import static br.com.senac.util.Geradores.*;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import static org.junit.Assert.*;
import org.junit.Test;



/**
 *
 * @author jonathan.costa1
 */
public class ClienteDaoImplTest {

    private Cliente cliente;
    private final ClienteDao clienteDao;
    private Session sessao;

    public ClienteDaoImplTest() {
        clienteDao = new ClienteDaoImpl();
    }

    @Test
    public void testSalvar() {

        System.out.println("salvar");
        cliente = new Cliente(gerarNome(), gerarCpf(), gerarCep(), Double.valueOf(gerarNumero(8)));
        sessao = HibernateUtil.abrirConexao();
        clienteDao.salvarOuAlterar(cliente, sessao);
        sessao.close();
        assertNotNull(cliente.getId());

    }

    @Test
    public void testAlterar() {

        System.out.println("alterar");
        buscarUsuarioBd();

        System.out.println("Nome ANTIGO: " + cliente.toString());

        sessao = HibernateUtil.abrirConexao();
        cliente.setNome(gerarNome2());
        clienteDao.salvarOuAlterar(cliente, sessao);
        String novoNome = gerarNome2();
        sessao.close();
        assertNotEquals(cliente, novoNome);

        System.out.println("Nome NOVO  : " + cliente.toString());
    }

    @Test
    public void testPesquisarPorId() {
        System.out.println("testPesquisarPorId");
        buscarUsuarioBd();
        sessao = HibernateUtil.abrirConexao();
        Cliente usuarioPesq = clienteDao.pesquisarPorId(cliente.getId(), sessao);
        sessao.close();
        assertNotNull(usuarioPesq);

    }

    @Test
    public void testPesquisarPorNome() {
        System.out.println("testPesquisarPorNome");
        buscarUsuarioBd();
        sessao = HibernateUtil.abrirConexao();
        List<Cliente> usuarioNome = clienteDao.pesquisarPorCliente(cliente.getNome(), sessao);
        sessao.close();
        assertTrue(!usuarioNome.isEmpty());
        System.out.println(usuarioNome);
    }

    @Test
    public void testPesquisarTodos() {
        System.out.println("testPesquisarTodos");
        buscarUsuarioBd();
        sessao = HibernateUtil.abrirConexao();
        List<Cliente> pesquisarTodos = clienteDao.pesquisarTodos(sessao);
        sessao.close();
        assertTrue(!pesquisarTodos.isEmpty());
        System.out.println(pesquisarTodos);

    }

    @Test
    public void testPesquisarTodoss() {
        System.out.println("testPesquisarTodoss");
        buscarUsuarioBd();
        sessao = HibernateUtil.abrirConexao();
        List<Cliente> pesquisarTodos = clienteDao.pesquisarTodos(sessao);

        mostrarPorSqlImpl(pesquisarTodos);

        sessao.close();
        assertTrue(!pesquisarTodos.isEmpty());

    }

    private void mostrarComStream(List<Cliente> pesquisarTodos) {
        pesquisarTodos.stream().sorted((usu1, usu2) -> usu1.getNome().compareTo(usu2.getNome())).forEach(pesquisarTudo
                -> {
            System.out.println(pesquisarTudo);
            System.out.println(" ");
        });
    }

    private void mostrarPorSqlImpl(List<Cliente> pesquisarTodos) {
        pesquisarTodos.forEach(pesquisarTudo
                -> {
            System.out.println(pesquisarTudo);
            System.out.println(" ");
        });
    }

    @Test
    public void testExcluir() {
        System.out.println("excluir");
        buscarUsuarioBd();
        sessao = HibernateUtil.abrirConexao();
        clienteDao.excluir(cliente, sessao);

        Cliente usuarioExcluido = clienteDao.pesquisarPorId(cliente.getId(), sessao);

        assertNull(usuarioExcluido);

    }

    public Cliente buscarUsuarioBd() {

        System.out.println("pesquisarPorId");
        sessao = HibernateUtil.abrirConexao();
        Query<Cliente> consulta = sessao.createQuery("from Cliente c");
        List<Cliente> clientes = consulta.getResultList();
        sessao.close();

        if (clientes.isEmpty()) {
            testSalvar();
        } else {
            cliente = clientes.get(0);
        }

        return cliente;

    }

}
