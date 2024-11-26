/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import com.mycompany.petagenda.MenuPanel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ui.custom.RoundedCornerButtonUI;

/**
 *
 * @author d.rodrigues
 */
public class Tela_visu_finance extends javax.swing.JFrame {

    /**
     * Creates new form Tela_visu_finance
     */
    public Tela_visu_finance() {
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
        jBtn_visualizar = new javax.swing.JButton();
        jBtn_criar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_telaFinance = new javax.swing.JTable();
        jLbl_BGpadrao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel_menu.setBackground(new java.awt.Color(124, 115, 101));
        jPanel_menu.setForeground(new java.awt.Color(124, 115, 101));
        jPanel_menu.setFont(new java.awt.Font("Merriweather", 0, 12)); // NOI18N
        jPanel_menu.setMinimumSize(new java.awt.Dimension(205, 768));
        jPanel_menu.setPreferredSize(new java.awt.Dimension(205, 768));
        jPanel_menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 205, 768));

        jBtn_visualizar.setFont(new java.awt.Font("Merriweather", 0, 16)); // NOI18N
        jBtn_visualizar.setForeground(new java.awt.Color(255, 255, 255));
        jBtn_visualizar.setText("Visualizar Registros");
        jBtn_visualizar.setPreferredSize(new java.awt.Dimension(200, 50));
        jBtn_visualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_visualizarActionPerformed(evt);
            }
        });
        jBtn_visualizar.setUI(new RoundedCornerButtonUI());
        getContentPane().add(jBtn_visualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 580, -1, -1));

        jBtn_criar.setFont(new java.awt.Font("Merriweather", 0, 16)); // NOI18N
        jBtn_criar.setForeground(new java.awt.Color(255, 255, 255));
        jBtn_criar.setText("Inserir Registro");
        jBtn_criar.setPreferredSize(new java.awt.Dimension(200, 50));
        jBtn_criar.setUI(new RoundedCornerButtonUI());
        jBtn_criar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_criarActionPerformed(evt);
            }
        });
        getContentPane().add(jBtn_criar, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 580, -1, -1));

        jTable_telaFinance.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTable_telaFinance.setFont(new java.awt.Font("Merriweather", 0, 20)); // NOI18N
        jTable_telaFinance.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Data", "Descrição", "Entrada", "Saida"
            }
        ));
        jTable_telaFinance.setPreferredSize(new java.awt.Dimension(989, 523));
        jScrollPane1.setViewportView(jTable_telaFinance);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 810, 480));

        jLbl_BGpadrao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BG_PADRAO.png"))); // NOI18N
        getContentPane().add(jLbl_BGpadrao, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, 768));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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


    private void jBtn_visualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_visualizarActionPerformed
        String mesEscolhido = JOptionPane.showInputDialog(this, "Digite o ano e o mês (formato: aaaa-mm ou aaaa/mm):");

        if (mesEscolhido == null || mesEscolhido.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, insira o mês no formato aaaa-mm ou aaaa/mm.");
            return;
        }
        // Verificador de formato válido para consulta
        if (!mesEscolhido.matches("\\d{4}[-/]\\d{2}")) {
            JOptionPane.showMessageDialog(this, "Formato inválido. Por favor, insira o mês no formato aaaa-mm ou aaaa/mm.");
            return;
        }

        // converte o formato para consulta no BD
        if (mesEscolhido.contains("/")) {
            mesEscolhido = mesEscolhido.replace("/", "-");
        }

        DefaultTableModel model = (DefaultTableModel) jTable_telaFinance.getModel();
        model.setRowCount(0);

        try (Connection conn = ConexaoMySQL.conectar()) {
            if (conn != null) {
                // Consulta SQL para obter registros do mês escolhido
                String sql = "SELECT data_registro, descricao, entrada, saida FROM financeiro WHERE DATE_FORMAT(data_registro, '%Y-%m') = ?";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, mesEscolhido);  // Passa o mês escolhido como parâmetro

                    // Executa a consulta
                    ResultSet rs = stmt.executeQuery();

                    // Preenche a tabela com os dados retornados
                    while (rs.next()) {
                        String data = rs.getString("data_registro");
                        String descricao = rs.getString("descricao");
                        String entrada = rs.getString("entrada");
                        String saida = rs.getString("saida");

                        model.addRow(new Object[]{data, descricao, entrada, saida});
                    }

                    if (model.getRowCount() == 0) {
                        JOptionPane.showMessageDialog(this, "Nenhum registro encontrado para o mês " + mesEscolhido + ".");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Falha na conexão com o banco de dados.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao buscar registros: " + e.getMessage());
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jBtn_visualizarActionPerformed

    private void jBtn_criarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_criarActionPerformed
        // TODO add your handling code here:
        String data = JOptionPane.showInputDialog(this, "Digite a data (ex: aaaa/mm/dd):");
        String descricao = JOptionPane.showInputDialog(this, "Digite a descrição:");
        String entrada = JOptionPane.showInputDialog(this, "Digite o valor de entrada:");
        String saida = JOptionPane.showInputDialog(this, "Digite o valor de saída (opcional):");

        if (data.isEmpty() && descricao.isEmpty() && entrada.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos obrigatórios (data, descrição, entrada)");
            return;
        }
        entrada = entrada.replace(",", ".");
        if (!saida.isEmpty()) {
            saida.replace(",", ".");
        } else {
            saida = "0.00";
        }
        try {
            Double.parseDouble(entrada);
            Double.parseDouble(saida);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, insira valores numéricos válidos para entrada e saída.");
            return;
        }

        try (Connection conn = ConexaoMySQL.conectar()) {
            if (conn != null) {
                String sql = "INSERT INTO financeiro (data_registro, descricao, entrada, saida) VALUES (?, ?, ?, ?)";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, data);
                    stmt.setString(2, descricao);
                    stmt.setDouble(3, Double.parseDouble(entrada));
                    stmt.setDouble(4, Double.parseDouble(saida));
                    int rowsAffected = stmt.executeUpdate();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(this, "Registro inserido com sucesso!");
                        DefaultTableModel model = (DefaultTableModel) jTable_telaFinance.getModel();
                        model.addRow(new Object[]{data, descricao, entrada, saida});
                    } else {
                        JOptionPane.showMessageDialog(this, "Erro ao inserir registro no banco de dados.");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Falha na conexão com o banco de dados.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao inserir registro: " + e.getMessage());
        }
    }//GEN-LAST:event_jBtn_criarActionPerformed

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
            java.util.logging.Logger.getLogger(Tela_visu_finance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_visu_finance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_visu_finance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_visu_finance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_visu_finance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtn_criar;
    private javax.swing.JButton jBtn_visualizar;
    private javax.swing.JLabel jLbl_BGpadrao;
    private javax.swing.JPanel jPanel_menu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_telaFinance;
    // End of variables declaration//GEN-END:variables
}
