/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.tela;

import br.com.senac.dao.HibernateUtil;
import br.com.senac.dao.ClienteDao;
import br.com.senac.dao.ClienteDaoImpl;
import br.com.senac.entidade.Cliente;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author jonathan.costa1
 */
public class PesquisaCliente extends javax.swing.JFrame {

    private Session sessao;
    private List<Cliente> clientes;
    private Cliente cliente;
    private ClienteDao clienteDao;

    /**
     * Creates new form PesquisaUsuario
     */
    public PesquisaCliente() {
        initComponents();
        clienteDao = new ClienteDaoImpl();
    }
    
    public PesquisaCliente(Cliente cliente) {
        initComponents();
        clienteDao = new ClienteDaoImpl();
        carregarTabelaCliente(clientes);        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo_pesq_usuario = new javax.swing.JLabel();
        varNome = new javax.swing.JTextField();
        label_nome = new javax.swing.JLabel();
        btPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCliente = new javax.swing.JTable();
        btExcluir = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisa Cliente");

        titulo_pesq_usuario.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        titulo_pesq_usuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo_pesq_usuario.setText("Pesquisa Cliente");
        titulo_pesq_usuario.setToolTipText("");

        varNome.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        varNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                varNomeActionPerformed(evt);
            }
        });

        label_nome.setText("Nome:");

        btPesquisar.setText("Pesquisar");
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        tbCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nome", "CPF", "RG", "Salario", "Perfil", "Telefone", "Endere??o"
            }
        ));
        tbCliente.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tbCliente);

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btAlterar.setText("Alterar");
        btAlterar.setMaximumSize(new java.awt.Dimension(80, 22));
        btAlterar.setMinimumSize(new java.awt.Dimension(80, 22));
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label_nome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(varNome, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titulo_pesq_usuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo_pesq_usuario)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_nome)
                    .addComponent(varNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btExcluir)
                    .addComponent(btAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed

        String nome = varNome.getText().trim();

        if (nome.length() <= 2) {
            JOptionPane.showMessageDialog(null, "Nome apresenta poucos caracteres");
        } else {
            try {
                sessao = HibernateUtil.abrirConexao();
                clientes = clienteDao.pesquisarPorCliente(nome, sessao);

                if (clientes == null) {
                    JOptionPane.showMessageDialog(null, "Nenhum valor encontrado!");
                } else {
                    carregarTabelaCliente(clientes);
                }
            } catch (HibernateException e) {
                System.out.println("Erro ao pesquisar nome: " + e.getMessage());
            } finally {
                sessao.close();
            }
        }    }//GEN-LAST:event_btPesquisarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed

        int linhaSelecionada = tbCliente.getSelectedRow();

        if (linhaSelecionada < 0) {
            JOptionPane.showMessageDialog(null, "Selecione alguem para excluir");
        } else {
            try {
                sessao = HibernateUtil.abrirConexao();
                cliente = clientes.get(linhaSelecionada);
                clienteDao.excluir(cliente, sessao);
//                DefaultTableModel defaultTable = (DefaultTableModel) tbUsuario.getModel();
//                defaultTable.removeRow(linhaSelecionada);
                clientes.remove(linhaSelecionada);
                carregarTabelaCliente(clientes);
//                dispose();
                JOptionPane.showMessageDialog(null, "Excluido com sucesso");
            } catch (HibernateException e) {
                System.out.println("Erro ao excluir usu??rio " + e.getMessage());
            } finally {
                sessao.close();
            }
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed

        int linhaSelecionada = tbCliente.getSelectedRow();

        if (linhaSelecionada < 0) {
            JOptionPane.showMessageDialog(null, "Selecione linha para alterar");
        } else {
            try {
                sessao = HibernateUtil.abrirConexao();
                cliente = clientes.get(linhaSelecionada);
                new CadastroCliente(cliente).setVisible(true);                
            } catch (HibernateException e) {
                System.out.println("Erro ao selecionar linha " + e.getMessage());
            } finally {
                sessao.close();
            }
        }
    }//GEN-LAST:event_btAlterarActionPerformed

    private void varNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_varNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_varNomeActionPerformed
    private void carregarTabelaCliente(List<Cliente> clientes) {

        DefaultTableModel defaultTable = (DefaultTableModel) tbCliente.getModel();
        defaultTable.setNumRows(0);
        clientes.stream().forEach(cli -> {
            defaultTable.addRow(new Object[]{
                cli.getNome(),
                cli.getCpf(),
                cli.getRg(),
                cli.getSalario(),
                cli.getProfissao().getNome(),
                cli.getTelefone().getNumero(),
                cli.getEndereco().getCep()
            });
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PesquisaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PesquisaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PesquisaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PesquisaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PesquisaCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_nome;
    private javax.swing.JTable tbCliente;
    private javax.swing.JLabel titulo_pesq_usuario;
    private javax.swing.JTextField varNome;
    // End of variables declaration//GEN-END:variables
}
