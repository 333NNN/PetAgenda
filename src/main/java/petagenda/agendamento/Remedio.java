package petagenda.agendamento;

import java.time.LocalTime;
import petagenda.exception.IllegalAgendamentoException;
import petagenda.exception.IllegalArgumentsException;
import petagenda.exception.IllegalHoraAdministrarException;
import petagenda.exception.IllegalIdException;
import petagenda.exception.IllegalInstrucoesException;
import petagenda.exception.IllegalNomeException;

/**
 *
 * @author thiago
 */
public final class Remedio {
    private int id_remedio_agend;
    private String nome;
    private LocalTime horaAdministrar;
    private String instrucoes;
    private int id_agendamento;
    
    public static final int NULL_ID = -1;
    
    public Remedio (String nome, LocalTime horaAdministrar, String instrucoes, int id_agendamento) {
        this(1, nome, horaAdministrar, instrucoes, id_agendamento);
        this.id_remedio_agend = NULL_ID;
    }
    
    public Remedio (int id_remedio_agend, String nome, LocalTime horaAdministrar, String instrucoes, int id_agendamento) {
        IllegalArgumentsException exs = new IllegalArgumentsException();
    
        // id_remedio_agend
        try {
            setId(id_remedio_agend);
        } catch (IllegalIdException ex) {
            exs.addCause(ex);
        }
        
        // nome_remedio
        try {
            setNome(nome);
        } catch (IllegalNomeException ex) {
            exs.addCause(ex);
        }
        
        // hr_administrar
        try {
            setHoraAdministrar(horaAdministrar);
        } catch (IllegalHoraAdministrarException ex) {
            exs.addCause(ex);
        }
        
        // instrucoes
        try {
            setInstrucoes(instrucoes);
        } catch (IllegalInstrucoesException ex) {
            exs.addCause(ex);
        }
        
        // id_agendamento
        try {
            setIdAgendamento(id_agendamento);
        } catch (IllegalIdException ex) {
            exs.addCause(ex);
        }
        
        if (exs.size() > 0) {
            throw exs;
        }
    }
    
    // id_remedio_agend
    public void setId(int id_remedio_agend) {
        if (id_remedio_agend < 0) {
            throw new IllegalIdException("id_remedio_agend não pode ser inferior a zero");
        } else {
            this.id_remedio_agend = id_remedio_agend;
        }
    }
    
    public int getId() {
        return this.id_remedio_agend;
    }
    
    // nome_remedio
    public void setNome(String nome) {
        if (nome == null) {
            throw new IllegalNomeException("nome não pode ser nulo");
        } else {
            nome = nome.trim();
            if (nome.isEmpty()) {
                throw new IllegalNomeException("nome não pode ser vazio");
            } else if (nome.length() > 64) {
                throw new IllegalNomeException("nome não pode conter mais do que 64 caracteres");
            } else {
                this.nome = nome;
            }
        }
    }
    
    public String getNome() {
        return this.nome;
    }
    
    // hr_administrar
    public void setHoraAdministrar(LocalTime hr) {
        if (hr == null) {
            throw new IllegalHoraAdministrarException("hora de adminstrar o remédio não pode ser nula");
        } else {
            this.horaAdministrar = hr;
        }
    }
    
    public LocalTime getHoraAdministrar() {
        return this.horaAdministrar;
    }
    
    // instrucoes
    public void setInstrucoes(String instrucoes) {
        if (instrucoes == null) {
            this.instrucoes = null;
        } else {
            instrucoes = instrucoes.trim();
            if (instrucoes.isEmpty()) {
                this.instrucoes = null;
            } else if (instrucoes.length() > 120) {
                throw new IllegalInstrucoesException("instruções não podem conter mais do que 120 caracteres");
            } else {
                this.instrucoes = instrucoes;
            }
        }
    }
    
    public String getInstrucoes() {
        return this.instrucoes;
    }
    
    // id_agendamento
    public void setIdAgendamento(int id_agendamento) {
        if (id_agendamento < 0) {
            throw new IllegalIdException("id_agendamento não pode ser inferior a zero");
        } else {
            this.id_agendamento = id_agendamento;
        }
    }
    
    public int getIdAgendamento() {
        return this.id_agendamento;
    }
    
    
    @Override
    public String toString() {
        return String.format("ID_REMEDIO_AGEND: %d | NOME_REMEDIO: %s | HR_ADMINISTRAR: %s | INSTRUCOES: %s | ID_AGENDAMENTO: %d", 
               getId(), getNome(), getHoraAdministrar().toString(), getInstrucoes(), getIdAgendamento());
    }
}
