package Interfaces;

import com.mycompany.petagenda.MenuPanel;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import petagenda.Cliente;
import petagenda.Funcionario;
import petagenda.Pet;
import petagenda.agendamento.Agendamento;
import petagenda.agendamento.Pet_agendamento;
import petagenda.bd.BD;
import petagenda.exception.IllegalArgumentsException;
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
    private static final ArrayList<Integer> todos_ids_funcionarios = new ArrayList<>();
    private static final ArrayList<Integer> todos_ids_pets_selecionados = new ArrayList<>();

    public tela_agendamento() throws SQLException {
        initComponents();
        initMenuPanel();
        AlinhaJField();
        todos_ids_servico.clear();
        BloqueiaJField(jtxtf_nomePet_selecionado_um, jtxtf_donoPet_selecionado_um, jtxtf_enderecoPet_selecionado_um);
        BloqueiaJField(jtxtf_nomePet_selecionado_dois, jtxtf_donoPet_selecionado_dois, jtxtf_enderecoPet_selecionado_dois);
        BloqueiaJField(jtxtf_nomePet_selecionado_tres, jtxtf_donoPet_selecionado_tres, jtxtf_enderecoPet_selecionado_tres);
        BloqueiaJField(jtxtf_nomePet_selecionado_quatro, jtxtf_donoPet_selecionado_quatro, jtxtf_enderecoPet_selecionado_quatro);
        BloqueiaJField(jtxtf_nomePet_selecionado_cinco, jtxtf_donoPet_selecionado_cinco, jtxtf_enderecoPet_selecionado_cinco);
        PreencherJComboboxFuncionario();
        PreencherJComboboxServico();
    }

    private void AlinhaJField() {
        Border line = BorderFactory.createLineBorder(Color.BLACK, 2);
        Border emptyJfield = new EmptyBorder(0, 5, 0, 0);
        Border emptyJText = new EmptyBorder(5, 5, 0, 0);
        CompoundBorder border_field = new CompoundBorder(line, emptyJfield);
        CompoundBorder border_text = new CompoundBorder(line, emptyJText);

        jcmb_tipoServico.setBorder(border_field);
        jCombBox_pet_adicionar.setBorder(border_field);
        
        jtxtf_nomePet_selecionado_um.setBorder(border_field);
        jtxtf_donoPet_selecionado_um.setBorder(border_field);
        jtxtf_enderecoPet_selecionado_um.setBorder(border_field);
        
        jtxtf_nomePet_selecionado_dois.setBorder(border_field);
        jtxtf_donoPet_selecionado_dois.setBorder(border_field);
        jtxtf_enderecoPet_selecionado_dois.setBorder(border_field);
        
        jtxtf_nomePet_selecionado_tres.setBorder(border_field);
        jtxtf_donoPet_selecionado_tres.setBorder(border_field);
        jtxtf_enderecoPet_selecionado_tres.setBorder(border_field);
        
        jtxtf_nomePet_selecionado_quatro.setBorder(border_field);
        jtxtf_donoPet_selecionado_quatro.setBorder(border_field);
        jtxtf_enderecoPet_selecionado_quatro.setBorder(border_field);
        
        jtxtf_nomePet_selecionado_cinco.setBorder(border_field);
        jtxtf_donoPet_selecionado_cinco.setBorder(border_field);
        jtxtf_enderecoPet_selecionado_cinco.setBorder(border_field);
        
        jtxtf_dtAgendada.setBorder(border_field);
        jtxtf_hrAgendada.setBorder(border_field);
        jcmb_funcionarioAgendado.setBorder(border_field);
        jtxtf_remedio.setBorder(border_field);
        jtxtf_horarioRemedio.setBorder(border_field);
        jtxtf_intrucaoAdministracao.setBorder(border_field);
        jcmb_remediosAdicionados.setBorder(border_field);
        jtxta_observacao.setBorder(border_text);
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
    private void PreencherJComboboxFuncionario() {
        Funcionario[] funcionarios = BD.Funcionario.selectAll();
        
        if (funcionarios != null) {
            // Preenche cada linha com cada funcionário dentro de funcionários.
            for (Funcionario funcionario : funcionarios) {
                String nome = funcionario.getNome();
                int id_funcionario = funcionario.getId();
                todos_ids_funcionarios.add(id_funcionario);
                System.out.println(todos_ids_funcionarios);
                jcmb_funcionarioAgendado.addItem(nome);
            }
        }
    }
    
    private void PreencheJField (int id, JTextField pet, JTextField dono_pet, JTextField endereco) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String banco = "jdbc:mysql://localhost:3306/pet_agenda";
        String usuario = "root";
        String senha = "";
        
        String nome_pet;
        String nome_dono;
        String end;
        
        try {
            conn = DriverManager.getConnection(banco, usuario, senha);
        
            String sql = "{CALL pet_e_dono(?)}";

            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            if (rs.next()) {
                nome_pet = rs.getString("pet");
                nome_dono = rs.getString("dono");
                end = (rs.getString("rua")) + ", " + (rs.getString("numero")) + " - " + (rs.getString("bairro")) + " - " + (rs.getString("cidade")) + " - " + (rs.getString("cep"));

                pet.setText(nome_pet);
                dono_pet.setText(nome_dono);
                endereco.setText(end);
            }
            
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    private void BloqueiaJField (JTextField pet, JTextField dono_pet, JTextField endereco) throws SQLException {
        pet.setEnabled(false);
        dono_pet.setEnabled(false);
        endereco.setEnabled(false);
    }
    
    private void LimpaJField (JTextField pet, JTextField dono_pet, JTextField endereco) throws SQLException {
        pet.setText(null);
        dono_pet.setText(null);
        endereco.setText(null);
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
    
    // Recebe as informações dos campos em um novo objeto do tipo petagenda.Cliente
    private Agendamento getFieldInfo() throws SQLException {
        Agendamento novo_agendamento = null;

        LocalDateTime dt_hr_marcada = null;
        int qntPasseios;
        LocalDateTime dta_hr_iniciado = null;
        LocalDateTime dta_hr_finalizado = null;
        int check_entrega;
        String observacao, endereco_pet;
        int id_funcionario;
        
        // dt_hr_marcada, dta_hr_iniciado, dta_hr_finalizado.
        String data = jtxtf_dtAgendada.getText(); // data
        String hora = jtxtf_hrAgendada.getText(); // hora
        
        String dia_hora = data + " " + hora; // data + hora
        
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); // formato esperado.
        
        // Tentando converter String para LocalDateTime.
        try {
            LocalDateTime local_date_time = LocalDateTime.parse(dia_hora, formato);
            String data_hora_formatada = local_date_time.format(formato);
            System.out.println("Data e Hora formatada: " + data_hora_formatada);
            dt_hr_marcada = local_date_time;
            dta_hr_iniciado = local_date_time;
            dta_hr_finalizado = local_date_time.plusMinutes(30);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Certifique-se que a data e hora esta correta\nano/mes/dia hh:mm:ss", "Erro de data", JOptionPane.ERROR_MESSAGE);
        }
        
        endereco_pet = "TEMPORARIO";
        
        // qntPasseios
        if (id_servico == 1) {
            qntPasseios = todos_ids_pets_selecionados.size();
        }
        else {
            qntPasseios = 0;
        }
        
        check_entrega = 0;
        
        
        observacao = jtxta_observacao.getText(); // observacao
        
        // Pega o id do funcionario.
        int func_selecionado = jcmb_funcionarioAgendado.getSelectedIndex();
        id_funcionario = todos_ids_funcionarios.get(func_selecionado);
        
        IllegalArgumentsException exsCadastro = new IllegalArgumentsException();
        
        // Criação do Agendamento.
        try {
            novo_agendamento = new Agendamento(dt_hr_marcada, endereco_pet, qntPasseios, dta_hr_iniciado, dta_hr_finalizado, check_entrega, observacao, id_servico, id_funcionario);  
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
        
        return novo_agendamento;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_menu = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel_cadastrar_agendamento = new javax.swing.JPanel();
        jlbl_nomePet = new javax.swing.JLabel();
        jtxtf_nomePet_selecionado_um = new javax.swing.JTextField();
        jlbl_tipoServico = new javax.swing.JLabel();
        jcmb_tipoServico = new javax.swing.JComboBox<>();
        jlbl_observacao = new javax.swing.JLabel();
        jscp_jtxta_observacao = new javax.swing.JScrollPane();
        jtxta_observacao = new javax.swing.JTextArea();
        jbtn_agendar = new javax.swing.JButton();
        jlbl_enderecoPet_selecionado_um = new javax.swing.JLabel();
        jtxtf_enderecoPet_selecionado_um = new javax.swing.JTextField();
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
        jlbl_donoPet_selcionado_um = new javax.swing.JLabel();
        jtxtf_donoPet_selecionado_um = new javax.swing.JTextField();
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
        jlbl_nomePet_selecionado_um = new javax.swing.JLabel();
        jCombBox_pet_adicionar = new javax.swing.JComboBox<>();
        jlbl_adicionar_pet = new javax.swing.JLabel();
        jlbl_img_linha4 = new javax.swing.JLabel();
        jlbl_nomePet_selecionado_dois = new javax.swing.JLabel();
        jtxtf_nomePet_selecionado_dois = new javax.swing.JTextField();
        jlbl_donoPet_selcionado_dois = new javax.swing.JLabel();
        jtxtf_donoPet_selecionado_dois = new javax.swing.JTextField();
        jlbl_enderecoPet_selecionado_dois = new javax.swing.JLabel();
        jtxtf_enderecoPet_selecionado_dois = new javax.swing.JTextField();
        jlbl_img_linha5 = new javax.swing.JLabel();
        jlbl_nomePet_selecionado_tres = new javax.swing.JLabel();
        jlbl_donoPet_selcionado_tres = new javax.swing.JLabel();
        jtxtf_donoPet_selecionado_tres = new javax.swing.JTextField();
        jtxtf_nomePet_selecionado_tres = new javax.swing.JTextField();
        jlbl_enderecoPet_selecionado_tres = new javax.swing.JLabel();
        jtxtf_enderecoPet_selecionado_tres = new javax.swing.JTextField();
        jlbl_img_linha6 = new javax.swing.JLabel();
        jlbl_nomePet_selecionado_quatro = new javax.swing.JLabel();
        jtxtf_nomePet_selecionado_quatro = new javax.swing.JTextField();
        jlbl_donoPet_selcionado_quatro = new javax.swing.JLabel();
        jtxtf_donoPet_selecionado_quatro = new javax.swing.JTextField();
        jlbl_enderecoPet_selecionado_quatro = new javax.swing.JLabel();
        jtxtf_enderecoPet_selecionado_quatro = new javax.swing.JTextField();
        jlbl_img_linha7 = new javax.swing.JLabel();
        jlbl_nomePet_selecionado_cinco = new javax.swing.JLabel();
        jtxtf_nomePet_selecionado_cinco = new javax.swing.JTextField();
        jlbl_donoPet_selcionado_cinco = new javax.swing.JLabel();
        jtxtf_donoPet_selecionado_cinco = new javax.swing.JTextField();
        jlbl_enderecoPet_selecionado_cinco = new javax.swing.JLabel();
        jtxtf_enderecoPet_selecionado_cinco = new javax.swing.JTextField();
        jlbl_img_adicionarRemedio4 = new javax.swing.JLabel();
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

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setMaximumSize(new java.awt.Dimension(880, 690));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(880, 690));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(880, 722));
        jScrollPane1.setRequestFocusEnabled(false);
        jScrollPane1.setViewportView(jPanel_cadastrar_agendamento);

        jPanel_cadastrar_agendamento.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_cadastrar_agendamento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel_cadastrar_agendamento.setFont(new java.awt.Font("Merriweather", 0, 14)); // NOI18N
        jPanel_cadastrar_agendamento.setMaximumSize(new java.awt.Dimension(845, 2250));
        jPanel_cadastrar_agendamento.setMinimumSize(new java.awt.Dimension(845, 2250));
        jPanel_cadastrar_agendamento.setPreferredSize(new java.awt.Dimension(899, 2250));
        jPanel_cadastrar_agendamento.setLayout(null);

        jlbl_nomePet.setBackground(new java.awt.Color(0, 0, 0));
        jlbl_nomePet.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_nomePet.setForeground(new java.awt.Color(0, 0, 0));
        jlbl_nomePet.setText("Pet:");
        jPanel_cadastrar_agendamento.add(jlbl_nomePet);
        jlbl_nomePet.setBounds(50, 310, 26, 20);

        jtxtf_nomePet_selecionado_um.setBackground(new java.awt.Color(217, 217, 217));
        jtxtf_nomePet_selecionado_um.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtf_nomePet_selecionado_um.setForeground(new java.awt.Color(0, 0, 0));
        jtxtf_nomePet_selecionado_um.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jtxtf_nomePet_selecionado_um.setMinimumSize(new java.awt.Dimension(250, 50));
        jtxtf_nomePet_selecionado_um.setPreferredSize(new java.awt.Dimension(350, 50));
        jtxtf_nomePet_selecionado_um.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtf_nomePet_selecionado_umActionPerformed(evt);
            }
        });
        jPanel_cadastrar_agendamento.add(jtxtf_nomePet_selecionado_um);
        jtxtf_nomePet_selecionado_um.setBounds(40, 452, 350, 50);

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
        jlbl_observacao.setForeground(new java.awt.Color(0, 0, 0));
        jlbl_observacao.setText("Observação");
        jPanel_cadastrar_agendamento.add(jlbl_observacao);
        jlbl_observacao.setBounds(50, 1940, 80, 20);

        jscp_jtxta_observacao.setBackground(new java.awt.Color(217, 217, 217));
        jscp_jtxta_observacao.setBorder(null);
        jscp_jtxta_observacao.setForeground(new java.awt.Color(0, 0, 0));
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
        jscp_jtxta_observacao.setBounds(40, 1964, 790, 140);

        jbtn_agendar.setBackground(new java.awt.Color(77, 120, 63));
        jbtn_agendar.setFont(new java.awt.Font("Merriweather", 0, 20)); // NOI18N
        jbtn_agendar.setForeground(new java.awt.Color(255, 255, 255));
        jbtn_agendar.setText("AGENDAR");
        jbtn_agendar.setBorder(null);
        jbtn_agendar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jbtn_agendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_agendarActionPerformed(evt);
            }
        });
        // Aplicando a UI personalizada
        jbtn_agendar.setUI(new RoundedCornerButtonUI());
        jPanel_cadastrar_agendamento.add(jbtn_agendar);
        jbtn_agendar.setBounds(310, 2150, 240, 50);

        jlbl_enderecoPet_selecionado_um.setBackground(new java.awt.Color(0, 0, 0));
        jlbl_enderecoPet_selecionado_um.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_enderecoPet_selecionado_um.setForeground(new java.awt.Color(0, 0, 0));
        jlbl_enderecoPet_selecionado_um.setText("Endereço do Pet:");
        jPanel_cadastrar_agendamento.add(jlbl_enderecoPet_selecionado_um);
        jlbl_enderecoPet_selecionado_um.setBounds(50, 522, 113, 20);

        jtxtf_enderecoPet_selecionado_um.setBackground(new java.awt.Color(217, 217, 217));
        jtxtf_enderecoPet_selecionado_um.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtf_enderecoPet_selecionado_um.setForeground(new java.awt.Color(0, 0, 0));
        jtxtf_enderecoPet_selecionado_um.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jtxtf_enderecoPet_selecionado_um.setMinimumSize(new java.awt.Dimension(250, 50));
        jtxtf_enderecoPet_selecionado_um.setPreferredSize(new java.awt.Dimension(785, 50));
        jtxtf_enderecoPet_selecionado_um.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtf_enderecoPet_selecionado_umActionPerformed(evt);
            }
        });
        jPanel_cadastrar_agendamento.add(jtxtf_enderecoPet_selecionado_um);
        jtxtf_enderecoPet_selecionado_um.setBounds(40, 544, 785, 50);

        jtxtf_dtAgendada.setBackground(new java.awt.Color(217, 217, 217));
        jtxtf_dtAgendada.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtf_dtAgendada.setForeground(new java.awt.Color(0, 0, 0));
        jtxtf_dtAgendada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jtxtf_dtAgendada.setMinimumSize(new java.awt.Dimension(250, 50));
        jtxtf_dtAgendada.setPreferredSize(new java.awt.Dimension(230, 50));
        jtxtf_dtAgendada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtf_dtAgendadaActionPerformed(evt);
            }
        });
        jPanel_cadastrar_agendamento.add(jtxtf_dtAgendada);
        jtxtf_dtAgendada.setBounds(40, 1530, 230, 50);

        jlbl_dtAgendada.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_dtAgendada.setForeground(new java.awt.Color(0, 0, 0));
        jlbl_dtAgendada.setText("Data agendada:");
        jPanel_cadastrar_agendamento.add(jlbl_dtAgendada);
        jlbl_dtAgendada.setBounds(50, 1510, 103, 20);

        jlbl_hrAgendada.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_hrAgendada.setForeground(new java.awt.Color(0, 0, 0));
        jlbl_hrAgendada.setText("Horário agend.:");
        jPanel_cadastrar_agendamento.add(jlbl_hrAgendada);
        jlbl_hrAgendada.setBounds(310, 1510, 99, 20);

        jtxtf_hrAgendada.setBackground(new java.awt.Color(217, 217, 217));
        jtxtf_hrAgendada.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtf_hrAgendada.setForeground(new java.awt.Color(0, 0, 0));
        jtxtf_hrAgendada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jtxtf_hrAgendada.setMinimumSize(new java.awt.Dimension(250, 50));
        jtxtf_hrAgendada.setPreferredSize(new java.awt.Dimension(250, 50));
        jtxtf_hrAgendada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtf_hrAgendadaActionPerformed(evt);
            }
        });
        jPanel_cadastrar_agendamento.add(jtxtf_hrAgendada);
        jtxtf_hrAgendada.setBounds(300, 1530, 120, 50);

        jcmb_remediosAdicionados.setBackground(new java.awt.Color(217, 217, 217));
        jcmb_remediosAdicionados.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jcmb_remediosAdicionados.setForeground(new java.awt.Color(0, 0, 0));
        jcmb_remediosAdicionados.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jcmb_remediosAdicionados.setMinimumSize(new java.awt.Dimension(200, 50));
        jcmb_remediosAdicionados.setPreferredSize(new java.awt.Dimension(200, 50));
        jPanel_cadastrar_agendamento.add(jcmb_remediosAdicionados);
        jcmb_remediosAdicionados.setBounds(460, 1780, 330, 50);

        jlbl_remediosAdicionados.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_remediosAdicionados.setForeground(new java.awt.Color(0, 0, 0));
        jlbl_remediosAdicionados.setText("Remédios adicionados");
        jPanel_cadastrar_agendamento.add(jlbl_remediosAdicionados);
        jlbl_remediosAdicionados.setBounds(470, 1760, 170, 20);

        jlbl_remedio.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_remedio.setForeground(new java.awt.Color(0, 0, 0));
        jlbl_remedio.setText("Remédio");
        jPanel_cadastrar_agendamento.add(jlbl_remedio);
        jlbl_remedio.setBounds(50, 1670, 500, 20);

        jtxtf_remedio.setBackground(new java.awt.Color(217, 217, 217));
        jtxtf_remedio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtf_remedio.setForeground(new java.awt.Color(0, 0, 0));
        jtxtf_remedio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jtxtf_remedio.setMinimumSize(new java.awt.Dimension(250, 50));
        jtxtf_remedio.setPreferredSize(new java.awt.Dimension(250, 50));
        jtxtf_remedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtf_remedioActionPerformed(evt);
            }
        });
        jPanel_cadastrar_agendamento.add(jtxtf_remedio);
        jtxtf_remedio.setBounds(40, 1690, 600, 50);

        jlbl_intrucaoAdministracao.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_intrucaoAdministracao.setForeground(new java.awt.Color(0, 0, 0));
        jlbl_intrucaoAdministracao.setText("Instruções de administração");
        jPanel_cadastrar_agendamento.add(jlbl_intrucaoAdministracao);
        jlbl_intrucaoAdministracao.setBounds(50, 1760, 250, 20);

        jtxtf_intrucaoAdministracao.setBackground(new java.awt.Color(217, 217, 217));
        jtxtf_intrucaoAdministracao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtf_intrucaoAdministracao.setForeground(new java.awt.Color(0, 0, 0));
        jtxtf_intrucaoAdministracao.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jtxtf_intrucaoAdministracao.setMinimumSize(new java.awt.Dimension(250, 50));
        jtxtf_intrucaoAdministracao.setPreferredSize(new java.awt.Dimension(250, 50));
        jtxtf_intrucaoAdministracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtf_intrucaoAdministracaoActionPerformed(evt);
            }
        });
        jPanel_cadastrar_agendamento.add(jtxtf_intrucaoAdministracao);
        jtxtf_intrucaoAdministracao.setBounds(40, 1780, 350, 50);

        jlbl_funcionarioAgendado.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_funcionarioAgendado.setForeground(new java.awt.Color(0, 0, 0));
        jlbl_funcionarioAgendado.setText("Funcionário agendado:");
        jPanel_cadastrar_agendamento.add(jlbl_funcionarioAgendado);
        jlbl_funcionarioAgendado.setBounds(470, 1510, 148, 20);

        jcmb_funcionarioAgendado.setBackground(new java.awt.Color(217, 217, 217));
        jcmb_funcionarioAgendado.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jcmb_funcionarioAgendado.setForeground(new java.awt.Color(0, 0, 0));
        jcmb_funcionarioAgendado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jcmb_funcionarioAgendado.setMinimumSize(new java.awt.Dimension(200, 50));
        jcmb_funcionarioAgendado.setPreferredSize(new java.awt.Dimension(200, 50));
        jPanel_cadastrar_agendamento.add(jcmb_funcionarioAgendado);
        jcmb_funcionarioAgendado.setBounds(460, 1530, 370, 50);

        jlbl_donoPet_selcionado_um.setBackground(new java.awt.Color(0, 0, 0));
        jlbl_donoPet_selcionado_um.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_donoPet_selcionado_um.setForeground(new java.awt.Color(0, 0, 0));
        jlbl_donoPet_selcionado_um.setText("Dono do Pet:");
        jPanel_cadastrar_agendamento.add(jlbl_donoPet_selcionado_um);
        jlbl_donoPet_selcionado_um.setBounds(485, 430, 85, 20);

        jtxtf_donoPet_selecionado_um.setBackground(new java.awt.Color(217, 217, 217));
        jtxtf_donoPet_selecionado_um.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtf_donoPet_selecionado_um.setForeground(new java.awt.Color(0, 0, 0));
        jtxtf_donoPet_selecionado_um.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jtxtf_donoPet_selecionado_um.setMinimumSize(new java.awt.Dimension(250, 50));
        jtxtf_donoPet_selecionado_um.setPreferredSize(new java.awt.Dimension(350, 50));
        jtxtf_donoPet_selecionado_um.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtf_donoPet_selecionado_umActionPerformed(evt);
            }
        });
        jPanel_cadastrar_agendamento.add(jtxtf_donoPet_selecionado_um);
        jtxtf_donoPet_selecionado_um.setBounds(475, 452, 350, 50);

        jlbl_horarioRemedio.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_horarioRemedio.setForeground(new java.awt.Color(0, 0, 0));
        jlbl_horarioRemedio.setText("Horário");
        jPanel_cadastrar_agendamento.add(jlbl_horarioRemedio);
        jlbl_horarioRemedio.setBounds(710, 1670, 80, 20);

        jtxtf_horarioRemedio.setBackground(new java.awt.Color(217, 217, 217));
        jtxtf_horarioRemedio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtf_horarioRemedio.setForeground(new java.awt.Color(0, 0, 0));
        jtxtf_horarioRemedio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jtxtf_horarioRemedio.setMinimumSize(new java.awt.Dimension(250, 50));
        jtxtf_horarioRemedio.setPreferredSize(new java.awt.Dimension(250, 50));
        jtxtf_horarioRemedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtf_horarioRemedioActionPerformed(evt);
            }
        });
        jPanel_cadastrar_agendamento.add(jtxtf_horarioRemedio);
        jtxtf_horarioRemedio.setBounds(700, 1690, 90, 50);

        jlbl_img_adicionarRemedio.setFont(new java.awt.Font("Merriweather", 0, 45)); // NOI18N
        jlbl_img_adicionarRemedio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Data e funcionario agendamento.png"))); // NOI18N
        jlbl_img_adicionarRemedio.setText(" ");
        jlbl_img_adicionarRemedio.setToolTipText("");
        jPanel_cadastrar_agendamento.add(jlbl_img_adicionarRemedio);
        jlbl_img_adicionarRemedio.setBounds(40, 1450, 802, 58);

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
        jlbl_btn_editarRemedio.setBounds(570, 1840, 102, 30);

        jlbl_btn_adicionarRemedio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btn adicionar.png"))); // NOI18N
        jPanel_cadastrar_agendamento.add(jlbl_btn_adicionarRemedio);
        jlbl_btn_adicionarRemedio.setBounds(250, 1840, 123, 30);

        jlbl_btn_removerRemedio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btn remover.png"))); // NOI18N
        jPanel_cadastrar_agendamento.add(jlbl_btn_removerRemedio);
        jlbl_btn_removerRemedio.setBounds(100, 1840, 123, 30);

        jlbl_img_adicionarRemedio1.setFont(new java.awt.Font("Merriweather", 0, 45)); // NOI18N
        jlbl_img_adicionarRemedio1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/observacoes.png"))); // NOI18N
        jlbl_img_adicionarRemedio1.setText(" ");
        jlbl_img_adicionarRemedio1.setToolTipText("");
        jPanel_cadastrar_agendamento.add(jlbl_img_adicionarRemedio1);
        jlbl_img_adicionarRemedio1.setBounds(40, 1880, 802, 58);

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

        jlbl_nomePet_selecionado_um.setBackground(new java.awt.Color(0, 0, 0));
        jlbl_nomePet_selecionado_um.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_nomePet_selecionado_um.setForeground(new java.awt.Color(0, 0, 0));
        jlbl_nomePet_selecionado_um.setText("Pet:");
        jPanel_cadastrar_agendamento.add(jlbl_nomePet_selecionado_um);
        jlbl_nomePet_selecionado_um.setBounds(50, 430, 26, 20);

        jCombBox_pet_adicionar.setBackground(new java.awt.Color(217, 217, 217));
        jCombBox_pet_adicionar.setForeground(new java.awt.Color(0, 0, 0));
        jCombBox_pet_adicionar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jCombBox_pet_adicionar.setPreferredSize(new java.awt.Dimension(350, 50));
        jPanel_cadastrar_agendamento.add(jCombBox_pet_adicionar);
        jCombBox_pet_adicionar.setBounds(40, 332, 350, 50);

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

        jlbl_nomePet_selecionado_dois.setBackground(new java.awt.Color(0, 0, 0));
        jlbl_nomePet_selecionado_dois.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_nomePet_selecionado_dois.setForeground(new java.awt.Color(0, 0, 0));
        jlbl_nomePet_selecionado_dois.setText("Pet:");
        jPanel_cadastrar_agendamento.add(jlbl_nomePet_selecionado_dois);
        jlbl_nomePet_selecionado_dois.setBounds(50, 640, 26, 20);

        jtxtf_nomePet_selecionado_dois.setBackground(new java.awt.Color(217, 217, 217));
        jtxtf_nomePet_selecionado_dois.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtf_nomePet_selecionado_dois.setForeground(new java.awt.Color(0, 0, 0));
        jtxtf_nomePet_selecionado_dois.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jtxtf_nomePet_selecionado_dois.setMinimumSize(new java.awt.Dimension(250, 50));
        jtxtf_nomePet_selecionado_dois.setPreferredSize(new java.awt.Dimension(350, 50));
        jtxtf_nomePet_selecionado_dois.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtf_nomePet_selecionado_doisActionPerformed(evt);
            }
        });
        jPanel_cadastrar_agendamento.add(jtxtf_nomePet_selecionado_dois);
        jtxtf_nomePet_selecionado_dois.setBounds(40, 660, 350, 50);

        jlbl_donoPet_selcionado_dois.setBackground(new java.awt.Color(0, 0, 0));
        jlbl_donoPet_selcionado_dois.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_donoPet_selcionado_dois.setForeground(new java.awt.Color(0, 0, 0));
        jlbl_donoPet_selcionado_dois.setText("Dono do Pet:");
        jPanel_cadastrar_agendamento.add(jlbl_donoPet_selcionado_dois);
        jlbl_donoPet_selcionado_dois.setBounds(480, 640, 85, 20);

        jtxtf_donoPet_selecionado_dois.setBackground(new java.awt.Color(217, 217, 217));
        jtxtf_donoPet_selecionado_dois.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtf_donoPet_selecionado_dois.setForeground(new java.awt.Color(0, 0, 0));
        jtxtf_donoPet_selecionado_dois.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jtxtf_donoPet_selecionado_dois.setMinimumSize(new java.awt.Dimension(250, 50));
        jtxtf_donoPet_selecionado_dois.setPreferredSize(new java.awt.Dimension(350, 50));
        jtxtf_donoPet_selecionado_dois.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtf_donoPet_selecionado_doisActionPerformed(evt);
            }
        });
        jPanel_cadastrar_agendamento.add(jtxtf_donoPet_selecionado_dois);
        jtxtf_donoPet_selecionado_dois.setBounds(470, 660, 350, 50);

        jlbl_enderecoPet_selecionado_dois.setBackground(new java.awt.Color(0, 0, 0));
        jlbl_enderecoPet_selecionado_dois.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_enderecoPet_selecionado_dois.setForeground(new java.awt.Color(0, 0, 0));
        jlbl_enderecoPet_selecionado_dois.setText("Endereço do Pet:");
        jPanel_cadastrar_agendamento.add(jlbl_enderecoPet_selecionado_dois);
        jlbl_enderecoPet_selecionado_dois.setBounds(50, 730, 113, 20);

        jtxtf_enderecoPet_selecionado_dois.setBackground(new java.awt.Color(217, 217, 217));
        jtxtf_enderecoPet_selecionado_dois.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtf_enderecoPet_selecionado_dois.setForeground(new java.awt.Color(0, 0, 0));
        jtxtf_enderecoPet_selecionado_dois.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jtxtf_enderecoPet_selecionado_dois.setMinimumSize(new java.awt.Dimension(250, 50));
        jtxtf_enderecoPet_selecionado_dois.setPreferredSize(new java.awt.Dimension(785, 50));
        jtxtf_enderecoPet_selecionado_dois.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtf_enderecoPet_selecionado_doisActionPerformed(evt);
            }
        });
        jPanel_cadastrar_agendamento.add(jtxtf_enderecoPet_selecionado_dois);
        jtxtf_enderecoPet_selecionado_dois.setBounds(40, 750, 785, 50);

        jlbl_img_linha5.setFont(new java.awt.Font("Merriweather", 0, 45)); // NOI18N
        jlbl_img_linha5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/linha.png"))); // NOI18N
        jlbl_img_linha5.setText(" ");
        jlbl_img_linha5.setToolTipText("");
        jlbl_img_linha5.setPreferredSize(new java.awt.Dimension(805, 10));
        jPanel_cadastrar_agendamento.add(jlbl_img_linha5);
        jlbl_img_linha5.setBounds(40, 830, 805, 10);

        jlbl_nomePet_selecionado_tres.setBackground(new java.awt.Color(0, 0, 0));
        jlbl_nomePet_selecionado_tres.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_nomePet_selecionado_tres.setForeground(new java.awt.Color(0, 0, 0));
        jlbl_nomePet_selecionado_tres.setText("Pet:");
        jPanel_cadastrar_agendamento.add(jlbl_nomePet_selecionado_tres);
        jlbl_nomePet_selecionado_tres.setBounds(50, 850, 26, 20);

        jlbl_donoPet_selcionado_tres.setBackground(new java.awt.Color(0, 0, 0));
        jlbl_donoPet_selcionado_tres.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_donoPet_selcionado_tres.setForeground(new java.awt.Color(0, 0, 0));
        jlbl_donoPet_selcionado_tres.setText("Dono do Pet:");
        jPanel_cadastrar_agendamento.add(jlbl_donoPet_selcionado_tres);
        jlbl_donoPet_selcionado_tres.setBounds(480, 850, 85, 20);

        jtxtf_donoPet_selecionado_tres.setBackground(new java.awt.Color(217, 217, 217));
        jtxtf_donoPet_selecionado_tres.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtf_donoPet_selecionado_tres.setForeground(new java.awt.Color(0, 0, 0));
        jtxtf_donoPet_selecionado_tres.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jtxtf_donoPet_selecionado_tres.setMinimumSize(new java.awt.Dimension(250, 50));
        jtxtf_donoPet_selecionado_tres.setPreferredSize(new java.awt.Dimension(350, 50));
        jtxtf_donoPet_selecionado_tres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtf_donoPet_selecionado_tresActionPerformed(evt);
            }
        });
        jPanel_cadastrar_agendamento.add(jtxtf_donoPet_selecionado_tres);
        jtxtf_donoPet_selecionado_tres.setBounds(470, 870, 350, 50);

        jtxtf_nomePet_selecionado_tres.setBackground(new java.awt.Color(217, 217, 217));
        jtxtf_nomePet_selecionado_tres.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtf_nomePet_selecionado_tres.setForeground(new java.awt.Color(0, 0, 0));
        jtxtf_nomePet_selecionado_tres.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jtxtf_nomePet_selecionado_tres.setMinimumSize(new java.awt.Dimension(250, 50));
        jtxtf_nomePet_selecionado_tres.setPreferredSize(new java.awt.Dimension(350, 50));
        jtxtf_nomePet_selecionado_tres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtf_nomePet_selecionado_tresActionPerformed(evt);
            }
        });
        jPanel_cadastrar_agendamento.add(jtxtf_nomePet_selecionado_tres);
        jtxtf_nomePet_selecionado_tres.setBounds(40, 870, 350, 50);

        jlbl_enderecoPet_selecionado_tres.setBackground(new java.awt.Color(0, 0, 0));
        jlbl_enderecoPet_selecionado_tres.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_enderecoPet_selecionado_tres.setForeground(new java.awt.Color(0, 0, 0));
        jlbl_enderecoPet_selecionado_tres.setText("Endereço do Pet:");
        jPanel_cadastrar_agendamento.add(jlbl_enderecoPet_selecionado_tres);
        jlbl_enderecoPet_selecionado_tres.setBounds(50, 940, 113, 20);

        jtxtf_enderecoPet_selecionado_tres.setBackground(new java.awt.Color(217, 217, 217));
        jtxtf_enderecoPet_selecionado_tres.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtf_enderecoPet_selecionado_tres.setForeground(new java.awt.Color(0, 0, 0));
        jtxtf_enderecoPet_selecionado_tres.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jtxtf_enderecoPet_selecionado_tres.setMinimumSize(new java.awt.Dimension(250, 50));
        jtxtf_enderecoPet_selecionado_tres.setPreferredSize(new java.awt.Dimension(785, 50));
        jtxtf_enderecoPet_selecionado_tres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtf_enderecoPet_selecionado_tresActionPerformed(evt);
            }
        });
        jPanel_cadastrar_agendamento.add(jtxtf_enderecoPet_selecionado_tres);
        jtxtf_enderecoPet_selecionado_tres.setBounds(40, 960, 785, 50);

        jlbl_img_linha6.setFont(new java.awt.Font("Merriweather", 0, 45)); // NOI18N
        jlbl_img_linha6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/linha.png"))); // NOI18N
        jlbl_img_linha6.setText(" ");
        jlbl_img_linha6.setToolTipText("");
        jlbl_img_linha6.setPreferredSize(new java.awt.Dimension(805, 10));
        jPanel_cadastrar_agendamento.add(jlbl_img_linha6);
        jlbl_img_linha6.setBounds(40, 1040, 805, 10);

        jlbl_nomePet_selecionado_quatro.setBackground(new java.awt.Color(0, 0, 0));
        jlbl_nomePet_selecionado_quatro.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_nomePet_selecionado_quatro.setForeground(new java.awt.Color(0, 0, 0));
        jlbl_nomePet_selecionado_quatro.setText("Pet:");
        jPanel_cadastrar_agendamento.add(jlbl_nomePet_selecionado_quatro);
        jlbl_nomePet_selecionado_quatro.setBounds(50, 1060, 26, 20);

        jtxtf_nomePet_selecionado_quatro.setBackground(new java.awt.Color(217, 217, 217));
        jtxtf_nomePet_selecionado_quatro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtf_nomePet_selecionado_quatro.setForeground(new java.awt.Color(0, 0, 0));
        jtxtf_nomePet_selecionado_quatro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jtxtf_nomePet_selecionado_quatro.setMinimumSize(new java.awt.Dimension(250, 50));
        jtxtf_nomePet_selecionado_quatro.setPreferredSize(new java.awt.Dimension(350, 50));
        jtxtf_nomePet_selecionado_quatro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtf_nomePet_selecionado_quatroActionPerformed(evt);
            }
        });
        jPanel_cadastrar_agendamento.add(jtxtf_nomePet_selecionado_quatro);
        jtxtf_nomePet_selecionado_quatro.setBounds(40, 1080, 350, 50);

        jlbl_donoPet_selcionado_quatro.setBackground(new java.awt.Color(0, 0, 0));
        jlbl_donoPet_selcionado_quatro.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_donoPet_selcionado_quatro.setForeground(new java.awt.Color(0, 0, 0));
        jlbl_donoPet_selcionado_quatro.setText("Dono do Pet:");
        jPanel_cadastrar_agendamento.add(jlbl_donoPet_selcionado_quatro);
        jlbl_donoPet_selcionado_quatro.setBounds(480, 1060, 85, 20);

        jtxtf_donoPet_selecionado_quatro.setBackground(new java.awt.Color(217, 217, 217));
        jtxtf_donoPet_selecionado_quatro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtf_donoPet_selecionado_quatro.setForeground(new java.awt.Color(0, 0, 0));
        jtxtf_donoPet_selecionado_quatro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jtxtf_donoPet_selecionado_quatro.setMinimumSize(new java.awt.Dimension(250, 50));
        jtxtf_donoPet_selecionado_quatro.setPreferredSize(new java.awt.Dimension(350, 50));
        jtxtf_donoPet_selecionado_quatro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtf_donoPet_selecionado_quatroActionPerformed(evt);
            }
        });
        jPanel_cadastrar_agendamento.add(jtxtf_donoPet_selecionado_quatro);
        jtxtf_donoPet_selecionado_quatro.setBounds(470, 1080, 350, 50);

        jlbl_enderecoPet_selecionado_quatro.setBackground(new java.awt.Color(0, 0, 0));
        jlbl_enderecoPet_selecionado_quatro.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_enderecoPet_selecionado_quatro.setForeground(new java.awt.Color(0, 0, 0));
        jlbl_enderecoPet_selecionado_quatro.setText("Endereço do Pet:");
        jPanel_cadastrar_agendamento.add(jlbl_enderecoPet_selecionado_quatro);
        jlbl_enderecoPet_selecionado_quatro.setBounds(50, 1150, 113, 20);

        jtxtf_enderecoPet_selecionado_quatro.setBackground(new java.awt.Color(217, 217, 217));
        jtxtf_enderecoPet_selecionado_quatro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtf_enderecoPet_selecionado_quatro.setForeground(new java.awt.Color(0, 0, 0));
        jtxtf_enderecoPet_selecionado_quatro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jtxtf_enderecoPet_selecionado_quatro.setMinimumSize(new java.awt.Dimension(250, 50));
        jtxtf_enderecoPet_selecionado_quatro.setPreferredSize(new java.awt.Dimension(785, 50));
        jtxtf_enderecoPet_selecionado_quatro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtf_enderecoPet_selecionado_quatroActionPerformed(evt);
            }
        });
        jPanel_cadastrar_agendamento.add(jtxtf_enderecoPet_selecionado_quatro);
        jtxtf_enderecoPet_selecionado_quatro.setBounds(40, 1170, 785, 50);

        jlbl_img_linha7.setFont(new java.awt.Font("Merriweather", 0, 45)); // NOI18N
        jlbl_img_linha7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/linha.png"))); // NOI18N
        jlbl_img_linha7.setText(" ");
        jlbl_img_linha7.setToolTipText("");
        jlbl_img_linha7.setPreferredSize(new java.awt.Dimension(805, 10));
        jPanel_cadastrar_agendamento.add(jlbl_img_linha7);
        jlbl_img_linha7.setBounds(40, 1250, 805, 10);

        jlbl_nomePet_selecionado_cinco.setBackground(new java.awt.Color(0, 0, 0));
        jlbl_nomePet_selecionado_cinco.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_nomePet_selecionado_cinco.setForeground(new java.awt.Color(0, 0, 0));
        jlbl_nomePet_selecionado_cinco.setText("Pet:");
        jPanel_cadastrar_agendamento.add(jlbl_nomePet_selecionado_cinco);
        jlbl_nomePet_selecionado_cinco.setBounds(50, 1270, 26, 20);

        jtxtf_nomePet_selecionado_cinco.setBackground(new java.awt.Color(217, 217, 217));
        jtxtf_nomePet_selecionado_cinco.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtf_nomePet_selecionado_cinco.setForeground(new java.awt.Color(0, 0, 0));
        jtxtf_nomePet_selecionado_cinco.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jtxtf_nomePet_selecionado_cinco.setMinimumSize(new java.awt.Dimension(250, 50));
        jtxtf_nomePet_selecionado_cinco.setPreferredSize(new java.awt.Dimension(350, 50));
        jtxtf_nomePet_selecionado_cinco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtf_nomePet_selecionado_cincoActionPerformed(evt);
            }
        });
        jPanel_cadastrar_agendamento.add(jtxtf_nomePet_selecionado_cinco);
        jtxtf_nomePet_selecionado_cinco.setBounds(40, 1290, 350, 50);

        jlbl_donoPet_selcionado_cinco.setBackground(new java.awt.Color(0, 0, 0));
        jlbl_donoPet_selcionado_cinco.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_donoPet_selcionado_cinco.setForeground(new java.awt.Color(0, 0, 0));
        jlbl_donoPet_selcionado_cinco.setText("Dono do Pet:");
        jPanel_cadastrar_agendamento.add(jlbl_donoPet_selcionado_cinco);
        jlbl_donoPet_selcionado_cinco.setBounds(480, 1270, 85, 20);

        jtxtf_donoPet_selecionado_cinco.setBackground(new java.awt.Color(217, 217, 217));
        jtxtf_donoPet_selecionado_cinco.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtf_donoPet_selecionado_cinco.setForeground(new java.awt.Color(0, 0, 0));
        jtxtf_donoPet_selecionado_cinco.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jtxtf_donoPet_selecionado_cinco.setMinimumSize(new java.awt.Dimension(250, 50));
        jtxtf_donoPet_selecionado_cinco.setPreferredSize(new java.awt.Dimension(350, 50));
        jtxtf_donoPet_selecionado_cinco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtf_donoPet_selecionado_cincoActionPerformed(evt);
            }
        });
        jPanel_cadastrar_agendamento.add(jtxtf_donoPet_selecionado_cinco);
        jtxtf_donoPet_selecionado_cinco.setBounds(470, 1290, 350, 50);

        jlbl_enderecoPet_selecionado_cinco.setBackground(new java.awt.Color(0, 0, 0));
        jlbl_enderecoPet_selecionado_cinco.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jlbl_enderecoPet_selecionado_cinco.setForeground(new java.awt.Color(0, 0, 0));
        jlbl_enderecoPet_selecionado_cinco.setText("Endereço do Pet:");
        jPanel_cadastrar_agendamento.add(jlbl_enderecoPet_selecionado_cinco);
        jlbl_enderecoPet_selecionado_cinco.setBounds(50, 1360, 113, 20);

        jtxtf_enderecoPet_selecionado_cinco.setBackground(new java.awt.Color(217, 217, 217));
        jtxtf_enderecoPet_selecionado_cinco.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtf_enderecoPet_selecionado_cinco.setForeground(new java.awt.Color(0, 0, 0));
        jtxtf_enderecoPet_selecionado_cinco.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jtxtf_enderecoPet_selecionado_cinco.setMinimumSize(new java.awt.Dimension(250, 50));
        jtxtf_enderecoPet_selecionado_cinco.setPreferredSize(new java.awt.Dimension(785, 50));
        jtxtf_enderecoPet_selecionado_cinco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtf_enderecoPet_selecionado_cincoActionPerformed(evt);
            }
        });
        jPanel_cadastrar_agendamento.add(jtxtf_enderecoPet_selecionado_cinco);
        jtxtf_enderecoPet_selecionado_cinco.setBounds(40, 1380, 785, 50);

        jlbl_img_adicionarRemedio4.setFont(new java.awt.Font("Merriweather", 0, 45)); // NOI18N
        jlbl_img_adicionarRemedio4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adic remedio.png"))); // NOI18N
        jlbl_img_adicionarRemedio4.setText(" ");
        jlbl_img_adicionarRemedio4.setToolTipText("");
        jPanel_cadastrar_agendamento.add(jlbl_img_adicionarRemedio4);
        jlbl_img_adicionarRemedio4.setBounds(40, 1610, 802, 58);

        jScrollPane1.setViewportView(jPanel_cadastrar_agendamento);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(346, 46, -1, -1));

        jlbl_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BG_PADRAO.png"))); // NOI18N
        getContentPane().add(jlbl_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtn_agendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_agendarActionPerformed
        // TODO add your handling code here:
        Agendamento agendamento = null;
        
        // Cadastro do agendamento.
        try {
            agendamento = getFieldInfo(); // Retornara null se informações não forem válidas.
        }
        catch (SQLException ex) {
            Logger.getLogger(Tela_cadastro_cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (!todos_ids_pets_selecionados.isEmpty()) {
            if (agendamento != null) {
                int ag = BD.agendamento.insert(agendamento); // Dando insert no agendamento.
                
                int id_agendamento = agendamento.getId(); // id_agendamento.
                
                System.out.println(todos_ids_pets_selecionados);
                // pet_agendamento
                for (Integer id_pet : todos_ids_pets_selecionados) {
                    Pet_agendamento pet_agendamento = new Pet_agendamento(id_agendamento, id_pet);
                    System.out.println("id_agendamento: " + id_agendamento);
                    System.out.println("id_pet: " + id_pet);
                    
                    int pa = BD.pet_agendamento.insert(pet_agendamento); // Dando insert no peg_agendamento.
                    if (pa > 0) {
                        System.out.println("pet_agendamento cadastrado com sucesso.");
                    }
                }
                
                if (ag > 0) {
                    JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
                }
            }
        }
    }//GEN-LAST:event_jbtn_agendarActionPerformed

    private void jtxtf_nomePet_selecionado_umActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtf_nomePet_selecionado_umActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtf_nomePet_selecionado_umActionPerformed

    private void jtxtf_enderecoPet_selecionado_umActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtf_enderecoPet_selecionado_umActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtf_enderecoPet_selecionado_umActionPerformed

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

    private void jtxtf_donoPet_selecionado_umActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtf_donoPet_selecionado_umActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtf_donoPet_selecionado_umActionPerformed

    private void jtxtf_horarioRemedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtf_horarioRemedioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtf_horarioRemedioActionPerformed

    private void jlbl_adicionar_petMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbl_adicionar_petMouseClicked
        // TODO add your handling code here:
        // Usuário clicando para adicionar um pet.
        int index_selecionado = jCombBox_pet_adicionar.getSelectedIndex(); // Pega o index selecionado no combobox.
        
        int count = 0;
        
        if (index_selecionado > -1) { // Se for valido.
            int id = todos_ids_pets.get(index_selecionado);
            todos_ids_pets_selecionados.add(id); // Adiciona o id do pet selecionado aos ids selecionados.
            jCombBox_pet_adicionar.removeAllItems(); // Remove todos os itens do combobox.
            PreencherJComboboxPet(); // Preenche novamento o combobox sem o item selecionado.
            
            switch (todos_ids_pets.size()) {
                case 4 -> {
                    try {
                        PreencheJField(id, jtxtf_nomePet_selecionado_um, jtxtf_donoPet_selecionado_um, jtxtf_enderecoPet_selecionado_um);
                    } catch (SQLException ex) {
                        Logger.getLogger(tela_agendamento.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                case 3 -> {
                    try {
                        PreencheJField(id, jtxtf_nomePet_selecionado_dois, jtxtf_donoPet_selecionado_dois, jtxtf_enderecoPet_selecionado_dois);
                    } catch (SQLException ex) {
                        Logger.getLogger(tela_agendamento.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                case 2 -> {
                    try {
                        PreencheJField(id, jtxtf_nomePet_selecionado_tres, jtxtf_donoPet_selecionado_tres, jtxtf_enderecoPet_selecionado_tres);
                    } catch (SQLException ex) {
                        Logger.getLogger(tela_agendamento.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                case 1 -> {
                    try {
                        PreencheJField(id, jtxtf_nomePet_selecionado_quatro, jtxtf_donoPet_selecionado_quatro, jtxtf_enderecoPet_selecionado_quatro);
                    } catch (SQLException ex) {
                        Logger.getLogger(tela_agendamento.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                case 0 -> {
                    try {
                        PreencheJField(id, jtxtf_nomePet_selecionado_cinco, jtxtf_donoPet_selecionado_cinco, jtxtf_enderecoPet_selecionado_cinco);
                    } catch (SQLException ex) {
                        Logger.getLogger(tela_agendamento.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                default -> {
                }
            }
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
        try {
            LimpaJField(jtxtf_nomePet_selecionado_um, jtxtf_donoPet_selecionado_um, jtxtf_enderecoPet_selecionado_um);
            LimpaJField(jtxtf_nomePet_selecionado_dois, jtxtf_donoPet_selecionado_dois, jtxtf_enderecoPet_selecionado_dois);
            LimpaJField(jtxtf_nomePet_selecionado_tres, jtxtf_donoPet_selecionado_tres, jtxtf_enderecoPet_selecionado_tres);
            LimpaJField(jtxtf_nomePet_selecionado_quatro, jtxtf_donoPet_selecionado_quatro, jtxtf_enderecoPet_selecionado_quatro);
            LimpaJField(jtxtf_nomePet_selecionado_cinco, jtxtf_donoPet_selecionado_cinco, jtxtf_enderecoPet_selecionado_cinco);
        } catch (SQLException ex) {
            Logger.getLogger(tela_agendamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreencherJComboboxPet(); // Preenche novamente com o serviço selecionado.
    }//GEN-LAST:event_jcmb_tipoServicoItemStateChanged

    private void jtxtf_nomePet_selecionado_doisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtf_nomePet_selecionado_doisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtf_nomePet_selecionado_doisActionPerformed

    private void jtxtf_donoPet_selecionado_doisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtf_donoPet_selecionado_doisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtf_donoPet_selecionado_doisActionPerformed

    private void jtxtf_enderecoPet_selecionado_doisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtf_enderecoPet_selecionado_doisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtf_enderecoPet_selecionado_doisActionPerformed

    private void jtxtf_donoPet_selecionado_tresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtf_donoPet_selecionado_tresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtf_donoPet_selecionado_tresActionPerformed

    private void jtxtf_nomePet_selecionado_tresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtf_nomePet_selecionado_tresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtf_nomePet_selecionado_tresActionPerformed

    private void jtxtf_enderecoPet_selecionado_tresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtf_enderecoPet_selecionado_tresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtf_enderecoPet_selecionado_tresActionPerformed

    private void jtxtf_nomePet_selecionado_quatroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtf_nomePet_selecionado_quatroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtf_nomePet_selecionado_quatroActionPerformed

    private void jtxtf_donoPet_selecionado_quatroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtf_donoPet_selecionado_quatroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtf_donoPet_selecionado_quatroActionPerformed

    private void jtxtf_enderecoPet_selecionado_quatroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtf_enderecoPet_selecionado_quatroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtf_enderecoPet_selecionado_quatroActionPerformed

    private void jtxtf_nomePet_selecionado_cincoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtf_nomePet_selecionado_cincoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtf_nomePet_selecionado_cincoActionPerformed

    private void jtxtf_donoPet_selecionado_cincoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtf_donoPet_selecionado_cincoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtf_donoPet_selecionado_cincoActionPerformed

    private void jtxtf_enderecoPet_selecionado_cincoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtf_enderecoPet_selecionado_cincoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtf_enderecoPet_selecionado_cincoActionPerformed
    
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
                try {
                    new tela_agendamento().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(tela_agendamento.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jCombBox_pet_adicionar;
    private javax.swing.JPanel jPanel_cadastrar_agendamento;
    private javax.swing.JPanel jPanel_menu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtn_agendar;
    private javax.swing.JComboBox<String> jcmb_funcionarioAgendado;
    private javax.swing.JComboBox<String> jcmb_remediosAdicionados;
    private javax.swing.JComboBox<String> jcmb_tipoServico;
    private javax.swing.JLabel jlbl_adicionar_pet;
    private javax.swing.JLabel jlbl_background;
    private javax.swing.JLabel jlbl_btn_adicionarRemedio;
    private javax.swing.JLabel jlbl_btn_editarRemedio;
    private javax.swing.JLabel jlbl_btn_removerRemedio;
    private javax.swing.JLabel jlbl_donoPet_selcionado_cinco;
    private javax.swing.JLabel jlbl_donoPet_selcionado_dois;
    private javax.swing.JLabel jlbl_donoPet_selcionado_quatro;
    private javax.swing.JLabel jlbl_donoPet_selcionado_tres;
    private javax.swing.JLabel jlbl_donoPet_selcionado_um;
    private javax.swing.JLabel jlbl_dtAgendada;
    private javax.swing.JLabel jlbl_enderecoPet_selecionado_cinco;
    private javax.swing.JLabel jlbl_enderecoPet_selecionado_dois;
    private javax.swing.JLabel jlbl_enderecoPet_selecionado_quatro;
    private javax.swing.JLabel jlbl_enderecoPet_selecionado_tres;
    private javax.swing.JLabel jlbl_enderecoPet_selecionado_um;
    private javax.swing.JLabel jlbl_funcionarioAgendado;
    private javax.swing.JLabel jlbl_horarioRemedio;
    private javax.swing.JLabel jlbl_hrAgendada;
    private javax.swing.JLabel jlbl_img_adicionarRemedio;
    private javax.swing.JLabel jlbl_img_adicionarRemedio1;
    private javax.swing.JLabel jlbl_img_adicionarRemedio2;
    private javax.swing.JLabel jlbl_img_adicionarRemedio3;
    private javax.swing.JLabel jlbl_img_adicionarRemedio4;
    private javax.swing.JLabel jlbl_img_linha2;
    private javax.swing.JLabel jlbl_img_linha4;
    private javax.swing.JLabel jlbl_img_linha5;
    private javax.swing.JLabel jlbl_img_linha6;
    private javax.swing.JLabel jlbl_img_linha7;
    private javax.swing.JLabel jlbl_intrucaoAdministracao;
    private javax.swing.JLabel jlbl_nomePet;
    private javax.swing.JLabel jlbl_nomePet_selecionado_cinco;
    private javax.swing.JLabel jlbl_nomePet_selecionado_dois;
    private javax.swing.JLabel jlbl_nomePet_selecionado_quatro;
    private javax.swing.JLabel jlbl_nomePet_selecionado_tres;
    private javax.swing.JLabel jlbl_nomePet_selecionado_um;
    private javax.swing.JLabel jlbl_observacao;
    private javax.swing.JLabel jlbl_remedio;
    private javax.swing.JLabel jlbl_remediosAdicionados;
    private javax.swing.JLabel jlbl_tipoServico;
    private javax.swing.JScrollPane jscp_jtxta_observacao;
    private javax.swing.JTextArea jtxta_observacao;
    private javax.swing.JTextField jtxtf_donoPet_selecionado_cinco;
    private javax.swing.JTextField jtxtf_donoPet_selecionado_dois;
    private javax.swing.JTextField jtxtf_donoPet_selecionado_quatro;
    private javax.swing.JTextField jtxtf_donoPet_selecionado_tres;
    private javax.swing.JTextField jtxtf_donoPet_selecionado_um;
    private javax.swing.JTextField jtxtf_dtAgendada;
    private javax.swing.JTextField jtxtf_enderecoPet_selecionado_cinco;
    private javax.swing.JTextField jtxtf_enderecoPet_selecionado_dois;
    private javax.swing.JTextField jtxtf_enderecoPet_selecionado_quatro;
    private javax.swing.JTextField jtxtf_enderecoPet_selecionado_tres;
    private javax.swing.JTextField jtxtf_enderecoPet_selecionado_um;
    private javax.swing.JTextField jtxtf_horarioRemedio;
    private javax.swing.JTextField jtxtf_hrAgendada;
    private javax.swing.JTextField jtxtf_intrucaoAdministracao;
    private javax.swing.JTextField jtxtf_nomePet_selecionado_cinco;
    private javax.swing.JTextField jtxtf_nomePet_selecionado_dois;
    private javax.swing.JTextField jtxtf_nomePet_selecionado_quatro;
    private javax.swing.JTextField jtxtf_nomePet_selecionado_tres;
    private javax.swing.JTextField jtxtf_nomePet_selecionado_um;
    private javax.swing.JTextField jtxtf_remedio;
    private javax.swing.JLabel lbl_CadastrarPet1;
    // End of variables declaration//GEN-END:variables
}
