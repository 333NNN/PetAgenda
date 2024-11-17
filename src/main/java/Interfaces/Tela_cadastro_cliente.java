/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import com.mycompany.petagenda.MenuPanel;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import petagenda.Cliente;
import petagenda.Usuario;
import petagenda.bd.BD;
import petagenda.dados.Endereco;
import petagenda.dados.LocalAtuacao;
import petagenda.exception.IllegalArgumentsException;
import petagenda.servico.Servico;
import ui.custom.RoundedCornerButtonUI;
import ui.custom.RoundedCornerBorder;

/**
 *
 * @author c.nunes
 */
public class Tela_cadastro_cliente extends javax.swing.JFrame {

    public class ConexaoMySQL {
        private static final String URL = "jdbc:mysql://localhost:3306/pet_agenda";
        private static final String USER = "root";
        private static final String PASSWORD = "";

        public static Connection conectar() {
            try {
                return DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                System.out.println("Erro ao conectar: " + e.getMessage());
                return null;
            }
        }
    }

    /**
     * Creates new form Interface_cliente
     */
    public Tela_cadastro_cliente() {
        // Validação de login.
        /*
        if (Usuario.getAtual() != null) {

        }
        else {
            JOptionPane.showMessageDialog(null, "É necessário estar logado para acessar esta funcionalidade.");
            super.dispose();
            System.exit(0);
        }
        */

        initComponents();
        initMenuPanel();
        AlinhaJField();
    }
    
    private void AlinhaJField() {
        Border line = BorderFactory.createLineBorder(Color.BLACK, 2);
        Border empty = new EmptyBorder(0, 5, 0, 0);
        CompoundBorder border = new CompoundBorder(line, empty);

        jtxtf_campo_nome_cliente.setBorder(border);
        jtxtf_campo_cpf.setBorder(border);
        jtxtf_campo_telefone.setBorder(border);
        jcbox_Selecao_servico.setBorder(border);
        jtxtf_campo_cep.setBorder(border);
        jtxtf_campo_num.setBorder(border);
        jtxtf_campo_rua.setBorder(border);
        jtxtf_campo_bairro.setBorder(border);
        jtxtf_campo_cidade.setBorder(border);
    }
    
    // Recebe as informações dos campos em um novo objeto do tipo petagenda.Cliente
    private Cliente getFieldInfo() throws SQLException {
        Cliente novo_cliente = null;
        String nome, cpf, telefone, rua, numero, bairro, cidade, cep, buscar_com, devolver_pet_para;
        
        nome = jtxtf_campo_nome_cliente.getText();
        cpf = jtxtf_campo_cpf.getText();
        telefone = jtxtf_campo_telefone.getText();
        cep = jtxtf_campo_cep.getText();
        numero = jtxtf_campo_num.getText();
        rua = jtxtf_campo_rua.getText();
        bairro = jtxtf_campo_bairro.getText();
        cidade = jtxtf_campo_cidade.getText();
        
        // TEMPORARIO
        buscar_com = jtxtf_campo_nome_cliente.getText();
        devolver_pet_para = jtxtf_campo_nome_cliente.getText();
        
        
        IllegalArgumentsException exsCadastro = new IllegalArgumentsException();
        
        // Criação do cliente.
        try {
            novo_cliente = new Cliente(nome, cpf, telefone, rua, numero, bairro, cidade, cep, buscar_com, devolver_pet_para);
        }
        catch (IllegalArgumentsException exs) {
            exsCadastro.addCause(exs.getCauses());
        }
        
        // Se houver exceções de validação, exibe as mensagens.
        if (exsCadastro.size() > 0) {
            Throwable[] todasCauses = exsCadastro.getCauses();
            Arrays.sort(todasCauses);
            
            StringBuilder erros = new StringBuilder();
            
            for (Throwable c: todasCauses) {
                if (c != null) {
                    erros.append(c.getMessage());
                    erros.append("\n");
                }
            }
            
            JOptionPane.showMessageDialog(null, erros.toString(), "Campos inválidos", JOptionPane.ERROR_MESSAGE);
        }
        
        return novo_cliente;
    }
    
    // Limpa as informações dos campos de Usuario
    private void clearFieldsInfo() {
        jtxtf_campo_nome_cliente.setText(null);
        jtxtf_campo_cpf.setText(null);
        jtxtf_campo_telefone.setText(null);
        //jcbox_Selecao_servico.setBorder(border);
        jtxtf_campo_cep.setText(null);
        jtxtf_campo_num.setText(null);
        jtxtf_campo_rua.setText(null);
        jtxtf_campo_bairro.setText(null);
        jtxtf_campo_cidade.setText(null);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel_menu = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jtxtf_campo_nome_cliente = new javax.swing.JTextField();
        jlbl_nome_cliente = new javax.swing.JLabel();
        jtxtf_campo_cpf = new javax.swing.JTextField();
        jlbl_cpf = new javax.swing.JLabel();
        jtxtf_campo_telefone = new javax.swing.JTextField();
        jlbl_telefone = new javax.swing.JLabel();
        jlbl_servico_contratado = new javax.swing.JLabel();
        jcbox_Selecao_servico = new javax.swing.JComboBox<>();
        jtxtf_campo_cep = new javax.swing.JTextField();
        jlbl_cep = new javax.swing.JLabel();
        jtxtf_campo_num = new javax.swing.JTextField();
        jlbl_rua = new javax.swing.JLabel();
        jtxtf_campo_rua = new javax.swing.JTextField();
        jlbl_bairro = new javax.swing.JLabel();
        jtxtf_campo_bairro = new javax.swing.JTextField();
        jtxtf_campo_cidade = new javax.swing.JTextField();
        jlbl_cidade = new javax.swing.JLabel();
        jlbl_titulo = new javax.swing.JLabel();
        jlbl_num = new javax.swing.JLabel();
        jbtn_Cadastrar_cliente = new javax.swing.JButton();
        jlbl_background = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel_menu.setBackground(new java.awt.Color(124, 115, 101));
        jPanel_menu.setForeground(new java.awt.Color(124, 115, 101));
        jPanel_menu.setFont(new java.awt.Font("Merriweather", 0, 12)); // NOI18N
        jPanel_menu.setMinimumSize(new java.awt.Dimension(205, 768));
        jPanel_menu.setPreferredSize(new java.awt.Dimension(205, 768));
        jPanel_menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 205, 768));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtxtf_campo_nome_cliente.setBackground(new java.awt.Color(255, 255, 255));
        jtxtf_campo_nome_cliente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtf_campo_nome_cliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jtxtf_campo_nome_cliente.setCaretColor(new java.awt.Color(255, 255, 255));
        jtxtf_campo_nome_cliente.setMinimumSize(new java.awt.Dimension(550, 50));
        jtxtf_campo_nome_cliente.setPreferredSize(new java.awt.Dimension(550, 50));
        jPanel1.add(jtxtf_campo_nome_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 106, -1, 52));

        jlbl_nome_cliente.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_nome_cliente.setText("Nome completo do cliente:");
        jPanel1.add(jlbl_nome_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 85, 200, 20));

        jtxtf_campo_cpf.setBackground(new java.awt.Color(255, 255, 255));
        jtxtf_campo_cpf.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtf_campo_cpf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jtxtf_campo_cpf.setPreferredSize(new java.awt.Dimension(250, 50));
        jPanel1.add(jtxtf_campo_cpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 195, -1, -1));

        jlbl_cpf.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_cpf.setText("CPF:");
        jPanel1.add(jlbl_cpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 176, -1, -1));

        jtxtf_campo_telefone.setBackground(new java.awt.Color(255, 255, 255));
        jtxtf_campo_telefone.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtf_campo_telefone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jtxtf_campo_telefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtf_campo_telefoneActionPerformed(evt);
            }
        });
        jPanel1.add(jtxtf_campo_telefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 195, 270, 50));

        jlbl_telefone.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_telefone.setText("Telefone:");
        jPanel1.add(jlbl_telefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 176, -1, -1));

        jlbl_servico_contratado.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_servico_contratado.setText("Serviço contratado:");
        jlbl_servico_contratado.setMinimumSize(new java.awt.Dimension(150, 15));
        jlbl_servico_contratado.setPreferredSize(new java.awt.Dimension(150, 15));
        jPanel1.add(jlbl_servico_contratado, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 265, 150, 15));

        jcbox_Selecao_servico.setBackground(new java.awt.Color(255, 255, 255));
        jcbox_Selecao_servico.setFont(new java.awt.Font("Merriweather", 0, 14)); // NOI18N
        jcbox_Selecao_servico.setForeground(new java.awt.Color(217, 217, 217));
        jcbox_Selecao_servico.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jcbox_Selecao_servico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jcbox_Selecao_servico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbox_Selecao_servicoActionPerformed(evt);
            }
        });
        jPanel1.add(jcbox_Selecao_servico, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 284, 250, 50));

        jtxtf_campo_cep.setBackground(new java.awt.Color(255, 255, 255));
        jtxtf_campo_cep.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtf_campo_cep.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jtxtf_campo_cep.setPreferredSize(new java.awt.Dimension(150, 50));
        jPanel1.add(jtxtf_campo_cep, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 284, 150, 50));

        jlbl_cep.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_cep.setText("CEP:");
        jPanel1.add(jlbl_cep, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 265, -1, -1));

        jtxtf_campo_num.setBackground(new java.awt.Color(255, 255, 255));
        jtxtf_campo_num.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtf_campo_num.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.add(jtxtf_campo_num, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 284, 90, 50));

        jlbl_rua.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_rua.setText("Rua:");
        jPanel1.add(jlbl_rua, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 354, -1, -1));

        jtxtf_campo_rua.setBackground(new java.awt.Color(255, 255, 255));
        jtxtf_campo_rua.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtf_campo_rua.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.add(jtxtf_campo_rua, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 373, 550, 50));

        jlbl_bairro.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_bairro.setText("Bairro:");
        jlbl_bairro.setPreferredSize(new java.awt.Dimension(52, 15));
        jPanel1.add(jlbl_bairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 443, -1, -1));

        jtxtf_campo_bairro.setBackground(new java.awt.Color(255, 255, 255));
        jtxtf_campo_bairro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtf_campo_bairro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.add(jtxtf_campo_bairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 462, 270, 50));

        jtxtf_campo_cidade.setBackground(new java.awt.Color(255, 255, 255));
        jtxtf_campo_cidade.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtf_campo_cidade.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jtxtf_campo_cidade.setPreferredSize(new java.awt.Dimension(300, 60));
        jPanel1.add(jtxtf_campo_cidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 462, 250, 50));

        jlbl_cidade.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_cidade.setText("Cidade:");
        jlbl_cidade.setPreferredSize(new java.awt.Dimension(56, 15));
        jPanel1.add(jlbl_cidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(349, 443, -1, -1));

        jlbl_titulo.setBackground(new java.awt.Color(0, 0, 0));
        jlbl_titulo.setFont(new java.awt.Font("Merriweather", 0, 45)); // NOI18N
        jlbl_titulo.setText("Cadastrar cliente");
        jlbl_titulo.setMaximumSize(new java.awt.Dimension(377, 45));
        jlbl_titulo.setMinimumSize(new java.awt.Dimension(377, 45));
        jlbl_titulo.setPreferredSize(new java.awt.Dimension(377, 45));
        jPanel1.add(jlbl_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 377, 45));

        jlbl_num.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_num.setText("N°");
        jPanel1.add(jlbl_num, new org.netbeans.lib.awtextra.AbsoluteConstraints(508, 265, -1, -1));

        jbtn_Cadastrar_cliente.setBackground(new java.awt.Color(77, 120, 63));
        jbtn_Cadastrar_cliente.setFont(new java.awt.Font("Merriweather", 0, 20)); // NOI18N
        jbtn_Cadastrar_cliente.setForeground(new java.awt.Color(255, 255, 255));
        jbtn_Cadastrar_cliente.setText("CADASTRAR");
        jbtn_Cadastrar_cliente.setBorder(null);
        jbtn_Cadastrar_cliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtn_Cadastrar_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_Cadastrar_clienteActionPerformed(evt);
            }
        });
        // Aplicando a UI personalizada
        jbtn_Cadastrar_cliente.setUI(new RoundedCornerButtonUI());
        jPanel1.add(jbtn_Cadastrar_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 557, 240, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(371, 40, 630, 640));

        jlbl_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BG_PADRAO.png"))); // NOI18N
        jlbl_background.setFocusable(false);
        jlbl_background.setRequestFocusEnabled(false);
        jlbl_background.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(jlbl_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, 768));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jtxtf_campo_telefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtf_campo_telefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtf_campo_telefoneActionPerformed

    private void jbtn_Cadastrar_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_Cadastrar_clienteActionPerformed
        // TODO add your handling code here:
        Cliente cadastrar = null;
        
        
        try {
            cadastrar = getFieldInfo(); // Retornara null se informações não forem válidas.
            
        }
        catch (SQLException ex) {
            Logger.getLogger(Tela_cadastro_cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (cadastrar != null) {
            int r = BD.Cliente.insert(cadastrar);
            if (r > 0) { // Foi cadastrado.
                clearFieldsInfo();
                JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
            }
        }
    }//GEN-LAST:event_jbtn_Cadastrar_clienteActionPerformed

    private void jcbox_Selecao_servicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbox_Selecao_servicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbox_Selecao_servicoActionPerformed

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
            java.util.logging.Logger.getLogger(Tela_cadastro_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_cadastro_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_cadastro_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_cadastro_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_cadastro_cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel_menu;
    private javax.swing.JButton jbtn_Cadastrar_cliente;
    private javax.swing.JComboBox<petagenda.servico.Servico> jcbox_Selecao_servico;
    private javax.swing.JLabel jlbl_background;
    private javax.swing.JLabel jlbl_bairro;
    private javax.swing.JLabel jlbl_cep;
    private javax.swing.JLabel jlbl_cidade;
    private javax.swing.JLabel jlbl_cpf;
    private javax.swing.JLabel jlbl_nome_cliente;
    private javax.swing.JLabel jlbl_num;
    private javax.swing.JLabel jlbl_rua;
    private javax.swing.JLabel jlbl_servico_contratado;
    private javax.swing.JLabel jlbl_telefone;
    private javax.swing.JLabel jlbl_titulo;
    private javax.swing.JTextField jtxtf_campo_bairro;
    private javax.swing.JTextField jtxtf_campo_cep;
    private javax.swing.JTextField jtxtf_campo_cidade;
    private javax.swing.JTextField jtxtf_campo_cpf;
    private javax.swing.JTextField jtxtf_campo_nome_cliente;
    private javax.swing.JTextField jtxtf_campo_num;
    private javax.swing.JTextField jtxtf_campo_rua;
    private javax.swing.JTextField jtxtf_campo_telefone;
    // End of variables declaration//GEN-END:variables

    private void initMenuPanel() {
        MenuPanel menuPanel = new MenuPanel();
        jPanel_menu.add(menuPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 205, 768));
    }
}
