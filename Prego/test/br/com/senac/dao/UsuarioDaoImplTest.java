/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Usuario;
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
public class UsuarioDaoImplTest {

    private Usuario usuario;
    private UsuarioDao usuarioDao;

    public UsuarioDaoImplTest() {
        usuarioDao = new UsuarioDaoImpl();
    }

//    @Test
    public void testSalvar() throws Exception {
        System.out.println("salvar");
        usuario = new Usuario(
                Gerador.gerarNome2(),
                Gerador.gerarLogin(),
                Gerador.gerarSenha(5)
        );
        usuarioDao.salvar(usuario);
        assertNotNull(usuario.getId());
    }

    @Test
    public void testAlterar() throws Exception {
        System.out.println("alterar");
    }

    @Test
    public void testExcluir() throws Exception {
        System.out.println("excluir");
    }

    @Test
    public void testPesquisarTudo() throws Exception {
        System.out.println("pesquisarTudo");
    }

    @Test
    public void testPesquisarPorTudo() throws Exception {
        System.out.println("pesquisarPorTudo");
    }

    @Test
    public void testPesquisarPorId() throws Exception {
        System.out.println("pesquisarPorId");
        buscarUsuarioBD();
        Usuario usuarioPesquisado = usuarioDao.pesquisarPorId(usuario.getId());
        assertNotNull(usuarioPesquisado);
        System.out.println(usuario.toString());
    }

    public Usuario buscarUsuarioBD() throws Exception {
        String sql = "select * from usuario";
        Connection conn = FabricaConexao.abrirConexao();
        PreparedStatement prepara = conn.prepareStatement(sql);
        ResultSet rs = prepara.executeQuery();

        if (rs.next()) {
            usuario = new Usuario();
            usuario.setId(rs.getInt("id"));
            usuario.setNome(rs.getString("nome"));
            usuario.setLogin(rs.getString("login"));
            usuario.setSenha(rs.getString("senha"));
            usuario.setUltimoAcesso(rs.getDate("ultimo_acesso"));
        } else {
            testSalvar();
        }
        return usuario;
    }

}
