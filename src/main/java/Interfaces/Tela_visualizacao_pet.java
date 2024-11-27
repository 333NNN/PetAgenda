/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import static Interfaces.Tela_visualizacao_funcionario.id_funcionario;
import com.mycompany.petagenda.MenuPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import petagenda.Cliente;
import petagenda.Funcionario;
import petagenda.Pet;
import petagenda.bd.BD;
import ui.custom.RoundedCornerBorder;
import ui.custom.RoundedCornerButtonUI;

/**
 *
 * @author kevin
 */

public class Tela_visualizacao_pet extends javax.swing.JFrame {

    /**
     * Creates new form tela_cadastro_funcionario
     */
    public static int id_pet; // id do pet, vai ser acessado pela tela de atualização de funcionario.
    public static int id_cliente; // id do cliente, relacionado ao pet.
    private static int linha_selecionada_pet; // Linha selecionada, usada para achar o id_pet.
    private static final ArrayList<Integer> todos_ids_pet = new ArrayList<>();  // todos os ids da tabela.
    private static final ArrayList<Integer> todos_ids_clientes = new ArrayList<>(); // todos os ids dos clientes.
    
    public Tela_visualizacao_pet() {
        initComponents();
        initMenuPanel();
        AjustarColuna();
        linha_selecionada_pet = -1;
        todos_ids_pet.clear();
        carregarDadosTabela();
        moveHeader();
        jPanel_deletar.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
        jPanel_editar.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_funcionarios = new javax.swing.JLabel();
        jPanel_menu = new javax.swing.JPanel();
        jbtn_cadastrarPet = new javax.swing.JButton();
        jPanel_tabela_pet = new javax.swing.JPanel();
        jScroll_tabela = new javax.swing.JScrollPane();
        jtbl_visualizacao_pet = new javax.swing.JTable();
        jPanel_deletar = new javax.swing.JPanel();
        jlbl_deletar = new javax.swing.JLabel();
        jPanel_editar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jlbl_background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_funcionarios.setBackground(new java.awt.Color(255, 255, 255));
        lbl_funcionarios.setFont(new java.awt.Font("Merriweather", 0, 45)); // NOI18N
        lbl_funcionarios.setForeground(new java.awt.Color(0, 0, 0));
        lbl_funcionarios.setText("Pets");
        getContentPane().add(lbl_funcionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 20, -1, -1));

        jPanel_menu.setBackground(new java.awt.Color(124, 115, 101));
        jPanel_menu.setForeground(new java.awt.Color(124, 115, 101));
        jPanel_menu.setFont(new java.awt.Font("Merriweather", 0, 12)); // NOI18N
        jPanel_menu.setMinimumSize(new java.awt.Dimension(205, 768));
        jPanel_menu.setPreferredSize(new java.awt.Dimension(205, 768));
        jPanel_menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 205, 768));

        jbtn_cadastrarPet.setBackground(new java.awt.Color(77, 120, 63));
        jbtn_cadastrarPet.setFont(new java.awt.Font("Merriweather", 0, 20)); // NOI18N
        jbtn_cadastrarPet.setForeground(new java.awt.Color(255, 255, 255));
        jbtn_cadastrarPet.setText("Cadastrar Pet");
        jbtn_cadastrarPet.setBorder(null);
        jbtn_cadastrarPet.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtn_cadastrarPet.setPreferredSize(new java.awt.Dimension(240, 50));
        jbtn_cadastrarPet.setUI(new RoundedCornerButtonUI());
        jbtn_cadastrarPet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_cadastrarPetActionPerformed(evt);
            }
        });
        getContentPane().add(jbtn_cadastrarPet, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 620, -1, -1));

        jPanel_tabela_pet.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_tabela_pet.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel_tabela_pet.setMinimumSize(new java.awt.Dimension(905, 560));
        jPanel_tabela_pet.setOpaque(false);
        jPanel_tabela_pet.setPreferredSize(new java.awt.Dimension(915, 480));
        jPanel_tabela_pet.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScroll_tabela.setPreferredSize(new java.awt.Dimension(915, 480));
        jScroll_tabela.setVerifyInputWhenFocusTarget(false);

        jtbl_visualizacao_pet.setFont(new java.awt.Font("Merriweather", 0, 16)); // NOI18N
        jtbl_visualizacao_pet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome do pet", "Nome do dono", "Raça", "Cor", "Porte", "Sexo", "Castrado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbl_visualizacao_pet.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtbl_visualizacao_pet.setPreferredSize(new java.awt.Dimension(1070, 480));
        jtbl_visualizacao_pet.setRowHeight(30);
        jtbl_visualizacao_pet.setShowHorizontalLines(true);
        jtbl_visualizacao_pet.setShowVerticalLines(true);
        jtbl_visualizacao_pet.getTableHeader().setReorderingAllowed(false);
        jtbl_visualizacao_pet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jtbl_visualizacao_petMouseEntered(evt);
            }
        });
        jScroll_tabela.setViewportView(jtbl_visualizacao_pet);
        if (jtbl_visualizacao_pet.getColumnModel().getColumnCount() > 0) {
            jtbl_visualizacao_pet.getColumnModel().getColumn(0).setResizable(false);
            jtbl_visualizacao_pet.getColumnModel().getColumn(1).setResizable(false);
            jtbl_visualizacao_pet.getColumnModel().getColumn(2).setResizable(false);
            jtbl_visualizacao_pet.getColumnModel().getColumn(3).setResizable(false);
            jtbl_visualizacao_pet.getColumnModel().getColumn(4).setResizable(false);
            jtbl_visualizacao_pet.getColumnModel().getColumn(5).setResizable(false);
            jtbl_visualizacao_pet.getColumnModel().getColumn(6).setResizable(false);
        }

        jPanel_tabela_pet.add(jScroll_tabela, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel_tabela_pet, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 103, -1, -1));

        jPanel_deletar.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_deletar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel_deletar.setPreferredSize(new java.awt.Dimension(42, 42));
        jPanel_deletar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlbl_deletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon deletar.png"))); // NOI18N
        jPanel_deletar.add(jlbl_deletar, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 9, -1, -1));

        getContentPane().add(jPanel_deletar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1216, 530, -1, -1));

        jPanel_editar.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_editar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel_editar.setPreferredSize(new java.awt.Dimension(42, 42));
        jPanel_editar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel_editarMouseClicked(evt);
            }
        });
        jPanel_editar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon editar.png"))); // NOI18N
        jPanel_editar.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 9, -1, -1));

        getContentPane().add(jPanel_editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1258, 530, -1, -1));

        jlbl_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BG_PADRAO.png"))); // NOI18N
        jlbl_background.setText(" ");
        jlbl_background.setMaximumSize(new java.awt.Dimension(1366, 768));
        jlbl_background.setMinimumSize(new java.awt.Dimension(1366, 768));
        jlbl_background.setPreferredSize(new java.awt.Dimension(1366, 768));
        getContentPane().add(jlbl_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtn_cadastrarPetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_cadastrarPetActionPerformed
        // TODO add your handling code here:
        tela_cadastro_pet telaCadPets = new tela_cadastro_pet();
        telaCadPets.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbtn_cadastrarPetActionPerformed

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
        JTableHeader header = jtbl_visualizacao_pet.getTableHeader();   
        header.setPreferredSize(new Dimension(0, 30));
        TableColumnModel modeloDaColuna = jtbl_visualizacao_pet.getColumnModel();  

        // Organiza a tabela de acordo com os parametros.
        modeloDaColuna.getColumn(0).setCellRenderer(rendererEsquerda); // Nome do pet
        modeloDaColuna.getColumn(1).setCellRenderer(rendererEsquerda); // Nome do dono
        modeloDaColuna.getColumn(2).setCellRenderer(rendererEsquerda); // Raça
        modeloDaColuna.getColumn(3).setCellRenderer(rendererEsquerda); // Cor
        modeloDaColuna.getColumn(4).setCellRenderer(rendererCentro); // Porte
        modeloDaColuna.getColumn(5).setCellRenderer(rendererCentro); // Sexo
        modeloDaColuna.getColumn(6).setCellRenderer(rendererCentro); // Castrado

        // Define o tamanho das colunas na tabela.
        modeloDaColuna.getColumn(0).setPreferredWidth(200); // Nome do pet
        modeloDaColuna.getColumn(1).setPreferredWidth(300); // Nome do dono
        modeloDaColuna.getColumn(2).setPreferredWidth(150); // Raça
        modeloDaColuna.getColumn(3).setPreferredWidth(200); // Cor
        modeloDaColuna.getColumn(4).setPreferredWidth(80); // Porte
        modeloDaColuna.getColumn(5).setPreferredWidth(75); // Sexo
        modeloDaColuna.getColumn(6).setPreferredWidth(65); // Castrado
    }
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void jPanel_editarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_editarMouseClicked
        // TODO add your handling code here:
        if (linha_selecionada_pet > -1) { // Pega o id_pet com base em todos os ids e linha_selecionada.
            id_pet = todos_ids_pet.get(linha_selecionada_pet);
            id_cliente = todos_ids_clientes.get(linha_selecionada_pet);
            System.out.println("id_pet: " + id_pet);
            System.out.println("id_cliente: " + id_cliente);

            tela_atualizar_pet tela_atualizar = new tela_atualizar_pet();
            tela_atualizar.setVisible(true);
            this.dispose();
        }
        else {
            JOptionPane.showMessageDialog(null, "Selecione uma linha para ser editada", "Linha inválida", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jPanel_editarMouseClicked

    private void jtbl_visualizacao_petMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_visualizacao_petMouseEntered
        // TODO add your handling code here:
        // MouseListener para capturar o clique na tabela
        jtbl_visualizacao_pet.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Pega a linha selecionada
                linha_selecionada_pet = jtbl_visualizacao_pet.rowAtPoint(e.getPoint());
            }
        });
    }//GEN-LAST:event_jtbl_visualizacao_petMouseEntered
    
    private void initMenuPanel() {
        MenuPanel menuPanel = new MenuPanel();
        jPanel_menu.add(menuPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 205, 768));
    }
    
    private void moveHeader() {
        // Cabeçalho da tabela e o JScrollPane
        JTableHeader header = jtbl_visualizacao_pet.getTableHeader();
        JScrollBar horizontalScrollBar = jScroll_tabela.getHorizontalScrollBar();

        // Sincroniza a rolagem da JTable com o header
        horizontalScrollBar.addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                header.setLocation(-e.getValue(), header.getY());
            }
        });
    }
    
    private void carregarDadosTabela() {
        Pet[] pets = BD.Pet.selectAll(); // Todos os pets.
        Cliente[] clientes = BD.Cliente.selectAll(); // Todos os clientes.
        
        // Modelo da tabela.
        DefaultTableModel modelo = (DefaultTableModel) jtbl_visualizacao_pet.getModel();
        modelo.setNumRows(0);
            
        
        String sexo, castrado;
        
        if (pets != null) {
            // Preenche cada linha com cada pet dentro de pets.
            for (Pet pet : pets) {
                todos_ids_pet.add(pet.getId());
                if (pet.getSexo().PET.equals("M")) {
                    sexo = "Macho";
                }
                else {
                    sexo = "Fêmea";
                }
                
                if (pet.getECastrado()) {
                    castrado = "Sim";
                }
                else {
                    castrado = "Não";
                }
                
                todos_ids_clientes.add(clientes[pet.getDono() - 1].getId());
                Object[] linha = {
                        pet.getNome(),
                        clientes[pet.getDono() - 1].getNome(),
                        pet.getRaca(),
                        pet.getCor(),
                        pet.getPorte().toString(),
                        sexo,
                        castrado
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
        java.util.logging.Logger.getLogger(Tela_visualizacao_pet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        java.util.logging.Logger.getLogger(Tela_visualizacao_pet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        java.util.logging.Logger.getLogger(Tela_visualizacao_pet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(Tela_visualizacao_pet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new Tela_visualizacao_pet().setVisible(true);
        }
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel_deletar;
    private javax.swing.JPanel jPanel_editar;
    private javax.swing.JPanel jPanel_menu;
    private javax.swing.JPanel jPanel_tabela_pet;
    private javax.swing.JScrollPane jScroll_tabela;
    private javax.swing.JButton jbtn_cadastrarPet;
    private javax.swing.JLabel jlbl_background;
    private javax.swing.JLabel jlbl_deletar;
    private javax.swing.JTable jtbl_visualizacao_pet;
    private javax.swing.JLabel lbl_funcionarios;
    // End of variables declaration//GEN-END:variables

}
