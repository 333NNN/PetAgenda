package petagenda.servico;

import petagenda.exception.IllegalArgumentsException;
import petagenda.exception.IllegalIdException;
import petagenda.exception.IllegalNomeException;
import petagenda.exception.IllegalPrecoException;
import petagenda.exception.IllegalDescricaoException;

import java.util.ArrayList;

/**
 *
 * @author Thiago M. Baiense
 */
public final class Servico {
    private int id_servico;
    private String nome;
    private double preco;
    private String descricao;
    
    public static final int NULL_ID = -1;
    
    public Servico(String nome, double preco) {
        this(1, nome, preco, null);
        this.id_servico = NULL_ID;
    }
    
    public Servico(int id_servico, String nome, double preco) {
        this(id_servico, nome, preco, null);
    }
    
    public Servico(String nome, double preco, String descricao) {
        this(1, nome, preco, descricao);
        this.id_servico = NULL_ID;
    }
    
    public Servico(int id_servico, String nome, double preco, String descricao) {
        ArrayList<Throwable> cList = null; // Armazena as cause a serem adicionadas ao construtor
        
        // id_servico
        try {
            this.setId(id_servico);
        } catch (IllegalIdException ex) {
            cList = new ArrayList<Throwable>();
            cList.add(ex);
        }
        
        // nome
        try {
            this.setNome(nome);
        } catch (IllegalNomeException ex) {
            if (cList == null) {
                cList = new ArrayList<Throwable>();
            }
            cList.add(ex);
        }

        // preco
        try {
            this.setPreco(preco);
        } catch (IllegalPrecoException ex) {
            if (cList == null) {
                cList = new ArrayList<Throwable>();
            }
            cList.add(ex);
        }
        
        // descricao
        try {
            this.setDescricao(descricao);
        } catch (IllegalDescricaoException ex) {
            if (cList == null) {
                cList = new ArrayList<Throwable>();
            }
            cList.add(ex);
        }
        
        // Mostra os erros.
        if (cList != null && !cList.isEmpty()) {
            Throwable[] tArray = new Throwable[cList.size()];
            cList.toArray(tArray);
            throw new IllegalArgumentsException(tArray);
        }
    }
    
    // Verifica se o funcionário já é existente.
    public boolean isNew() {
        return this.getId() == NULL_ID;
    }
    
    // id_servico
    public void setId(int id_servico) {
        if (id_servico < 1) {
            throw new IllegalIdException();
        }
        
        this.id_servico = id_servico;
    }
    
    public int getId() {
        return this.id_servico;
    }
    
    // nome
    public void setNome(String nome) {
        if (nome == null) {
            throw new IllegalNomeException("nome não pode ser nulo");
        }
        
        nome = nome.trim();
        
        if (nome.isEmpty()) {
            throw new IllegalNomeException("nome não pode ser vazio");
        } else if (nome.length() > 45) {
            throw new IllegalNomeException("nome não pode conter mais de 45 caracteres");
        }
        
        this.nome = nome;
    }
    
    public String getNome() {
        return this.nome;
    }

    // preco
    public void setPreco(double preco) {
        if (preco < 0) {
            throw new IllegalPrecoException("preço não pode ser inferior a 0");
        }
        
        this.preco = preco;
    }
    
    public double getPreco() {
        return this.preco;
    }
    
    // descricao
    public void setDescricao(String desc) {
        if (desc == null) {
            this.descricao = null;
        } else {
            desc = desc.trim();
        
            if (desc.isEmpty()) {
                this.descricao = null;
            } else if (desc.length() > 200) {
                throw new IllegalDescricaoException("descrição não pode conter mais de 200 caracteres");
            } else {
                this.descricao = desc;
            }
        }
    }
    
    public String getDescricao() {
        return this.descricao;
    }
    
    public boolean equals(Object o) {
        if (o != null && o instanceof Servico) {
            return this.getId() == ((Servico)o).getId();
        } else {
            return false;
        }
    }
    
    @Override
    public String toString() {
        //return this.getNome();
        return String.format("id_servico: %d | nome: %s | preco: %.2f | descricao: %s", getId(), getNome(), getPreco(), getDescricao());
    }
}
