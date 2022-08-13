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
import java.sql.Statement;
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
        String sql = "INSERT INTO usuario(nome, login, senha) VALUES (?, ?, ?)";
        try {
            conn = FabricaConexao.abrirConexao();
            prepara = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            prepara.setString(1, usuario.getNome());
            prepara.setString(2, usuario.getLogin());
            prepara.setString(3, usuario.getSenha());
            prepara.executeUpdate();

            rs = prepara.getGeneratedKeys();
            rs.next();
            usuario.setId(rs.getInt(1));

        } catch (SQLException e) {
            System.out.println("Erro ao salvar " + e.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conn, prepara, rs);
        }

    }

    @Override
    public void alterar(Usuario usuario) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void excluir(Integer id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Usuario pesquisarPorId(Integer id) throws SQLException {
        Usuario usuario = null;
        String sql = "SELECT * FROM usuario WHERE id = ?";
        try {
            conn = FabricaConexao.abrirConexao();
            prepara = conn.prepareStatement(sql);
            prepara.setInt(1, id);
            rs = prepara.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();

                usuario.setId(id);
                usuario.setNome(rs.getString("nome"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setUltimoAcesso(rs.getDate("ultimo_acesso"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao pesquisar por id " + e.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conn, prepara, rs);
        }
        return usuario;
    }

    @Override
    public List<Usuario> pesquisarTudo() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Usuario> pesquisarPorTudo(String nome) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.    }

    }
}
