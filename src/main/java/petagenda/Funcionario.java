/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package petagenda;

/**
 *
 * @author edmun
 */

import java.util.Arrays;
import static petagenda.Usuario.NULL_ID;
import petagenda.bd.BD;
import petagenda.dados.*;
import petagenda.exception.*;
import petagenda.servico.*;

public final class Funcionario {
    private static Funcionario atual;
    private int id;
    private String nome;
    private CPF cpf;
    private String telefone;
    private String servico_prestado;
    private String cep;
    private String numero;
    private String rua;
    private String bairro;
    private String cidade;
    
    public Funcionario (int id, String nome, CPF cpf, String telefone, String servico_prestado, String rua,String cep, String numero, String bairro, String cidade) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.servico_prestado = servico_prestado;
        this.rua = rua;
        this.cep = cep;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
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

    public boolean isNew() {
        return this.getId() == NULL_ID;
    }


    // Getters e Setters

    public void setId(int id) {
        if (id < 0) {
            throw new IllegalIdException("Id não pode ser inferior a zero");
        } else {
            this.id = id;
        }
    }

    public int getId() {
        return this.id;
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
    public void setTelefone (String telefone) {
        if (telefone == null || telefone.isEmpty()) {
            throw new IllegalArgumentException("CPF não pode ser nulo ou vazio.");
        }
        this.telefone = telefone; // Criando objeto CPF
    }
    public String getTelefone () {
        return this.telefone;
    }
    
    public void setServico_prestado () {
        if (servico_prestado == null || servico_prestado.isEmpty()) {
            throw new IllegalArgumentException("CPF não pode ser nulo ou vazio.");
        }
        this.servico_prestado = servico_prestado; // Criando objeto CPF
    }
    public String getServico_prestado() {
        return this.servico_prestado;
    }
    
    public void setCep(String cep) {
        this.cep = cep;
    }
    public String getCep () {
        return this.cep;
    }
    
    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    public String getNumero () {
        return this.numero;
    }
    
    public void setRua(String rua) {
        this.rua = rua;
    }
    
    public String getRua () {
        return this.rua;
    }
    
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    
    public String getCidade () {
        return this.cidade;
    }
    
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    public String getBairro () {
        return this.bairro;
    }

    @Override
    public String toString() {
        return String.format("ID: %-5d | NOME: %-16s | CPF: %-11s | PERMISSÃO: %d", getId(), getNome(), getCpf().toString() +
                getTelefone(), getServico_prestado(), getCep(), getNumero(), getRua(), getCidade(), getBairro());
    }
}
