/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package petagenda;

/**
 *
 * @author edmun
 */

import petagenda.bd.BD;
import petagenda.dados.CPF;
import petagenda.exception.*;

public final class Funcionario {
    private int id_func;
    private String nome;
    private CPF cpf;
    private String telefone;
    private String rua;
    private String cep;
    private String numero;
    private String bairro;
    private String cidade;
    
    public static final int NULL_ID = -1;
   
    /*
    public Funcionario (int id_func, String nome, CPF cpf, String telefone, String rua, String cep, String numero, String bairro, String cidade) {
        this.id_func = id_func;
    private String rua;
    private String bairro;
    private String cidade;
    
    public Funcionario (int id, String nome, CPF cpf, String telefone, String servico_prestado, String rua,String cep, String numero, String bairro, String cidade) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.rua = rua;
        this.cep = cep;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
    }
    */
    
    public Funcionario(String nome, String cpf, String telefone, String rua, String cep, String numero, String bairro, String cidade) {
        this(1, nome, cpf, telefone, rua, cep, numero, bairro, cidade);
        this.id_func = NULL_ID;
    }
    
    public Funcionario(int id_func, String nome, String cpf, String telefone, String rua, String cep, String numero, String bairro, String cidade) {
        IllegalArgumentsException exs = new IllegalArgumentsException();
        
        // id_func
        try {
            setId(id_func);
        }
        catch (IllegalIdException ex) {
            exs.addCause(ex);
        }
        
        // nome
        try {
            setNome(nome);
        }
        catch (IllegalNomeException ex) {
            exs.addCause(ex);
        }
        
        // cpf
        try {
            setCpf(cpf);
        }
        catch (IllegalCpfException ex) {
            exs.addCause(ex);
        }
        
        // telefone
        try {
            setTelefone(telefone);
        }
        catch (IllegalTelefoneException ex) {
            exs.addCause(ex);
        }
        
        // rua
        try {
            setRua(rua);
        }
        catch (IllegalRuaException ex) {
            exs.addCause(ex);
        }
        
        // cep
        try {
            setCep(cep);
        }
        catch (IllegalCepException ex) {
            exs.addCause(ex);
        }
        
        // numero
        try {
            setNumero(numero);
        }
        catch (IllegalNumeroException ex) {
            exs.addCause(ex);
        }
        
        // bairro
        try {
            setBairro(bairro);
        }
        catch (IllegalBairroException ex) {
            exs.addCause(ex);
        }
        
        // cidade
        try {
            setCidade(cidade);
        }
        catch (IllegalCidadeException ex) {
            exs.addCause(ex);
        }
        
        if (exs.size() > 0) { // Alguma exceção ocorreu.
            throw exs;
        }
    }
    
    /*public static void insert(Funcionario funcionario) {
        BD.Funcionario.insert(funcionario);
    }

    public static void update(Funcionario funcionario) {
        BD.Funcionario.update(funcionario);
    }

    public static void delete(Funcionario funcionario) {
        BD.Funcionario.delete(funcionario);
    }
    */

    // Verifica se o funcionário já é existente.
    public boolean isNew() {
        return this.getId() == NULL_ID;
    }


    // Getters e Setters


    // id_func
    public void setId(int id_func) {
        if (id_func < 0) {
            throw new IllegalIdException("Id não pode ser inferior a zero");
        } else {
            this.id_func = id_func;
        }
    }

    public int getId() {
        return this.id_func;
    }

    // nome
    public void setNome(String nome) {
        nome = nome.trim(); // Tira os espaços em branco do início e final.
        if (nome == null || nome.isEmpty()) {
            throw new IllegalNomeException("Nome não pode ser nulo ou vazio.");
        }
        else if (nome.length() > 64) {
            throw new IllegalNomeException("Nome não pode ultrapassar 64 caracteres.");
        }
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }
    
    // CPF
    public void setCpf(String strCpf) {
        strCpf = strCpf.trim(); // Tira os espaços em branco do início e final.
        if (strCpf == null || strCpf.isEmpty()) {
            throw new IllegalCpfException("CPF não pode ser nulo ou vazio.");
        }
        
        this.cpf = new CPF(strCpf); // Criando objeto CPF
    }

    public CPF getCpf() {
        return this.cpf;
    }
    
    // Telefone
    public void setTelefone (String telefone) {
        telefone = telefone.trim(); // Tira os espaços em branco do início e final.
        if (telefone == null || telefone.isEmpty()) {
            throw new IllegalTelefoneException("Telefone não pode ser nulo ou vazio.");
        }
        else if (telefone.length() > 15) {
            throw new IllegalNomeException("Nome não pode ultrapassar 64 caracteres.");
        }
        this.telefone = telefone; // Criando objeto CPF
    }
    
    public String getTelefone () {
        return this.telefone;
    }
    
    // Rua
    public void setRua(String rua) {
        rua = rua.trim(); // Tira os espaços em branco do início e final.
        if (rua == null || rua.isEmpty()) {
            throw new IllegalRuaException("Rua não pode ser nulo ou vazio.");
        }
        else if (rua.length() > 45) {
            throw new IllegalRuaException("Rua não pode ultrapassar 45 caracteres.");
        }
        
        this.rua = rua;
    }
    
    public String getRua () {
        return this.rua;
    }
    
    // Cep
    public void setCep(String cep) {
        cep = cep.trim(); // Tira os espaços em branco do início e final.
        if (cep == null || cep.isEmpty()) {
            throw new IllegalCepException("Cep não pode ser nulo ou vazio.");
        }
        else if (cep.length() > 8) {
            throw new IllegalCepException("Cep não pode ultrapassar 8 caracteres.");
        }
        
        this.cep = cep;
    }
    
    public String getCep () {
        return this.cep;
    }
    
    // Numero
    public void setNumero(String numero) {
        numero = numero.trim(); // Tira os espaços em branco do início e final.
        if (numero == null || numero.isEmpty()) {
            throw new IllegalNumeroException("Numero não pode ser nulo ou vazio.");
        }
        else if (numero.length() > 16) {
            throw new IllegalNumeroException("Numero não pode ultrapassar 16 caracteres.");
        }
        
        this.numero = numero;
    }
    
    public String getNumero () {
        return this.numero;
    }
    
    // Bairro
    public void setBairro(String bairro) {
        bairro = bairro.trim(); // Tira os espaços em branco do início e final.
        if (bairro == null || bairro.isEmpty()) {
            throw new IllegalBairroException("Bairro não pode ser nulo ou vazio.");
        }
        else if (bairro.length() > 32) {
            throw new IllegalBairroException("Bairro não pode ultrapassar 8 caracteres.");
        }
        
        this.bairro = bairro;
    }
    
    public String getBairro () {
        return this.bairro;
    }
    
    // Cidade
    public void setCidade(String cidade) {
        cidade = cidade.trim(); // Tira os espaços em branco do início e final.
        if (cidade == null || cidade.isEmpty()) {
            throw new IllegalCidadeException("Cidade não pode ser nulo ou vazio.");
        }
        else if (cidade.length() > 32) {
            throw new IllegalCidadeException("Cidade não pode ultrapassar 8 caracteres.");
        }
        
        this.cidade = cidade;
    }
    
    public String getCidade () {
        return this.cidade;
    }
    

    @Override
    public String toString() {
        return String.format("ID: %d | NOME: %s | CPF: %s | TELEFONE: %s | RUA: %s | CEP: %s | NUMERO: %s | BAIRRO: %s | CIDADE: %s ", 
                getId(), getNome(), getCpf().toString(), getTelefone(), getRua(), getCep(), getNumero(), getBairro(), getCidade());
    }
}
