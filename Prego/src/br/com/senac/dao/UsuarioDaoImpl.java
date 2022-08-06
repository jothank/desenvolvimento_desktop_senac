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
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author jonathan.costa1
 */
public class UsuarioDaoImpl implements UsuarioDao {

    private Connection conn;
    private PreparedStatement prepara;
    private ResultSet rs;

    @Override
    public void salvar(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuario(nome, login, senha) values (?, ?, ?)";
        try {
            conn = FabricaConexao.abrirConexao();
            prepara = conn.prepareStatement(sql);
            prepara.setString(1, usuario.getNome());
            prepara.setString(2, usuario.getLogin());
            prepara.setString(3, usuario.getSenha());
            prepara.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao salvar " + e.getMessage());
        }

    }

    @Override
    public void alterar(Usuario usuario) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Integer id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario pesquisarPorId(Integer id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> pesquisarTudo() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> pesquisarPorTudo(String nome) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
