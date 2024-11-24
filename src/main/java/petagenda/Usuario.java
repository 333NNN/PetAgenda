package petagenda;

import java.util.Arrays;
import petagenda.bd.BD;
import petagenda.dados.*;
import petagenda.exception.*;
import petagenda.servico.*;

/**
 *
 * @author t.baiense
 */
public final class Usuario {
    private static Usuario atual;
    private int id_usuario;
    private String nome;
    private CPF cpf;
    private String senha;
    private int permissao;

    public static final int NULL_ID = -1;

    // Exemplo de uso
    public static void main(String[] args) {
        Usuario eu;
        try {
            // Teste de login
            Usuario logado = BD.Usuario.login("88784449012", "1234");
            System.out.println(logado);
        } catch (IllegalArgumentsException exs) {
            Throwable[] causas = exs.getCauses();
            System.out.println(Arrays.toString(causas));
        }
    }

    // Construtores
    public Usuario(String nome, CPF cpf, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
    }

    public Usuario(int id_usuario, String nome, CPF cpf, String senha, int permissao) {
        this.id_usuario = id_usuario;
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.permissao = permissao;
    }

    // Métodos estáticos para manipulação de dados no banco

    public static Usuario selectById(int id_usuario) {
        return BD.Usuario.selectById(id_usuario);
    }

    public static void insert(Usuario usuario) {
        BD.Usuario.insert(usuario);
    }

    public static void update(Usuario usuario) {
        BD.Usuario.update(usuario);
    }

    public static void delete(Usuario usuario) {
        BD.Usuario.delete(usuario);
    }

    public static Usuario login(String cpf, String senha) {
        return BD.Usuario.login(cpf, senha);
    }

    public boolean isNew() {
        return this.getId() == NULL_ID;
    }

    public static void setAtual(Usuario usuario) {
        if (usuario != null && usuario.getSenha() != null) {
            atual = usuario;
        }
    }

    public static Usuario getAtual() {
        return atual;
    }

    // Getters e Setters

    public void setId(int id_usuario) {
        if (id_usuario < 0) {
            throw new IllegalIdException("Id não pode ser inferior a zero");
        } else {
            this.id_usuario = id_usuario;
        }
    }

    public int getId() {
        return this.id_usuario;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio.");
        }
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setCpf(String strCpf) {
        if (strCpf == null || strCpf.isEmpty()) {
            throw new IllegalArgumentException("CPF não pode ser nulo ou vazio.");
        }
        this.cpf = new CPF(strCpf); // Criando objeto CPF
    }

    public CPF getCpf() {
        return this.cpf;
    }

    public void setSenha(String senha) {
        if (senha == null || senha.isEmpty()) {
            throw new IllegalArgumentException("Senha não pode ser nula ou vazia.");
        }
        this.senha = senha;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setPermissao(int permissao) {
        if (permissao < 0) {
            throw new IllegalArgumentException("Permissão não pode ser negativa.");
        }
        this.permissao = permissao;
    }

    public int getPermissao() {
        return this.permissao;
    }

    @Override
    public String toString() {
        return String.format("ID_USUARIO: %-5d | NOME: %-16s | CPF: %-11s | PERMISSÃO: %d", getId(), getNome(), getCpf().toString(), getPermissao());
    }
}
