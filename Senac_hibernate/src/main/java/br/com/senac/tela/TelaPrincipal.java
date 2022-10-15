/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.tela;

import br.com.senac.entidade.Usuario;

/**
 *
 * @author silvio.junior
 */
public class TelaPrincipal extends javax.swing.JFrame {

    private Usuario usuario;
    
    public TelaPrincipal() {
        initComponents();
    }
    
    public TelaPrincipal(Usuario usuario) {
        initComponents();
        this.usuario = usuario;   
        varUsuarioLogado.setText("Seja bem vindo " 
                                    + usuario.getNome());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        varUsuarioLogado = new javax.swing.JLabel();
        icone_cad_usuario = new javax.swing.JLabel();
        icone_pesq_usuario = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu_cadastro = new javax.swing.JMenu();
        item_cad_usuario = new javax.swing.JMenuItem();
        item_cad_perfil = new javax.swing.JMenuItem();
        menu_pesquisa = new javax.swing.JMenu();
        item_pesq_usuario = new javax.swing.JMenuItem();
        item_pesq_perfil = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Senac");

        icone_cad_usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/cad_usuario.png"))); // NOI18N
        icone_cad_usuario.setToolTipText("Novo Usuário");
        icone_cad_usuario.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        icone_cad_usuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        icone_cad_usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icone_cad_usuarioMouseClicked(evt);
            }
        });

        icone_pesq_usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/pesq_usario.png"))); // NOI18N
        icone_pesq_usuario.setToolTipText("Pesquisa de usuário");
        icone_pesq_usuario.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        icone_pesq_usuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        icone_pesq_usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icone_pesq_usuarioMouseClicked(evt);
            }
        });

        menu_cadastro.setText("Cadastro");

        item_cad_usuario.setText("Usuario");
        menu_cadastro.add(item_cad_usuario);

        item_cad_perfil.setText("Perfil");
        menu_cadastro.add(item_cad_perfil);

        jMenuBar1.add(menu_cadastro);

        menu_pesquisa.setText("Pesquisa");

        item_pesq_usuario.setText("Usuario");
        menu_pesquisa.add(item_pesq_usuario);

        item_pesq_perfil.setText("Perfil");
        menu_pesquisa.add(item_pesq_perfil);

        jMenuBar1.add(menu_pesquisa);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(varUsuarioLogado, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(icone_cad_usuario)
                .addGap(18, 18, 18)
                .addComponent(icone_pesq_usuario)
                .addContainerGap(479, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(varUsuarioLogado, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(icone_cad_usuario)
                    .addComponent(icone_pesq_usuario))
                .addGap(0, 239, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void icone_cad_usuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icone_cad_usuarioMouseClicked
        new CadastroUsuario().setVisible(true);
    }//GEN-LAST:event_icone_cad_usuarioMouseClicked

    private void icone_pesq_usuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icone_pesq_usuarioMouseClicked
        new PesquisaUsuario().setVisible(true);
    }//GEN-LAST:event_icone_pesq_usuarioMouseClicked

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                TelaPrincipal tela = new TelaPrincipal();
//                tela.setVisible(true);
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel icone_cad_usuario;
    private javax.swing.JLabel icone_pesq_usuario;
    private javax.swing.JMenuItem item_cad_perfil;
    private javax.swing.JMenuItem item_cad_usuario;
    private javax.swing.JMenuItem item_pesq_perfil;
    private javax.swing.JMenuItem item_pesq_usuario;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menu_cadastro;
    private javax.swing.JMenu menu_pesquisa;
    private javax.swing.JLabel varUsuarioLogado;
    // End of variables declaration//GEN-END:variables
}
