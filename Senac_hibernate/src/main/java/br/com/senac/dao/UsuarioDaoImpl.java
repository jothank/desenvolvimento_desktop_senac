/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Usuario;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author jonathan.costa1
 */
public class UsuarioDaoImpl extends BaseDaoImpl<Usuario, Long> implements UsuarioDao {

    @Override
    public Usuario pesquisarPorId(Long id, Session sessao) throws HibernateException {
        return sessao.find(Usuario.class, id);
    }

    @Override
    public List<Usuario> pesquisarPorNome(String nome, Session sessao) throws HibernateException {
        Query<Usuario> consulta = sessao.createQuery("select u from Usuario u where u.nome like :nome");
        consulta.setParameter("nome", "%" + nome + "%");
        return consulta.getResultList();
    }

    @Override
    public List<Usuario> pesquisarTodos(Session sessao) throws HibernateException {
        Query<Usuario> consulta = sessao.createQuery("select u from Usuario u order by u.nome");
        return consulta.getResultList();
    }

    @Override
    public Usuario logar(String login, String senha, Session sessao) throws HibernateException {
        Query<Usuario> consulta = sessao.createQuery("select u from Usuario u where u.login = :login and u.senha = :senha");
        consulta.setParameter("login", login);
        consulta.setParameter("senha", senha);
        return consulta.uniqueResult();
    }

}
