package br.com.senac.dao;

import br.com.senac.entidade.Cliente;
import br.com.senac.entidade.Endereco;
import br.com.senac.entidade.Profissao;
import br.com.senac.entidade.Telefone;
import br.com.senac.util.Geradores;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;
import static org.junit.Assert.*;

public class ClienteDaoImplTest {

    private Cliente cliente;
    private ClienteDao clienteDao;
    private Session sessao;

    public ClienteDaoImplTest() {
        clienteDao = new ClienteDaoImpl();
    }

    @Test
    public void testSalvar() {
        System.out.println("salvar");
//        ProfissaoDaoImplTest pdit = new ProfissaoDaoImplTest();
//        Profissao profissao = pdit.buscarProfissaoBD(); 
        sessao = HibernateUtil.abrirConexao();

        Profissao profissao = new Profissao("Prog", "dfgdf", true);
        ProfissaoDao profissaoDao = new ProfissaoDaoImpl();
        profissaoDao.salvarOuAlterar(profissao, sessao);

//        cliente = new Cliente(Geradores.gerarNome(), Geradores.gerarCpf(), Geradores.gerarNumero(5), 265656.36, profissao);
        cliente.setProfissao(profissao);

 //       Telefone telefone = new Telefone(("9" + Geradores.gerarNumero(4) + "-" + Geradores.gerarNumero(4)), ("(" + Geradores.gerarNumero(2) + ")"), "Vivo", "Celular");
//        cliente.setTelefone(telefone);

 //       Endereco endereco = new Endereco("Rua Geral", "Roçado", "88.108-190", "140", "São José", "SC", "Casa", "Rua da Igreja");
//        cliente.setEndereco(endereco);

        clienteDao.salvarOuAlterar(cliente, sessao);
        sessao.close();
        assertNotNull(cliente.getId());
    }

    @Test
    public void testAlterar() {
        System.out.println("alterar");
        buscarClienteBd();
        cliente.getTelefone().setNumero(("9" + Geradores.gerarNumero(4) + "-" + Geradores.gerarNumero(4)));
        cliente.getEndereco().setLogradouro("Rua Tax Tolo");
        sessao = HibernateUtil.abrirConexao();
        clienteDao.salvarOuAlterar(cliente, sessao);
        sessao.close();

        sessao = HibernateUtil.abrirConexao();
        Cliente cli = clienteDao.pesquisarPorId(cliente.getId(), sessao);
        sessao.close();
        assertEquals(cliente.getTelefone().getNumero(), cli.getTelefone().getNumero());
        assertEquals(cliente.getEndereco().getLogradouro(), cli.getEndereco().getLogradouro());
    }

    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
    }

    @Test
    public void testPesquisarPorNome() {
        System.out.println("pesquisarPorNome");
    }

    public Cliente buscarClienteBd() {
        String sql = "from Cliente c";
        sessao = HibernateUtil.abrirConexao();
        Query consulta = sessao.createQuery(sql);
        consulta.setMaxResults(1);
        List<Cliente> clientes = consulta.getResultList();
        sessao.close();
        if (clientes.isEmpty()) {
            testSalvar();
        } else {
            cliente = clientes.get(0);
        }
        return cliente;
    }

}