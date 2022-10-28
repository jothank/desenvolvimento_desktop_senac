/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.tela;

import br.com.senac.dao.HibernateUtil;
import br.com.senac.dao.ProfissaoDaoImpl;
import br.com.senac.dao.ProfissaoDao;
import br.com.senac.entidade.Profissao;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author jonathan.costa1
 */
public class PesquisaProfissao extends javax.swing.JFrame {

    private Session sessao;
    private List<Profissao> profissoes;
    private Profissao profissao;
    private ProfissaoDao profissaoDao;

    /**
     * Creates new form PesquisaPerfil
     */
    public PesquisaProfissao() {
        initComponents();
        profissaoDao = new ProfissaoDaoImpl();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo_pesq_perfil = new javax.swing.JLabel();
        varNome = new javax.swing.JTextField();
        label_nome = new javax.swing.JLabel();
        btPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPerfil = new javax.swing.JTable();
        btExcluir = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisa Profissao");

        titulo_pesq_perfil.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        titulo_pesq_perfil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo_pesq_perfil.setText("Pesquisa Profissao");
        titulo_pesq_perfil.setToolTipText("");

        varNome.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        label_nome.setText("Nome:");

        btPesquisar.setText("Pesquisar");
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        tbPerfil.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nome", "Descricao", "Situacao"
            }
        ));
        tbPerfil.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tbPerfil);

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
                        .addComponent(label_nome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(varNome, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(titulo_pesq_perfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(6, 6, 6))
            .addGroup(layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo_pesq_perfil)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_nome)
                    .addComponent(varNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btExcluir)
                    .addComponent(btAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(9, Short.MAX_VALUE))
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
                profissoes = profissaoDao.pesquisarPorNome(nome, sessao);
                if (profissoes.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nenhum valor encontrado!");
                } else {
                    carregarTabelaPerfil(profissoes);
                }
            } catch (HibernateException e) {
                System.out.println("Erro ao pesquisar nome: " + e.getMessage());
            } finally {
                sessao.close();
            }
        }
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed

        int linhaSelecionada = tbPerfil.getSelectedRow();

        if (linhaSelecionada < 0) {
            JOptionPane.showMessageDialog(null, "Selecione alguem para excluir");
        } else {
            try {
                sessao = HibernateUtil.abrirConexao();
                profissao = profissoes.get(linhaSelecionada);
                profissaoDao.excluir(profissao, sessao);
//                DefaultTableModel defaultTable = (DefaultTableModel) tbPerfil.getModel();
//                defaultTable.removeRow(linhaSelecionada);
                profissoes.remove(linhaSelecionada);
                carregarTabelaPerfil(profissoes);
//                dispose();
                JOptionPane.showMessageDialog(null, "Excluido com sucesso");
            } catch (HibernateException e) {
                System.out.println("Erro ao excluir profissao " + e.getMessage());
            } finally {
                sessao.close();
            }
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed

        int linhaSelecionada = tbPerfil.getSelectedRow();

        if (linhaSelecionada < 0) {
            JOptionPane.showMessageDialog(null, "Selecione alguem para alterar");
        } else {
            try {
                sessao = HibernateUtil.abrirConexao();
                profissao = profissoes.get(linhaSelecionada);
                new CadastroProfissao(profissao).setVisible(true);
            } catch (HibernateException e) {
                System.out.println("Erro ao excluir usuário " + e.getMessage());
            } finally {
                sessao.close();
            }
        }
    }//GEN-LAST:event_btAlterarActionPerformed
    private void carregarTabelaPerfil(List<Profissao> profissoes) {

        DefaultTableModel defaultTable = (DefaultTableModel) tbPerfil.getModel();
        defaultTable.setNumRows(0);
        profissoes.stream().forEach(pro -> {
            defaultTable.addRow(new Object[]{
                pro.getNome(),
                pro.getDescricao(),
                pro.getSituacao() ? "ativo" : "inativo"
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
            java.util.logging.Logger.getLogger(PesquisaProfissao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PesquisaProfissao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PesquisaProfissao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PesquisaProfissao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PesquisaProfissao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_nome;
    private javax.swing.JTable tbPerfil;
    private javax.swing.JLabel titulo_pesq_perfil;
    private javax.swing.JTextField varNome;
    // End of variables declaration//GEN-END:variables
}