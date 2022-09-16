/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Usuario;
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
public class UsuarioDaoImplTest {

    private Usuario usuario;
    private final UsuarioDao usuarioDao;
    private Session sessao;

    public UsuarioDaoImplTest() {
        usuarioDao = new UsuarioDaoImpl();
    }

//    @Test
    public void testSalvar() {

        System.out.println("salvar");
        usuario = new Usuario(gerarNome2(), gerarLogin(), gerarSenha(6));
        sessao = HibernateUtil.abrirConexao();
        usuarioDao.salvarOuAlterar(usuario, sessao);
        sessao.close();
        assertNotNull(usuario.getId());

    }

//    @Test
    public void testAlterar() {

        System.out.println("alterar");
        buscarUsuarioBd();

        System.out.println("Nome ANTIGO: " + usuario.toString());

        sessao = HibernateUtil.abrirConexao();
        usuario.setNome(gerarNome2());
        usuarioDao.salvarOuAlterar(usuario, sessao);
        String novoNome = gerarNome2();
        sessao.close();
        assertNotEquals(usuario, novoNome);

        System.out.println("Nome NOVO  : " + usuario.toString());
    }

//    @Test
    public void testPesquisarPorId() {
        System.out.println("testPesquisarPorId");
        buscarUsuarioBd();
        sessao = HibernateUtil.abrirConexao();
        Usuario usuarioPesq = usuarioDao.pesquisarPorId(usuario.getId(), sessao);
        sessao.close();
        assertNotNull(usuarioPesq);

    }

//    @Test
    public void testPesquisarPorNome() {
        System.out.println("testPesquisarPorNome");
        buscarUsuarioBd();
        sessao = HibernateUtil.abrirConexao();
        List<Usuario> usuarioNome = usuarioDao.pesquisarPorNome(usuario.getNome(), sessao);
        sessao.close();
        assertTrue(!usuarioNome.isEmpty());
        System.out.println(usuarioNome);
    }

//    @Test
    public void testPesquisarTodos() {
        System.out.println("testPesquisarTodos");
        buscarUsuarioBd();
        sessao = HibernateUtil.abrirConexao();
        List<Usuario> pesquisarTodos = usuarioDao.pesquisarTodos(sessao);
        sessao.close();
        assertTrue(!pesquisarTodos.isEmpty());
        System.out.println(pesquisarTodos);

    }

    @Test
    public void testPesquisarTodoss() {
        System.out.println("testPesquisarTodoss");
        buscarUsuarioBd();
        sessao = HibernateUtil.abrirConexao();
        List<Usuario> pesquisarTodos = usuarioDao.pesquisarTodos(sessao);

        mostrarPorSqlImpl(pesquisarTodos);

        sessao.close();
        assertTrue(!pesquisarTodos.isEmpty());

    }

    private void mostrarComStream(List<Usuario> pesquisarTodos) {
        pesquisarTodos.stream().sorted((usu1, usu2) -> usu1.getNome().compareTo(usu2.getNome())).forEach(pesquisarTudo
                -> {
            System.out.println(pesquisarTudo);
            System.out.println(" ");
        });
    }

    private void mostrarPorSqlImpl(List<Usuario> pesquisarTodos) {
        pesquisarTodos.forEach(pesquisarTudo
                -> {
            System.out.println(pesquisarTudo);
            System.out.println(" ");
        });
    }

//    @Test
    public void testLogar() {
        System.out.println("testLogar");
        buscarUsuarioBd();
        sessao = HibernateUtil.abrirConexao();
        Usuario logar = usuarioDao.logar(usuario.getLogin(), usuario.getSenha(), sessao);
        sessao.close();

        assertNotNull(logar);

    }

//    @Test
    public void testExcluir() {
        System.out.println("excluir");
        buscarUsuarioBd();
        sessao = HibernateUtil.abrirConexao();
        usuarioDao.excluir(usuario, sessao);

        Usuario usuarioExcluido = usuarioDao.pesquisarPorId(usuario.getId(), sessao);

        assertNull(usuarioExcluido);

    }

    public Usuario buscarUsuarioBd() {

        System.out.println("pesquisarPorId");
        sessao = HibernateUtil.abrirConexao();
        Query<Usuario> consulta = sessao.createQuery("from Usuario u");
        List<Usuario> usuarios = consulta.getResultList();
        sessao.close();

        if (usuarios.isEmpty()) {
            testSalvar();
        } else {
            usuario = usuarios.get(0);
        }

        return usuario;

    }

}
