/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jonathan.costa1
 */
public class FabricaConexao {

    public static Connection abrirConexao() throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/prego?useTimezone=true&serverTimezone=UTC", "root", "Senac2021");
        } catch (ClassNotFoundException classNotFoundException) {
            System.out.println("Erro no Driver MySQL");
        }
        return null;
    }
}
