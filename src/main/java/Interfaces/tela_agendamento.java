package Interfaces;

import com.mycompany.petagenda.MenuPanel;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import petagenda.bd.BD;
import petagenda.servico.Servico;
import ui.custom.RoundedCornerBorder;
import ui.custom.RoundedCornerButtonUI;

/**
 *
 * @author Thiago M. Baiense
 */
public class tela_agendamento extends javax.swing.JFrame {
    
    private static int id_servico;
    private static final ArrayList<Integer> todos_ids_servico = new ArrayList<>();
    
    private static final ArrayList<Integer> todos_ids_pets = new ArrayList<>();
    private static final ArrayList<Integer> todos_ids_pets_selecionados = new ArrayList<>();

    public tela_agendamento() {
        initComponents();
        initMenuPanel();
        AlinhaJField();
        todos_ids_servico.clear();
        PreencherJComboboxServico();
    }

    private void AlinhaJField() {
        Border line = BorderFactory.createLineBorder(Color.BLACK, 2);
        Border empty = new EmptyBorder(0, 5, 0, 0);
        CompoundBorder border = new CompoundBorder(line, empty);

        jcmb_tipoServico.setBorder(border);
        jCombBox_pet_adicionar.setBorder(border);
    }
    
    // Preenche ComboBox com os serviços.
    private void PreencherJComboboxServico() {
        Servico[] servicos = BD.Servico.selectAll();
        int id_servico;
        String nome;
        
        if (servicos != null) {
            // Preenche o combobox com os itens.
            for (Servico servico : servicos) {
                id_servico = servico.getId();
                todos_ids_servico.add(id_servico);
                nome = servico.getNome();
                jcmb_tipoServico.addItem(nome);
            }
        }
    }
    
    // Preenche ComboBox com os pets de acordo com o serviço.
    private void PreencherJComboboxPet() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String banco = "jdbc:mysql://localhost:3306/pet_agenda";
        String usuario = "root";
        String senha = "";
        
        // Verifica se o CPF já existe no banco de dados.
        try {
            conn = DriverManager.getConnection(banco, usuario, senha);

            // Pega o serviço selecionado.
            id_servico = todos_ids_servico.get(jcmb_tipoServico.getSelectedIndex());
            String sql = "{CALL pet_por_servico(?)}";
            
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_servico);

            rs = stmt.executeQuery();

            todos_ids_pets.clear(); // limpa os pets antigos antes de entrar no while.
            while (rs.next()) { // Enquanto tiver pets.
                // Pega o id do pet e adiciona a uma Array com todos os ids de pet.
                int id_pet = rs.getInt("id_pet");
                
                // Adiciona a todos_ids_pets somente pets que não então dentro dos pets_selecionados.
                if (!todos_ids_pets_selecionados.contains(id_pet)) {
                    todos_ids_pets.add(id_pet);
                    jCombBox_pet_adicionar.addItem(rs.getString("nome_pet"));
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_menu = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel_cadastrar_agendamento = new javax.swing.JPanel();
        jlbl_nomePet = new javax.swing.JLabel();
        jtxtf_nomePet_selecionado = new javax.swing.JTextField();
        jlbl_tipoServico = new javax.swing.JLabel();
        jcmb_tipoServico = new javax.swing.JComboBox<>();
        jlbl_observacao = new javax.swing.JLabel();
        jscp_jtxta_observacao = new javax.swing.JScrollPane();
        jtxta_observacao = new javax.swing.JTextArea();
        jbtn_cadastrarPet = new javax.swing.JButton();
        jlbl_enderecoPet_selecionado = new javax.swing.JLabel();
        jtxtf_enderecoPet_selecionado = new javax.swing.JTextField();
        jtxtf_dtAgendada = new javax.swing.JTextField();
        jlbl_dtAgendada = new javax.swing.JLabel();
        jlbl_hrAgendada = new javax.swing.JLabel();
        jtxtf_hrAgendada = new javax.swing.JTextField();
        jcmb_remediosAdicionados = new javax.swing.JComboBox<>();
        jlbl_remediosAdicionados = new javax.swing.JLabel();
        jlbl_remedio = new javax.swing.JLabel();
        jtxtf_remedio = new javax.swing.JTextField();
        jlbl_intrucaoAdministracao = new javax.swing.JLabel();
        jtxtf_intrucaoAdministracao = new javax.swing.JTextField();
        jlbl_funcionarioAgendado = new javax.swing.JLabel();
        jcmb_funcionarioAgendado = new javax.swing.JComboBox<>();
        jlbl_donoPet_selcionado = new javax.swing.JLabel();
        jtxtf_donoPet_selecionado = new javax.swing.JTextField();
        jlbl_horarioRemedio = new javax.swing.JLabel();
        jtxtf_horarioRemedio = new javax.swing.JTextField();
        jlbl_img_adicionarRemedio = new javax.swing.JLabel();
        lbl_CadastrarPet1 = new javax.swing.JLabel();
        jlbl_img_linha2 = new javax.swing.JLabel();
        jlbl_btn_editarRemedio = new javax.swing.JLabel();
        jlbl_btn_adicionarRemedio = new javax.swing.JLabel();
        jlbl_btn_removerRemedio = new javax.swing.JLabel();
        jlbl_img_adicionarRemedio1 = new javax.swing.JLabel();
        jlbl_img_adicionarRemedio2 = new javax.swing.JLabel();
        jlbl_img_adicionarRemedio3 = new javax.swing.JLabel();
        jlbl_nomePet_selecionado = new javax.swing.JLabel();
        jCombBox_pet_adicionar = new javax.swing.JComboBox<>();
        jlbl_img_linha3 = new javax.swing.JLabel();
        jlbl_adicionar_pet = new javax.swing.JLabel();
        jlbl_img_linha4 = new javax.swing.JLabel();
        jlbl_nomePet_selecionado1 = new javax.swing.JLabel();
        jtxtf_nomePet_selecionado1 = new javax.swing.JTextField();
        jlbl_donoPet_selcionado1 = new javax.swing.JLabel();
        jtxtf_donoPet_selecionado1 = new javax.swing.JTextField();
        jlbl_enderecoPet_selecionado1 = new javax.swing.JLabel();
        jtxtf_enderecoPet_selecionado1 = new javax.swing.JTextField();
        jlbl_background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PetAgenda - Cadastrar agendamento");
        setMaximumSize(new java.awt.Dimension(1366, 768));
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

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setMaximumSize(new java.awt.Dimension(880, 690));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(880, 690));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(880, 690));
        jScrollPane1.setViewportView(jPanel_cadastrar_agendamento);

        jPanel2.setMaximumSize(new java.awt.Dimension(870, 2147483647));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel_cadastrar_agendamento.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_cadastrar_agendamento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel_cadastrar_agendamento.setFont(new java.awt.Font("Merriweather", 0, 14)); // NOI18N
        jPanel_cadastrar_agendamento.setMaximumSize(new java.awt.Dimension(845, 1653));
        jPanel_cadastrar_agendamento.setMinimumSize(new java.awt.Dimension(845, 1653));
        jPanel_cadastrar_agendamento.setPreferredSize(new java.awt.Dimension(899, 1653));
        jPanel_cadastrar_agendamento.setLayout(null);

        jlbl_nomePet.setBackground(new java.awt.Color(0, 0, 0));
        jlbl_nomePet.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_nomePet.setForeground(new java.awt.Color(0, 0, 0));
        jlbl_nomePet.setText("Pet:");
        jPanel_cadastrar_agendamento.add(jlbl_nomePet);
        jlbl_nomePet.setBounds(50, 310, 26, 20);

        jtxtf_nomePet_selecionado.setBackground(new java.awt.Color(217, 217, 217));
        jtxtf_nomePet_selecionado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtf_nomePet_selecionado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jtxtf_nomePet_selecionado.setMinimumSize(new java.awt.Dimension(250, 50));
        jtxtf_nomePet_selecionado.setPreferredSize(new java.awt.Dimension(350, 50));
        jtxtf_nomePet_selecionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtf_nomePet_selecionadoActionPerformed(evt);
            }
        });
        jPanel_cadastrar_agendamento.add(jtxtf_nomePet_selecionado);
        jtxtf_nomePet_selecionado.setBounds(40, 452, 350, 50);

        jlbl_tipoServico.setBackground(new java.awt.Color(0, 0, 0));
        jlbl_tipoServico.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_tipoServico.setForeground(new java.awt.Color(0, 0, 0));
        jlbl_tipoServico.setText("Tipo do serviço:");
        jPanel_cadastrar_agendamento.add(jlbl_tipoServico);
        jlbl_tipoServico.setBounds(50, 160, 103, 20);

        jcmb_tipoServico.setBackground(new java.awt.Color(217, 217, 217));
        jcmb_tipoServico.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jcmb_tipoServico.setForeground(new java.awt.Color(0, 0, 0));
        jcmb_tipoServico.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jcmb_tipoServico.setMinimumSize(new java.awt.Dimension(200, 50));
        jcmb_tipoServico.setPreferredSize(new java.awt.Dimension(310, 50));
        jcmb_tipoServico.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcmb_tipoServicoItemStateChanged(evt);
            }
        });
        jPanel_cadastrar_agendamento.add(jcmb_tipoServico);
        jcmb_tipoServico.setBounds(40, 182, 310, 50);

        jlbl_observacao.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_observacao.setText("Observação");
        jPanel_cadastrar_agendamento.add(jlbl_observacao);
        jlbl_observacao.setBounds(50, 1660, 80, 20);

        jscp_jtxta_observacao.setBackground(new java.awt.Color(217, 217, 217));
        jscp_jtxta_observacao.setBorder(null);
        jscp_jtxta_observacao.setMinimumSize(new java.awt.Dimension(790, 140));
        jscp_jtxta_observacao.setPreferredSize(new java.awt.Dimension(790, 140));

        jtxta_observacao.setBackground(new java.awt.Color(217, 217, 217));
        jtxta_observacao.setColumns(20);
        jtxta_observacao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxta_observacao.setRows(5);
        jtxta_observacao.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jtxta_observacao.setMargin(new java.awt.Insets(16, 16, 16, 16));
        jtxta_observacao.setMaximumSize(new java.awt.Dimension(1200, 600));
        jtxta_observacao.setMinimumSize(new java.awt.Dimension(790, 80));
        jtxta_observacao.setPreferredSize(new java.awt.Dimension(790, 100));
        jscp_jtxta_observacao.setViewportView(jtxta_observacao);

        jPanel_cadastrar_agendamento.add(jscp_jtxta_observacao);
        jscp_jtxta_observacao.setBounds(40, 1690, 790, 140);

        jbtn_cadastrarPet.setBackground(new java.awt.Color(77, 120, 63));
        jbtn_cadastrarPet.setFont(new java.awt.Font("Merriweather", 0, 20)); // NOI18N
        jbtn_cadastrarPet.setForeground(new java.awt.Color(255, 255, 255));
        jbtn_cadastrarPet.setText("CADASTRAR");
        jbtn_cadastrarPet.setBorder(null);
        jbtn_cadastrarPet.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jbtn_cadastrarPet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_cadastrarPetActionPerformed(evt);
            }
        });
        // Aplicando a UI personalizada
        jbtn_cadastrarPet.setUI(new RoundedCornerButtonUI());
        jPanel_cadastrar_agendamento.add(jbtn_cadastrarPet);
        jbtn_cadastrarPet.setBounds(300, 1830, 240, 50);

        jlbl_enderecoPet_selecionado.setBackground(new java.awt.Color(0, 0, 0));
        jlbl_enderecoPet_selecionado.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_enderecoPet_selecionado.setForeground(new java.awt.Color(0, 0, 0));
        jlbl_enderecoPet_selecionado.setText("Endereço do Pet:");
        jPanel_cadastrar_agendamento.add(jlbl_enderecoPet_selecionado);
        jlbl_enderecoPet_selecionado.setBounds(50, 522, 113, 20);

        jtxtf_enderecoPet_selecionado.setBackground(new java.awt.Color(217, 217, 217));
        jtxtf_enderecoPet_selecionado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtf_enderecoPet_selecionado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jtxtf_enderecoPet_selecionado.setMinimumSize(new java.awt.Dimension(250, 50));
        jtxtf_enderecoPet_selecionado.setPreferredSize(new java.awt.Dimension(785, 50));
        jtxtf_enderecoPet_selecionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtf_enderecoPet_selecionadoActionPerformed(evt);
            }
        });
        jPanel_cadastrar_agendamento.add(jtxtf_enderecoPet_selecionado);
        jtxtf_enderecoPet_selecionado.setBounds(40, 544, 785, 50);

        jtxtf_dtAgendada.setBackground(new java.awt.Color(217, 217, 217));
        jtxtf_dtAgendada.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtf_dtAgendada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jtxtf_dtAgendada.setMinimumSize(new java.awt.Dimension(250, 50));
        jtxtf_dtAgendada.setPreferredSize(new java.awt.Dimension(230, 50));
        jtxtf_dtAgendada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtf_dtAgendadaActionPerformed(evt);
            }
        });
        jPanel_cadastrar_agendamento.add(jtxtf_dtAgendada);
        jtxtf_dtAgendada.setBounds(40, 1080, 230, 50);

        jlbl_dtAgendada.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_dtAgendada.setForeground(new java.awt.Color(0, 0, 0));
        jlbl_dtAgendada.setText("Data agendada:");
        jPanel_cadastrar_agendamento.add(jlbl_dtAgendada);
        jlbl_dtAgendada.setBounds(50, 1060, 103, 20);

        jlbl_hrAgendada.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_hrAgendada.setForeground(new java.awt.Color(0, 0, 0));
        jlbl_hrAgendada.setText("Horário agend.:");
        jPanel_cadastrar_agendamento.add(jlbl_hrAgendada);
        jlbl_hrAgendada.setBounds(310, 1060, 99, 20);

        jtxtf_hrAgendada.setBackground(new java.awt.Color(217, 217, 217));
        jtxtf_hrAgendada.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtf_hrAgendada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jtxtf_hrAgendada.setMinimumSize(new java.awt.Dimension(250, 50));
        jtxtf_hrAgendada.setPreferredSize(new java.awt.Dimension(250, 50));
        jtxtf_hrAgendada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtf_hrAgendadaActionPerformed(evt);
            }
        });
        jPanel_cadastrar_agendamento.add(jtxtf_hrAgendada);
        jtxtf_hrAgendada.setBounds(300, 1080, 120, 50);

        jcmb_remediosAdicionados.setBackground(new java.awt.Color(217, 217, 217));
        jcmb_remediosAdicionados.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jcmb_remediosAdicionados.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jcmb_remediosAdicionados.setMinimumSize(new java.awt.Dimension(200, 50));
        jcmb_remediosAdicionados.setPreferredSize(new java.awt.Dimension(200, 50));
        jPanel_cadastrar_agendamento.add(jcmb_remediosAdicionados);
        jcmb_remediosAdicionados.setBounds(460, 1420, 330, 50);

        jlbl_remediosAdicionados.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_remediosAdicionados.setText("Remédios adicionados");
        jPanel_cadastrar_agendamento.add(jlbl_remediosAdicionados);
        jlbl_remediosAdicionados.setBounds(470, 1400, 170, 20);

        jlbl_remedio.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_remedio.setText("Remédio");
        jPanel_cadastrar_agendamento.add(jlbl_remedio);
        jlbl_remedio.setBounds(80, 1310, 500, 20);

        jtxtf_remedio.setBackground(new java.awt.Color(217, 217, 217));
        jtxtf_remedio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtf_remedio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jtxtf_remedio.setMinimumSize(new java.awt.Dimension(250, 50));
        jtxtf_remedio.setPreferredSize(new java.awt.Dimension(250, 50));
        jtxtf_remedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtf_remedioActionPerformed(evt);
            }
        });
        jPanel_cadastrar_agendamento.add(jtxtf_remedio);
        jtxtf_remedio.setBounds(70, 1330, 600, 50);

        jlbl_intrucaoAdministracao.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_intrucaoAdministracao.setText("Instruções de administração");
        jPanel_cadastrar_agendamento.add(jlbl_intrucaoAdministracao);
        jlbl_intrucaoAdministracao.setBounds(80, 1400, 250, 20);

        jtxtf_intrucaoAdministracao.setBackground(new java.awt.Color(217, 217, 217));
        jtxtf_intrucaoAdministracao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtf_intrucaoAdministracao.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jtxtf_intrucaoAdministracao.setMinimumSize(new java.awt.Dimension(250, 50));
        jtxtf_intrucaoAdministracao.setPreferredSize(new java.awt.Dimension(250, 50));
        jtxtf_intrucaoAdministracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtf_intrucaoAdministracaoActionPerformed(evt);
            }
        });
        jPanel_cadastrar_agendamento.add(jtxtf_intrucaoAdministracao);
        jtxtf_intrucaoAdministracao.setBounds(70, 1420, 350, 50);

        jlbl_funcionarioAgendado.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_funcionarioAgendado.setForeground(new java.awt.Color(0, 0, 0));
        jlbl_funcionarioAgendado.setText("Funcionário agendado:");
        jPanel_cadastrar_agendamento.add(jlbl_funcionarioAgendado);
        jlbl_funcionarioAgendado.setBounds(470, 1060, 148, 20);

        jcmb_funcionarioAgendado.setBackground(new java.awt.Color(217, 217, 217));
        jcmb_funcionarioAgendado.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jcmb_funcionarioAgendado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECIONAR", "Roberto Antônio (35 anos)", "Silvia Rosimary da Costa (28 anos)" }));
        jcmb_funcionarioAgendado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jcmb_funcionarioAgendado.setMinimumSize(new java.awt.Dimension(200, 50));
        jcmb_funcionarioAgendado.setPreferredSize(new java.awt.Dimension(200, 50));
        jPanel_cadastrar_agendamento.add(jcmb_funcionarioAgendado);
        jcmb_funcionarioAgendado.setBounds(460, 1080, 370, 50);

        jlbl_donoPet_selcionado.setBackground(new java.awt.Color(0, 0, 0));
        jlbl_donoPet_selcionado.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_donoPet_selcionado.setForeground(new java.awt.Color(0, 0, 0));
        jlbl_donoPet_selcionado.setText("Dono do Pet:");
        jPanel_cadastrar_agendamento.add(jlbl_donoPet_selcionado);
        jlbl_donoPet_selcionado.setBounds(485, 430, 85, 20);

        jtxtf_donoPet_selecionado.setBackground(new java.awt.Color(217, 217, 217));
        jtxtf_donoPet_selecionado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtf_donoPet_selecionado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jtxtf_donoPet_selecionado.setMinimumSize(new java.awt.Dimension(250, 50));
        jtxtf_donoPet_selecionado.setPreferredSize(new java.awt.Dimension(350, 50));
        jtxtf_donoPet_selecionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtf_donoPet_selecionadoActionPerformed(evt);
            }
        });
        jPanel_cadastrar_agendamento.add(jtxtf_donoPet_selecionado);
        jtxtf_donoPet_selecionado.setBounds(475, 452, 350, 50);

        jlbl_horarioRemedio.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_horarioRemedio.setText("Horário");
        jPanel_cadastrar_agendamento.add(jlbl_horarioRemedio);
        jlbl_horarioRemedio.setBounds(710, 1310, 80, 20);

        jtxtf_horarioRemedio.setBackground(new java.awt.Color(217, 217, 217));
        jtxtf_horarioRemedio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtf_horarioRemedio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jtxtf_horarioRemedio.setMinimumSize(new java.awt.Dimension(250, 50));
        jtxtf_horarioRemedio.setPreferredSize(new java.awt.Dimension(250, 50));
        jtxtf_horarioRemedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtf_horarioRemedioActionPerformed(evt);
            }
        });
        jPanel_cadastrar_agendamento.add(jtxtf_horarioRemedio);
        jtxtf_horarioRemedio.setBounds(700, 1330, 90, 50);

        jlbl_img_adicionarRemedio.setFont(new java.awt.Font("Merriweather", 0, 45)); // NOI18N
        jlbl_img_adicionarRemedio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Data e funcionario agendamento.png"))); // NOI18N
        jlbl_img_adicionarRemedio.setText(" ");
        jlbl_img_adicionarRemedio.setToolTipText("");
        jPanel_cadastrar_agendamento.add(jlbl_img_adicionarRemedio);
        jlbl_img_adicionarRemedio.setBounds(40, 1000, 802, 58);

        lbl_CadastrarPet1.setFont(new java.awt.Font("Merriweather", 0, 45)); // NOI18N
        lbl_CadastrarPet1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cadastrar agendamento.png"))); // NOI18N
        lbl_CadastrarPet1.setText(" ");
        lbl_CadastrarPet1.setToolTipText("");
        jPanel_cadastrar_agendamento.add(lbl_CadastrarPet1);
        lbl_CadastrarPet1.setBounds(150, 30, 540, 58);

        jlbl_img_linha2.setFont(new java.awt.Font("Merriweather", 0, 45)); // NOI18N
        jlbl_img_linha2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/linha.png"))); // NOI18N
        jlbl_img_linha2.setText(" ");
        jlbl_img_linha2.setToolTipText("");
        jlbl_img_linha2.setPreferredSize(new java.awt.Dimension(805, 10));
        jPanel_cadastrar_agendamento.add(jlbl_img_linha2);
        jlbl_img_linha2.setBounds(40, 410, 805, 10);

        jlbl_btn_editarRemedio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btn editar.png"))); // NOI18N
        jPanel_cadastrar_agendamento.add(jlbl_btn_editarRemedio);
        jlbl_btn_editarRemedio.setBounds(570, 1490, 102, 30);

        jlbl_btn_adicionarRemedio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btn adicionar.png"))); // NOI18N
        jPanel_cadastrar_agendamento.add(jlbl_btn_adicionarRemedio);
        jlbl_btn_adicionarRemedio.setBounds(250, 1490, 123, 30);

        jlbl_btn_removerRemedio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btn remover.png"))); // NOI18N
        jPanel_cadastrar_agendamento.add(jlbl_btn_removerRemedio);
        jlbl_btn_removerRemedio.setBounds(110, 1490, 123, 30);

        jlbl_img_adicionarRemedio1.setFont(new java.awt.Font("Merriweather", 0, 45)); // NOI18N
        jlbl_img_adicionarRemedio1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adic remedio.png"))); // NOI18N
        jlbl_img_adicionarRemedio1.setText(" ");
        jlbl_img_adicionarRemedio1.setToolTipText("");
        jPanel_cadastrar_agendamento.add(jlbl_img_adicionarRemedio1);
        jlbl_img_adicionarRemedio1.setBounds(40, 1240, 802, 58);

        jlbl_img_adicionarRemedio2.setFont(new java.awt.Font("Merriweather", 0, 45)); // NOI18N
        jlbl_img_adicionarRemedio2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/servico_agendamento.png"))); // NOI18N
        jlbl_img_adicionarRemedio2.setText(" ");
        jlbl_img_adicionarRemedio2.setToolTipText("");
        jPanel_cadastrar_agendamento.add(jlbl_img_adicionarRemedio2);
        jlbl_img_adicionarRemedio2.setBounds(40, 100, 802, 58);

        jlbl_img_adicionarRemedio3.setFont(new java.awt.Font("Merriweather", 0, 45)); // NOI18N
        jlbl_img_adicionarRemedio3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pets_agendamento.png"))); // NOI18N
        jlbl_img_adicionarRemedio3.setText(" ");
        jlbl_img_adicionarRemedio3.setToolTipText("");
        jPanel_cadastrar_agendamento.add(jlbl_img_adicionarRemedio3);
        jlbl_img_adicionarRemedio3.setBounds(40, 252, 802, 58);

        jlbl_nomePet_selecionado.setBackground(new java.awt.Color(0, 0, 0));
        jlbl_nomePet_selecionado.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_nomePet_selecionado.setForeground(new java.awt.Color(0, 0, 0));
        jlbl_nomePet_selecionado.setText("Pet:");
        jPanel_cadastrar_agendamento.add(jlbl_nomePet_selecionado);
        jlbl_nomePet_selecionado.setBounds(50, 430, 26, 20);

        jCombBox_pet_adicionar.setBackground(new java.awt.Color(217, 217, 217));
        jCombBox_pet_adicionar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jCombBox_pet_adicionar.setPreferredSize(new java.awt.Dimension(350, 50));
        jPanel_cadastrar_agendamento.add(jCombBox_pet_adicionar);
        jCombBox_pet_adicionar.setBounds(40, 332, 350, 50);

        jlbl_img_linha3.setFont(new java.awt.Font("Merriweather", 0, 45)); // NOI18N
        jlbl_img_linha3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/linha.png"))); // NOI18N
        jlbl_img_linha3.setText(" ");
        jlbl_img_linha3.setToolTipText("");
        jPanel_cadastrar_agendamento.add(jlbl_img_linha3);
        jlbl_img_linha3.setBounds(30, 1540, 805, 10);

        jlbl_adicionar_pet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adicionar.png"))); // NOI18N
        jlbl_adicionar_pet.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlbl_adicionar_pet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbl_adicionar_petMouseClicked(evt);
            }
        });
        jPanel_cadastrar_agendamento.add(jlbl_adicionar_pet);
        jlbl_adicionar_pet.setBounds(410, 337, 40, 40);

        jlbl_img_linha4.setFont(new java.awt.Font("Merriweather", 0, 45)); // NOI18N
        jlbl_img_linha4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/linha.png"))); // NOI18N
        jlbl_img_linha4.setText(" ");
        jlbl_img_linha4.setToolTipText("");
        jlbl_img_linha4.setPreferredSize(new java.awt.Dimension(805, 10));
        jPanel_cadastrar_agendamento.add(jlbl_img_linha4);
        jlbl_img_linha4.setBounds(40, 620, 805, 10);

        jlbl_nomePet_selecionado1.setBackground(new java.awt.Color(0, 0, 0));
        jlbl_nomePet_selecionado1.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_nomePet_selecionado1.setForeground(new java.awt.Color(0, 0, 0));
        jlbl_nomePet_selecionado1.setText("Pet:");
        jPanel_cadastrar_agendamento.add(jlbl_nomePet_selecionado1);
        jlbl_nomePet_selecionado1.setBounds(50, 640, 26, 20);

        jtxtf_nomePet_selecionado1.setBackground(new java.awt.Color(217, 217, 217));
        jtxtf_nomePet_selecionado1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtf_nomePet_selecionado1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jtxtf_nomePet_selecionado1.setMinimumSize(new java.awt.Dimension(250, 50));
        jtxtf_nomePet_selecionado1.setPreferredSize(new java.awt.Dimension(350, 50));
        jtxtf_nomePet_selecionado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtf_nomePet_selecionado1ActionPerformed(evt);
            }
        });
        jPanel_cadastrar_agendamento.add(jtxtf_nomePet_selecionado1);
        jtxtf_nomePet_selecionado1.setBounds(40, 660, 350, 50);

        jlbl_donoPet_selcionado1.setBackground(new java.awt.Color(0, 0, 0));
        jlbl_donoPet_selcionado1.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_donoPet_selcionado1.setForeground(new java.awt.Color(0, 0, 0));
        jlbl_donoPet_selcionado1.setText("Dono do Pet:");
        jPanel_cadastrar_agendamento.add(jlbl_donoPet_selcionado1);
        jlbl_donoPet_selcionado1.setBounds(480, 640, 85, 20);

        jtxtf_donoPet_selecionado1.setBackground(new java.awt.Color(217, 217, 217));
        jtxtf_donoPet_selecionado1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtf_donoPet_selecionado1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jtxtf_donoPet_selecionado1.setMinimumSize(new java.awt.Dimension(250, 50));
        jtxtf_donoPet_selecionado1.setPreferredSize(new java.awt.Dimension(350, 50));
        jtxtf_donoPet_selecionado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtf_donoPet_selecionado1ActionPerformed(evt);
            }
        });
        jPanel_cadastrar_agendamento.add(jtxtf_donoPet_selecionado1);
        jtxtf_donoPet_selecionado1.setBounds(470, 660, 350, 50);

        jlbl_enderecoPet_selecionado1.setBackground(new java.awt.Color(0, 0, 0));
        jlbl_enderecoPet_selecionado1.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_enderecoPet_selecionado1.setForeground(new java.awt.Color(0, 0, 0));
        jlbl_enderecoPet_selecionado1.setText("Endereço do Pet:");
        jPanel_cadastrar_agendamento.add(jlbl_enderecoPet_selecionado1);
        jlbl_enderecoPet_selecionado1.setBounds(50, 730, 113, 20);

        jtxtf_enderecoPet_selecionado1.setBackground(new java.awt.Color(217, 217, 217));
        jtxtf_enderecoPet_selecionado1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtf_enderecoPet_selecionado1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jtxtf_enderecoPet_selecionado1.setMinimumSize(new java.awt.Dimension(250, 50));
        jtxtf_enderecoPet_selecionado1.setPreferredSize(new java.awt.Dimension(785, 50));
        jtxtf_enderecoPet_selecionado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtf_enderecoPet_selecionado1ActionPerformed(evt);
            }
        });
        jPanel_cadastrar_agendamento.add(jtxtf_enderecoPet_selecionado1);
        jtxtf_enderecoPet_selecionado1.setBounds(40, 750, 785, 50);

        jPanel2.add(jPanel_cadastrar_agendamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 1653));

        jScrollPane1.setViewportView(jPanel2);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(346, 46, -1, 2180));

        jlbl_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BG_PADRAO.png"))); // NOI18N
        getContentPane().add(jlbl_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtn_cadastrarPetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_cadastrarPetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtn_cadastrarPetActionPerformed

    private void jtxtf_nomePet_selecionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtf_nomePet_selecionadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtf_nomePet_selecionadoActionPerformed

    private void jtxtf_enderecoPet_selecionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtf_enderecoPet_selecionadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtf_enderecoPet_selecionadoActionPerformed

    private void jtxtf_dtAgendadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtf_dtAgendadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtf_dtAgendadaActionPerformed

    private void jtxtf_hrAgendadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtf_hrAgendadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtf_hrAgendadaActionPerformed

    private void jtxtf_remedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtf_remedioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtf_remedioActionPerformed

    private void jtxtf_intrucaoAdministracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtf_intrucaoAdministracaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtf_intrucaoAdministracaoActionPerformed

    private void jtxtf_donoPet_selecionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtf_donoPet_selecionadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtf_donoPet_selecionadoActionPerformed

    private void jtxtf_horarioRemedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtf_horarioRemedioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtf_horarioRemedioActionPerformed

    private void jlbl_adicionar_petMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbl_adicionar_petMouseClicked
        // TODO add your handling code here:
        // Usuário clicando para adicionar um pet.
        int index_selecionado = jCombBox_pet_adicionar.getSelectedIndex(); // Pega o index selecionado no combobox.
        
        if (index_selecionado > -1) { // Se for valido.
            todos_ids_pets_selecionados.add(todos_ids_pets.get(index_selecionado)); // Adiciona o id do pet selecionado aos ids selecionados.
            jCombBox_pet_adicionar.removeAllItems(); // Remove todos os itens do combobox.
            PreencherJComboboxPet(); // Preenche novamento o combobox sem o item selecionado.
        }
        else {
            JOptionPane.showMessageDialog(null, "Não há mais itens a ser selecionado", "Item inválido", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_jlbl_adicionar_petMouseClicked

    private void jcmb_tipoServicoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcmb_tipoServicoItemStateChanged
        // TODO add your handling code here:
        // Ao trocar de servico remove todos os pets do combobox e remove todos os pets selecionados.
        jCombBox_pet_adicionar.removeAllItems();
        todos_ids_pets_selecionados.clear();
        PreencherJComboboxPet(); // Preenche novamente com o serviço selecionado.
    }//GEN-LAST:event_jcmb_tipoServicoItemStateChanged

    private void jtxtf_nomePet_selecionado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtf_nomePet_selecionado1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtf_nomePet_selecionado1ActionPerformed

    private void jtxtf_donoPet_selecionado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtf_donoPet_selecionado1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtf_donoPet_selecionado1ActionPerformed

    private void jtxtf_enderecoPet_selecionado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtf_enderecoPet_selecionado1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtf_enderecoPet_selecionado1ActionPerformed
    
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
            java.util.logging.Logger.getLogger(tela_agendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tela_agendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tela_agendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tela_agendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tela_agendamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jCombBox_pet_adicionar;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel_cadastrar_agendamento;
    private javax.swing.JPanel jPanel_menu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtn_cadastrarPet;
    private javax.swing.JComboBox<String> jcmb_funcionarioAgendado;
    private javax.swing.JComboBox<String> jcmb_remediosAdicionados;
    private javax.swing.JComboBox<String> jcmb_tipoServico;
    private javax.swing.JLabel jlbl_adicionar_pet;
    private javax.swing.JLabel jlbl_background;
    private javax.swing.JLabel jlbl_btn_adicionarRemedio;
    private javax.swing.JLabel jlbl_btn_editarRemedio;
    private javax.swing.JLabel jlbl_btn_removerRemedio;
    private javax.swing.JLabel jlbl_donoPet_selcionado;
    private javax.swing.JLabel jlbl_donoPet_selcionado1;
    private javax.swing.JLabel jlbl_dtAgendada;
    private javax.swing.JLabel jlbl_enderecoPet_selecionado;
    private javax.swing.JLabel jlbl_enderecoPet_selecionado1;
    private javax.swing.JLabel jlbl_funcionarioAgendado;
    private javax.swing.JLabel jlbl_horarioRemedio;
    private javax.swing.JLabel jlbl_hrAgendada;
    private javax.swing.JLabel jlbl_img_adicionarRemedio;
    private javax.swing.JLabel jlbl_img_adicionarRemedio1;
    private javax.swing.JLabel jlbl_img_adicionarRemedio2;
    private javax.swing.JLabel jlbl_img_adicionarRemedio3;
    private javax.swing.JLabel jlbl_img_linha2;
    private javax.swing.JLabel jlbl_img_linha3;
    private javax.swing.JLabel jlbl_img_linha4;
    private javax.swing.JLabel jlbl_intrucaoAdministracao;
    private javax.swing.JLabel jlbl_nomePet;
    private javax.swing.JLabel jlbl_nomePet_selecionado;
    private javax.swing.JLabel jlbl_nomePet_selecionado1;
    private javax.swing.JLabel jlbl_observacao;
    private javax.swing.JLabel jlbl_remedio;
    private javax.swing.JLabel jlbl_remediosAdicionados;
    private javax.swing.JLabel jlbl_tipoServico;
    private javax.swing.JScrollPane jscp_jtxta_observacao;
    private javax.swing.JTextArea jtxta_observacao;
    private javax.swing.JTextField jtxtf_donoPet_selecionado;
    private javax.swing.JTextField jtxtf_donoPet_selecionado1;
    private javax.swing.JTextField jtxtf_dtAgendada;
    private javax.swing.JTextField jtxtf_enderecoPet_selecionado;
    private javax.swing.JTextField jtxtf_enderecoPet_selecionado1;
    private javax.swing.JTextField jtxtf_horarioRemedio;
    private javax.swing.JTextField jtxtf_hrAgendada;
    private javax.swing.JTextField jtxtf_intrucaoAdministracao;
    private javax.swing.JTextField jtxtf_nomePet_selecionado;
    private javax.swing.JTextField jtxtf_nomePet_selecionado1;
    private javax.swing.JTextField jtxtf_remedio;
    private javax.swing.JLabel lbl_CadastrarPet1;
    // End of variables declaration//GEN-END:variables
}
