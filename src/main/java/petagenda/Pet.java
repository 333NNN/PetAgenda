package petagenda;

//import java.util.Arrays;
import petagenda.exception.IllegalPorteException;
import petagenda.dados.Endereco;
import petagenda.dados.Porte;
import petagenda.exception.*;
import petagenda.dados.Sexo;
//import petagenda.servico.Servico;
//import petagenda.servico.TipoServico;

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
    private boolean eCastrado;
    private String caminho_cartao_vacinacao;
    private String estado_saude;
    private String cor;
    private Cliente dono;
    
    public Pet(String nome, Cliente dono, String raca, Sexo sexo, Porte porte, boolean eCastrado) {
        this(1, nome, dono, raca, sexo, porte, eCastrado);
        this.id_pet = -1;
    }
    
    public Pet(int id_pet, String nome, Cliente dono, String raca, Sexo sexo, Porte porte, boolean eCastrado) {
        IllegalArgumentsException exs = new IllegalArgumentsException();
        
        try {
            setId(id_pet);
        } catch (IllegalIdException ex) {
            exs.addCause(ex);
        }
        
        try {
            setNome(nome);
        } catch (IllegalNomeException ex) {
            exs.addCause(ex);
        }
        
        try {
            setDono(dono);
        } catch (IllegalClienteException ex) {
            exs.addCause(ex);
        }
        
        try {
            setRaca(raca);
        } catch (IllegalRacaException ex) {
            exs.addCause(ex);
        }
        
        try {
            setSexo(sexo);
        } catch (IllegalSexoException ex) {
            exs.addCause(ex);
        }
        
        try {
            setPorte(porte);
        } catch (IllegalPorteException ex) {
            exs.addCause(ex);
        }
        
        setCastrado(eCastrado);
        
        if (exs.size() > 0) {
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
            } else if (nome.length() > 45) {
                throw new IllegalNomeException("nome não pode conter mais do que 45 caracteres");
            }
            this.nome = nome;
        }
    }
    
    public String getNome() {
        return this.nome;
    }
    
    // raca
    public void setRaca(String raca){
        if (raca == null) {
            throw new IllegalNomeException("raça não pode ser nula");
        }
        raca = raca.trim();
        if (raca.isEmpty()) {
            throw new IllegalNomeException("raça não pode ser vazia");
        } else if (raca.length() > 45) {
            throw new IllegalNomeException("raça não pode conter mais do que 45 caracteres");
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
    
    //    public void setPorte(String porte) {
//        if (porte == null) {
////            throw new IllegalPorteException("porte não pode ser nulo");
//            this.porte = null;
//        } else {
//            porte = porte.trim();
//            if (porte.isEmpty()) {
////                throw new IllegalNomeException("porte não pode ser vazia");
//                this.porte = null;
//            } else if (porte.length() > 16) {
//                throw new IllegalNomeException("porte não pode conter mais do que 20 caracteres");
//            }
//            this.porte = porte;
//        }
//    }
    
    public Porte getPorte() {
        return this.porte;
    }
    
    public String getPorteTexto() {
        return this.porte.getTexto();
    }
    
    // comportamento
    public void setComportamento(String comportamento) {
        if (comportamento == null) {
//            throw new IllegalNomeException("comportamento não pode ser nulo");
            this.comportamento = null;
        } else {
            comportamento = comportamento.trim();
            if (comportamento.isEmpty()) {
//                throw new IllegalNomeException("comportamento não pode ser vazia");
                this.comportamento = null;
            } else if (comportamento.length() > 80) {
                throw new IllegalNomeException("comportamento não pode conter mais do que 80 caracteres");
            }
            this.comportamento = comportamento;
        }
    }
    
    public String getComportamento() {
        return this.comportamento;
    }
    
    // e_castrado
    public void setCastrado(boolean eCastrado) {
        this.eCastrado = eCastrado;
    }
    
    public boolean getECastrado() {
        return this.eCastrado;
    }
    
    // caminho_cartao_vacinacao
    public void setCaminhoCartaoVacinacao(String caminho) {
        if (caminho == null) {
//            throw new IllegalCaminhoCartaoVacinacaoException("caminho do cartão de vacinação não pode ser nulo");
            this.caminho_cartao_vacinacao = null;
        } else {
            caminho = caminho.trim();
            if (caminho.isEmpty()) {
//                throw new IllegalCaminhoCartaoVacinacaoException("caminho do cartão de vacinação não pode ser vazia");
                this.caminho_cartao_vacinacao = null;
            } else if (caminho.length() > 255) {
                throw new IllegalCaminhoCartaoVacinacaoException("caminho do cartão de vacinação não pode conter mais do que 255 caracteres");
            }
            this.caminho_cartao_vacinacao = caminho;
        }
    }
    
    public String getCaminhoCartaoVacinacao() {
        return this.caminho_cartao_vacinacao;
    }
    
    // estado_saude
    public void setEstadoSaude(String estado) {
        if (estado == null) {
//            throw new IllegalNomeException("estado de saúde não pode ser nulo");
            this.estado_saude = null;
        } else {
            estado = estado.trim();
            if (estado.isEmpty()) {
//                throw new IllegalNomeException("estado de saúde não pode ser vazia");
                this.estado_saude = null;
            } else if (estado.length() > 80) {
                throw new IllegalNomeException("estado de saúde não pode conter mais do que 255 caracteres");
            }
            this.estado_saude = estado;
        }
    }
    
    public String getEstadoSaude() {
        return this.estado_saude;
    }
    
    // cor
    public void setCor(String cor) {
        if (cor == null) {
//            throw new IllegalNomeException("cor não pode ser nulo");
            this.cor = null;
        } else {
            cor = cor.trim();
            if (cor.isEmpty()) {
//                throw new IllegalNomeException("cor não pode ser vazia");
                this.cor = null;
            } else if (cor.length() > 16) {
                throw new IllegalNomeException("cor não pode conter mais do que 16 caracteres");
            }
            this.cor = cor;
        }
    }
    
    public String getCor() {
        return this.cor;
    }
    
    // id_cliente
    public void setDono(Cliente dono) {
        if (dono == null) {
            throw new IllegalClienteException("cliente não pode ser nulo");
        } else {
            this.dono = dono;
        }
    }
    
    public Cliente getDono() {
        return this.dono;
    }

    @Override
    public String toString() {
        return String.format("NOME: %s | DONO: %s | RAÇA: %s | SEXO: %s | É CASTRADO: %s", getNome(), getDono().getNome(), getRaca(), getSexo().PET, ((getECastrado()) ? "SIM" : "NÃO"));
    }
}
