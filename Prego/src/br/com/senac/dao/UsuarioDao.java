/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Usuario;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author jonathan.costa1
 */
public interface UsuarioDao {

    public abstract void salvar(Usuario usuario) throws SQLException;

    public abstract void alterar(Usuario usuario) throws SQLException;

    public abstract void excluir(Integer id) throws SQLException;

    Usuario pesquisarPorId(Integer id) throws SQLException;

    List<Usuario> pesquisarTudo() throws SQLException;

    List<Usuario> pesquisarPorNome (String nome) throws SQLException;

}
