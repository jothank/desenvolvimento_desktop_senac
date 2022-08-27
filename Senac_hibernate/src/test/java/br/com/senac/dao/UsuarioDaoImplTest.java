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
    private UsuarioDao usuarioDao;
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

    @Test
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
        System.out.println("pesquisar");
        buscarUsuarioBd();
        sessao = HibernateUtil.abrirConexao();
        Usuario usuarioPesq = usuarioDao.pesquisarPorId(usuario.getId(), sessao);
        sessao.close();
        assertNotNull(usuarioPesq);

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
