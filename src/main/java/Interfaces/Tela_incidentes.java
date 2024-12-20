/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import com.mycompany.petagenda.MenuPanel;
import ui.custom.RoundedCornerButtonUI;

/**
 *
 * @author edmun
 */
public class Tela_incidentes extends javax.swing.JFrame {

    /**
     * Creates new form Tela_incidentes
     */
    public Tela_incidentes() {
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

        jbtn_cadastrar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        lbl_historico_servicos = new javax.swing.JLabel();
        jtxtf_campo_nome_pet = new javax.swing.JTextField();
        jspnnr_Grupo = new javax.swing.JSpinner();
        jlbl_descricao_incidente = new javax.swing.JLabel();
        jlbl_Grupo1 = new javax.swing.JLabel();
        jlbl_emergencia_medica = new javax.swing.JLabel();
        jckBox_Sim1 = new javax.swing.JCheckBox();
        jckBox_Nao1 = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jlbl_nome_cpet1 = new javax.swing.JLabel();
        jPanel_menu = new javax.swing.JPanel();
        jlbl_background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbtn_cadastrar.setBackground(new java.awt.Color(77, 120, 63));
        jbtn_cadastrar.setFont(new java.awt.Font("Merriweather", 0, 20)); // NOI18N
        jbtn_cadastrar.setForeground(new java.awt.Color(255, 255, 255));
        jbtn_cadastrar.setText("Cadastrar ");
        jbtn_cadastrar.setBorder(null);
        jbtn_cadastrar.setPreferredSize(new java.awt.Dimension(240, 50));
        jbtn_cadastrar.setUI(new RoundedCornerButtonUI());
        jbtn_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_cadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(jbtn_cadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 560, 180, -1));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel6.setMinimumSize(new java.awt.Dimension(905, 560));
        jPanel6.setOpaque(false);
        jPanel6.setPreferredSize(new java.awt.Dimension(905, 560));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_historico_servicos.setBackground(new java.awt.Color(255, 255, 255));
        lbl_historico_servicos.setFont(new java.awt.Font("Merriweather", 0, 45)); // NOI18N
        lbl_historico_servicos.setForeground(new java.awt.Color(0, 0, 0));
        lbl_historico_servicos.setText("Cadastro de Incidente");
        lbl_historico_servicos.setPreferredSize(new java.awt.Dimension(600, 58));
        jPanel6.add(lbl_historico_servicos, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, -1));

        jtxtf_campo_nome_pet.setBackground(new java.awt.Color(217, 217, 217));
        jtxtf_campo_nome_pet.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtf_campo_nome_pet.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jtxtf_campo_nome_pet.setCaretColor(new java.awt.Color(255, 255, 255));
        jtxtf_campo_nome_pet.setMinimumSize(new java.awt.Dimension(550, 50));
        jtxtf_campo_nome_pet.setOpaque(true);
        jtxtf_campo_nome_pet.setPreferredSize(new java.awt.Dimension(550, 50));
        jPanel6.add(jtxtf_campo_nome_pet, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 220, 52));

        jspnnr_Grupo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel6.add(jspnnr_Grupo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 150, 50));

        jlbl_descricao_incidente.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_descricao_incidente.setForeground(new java.awt.Color(0, 0, 0));
        jlbl_descricao_incidente.setText("Descrição do Incidente:");
        jlbl_descricao_incidente.setPreferredSize(new java.awt.Dimension(660, 20));
        jPanel6.add(jlbl_descricao_incidente, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        jlbl_Grupo1.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_Grupo1.setForeground(new java.awt.Color(0, 0, 0));
        jlbl_Grupo1.setText("Id do agendamento:");
        jlbl_Grupo1.setPreferredSize(new java.awt.Dimension(190, 20));
        jPanel6.add(jlbl_Grupo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, -1, -1));

        jlbl_emergencia_medica.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_emergencia_medica.setForeground(new java.awt.Color(0, 0, 0));
        jlbl_emergencia_medica.setText("Emergência Médica:");
        jlbl_emergencia_medica.setPreferredSize(new java.awt.Dimension(240, 40));
        jPanel6.add(jlbl_emergencia_medica, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, -1, -1));

        jckBox_Sim1.setFont(new java.awt.Font("Merriweather", 0, 12)); // NOI18N
        jckBox_Sim1.setForeground(new java.awt.Color(0, 0, 0));
        jckBox_Sim1.setText("Sim");
        jckBox_Sim1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jckBox_Sim1ActionPerformed(evt);
            }
        });
        jPanel6.add(jckBox_Sim1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, -1, -1));

        jckBox_Nao1.setFont(new java.awt.Font("Merriweather", 0, 12)); // NOI18N
        jckBox_Nao1.setForeground(new java.awt.Color(0, 0, 0));
        jckBox_Nao1.setText("Não");
        jckBox_Nao1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jckBox_Nao1ActionPerformed(evt);
            }
        });
        jPanel6.add(jckBox_Nao1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 120, -1, -1));

        jTextArea1.setBackground(new java.awt.Color(217, 217, 217));
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(jTextArea1);

        jPanel6.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 680, 170));

        jlbl_nome_cpet1.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_nome_cpet1.setForeground(new java.awt.Color(0, 0, 0));
        jlbl_nome_cpet1.setText("Nome do Pet:");
        jlbl_nome_cpet1.setPreferredSize(new java.awt.Dimension(210, 20));
        jPanel6.add(jlbl_nome_cpet1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, 740, 400));

        jPanel_menu.setBackground(new java.awt.Color(124, 115, 101));
        jPanel_menu.setForeground(new java.awt.Color(124, 115, 101));
        jPanel_menu.setPreferredSize(new java.awt.Dimension(205, 768));
        jPanel_menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jlbl_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BG_PADRAO.png"))); // NOI18N
        getContentPane().add(jlbl_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jckBox_Sim1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jckBox_Sim1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jckBox_Sim1ActionPerformed

    private void jckBox_Nao1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jckBox_Nao1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jckBox_Nao1ActionPerformed

    private void jbtn_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_cadastrarActionPerformed
        // TODO add your handling code here:
        Tela_cadastro_cliente telaCadCliente = new Tela_cadastro_cliente();
        telaCadCliente.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbtn_cadastrarActionPerformed

    private void initMenuPanel() {
        MenuPanel menuPanel = new MenuPanel();
        jPanel_menu.add(menuPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 205, 768));
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
            java.util.logging.Logger.getLogger(Tela_incidentes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_incidentes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_incidentes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_incidentes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_incidentes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel_menu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton jbtn_cadastrar;
    private javax.swing.JCheckBox jckBox_Nao1;
    private javax.swing.JCheckBox jckBox_Sim1;
    private javax.swing.JLabel jlbl_Grupo1;
    private javax.swing.JLabel jlbl_background;
    private javax.swing.JLabel jlbl_descricao_incidente;
    private javax.swing.JLabel jlbl_emergencia_medica;
    private javax.swing.JLabel jlbl_nome_cpet1;
    private javax.swing.JSpinner jspnnr_Grupo;
    private javax.swing.JTextField jtxtf_campo_nome_pet;
    private javax.swing.JLabel lbl_historico_servicos;
    // End of variables declaration//GEN-END:variables
}
