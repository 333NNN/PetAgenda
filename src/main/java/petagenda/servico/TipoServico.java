package petagenda.servico;

import java.util.ArrayList;
import petagenda.bd.BD;
import petagenda.exception.IllegalArgumentsException;
import petagenda.exception.IllegalIdException;
import petagenda.exception.IllegalNomeException;

/** Representa os diferentes tipos de serviços disponíveis para agendamento.
 * Cada {@code TipoServico} possui um {@link #id id) e um {@link #nome nome},
 * referentes às informações do banco de dados. <br>
 * 
 * Antes de ser utilizada, as constantes precisam ser inicializadas usando o
 * método estático {@link #init() init()}.
 * @author Thiago M. Baiense
 */
public class TipoServico {
    public static final TipoServico ATENDIMENTO_DOMESTICO = new TipoServico();
    public static final TipoServico CUIDADO_ESPECIAL = new TipoServico();
    public static final TipoServico PASSEIO = new TipoServico();
    
    public static final int NULL_ID = -1;
    
    private String nome;
    private int id;
    
    // Carrega as constantes estáticas do banco
    public static void init() {
        TipoServico[] tipos = BD.TipoServico.selectAll();
        if (tipos == null) {
            System.out.println("AVISO: banco de dados retornou 0 TipoServicos cadastrados ou não foi possível conectar ao banco.");
            return; 
        }
        
        for (TipoServico t : tipos) {
            if (t != null) {
                switch (t.getId()) {
                    case 1 -> {
                        ATENDIMENTO_DOMESTICO.id = t.getId();
                        ATENDIMENTO_DOMESTICO.nome = t.getNome();
                    }
                    case 2 -> {
                        CUIDADO_ESPECIAL.id = t.getId();
                        CUIDADO_ESPECIAL.nome = t.getNome();
                    }
                    case 3 -> {
                        PASSEIO.id = t.getId();
                        PASSEIO.nome = t.getNome();
                    }
                    default -> {
                        System.out.print("Tipo serviço desconhecido recebido do BD: id " + t.getId());
                    }
                }
            }
        }
        
    }
    
    private TipoServico() {
        this.id = NULL_ID;
    }
    
    public TipoServico(String nome) {
        this(1, nome);
        this.id = NULL_ID;
    }
    
    public TipoServico(int id, String nome) {
        IllegalArgumentsException exs;
        ArrayList<Throwable> tList = null;
        if (id < 0) {
            tList = new ArrayList<Throwable>();
            tList.add(new IllegalIdException("id nao pode ser menor que zero"));
        }
        if (nome == null) {
            if (tList == null) {
                tList = new ArrayList<Throwable>();
            }
            tList.add(new IllegalNomeException("nome nao pode ser nulo"));
        }
        nome = nome.trim();
        
        if (nome.isEmpty()) {
            if (tList == null) {
                tList = new ArrayList<Throwable>();
            }
            tList.add(new IllegalNomeException("nome nao pode ser vazio"));
        } else if (nome.length() > 45) {
            if (tList == null) {
                tList = new ArrayList<Throwable>();
            }
            tList.add(new IllegalNomeException("nome nao pode conter mais do que 45 caracteres"));
        }
        if (tList == null) {
            this.id = id;
            this.nome = nome;
        } else {
            throw new IllegalArgumentsException("um ou mais argumentos são inválidos", tList.toArray(new Throwable[tList.size()]));
        }
    }
    
    public int getId() {
        return this.id;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public static TipoServico[] values() {
        return new TipoServico[] {ATENDIMENTO_DOMESTICO, CUIDADO_ESPECIAL, PASSEIO};
    }
    
    @Override
    public String toString() {
        return this.getNome();
    }
    
    public TipoServico valueOf(int id) {
        if (id == ATENDIMENTO_DOMESTICO.getId()) {
            return ATENDIMENTO_DOMESTICO;
        } else if (id == CUIDADO_ESPECIAL.getId()) {
            return CUIDADO_ESPECIAL;
        } else if (id == PASSEIO.getId()) {
            return PASSEIO;
        } else {
            return null;
        }
    }
    
    public static TipoServico valueOfNome(String nome) {
        if (nome.equals(ATENDIMENTO_DOMESTICO.getNome()))
            return ATENDIMENTO_DOMESTICO;
        else if (nome.equals(CUIDADO_ESPECIAL.getNome()))
            return CUIDADO_ESPECIAL;
        else if (nome.equals(PASSEIO.getNome()))
            return PASSEIO;
        else 
            return null;
    }
    
    // Carregamento automático das constantes estáticas. Roda apenas quando a classe for carregada pela primeira vez durante a execução do software
    static {
        TipoServico.init();
    }
}