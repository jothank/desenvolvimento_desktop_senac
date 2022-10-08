/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.tela;

import br.com.senac.dao.HibernateUtil;
import br.com.senac.dao.PerfilDao;
import br.com.senac.dao.PerfilDaoImpl;
import br.com.senac.entidade.Perfil;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author jonathan.costa1
 */
public class CadastroPerfil extends javax.swing.JFrame {

    /**
     * Creates new form CadastroUsuario
     */
    private PerfilDao perfilDao;
    private Session sessao;
    private Perfil perfil;
    private List<Perfil> perfis;

    public CadastroPerfil() {
        initComponents();
    }

    CadastroPerfil(Perfil perfil) {
        initComponents();
        carregarAlteracaoPerfil(perfil);
        btSalvar.setText("Alterar");        
        tituto_cadastro.setText("Alterar Usuário");
    }
    
    private void carregarAlteracaoPerfil(Perfil perfil) {
        this.perfil = perfil;
        varNome.setText(perfil.getNome());
        varNome1.setText(perfil.getDescricao());
        btCancelar.setEnabled(false);        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tituto_cadastro = new javax.swing.JLabel();
        label_nome = new javax.swing.JLabel();
        varNome = new javax.swing.JTextField();
        btCancelar = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        label_nome1 = new javax.swing.JLabel();
        varNome1 = new javax.swing.JTextField();
        label_perfil = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro Usuário");

        tituto_cadastro.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        tituto_cadastro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituto_cadastro.setText("Cadastro Perfil");
        tituto_cadastro.setToolTipText("");

        label_nome.setText("Nome:");

        varNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                varNomeActionPerformed(evt);
            }
        });

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        label_nome1.setText("Descrição:");

        varNome1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                varNome1ActionPerformed(evt);
            }
        });

        label_perfil.setText("Situação:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tituto_cadastro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btCancelar)
                                .addGap(18, 18, 18)
                                .addComponent(btSalvar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(label_nome))
                                    .addComponent(label_nome1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(label_perfil)))
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(varNome1, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                                    .addComponent(varNome))))
                        .addGap(0, 21, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituto_cadastro)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_nome)
                    .addComponent(varNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_nome1)
                    .addComponent(varNome1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(label_perfil)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSalvar)
                    .addComponent(btCancelar))
                .addGap(49, 49, 49))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        perfilDao = new PerfilDaoImpl();
        sessao = HibernateUtil.abrirConexao();
        if (validarFormulario()) {
            if (perfil == null) {
                perfil = new Perfil();
            }
            perfil.setNome(varNome.getText());
            perfil.setDescricao(varNome1.getText());
            perfilDao.salvarOuAlterar(perfil, sessao);
            dispose();
            JOptionPane.showMessageDialog(null, "Usuário salvo com sucesso!");
            sessao.close();
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private boolean validarFormulario() {
        String nome = varNome.getText().trim();
        if (validarCampoMenor3Caracter(nome)) {
            JOptionPane.showMessageDialog(null, "Preencha o nome corretamente!");
            return false;
        }
        return true; //retornar falso apenas explicação
    }

    private boolean validarCampoMenor3Caracter(String campo) {
        return campo.length() < 3;
    }

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        btCancelar.addActionListener((ActionEvent e) -> {
            varNome1.setText("");
            varNome.setText("");
        });
    }//GEN-LAST:event_btCancelarActionPerformed

    private void varNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_varNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_varNomeActionPerformed

    private void varNome1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_varNome1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_varNome1ActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroPerfil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label_nome;
    private javax.swing.JLabel label_nome1;
    private javax.swing.JLabel label_perfil;
    private javax.swing.JLabel tituto_cadastro;
    private javax.swing.JTextField varNome;
    private javax.swing.JTextField varNome1;
    // End of variables declaration//GEN-END:variables

}
