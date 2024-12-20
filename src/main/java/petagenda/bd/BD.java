    package petagenda.bd;

import petagenda.dados.CPF;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import petagenda.exception.IllegalArgumentsException;

//import petagenda.servico.*;
import petagenda.dados.*;

/**
 * Representa a API principal do software com o driver do SGBD. Contém os
 * métodos necessários para as operações de CRUD envolvendo as demais classes do
 * PetAgenda.
 *
 * @author Thiago M. Baiense
 */
public class BD {

    static final String SGBD = "mysql";
    static final String ADDRESS = "localhost";
    static final String PORT = "3306";
    static final String SCHEMA = "pet_agenda";
    static final String USER = "root";
    static final String USER_PWD = "";

    static {
        DriverManager.setLoginTimeout(5);
    }

    public static Connection getConnection() {
        try {
            final String connStr = String.format("jdbc:%s://%s:%s/%s", SGBD, ADDRESS, PORT, SCHEMA);
            Connection conn = DriverManager.getConnection(connStr, USER, USER_PWD);
            return conn;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível estabelecer uma conexão com o banco especificado.\nVerifique as configurações definidas e tente novamente.", "Erro de conexão", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    static public class Usuario {

        public static final String TABLE = "usuario";

        public static petagenda.Usuario login(String login, String senha) {
            petagenda.Usuario recebido = null;

            if (login != null && senha != null) {
                Connection conn = BD.getConnection();
                if (conn != null) { // Se banco for acessível
                    // Criação do statement
                    PreparedStatement select = null;
                    try {
                        select = conn.prepareStatement(
                                String.format("SELECT id_usuario, cpf, nome_usuario, senha_usuario, permissao FROM %s WHERE cpf = ? AND senha_usuario = ?", TABLE));
                        select.setString(1, login);
                        select.setString(2, senha);
                        ResultSet rs = select.executeQuery();
                        petagenda.Usuario[] selected = parse(rs);

                        if (selected != null) {
                            recebido = selected[0];
                        }
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro na execução da query de login", JOptionPane.ERROR_MESSAGE);
                    }

                    if (select != null) { // Se preparedStatement não falhou
                        try {
                            select.close();
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de PreparedStatement", JOptionPane.ERROR_MESSAGE);
                        } finally {
                            select = null;
                        }
                    }

                    try {
                        conn.close();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de conexão", JOptionPane.ERROR_MESSAGE);
                    } finally {
                        conn = null;
                    }
                }
            }
            return recebido;
        }

        public static int insert(petagenda.Usuario usuario) {
            int r = 0;

            if (usuario == null) {
                throw new NullPointerException("Serviço não pode ser nulo");
            } else {
                Connection conn = BD.getConnection();
                if (conn == null) { // Se banco for inacessível
                    return r;
                } else {
                    // Criação do statement
                    PreparedStatement insert = null;
                    try {
                        insert = conn.prepareStatement(String.format("INSERT INTO %s(cpf, nome_usuario, senha_usuario, permissao) VALUES (?, ?, ?, ?)", TABLE));

                        // cpf
                        petagenda.dados.CPF cpf = usuario.getCpf();
                        String strCpf;
                        if (cpf != null) {
                            strCpf = cpf.toString();
                        } else {
                            strCpf = null;
                        }

                        insert.setString(1, strCpf); // cpf
                        insert.setString(2, usuario.getNome()); // nome_usuario
                        insert.setString(3, usuario.getSenha()); // senha_usuario
                        insert.setInt(4, usuario.getPermissao()); // permissao

                        r = insert.executeUpdate();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de execução do insert", JOptionPane.ERROR_MESSAGE);
                        r = -1;
                    }

                    if (insert != null) { // Se preparedStatement não falhou
                        try {
                            insert.close();
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de PreparedStatement", JOptionPane.ERROR_MESSAGE);
                        } finally {
                            insert = null;
                        }
                    }

                    try {
                        conn.close();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de conexão", JOptionPane.ERROR_MESSAGE);
                    } finally {
                        conn = null;
                    }
                }
            }
            return r;
        }

        public static int delete(petagenda.Usuario usuario) {
            int r = 0;

            if (usuario == null) {
                throw new NullPointerException("Usuario não pode ser nulo");
            } else {
                Connection conn = BD.getConnection();
                if (conn == null) { // Se banco for inacessível
                    return r;
                } else {

                    // Criação do statement
                    PreparedStatement insert = null;
                    try {
                        insert = conn.prepareStatement(String.format("DELETE FROM %s WHERE id_usuario = ?", TABLE));

                        insert.setInt(1, usuario.getId()); // id_usuario

                        r = insert.executeUpdate();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de execução do delete", JOptionPane.ERROR_MESSAGE);
                        r = -1;
                    }

                    if (insert != null) { // Se preparedStatement não falhou
                        try {
                            insert.close();
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de PreparedStatement", JOptionPane.ERROR_MESSAGE);
                        } finally {
                            insert = null;
                        }
                    }

                    try {
                        conn.close();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de conexão", JOptionPane.ERROR_MESSAGE);
                    } finally {
                        conn = null;
                    }
                }
            }
            return r;
        }

        public static int update(petagenda.Usuario usuario) {
            int r = 0;

            if (usuario == null) {
                throw new NullPointerException("Local de atuação não pode ser nulo");
            } else {
                Connection conn = BD.getConnection();
                if (conn == null) { // Se banco for inacessível
                    return r;
                } else {
                    // Criação do statement
                    PreparedStatement insert = null;
                    try {
                        insert = conn.prepareStatement(String.format("UPDATE %s SET cpf = ?, nome_usuario = ?, senha_usuario = ? WHERE id_usuario = ?", TABLE));

                        petagenda.dados.CPF cpf = usuario.getCpf();
                        String strCpf;
//                        if (cpf == null) {
//                            strCpf = null;
//                        } else {
                        strCpf = cpf.toString();
//                        }
                        insert.setString(1, strCpf);
                        insert.setString(2, usuario.getNome());
                        insert.setString(3, usuario.getSenha());

                        // Controle de atualização do Local de atuação
                        // petagenda.dados.LocalAtuacao localAtuacaoUsuario = usuario.getLocalAtuacao();
                        // int id_local_atuacao_usuario = localAtuacaoUsuario.getId();
                        //petagenda.dados.LocalAtuacao localAtuacaoCadastrado = BD.Usuario.selectById(usuario.getId()).getLocalAtuacao();
                        //int id_local_atuacao_cadastrado = localAtuacaoCadastrado.getId();
                        //boolean apagarLocalAtuacaoCadastrado = false;
                        //int locaisEncontrados = BD.Usuario.selectByLocalAtuacao(localAtuacaoCadastrado).length;
                        //if (locaisEncontrados == 1) { // Somente este usuário usa o local de atuação cadastrados
                        //if (localAtuacaoUsuario.isNew()) {
                        //localAtuacaoUsuario.setId(id_local_atuacao_cadastrado);
                        //BD.LocalAtuacao.update(localAtuacaoUsuario);
                        //insert.setInt(7, id_local_atuacao_cadastrado);
                        //} else if (id_local_atuacao_usuario != id_local_atuacao_cadastrado) {
                        //insert.setInt(7, id_local_atuacao_usuario);
                        //apagarLocalAtuacaoCadastrado = true;
                        //} else { // É o mesmo id de local de atuação
                        //if (!localAtuacaoUsuario.deepEquals(localAtuacaoCadastrado)) {
                        //BD.LocalAtuacao.update(localAtuacaoUsuario);
                        //}
                        //insert.setInt(7, id_local_atuacao_usuario);
                        //}
                        //} else {
                        //if (localAtuacaoUsuario.isNew()) {
                        //BD.LocalAtuacao.insert(localAtuacaoUsuario);
                        //insert.setInt(7, BD.LocalAtuacao.selectLast().getId());
                        //} else {
                        //insert.setInt(7, id_local_atuacao_usuario);
                        //}
                        //}
                        //r = insert.executeUpdate();
                        //if (apagarLocalAtuacaoCadastrado) {
                        //BD.LocalAtuacao.delete(localAtuacaoCadastrado);
                        //}
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de execução do update", JOptionPane.ERROR_MESSAGE);
                        r = -1;
                    }

                    //if (insert != null) { // Se preparedStatement não falhou
                    //try {
                    //insert.close();
                    //} catch (SQLException e) {
                    //JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de PreparedStatement", JOptionPane.ERROR_MESSAGE);
                    //} finally {
                    //insert = null;
                    //}
                    //}
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de conexão", JOptionPane.ERROR_MESSAGE);
                    } finally {
                        conn = null;
                    }
                }
            }
            return r;
        }

        public static petagenda.Usuario selectById(int id) {
            petagenda.Usuario usuario = null;

            if (id != petagenda.Usuario.NULL_ID) {
                Connection conn = BD.getConnection();
                if (conn != null) { // Se banco for acessível
                    // Criação do statement
                    PreparedStatement select = null;
                    try {
                        select = conn.prepareStatement(
                                String.format("SELECT id_usuario, cpf, nome_usuario, senha_usuario, permissao FROM %s WHERE id_usuario = ?", TABLE));
                        select.setInt(1, id);

                        ResultSet rs = select.executeQuery();
                        petagenda.Usuario[] selected = parse(rs);

                        if (selected != null) {
                            usuario = selected[0];
                        }
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro na execução da query", JOptionPane.ERROR_MESSAGE);
                    }

                    if (select != null) { // Se preparedStatement não falhou
                        try {
                            select.close();
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de PreparedStatement", JOptionPane.ERROR_MESSAGE);
                        } finally {
                            select = null;
                        }
                    }

                    try {
                        conn.close();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de conexão", JOptionPane.ERROR_MESSAGE);
                    } finally {
                        conn = null;
                    }
                }
            }
            return usuario;
        }

        public static petagenda.Usuario[] selectAll() {
            petagenda.Usuario[] usuarios = null;

            Connection conn = BD.getConnection();
            if (conn != null) { // Se banco for acessível
                // Criação do statement
                PreparedStatement select = null;
                try {
                    select = conn.prepareStatement(
                            String.format("SELECT id_usuario, cpf, nome_usuario, senha_usuario, permissao FROM %s", TABLE));

                    ResultSet rs = select.executeQuery();
                    usuarios = parse(rs);
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Erro na execução da query", JOptionPane.ERROR_MESSAGE);
                }

                if (select != null) { // Se preparedStatement não falhou
                    try {
                        select.close();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de PreparedStatement", JOptionPane.ERROR_MESSAGE);
                    } finally {
                        select = null;
                    }
                }

                try {
                    conn.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de conexão", JOptionPane.ERROR_MESSAGE);
                } finally {
                    conn = null;
                }
            }
            return usuarios;
        }

        public static petagenda.Usuario selectLast() {
            petagenda.Usuario usuario = null;

            Connection conn = BD.getConnection();
            if (conn != null) { // Se banco for acessível
                // Criação do statement
                PreparedStatement select = null;
                try {
                    select = conn.prepareStatement(
                            String.format("SELECT id_usuario, cpf, nome_usuario, senha_usuario, permissao FROM %s ORDER BY id_usuario DESC LIMIT 1", TABLE));

                    ResultSet rs = select.executeQuery();
                    petagenda.Usuario[] selected = parse(rs);

                    if (selected != null) {
                        usuario = selected[0];
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Erro na execução da query", JOptionPane.ERROR_MESSAGE);
                }

                if (select != null) { // Se preparedStatement não falhou
                    try {
                        select.close();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de PreparedStatement", JOptionPane.ERROR_MESSAGE);
                    } finally {
                        select = null;
                    }
                }

                try {
                    conn.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de conexão", JOptionPane.ERROR_MESSAGE);
                } finally {
                    conn = null;
                }
            }

            return usuario;
        }

        public static petagenda.Usuario[] selectByLocalAtuacao(petagenda.dados.LocalAtuacao localAtuacao) {
            petagenda.Usuario[] usuarios = null;

            if (localAtuacao == null) {
                throw new NullPointerException("Local de Atuação não pode ser nulo");
            } else if (!localAtuacao.isNew()) {
                Connection conn = BD.getConnection();
                if (conn != null) { // Se banco for acessível
                    // Criação do statement
                    PreparedStatement select = null;
                    try {
                        select = conn.prepareStatement(
                                String.format("SELECT id_usuario, cpf, nome_usuario, senha_usuario, permissao FROM %s WHERE id_local_atuacao = ?", TABLE));
                        select.setInt(1, localAtuacao.getId());

                        ResultSet rs = select.executeQuery();
                        usuarios = parse(rs);
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro na execução da query", JOptionPane.ERROR_MESSAGE);
                    }

                    if (select != null) { // Se preparedStatement não falhou
                        try {
                            select.close();
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de PreparedStatement", JOptionPane.ERROR_MESSAGE);
                        } finally {
                            select = null;
                        }
                    }

                    try {
                        conn.close();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de conexão", JOptionPane.ERROR_MESSAGE);
                    } finally {
                        conn = null;
                    }
                }
            }
            return usuarios;
        }

        public static petagenda.Usuario[] parse(ResultSet rs) {
            if (rs == null) {
                throw new NullPointerException("ResultSet não pode ser nulo");
            } else {
                ArrayList<petagenda.Usuario> uList = new ArrayList<petagenda.Usuario>();
                petagenda.Usuario[] uArray = null;

                try {
                    while (rs.next()) {
                        petagenda.Usuario u;
                        int id_permissao;
                        int id_usuario;
                        String nome_usuario, senha_usuario;
                        CPF cpf;

                        // Recebimento dos dados do ResultSet
                        id_usuario = rs.getInt("id_usuario"); // id_usuario
                        nome_usuario = rs.getString("nome_usuario"); // nome_usuario

                        // Converte a string do CPF para um objeto CPF
                        cpf = new CPF(rs.getString("cpf")); // cpf

                        senha_usuario = rs.getString("senha_usuario"); // senha_usuario
                        id_permissao = rs.getInt("permissao"); // permissao

                        // Criar o objeto Usuario
                        try {
                            u = new petagenda.Usuario(id_usuario, nome_usuario, cpf, senha_usuario, id_permissao);

                            uList.add(u);
                        } catch (IllegalArgumentsException exs) {
                            StringBuilder strEx = new StringBuilder(String.format("Erro ao receber Usuario (id= %d):\n", id_usuario));
                            for (Throwable cause : exs.getCauses()) {
                                strEx.append(cause.getMessage());
                                strEx.append("\n");
                            }
                            System.out.println(strEx.toString());
                        }
                    }

                    // Se a lista não estiver vazia, converta para array
                    if (!uList.isEmpty()) {
                        uArray = new petagenda.Usuario[uList.size()];
                        uArray = uList.toArray(uArray);
                    }

                } catch (SQLException e) {
                    System.out.printf("Erro ao fazer parse de ResultSet contendo Usuario: %s\n", e.getMessage());
                }

                return uArray;
            }
        }

    }

    public static boolean atualizarSenhaUsuario(String login, String novaSenha) {
        try (Connection conn = getConnection()) {
            String sql = "UPDATE usuario SET senha_usuario = ? WHERE cpf = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, novaSenha);
            stmt.setString(2, login);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    static public class Cliente {

        public static final String TABLE = "cliente";

        public static int insert(petagenda.Cliente cliente) {
            int r = 0;

            if (cliente == null) {
                throw new NullPointerException("Serviço não pode ser nulo");
            }/* else if (cliente.getServico().isNew()) { // Servico solicitado precisa associado precisa estar cadastrado
                throw new IllegalServicoException("Serviço solicitado não pode conter um tipo de serviço ainda não cadastrado");
            }*/ else {
                Connection conn = BD.getConnection();
                if (conn == null) { // Se banco for inacessível
                    return r;
                } else {
                    // Criação do statement
                    PreparedStatement insert = null;
                    try {
                        insert = conn.prepareStatement(String.format("INSERT INTO %s(nome, cpf, telefone, rua, numero, bairro, cidade, cep) VALUES (?, ?, ?, ?, ?, ?, ?, ?)", TABLE));

                        insert.setString(1, cliente.getNome()); // nome_cliente

                        petagenda.dados.CPF cpf = cliente.getCpf();
                        String strCpf;
                        if (cpf == null) {
                            strCpf = null;
                        } else {
                            strCpf = cpf.toString();
                        }

                        insert.setString(2, strCpf); // cpf
                        insert.setString(3, cliente.getTelefone()); // telefone
                        insert.setString(4, cliente.getRua()); // rua
                        insert.setString(5, cliente.getNumero()); // numero
                        insert.setString(6, cliente.getBairro()); // bairro
                        insert.setString(7, cliente.getCidade()); // cidade
                        insert.setString(8, cliente.getCep()); // cep

                        r = insert.executeUpdate();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de execução do insert", JOptionPane.ERROR_MESSAGE);
                        r = -1;
                    }

                    if (insert != null) { // Se preparedStatement não falhou
                        try {
                            insert.close();
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de PreparedStatement", JOptionPane.ERROR_MESSAGE);
                        } finally {
                            insert = null;
                        }
                    }

                    try {
                        conn.close();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de conexão", JOptionPane.ERROR_MESSAGE);
                    } finally {
                        conn = null;
                    }
                }
            }
            return r;
        }

        public static int delete(petagenda.Cliente cliente) {
            int r = 0;

            if (cliente == null) {
                throw new NullPointerException("Cliente não pode ser nulo");
            } else if (!cliente.isNew()) { // Só inicia conexão se Cliente e Endereco for cadastrado
                Connection conn = BD.getConnection();
                if (conn == null) { // Se banco for inacessível
                    return r;
                } else {

                    // Criação do statement
                    PreparedStatement insert = null;
                    try {
                        insert = conn.prepareStatement(String.format("DELETE FROM %s WHERE id_cliente = ?", TABLE));
                        insert.setInt(1, cliente.getId());

                        r = insert.executeUpdate();

                        // Deleção do endereço associado;
                        // BD.Endereco.delete(cliente.getEndereco());
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de execução do delete", JOptionPane.ERROR_MESSAGE);
                        r = -1;
                    }

                    if (insert != null) { // Se preparedStatement não falhou
                        try {
                            insert.close();
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de PreparedStatement", JOptionPane.ERROR_MESSAGE);
                        } finally {
                            insert = null;
                        }
                    }

                    try {
                        conn.close();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de conexão", JOptionPane.ERROR_MESSAGE);
                    } finally {
                        conn = null;
                    }
                }
            }
            return r;
        }

        public static int update(petagenda.Cliente cliente) {
            int r = 0;

            if (cliente == null) {
                throw new NullPointerException("Local de atuação não pode ser nulo");
            } else if (!cliente.isNew() /*&& !cliente.getServico().isNew()*/) { // Só inicia conexão se Cliente informado possuir id válido e o Servico for cadastrado e endereço já estiver cadastrado
                Connection conn = BD.getConnection();
                if (conn == null) { // Se banco for inacessível
                    return r;
                } else {
                    // Criação do statement
                    PreparedStatement insert = null;
                    try {
                        insert = conn.prepareStatement(String.format("UPDATE %s SET nome = ?, cpf = ?, telefone = ?, rua = ?, numero = ?, bairro = ?, cidade = ?, cep = ? WHERE id_cliente = ?", TABLE));

                        //petagenda.dados.Endereco enderecoCliente = cliente.getEndereco();
                        // Atualização do endereco do cliente se mudou
                        petagenda.Cliente clienteCadastrado = BD.Cliente.selectById(cliente.getId());
                        //petagenda.dados.Endereco enderecoCadastrado = clienteCadastrado.getEndereco();
                        //int id_endereco_cadastrado = enderecoCadastrado.getId();

                        // Verificação se Endereco do objeto difere do recebido do banco
                        /*
                        if (!enderecoCliente.deepEquals(enderecoCadastrado)) { // Se Endereco do objeto difere do cadastrado no cliente do banco
                            enderecoCliente.setId(id_endereco_cadastrado);
                            BD.Endereco.update(enderecoCliente);
                        }
                         */
                        insert.setString(1, cliente.getNome()); // nome
                        petagenda.dados.CPF cpf = cliente.getCpf();
                        String strCpf;
                        if (cpf == null) {
                            strCpf = null;
                        } else {
                            strCpf = cpf.toString();
                        }
                        insert.setString(2, strCpf); // cpf
                        insert.setString(3, cliente.getTelefone()); // telefone
                        insert.setString(4, cliente.getRua()); // rua
                        insert.setString(5, cliente.getNumero()); // numero
                        insert.setString(6, cliente.getBairro()); // bairro
                        insert.setString(7, cliente.getCidade()); // cidade
                        insert.setString(8, cliente.getCep()); // cep
                        insert.setInt(11, cliente.getId());

                        r = insert.executeUpdate();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de execução do update", JOptionPane.ERROR_MESSAGE);
                        r = -1;
                    }

                    if (insert != null) { // Se preparedStatement não falhou
                        try {
                            insert.close();
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de PreparedStatement", JOptionPane.ERROR_MESSAGE);
                        } finally {
                            insert = null;
                        }
                    }

                    try {
                        conn.close();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de conexão", JOptionPane.ERROR_MESSAGE);
                    } finally {
                        conn = null;
                    }
                }
            }
            return r;
        }

        public static petagenda.Cliente selectById(int id_cliente) {
            petagenda.Cliente cliente = null;

            if (id_cliente != petagenda.Cliente.NULL_ID) {
                Connection conn = BD.getConnection();
                if (conn != null) { // Se banco for acessível
                    // Criação do statement
                    PreparedStatement select = null;
                    try {
                        select = conn.prepareStatement(String.format("SELECT id_cliente, nome, cpf, telefone, rua, numero, bairro, cidade, cep FROM %s WHERE id_cliente = ?", TABLE));
                        select.setInt(1, id_cliente);

                        ResultSet rs = select.executeQuery();
                        petagenda.Cliente[] selected = parse(rs);

                        if (selected != null) {
                            cliente = selected[0];
                        }
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro na execução da query", JOptionPane.ERROR_MESSAGE);
                    }

                    if (select != null) { // Se preparedStatement não falhou
                        try {
                            select.close();
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de PreparedStatement", JOptionPane.ERROR_MESSAGE);
                        } finally {
                            select = null;
                        }
                    }

                    try {
                        conn.close();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de conexão", JOptionPane.ERROR_MESSAGE);
                    } finally {
                        conn = null;
                    }
                }
            }
            return cliente;
        }

        public static petagenda.Cliente selectByCpf(CPF cpf) {
            petagenda.Cliente cliente = null;

            if (cpf != null) {
                Connection conn = BD.getConnection();
                if (conn != null) { // Se banco for acessível
                    // Criação do statement
                    PreparedStatement select = null;
                    try {
                        select = conn.prepareStatement(String.format("SELECT id_cliente, nome, cpf, telefone, rua, numero, bairro, cidade, cep FROM %s WHERE cpf = ?", TABLE));
                        select.setString(1, cpf.toString());

                        ResultSet rs = select.executeQuery();
                        petagenda.Cliente[] selected = parse(rs);

                        if (selected != null) {
                            cliente = selected[0];
                        }
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro na execução da query", JOptionPane.ERROR_MESSAGE);
                    }

                    if (select != null) { // Se preparedStatement não falhou
                        try {
                            select.close();
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de PreparedStatement", JOptionPane.ERROR_MESSAGE);
                        } finally {
                            select = null;
                        }
                    }

                    try {
                        conn.close();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de conexão", JOptionPane.ERROR_MESSAGE);
                    } finally {
                        conn = null;
                    }
                }
            }
            return cliente;
        }

        public static petagenda.Cliente[] selectAll() {
            petagenda.Cliente[] clientes = null;

            Connection conn = BD.getConnection();
            if (conn != null) { // Se banco for acessível
                // Criação do statement
                PreparedStatement select = null;
                try {
                    select = conn.prepareStatement(String.format("SELECT id_cliente, nome, cpf, telefone, rua, numero, bairro, cidade, cep FROM %s", TABLE));

                    ResultSet rs = select.executeQuery();
                    clientes = parse(rs);
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Erro na execução da query", JOptionPane.ERROR_MESSAGE);
                }

                if (select != null) { // Se preparedStatement não falhou
                    try {
                        select.close();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de PreparedStatement", JOptionPane.ERROR_MESSAGE);
                    } finally {
                        select = null;
                    }
                }

                try {
                    conn.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de conexão", JOptionPane.ERROR_MESSAGE);
                } finally {
                    conn = null;
                }
            }
            return clientes;
        }

        public static petagenda.Cliente selectLast() {
            petagenda.Cliente cliente = null;

            Connection conn = BD.getConnection();
            if (conn != null) { // Se banco for acessível
                // Criação do statement
                PreparedStatement select = null;
                try {
                    select = conn.prepareStatement(String.format("SELECT id_cliente, nome, cpf, telefone, rua, numero, bairro, cidade, cep FROM %s ORDER BY id_cliente DESC LIMIT 1", TABLE));

                    ResultSet rs = select.executeQuery();
                    petagenda.Cliente[] selected = parse(rs);

                    if (selected != null) {
                        cliente = selected[0];
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Erro na execução da query", JOptionPane.ERROR_MESSAGE);
                }

                if (select != null) { // Se preparedStatement não falhou
                    try {
                        select.close();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de PreparedStatement", JOptionPane.ERROR_MESSAGE);
                    } finally {
                        select = null;
                    }
                }

                try {
                    conn.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de conexão", JOptionPane.ERROR_MESSAGE);
                } finally {
                    conn = null;
                }
            }

            return cliente;
        }

        public static petagenda.Cliente[] parse(ResultSet rs) {
            if (rs == null) {
                throw new NullPointerException("ResultSet não pode ser nulo");
            } else {
                ArrayList<petagenda.Cliente> cList = new ArrayList<petagenda.Cliente>();
                petagenda.Cliente[] cArray = null;

                try {
                    while (rs.next()) {
                        petagenda.Cliente c;
                        int id_cliente;
                        String nome, telefone, rua, numero, bairro, cidade, cep;
                        petagenda.dados.CPF cpf;

                        // Recebimento dos dados do ResultSet
                        id_cliente = rs.getInt("id_cliente");
                        nome = rs.getString("nome");

                        String strCpf = rs.getString("cpf");
                        if (strCpf == null) {
                            cpf = null;
                        } else {
                            cpf = new CPF(strCpf);
                        }

                        telefone = rs.getString("telefone");
                        rua = rs.getString("rua");
                        numero = rs.getString("numero");
                        bairro = rs.getString("bairro");
                        cidade = rs.getString("cidade");
                        cep = rs.getString("cep");

                        // Verificação dos dados e criação do objeto
                        try {
                            c = new petagenda.Cliente(id_cliente, nome, strCpf, telefone, rua, numero, bairro, cidade, cep);

                            if (cpf != null) {
                                c.setCpf(cpf);
                            }

                            cList.add(c);
                        } catch (IllegalArgumentsException exs) {
                            StringBuilder strEx = new StringBuilder(String.format("Erro ao receber Cliente (id= %d):\n", id_cliente));
                            for (Throwable cause : exs.getCauses()) {
                                strEx.append(cause.getMessage());
                                strEx.append("\n");
                            }
                            System.out.println(strEx.toString());
                        }
                    }
                    if (!cList.isEmpty()) {
                        cArray = new petagenda.Cliente[cList.size()];
                        cArray = cList.toArray(cArray);
                    }
                } catch (SQLException e) {
                    System.out.printf("Erro ao fazer parse de ResultSet contendo Cliente: %s", e.getMessage());
                }

                return cArray;
            }
        }
    }

    /*
    static public class Permissao {

        static final String TABLE = "permissao";

        public static petagenda.dados.Permissao[] selectAll() {
            try {
                Connection conn = BD.getConnection();
                if (conn == null) {
                    return null;
                }
                String selectStr = String.format("SELECT id, nome FROM %s", TABLE);
                PreparedStatement select = conn.prepareStatement(selectStr);

                ResultSet rs = select.executeQuery();
                petagenda.dados.Permissao[] permissoes = BD.Permissao.parse(rs);

                return permissoes;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Não foi possível realizar o SELECT.\nVerifique as informações relevantes e tente novamente.", "Erro de SELECT", JOptionPane.ERROR_MESSAGE);
                return null;
            }
        }
//        

        public static petagenda.dados.Permissao selectById(int id) {
            petagenda.dados.Permissao permissao = null;

            if (id != petagenda.dados.Permissao.NULL_ID) {
                Connection conn = BD.getConnection();
                if (conn != null) { // Se banco for acessível
                    // Criação do statement
                    PreparedStatement select = null;
                    try {
                        select = conn.prepareStatement(
                                String.format("SELECT id, nome FROM %s WHERE id = ?", TABLE));
                        select.setInt(1, id);

                        ResultSet rs = select.executeQuery();
                        petagenda.dados.Permissao[] selected = parse(rs);

                        if (selected != null) {
                            permissao = selected[0];
                        }
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro na execução da query", JOptionPane.ERROR_MESSAGE);
                    }

                    if (select != null) { // Se preparedStatement não falhou
                        try {
                            select.close();
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de PreparedStatement", JOptionPane.ERROR_MESSAGE);
                        } finally {
                            select = null;
                        }
                    }

                    try {
                        conn.close();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de conexão", JOptionPane.ERROR_MESSAGE);
                    } finally {
                        conn = null;
                    }
                }
            }

            return permissao;
        }

        public static petagenda.dados.Permissao[] parse(ResultSet rs) throws SQLException {
            if (rs == null) {
                throw new NullPointerException("ResultSet não pode ser null");
            }

            ArrayList<petagenda.dados.Permissao> pList = new ArrayList<petagenda.dados.Permissao>();
            try {
                while (rs.next()) {
                    petagenda.dados.Permissao permissao;
                    String nome;
                    int id;

                    id = rs.getInt("id");
                    nome = rs.getString("nome");

                    permissao = new petagenda.dados.Permissao(id, nome);
                    pList.add(permissao);
                }
                if (!pList.isEmpty()) {
                    petagenda.dados.Permissao[] permissoes = new petagenda.dados.Permissao[pList.size()];
                    pList.toArray(permissoes);
                    return permissoes;
                }
            } catch (SQLException e) {
                System.out.printf("Erro ao fazer parse de ResultSet contendo Permissao: %s", e.getMessage());
            }

            return null;
        }
    }
     */
    static public class Servico {

        public static final String TABLE = "servico";

        public static int insert(petagenda.servico.Servico servico) {
            int r = 0;

            if (servico == null) {
                throw new NullPointerException("Serviço não pode ser nulo");
            } else {
                Connection conn = BD.getConnection();
                if (conn == null) { // Se banco for inacessível
                    return r;
                } else {
                    // Criação do statement
                    PreparedStatement insert = null;
                    try {
                        insert = conn.prepareStatement(String.format("INSERT INTO %s(nome, preco, descricao) VALUES (?, ?, ?)", TABLE));
                        insert.setString(1, servico.getNome()); // nome
                        insert.setDouble(2, servico.getPreco()); // preco
                        insert.setString(3, servico.getDescricao()); // descricao

                        r = insert.executeUpdate();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de execução do insert", JOptionPane.ERROR_MESSAGE);
                        r = -1;
                    }

                    if (insert != null) { // Se preparedStatement não falhou
                        try {
                            insert.close();
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de PreparedStatement", JOptionPane.ERROR_MESSAGE);
                        } finally {
                            insert = null;
                        }
                    }

                    try {
                        conn.close();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de conexão", JOptionPane.ERROR_MESSAGE);
                    } finally {
                        conn = null;
                    }
                }
            }
            return r;
        }

        public static int delete(petagenda.servico.Servico servico) {
            int r = 0;

            if (servico == null) {
                throw new NullPointerException("Local de atuação não pode ser nulo");
            } else if (servico.getId() != petagenda.servico.Servico.NULL_ID) { // Só inicia conexão de Servico informado possuir id_servico válido
                Connection conn = BD.getConnection();
                if (conn == null) { // Se banco for inacessível
                    return r;
                } else {
                    // Criação do statement
                    PreparedStatement insert = null;
                    try {
                        insert = conn.prepareStatement(String.format("DELETE FROM %s WHERE id_servico = ?", TABLE));
                        insert.setInt(1, servico.getId());

                        r = insert.executeUpdate();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de execução do delete", JOptionPane.ERROR_MESSAGE);
                        r = -1;
                    }

                    if (insert != null) { // Se preparedStatement não falhou
                        try {
                            insert.close();
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de PreparedStatement", JOptionPane.ERROR_MESSAGE);
                        } finally {
                            insert = null;
                        }
                    }

                    try {
                        conn.close();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de conexão", JOptionPane.ERROR_MESSAGE);
                    } finally {
                        conn = null;
                    }
                }
            }
            return r;
        }

        public static int update(petagenda.servico.Servico servico) {
            int r = 0;

            if (servico == null) {
                throw new NullPointerException("Local de atuação não pode ser nulo");
            } else if (servico.getId() != petagenda.servico.Servico.NULL_ID) { // Só inicia conexão de Servico informado possuir id válido e o TipoServico for cadastrado
                Connection conn = BD.getConnection();
                if (conn == null) { // Se banco for inacessível
                    return r;
                } else {
                    // Criação do statement
                    PreparedStatement insert = null;
                    try {
                        insert = conn.prepareStatement(String.format("UPDATE %s SET nome = ?, preco = ?, descricao = ? WHERE id_servico = ?", TABLE));
                        insert.setString(1, servico.getNome());
                        insert.setDouble(2, servico.getPreco());
                        insert.setString(3, servico.getDescricao());
                        insert.setInt(4, servico.getId());

                        r = insert.executeUpdate();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de execução do update", JOptionPane.ERROR_MESSAGE);
                        r = -1;
                    }

                    if (insert != null) { // Se preparedStatement não falhou
                        try {
                            insert.close();
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de PreparedStatement", JOptionPane.ERROR_MESSAGE);
                        } finally {
                            insert = null;
                        }
                    }

                    try {
                        conn.close();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de conexão", JOptionPane.ERROR_MESSAGE);
                    } finally {
                        conn = null;
                    }
                }
            }
            return r;
        }

        public static petagenda.servico.Servico selectById(int id_servico) {
            petagenda.servico.Servico servico = null;

            if (id_servico != petagenda.servico.Servico.NULL_ID) {
                Connection conn = BD.getConnection();
                if (conn != null) { // Se banco for acessível
                    // Criação do statement
                    PreparedStatement select = null;
                    try {
                        select = conn.prepareStatement(String.format("SELECT id_servico, nome, preco, descricao FROM %s WHERE id_servico = ?", TABLE));
                        select.setInt(1, id_servico);

                        ResultSet rs = select.executeQuery();
                        petagenda.servico.Servico[] selected = parse(rs);

                        if (selected != null) {
                            servico = selected[0];
                        }
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro na execução da query", JOptionPane.ERROR_MESSAGE);
                    }

                    if (select != null) { // Se preparedStatement não falhou
                        try {
                            select.close();
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de PreparedStatement", JOptionPane.ERROR_MESSAGE);
                        } finally {
                            select = null;
                        }
                    }

                    try {
                        conn.close();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de conexão", JOptionPane.ERROR_MESSAGE);
                    } finally {
                        conn = null;
                    }
                }
            }
            return servico;
        }

        public static petagenda.servico.Servico selectByName(String nome_servico) {
            petagenda.servico.Servico servico = null;

            if (nome_servico != null) {
                Connection conn = BD.getConnection();
                if (conn != null) { // Se banco for acessível
                    // Criação do statement
                    PreparedStatement select = null;
                    try {
                        select = conn.prepareStatement(String.format("SELECT id_servico, nome, preco, descricao FROM %s WHERE nome = ?", TABLE));
                        select.setString(1, nome_servico);

                        ResultSet rs = select.executeQuery();
                        petagenda.servico.Servico[] selected = parse(rs);

                        if (selected != null) {
                            servico = selected[0];
                        }
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro na execução da query", JOptionPane.ERROR_MESSAGE);
                    }

                    if (select != null) { // Se preparedStatement não falhou
                        try {
                            select.close();
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de PreparedStatement", JOptionPane.ERROR_MESSAGE);
                        } finally {
                            select = null;
                        }
                    }

                    try {
                        conn.close();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de conexão", JOptionPane.ERROR_MESSAGE);
                    } finally {
                        conn = null;
                    }
                }
            }
            return servico;
        }

        public static petagenda.servico.Servico[] selectAll() {
            petagenda.servico.Servico[] servicos = null;

            Connection conn = BD.getConnection();
            if (conn != null) { // Se banco for acessível
                // Criação do statement
                PreparedStatement select = null;
                try {
                    select = conn.prepareStatement(String.format("SELECT id_servico, nome, preco, descricao FROM %s", TABLE));

                    ResultSet rs = select.executeQuery();
                    servicos = parse(rs);
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Erro na execução da query", JOptionPane.ERROR_MESSAGE);
                }

                if (select != null) { // Se preparedStatement não falhou
                    try {
                        select.close();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de PreparedStatement", JOptionPane.ERROR_MESSAGE);
                    } finally {
                        select = null;
                    }
                }

                try {
                    conn.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de conexão", JOptionPane.ERROR_MESSAGE);
                } finally {
                    conn = null;
                }
            }
            return servicos;
        }

        public static petagenda.servico.Servico selectLast() {
            petagenda.servico.Servico servico = null;

            Connection conn = BD.getConnection();
            if (conn != null) { // Se banco for acessível
                // Criação do statement
                PreparedStatement select = null;
                try {
                    select = conn.prepareStatement(String.format("SELECT id_servico, nome, preco, descricao FROM %s ORDER BY id_servico DESC LIMIT 1", TABLE));

                    ResultSet rs = select.executeQuery();
                    petagenda.servico.Servico[] selected = parse(rs);

                    if (selected != null) {
                        servico = selected[0];
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Erro na execução da query", JOptionPane.ERROR_MESSAGE);
                }

                if (select != null) { // Se preparedStatement não falhou
                    try {
                        select.close();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de PreparedStatement", JOptionPane.ERROR_MESSAGE);
                    } finally {
                        select = null;
                    }
                }

                try {
                    conn.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de conexão", JOptionPane.ERROR_MESSAGE);
                } finally {
                    conn = null;
                }
            }

            return servico;
        }

        public static petagenda.servico.Servico[] parse(ResultSet rs) {
            if (rs == null) {
                throw new NullPointerException("ResultSet não pode ser nulo");
            } else {
                ArrayList<petagenda.servico.Servico> sList = new ArrayList<petagenda.servico.Servico>();
                petagenda.servico.Servico[] sArray = null;

                try {
                    while (rs.next()) {
                        petagenda.servico.Servico s;
                        int id_servico = -1;
                        String nome, descricao;
                        double preco;

                        // Dados ResultSet.
                        id_servico = rs.getInt("id_servico");
                        nome = rs.getString("nome");
                        preco = rs.getDouble("preco");
                        descricao = rs.getString("descricao");

                        // Verificação dos dados e criação do objeto
                        try {
                            s = new petagenda.servico.Servico(id_servico, nome, preco, descricao);
                            sList.add(s);
                        } catch (IllegalArgumentsException exs) {
                            StringBuilder strEx = new StringBuilder(String.format("Erro ao receber Servico (id_servico = %d):\n", id_servico));
                            for (Throwable c : exs.getCauses()) {
                                strEx.append(c.getMessage());
                                strEx.append("\n");
                            }
                            System.out.println(strEx.toString());
                        }
                    }
                    if (!sList.isEmpty()) {
                        sArray = new petagenda.servico.Servico[sList.size()];
                        sArray = sList.toArray(sArray);
                    }
                } catch (SQLException e) {
                    System.out.printf("Erro ao fazer parse de ResultSet contendo Servico: %s", e.getMessage());
                }

                return sArray;
            }
        }
    }

    static public class ClienteContrataServico {

        public static final String TABLE = "cliente_contrata_servico";

        public static int insert(petagenda.Cliente_servico cliente_servico) {
            int r = 0;

            if (cliente_servico == null) {
                throw new NullPointerException("Serviço não pode ser nulo.");
            } else {
                Connection conn = BD.getConnection();
                if (conn == null) { //Se o banco de dados for inacessível.
                    return r;
                } else {
                    // Criação do statement.
                    PreparedStatement insert = null;
                    try {
                        insert = conn.prepareStatement(String.format("INSERT INTO %s(id_servico, id_cliente) VALUES(?, ?)", TABLE));

                        insert.setInt(1, cliente_servico.getIdServico()); // id_servico
                        insert.setInt(2, cliente_servico.getIdCliente()); // id_cliente

                        r = insert.executeUpdate();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de execução do insert", JOptionPane.ERROR_MESSAGE);
                        r = -1;
                    }

                    if (insert != null) { // Se preparedStatement não falhou.
                        try {
                            insert.close();
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de PreparedStatement", JOptionPane.ERROR_MESSAGE);
                        } finally {
                            insert = null;
                        }
                    }

                    try {
                        conn.close();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de conexão", JOptionPane.ERROR_MESSAGE);
                    } finally {
                        conn = null;
                    }
                }
            }

            return r;
        }

        public static petagenda.Cliente_servico[] selectAll() {
            petagenda.Cliente_servico[] clientes_servicos = null;

            Connection conn = BD.getConnection();
            if (conn != null) { // Se o banco for acessível.
                // Criação do statement.
                PreparedStatement select = null;
                try {
                    select = conn.prepareStatement(String.format("SELECT id_cliente_contrata_servico, id_servico, id_cliente FROM %s", TABLE));

                    ResultSet rs = select.executeQuery();
                    clientes_servicos = parse(rs);
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Erro na execução da query", JOptionPane.ERROR_MESSAGE);
                }

                if (select != null) { // Se preparedStatement não falhou.
                    try {
                        select.close();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de PreparedStatement", JOptionPane.ERROR_MESSAGE);
                    } finally {
                        select = null;
                    }
                }

                try {
                    conn.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de conexão", JOptionPane.ERROR_MESSAGE);
                } finally {
                    conn = null;
                }
            }

            return clientes_servicos;
        }

        public static petagenda.Cliente_servico[] parse(ResultSet rs) {
            if (rs == null) {
                throw new NullPointerException("ResultSet não pode ser nulo.");
            } else {
                ArrayList<petagenda.Cliente_servico> cList = new ArrayList<petagenda.Cliente_servico>();
                petagenda.Cliente_servico[] cArray = null;

                try {
                    while (rs.next()) {
                        petagenda.Cliente_servico c;
                        int id_cliente_contrata_servico, id_servico, id_cliente;

                        // Recebimento dos dados do ResultSet.
                        id_cliente_contrata_servico = rs.getInt("id_cliente_contrata_servico");
                        id_servico = rs.getInt("id_servico");
                        id_cliente = rs.getInt("id_cliente");

                        // Verificação dos dados e criação do objeto.
                        try {
                            c = new petagenda.Cliente_servico(id_cliente_contrata_servico, id_servico, id_cliente);

                            cList.add(c);
                        } catch (IllegalArgumentsException exs) {
                            StringBuilder strEx = new StringBuilder(String.format("Erro ao receber cliente_contrata_servico (id_cliente_contrata_servico = %d):\n", id_cliente_contrata_servico));
                            for (Throwable cause : exs.getCauses()) {
                                strEx.append(cause.getMessage());
                                strEx.append("\n");
                            }
                            System.out.println(strEx.toString());
                        }
                    }

                    if (!cList.isEmpty()) {
                        cArray = new petagenda.Cliente_servico[cList.size()];
                        cArray = cList.toArray(cArray);
                    }
                } catch (SQLException e) {
                    System.out.printf("Erro ao fazer parse de ResultSet contendo Cliente_servico: %s", e.getMessage());
                }

                return cArray;
            }
        }
    }

    static public class Funcionario {

        public static final String TABLE = "funcionario";

        public static int insert(petagenda.Funcionario funcionario) {
            int r = 0;

            if (funcionario == null) {
                throw new NullPointerException("Funcionário não pode ser nulo.");
            } else {
                Connection conn = BD.getConnection();
                if (conn == null) { // Se o banco for inacessível retorna 0.
                    return r;
                } else {
                    // Criação do statement.
                    PreparedStatement insert = null;
                    try {
                        insert = conn.prepareStatement(String.format("INSERT INTO %s(nome, cpf, telefone, rua, cep, numero, bairro, cidade) VALUES (?, ?, ?, ?, ?, ?, ?, ?)", TABLE));

                        insert.setString(1, funcionario.getNome()); // Nome funcionario

                        // CPF
                        petagenda.dados.CPF cpf = funcionario.getCpf();
                        String strCpf;
                        if (cpf == null) {
                            strCpf = null;
                        } else {
                            strCpf = cpf.toString();
                        }
                        insert.setString(2, strCpf); // CPF
                        insert.setString(3, funcionario.getTelefone());
                        insert.setString(4, funcionario.getRua());
                        insert.setString(5, funcionario.getCep());
                        insert.setString(6, funcionario.getNumero());
                        insert.setString(7, funcionario.getBairro());
                        insert.setString(8, funcionario.getCidade());

                        r = insert.executeUpdate();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de execução do insert", JOptionPane.ERROR_MESSAGE);
                        r = -1;
                    }

                    if (insert != null) { // Se preparedStatement não falhou
                        try {
                            insert.close();
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de PreparedStatement", JOptionPane.ERROR_MESSAGE);
                        } finally {
                            insert = null;
                        }
                    }

                    try {
                        conn.close();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de conexão", JOptionPane.ERROR_MESSAGE);
                    } finally {
                        conn = null;
                    }
                }
            }

            return r;
        }

        public static int delete(petagenda.Funcionario funcionario) {
            int r = 0;

            if (funcionario == null) {
                throw new NullPointerException("Funcionario não pode ser nulo.");
            } else if (!funcionario.isNew()) { // Só inicia conexão se o funcionário for cadastrado
                Connection conn = BD.getConnection();
                if (conn == null) { // Se o banco for inacessível retorna 0.
                    return r;
                } else {
                    // Criação do statement
                    PreparedStatement insert = null;
                    try {
                        insert = conn.prepareStatement(String.format("DELETE FROM %s WHERE id_func = ?", TABLE));
                        insert.setInt(1, funcionario.getId());

                        r = insert.executeUpdate();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de execução do delete", JOptionPane.ERROR_MESSAGE);
                        r = -1;
                    }

                    if (insert != null) { // Se preparedStatement não falhou
                        try {
                            insert.close();
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de PreparedStatement", JOptionPane.ERROR_MESSAGE);
                        } finally {
                            insert = null;
                        }
                    }

                    try {
                        conn.close();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de conexão", JOptionPane.ERROR_MESSAGE);
                    } finally {
                        conn = null;
                    }
                }
            }

            return r;
        }

        public static int update(petagenda.Funcionario funcionario) {
            int r = 0;

            if (funcionario == null) {
                throw new NullPointerException("Local de atualização não pode ser nulo.");
            } else if (!funcionario.isNew()) { // Só inicia a conexão se funcionário for cadastrado.
                Connection conn = BD.getConnection();

                if (conn == null) { // Se o banco for inacessível.
                    return r;
                } else {
                    // Criação do statement.
                    PreparedStatement insert = null;
                    try {
                        insert = conn.prepareStatement(String.format("UPDATE %s SET nome = ?, cpf = ?, telefone = ?, rua = ?, cep = ?, numero = ?, bairro = ?, cidade = ? WHERE id_func = ?", TABLE));

                        insert.setString(1, funcionario.getNome()); // Nome

                        // CPF
                        petagenda.dados.CPF cpf = funcionario.getCpf();
                        String strCpf;
                        if (cpf == null) {
                            strCpf = null;
                        } else {
                            strCpf = cpf.toString();
                        }
                        insert.setString(2, strCpf); // CPF
                        insert.setString(3, funcionario.getTelefone()); // Telefone
                        insert.setString(4, funcionario.getRua()); // Rua
                        insert.setString(5, funcionario.getCep()); // Cep
                        insert.setString(6, funcionario.getNumero()); // Numero
                        insert.setString(7, funcionario.getBairro()); // Bairro
                        insert.setString(8, funcionario.getCidade()); // Cidade
                        insert.setInt(9, funcionario.getId()); // id_func

                        r = insert.executeUpdate();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de execução do update", JOptionPane.ERROR_MESSAGE);
                        r = -1;
                    }

                    if (insert != null) { // Se preparedStatement não falhou.
                        try {
                            insert.close();
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de PreparedStatement", JOptionPane.ERROR_MESSAGE);
                        } finally {
                            insert = null;
                        }
                    }

                    try {
                        conn.close();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de conexão", JOptionPane.ERROR_MESSAGE);
                    } finally {
                        conn = null;
                    }
                }
            }

            return r;
        }

        public static petagenda.Funcionario[] selectAll() {
            petagenda.Funcionario[] funcionarios = null;

            Connection conn = BD.getConnection();
            if (conn != null) { // Se o banco for acessível.
                PreparedStatement select = null;
                try {
                    select = conn.prepareStatement(String.format("SELECT id_func, nome, cpf, telefone, rua, cep, numero, bairro, cidade FROM %s", TABLE));

                    ResultSet rs = select.executeQuery();
                    funcionarios = parse(rs);
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Erro na execução da query", JOptionPane.ERROR_MESSAGE);
                }

                if (select != null) { // Se preparedStatement não falhou
                    try {
                        select.close();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de PreparedStatement", JOptionPane.ERROR_MESSAGE);
                    } finally {
                        select = null;
                    }
                }

                try {
                    conn.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de conexão", JOptionPane.ERROR_MESSAGE);
                } finally {
                    conn = null;
                }
            }

            return funcionarios;
        }
        
        public static petagenda.Funcionario selectById(int id_func) {
            petagenda.Funcionario funcionario = null;
            
            if (id_func != petagenda.Funcionario.NULL_ID) {
                Connection conn = BD.getConnection();
                if (conn != null) { // Se  banco for acessível.
                    // Criação do statement
                    PreparedStatement select = null;
                    try {
                        select = conn.prepareStatement(String.format("SELECT id_func, nome, cpf, telefone, rua, cep, numero, bairro, cidade FROM %s WHERE id_func = ?", TABLE));
                        select.setInt(1, id_func);
                        
                        ResultSet rs = select.executeQuery();
                        petagenda.Funcionario[] selected = parse(rs);
                        
                        if (selected != null) {
                            funcionario = selected[0];
                        }
                    }
                    catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro na execução da query", JOptionPane.ERROR_MESSAGE);
                    }
                    
                    if (select != null) { // Se preparedStatement não falhou.
                        try {
                            select.close();
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de PreparedStatement", JOptionPane.ERROR_MESSAGE);
                        } finally {
                            select = null;
                        }
                    }
                    
                    try {
                        conn.close();
                    }
                    catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de conexão", JOptionPane.ERROR_MESSAGE);
                    }
                    finally {
                        conn = null;
                    }
                }
            }
            
            return funcionario;
        }

        public static petagenda.Funcionario[] parse(ResultSet rs) {
            if (rs == null) {
                throw new NullPointerException("ResultSet não pode ser nulo.");
            } else {
                ArrayList<petagenda.Funcionario> fList = new ArrayList<petagenda.Funcionario>();
                petagenda.Funcionario[] fArray = null;

                try {
                    while (rs.next()) {
                        petagenda.Funcionario f;
                        int id_func;
                        String nome, telefone, rua, cep, numero, bairro, cidade;
                        petagenda.dados.CPF cpf;

                        // Recebimento dos dados do ResultSet
                        id_func = rs.getInt("id_func"); // id_func
                        nome = rs.getString("nome"); // nome

                        String strCpf = rs.getString("cpf");
                        if (strCpf == null) {
                            cpf = null;
                        } else {
                            cpf = new CPF(strCpf); // cpf
                        }

                        telefone = rs.getString("telefone"); // telefone
                        rua = rs.getString("rua");
                        cep = rs.getString("cep");
                        numero = rs.getString("numero");
                        bairro = rs.getString("bairro");
                        cidade = rs.getString("cidade");

                        // Verificação dos dados e criação do objeto.
                        try {
                            f = new petagenda.Funcionario(id_func, nome, strCpf, telefone, rua, cep, numero, bairro, cidade);

                            if (cpf != null) {
                                f.setCpf(cpf);
                            }

                            fList.add(f); // Adiciona as informações a lista.
                        } catch (IllegalArgumentsException exs) {
                            StringBuilder strEx = new StringBuilder(String.format("ERRO ao receber Funcionario (id_func = %d)", id_func));

                            for (Throwable cause : exs.getCauses()) {
                                strEx.append(cause.getMessage());
                                strEx.append("\n");
                            }
                            System.out.println(strEx.toString());
                        }
                    }

                    if (!fList.isEmpty()) {
                        fArray = new petagenda.Funcionario[fList.size()];
                        fArray = fList.toArray(fArray);
                    }
                } catch (SQLException e) {
                    System.out.printf("Erro ao fazer parse de ResultSet contendo Funcionario: %s", e.getMessage());
                }

                return fArray;
            }
        }
    }

    static public class Pet {

        public static final String TABLE = "pet";

        public static int insert(petagenda.Pet pet) {
            int r = 0;

            if (pet == null) {
                throw new NullPointerException("Pet não pode ser nulo.");
            } else {
                Connection conn = BD.getConnection();
                if (conn == null) { // Se o banco for inacessível retorna 0.
                    return r;
                } else {
                    // Criação do statement.
                    PreparedStatement insert = null;
                    try {
                        insert = conn.prepareStatement(String.format("INSERT INTO %s(nome, raca, sexo, porte, comportamento, e_castrado, caminho_cartao_vacinacao, estado_saude, cor, id_cliente) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", TABLE));

                        insert.setString(1, pet.getNome()); // nome
                        insert.setString(2, pet.getRaca()); // raca
                        insert.setString(3, pet.getSexo().toString()); // sexo
                        insert.setString(4, pet.getPorte().toString()); // porte
                        insert.setString(5, pet.getComportamento()); // comportamento
                        insert.setBoolean(6, pet.getECastrado()); // e_castrado
                        insert.setString(7, pet.getCaminhoCartaoVacinacao()); // caminho_cartao_vacinacao
                        insert.setString(8, pet.getEstadoSaude()); // estado_saude
                        insert.setString(9, pet.getCor()); // cor
                        insert.setInt(10, pet.getDono()); // id_cliente

                        r = insert.executeUpdate();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de execução do insert", JOptionPane.ERROR_MESSAGE);
                        r = -1;
                    }

                    if (insert != null) { // Se preparedStatement não falhou
                        try {
                            insert.close();
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de PreparedStatement", JOptionPane.ERROR_MESSAGE);
                        } finally {
                            insert = null;
                        }
                    }

                    try {
                        conn.close();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de conexão", JOptionPane.ERROR_MESSAGE);
                    } finally {
                        conn = null;
                    }
                }
            }

            return r;
        }
        
        public static int update(petagenda.Pet pet) {
            int r = 0;
            
            if (pet == null) {
                throw new NullPointerException("Pet não pode ser nulo.");
            }
            else if (!pet.isNew()) { // Só inicia conexão se Pet informado possuir id válido.
                Connection conn = BD.getConnection();
                if (conn == null) { // Se banco for inacessível.
                    return r;
                }
                else {
                    // Criação do statement.
                    PreparedStatement insert = null;
                    try {
                        insert = conn.prepareStatement(String.format("UPDATE %s SET nome = ?, raca = ?, sexo = ?, porte = ?, comportamento = ?, e_castrado = ?, caminho_cartao_vacinacao = ?, estado_saude = ?, cor = ?, id_cliente = ? WHERE id_pet = ?", TABLE));
                    
                        insert.setString(1, pet.getNome()); // nome
                        insert.setString(2, pet.getRaca()); // raca
                        insert.setString(3, pet.getSexo().toString()); // sexo
                        insert.setString(4, pet.getPorte().toString()); // porte        
                        insert.setString(5, pet.getComportamento()); // comportamento   
                        insert.setBoolean(6, pet.getECastrado()); // e_castrado
                        insert.setString(7, pet.getCaminhoCartaoVacinacao()); // caminho_cartao_vacinacao
                        insert.setString(8, pet.getEstadoSaude()); // estado_saude
                        insert.setString(9, pet.getCor()); // cor
                        insert.setInt(10, pet.getDono()); // id_cliente        
                        
                        r = insert.executeUpdate();
                    }
                    catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de execução do update", JOptionPane.ERROR_MESSAGE);
                        r = -1;
                    }
                    
                    if (insert != null) { // Se preparedStatement não falhou
                        try {
                            insert.close();
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de PreparedStatement", JOptionPane.ERROR_MESSAGE);
                        } finally {
                            insert = null;
                        }
                    }
                    
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de conexão", JOptionPane.ERROR_MESSAGE);
                    } finally {
                        conn = null;
                    }
                }
            }
            
            return r;
        }
        
        public static petagenda.Pet[] selectAll() {
            petagenda.Pet[] pets = null;
            
            Connection conn = BD.getConnection();
            
            if (conn != null) { // Se o banco for acessível.
                // Criação do statement.
                PreparedStatement select = null;
                try {
                    select = conn.prepareStatement(String.format("SELECT id_pet, nome, raca, sexo, porte, comportamento, e_castrado, caminho_cartao_vacinacao, estado_saude, cor, id_cliente FROM %s ORDER BY id_cliente", TABLE));
                    
                    ResultSet rs = select.executeQuery();
                    pets = parse(rs);
                }
                catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Erro na execução da query", JOptionPane.ERROR_MESSAGE);
                }
                
                if (select != null) { // Se preparedStatement não falhou.
                    try {
                        select.close();
                    }
                    catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de PreparedStatement", JOptionPane.ERROR_MESSAGE);
                    }
                    finally {
                        select = null;
                    }
                }
                
                try {
                    conn.close();
                }
                catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de conexão", JOptionPane.ERROR_MESSAGE);
                }
                finally {
                    conn = null;
                }
            }
            
            return pets;
        }
        
        public static petagenda.Pet selectById(int id_pet) {
            petagenda.Pet pet = null;
            
            if (id_pet != petagenda.Pet.NULL_ID) {
                Connection conn = BD.getConnection();
                if (conn != null) { // Se banco for acessível.
                    // Criação do statement.
                    PreparedStatement select = null;
                    try {
                        select = conn.prepareStatement(String.format("SELECT id_pet, nome, raca, sexo, porte, comportamento, e_castrado, caminho_cartao_vacinacao, estado_saude, cor, id_cliente FROM %s WHERE id_pet = ?", TABLE));
                        select.setInt(1, id_pet);
                        
                        ResultSet rs = select.executeQuery();
                        petagenda.Pet[] selected = parse(rs);
                        
                        if (selected != null) {
                            pet = selected[0];
                        }
                    }
                    catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro na execução da query", JOptionPane.ERROR_MESSAGE);
                    }
                    
                    if (select != null) { // Se preparedStatement não falhou
                        try {
                            select.close();
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de PreparedStatement", JOptionPane.ERROR_MESSAGE);
                        } finally {
                            select = null;
                        }
                    }
                    
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de conexão", JOptionPane.ERROR_MESSAGE);
                    } finally {
                        conn = null;
                    }
                }
            }
            
            return pet;
        }
        
        public static petagenda.Pet[] parse(ResultSet rs) {
            if (rs == null) {
                throw new NullPointerException("ResultSet não pode ser nulo");
            }
            else {
                ArrayList<petagenda.Pet> pList = new ArrayList<petagenda.Pet>();
                petagenda.Pet[] pArray = null;
                
                try {
                    while (rs.next()) {
                        petagenda.Pet p;
                        int id_pet, id_cliente;
                        String nome, raca, comportamento, caminho_cartao_vacinacao, estado_saude, cor;
                        Sexo sexo;
                        Porte porte;
                        Boolean eCastrado;
                        
                        // Recebimento dos dados do ResultSet
                        id_pet = rs.getInt("id_pet");
                        nome = rs.getString("nome");
                        raca = rs.getString("raca");
                        
                        String strSexo = rs.getString("sexo");
                        if (strSexo == null) {
                            sexo = null;
                        }
                        else {
                            sexo = Sexo.valueOf(strSexo);
                        }
                        
                        String strPorte = rs.getString("porte");
                        if (strPorte == null) {
                            porte = null;
                        }
                        else {
                            porte = Porte.valueOf(strPorte.toUpperCase());
                        }
                        
                        comportamento = rs.getString("comportamento");
                        eCastrado = rs.getBoolean("e_castrado");
                        caminho_cartao_vacinacao = rs.getString("caminho_cartao_vacinacao");
                        estado_saude = rs.getString("estado_saude");
                        cor = rs.getString("cor");
                        id_cliente = rs.getInt("id_cliente");
                        
                        // Verificação dos dados e criação do objeto
                        try {
                            p = new petagenda.Pet(id_pet, nome, raca, sexo, porte, comportamento, eCastrado, caminho_cartao_vacinacao, estado_saude, cor, id_cliente);
                            
                            if (sexo != null) {
                                p.setSexo(sexo);
                            }
                            
                            if (porte != null) {
                                p.setPorte(porte);
                            }
                            
                            pList.add(p);
                        }
                        catch (IllegalArgumentsException exs) {
                            StringBuilder strEx = new StringBuilder(String.format("Erro ao receber Pet (id_pet = %d): \n", id_pet));
                            for (Throwable cause : exs.getCauses()) {
                                strEx.append(cause.getMessage());
                                strEx.append("\n");
                            }
                            
                            System.out.println(strEx.toString());
                        }
                    }
                    
                    if (!pList.isEmpty()) {
                        pArray = new petagenda.Pet[pList.size()];
                        pArray = pList.toArray(pArray);
                    }
                }
                catch (SQLException e) {
                    System.out.printf("Erro ao fazer parse de ResultSet contendo Pet: %s", e.getMessage());
                }
                
                return pArray;
            }
        }
    }
    
    static public class agendamento {
        
        public static final String TABLE = "agendamento";
        
        public static int insert(petagenda.agendamento.Agendamento agendamento) {
            int r = 0;
            
            if (agendamento == null) {
                throw new NullPointerException("Agendamento não pode ser nulo");
            }
            else {
                Connection conn = BD.getConnection();
                
                if (conn == null) { // Se banco for inacessível.
                    return r;
                }
                else {
                    // Criação do statement.
                    PreparedStatement insert = null;
                    try {
                        insert = conn.prepareStatement(String.format("INSERT INTO %s (dt_hr_marcada, endereco_pet, qnt_passeios, dta_hr_iniciado, dta_hr_finalizado, check_entrega, observacao, id_servico, id_func) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)", TABLE));
                    
                        // data e hora
                        LocalDateTime dataHoraMarcada = agendamento.getDataHoraMarcada();
                        LocalDateTime dataHoraIniciado = agendamento.getDataHoraIniciado();
                        LocalDateTime dataHoraFinalizado = agendamento.getDataHoraFinalizado();
                        
                        Timestamp timestamp_maracada = Timestamp.valueOf(dataHoraMarcada);
                        Timestamp timestamp_iniciado = Timestamp.valueOf(dataHoraIniciado);
                        Timestamp timestamp_finalizado = Timestamp.valueOf(dataHoraFinalizado);
                        
                        insert.setTimestamp(1, timestamp_maracada); // dt_hr_marcada
                        insert.setString(2, agendamento.getEnderecoPet()); // endereco_pet
                        insert.setInt(3, agendamento.getQntPasseios()); // qnt_passeios
                        insert.setTimestamp(4, timestamp_iniciado); // dta_hr_iniciado
                        insert.setTimestamp(5, timestamp_finalizado); // dta_hr_finalizado
                        insert.setInt(6, agendamento.getCheckEntrega()); // check_entrega
                        insert.setString(7, agendamento.getObservacao()); // observacao
                        insert.setInt(8, agendamento.getIdServico()); // id_servico
                        insert.setInt(9, agendamento.getIdFuncionario()); // id_funcionario
                        
                        r = insert.executeUpdate();
                    }
                    catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de execução do insert", JOptionPane.ERROR_MESSAGE);
                        r = -1;
                    }
                    
                    if (insert != null) { // Se preparedStatement não falhou
                        try {
                            insert.close();
                        }
                        catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de PreparedStatement", JOptionPane.ERROR_MESSAGE);
                        }
                        finally {
                            insert = null;
                        }
                    }
                    
                    try {
                        conn.close();
                    }
                    catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de conexão", JOptionPane.ERROR_MESSAGE);
                    }
                    finally {
                        conn = null;
                    }
                }
            }
            
            return r;
        }
        
        public static petagenda.agendamento.Agendamento selectLast() {
            petagenda.agendamento.Agendamento agendamento = null;
            
            Connection conn = BD.getConnection();
            if (conn != null) { // Se banco for acessível.
                // Criação do statement.
                PreparedStatement select = null;
                try {
                    select = conn.prepareStatement(String.format("SELECT id_agendamento, dt_hr_marcada, endereco_pet, qnt_passeios, dta_hr_iniciado, dta_hr_finalizado, check_entrega, observacao, id_servico, id_func FROM %s ORDER BY id_agendamento DESC LIMIT 1", TABLE));
                    
                    ResultSet rs = select.executeQuery();
                    petagenda.agendamento.Agendamento[] selected = parse(rs);
                    
                    if (selected != null) {
                        agendamento = selected[0];
                    }
                
                }
                catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Erro na execução da query", JOptionPane.ERROR_MESSAGE);
                }
                
                if (select != null) { // Se preparedStatement não falhou
                    try {
                        select.close();
                    }
                    catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de PreparedStatement", JOptionPane.ERROR_MESSAGE);
                    } 
                    finally {
                        select = null;
                    }
                }
                
                try {
                    conn.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de conexão", JOptionPane.ERROR_MESSAGE);
                } finally {
                    conn = null;
                }
            }
            
            return agendamento;
        }
        
        public static petagenda.agendamento.Agendamento[] parse(ResultSet rs) {
            if (rs == null) {
                throw new NullPointerException("ResultSet não pode ser nulo");
            } else {
                ArrayList<petagenda.agendamento.Agendamento> cList = new ArrayList<petagenda.agendamento.Agendamento>();
                petagenda.agendamento.Agendamento[] cArray = null;

                try {
                    while (rs.next()) {
                        petagenda.agendamento.Agendamento ag;
                        int id_agendamento, id_servico, id_funcionario, check_entrega, qnt_passeios;
                        String endereco_pet, observacao;
                        LocalDateTime dt_hr_marcada, dta_hr_iniciado, dta_hr_finalizado;
                        
                        Timestamp timestamp_maracada = null;
                        Timestamp timestamp_iniciado = null;
                        Timestamp timestamp_finalizado = null;

                        // Recebimento dos dados do ResultSet
                        id_agendamento = rs.getInt("id_agendamento"); // id_agendamento
                        
                        // dt_hr_marcada
                        timestamp_maracada = rs.getTimestamp("dt_hr_marcada");
                        dt_hr_marcada = timestamp_maracada.toLocalDateTime();
                        
                        endereco_pet = rs.getString("endereco_pet"); // endereco_pet
                        qnt_passeios = rs.getInt("qnt_passeios"); // qnt_passeios
                        
                        // dta_hr_iniciado
                        timestamp_iniciado = rs.getTimestamp("dta_hr_iniciado");
                        dta_hr_iniciado = timestamp_iniciado.toLocalDateTime();
                        
                        // dta_hr_finalizado
                        timestamp_finalizado = rs.getTimestamp("dta_hr_finalizado");
                        dta_hr_finalizado = timestamp_finalizado.toLocalDateTime();
                        
                        check_entrega = rs.getInt("check_entrega"); // check_entrega
                        observacao = rs.getString("observacao"); // observacao
                        
                        id_servico = rs.getInt("id_servico");
                        id_funcionario = rs.getInt("id_func");

                        // Verificação dos dados e criação do objeto
                        
                        try {
                            ag = new petagenda.agendamento.Agendamento(id_agendamento, dt_hr_marcada, endereco_pet, qnt_passeios, dta_hr_iniciado, dta_hr_finalizado, check_entrega, observacao, id_servico, id_funcionario);

                            cList.add(ag);
                        } catch (IllegalArgumentsException exs) {
                            StringBuilder strEx = new StringBuilder(String.format("Erro ao receber Agendamento (id_agendamento = %d):\n", id_agendamento));
                            for (Throwable cause : exs.getCauses()) {
                                strEx.append(cause.getMessage());
                                strEx.append("\n");
                            }
                            System.out.println(strEx.toString());
                        }
                    }
                    if (!cList.isEmpty()) {
                        cArray = new petagenda.agendamento.Agendamento[cList.size()];
                        cArray = cList.toArray(cArray);
                    }
                } catch (SQLException e) {
                    System.out.printf("Erro ao fazer parse de ResultSet contendo Cliente: %s", e.getMessage());
                }

                return cArray;
            }
        }
    }
    
    static public class pet_agendamento {
        
        public static final String TABLE = "pet_agendamento";

        public static int insert(petagenda.agendamento.Pet_agendamento pet_agendamento) {
            int r = 0;

            if (pet_agendamento == null) {
                throw new NullPointerException("Pet_agendamento não pode ser nulo.");
            } else {
                Connection conn = BD.getConnection();
                if (conn == null) { //Se o banco de dados for inacessível.
                    return r;
                } else {
                    // Criação do statement.
                    PreparedStatement insert = null;
                    try {
                        insert = conn.prepareStatement(String.format("INSERT INTO %s(id_agendamento_pet, id_pet_agend) VALUES(?, ?)", TABLE));

                        insert.setInt(1, pet_agendamento.getIdAgendamento()); // id_agendamento
                        insert.setInt(2, pet_agendamento.getIdPet()); // id_pet

                        r = insert.executeUpdate();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de execução do insert", JOptionPane.ERROR_MESSAGE);
                        r = -1;
                    }

                    if (insert != null) { // Se preparedStatement não falhou.
                        try {
                            insert.close();
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de PreparedStatement", JOptionPane.ERROR_MESSAGE);
                        } finally {
                            insert = null;
                        }
                    }

                    try {
                        conn.close();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de conexão", JOptionPane.ERROR_MESSAGE);
                    } finally {
                        conn = null;
                    }
                }
            }

            return r;
        }
    
    }
    
    static public class remedio {
        
        public static final String TABLE = "remedio_agend";
        
        public static int insert(petagenda.agendamento.Remedio remedio) {
            int r = 0;
            
            if (remedio == null) {
                throw new NullPointerException("Remedio não pode ser nulo");
            }
            else {
                Connection conn = BD.getConnection();
                
                if (conn == null) { // Se banco for inacessível.
                    return r;
                }
                else {
                    // Criação do statement.
                    PreparedStatement insert = null;
                    try {
                        insert = conn.prepareStatement(String.format("INSERT INTO %s (nome_remedio, hr_administrar, instrucoes, id_agendamento) VALUES (?, ?, ?, ?)", TABLE));
                        
                        // data e hora
                        LocalTime hr_administrar = remedio.getHoraAdministrar();
                       
                        
                        insert.setString(1, remedio.getNome()); // nome_remedio
                        insert.setTime(2, java.sql.Time.valueOf(hr_administrar)); // hr_administrar
                        insert.setString(3, remedio.getInstrucoes()); // instrucoes
                        insert.setInt(4, remedio.getIdAgendamento()); // id_agendamento
                        
                        r = insert.executeUpdate();
                    }
                    catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de execução do insert", JOptionPane.ERROR_MESSAGE);
                        r = -1;
                    }
                    
                    if (insert != null) { // Se preparedStatement não falhou
                        try {
                            insert.close();
                        }
                        catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de PreparedStatement", JOptionPane.ERROR_MESSAGE);
                        } 
                        finally {
                            insert = null;
                        }
                    }
                    
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de conexão", JOptionPane.ERROR_MESSAGE);
                    } finally {
                        conn = null;
                    }
                }
            }
            
            return r;
        }
    }
    
    static public class alimentacao {
        
        public static final String TABLE = "hr_alim_agend";
        
        public static int insert(petagenda.agendamento.alimentacao alimentacao) {
            int r = 0;
            
            if (alimentacao == null) {
                throw new NullPointerException("Alimentacao não pode ser nulo");
            }
            else {
                Connection conn = BD.getConnection();
                
                if (conn == null) { // Se banco for inacessível.
                    return r;
                }
                else {
                    // Criação do statement.
                    PreparedStatement insert = null;
                    try {
                        insert = conn.prepareStatement(String.format("INSERT INTO %s (horario, id_agendamento) VALUES (?, ?)", TABLE));
                        
                        // data e hora
                        LocalTime horario = alimentacao.getHorario();
                        
                        insert.setTime(1, java.sql.Time.valueOf(horario));
                        insert.setInt(2, alimentacao.getIdAgendamento());
                        
                        r = insert.executeUpdate();
                    }
                    catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de execução do insert", JOptionPane.ERROR_MESSAGE);
                        r = -1;
                    }
                    
                    if (insert != null) { // Se preparedStatement não falhou.
                        try {
                            insert.close();
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de PreparedStatement", JOptionPane.ERROR_MESSAGE);
                        } finally {
                            insert = null;
                        }
                    }
                    
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de fechamento de conexão", JOptionPane.ERROR_MESSAGE);
                    } finally {
                        conn = null;
                    }
                }
            }
            
            return r;
        }
    }
}
