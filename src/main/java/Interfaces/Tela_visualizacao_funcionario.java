/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import com.mycompany.petagenda.MenuPanel;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import petagenda.bd.BD;
import petagenda.Funcionario;
import ui.custom.RoundedCornerBorder;
import ui.custom.RoundedCornerButtonUI;

/**
 *
 * @author kevin
 */
public class Tela_visualizacao_funcionario extends javax.swing.JFrame {

    /**
     * Creates new form tela_cadastro_funcionario
     */
    public Tela_visualizacao_funcionario() {
        initComponents();
        initMenuPanel();
        AjustarColuna();
        carregarDadosTabela();
        
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
        btn_cadastrarFuncionario = new javax.swing.JButton();
        jPanel_tabela = new javax.swing.JPanel();
        jScroll_tabela = new javax.swing.JScrollPane();
        jtbl_funcionarios = new javax.swing.JTable();
        lbl_funcionarios = new javax.swing.JLabel();
        jlbl_background = new javax.swing.JLabel();

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

        btn_cadastrarFuncionario.setBackground(new java.awt.Color(77, 120, 63));
        btn_cadastrarFuncionario.setFont(new java.awt.Font("Merriweather", 0, 20)); // NOI18N
        btn_cadastrarFuncionario.setForeground(new java.awt.Color(255, 255, 255));
        btn_cadastrarFuncionario.setText("Cadastrar Funcionário");
        btn_cadastrarFuncionario.setBorder(null);
        btn_cadastrarFuncionario.setPreferredSize(new java.awt.Dimension(240, 50));
        btn_cadastrarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cadastrarFuncionarioActionPerformed(evt);
            }
        });
        btn_cadastrarFuncionario.setUI(new RoundedCornerButtonUI());
        getContentPane().add(btn_cadastrarFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 630, -1, -1));

        jPanel_tabela.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_tabela.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel_tabela.setMinimumSize(new java.awt.Dimension(905, 560));
        jPanel_tabela.setOpaque(false);
        jPanel_tabela.setPreferredSize(new java.awt.Dimension(830, 480));
        jPanel_tabela.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScroll_tabela.setPreferredSize(new java.awt.Dimension(830, 480));
        jScroll_tabela.setVerifyInputWhenFocusTarget(false);

        jtbl_funcionarios.setFont(new java.awt.Font("Merriweather", 0, 16)); // NOI18N
        jtbl_funcionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nome", "CPF", "Telefone", "Serviço Prestado", "Endereço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbl_funcionarios.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtbl_funcionarios.setPreferredSize(new java.awt.Dimension(830, 1200));
        jtbl_funcionarios.setRowHeight(30);
        jtbl_funcionarios.setShowHorizontalLines(true);
        jtbl_funcionarios.setShowVerticalLines(true);
        jtbl_funcionarios.getTableHeader().setReorderingAllowed(false);
        jScroll_tabela.setViewportView(jtbl_funcionarios);
        if (jtbl_funcionarios.getColumnModel().getColumnCount() > 0) {
            jtbl_funcionarios.getColumnModel().getColumn(0).setResizable(false);
            jtbl_funcionarios.getColumnModel().getColumn(1).setResizable(false);
            jtbl_funcionarios.getColumnModel().getColumn(2).setResizable(false);
            jtbl_funcionarios.getColumnModel().getColumn(3).setResizable(false);
            jtbl_funcionarios.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel_tabela.add(jScroll_tabela, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel_tabela, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 103, -1, -1));

        lbl_funcionarios.setBackground(new java.awt.Color(255, 255, 255));
        lbl_funcionarios.setFont(new java.awt.Font("Merriweather", 0, 45)); // NOI18N
        lbl_funcionarios.setForeground(new java.awt.Color(0, 0, 0));
        lbl_funcionarios.setText("Funcionários");
        getContentPane().add(lbl_funcionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, -1, -1));

        jlbl_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BG_PADRAO.png"))); // NOI18N
        jlbl_background.setText(" ");
        jlbl_background.setMaximumSize(new java.awt.Dimension(1366, 768));
        jlbl_background.setMinimumSize(new java.awt.Dimension(1366, 768));
        jlbl_background.setPreferredSize(new java.awt.Dimension(1366, 768));
        getContentPane().add(jlbl_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cadastrarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cadastrarFuncionarioActionPerformed
        tela_cadastro_funcionario frame = new tela_cadastro_funcionario();
        frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_cadastrarFuncionarioActionPerformed
    
    // Personaliza a "width" da coluna em geral.
    private void AjustarColuna() {
        // Centraliza a coluna.
        DefaultTableCellRenderer rendererCentro = new DefaultTableCellRenderer();
        rendererCentro.setHorizontalAlignment(SwingConstants.CENTER);
        
        // Alinha a coluna a direita.
        DefaultTableCellRenderer rendererDireita = new DefaultTableCellRenderer();  
        rendererDireita.setHorizontalAlignment(SwingConstants.RIGHT);
        
        // Alinha a coluna a esquerda.
        DefaultTableCellRenderer rendererEsquerda = new DefaultTableCellRenderer();  
        rendererEsquerda.setHorizontalAlignment(SwingConstants.LEFT);  

        // Define o tamanho do cabeçalho.
        JTableHeader header = jtbl_funcionarios.getTableHeader();   
        header.setPreferredSize(new Dimension(0, 30));
        TableColumnModel modeloDaColuna = jtbl_funcionarios.getColumnModel();  

        // Organiza a tabela de acordo com os parametros.
        modeloDaColuna.getColumn(0).setCellRenderer(rendererEsquerda); // Nome
        modeloDaColuna.getColumn(1).setCellRenderer(rendererCentro); // CPF
        modeloDaColuna.getColumn(2).setCellRenderer(rendererCentro); // Telefone
        modeloDaColuna.getColumn(3).setCellRenderer(rendererCentro); // Serviço Prestado
        modeloDaColuna.getColumn(4).setCellRenderer(rendererCentro); // Endereço

        // Define o tamanho das colunas na tabela.
        modeloDaColuna.getColumn(0).setMaxWidth(300); // Nome
        modeloDaColuna.getColumn(1).setMaxWidth(120); // CPF
        modeloDaColuna.getColumn(2).setMaxWidth(130); // Telefone
        modeloDaColuna.getColumn(3).setMaxWidth(180); // Serviço Prestado
        modeloDaColuna.getColumn(4).setMaxWidth(100); // Endereço
    }
    
    private void initMenuPanel() {
        MenuPanel menuPanel = new MenuPanel();
        jPanel_menu.add(menuPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 205, 768));
    }

    private void carregarDadosTabela() {
        Funcionario[] funcionarios = BD.Funcionario.selectAll();
        
        DefaultTableModel modelo = (DefaultTableModel) jtbl_funcionarios.getModel();
        modelo.setNumRows(0);
            
        if (funcionarios != null) {
            // Preenche cada linha com cada funcionário dentro de funcionários.
            for (Funcionario funcionario : funcionarios) {
                String endereco = funcionario.getRua() + ", " + funcionario.getNumero() + " - " + funcionario.getBairro() + " - " + funcionario.getCidade() + " - " + funcionario.getCep();
                Object[] linha = {
                        funcionario.getNome(),
                        funcionario.getCpf().toString(),
                        funcionario.getTelefone(),
                        "Dog Walking/Pet Sitting",
                        //"Ver",
                        endereco
                    };
                modelo.addRow(linha); // Adiciona a linha a tabela.
            }
        }
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
            java.util.logging.Logger.getLogger(Tela_visualizacao_funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_visualizacao_funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_visualizacao_funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_visualizacao_funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and displjScroll_tabela*/
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_visualizacao_funcionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cadastrarFuncionario;
    private javax.swing.JPanel jPanel_menu;
    private javax.swing.JPanel jPanel_tabela;
    private javax.swing.JScrollPane jScroll_tabela;
    private javax.swing.JLabel jlbl_background;
    private javax.swing.JTable jtbl_funcionarios;
    private javax.swing.JLabel lbl_funcionarios;
    // End of variables declaration//GEN-END:variables

}
