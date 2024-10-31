/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import com.mycompany.petagenda.MenuPanel;
import java.awt.BorderLayout;

/**
 *
 * @author d.rodrigues
 */
public class Tela_Inicial extends javax.swing.JFrame {

    /**
     * Creates new form Tela_Inicial
     */
    public Tela_Inicial() {
        initComponents();
        initMenuPanel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_menu = new javax.swing.JPanel();
        jPanel_Menu_layout = new javax.swing.JPanel();
        jButton_Cliente = new javax.swing.JButton();
        jButton_Funcionarios = new javax.swing.JButton();
        jButton_Agenda = new javax.swing.JButton();
        jButton_Financeiro = new javax.swing.JButton();
        jButton_ListaPets = new javax.swing.JButton();
        jButton_Configs = new javax.swing.JButton();
        jButton_Sair = new javax.swing.JButton();
        jlbl_background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel_menu.setBackground(new java.awt.Color(124, 115, 101));
        jPanel_menu.setForeground(new java.awt.Color(124, 115, 101));
        jPanel_menu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel_menu.setFont(new java.awt.Font("Merriweather", 0, 12)); // NOI18N
        jPanel_menu.setMinimumSize(new java.awt.Dimension(205, 768));
        jPanel_menu.setPreferredSize(new java.awt.Dimension(205, 768));
        jPanel_menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        getContentPane().add(jPanel_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 205, 768));

        jPanel_Menu_layout.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_Menu_layout.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        jPanel_Menu_layout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton_Cliente.setBackground(new java.awt.Color(124, 115, 101));
        jButton_Cliente.setForeground(new java.awt.Color(124, 115, 101));
        jButton_Cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_clientes.png"))); // NOI18N
        jButton_Cliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton_Cliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ClienteActionPerformed(evt);
            }
        });
        jPanel_Menu_layout.add(jButton_Cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 53, 120, 100));

        jButton_Funcionarios.setBackground(new java.awt.Color(124, 115, 101));
        jButton_Funcionarios.setForeground(new java.awt.Color(124, 115, 101));
        jButton_Funcionarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_funcionario.png"))); // NOI18N
        jButton_Funcionarios.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton_Funcionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_FuncionariosActionPerformed(evt);
            }
        });
        jPanel_Menu_layout.add(jButton_Funcionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(272, 53, 120, 100));

        jButton_Agenda.setBackground(new java.awt.Color(124, 115, 101));
        jButton_Agenda.setForeground(new java.awt.Color(124, 115, 101));
        jButton_Agenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_agenda.png"))); // NOI18N
        jButton_Agenda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel_Menu_layout.add(jButton_Agenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 53, 120, 100));

        jButton_Financeiro.setBackground(new java.awt.Color(124, 115, 101));
        jButton_Financeiro.setForeground(new java.awt.Color(124, 115, 101));
        jButton_Financeiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_financeiro.png"))); // NOI18N
        jButton_Financeiro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton_Financeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_FinanceiroActionPerformed(evt);
            }
        });
        jPanel_Menu_layout.add(jButton_Financeiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 275, 120, 100));

        jButton_ListaPets.setBackground(new java.awt.Color(124, 115, 101));
        jButton_ListaPets.setForeground(new java.awt.Color(124, 115, 101));
        jButton_ListaPets.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_pets.png"))); // NOI18N
        jButton_ListaPets.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton_ListaPets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ListaPetsActionPerformed(evt);
            }
        });
        jPanel_Menu_layout.add(jButton_ListaPets, new org.netbeans.lib.awtextra.AbsoluteConstraints(273, 275, 120, 100));

        jButton_Configs.setBackground(new java.awt.Color(124, 115, 101));
        jButton_Configs.setForeground(new java.awt.Color(124, 115, 101));
        jButton_Configs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_configuracoes.png"))); // NOI18N
        jButton_Configs.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton_Configs.setMaximumSize(new java.awt.Dimension(51, 45));
        jButton_Configs.setMinimumSize(new java.awt.Dimension(51, 45));
        jButton_Configs.setPreferredSize(new java.awt.Dimension(51, 45));
        jPanel_Menu_layout.add(jButton_Configs, new org.netbeans.lib.awtextra.AbsoluteConstraints(486, 275, 120, 100));

        jButton_Sair.setBackground(new java.awt.Color(124, 115, 101));
        jButton_Sair.setForeground(new java.awt.Color(124, 115, 101));
        jButton_Sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_sair.png"))); // NOI18N
        jButton_Sair.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton_Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SairActionPerformed(evt);
            }
        });
        jPanel_Menu_layout.add(jButton_Sair, new org.netbeans.lib.awtextra.AbsoluteConstraints(522, 386, 140, 60));

        getContentPane().add(jPanel_Menu_layout, new org.netbeans.lib.awtextra.AbsoluteConstraints(348, 125, 664, 448));

        jlbl_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BG_PADRAO.png"))); // NOI18N
        getContentPane().add(jlbl_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void initMenuPanel() {
        MenuPanel menuPanel = new MenuPanel();
        jPanel_menu.add(menuPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 205, 768));
    }
    
    private void jButton_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_ClienteActionPerformed

    private void jButton_FuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_FuncionariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_FuncionariosActionPerformed

    private void jButton_FinanceiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_FinanceiroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_FinanceiroActionPerformed

    private void jButton_ListaPetsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ListaPetsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_ListaPetsActionPerformed

    private void jButton_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SairActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_SairActionPerformed

    private void btn_funcionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_funcionariosActionPerformed
        tela_cadastro_funcionario frame = new tela_cadastro_funcionario();
        frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_funcionariosActionPerformed

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
            java.util.logging.Logger.getLogger(Tela_Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_Inicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Agenda;
    private javax.swing.JButton jButton_Cliente;
    private javax.swing.JButton jButton_Configs;
    private javax.swing.JButton jButton_Financeiro;
    private javax.swing.JButton jButton_Funcionarios;
    private javax.swing.JButton jButton_ListaPets;
    private javax.swing.JButton jButton_Sair;
    private javax.swing.JPanel jPanel_Menu_layout;
    private javax.swing.JPanel jPanel_menu;
    private javax.swing.JLabel jlbl_background;
    // End of variables declaration//GEN-END:variables
}
