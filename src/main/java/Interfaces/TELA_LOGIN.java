/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

/**
 *
 * @author The Great Garibaldo
 */

import javax.swing.JFrame;
import ui.custom.RoundedCornerBorder;

public class TELA_LOGIN extends javax.swing.JFrame {

    /**
     * Creates new form TELA_LOGIN
     */
    public TELA_LOGIN() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_logo = new javax.swing.JLabel();
        jLabel_LOGIN = new javax.swing.JLabel();
        txt_login = new javax.swing.JTextField();
        jLabel_SENHA = new javax.swing.JLabel();
        txt_senha = new javax.swing.JPasswordField();
        jButton_ENTRAR = new javax.swing.JButton();
        jLabel_ImgFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_logo.setBackground(new java.awt.Color(239, 225, 201));
        lbl_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo_PetAgendaMenor.png"))); // NOI18N
        lbl_logo.setOpaque(true);
        getContentPane().add(lbl_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 200, 210));

        jLabel_LOGIN.setFont(new java.awt.Font("Merriweather", 0, 32)); // NOI18N
        jLabel_LOGIN.setForeground(new java.awt.Color(0, 0, 0));
        jLabel_LOGIN.setText("Login");
        jLabel_LOGIN.setMaximumSize(new java.awt.Dimension(123, 49));
        jLabel_LOGIN.setMinimumSize(new java.awt.Dimension(123, 49));
        jLabel_LOGIN.setPreferredSize(new java.awt.Dimension(123, 49));
        getContentPane().add(jLabel_LOGIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 250, 110, 50));

        txt_login.setBackground(new java.awt.Color(152, 141, 124));
        txt_login.setOpaque(false);
        txt_login.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_login.setForeground(new java.awt.Color(30, 30, 30));
        txt_login.setText("TheMasterOfTheMasterAdmin");
        txt_login.setBorder(null);
        txt_login.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txt_login.setMinimumSize(new java.awt.Dimension(550, 50));
        txt_login.setPreferredSize(new java.awt.Dimension(550, 50));
        txt_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_loginActionPerformed(evt);
            }
        });
        getContentPane().add(txt_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 300, -1, -1));

        jLabel_SENHA.setFont(new java.awt.Font("Merriweather", 0, 32)); // NOI18N
        jLabel_SENHA.setForeground(new java.awt.Color(0, 0, 0));
        jLabel_SENHA.setText("Senha");
        getContentPane().add(jLabel_SENHA, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 390, 130, 40));

        txt_senha.setBackground(new java.awt.Color(152, 141, 124));
        txt_senha.setForeground(new java.awt.Color(0, 0, 0));
        txt_senha.setText("jPasswordField1");
        txt_senha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txt_senha.setMinimumSize(new java.awt.Dimension(550, 50));
        txt_senha.setPreferredSize(new java.awt.Dimension(552, 50));
        txt_senha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_senhaActionPerformed(evt);
            }
        });
        getContentPane().add(txt_senha, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 430, -1, -1));

        jButton_ENTRAR.setBackground(new java.awt.Color(239, 225, 201));
        jButton_ENTRAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/botao_osso_entrar.png"))); // NOI18N
        jButton_ENTRAR.setBorder(null);
        jButton_ENTRAR.setBorderPainted(false);
        jButton_ENTRAR.setContentAreaFilled(false);
        jButton_ENTRAR.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_ENTRAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ENTRARActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_ENTRAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 510, 190, 90));

        jLabel_ImgFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BG_LOGIN.png"))); // NOI18N
        jLabel_ImgFundo.setMaximumSize(new java.awt.Dimension(1920, 1080));
        getContentPane().add(jLabel_ImgFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, 768));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_ENTRARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ENTRARActionPerformed
        // TODO add your handling code here:
        //Adicionar conexão com o banco de dados
        
        tela_redefinicao_senha telaSenha = new tela_redefinicao_senha();
        telaSenha.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton_ENTRARActionPerformed

    private void txt_senhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_senhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_senhaActionPerformed

    private void txt_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_loginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_loginActionPerformed

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
            java.util.logging.Logger.getLogger(TELA_LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TELA_LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TELA_LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TELA_LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TELA_LOGIN().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_ENTRAR;
    private javax.swing.JLabel jLabel_ImgFundo;
    private javax.swing.JLabel jLabel_LOGIN;
    private javax.swing.JLabel jLabel_SENHA;
    private javax.swing.JLabel lbl_logo;
    private javax.swing.JTextField txt_login;
    private javax.swing.JPasswordField txt_senha;
    // End of variables declaration//GEN-END:variables
}
