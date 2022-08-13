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
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jonathan.costa1
 */
public class ClientDaoImpl implements ClientDao {

    private Connection conn;
    private PreparedStatement prepara;
    private ResultSet rs;

    @Override
    public void salvar(Client client) throws SQLException {
        String sql = "INSERT INTO client (nome, cpf, rg, salario) values (?, ?, ?, ?)";
        try {
            conn = FabricaConexao.abrirConexao();
            prepara = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            prepara.setString(1, client.getNome());
            prepara.setString(2, client.getCpf());
            prepara.setString(3, client.getRg());
            prepara.setDouble(4, client.getSalario());
            prepara.executeUpdate();

            rs = prepara.getGeneratedKeys();
            rs.next();
            client.setId(rs.getInt(1));

        } catch (SQLException e) {
            System.out.println("Erro ao salvar " + e.getMessage());
        }

    }

    @Override
    public Client pesquisarPorId(Integer id) throws SQLException {
        Client client = null;
        String sql = "SELECT * FROM client WHERE id = ?";
        try {
            conn = FabricaConexao.abrirConexao();
            prepara = conn.prepareStatement(sql);
            prepara.setInt(1, id);
            rs = prepara.executeQuery();
            if (rs.next()) {
                client = new Client();

                client.setId(id);
                client.setNome(rs.getString("nome"));
                client.setCpf(rs.getString("cpf"));
                client.setRg(rs.getString("rg"));
                client.setSalario(rs.getDouble("salario"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao pesquisar por id " + e.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conn, prepara, rs);
        }
        return client;
    }
}
