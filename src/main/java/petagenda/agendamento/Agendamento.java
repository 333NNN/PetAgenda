package petagenda.agendamento;

import java.time.LocalDateTime;
import petagenda.exception.*;

/**
 *
 * @author thiago
 */
public final class Agendamento {
    private int id_agendamento;
    private LocalDateTime dt_hr_marcada;
    private int qntPasseios;
    private LocalDateTime dta_hr_iniciado;
    private LocalDateTime dta_hr_finalizado;
    private int check_entrega;
    private String observacao;
    private int id_servico;
    private int id_funcionario;
    
    public static final int NULL_ID = -1;

    
    public Agendamento(LocalDateTime dt_hr_marcada, int qntPasseios, LocalDateTime dta_hr_iniciado, LocalDateTime dta_hr_finalizado, int check_entrega, String observacao, int id_servico, int id_funcionario) {
        this(1, dt_hr_marcada, qntPasseios, dta_hr_iniciado, dta_hr_finalizado, check_entrega, observacao, id_servico, id_funcionario);
        this.id_agendamento = NULL_ID;
    }
    
    public Agendamento(int id_agendamento, LocalDateTime dt_hr_marcada, int qntPasseios, LocalDateTime dta_hr_iniciado, LocalDateTime dta_hr_finalizado, int check_entrega, String observacao, int id_servico, int id_funcionario) {
        IllegalArgumentsException exs = new IllegalArgumentsException();
        
        // id_agedamento
        try {
            setId(id_agendamento);
        } catch (IllegalIdException ex) {
            exs.addCause(ex);
        }

        
        // dt_hr_marcada
        try {
            setDataHoraMarcada(dt_hr_marcada);
        } catch (IllegalDataHoraMarcadaException ex) {
            exs.addCause(ex);
        }
        
        
        // qnt_passeios
        try {
            setQntPasseios(qntPasseios);
        }
        catch (IllegalQuantidadePasseiosException ex) {
            exs.addCause(ex);
        }
        
        // dta_hr_iniciado
        try {
            setDataHoraIniciado(dta_hr_iniciado);
        }
        catch (IllegalDataHoraIniciadoException ex) {
            exs.addCause(ex);
        }
        
        // dta_hr_finalizado
        try {
            setDataHoraFinalizado(dta_hr_finalizado);
        }
        catch (IllegalDataHoraFinalizadoException ex) {
            exs.addCause(ex);
        }
        
        // check_entrega
        try {
            setCheckEntrega(check_entrega);
        }
        catch (IllegalCheckEntregaException ex) {
            exs.addCause(ex);
        }
        
        // observacao
        try {
            setObservacao(observacao);
        }
        catch (IllegalObservacaoException ex) {
            exs.addCause(ex);
        } 
        
        // id_servico
        try {
            setIdServico(id_servico);
        }
        catch (IllegalIdException ex) {
            exs.addCause(ex);
        }
        
        // id_funcionario
        try {
            setIdFuncionario(id_funcionario);
        }
        catch (IllegalIdException ex) {
            exs.addCause(ex);
        }

        
        if (exs.size() > 0) { // Alguma exceção ocorreu
            throw exs;
        }
    }
    
    // id_agendamento
    public void setId(int id_agendamento) {
        if (id_agendamento < 0) {
            throw new IllegalIdException("id_agendamento não pode ser inferior a zero");
        } else {
            this.id_agendamento = id_agendamento;
        }
    }
    
    public int getId() {
        return this.id_agendamento;
    }
    
    
    // dt_hr_marcada
    public void setDataHoraMarcada(LocalDateTime dthr) {
        if (dthr == null) {
            throw new IllegalDataHoraMarcadaException("data e hora marcada não pode ser nula");
        } else {
            this.dt_hr_marcada = dthr;
        }
    }
    
    public LocalDateTime getDataHoraMarcada() {
        return this.dt_hr_marcada;
    }
    
    
    // qnt_passeios
    public void setQntPasseios(int passeios) {
        if (passeios < 0) {
            throw new IllegalQuantidadePasseiosException("quantidade de passeios não pode ser inferior a zero");
        } else {
            this.qntPasseios = passeios;
        }
    }
    
    public int getQntPasseios() {
        return this.qntPasseios;
    }
    
    
    // dta_hr_iniciado
    public void setDataHoraIniciado(LocalDateTime dthr) {
        if (dthr == null) {
            throw new IllegalDataHoraIniciadoException("data e hora marcada não pode ser nula");
        } else {
            this.dta_hr_iniciado = dthr;
        }
    }
    
    public LocalDateTime getDataHoraIniciado() {
        return this.dta_hr_iniciado;
    }
    
    
    // dta_hr_finalizado
    public void setDataHoraFinalizado(LocalDateTime dthr) {
        if (dthr == null) {
            throw new IllegalDataHoraFinalizadoException("data e hora marcada não pode ser nula");
        } else {
            this.dta_hr_finalizado = dthr;
        }
    }
    
    public LocalDateTime getDataHoraFinalizado() {
        return this.dta_hr_finalizado;
    }
    
    
    // check_entrega
    public void setCheckEntrega (int check) {
        if (check < 0 && check > 1) {
           throw new IllegalCheckEntregaException("check de entrega não pode ser diferente de 0 ou 1");
        }
        else {
            this.check_entrega = check;
        }
    }
    
    public int getCheckEntrega () {
        return this.check_entrega;
    }

    
    // observacao
    public void setObservacao(String obs) {
        if (obs != null) {
            obs = obs.trim();
            if (obs.length() > 255) {
                throw new IllegalObservacaoException("observação não pode conter mais do que 255 caracteres.");
            } else if (obs.isEmpty()) {
                obs = null;
            }
        }
        this.observacao = obs;
    }
    
    public String getObservacao() {
        return this.observacao;
    }
    
    
    // id_servico
    public void setIdServico(int id_servico) {
        if (id_servico < 0) {
            throw new IllegalIdException("id_servico não pode ser inferior a zero");
        } else {
            this.id_servico = id_servico;
        }
    }
    
    public int getIdServico() {
        return this.id_servico;
    }
    
    
    // id_funcionario
    public void setIdFuncionario(int id_funcionario) {
        if (id_funcionario < 0) {
            throw new IllegalIdException("id_funcionario não pode ser inferior a zero");
        } else {
            this.id_funcionario = id_funcionario;
        }
    }
    
    public int getIdFuncionario() {
        return this.id_funcionario;
    }
     
    /*
    public void addHorarioAlimentacao(LocalTime horario) {
        if (horario == null) {
            throw new IllegalHorarioAlimentacaoException("horário de alimentação do pet não pode ser nulo");
        } else {
            this.horariosAlimentacao.add(horario);
        }
    }
    
    public void addRemedio(Remedio remedio) {
        if (remedio == null) {
            throw new IllegalHorarioAlimentacaoException("remédio não pode ser nulo");
        } else {
            this.remedios.add(remedio);
        }
    }
    
    public void clearHorariosAlimentacao() {
        this.horariosAlimentacao.clear();
    }
    
    public void clearRemedios() {
        this.remedios.clear();
    }
    */
    
    /*public int getHorariosAlimentacaoCount() {
        return this.horariosAlimentacao.size();
    }
    
    public LocalTime[] getHorariosAlimentacao() {
        return this.horariosAlimentacao.toArray(new LocalTime[getHorariosAlimentacaoCount()]);
    }
    
    public LocalTime getHorarioAlimentacao(int index) {
        return this.horariosAlimentacao.get(index);
    }
    
    public int getRemediosCount() {
        return this.remedios.size();
    }
    
    public Remedio[] getRemedios() {
        if (getRemediosCount() > 0) {
            return this.remedios.toArray(new Remedio[getRemediosCount()]);
        } else {
            return null;
        }
    }
    
    public Remedio getRemedio(int index) {
        return this.remedios.get(index);
    }
    
    public void removeHorarioAlimentacao(int index) {
        this.horariosAlimentacao.remove(index);
    }
    
    public void removeRemedio(int index) {
        this.remedios.remove(index);
    }
    */


    
    
    /*
    public void setHorariosAlimentacao(LocalTime... horarios) {
        this.clearHorariosAlimentacao();
        if (horarios != null) {
            for (LocalTime h : horarios) {
                if (h != null) {
                    this.addHorarioAlimentacao(h);
                }
            }
        }
    }
    
    public void setRemedios(Remedio... remedios) {
        this.clearRemedios();
        if (remedios != null) {
            for (Remedio r : remedios) {
                if (r != null) {
                    this.addRemedio(r);
                }
            }
        }
    }
*/
    
    @Override
    public String toString() {
        return String.format("ID_AGENDAMENTO: %d | DT_HR_MARCADA: %s | QNT_PASSEIOS: %d | DTA_HR_INICIADO: %s | DTA_HR_FINALIZADO: %s | CHECK_ENTREGA: %d | OBSERVACAO: %s | ID_SERVICO: %d | ID_FUNCIONARIO: %d", 
                getId(), getDataHoraMarcada().toString(), getQntPasseios(), getDataHoraIniciado().toString(), getDataHoraFinalizado().toString(),
                getCheckEntrega(), getObservacao(), getIdServico(), getIdFuncionario());
    }
}
