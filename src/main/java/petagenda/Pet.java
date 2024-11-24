package petagenda;

//import java.util.Arrays;
import petagenda.exception.IllegalPorteException;
import petagenda.dados.Porte;
import petagenda.exception.*;
import petagenda.dados.Sexo;

/**
 *
 * @author thiago
 */
public final class Pet {
    private int id_pet;
    private String nome;
    private String raca;
    private Sexo sexo;
    private Porte porte;
    private String comportamento;
    private Boolean eCastrado;
    private String caminho_cartao_vacinacao;
    private String estado_saude;
    private String cor;
    private int id_cliente;
    
    public static final int NULL_ID = -1;
    
    public Pet(String nome, String raca, Sexo sexo, Porte porte, String comportamento, Boolean eCastrado, String caminho_cartao_vacinacao, String estado_saude, String cor, int id_cliente) {
        this(1, nome, raca, sexo, porte, comportamento, eCastrado, caminho_cartao_vacinacao, estado_saude, cor, id_cliente);
        this.id_pet = NULL_ID;
    }
    
    public Pet(int id_pet, String nome, String raca, Sexo sexo, Porte porte, String comportamento, Boolean eCastrado, String caminho_cartao_vacinacao, String estado_saude, String cor, int id_cliente) {
        IllegalArgumentsException exs = new IllegalArgumentsException();
        
        // id_pet
        try {
            setId(id_pet);
        } catch (IllegalIdException ex) {
            exs.addCause(ex);
        }
        
        // nome
        try {
            setNome(nome);
        } catch (IllegalNomeException ex) {
            exs.addCause(ex);
        }
        
        // raca
        try {
            setRaca(raca);
        } catch (IllegalRacaException ex) {
            exs.addCause(ex);
        }
        
        // sexo
        try {
            setSexo(sexo);
        } catch (IllegalSexoException ex) {
            exs.addCause(ex);
        }
        
        // porte
        try {
            setPorte(porte);
        } catch (IllegalPorteException ex) {
            exs.addCause(ex);
        }
        
        // comportamento
        try {
            setComportamento(comportamento);
        }
        catch (IllegalComportamentoPetException ex) {
            exs.addCause(ex);
        }
        
        // e_castrado
        try {
            setCastrado(eCastrado);
        }
        catch (IllegalECastradoException ex) {
            exs.addCause(ex);
        }

        // caminho_cartao_vacinacao
        try {
            setCaminhoCartaoVacinacao(caminho_cartao_vacinacao);
        }
        catch (IllegalCaminhoCartaoVacinacaoException ex) {
            exs.addCause(ex);
        }
        
        // estado_saude
        try {
            setEstadoSaude(estado_saude);
        }
        catch (IllegalEstadoSaudeException ex) {
            exs.addCause(ex);
        }
        
        // cor
        try {
            setCor(cor);
        }
        catch (IllegalCorException ex) {
            exs.addCause(ex);
        }
        
        // id_cliente
        try {
            setDono(id_cliente);
        }
        catch (IllegalIdException ex) {
            exs.addCause(ex);
        }
        
        if (exs.size() > 0) { // Alguma exceção ocorreu.
            throw exs;
        }
    }
    
    // id_pet
    public void setId(int id_pet) {
        if (id_pet < 0) {
            throw new IllegalIdException("id não pode ser inferior a zero");
        } else {
            this.id_pet = id_pet;
        }
    }
    
    public int getId() {
        return this.id_pet;
    }
    
    // nome
    public void setNome(String nome) {
        if (nome == null) {
            throw new IllegalNomeException("nome não pode ser nulo");
        } else {
            nome = nome.trim();
            if (nome.isEmpty()) {
                throw new IllegalNomeException("nome não pode ser vazio");
            } else if (nome.length() > 64) {
                throw new IllegalNomeException("nome não pode conter mais do que 45 caracteres");
            }  
        }
        this.nome = nome;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    // raca
    public void setRaca(String raca){
        if (raca == null) {
            throw new IllegalRacaException("raça não pode ser nula");
        }
        raca = raca.trim();
        if (raca.isEmpty()) {
            throw new IllegalRacaException("raça não pode ser vazia");
        } else if (raca.length() > 45) {
            throw new IllegalRacaException("raça não pode conter mais do que 45 caracteres");
        }
        this.raca = raca;
    }
    
    public String getRaca() {
        return this.raca;
    }
    
    // sexo
    public void setSexo(Sexo sexo) {
        if (sexo == null) {
            throw new IllegalSexoException("sexo não pode ser nulo");
        } else {
            this.sexo = sexo;
        }
    }
    
    public Sexo getSexo() {
        return this.sexo;
    }
    
    // porte
    public void setPorte(Porte porte) {
        if (porte == null) {
            throw new IllegalPorteException("porte não pode ser nulo");
        } else {
            this.porte = porte;
        }
    }
    
    public Porte getPorte() {
        return this.porte;
    }
    
    public String getPorteTexto() {
        return this.porte.getTexto();
    }
    
    // comportamento
    public void setComportamento(String comportamento) {
        if (comportamento == null) {
            throw new IllegalComportamentoPetException("comportamento não pode ser nulo");
        } else {
            comportamento = comportamento.trim();
            if (comportamento.isEmpty()) {
                throw new IllegalComportamentoPetException("comportamento não pode ser vazia");
            } else if (comportamento.length() > 80) {
                throw new IllegalComportamentoPetException("comportamento não pode conter mais do que 80 caracteres");
            }  
        }
        this.comportamento = comportamento;
    }
    
    public String getComportamento() {
        return this.comportamento;
    }
    
    // e_castrado
    public void setCastrado(Boolean eCastrado) {
        if (eCastrado == null) {
            throw new IllegalECastradoException("Castrado não pode ser nulo");
        }
        else {
            this.eCastrado = eCastrado;
        }
    }
    
    public boolean getECastrado() {
        return this.eCastrado;
    }
    
    // caminho_cartao_vacinacao
    public void setCaminhoCartaoVacinacao(String caminho) {
        if (caminho == null) {
            throw new IllegalCaminhoCartaoVacinacaoException("caminho do cartão de vacinação não pode ser nulo");
        } else {
            caminho = caminho.trim();
            if (caminho.isEmpty()) {
                throw new IllegalCaminhoCartaoVacinacaoException("caminho do cartão de vacinação não pode ser vazia");
            } else if (caminho.length() > 255) {
                throw new IllegalCaminhoCartaoVacinacaoException("caminho do cartão de vacinação não pode conter mais do que 255 caracteres");
            }  
        }
        this.caminho_cartao_vacinacao = caminho;
    }
    
    public String getCaminhoCartaoVacinacao() {
        return this.caminho_cartao_vacinacao;
    }
    
    // estado_saude
    public void setEstadoSaude(String estado) {
        if (estado == null) {
            throw new IllegalEstadoSaudeException("estado de saúde não pode ser nulo");
        } else {
            estado = estado.trim();
            if (estado.isEmpty()) {
                throw new IllegalEstadoSaudeException("estado de saúde não pode ser vazia");
            } else if (estado.length() > 80) {
                throw new IllegalEstadoSaudeException("estado de saúde não pode conter mais do que 255 caracteres");
            }  
        }
        this.estado_saude = estado;
    }
    
    public String getEstadoSaude() {
        return this.estado_saude;
    }
    
    // cor
    public void setCor(String cor) {
        if (cor == null) {
            throw new IllegalCorException("cor não pode ser nulo");
        } else {
            cor = cor.trim();
            if (cor.isEmpty()) {
                throw new IllegalCorException("cor não pode ser vazia");
            } else if (cor.length() > 16) {
                throw new IllegalCorException("cor não pode conter mais do que 16 caracteres");
            }
        }
        this.cor = cor;
    }
    
    public String getCor() {
        return this.cor;
    }
    
    // id_cliente
    public void setDono(int id_cliente) {
        if (id_cliente < 0) {
            throw new IllegalIdException("cliente não pode ser nulo");
        } else {
            this.id_cliente = id_cliente;
        }
    }
    
    public int getDono() {
        return this.id_cliente;
    }

    @Override
    public String toString() {
        return String.format("ID_PET: %d | NOME: %s | RAÇA: %s | SEXO: %s | PORTE: %s | COMPORTAMENTO: %s | E_CASTRADO: %s | CAMINHO_CARTAO_VACINACAO: %s | ESTADO_SAUDE: %s | COR: %s | ID_CLIENTE: %d", getId(), getNome(), getRaca(), getSexo().PET, getPorte(), getComportamento(), ((getECastrado()) ? "SIM" : "NÃO"), getCaminhoCartaoVacinacao(), getEstadoSaude(), getCor(), getDono());
         
    }
}
