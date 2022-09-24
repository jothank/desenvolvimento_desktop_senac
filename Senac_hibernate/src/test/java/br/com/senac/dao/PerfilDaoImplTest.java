/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Perfil;
import static br.com.senac.util.Geradores.*;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jonathan.costa1
 */
public class PerfilDaoImplTest {

    private Perfil perfil;
    private final PerfilDao perfilDao;
    private Session sessao;

    public PerfilDaoImplTest() {
        perfilDao = new PerfilDaoImpl();
    }

    @Test
    public void testSalvar() {

        System.out.println("salvar");
        perfil = new Perfil(gerarNome(), gerarNome2());
        sessao = HibernateUtil.abrirConexao();
        perfilDao.salvarOuAlterar(perfil, sessao);
        sessao.close();

        assertNotNull(perfil.getId());

    }

    @Test
    public void testAlterar() {

        System.out.println("alterar");
        buscarUsuarioBd();

        sessao = HibernateUtil.abrirConexao();
        perfil.setNome(gerarNome2());
        perfilDao.salvarOuAlterar(perfil, sessao);
        String novoNome = gerarNome2();
        sessao.close();

        assertNotEquals(perfil, novoNome);

    }

    @Test
    public void testExcluir() {

        System.out.println("excluir");
        buscarUsuarioBd();

        sessao = HibernateUtil.abrirConexao();
        perfilDao.excluir(perfil, sessao);
        Perfil usuarioExcluido = perfilDao.pesquisarPorId(perfil.getId(), sessao);

        assertNull(usuarioExcluido);

    }

    @Test
    public void testPesquisarPorId() {

        System.out.println("testPesquisarPorId");
        buscarUsuarioBd();

        sessao = HibernateUtil.abrirConexao();
        Perfil perfilPesq = perfilDao.pesquisarPorId(perfil.getId(), sessao);
        sessao.close();

        assertNotNull(perfilPesq);

    }

    @Test
    public void testPesquisarPorPerfil() {

        System.out.println("pesquisarPorPerfil");
        buscarUsuarioBd();

        sessao = HibernateUtil.abrirConexao();
        List<Perfil> usuarioNome = perfilDao.pesquisarPorNome(perfil.getNome(), sessao);
        sessao.close();

        assertTrue(!usuarioNome.isEmpty());

    }

    @Test
    public void testPesquisarTodos() {

        System.out.println("testPesquisarTodos");
        buscarUsuarioBd();

        sessao = HibernateUtil.abrirConexao();
        List<Perfil> pesquisarTodos = perfilDao.pesquisarTodos(sessao);
        sessao.close();

        assertTrue(!pesquisarTodos.isEmpty());

    }

    public Perfil buscarUsuarioBd() {

        System.out.println("pesquisarPorId");
        sessao = HibernateUtil.abrirConexao();
        Query<Perfil> consulta = sessao.createQuery("from Perfil c");
        List<Perfil> perfis = consulta.getResultList();
        sessao.close();

        if (perfis.isEmpty()) {
            testSalvar();
        } else {
            perfil = perfis.get(0);
        }

        return perfil;

    }
}
