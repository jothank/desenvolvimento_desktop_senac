/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Client;
import java.sql.SQLException;

/**
 *
 * @author jonathan.costa1
 */
public interface ClientDao {

    public abstract void salvar(Client client) throws SQLException;

    Client pesquisarPorId(Integer id) throws SQLException;

}
