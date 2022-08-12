/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Usuario;
import java.util.List;
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

    @Test
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
        Usuario usuario = null;
        UsuarioDaoImpl instance = new UsuarioDaoImpl();
        instance.alterar(usuario);
        fail("The test case is a prototype.");
    }
//

    @Test
    public void testExcluir() throws Exception {
        System.out.println("excluir");
        Integer id = null;
        UsuarioDaoImpl instance = new UsuarioDaoImpl();
        instance.excluir(id);
        fail("The test case is a prototype.");
    }
//

    @Test
    public void testPesquisarPorId() throws Exception {
        System.out.println("pesquisarPorId");
        Integer id = null;
        UsuarioDaoImpl instance = new UsuarioDaoImpl();
        Usuario expResult = null;
        Usuario result = instance.pesquisarPorId(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
//

    @Test
    public void testPesquisarTudo() throws Exception {
        System.out.println("pesquisarTudo");
        UsuarioDaoImpl instance = new UsuarioDaoImpl();
        List<Usuario> expResult = null;
        List<Usuario> result = instance.pesquisarTudo();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
//

    @Test
    public void testPesquisarPorTudo() throws Exception {
        System.out.println("pesquisarPorTudo");
        String nome = "";
        UsuarioDaoImpl instance = new UsuarioDaoImpl();
        List<Usuario> expResult = null;
        List<Usuario> result = instance.pesquisarPorTudo(nome);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

}
