/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import javax.swing.JOptionPane;
import ui.custom.RoundedCornerBorder;
import ui.custom.RoundedCornerButtonUI;

/**
 *
 * @author kevin
 */
public class tela_cadastro_funcionario extends javax.swing.JFrame {

    /**
     * Creates new form tela_cadastro_funcionario
     */
    public tela_cadastro_funcionario() {
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
        lbl_cadastrarFuncinario = new javax.swing.JLabel();
        jlbl_nome_funcionario = new javax.swing.JLabel();
        field_nome_funcionario = new javax.swing.JTextField();
        jlbl_cpf = new javax.swing.JLabel();
        field_cpf = new javax.swing.JTextField();
        jlbl_telefone = new javax.swing.JLabel();
        field_telefone = new javax.swing.JTextField();
        jlbl_servico_prestado = new javax.swing.JLabel();
        jcbox_Selecao_servico = new javax.swing.JComboBox<>();
        jlbl_cep = new javax.swing.JLabel();
        field_cep = new javax.swing.JTextField();
        jlbl_numero = new javax.swing.JLabel();
        field_numero = new javax.swing.JTextField();
        jlbl_rua = new javax.swing.JLabel();
        field_rua = new javax.swing.JTextField();
        jlbl_bairro = new javax.swing.JLabel();
        field_bairro = new javax.swing.JTextField();
        jlbl_cidade = new javax.swing.JLabel();
        field_cidade = new javax.swing.JTextField();
        jbtn_cadastrarFuncionario = new javax.swing.JButton();
        jlbl_background_cadastro_funcionario = new javax.swing.JLabel();

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
        btn_agenda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        btn_agenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agendaActionPerformed(evt);
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
        btn_financeiro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        btn_clientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        btn_funcionarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        btn_pets.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        btn_config.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        jPanel1.setMinimumSize(new java.awt.Dimension(670, 640));
        jPanel1.setPreferredSize(new java.awt.Dimension(670, 640));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_cadastrarFuncinario.setFont(new java.awt.Font("Merriweather", 0, 45)); // NOI18N
        lbl_cadastrarFuncinario.setForeground(new java.awt.Color(0, 0, 0));
        lbl_cadastrarFuncinario.setText("Cadastrar funcionário");
        lbl_cadastrarFuncinario.setPreferredSize(new java.awt.Dimension(486, 45));
        jPanel1.add(lbl_cadastrarFuncinario, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 20, -1, -1));

        jlbl_nome_funcionario.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_nome_funcionario.setForeground(new java.awt.Color(0, 0, 0));
        jlbl_nome_funcionario.setText("Nome do funcionário:");
        jlbl_nome_funcionario.setPreferredSize(new java.awt.Dimension(165, 20));
        jPanel1.add(jlbl_nome_funcionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 85, -1, 20));

        field_nome_funcionario.setBackground(new java.awt.Color(217, 217, 217));
        field_nome_funcionario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        field_nome_funcionario.setBorder(new RoundedCornerBorder(50));
        field_nome_funcionario.setMinimumSize(new java.awt.Dimension(550, 50));
        field_nome_funcionario.setPreferredSize(new java.awt.Dimension(550, 50));
        field_nome_funcionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_nome_funcionarioActionPerformed(evt);
            }
        });
        jPanel1.add(field_nome_funcionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 104, -1, -1));

        jlbl_cpf.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_cpf.setForeground(new java.awt.Color(0, 0, 0));
        jlbl_cpf.setText("CPF:");
        jPanel1.add(jlbl_cpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 174, -1, -1));

        field_cpf.setBackground(new java.awt.Color(217, 217, 217));
        field_cpf.setBorder(new RoundedCornerBorder(50));
        field_cpf.setMinimumSize(new java.awt.Dimension(250, 50));
        field_cpf.setPreferredSize(new java.awt.Dimension(250, 50));
        jPanel1.add(field_cpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 193, -1, -1));

        jlbl_telefone.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_telefone.setForeground(new java.awt.Color(0, 0, 0));
        jlbl_telefone.setText("Telefone:");
        jlbl_telefone.setMaximumSize(new java.awt.Dimension(71, 20));
        jlbl_telefone.setMinimumSize(new java.awt.Dimension(71, 20));
        jlbl_telefone.setPreferredSize(new java.awt.Dimension(71, 20));
        jPanel1.add(jlbl_telefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 174, -1, -1));

        field_telefone.setBackground(new java.awt.Color(217, 217, 217));
        field_telefone.setBorder(new RoundedCornerBorder(50));
        field_telefone.setMinimumSize(new java.awt.Dimension(250, 50));
        field_telefone.setPreferredSize(new java.awt.Dimension(250, 50));
        field_telefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_telefoneActionPerformed(evt);
            }
        });
        jPanel1.add(field_telefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(341, 193, -1, -1));

        jlbl_servico_prestado.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_servico_prestado.setForeground(new java.awt.Color(0, 0, 0));
        jlbl_servico_prestado.setText("Serviço prestado:");
        jPanel1.add(jlbl_servico_prestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 263, -1, -1));

        jcbox_Selecao_servico.setBackground(new java.awt.Color(217, 217, 217));
        jcbox_Selecao_servico.setFont(new java.awt.Font("Merriweather", 0, 14)); // NOI18N
        jcbox_Selecao_servico.setForeground(new java.awt.Color(217, 217, 217));
        jcbox_Selecao_servico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECIONAR", "DogWalker", "PetSitting", "DogWalker e PetSitting", "Cuidados Especiais" }));
        jcbox_Selecao_servico.setBorder(new RoundedCornerBorder(50));
        jcbox_Selecao_servico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jcbox_Selecao_servico, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 284, 250, 50));

        jlbl_cep.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_cep.setForeground(new java.awt.Color(0, 0, 0));
        jlbl_cep.setText("CEP:");
        jPanel1.add(jlbl_cep, new org.netbeans.lib.awtextra.AbsoluteConstraints(329, 263, -1, -1));

        field_cep.setBackground(new java.awt.Color(217, 217, 217));
        field_cep.setBorder(new RoundedCornerBorder(50));
        field_cep.setMinimumSize(new java.awt.Dimension(150, 50));
        field_cep.setPreferredSize(new java.awt.Dimension(150, 50));
        jPanel1.add(field_cep, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 282, -1, -1));

        jlbl_numero.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_numero.setForeground(new java.awt.Color(0, 0, 0));
        jlbl_numero.setText("N°:");
        jPanel1.add(jlbl_numero, new org.netbeans.lib.awtextra.AbsoluteConstraints(519, 263, -1, -1));

        field_numero.setBackground(new java.awt.Color(217, 217, 217));
        field_numero.setBorder(new RoundedCornerBorder(50));
        field_numero.setPreferredSize(new java.awt.Dimension(90, 50));
        jPanel1.add(field_numero, new org.netbeans.lib.awtextra.AbsoluteConstraints(501, 282, -1, -1));

        jlbl_rua.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_rua.setForeground(new java.awt.Color(0, 0, 0));
        jlbl_rua.setText("Rua:");
        jPanel1.add(jlbl_rua, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 350, -1, -1));

        field_rua.setBackground(new java.awt.Color(217, 217, 217));
        field_rua.setBorder(new RoundedCornerBorder(50));
        field_rua.setMinimumSize(new java.awt.Dimension(550, 50));
        field_rua.setPreferredSize(new java.awt.Dimension(550, 50));
        field_rua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_ruaActionPerformed(evt);
            }
        });
        jPanel1.add(field_rua, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, -1, -1));

        jlbl_bairro.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_bairro.setForeground(new java.awt.Color(0, 0, 0));
        jlbl_bairro.setText("Bairro:");
        jPanel1.add(jlbl_bairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 443, -1, -1));

        field_bairro.setBackground(new java.awt.Color(217, 217, 217));
        field_bairro.setBorder(new RoundedCornerBorder(50));
        field_bairro.setMinimumSize(new java.awt.Dimension(270, 50));
        field_bairro.setPreferredSize(new java.awt.Dimension(270, 50));
        jPanel1.add(field_bairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 462, -1, -1));

        jlbl_cidade.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_cidade.setForeground(new java.awt.Color(0, 0, 0));
        jlbl_cidade.setText("Cidade:");
        jPanel1.add(jlbl_cidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 443, -1, -1));

        field_cidade.setBackground(new java.awt.Color(217, 217, 217));
        field_cidade.setBorder(new RoundedCornerBorder(50));
        field_cidade.setMinimumSize(new java.awt.Dimension(250, 50));
        field_cidade.setPreferredSize(new java.awt.Dimension(250, 50));
        jPanel1.add(field_cidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(341, 462, -1, -1));

        jbtn_cadastrarFuncionario.setBackground(new java.awt.Color(77, 120, 63));
        jbtn_cadastrarFuncionario.setFont(new java.awt.Font("Merriweather", 0, 20)); // NOI18N
        jbtn_cadastrarFuncionario.setForeground(new java.awt.Color(255, 255, 255));
        jbtn_cadastrarFuncionario.setText("CADASTRAR");
        jbtn_cadastrarFuncionario.setBorder(null);
        jbtn_cadastrarFuncionario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtn_cadastrarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_cadastrarFuncionarioActionPerformed(evt);
            }
        });
        // Aplicando a UI personalizada
        jbtn_cadastrarFuncionario.setUI(new RoundedCornerButtonUI());
        jPanel1.add(jbtn_cadastrarFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 557, 240, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(371, 40, 670, 640));

        jlbl_background_cadastro_funcionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BG_PADRAO.png"))); // NOI18N
        jlbl_background_cadastro_funcionario.setText("   ");
        jlbl_background_cadastro_funcionario.setMaximumSize(new java.awt.Dimension(1366, 768));
        jlbl_background_cadastro_funcionario.setMinimumSize(new java.awt.Dimension(1366, 768));
        jlbl_background_cadastro_funcionario.setPreferredSize(new java.awt.Dimension(1366, 768));
        getContentPane().add(jlbl_background_cadastro_funcionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void field_nome_funcionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_nome_funcionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_nome_funcionarioActionPerformed

    private void field_telefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_telefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_telefoneActionPerformed

    private void field_ruaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_ruaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_ruaActionPerformed

    private void btn_HomeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_HomeMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_HomeMousePressed

    private void btn_HomeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_HomeMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_HomeMouseReleased

    private void btn_HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_HomeActionPerformed
        // TODO add your handling code here:
        Tela_Inicial telaPrincipal = new Tela_Inicial();
        telaPrincipal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_HomeActionPerformed

    private void btn_agendaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_agendaMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_agendaMouseMoved

    private void btn_agendaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_agendaMousePressed
        // TODO add your handling code here:
        btn_agenda.setBackground(new java.awt.Color(99, 90, 77));
    }//GEN-LAST:event_btn_agendaMousePressed

    private void jbtn_cadastrarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_cadastrarFuncionarioActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Cadastro realizado com sucesso!");
    }//GEN-LAST:event_jbtn_cadastrarFuncionarioActionPerformed

    private void btn_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sairActionPerformed
        // TODO add your handling code here:
        //Adicionar conexão com o banco de dados
        TELA_LOGIN telaLogin = new TELA_LOGIN();
        telaLogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_sairActionPerformed

    private void btn_agendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agendaActionPerformed
        // TODO add your handling code here:
        Tela_de_visualizacao_do_mes telaVisualizaMes = new Tela_de_visualizacao_do_mes();
        telaVisualizaMes.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_agendaActionPerformed

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
            java.util.logging.Logger.getLogger(tela_cadastro_funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tela_cadastro_funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tela_cadastro_funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tela_cadastro_funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tela_cadastro_funcionario().setVisible(true);
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
    private javax.swing.JTextField field_bairro;
    private javax.swing.JTextField field_cep;
    private javax.swing.JTextField field_cidade;
    private javax.swing.JTextField field_cpf;
    private javax.swing.JTextField field_nome_funcionario;
    private javax.swing.JTextField field_numero;
    private javax.swing.JTextField field_rua;
    private javax.swing.JTextField field_telefone;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel_menu;
    private javax.swing.JButton jbtn_cadastrarFuncionario;
    private javax.swing.JComboBox<String> jcbox_Selecao_servico;
    private javax.swing.JLabel jlbl_background_cadastro_funcionario;
    private javax.swing.JLabel jlbl_bairro;
    private javax.swing.JLabel jlbl_cep;
    private javax.swing.JLabel jlbl_cidade;
    private javax.swing.JLabel jlbl_cpf;
    private javax.swing.JLabel jlbl_nome_funcionario;
    private javax.swing.JLabel jlbl_numero;
    private javax.swing.JLabel jlbl_rua;
    private javax.swing.JLabel jlbl_servico_prestado;
    private javax.swing.JLabel jlbl_telefone;
    private javax.swing.JLabel lbl_cadastrarFuncinario;
    // End of variables declaration//GEN-END:variables
}
