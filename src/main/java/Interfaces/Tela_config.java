/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import com.mycompany.petagenda.MenuPanel;
import ui.custom.RoundedCornerButtonUI;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import petagenda.bd.BD;

/**
 *
 * @author Nata e Julia
 */
public class Tela_config extends javax.swing.JFrame {

    /**
     * Creates new form Tela_config
     */
    public Tela_config() {
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

        jPanel1 = new javax.swing.JPanel();
        lbl_cadastrarUsuario = new javax.swing.JLabel();
        btn_cadastrarUsuario = new javax.swing.JButton();
        lbl_AlteraSenha = new javax.swing.JLabel();
        btn_alteraSenha = new javax.swing.JButton();
        lbl_codigo = new javax.swing.JLabel();
        btn_exibirCodigo = new javax.swing.JButton();
        jPanel_menu = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.setPreferredSize(new java.awt.Dimension(850, 550));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_cadastrarUsuario.setBackground(new java.awt.Color(255, 255, 255));
        lbl_cadastrarUsuario.setFont(new java.awt.Font("Merriweather", 0, 18)); // NOI18N
        lbl_cadastrarUsuario.setForeground(new java.awt.Color(0, 0, 0));
        lbl_cadastrarUsuario.setText("Cadastrar novo usuário:");
        lbl_cadastrarUsuario.setPreferredSize(new java.awt.Dimension(500, 23));
        jPanel1.add(lbl_cadastrarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, -1, -1));

        btn_cadastrarUsuario.setBackground(new java.awt.Color(77, 120, 63));
        btn_cadastrarUsuario.setFont(new java.awt.Font("Merriweather", 0, 20)); // NOI18N
        btn_cadastrarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        btn_cadastrarUsuario.setText("Cadastrar ");
        btn_cadastrarUsuario.setBorder(null);
        btn_cadastrarUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cadastrarUsuario.setPreferredSize(new java.awt.Dimension(240, 50));
        btn_cadastrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cadastrarUsuarioActionPerformed(evt);
            }
        });
        btn_cadastrarUsuario.setUI(new RoundedCornerButtonUI());
        jPanel1.add(btn_cadastrarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, -1, -1));

        lbl_AlteraSenha.setBackground(new java.awt.Color(255, 255, 255));
        lbl_AlteraSenha.setFont(new java.awt.Font("Merriweather", 0, 18)); // NOI18N
        lbl_AlteraSenha.setForeground(new java.awt.Color(0, 0, 0));
        lbl_AlteraSenha.setText("Alterar Senha:");
        lbl_AlteraSenha.setPreferredSize(new java.awt.Dimension(500, 23));
        jPanel1.add(lbl_AlteraSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, -1, -1));

        btn_alteraSenha.setBackground(new java.awt.Color(77, 120, 63));
        btn_alteraSenha.setFont(new java.awt.Font("Merriweather", 0, 20)); // NOI18N
        btn_alteraSenha.setForeground(new java.awt.Color(255, 255, 255));
        btn_alteraSenha.setText("Alterar ");
        btn_alteraSenha.setBorder(null);
        btn_alteraSenha.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_alteraSenha.setPreferredSize(new java.awt.Dimension(240, 50));
        btn_alteraSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_alteraSenhaActionPerformed(evt);
            }
        });
        btn_alteraSenha.setUI(new RoundedCornerButtonUI());
        jPanel1.add(btn_alteraSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, -1, -1));

        lbl_codigo.setBackground(new java.awt.Color(255, 255, 255));
        lbl_codigo.setFont(new java.awt.Font("Merriweather", 0, 18)); // NOI18N
        lbl_codigo.setForeground(new java.awt.Color(0, 0, 0));
        lbl_codigo.setText("Código para recuperação de senha:");
        lbl_codigo.setPreferredSize(new java.awt.Dimension(500, 23));
        jPanel1.add(lbl_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, -1, -1));

        btn_exibirCodigo.setBackground(new java.awt.Color(77, 120, 63));
        btn_exibirCodigo.setFont(new java.awt.Font("Merriweather", 0, 20)); // NOI18N
        btn_exibirCodigo.setForeground(new java.awt.Color(255, 255, 255));
        btn_exibirCodigo.setText("Exibir");
        btn_exibirCodigo.setBorder(null);
        btn_exibirCodigo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_exibirCodigo.setPreferredSize(new java.awt.Dimension(240, 50));
        btn_exibirCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exibirCodigoActionPerformed(evt);
            }
        });
        btn_exibirCodigo.setUI(new RoundedCornerButtonUI());
        jPanel1.add(btn_exibirCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 350, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 103, -1, -1));

        jPanel_menu.setBackground(new java.awt.Color(124, 115, 101));
        jPanel_menu.setForeground(new java.awt.Color(124, 115, 101));
        jPanel_menu.setFont(new java.awt.Font("Merriweather", 0, 12)); // NOI18N
        jPanel_menu.setMinimumSize(new java.awt.Dimension(205, 768));
        jPanel_menu.setPreferredSize(new java.awt.Dimension(205, 768));
        jPanel_menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 205, 768));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Merriweather", 0, 45)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Configurações");
        jLabel2.setPreferredSize(new java.awt.Dimension(580, 58));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(598, 40, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BG_PADRAO.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_alteraSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_alteraSenhaActionPerformed
        // TODO add your handling code here:
        tela_redefinicao_senha telaSenha = new tela_redefinicao_senha();
        telaSenha.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_alteraSenhaActionPerformed

    private void btn_cadastrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cadastrarUsuarioActionPerformed
        // TODO add your handling code here:
        TELA_CADASTRO_USUARIO telaCadastroUsuario = new TELA_CADASTRO_USUARIO();
        telaCadastroUsuario.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_cadastrarUsuarioActionPerformed

    private void btn_exibirCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exibirCodigoActionPerformed
        JPasswordField passwordField = new JPasswordField();
        int option = JOptionPane.showConfirmDialog(null,
                passwordField,
                "Insira a senha:",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            String senhaDigitada = new String(passwordField.getPassword());

            String senhaCorreta = obterSenhaCorretaDoBanco();

            if (senhaCorreta != null && senhaCorreta.equals(senhaDigitada)) {

                String codigoGerado = "ABC123";

                JOptionPane.showMessageDialog(null,
                        "O código gerado é: " + codigoGerado,
                        "Código Gerado",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null,
                        "Senha incorreta. Tente novamente.",
                        "Erro de Autenticação",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "Operação cancelada.",
                    "Cancelado",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    private String obterSenhaCorretaDoBanco() {
        String senhaCorreta = null;
        try {
            Connection conexao = BD.getConnection();
            String query = "SELECT senha_usuario FROM usuario WHERE id_usuario = 1";
            PreparedStatement stmt = conexao.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                senhaCorreta = rs.getString("senha_usuario");
            }
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return senhaCorreta;
    }//GEN-LAST:event_btn_exibirCodigoActionPerformed

    /**
     * @param args the command line arguments
     */
    private void initMenuPanel() {
        MenuPanel menuPanel = new MenuPanel();
        jPanel_menu.add(menuPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 205, 768));
    }

    public class RecoveryCodeGenerator {

        public static String generateRecoveryCode() {
            SecureRandom random = new SecureRandom();
            StringBuilder code = new StringBuilder();

            for (int i = 0; i < 6; i++) {
                int digit = random.nextInt(10);
                code.append(digit);
            }
            return code.toString();
        }
    }

    public void onUserLogin(String userId) {
        String checkSql = "SELECT codigo_recuperacao FROM usuario WHERE id_usuario = ?";
        String updateSql = "UPDATE usuario SET codigo_recuperacao = ? WHERE id = ?";

        try (Connection con = BD.getConnection(); PreparedStatement checkStmt = con.prepareStatement(checkSql)) {

            checkStmt.setString(1, userId);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                String recoveryCode = rs.getString("codigo_recuperacao");

                if (recoveryCode == null || recoveryCode.isEmpty()) {
                    String newRecoveryCode = RecoveryCodeGenerator.generateRecoveryCode();
                    try (PreparedStatement updateStmt = con.prepareStatement(updateSql)) {
                        updateStmt.setString(1, newRecoveryCode);
                        updateStmt.setString(2, userId);
                        updateStmt.executeUpdate();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showRecoveryCode(String userId, String inputPassword) {
        String sql = "SELECT senha_usuario, codigo_recuperacao FROM usuario WHERE id_usuario = ?";
        try (Connection con = BD.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, userId);
            ResultSet rs = stmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
            java.util.logging.Logger.getLogger(Tela_config.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_config.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_config.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_config.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_config().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_alteraSenha;
    private javax.swing.JButton btn_cadastrarUsuario;
    private javax.swing.JButton btn_exibirCodigo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel_menu;
    private javax.swing.JLabel lbl_AlteraSenha;
    private javax.swing.JLabel lbl_cadastrarUsuario;
    private javax.swing.JLabel lbl_codigo;
    // End of variables declaration//GEN-END:variables
}
