/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import com.mycompany.petagenda.MenuPanel;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import ui.custom.RoundedCornerButtonUI;

/**
 *
 * @author kevin
 */
public class Tela_visualizacao_cliente extends javax.swing.JFrame {

    /**
     * Creates new form tela_cadastro_cliente
     */
    
    public Tela_visualizacao_cliente() {
        initComponents();
        initMenuPanel();
        AjustarColuna();
        carregarDadosTabela();
        mostrarEndereco();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_clientes = new javax.swing.JLabel();
        jPanel_tabela_clientes = new javax.swing.JPanel();
        jScrollPane_clientes_cadastrados = new javax.swing.JScrollPane();
        jtbl_clientes_cadastrados = new javax.swing.JTable();
        jPanel_menu = new javax.swing.JPanel();
        jbtn_cadastrarCliente = new javax.swing.JButton();
        jlbl_background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_clientes.setBackground(new java.awt.Color(255, 255, 255));
        lbl_clientes.setFont(new java.awt.Font("Merriweather", 0, 45)); // NOI18N
        lbl_clientes.setForeground(new java.awt.Color(0, 0, 0));
        lbl_clientes.setText("Clientes");
        getContentPane().add(lbl_clientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 20, -1, -1));

        jPanel_tabela_clientes.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_tabela_clientes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel_tabela_clientes.setMinimumSize(new java.awt.Dimension(905, 560));
        jPanel_tabela_clientes.setOpaque(false);
        jPanel_tabela_clientes.setPreferredSize(new java.awt.Dimension(915, 480));
        jPanel_tabela_clientes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane_clientes_cadastrados.setHorizontalScrollBar(null);
        jScrollPane_clientes_cadastrados.setPreferredSize(new java.awt.Dimension(915, 480));

        jtbl_clientes_cadastrados.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jtbl_clientes_cadastrados.setModel(new javax.swing.table.DefaultTableModel(
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
                "Nome do cliente", "CPF", "Telefone", "Serviço Contratado", "Endereço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbl_clientes_cadastrados.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtbl_clientes_cadastrados.setPreferredSize(new java.awt.Dimension(895, 480));
        jtbl_clientes_cadastrados.setRowHeight(30);
        jtbl_clientes_cadastrados.setShowHorizontalLines(true);
        jtbl_clientes_cadastrados.setShowVerticalLines(true);
        jtbl_clientes_cadastrados.getTableHeader().setReorderingAllowed(false);
        jScrollPane_clientes_cadastrados.setViewportView(jtbl_clientes_cadastrados);
        if (jtbl_clientes_cadastrados.getColumnModel().getColumnCount() > 0) {
            jtbl_clientes_cadastrados.getColumnModel().getColumn(0).setResizable(false);
            jtbl_clientes_cadastrados.getColumnModel().getColumn(1).setResizable(false);
            jtbl_clientes_cadastrados.getColumnModel().getColumn(2).setResizable(false);
            jtbl_clientes_cadastrados.getColumnModel().getColumn(3).setResizable(false);
            jtbl_clientes_cadastrados.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel_tabela_clientes.add(jScrollPane_clientes_cadastrados, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel_tabela_clientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 103, -1, -1));

        jPanel_menu.setBackground(new java.awt.Color(124, 115, 101));
        jPanel_menu.setForeground(new java.awt.Color(124, 115, 101));
        jPanel_menu.setFont(new java.awt.Font("Merriweather", 0, 12)); // NOI18N
        jPanel_menu.setMinimumSize(new java.awt.Dimension(205, 768));
        jPanel_menu.setPreferredSize(new java.awt.Dimension(205, 768));
        jPanel_menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 205, 768));

        jbtn_cadastrarCliente.setBackground(new java.awt.Color(77, 120, 63));
        jbtn_cadastrarCliente.setFont(new java.awt.Font("Merriweather", 0, 20)); // NOI18N
        jbtn_cadastrarCliente.setForeground(new java.awt.Color(255, 255, 255));
        jbtn_cadastrarCliente.setText("Cadastrar Cliente");
        jbtn_cadastrarCliente.setBorder(null);
        jbtn_cadastrarCliente.setPreferredSize(new java.awt.Dimension(240, 50));
        jbtn_cadastrarCliente.setUI(new RoundedCornerButtonUI());
        jbtn_cadastrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_cadastrarClienteActionPerformed(evt);
            }
        });
        getContentPane().add(jbtn_cadastrarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 620, -1, -1));

        jlbl_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BG_PADRAO.png"))); // NOI18N
        jlbl_background.setText(" ");
        jlbl_background.setMaximumSize(new java.awt.Dimension(1366, 768));
        jlbl_background.setMinimumSize(new java.awt.Dimension(1366, 768));
        jlbl_background.setPreferredSize(new java.awt.Dimension(1366, 768));
        getContentPane().add(jlbl_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtn_cadastrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_cadastrarClienteActionPerformed
        // TODO add your handling code here:
        Tela_cadastro_cliente telaCadCliente = new Tela_cadastro_cliente();
        telaCadCliente.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbtn_cadastrarClienteActionPerformed

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
        JTableHeader header = jtbl_clientes_cadastrados.getTableHeader();   
        header.setPreferredSize(new Dimension(0, 30));
        TableColumnModel modeloDaColuna = jtbl_clientes_cadastrados.getColumnModel();  

        // Organiza a tabela de acordo com os parametros.
        modeloDaColuna.getColumn(0).setCellRenderer(rendererEsquerda); // Nome
        modeloDaColuna.getColumn(1).setCellRenderer(rendererCentro); // CPF
        modeloDaColuna.getColumn(2).setCellRenderer(rendererCentro); // Telefone
        modeloDaColuna.getColumn(3).setCellRenderer(rendererEsquerda); // Serviço Contratado
        modeloDaColuna.getColumn(4).setCellRenderer(rendererCentro); // Endereço

        // Define o tamanho das colunas na tabela.
        modeloDaColuna.getColumn(0).setMaxWidth(300); // Nome
        modeloDaColuna.getColumn(1).setMaxWidth(120); // CPF
        modeloDaColuna.getColumn(2).setMaxWidth(130); // Telefone
        modeloDaColuna.getColumn(3).setMaxWidth(145); // Serviço Contratado
        modeloDaColuna.getColumn(4).setMaxWidth(199); // Endereço
    }
    
    private void initMenuPanel() {
        MenuPanel menuPanel = new MenuPanel();
        jPanel_menu.add(menuPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 205, 768));
    }

    private void carregarDadosTabela() {
        // Conexão com o banco.
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String banco = "jdbc:mysql://localhost:3306/pet_agenda";
        String usuario = "root";
        String senha = "";
        
        // Tabela.
        DefaultTableModel modelo = (DefaultTableModel) jtbl_clientes_cadastrados.getModel();
        modelo.setNumRows(0);

        try {
            conn = DriverManager.getConnection(banco, usuario, senha); // Iniciando a conexão com o banco.

            String sql = "SELECT * FROM visualizacao_cliente";
            stmt = conn.prepareStatement(sql);

            rs = stmt.executeQuery();
            while (rs.next()) {
                Object[] linha = {
                        rs.getString("nome_cliente"),
                        rs.getString("cpf"),
                        rs.getString("telefone"),
                        rs.getString("nome_servico"),
                        (rs.getString("rua")) + ", " + (rs.getString("numero")) + " - " + (rs.getString("bairro")) + " - " + (rs.getString("cidade")) + " - " + (rs.getString("cep"))
                    };
                modelo.addRow(linha); // Adiciona a linha a tabela.
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void mostrarEndereco () {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Tela_visualizacao_cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Adicionando MouseListener
        jtbl_clientes_cadastrados.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Obter a linha em que o mouse está passando
                int row = jtbl_clientes_cadastrados.rowAtPoint(e.getPoint());
                
                // Exibir conteúdo da linha quando o mouse entra
                if (row != -1) {
                    String endereco = (String) jtbl_clientes_cadastrados.getValueAt(row, 4);

                    jtbl_clientes_cadastrados.setToolTipText(endereco);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Remover o Tooltip quando o mouse sair da linha
                jtbl_clientes_cadastrados.setToolTipText(null);
            }
        });
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
            java.util.logging.Logger.getLogger(Tela_visualizacao_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_visualizacao_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_visualizacao_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_visualizacao_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_visualizacao_cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel_menu;
    private javax.swing.JPanel jPanel_tabela_clientes;
    private javax.swing.JScrollPane jScrollPane_clientes_cadastrados;
    private javax.swing.JButton jbtn_cadastrarCliente;
    private javax.swing.JLabel jlbl_background;
    private javax.swing.JTable jtbl_clientes_cadastrados;
    private javax.swing.JLabel lbl_clientes;
    // End of variables declaration//GEN-END:variables

}
