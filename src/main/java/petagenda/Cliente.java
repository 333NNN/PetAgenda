package petagenda;

import petagenda.bd.BD;
import java.util.ArrayList;
import java.util.Arrays;
import petagenda.dados.*;
import petagenda.exception.*;
import petagenda.servico.*;

/**
 *
 * @author t.baiense
 */
public final class Cliente {
    private int id_cliente;
    private String nome;
    //private Endereco endereco;
    private CPF cpf;
    private String telefone;
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String cep;
    //private Servico servicoSolicita;
    private String buscar_com;
    private String devolver_para;
    
    public static final int NULL_ID = -1;
    
    // Exemplo de uso
    public static void main(String[] args) {
        Cliente eu;
        try {
//            TipoServico passeio = new TipoServico("Passeio");
//            Servico servSolicita = new Servico("Dog Walker", passeio, 60, 100.0);
//            Endereco endCliente = new Endereco("Rua Guanabara", "num. 106", "Itaparica", "Vitoria", "12345678");
            
//            Cliente cl = new Cliente("Roberto", endCliente, "4002-8922", servSolicita);
//            
            // Inserindo novo Cliente no banco
            Endereco endCliente = new Endereco("Rua Vitória", "num. 106", "Itaparica", "Vitoria", "12345678");
//            endCliente.setId(BD.Endereco.selectLast().getId());
            Servico servDogWalking = BD.Servico.selectById(4);
            //Cliente cl = new Cliente("Mariazinha", endCliente, "4002-8922", servDogWalking);
            //BD.Cliente.insert(cl);
            System.out.println("Último cliente inserido:\n" + BD.Cliente.selectById(BD.Cliente.selectLast().getId()).toString());

            // Buscando todos clientes cadastrados
            System.out.println("--- TODOS CLIENTES CADASTRADOS ---\n");
            Cliente[] clientes = BD.Cliente.selectAll();
            for (Cliente c : clientes) {
                if (c != null) {
                    System.out.println(c.toString());
                }
            }
            
            // Alterando Cliente no banco
//            Cliente cl = BD.Cliente.selectLast();
//            Endereco novoEndCliente = new Endereco("Rua nova", "num. novo", "Bairro novo", "Cidade nova", "12345999");
//            Servico novoServCliente = BD.Servico.selectById(1);
//            cl.setEndereco(novoEndCliente);
//            cl.setServico(novoServCliente);
//            
//            BD.Cliente.update(cl);
//            System.out.println(BD.Cliente.selectById(BD.Cliente.selectLast().getId()).toString());

            // Apagando Cliente no banco
//            Cliente lastClDelete = BD.Cliente.selectLast();
//            System.out.println(BD.Cliente.delete(lastClDelete));

        } catch (IllegalArgumentsException exs) {
            Throwable[] causas = exs.getCauses(); // Exceções geradas pelo construtor por conta de argumentos inválidos
            System.out.println(Arrays.toString(causas)); // Printa as exceções se houver
        }
        
    }
    
    /*
    public Cliente(int id_cliente, String nome, String cpf, String telefone, String rua, String numero, String bairro, String cidade, String cep, String buscarPetCom, String devolverPetPara) {
        this(id_cliente, nome, cpf, telefone, rua, numero, bairro, cidade, cep, null, null);
    }
    */
    
    public Cliente(String nome, String cpf, String telefone, String rua, String numero, String bairro, String cidade, String cep, String buscarPetCom, String devolverPetPara) {
        this(1, nome, cpf, telefone, rua, numero, bairro, cidade, cep, buscarPetCom, devolverPetPara);
        this.id_cliente = NULL_ID;
    }
    
    public Cliente(int id_cliente, String nome, String cpf, String telefone, String rua, String numero, String bairro, String cidade, String cep, String buscarPetCom, String devolverPetPara) {
        IllegalArgumentsException exs = new IllegalArgumentsException();
        
        // Id
        try {
            setId(id_cliente);
        } catch (IllegalIdException ex) {
            exs.addCause(ex);
        }
        
        // Nome
        try {
            setNome(nome);
        } catch (IllegalNomeException ex) {
            exs.addCause(ex);
        }
        
        // CPF
        try {
            setCpf(cpf);
        } catch (IllegalCpfException ex) {
           exs.addCause(ex);
        }
        
        // Telefone
        try {
            setTelefone(telefone);
        } catch (IllegalTelefoneException ex) {
            exs.addCause(ex);
        }
        
        // rua
        try {
            setRua(rua);
        }
        catch (IllegalRuaException ex) {
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
        
        // cep
        try {
            setCep(cep);
        }
        catch (IllegalCepException ex) {
            exs.addCause(ex);
        }
        
        // Buscar_com
        try {
            setBuscarPetCom(buscarPetCom);
        } catch (IllegalNomeException ex) {
            exs.addCause(ex);
        }
        
        // devolver_para
        try {
            setDevolverPetPara(devolverPetPara);
        } catch (IllegalNomeException ex) {
            exs.addCause(ex);
        }
 
        // Endereço
        /*
        try {
            setEndereco(endereco);
        } catch (IllegalEnderecoException ex) {
            exs.addCause(ex);
        }
        */

        // Serviço solicitado
        /*
        try {
            setServico(servicoSolicita);
        } catch (IllegalServicoException ex) {
            exs.addCause(ex);
        }
        */

        if (exs.size() > 0) { // Alguma exceção ocorreu
            throw exs;
        }
    }
    
    // Verifica se o cliente já é existente.
    public boolean isNew() {
        return this.getId() == NULL_ID;
    }
    
    public void setId(int id_cliente) {
        if (id_cliente < 0) {
            throw new IllegalIdException("id não pode ser inferior a zero");
        } else {
            this.id_cliente = id_cliente;
        }
    }
    
    public int getId() {
        return this.id_cliente;
    }
    
    // Nome
    public void setNome(String nome) {
        if (nome == null) {
            throw new IllegalNomeException("nome não pode ser nulo");
        }
        nome = nome.trim();
        if (nome.isEmpty()) {
            throw new IllegalNomeException("nome não pode ser vazio");
        } else if (nome.length() > 64) {
            throw new IllegalNomeException("nome não pode conter mais do que 64 caracteres");
        }
        this.nome = nome;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    /*
    public void setEndereco(Endereco endereco) {
        if (endereco == null) {
            throw new IllegalEnderecoException("Endereço não pode ser nulo");
        } else {
            this.endereco = endereco;
        }
    }
    
    public Endereco getEndereco() {
        return this.endereco;
    }
    */
    
    // Cpf
    public void setCpf(String strCpf) {
        if (strCpf == null) {
            this.setCpf((CPF)null); // Meus olhos choram sangue de ter que fazer isso (ಥ﹏ಥ) 
        } else {
            this.setCpf(new CPF(strCpf)); // Dá throw de IllegalCpfException se for inválido e NullPointerException se for nulo
        }
    }
    
    public void setCpf(CPF cpf) {
        if (cpf == null) {
            this.cpf = null;
            throw new IllegalCpfException("CPF não pode ser nulo");
            
        } else {
            this.cpf = cpf;
        }
    }
    
    public CPF getCpf() {
        return this.cpf;
    }
    
    // Telefone
    public void setTelefone(String tel) {
        if (tel == null) {
            throw new IllegalTelefoneException("telefone não pode ser nulo");
        }
        tel = tel.trim();
        if (tel.isEmpty()) {
            throw new IllegalTelefoneException("telefone não pode ser vazio");
        } else if (tel.length() > 15) {
            throw new IllegalTelefoneException("telefone não pode conter mais do que 12 caracteres");
        }
        this.telefone = tel;
    }
    
    public String getTelefone() {
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
    
    // Cep
    public void setCep(String cep) {
        cep = cep.trim(); // Tira os espaços em branco do início e final.
        if (cep == null || cep.isEmpty()) {
            throw new IllegalCepException("Cep não pode ser nulo ou vazio.");
        }
        else if (cep.length() > 8 || cep.length() < 8) {
            throw new IllegalCepException("Cep inválido.");
        }
        
        this.cep = cep;
    }
    
    public String getCep () {
        return this.cep;
    }
    
    // Buscar_com
    public void setBuscarPetCom(String pessoa) {
        if (pessoa == null) {
            throw new IllegalNomeException("pessoa não pode ser nulo");
        } else {
            pessoa = pessoa.trim();
            if (pessoa.isEmpty()) {
                throw new IllegalNomeException("pessoa não pode ser vazio");
            } else if (pessoa.length() > 64) {
                throw new IllegalNomeException("pessoa não pode conter mais do que 64 caracteres");
            }
            this.buscar_com = pessoa;
        }
    }
    
    public String getBuscarPetCom() {
        return this.buscar_com;
    }
    
    // Devolver_para
    public void setDevolverPetPara(String pessoa) {
        if (pessoa == null) {
//            throw new IllegalNomeException("pessoa não pode ser nulo");
            this.devolver_para = null;
        } else {
            pessoa = pessoa.trim();
            if (pessoa.isEmpty()) {
                throw new IllegalNomeException("pessoa não pode ser vazio");
            } else if (pessoa.length() > 64) {
                throw new IllegalNomeException("pessoa não pode conter mais do que 64 caracteres");
            }
            this.devolver_para = pessoa;
        }
    }
    
    public String getDevolverPetPara() {
        return this.devolver_para;
    }

    @Override
    public String toString() {
        return String.format("NOME: %s | CPF: %s" /*SERVIÇO SOL.: %s"*/, getNome(), getCpf()/*, getEndereco().toString(), getTelefone(), getServico().getNome()*/);
                                   //ENDERECO: %s 
    }
}
