/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import com.mycompany.petagenda.MenuPanel;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import petagenda.dados.Porte;
import petagenda.dados.Sexo;
import ui.custom.RoundedCornerBorder;
import ui.custom.RoundedCornerButtonUI;
import petagenda.Cliente;
import petagenda.Pet;
import petagenda.bd.BD;
import petagenda.exception.IllegalArgumentsException;

/**
 *
 * @author kevin
 */
public class tela_cadastro_pet extends javax.swing.JFrame {

    /**
     * Creates new form tela_cadastro_pet
     */
    public tela_cadastro_pet() {
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
        //jcombBox_nome_dono.setEnabled(false);
        AlinhaJField();
    }
    
    private void AlinhaJField() {
        Border line = BorderFactory.createLineBorder(Color.BLACK, 2);
        Border emptyJfield = new EmptyBorder(0, 5, 0, 0);
        Border emptyJText = new EmptyBorder(5, 5, 0, 0);
        CompoundBorder border_field = new CompoundBorder(line, emptyJfield);
        CompoundBorder border_text = new CompoundBorder(line, emptyJText);

        jtxtf_nome_pet.setBorder(border_field);
        jcombBox_nome_dono.setBorder(border_field);
        jtxtf_Raca.setBorder(border_field);
        jcmbBx_Porte.setBorder(border_field);
        txtf_Cor.setBorder(border_field);
        jcmbBx_sexo.setBorder(border_field);
        jtxtarea_comportamento.setBorder(border_text);
        jtxtarea_saude.setBorder(border_text);
    }
    
    private void clearFieldsInfo() {
        jtxtf_nome_pet.setText(null);
        jtxtf_Raca.setText(null);
        jcmbBx_sexo.setSelectedIndex(0);
        jcmbBx_Porte.setSelectedIndex(0);
        jtxtarea_comportamento.setText(null);
        chkBx_Sim.setSelected(false);
        chkBx_Nao.setSelected(false);
        jtxtarea_saude.setText(null);  
        txtf_Cor.setText(null);
    }
    
    private Pet getFieldInfo() throws SQLException{
        Pet novo_pet = null;
        
        String nome, raca, comportamento, caminho_cartao_vacinacao, estado_saude, cor;
        Boolean eCastrado = null;
        Sexo sexo;
        Porte porte;
        int id_cliente, index_cliente;

        nome = jtxtf_nome_pet.getText(); // nome
        raca = jtxtf_Raca.getText(); // raca
        sexo = (Sexo) jcmbBx_sexo.getSelectedItem(); // sexo
        porte = (Porte) jcmbBx_Porte.getSelectedItem(); // porte
        comportamento = jtxtarea_comportamento.getText(); // comportamento
        
        // Define se é castrado ou não.
        if (chkBx_Sim.isSelected()) {
            eCastrado = true;
        }
        else if (chkBx_Nao.isSelected())
        {
            eCastrado = false;
        }
        
        // caminho_cartao_vacinacao
        
        estado_saude = jtxtarea_saude.getText(); // estado_saude
        cor = txtf_Cor.getText(); // cor
        
        // id_cliente
        Cliente[] clientes = BD.Cliente.selectAll();
        index_cliente = jcombBox_nome_dono.getSelectedIndex();
        id_cliente = clientes[index_cliente].getId();
        
        System.out.println("Id_cliente" + id_cliente);
        
        IllegalArgumentsException exsCadastro = new IllegalArgumentsException();
         
        // Criação do pet.
        try {
            novo_pet = new Pet(nome, raca, sexo, porte, comportamento, eCastrado, "TEMPORARIO", estado_saude, cor, id_cliente);
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
        
        return novo_pet;
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
        jpanel_cadastrar_pet = new javax.swing.JPanel();
        lbl_CadastrarPet = new javax.swing.JLabel();
        label_nome_do_pet1 = new javax.swing.JLabel();
        jtxtf_nome_pet = new javax.swing.JTextField();
        label_nome_do_pet = new javax.swing.JLabel();
        lbl_Castrado = new javax.swing.JLabel();
        chkBx_Sim = new javax.swing.JCheckBox("Sim");
        chkBx_Nao = new javax.swing.JCheckBox("Não");
        lbl_Vacinas = new javax.swing.JLabel();
        jbtn_AddVacinas = new javax.swing.JButton();
        javax.swing.JLabel label_raca = new javax.swing.JLabel();
        jtxtf_Raca = new javax.swing.JTextField();
        label_porte = new javax.swing.JLabel();
        jcmbBx_Porte = new javax.swing.JComboBox<Porte>(Porte.values());
        label_cor = new javax.swing.JLabel();
        txtf_Cor = new javax.swing.JTextField();
        label_sexo = new javax.swing.JLabel();
        jcmbBx_sexo = new javax.swing.JComboBox<>(Sexo.values());
        label_comportamento_do_pet = new javax.swing.JLabel();
        jtxtArea_Comportamento = new javax.swing.JScrollPane();
        jtxtarea_comportamento = new javax.swing.JTextArea();
        lbl_Saude = new javax.swing.JLabel();
        jtxtArea_Saude = new javax.swing.JScrollPane();
        jtxtarea_saude = new javax.swing.JTextArea();
        jbtn_cadastrarPet = new javax.swing.JButton();
        jcombBox_nome_dono = new javax.swing.JComboBox<>();
        jlbl_background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PetAgenda - Cadastrar Pets");
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel_menu.setBackground(new java.awt.Color(124, 115, 101));
        jPanel_menu.setForeground(new java.awt.Color(124, 115, 101));
        jPanel_menu.setFont(new java.awt.Font("Merriweather", 0, 12)); // NOI18N
        jPanel_menu.setMinimumSize(new java.awt.Dimension(205, 768));
        jPanel_menu.setPreferredSize(new java.awt.Dimension(205, 768));
        jPanel_menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 205, 768));

        jpanel_cadastrar_pet.setBackground(new java.awt.Color(255, 255, 255));
        jpanel_cadastrar_pet.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jpanel_cadastrar_pet.setFont(new java.awt.Font("Merriweather", 0, 14)); // NOI18N
        jpanel_cadastrar_pet.setPreferredSize(new java.awt.Dimension(899, 617));
        jpanel_cadastrar_pet.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_CadastrarPet.setFont(new java.awt.Font("Merriweather", 0, 45)); // NOI18N
        lbl_CadastrarPet.setForeground(new java.awt.Color(0, 0, 0));
        lbl_CadastrarPet.setText("Cadastrar pets");
        lbl_CadastrarPet.setPreferredSize(new java.awt.Dimension(590, 58));
        jpanel_cadastrar_pet.add(lbl_CadastrarPet, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, -1, -1));

        label_nome_do_pet1.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        label_nome_do_pet1.setForeground(new java.awt.Color(0, 0, 0));
        label_nome_do_pet1.setText("Nome do Pet:");
        label_nome_do_pet1.setPreferredSize(new java.awt.Dimension(240, 20));
        jpanel_cadastrar_pet.add(label_nome_do_pet1, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 84, -1, -1));

        jtxtf_nome_pet.setBackground(new java.awt.Color(217, 217, 217));
        jtxtf_nome_pet.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtf_nome_pet.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jtxtf_nome_pet.setMinimumSize(new java.awt.Dimension(250, 50));
        jtxtf_nome_pet.setPreferredSize(new java.awt.Dimension(250, 50));
        jtxtf_nome_pet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtf_nome_petActionPerformed(evt);
            }
        });
        jtxtf_nome_pet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtf_nome_petKeyTyped(evt);
            }
        });
        jpanel_cadastrar_pet.add(jtxtf_nome_pet, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 103, -1, -1));

        label_nome_do_pet.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        label_nome_do_pet.setForeground(new java.awt.Color(0, 0, 0));
        label_nome_do_pet.setText("Nome do Dono:");
        label_nome_do_pet.setPreferredSize(new java.awt.Dimension(240, 20));
        jpanel_cadastrar_pet.add(label_nome_do_pet, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 84, -1, -1));

        lbl_Castrado.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        lbl_Castrado.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Castrado.setText("Castrado:");
        lbl_Castrado.setPreferredSize(new java.awt.Dimension(80, 20));
        jpanel_cadastrar_pet.add(lbl_Castrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 90, -1, -1));

        chkBx_Sim.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                // Verifica se o JCheckBox "Sim" foi selecionado
                if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
                    // Se "Sim" for selecionado, desmarque "Não"
                    chkBx_Nao.setSelected(false);
                }
            }
        });
        chkBx_Sim.setBackground(new java.awt.Color(255, 255, 255));
        chkBx_Sim.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        chkBx_Sim.setForeground(new java.awt.Color(0, 0, 0));
        chkBx_Sim.setText("SIM");
        chkBx_Sim.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        chkBx_Sim.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chkBx_Sim.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkBx_SimStateChanged(evt);
            }
        });
        chkBx_Sim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkBx_SimActionPerformed(evt);
            }
        });
        jpanel_cadastrar_pet.add(chkBx_Sim, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 90, -1, -1));

        chkBx_Nao.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                // Verifica se o JCheckBox "Não" foi selecionado
                if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
                    // Se "Não" for selecionado, desmarque "Sim"
                    chkBx_Sim.setSelected(false);
                }
            }
        });
        chkBx_Nao.setBackground(new java.awt.Color(255, 255, 255));
        chkBx_Nao.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        chkBx_Nao.setForeground(new java.awt.Color(0, 0, 0));
        chkBx_Nao.setText("NÃO");
        chkBx_Nao.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        chkBx_Nao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpanel_cadastrar_pet.add(chkBx_Nao, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 90, -1, -1));

        lbl_Vacinas.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        lbl_Vacinas.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Vacinas.setText("Vacinas:");
        lbl_Vacinas.setPreferredSize(new java.awt.Dimension(80, 20));
        jpanel_cadastrar_pet.add(lbl_Vacinas, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 130, -1, -1));

        jbtn_AddVacinas.setBackground(new java.awt.Color(217, 217, 217));
        jbtn_AddVacinas.setFont(new java.awt.Font("Merriweather", 0, 12)); // NOI18N
        jbtn_AddVacinas.setForeground(new java.awt.Color(0, 0, 0));
        jbtn_AddVacinas.setText("ADICIONAR");
        jbtn_AddVacinas.setBorder(new RoundedCornerBorder(16));
        jbtn_AddVacinas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtn_AddVacinas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_AddVacinasActionPerformed(evt);
            }
        });
        // Aplicando a UI personalizada
        jbtn_cadastrarPet.setUI(new RoundedCornerButtonUI());
        jpanel_cadastrar_pet.add(jbtn_AddVacinas, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 130, 122, 19));

        label_raca.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        label_raca.setForeground(new java.awt.Color(0, 0, 0));
        label_raca.setText("Raça:");
        label_raca.setPreferredSize(new java.awt.Dimension(230, 20));
        jpanel_cadastrar_pet.add(label_raca, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 179, -1, -1));

        jtxtf_Raca.setBackground(new java.awt.Color(217, 217, 217));
        jtxtf_Raca.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtf_Raca.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jtxtf_Raca.setMinimumSize(new java.awt.Dimension(200, 50));
        jtxtf_Raca.setPreferredSize(new java.awt.Dimension(240, 50));
        jtxtf_Raca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtf_RacaActionPerformed(evt);
            }
        });
        jtxtf_Raca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtf_RacaKeyTyped(evt);
            }
        });
        jpanel_cadastrar_pet.add(jtxtf_Raca, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 240, -1));

        label_porte.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        label_porte.setForeground(new java.awt.Color(0, 0, 0));
        label_porte.setText("Porte:");
        label_porte.setPreferredSize(new java.awt.Dimension(160, 20));
        jpanel_cadastrar_pet.add(label_porte, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, -1, -1));

        jcmbBx_Porte.setBackground(new java.awt.Color(217, 217, 217));
        jcmbBx_Porte.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jcmbBx_Porte.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jcmbBx_Porte.setMinimumSize(new java.awt.Dimension(232, 50));
        jcmbBx_Porte.setPreferredSize(new java.awt.Dimension(232, 50));
        jcmbBx_Porte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcmbBx_PorteActionPerformed(evt);
            }
        });
        jpanel_cadastrar_pet.add(jcmbBx_Porte, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 200, 170, -1));

        label_cor.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        label_cor.setForeground(new java.awt.Color(0, 0, 0));
        label_cor.setText("Cor:");
        label_cor.setPreferredSize(new java.awt.Dimension(180, 20));
        jpanel_cadastrar_pet.add(label_cor, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, -1, -1));

        txtf_Cor.setBackground(new java.awt.Color(217, 217, 217));
        txtf_Cor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtf_Cor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txtf_Cor.setPreferredSize(new java.awt.Dimension(190, 50));
        txtf_Cor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtf_CorActionPerformed(evt);
            }
        });
        txtf_Cor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtf_CorKeyTyped(evt);
            }
        });
        jpanel_cadastrar_pet.add(txtf_Cor, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 200, -1, -1));

        label_sexo.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        label_sexo.setForeground(new java.awt.Color(0, 0, 0));
        label_sexo.setText("Sexo:");
        label_sexo.setPreferredSize(new java.awt.Dimension(130, 20));
        jpanel_cadastrar_pet.add(label_sexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 180, -1, -1));

        for (Sexo sexo : Sexo.values()) {
            sexo.setTipoExibicao("PET");
        }
        jcmbBx_sexo.setBackground(new java.awt.Color(217, 217, 217));
        jcmbBx_sexo.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jcmbBx_sexo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jcmbBx_sexo.setMinimumSize(new java.awt.Dimension(232, 50));
        jcmbBx_sexo.setPreferredSize(new java.awt.Dimension(232, 50));
        jcmbBx_sexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcmbBx_sexoActionPerformed(evt);
            }
        });
        jpanel_cadastrar_pet.add(jcmbBx_sexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 201, 140, -1));

        label_comportamento_do_pet.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        label_comportamento_do_pet.setForeground(new java.awt.Color(0, 0, 0));
        label_comportamento_do_pet.setText("Comportamento do Pet:");
        label_comportamento_do_pet.setPreferredSize(new java.awt.Dimension(780, 20));
        jpanel_cadastrar_pet.add(label_comportamento_do_pet, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 279, -1, -1));

        jtxtArea_Comportamento.setBackground(new java.awt.Color(217, 217, 217));
        jtxtArea_Comportamento.setBorder(null);
        jtxtArea_Comportamento.setMinimumSize(new java.awt.Dimension(800, 80));
        jtxtArea_Comportamento.setPreferredSize(new java.awt.Dimension(800, 80));
        jtxtArea_Comportamento.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        jtxtArea_Comportamento.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        jtxtarea_comportamento.setBackground(new java.awt.Color(217, 217, 217));
        jtxtarea_comportamento.setColumns(20);
        jtxtarea_comportamento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtarea_comportamento.setRows(0);
        jtxtarea_comportamento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jtxtarea_comportamento.setOpaque(false);
        jtxtarea_comportamento.setPreferredSize(null);
        jtxtarea_comportamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtarea_comportamentoKeyTyped(evt);
            }
        });
        jtxtArea_Comportamento.setViewportView(jtxtarea_comportamento);

        jpanel_cadastrar_pet.add(jtxtArea_Comportamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, -1));

        lbl_Saude.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        lbl_Saude.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Saude.setText("Saúde do Pet:");
        lbl_Saude.setPreferredSize(new java.awt.Dimension(790, 20));
        jpanel_cadastrar_pet.add(lbl_Saude, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 389, -1, -1));

        jtxtArea_Saude.setBackground(new java.awt.Color(217, 217, 217));
        jtxtArea_Saude.setBorder(null);
        jtxtArea_Saude.setMinimumSize(new java.awt.Dimension(800, 80));
        jtxtArea_Saude.setPreferredSize(new java.awt.Dimension(800, 80));
        jtxtArea_Saude.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        jtxtArea_Saude.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        jtxtarea_saude.setBackground(new java.awt.Color(217, 217, 217));
        jtxtarea_saude.setColumns(20);
        jtxtarea_saude.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtarea_saude.setRows(0);
        jtxtarea_saude.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jtxtarea_saude.setOpaque(false);
        jtxtarea_saude.setPreferredSize(null);
        jtxtarea_saude.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtarea_saudeKeyTyped(evt);
            }
        });
        jtxtArea_Saude.setViewportView(jtxtarea_saude);

        jpanel_cadastrar_pet.add(jtxtArea_Saude, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 409, -1, -1));

        jbtn_cadastrarPet.setBackground(new java.awt.Color(77, 120, 63));
        jbtn_cadastrarPet.setFont(new java.awt.Font("Merriweather", 0, 20)); // NOI18N
        jbtn_cadastrarPet.setForeground(new java.awt.Color(255, 255, 255));
        jbtn_cadastrarPet.setText("CADASTRAR");
        jbtn_cadastrarPet.setBorder(null);
        jbtn_cadastrarPet.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtn_cadastrarPet.setPreferredSize(new java.awt.Dimension(240, 50));
        jbtn_cadastrarPet.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jbtn_cadastrarPetMouseMoved(evt);
            }
        });
        jbtn_cadastrarPet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbtn_cadastrarPetMouseExited(evt);
            }
        });
        jbtn_cadastrarPet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_cadastrarPetActionPerformed(evt);
            }
        });
        // Aplicando a UI personalizada
        jbtn_cadastrarPet.setUI(new RoundedCornerButtonUI());
        jpanel_cadastrar_pet.add(jbtn_cadastrarPet, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 530, 240, 50));

        jcombBox_nome_dono.setBackground(new java.awt.Color(217, 217, 217));
        jcombBox_nome_dono.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jcombBox_nome_dono.setPreferredSize(new java.awt.Dimension(250, 50));
        jpanel_cadastrar_pet.add(jcombBox_nome_dono, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 103, -1, -1));

        getContentPane().add(jpanel_cadastrar_pet, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 41, -1, -1));

        jlbl_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BG_PADRAO.png"))); // NOI18N
        getContentPane().add(jlbl_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtn_cadastrarPetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_cadastrarPetActionPerformed
        // TODO add your handling code here:
        Pet cadastrar = null;
        
        // Cadastro do cliente.
        try {
            cadastrar = getFieldInfo(); // Retornara null se informações não forem válidas.
        }
        catch (SQLException ex) {
            Logger.getLogger(tela_cadastro_pet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (cadastrar != null) {
            int r = BD.Pet.insert(cadastrar);
            
            if (r > 0) { // Insert funcionou
                JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
                
                Object[] opcoes = {"Sim", "Não"};

                // Exibe a caixa de diálogo com "Sim" e "Não"
                int resposta = JOptionPane.showOptionDialog(null, "Cadastrar outro pet?", "Confirmação", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

                // Verifica a resposta
                if (resposta == 0) { // Se o usuário clicar em 'sim', continua na mesma tela, só limpa os campos.
                    clearFieldsInfo();
                }
                else { // Se não usuário respondeu 'não', volta para o inicio.
                    Tela_Inicial tela_inicial = new Tela_Inicial();
                    tela_inicial.setVisible(true);
                    this.dispose();
                }
            }
        }
    }//GEN-LAST:event_jbtn_cadastrarPetActionPerformed

    // não deixa o usuario digitar números, somente caracteres.
    private void VerificaString(java.awt.event.KeyEvent evt) {
        String caracteres = "áéíóúàèìòùâêîôûãõäëïöüåñçøÁÉÍÓÚÀÈÌÒÙÂÊÎÔÛÃÕÄËÏÖÜÅÑÇØabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ- ";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }
    
    // não deixa o usuario digitar simbolos, somente caracteres e números.
    private void verificaStringNum(java.awt.event.KeyEvent evt) {
        String caracteres = "123456789áéíóúàèìòùâêîôûãõäëïöüåñçøÁÉÍÓÚÀÈÌÒÙÂÊÎÔÛÃÕÄËÏÖÜÅÑÇØabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-., ";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }
    
    private void chkBx_SimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkBx_SimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkBx_SimActionPerformed

    private void jbtn_AddVacinasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_AddVacinasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtn_AddVacinasActionPerformed

    private void jtxtf_RacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtf_RacaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtf_RacaActionPerformed

    private void jbtn_cadastrarPetMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtn_cadastrarPetMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtn_cadastrarPetMouseMoved

    private void jbtn_cadastrarPetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtn_cadastrarPetMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtn_cadastrarPetMouseExited

    private void jcmbBx_sexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmbBx_sexoActionPerformed
        // TODO add your handling code here:
        Sexo sexoSelecionado = (Sexo) jcmbBx_sexo.getSelectedItem();
    
        // Ação com base na seleção (aqui você vai usar PET, já que é para Pet)
        String sexoPet = sexoSelecionado.PET;
    }//GEN-LAST:event_jcmbBx_sexoActionPerformed

    private void txtf_CorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtf_CorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtf_CorActionPerformed

    private void jcmbBx_PorteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmbBx_PorteActionPerformed
        // TODO add your handling code here:
        Porte selectedPorte = (Porte) jcmbBx_Porte.getSelectedItem();
        
    }//GEN-LAST:event_jcmbBx_PorteActionPerformed

    private void jtxtf_nome_petActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtf_nome_petActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtf_nome_petActionPerformed
    
    private void chkBx_SimStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkBx_SimStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_chkBx_SimStateChanged

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        Cliente[] clientes = BD.Cliente.selectAll(); // Todos os clientes.
        Cliente ultimo_cadastrado = BD.Cliente.selectLast(); // Último cliente.
        
        for (Cliente cliente : clientes) {
            jcombBox_nome_dono.addItem(cliente.getNome());
        }
        
        if (ultimo_cadastrado != null) {
            String cpf_ultimo_cliente = ultimo_cadastrado.getCpf().toString();
            
            // Verifica por cada posição do combobox até encontrar o cpf do último cadastrado.
            for (int i = 0; i < jcombBox_nome_dono.getItemCount(); i++) {
                
                // Verifica se cliente tem o mesmo cpf que o último cliente.
                if ((clientes[i].getCpf().toString()).equals(cpf_ultimo_cliente)) { 
                    jcombBox_nome_dono.setSelectedIndex(i); // Coloca o comboBox selecionado na posição que foi achado.
                    break;
                }
            }
        }
    }//GEN-LAST:event_formWindowOpened

    private void jtxtf_nome_petKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtf_nome_petKeyTyped
        // TODO add your handling code here:
        verificaStringNum(evt);
    }//GEN-LAST:event_jtxtf_nome_petKeyTyped

    private void jtxtf_RacaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtf_RacaKeyTyped
        // TODO add your handling code here:
        VerificaString(evt);
    }//GEN-LAST:event_jtxtf_RacaKeyTyped

    private void txtf_CorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtf_CorKeyTyped
        // TODO add your handling code here:
        VerificaString(evt);
    }//GEN-LAST:event_txtf_CorKeyTyped

    private void jtxtarea_comportamentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtarea_comportamentoKeyTyped
        // TODO add your handling code here:
        verificaStringNum(evt);
    }//GEN-LAST:event_jtxtarea_comportamentoKeyTyped

    private void jtxtarea_saudeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtarea_saudeKeyTyped
        // TODO add your handling code here:
        verificaStringNum(evt);
    }//GEN-LAST:event_jtxtarea_saudeKeyTyped
    
    private void initMenuPanel() {
        MenuPanel menuPanel = new MenuPanel();
        jPanel_menu.add(menuPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 205, 768));
    }
    
    private void SalvarArquivoNoBanco(File file) throws IOException ,SQLException {
        FileInputStream fis = new FileInputStream(file);
        byte[] fileBytes = fis.readAllBytes();
        fis.close();
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
            java.util.logging.Logger.getLogger(tela_cadastro_pet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tela_cadastro_pet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tela_cadastro_pet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tela_cadastro_pet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tela_cadastro_pet().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chkBx_Nao;
    private javax.swing.JCheckBox chkBx_Sim;
    private javax.swing.JPanel jPanel_menu;
    private javax.swing.JButton jbtn_AddVacinas;
    private javax.swing.JButton jbtn_cadastrarPet;
    private javax.swing.JComboBox<Porte> jcmbBx_Porte;
    private javax.swing.JComboBox<Sexo> jcmbBx_sexo;
    private javax.swing.JComboBox<String> jcombBox_nome_dono;
    private javax.swing.JLabel jlbl_background;
    private javax.swing.JPanel jpanel_cadastrar_pet;
    private javax.swing.JScrollPane jtxtArea_Comportamento;
    private javax.swing.JScrollPane jtxtArea_Saude;
    private javax.swing.JTextArea jtxtarea_comportamento;
    private javax.swing.JTextArea jtxtarea_saude;
    private javax.swing.JTextField jtxtf_Raca;
    private javax.swing.JTextField jtxtf_nome_pet;
    private javax.swing.JLabel label_comportamento_do_pet;
    private javax.swing.JLabel label_cor;
    private javax.swing.JLabel label_nome_do_pet;
    private javax.swing.JLabel label_nome_do_pet1;
    private javax.swing.JLabel label_porte;
    private javax.swing.JLabel label_sexo;
    private javax.swing.JLabel lbl_CadastrarPet;
    private javax.swing.JLabel lbl_Castrado;
    private javax.swing.JLabel lbl_Saude;
    private javax.swing.JLabel lbl_Vacinas;
    private javax.swing.JTextField txtf_Cor;
    // End of variables declaration//GEN-END:variables
}
