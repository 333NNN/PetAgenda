/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import javax.swing.*;
import javax.swing.JOptionPane;
import ui.custom.RoundedCornerBorder;
import ui.custom.RoundedCornerButtonUI;

/**
 *
 * @author ncunha
 */
public class TELA_CADASTRO_USUARIO extends javax.swing.JFrame {

    /**
     * Creates new form TELA_CADASTRO_USUARIO
     */
    public TELA_CADASTRO_USUARIO() {
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

        jPanel_menu = new javax.swing.JPanel();
        btn_Home = new javax.swing.JToggleButton();
        btn_agenda = new javax.swing.JButton();
        btn_financeiro = new javax.swing.JButton();
        btn_clientes = new javax.swing.JButton();
        btn_funcionarios = new javax.swing.JButton();
        btn_pets = new javax.swing.JButton();
        btn_config = new javax.swing.JButton();
        btn_sair = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jlbl_cadastrarUsuario = new javax.swing.JLabel();
        jlbl_nome = new javax.swing.JLabel();
        jlbl_nome = new javax.swing.JLabel();
        jtxt_nome = new javax.swing.JTextField();
        lbl_Cpf = new javax.swing.JLabel();
        jtxt_CPF = new javax.swing.JTextField();
        lbl_Senha = new javax.swing.JLabel();
        jtxt_senha = new javax.swing.JTextField();
        jbtn_CadastrarUsuario = new javax.swing.JButton();
        jlbl_background_cadastro_usuario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1366, 768));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel_menu.setBackground(new java.awt.Color(124, 115, 101));
        jPanel_menu.setForeground(new java.awt.Color(124, 115, 101));
        jPanel_menu.setFont(new java.awt.Font("Merriweather", 0, 12)); // NOI18N
        jPanel_menu.setMinimumSize(new java.awt.Dimension(205, 768));
        jPanel_menu.setPreferredSize(new java.awt.Dimension(205, 768));
        jPanel_menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_Home.setBackground(new java.awt.Color(124, 115, 101));
        btn_Home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo_PetAgendaMenor.png"))); // NOI18N
        btn_Home.setBorder(null);
        btn_Home.setBorderPainted(false);
        btn_Home.setContentAreaFilled(false);
        btn_Home.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Home.setFocusPainted(false);
        btn_Home.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/logo_PetAgendaPressed.png"))); // NOI18N
        btn_Home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_HomeMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_HomeMouseReleased(evt);
            }
        });
        btn_Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_HomeActionPerformed(evt);
            }
        });
        jPanel_menu.add(btn_Home, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 193, -1));

        btn_agenda.setBackground(new java.awt.Color(124, 115, 101));
        btn_agenda.setFont(new java.awt.Font("Merriweather", 0, 14)); // NOI18N
        btn_agenda.setForeground(new java.awt.Color(255, 255, 255));
        btn_agenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_agenda.png"))); // NOI18N
        btn_agenda.setText("Agenda");
        btn_agenda.setBorder(null);
        btn_agenda.setBorderPainted(false);
        btn_agenda.setContentAreaFilled(false);
        btn_agenda.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        btn_agenda.setDisabledIcon(null);
        btn_agenda.setDisabledSelectedIcon(null);
        btn_agenda.setEnabled(false);
        btn_agenda.setFocusPainted(false);
        btn_agenda.setHideActionText(true);
        btn_agenda.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_agenda.setIconTextGap(8);
        btn_agenda.setMaximumSize(new java.awt.Dimension(205, 50));
        btn_agenda.setMinimumSize(new java.awt.Dimension(205, 50));
        btn_agenda.setPreferredSize(new java.awt.Dimension(205, 60));
        btn_agenda.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btn_agendaMouseMoved(evt);
            }
        });
        btn_agenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_agendaMousePressed(evt);
            }
        });
        jPanel_menu.add(btn_agenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 248, -1, -1));

        btn_financeiro.setBackground(new java.awt.Color(124, 115, 101));
        btn_financeiro.setFont(new java.awt.Font("Merriweather", 0, 14)); // NOI18N
        btn_financeiro.setForeground(new java.awt.Color(255, 255, 255));
        btn_financeiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_financeiro.png"))); // NOI18N
        btn_financeiro.setText("Financeiro");
        btn_financeiro.setBorder(null);
        btn_financeiro.setContentAreaFilled(false);
        btn_financeiro.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        btn_financeiro.setDisabledIcon(null);
        btn_financeiro.setDisabledSelectedIcon(null);
        btn_financeiro.setEnabled(false);
        btn_financeiro.setHideActionText(true);
        btn_financeiro.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_financeiro.setIconTextGap(8);
        btn_financeiro.setMaximumSize(new java.awt.Dimension(205, 50));
        btn_financeiro.setMinimumSize(new java.awt.Dimension(205, 50));
        btn_financeiro.setPreferredSize(new java.awt.Dimension(205, 60));
        btn_financeiro.setSelected(true);
        jPanel_menu.add(btn_financeiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 308, -1, -1));

        btn_clientes.setBackground(new java.awt.Color(124, 115, 101));
        btn_clientes.setFont(new java.awt.Font("Merriweather", 0, 14)); // NOI18N
        btn_clientes.setForeground(new java.awt.Color(255, 255, 255));
        btn_clientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_clientes.png"))); // NOI18N
        btn_clientes.setText("Clientes");
        btn_clientes.setBorder(null);
        btn_clientes.setContentAreaFilled(false);
        btn_clientes.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        btn_clientes.setDisabledIcon(null);
        btn_clientes.setDisabledSelectedIcon(null);
        btn_clientes.setEnabled(false);
        btn_clientes.setHideActionText(true);
        btn_clientes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_clientes.setIconTextGap(8);
        btn_clientes.setMaximumSize(new java.awt.Dimension(205, 50));
        btn_clientes.setMinimumSize(new java.awt.Dimension(205, 50));
        btn_clientes.setPreferredSize(new java.awt.Dimension(205, 60));
        jPanel_menu.add(btn_clientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 368, -1, -1));

        btn_funcionarios.setBackground(new java.awt.Color(124, 115, 101));
        btn_funcionarios.setFont(new java.awt.Font("Merriweather", 0, 14)); // NOI18N
        btn_funcionarios.setForeground(new java.awt.Color(255, 255, 255));
        btn_funcionarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_funcionario.png"))); // NOI18N
        btn_funcionarios.setText("Funcionários");
        btn_funcionarios.setBorder(null);
        btn_funcionarios.setContentAreaFilled(false);
        btn_funcionarios.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        btn_funcionarios.setDisabledIcon(null);
        btn_funcionarios.setDisabledSelectedIcon(null);
        btn_funcionarios.setEnabled(false);
        btn_funcionarios.setHideActionText(true);
        btn_funcionarios.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_funcionarios.setIconTextGap(8);
        btn_funcionarios.setMaximumSize(new java.awt.Dimension(205, 50));
        btn_funcionarios.setMinimumSize(new java.awt.Dimension(205, 50));
        btn_funcionarios.setPreferredSize(new java.awt.Dimension(205, 60));
        jPanel_menu.add(btn_funcionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 428, -1, -1));

        btn_pets.setBackground(new java.awt.Color(124, 115, 101));
        btn_pets.setFont(new java.awt.Font("Merriweather", 0, 14)); // NOI18N
        btn_pets.setForeground(new java.awt.Color(255, 255, 255));
        btn_pets.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_pets.png"))); // NOI18N
        btn_pets.setText("Pets");
        btn_pets.setBorder(null);
        btn_pets.setContentAreaFilled(false);
        btn_pets.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        btn_pets.setDisabledIcon(null);
        btn_pets.setDisabledSelectedIcon(null);
        btn_pets.setEnabled(false);
        btn_pets.setHideActionText(true);
        btn_pets.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_pets.setIconTextGap(8);
        btn_pets.setMaximumSize(new java.awt.Dimension(205, 50));
        btn_pets.setMinimumSize(new java.awt.Dimension(205, 50));
        btn_pets.setPreferredSize(new java.awt.Dimension(205, 60));
        jPanel_menu.add(btn_pets, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 488, -1, -1));

        btn_config.setBackground(new java.awt.Color(124, 115, 101));
        btn_config.setFont(new java.awt.Font("Merriweather", 0, 14)); // NOI18N
        btn_config.setForeground(new java.awt.Color(255, 255, 255));
        btn_config.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_configuracoes.png"))); // NOI18N
        btn_config.setText("Configurações");
        btn_config.setBorder(null);
        btn_config.setContentAreaFilled(false);
        btn_config.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        btn_config.setDisabledIcon(null);
        btn_config.setDisabledSelectedIcon(null);
        btn_config.setEnabled(false);
        btn_config.setHideActionText(true);
        btn_config.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_config.setIconTextGap(8);
        btn_config.setMaximumSize(new java.awt.Dimension(205, 50));
        btn_config.setMinimumSize(new java.awt.Dimension(205, 50));
        btn_config.setPreferredSize(new java.awt.Dimension(205, 60));
        jPanel_menu.add(btn_config, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 548, -1, -1));

        btn_sair.setBackground(new java.awt.Color(124, 115, 101));
        btn_sair.setFont(new java.awt.Font("Merriweather", 0, 14)); // NOI18N
        btn_sair.setForeground(new java.awt.Color(255, 255, 255));
        btn_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_sair.png"))); // NOI18N
        btn_sair.setText("Sair");
        btn_sair.setBorder(null);
        btn_sair.setContentAreaFilled(false);
        btn_sair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_sair.setHideActionText(true);
        btn_sair.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_sair.setIconTextGap(8);
        btn_sair.setMaximumSize(new java.awt.Dimension(205, 50));
        btn_sair.setMinimumSize(new java.awt.Dimension(205, 50));
        btn_sair.setPreferredSize(new java.awt.Dimension(205, 60));
        btn_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sairActionPerformed(evt);
            }
        });
        jPanel_menu.add(btn_sair, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 608, -1, -1));

        getContentPane().add(jPanel_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 205, 768));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setFont(new java.awt.Font("Merriweather", 0, 12)); // NOI18N
        jPanel1.setMinimumSize(new java.awt.Dimension(557, 569));
        jPanel1.setPreferredSize(new java.awt.Dimension(570, 569));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlbl_cadastrarUsuario.setFont(new java.awt.Font("Merriweather", 0, 36)); // NOI18N
        jlbl_cadastrarUsuario.setForeground(new java.awt.Color(0, 0, 0));
        jlbl_cadastrarUsuario.setText("Cadastrar usuário");
        jPanel1.add(jlbl_cadastrarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 318, 36));

        jlbl_nome.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_nome.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_nome.setForeground(new java.awt.Color(0, 0, 0));
        jlbl_nome.setText("Nome:");
        jPanel1.add(jlbl_nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 76, -1, -1));

        jtxt_nome.setBackground(new java.awt.Color(217, 217, 217));
        jtxt_nome.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxt_nome.setForeground(new java.awt.Color(0, 0, 0));
        jtxt_nome.setBorder(new RoundedCornerBorder(50));
        jtxt_nome.setCaretColor(new java.awt.Color(0, 0, 0));
        jtxt_nome.setMinimumSize(new java.awt.Dimension(550, 50));
        jtxt_nome.setPreferredSize(new java.awt.Dimension(550, 50));
        jPanel1.add(jtxt_nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 95, -1, -1));

        lbl_Cpf.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        lbl_Cpf.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Cpf.setText("CPF (Será utilizado como Login):");
        jPanel1.add(lbl_Cpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 165, -1, -1));

        jtxt_CPF.setBackground(new java.awt.Color(217, 217, 217));
        jtxt_CPF.setForeground(new java.awt.Color(0, 0, 0));
        jtxt_CPF.setBorder(new RoundedCornerBorder(50));
        jtxt_CPF.setCaretColor(new java.awt.Color(0, 0, 0));
        jtxt_CPF.setMinimumSize(new java.awt.Dimension(464, 42));
        jtxt_CPF.setPreferredSize(new java.awt.Dimension(550, 50));
        jtxt_CPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxt_CPFActionPerformed(evt);
            }
        });
        jPanel1.add(jtxt_CPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 184, 550, 50));

        lbl_Senha.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        lbl_Senha.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Senha.setText("SENHA (8 dígitos, incluindo números e caracteres especiais):");
        jPanel1.add(lbl_Senha, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 251, -1, -1));

        jtxt_senha.setBackground(new java.awt.Color(217, 217, 217));
        jtxt_senha.setForeground(new java.awt.Color(0, 0, 0));
        jtxt_senha.setBorder(new RoundedCornerBorder(50));
        jtxt_senha.setCaretColor(new java.awt.Color(0, 0, 0));
        jtxt_senha.setMinimumSize(new java.awt.Dimension(464, 42));
        jtxt_senha.setPreferredSize(new java.awt.Dimension(550, 50));
        jtxt_senha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxt_senhaActionPerformed(evt);
            }
        });
        jPanel1.add(jtxt_senha, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 273, 550, 50));

        jbtn_CadastrarUsuario.setBackground(new java.awt.Color(71, 120, 63));
        jbtn_CadastrarUsuario.setFont(new java.awt.Font("Merriweather", 0, 20)); // NOI18N
        jbtn_CadastrarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jbtn_CadastrarUsuario.setText("CADASTRAR");
        jbtn_CadastrarUsuario.setBorder(null);
        jbtn_CadastrarUsuario.setMaximumSize(new java.awt.Dimension(170, 35));
        jbtn_CadastrarUsuario.setMinimumSize(new java.awt.Dimension(170, 35));
        jbtn_CadastrarUsuario.setPreferredSize(new java.awt.Dimension(170, 35));
        jbtn_CadastrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_CadastrarUsuarioActionPerformed(evt);
            }
        });
        jbtn_CadastrarUsuario.setUI(new RoundedCornerButtonUI());
        jPanel1.add(jbtn_CadastrarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(201, 368, 240, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 120, 643, 451));

        jlbl_background_cadastro_usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BG_PADRAO.png"))); // NOI18N
        jlbl_background_cadastro_usuario.setLabelFor(jlbl_background_cadastro_usuario);
        jlbl_background_cadastro_usuario.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/BG_PADRAO.png"))); // NOI18N
        getContentPane().add(jlbl_background_cadastro_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jtxt_CPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxt_CPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxt_CPFActionPerformed

    private void jtxt_senhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxt_senhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxt_senhaActionPerformed

    private void jbtn_CadastrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_CadastrarUsuarioActionPerformed
        // TODO add your handling code here:
        //Adicionar conexão com o banco de dados
        JOptionPane.showMessageDialog(this, "Cadastro realizado com sucesso!");
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja cadastrar um novo usuário?", "Novo Cadastro", JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {
        // Se o usuário quiser cadastrar outro usuário, permanece na mesma tela
        // Neste caso, apenas limpa os campos ou reinicializa a tela, se necessário
            limparCampos(); // Exemplo de função que você pode criar para limpar os campos
        } 
        else {
        // Caso contrário, continua para a tela de login
            TELA_LOGIN telaLogin = new TELA_LOGIN();
            telaLogin.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jbtn_CadastrarUsuarioActionPerformed

    private void btn_HomeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_HomeMousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_btn_HomeMousePressed

    private void btn_HomeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_HomeMouseReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_btn_HomeMouseReleased

    private void btn_HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_HomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_HomeActionPerformed

    private void btn_agendaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_agendaMouseMoved
        // TODO add your handling code here:

    }//GEN-LAST:event_btn_agendaMouseMoved

    private void btn_agendaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_agendaMousePressed
        // TODO add your handling code here:
        btn_agenda.setBackground(new java.awt.Color(99, 90, 77));
    }//GEN-LAST:event_btn_agendaMousePressed

    private void btn_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sairActionPerformed
        // TODO add your handling code here:
        TELA_LOGIN telaLogin = new TELA_LOGIN();
        telaLogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_sairActionPerformed

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
            java.util.logging.Logger.getLogger(TELA_CADASTRO_USUARIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TELA_CADASTRO_USUARIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TELA_CADASTRO_USUARIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TELA_CADASTRO_USUARIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TELA_CADASTRO_USUARIO().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btn_Home;
    private javax.swing.JButton btn_agenda;
    private javax.swing.JButton btn_clientes;
    private javax.swing.JButton btn_config;
    private javax.swing.JButton btn_financeiro;
    private javax.swing.JButton btn_funcionarios;
    private javax.swing.JButton btn_pets;
    private javax.swing.JButton btn_sair;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel_menu;
    private javax.swing.JButton jbtn_CadastrarUsuario;
    private javax.swing.JLabel jlbl_background_cadastro_usuario;
    private javax.swing.JLabel jlbl_cadastrarUsuario;
    private javax.swing.JLabel jlbl_nome;
    private javax.swing.JTextField jtxt_CPF;
    private javax.swing.JTextField jtxt_nome;
    private javax.swing.JTextField jtxt_senha;
    private javax.swing.JLabel lbl_Cpf;
    private javax.swing.JLabel lbl_Senha;
    // End of variables declaration//GEN-END:variables

    private void limparCampos() {
        jtxt_nome.setText("");
        jtxt_CPF.setText("");
        jtxt_senha.setText("");
        jtxt_nome.requestFocus();
    }
}
