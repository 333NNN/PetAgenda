/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package petagenda.agendamento;

import java.time.LocalTime;
import petagenda.exception.IllegalArgumentsException;
import petagenda.exception.IllegalHoraAdministrarException;
import petagenda.exception.IllegalHorarioAlimentacaoException;
import petagenda.exception.IllegalIdException;

/**
 *
 * @author kevin
 */
public  final class alimentacao {
    private int id_hr_alim_agend;
    private LocalTime horario;
    private int id_agendamento;
    
    public static final int NULL_ID = -1;
    
    public alimentacao (LocalTime horario, int id_agendamento) {
        this(1, horario, id_agendamento);
        this.id_hr_alim_agend = NULL_ID;
    }
    
    public alimentacao (int id_hr_alim_agend, LocalTime horario, int id_agendamento) {
        IllegalArgumentsException exs = new IllegalArgumentsException();
        
        // id_hr_alim_agend
        try {
            setId(id_hr_alim_agend);
        }
        catch (IllegalIdException ex) {
            exs.addCause(ex);
        }
        
        // horario
        try {
            setHorario(horario);
        } catch (IllegalHorarioAlimentacaoException ex) {
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
   
    // id_hr_alim_agend
    public void setId(int id_hr_alim_agend) {
        if (id_hr_alim_agend < 0) {
            throw new IllegalIdException("id_remedio_agend não pode ser inferior a zero");
        } else {
            this.id_hr_alim_agend = id_hr_alim_agend;
        }
    }
    
    public int getId() {
        return this.id_hr_alim_agend;
    }
    
    
    // horario
    public void setHorario(LocalTime horario) {
        if (horario == null) {
            throw new IllegalHorarioAlimentacaoException("hora de adminstrar o remédio não pode ser nula");
        } else {
            this.horario = horario;
        }
    }
    
    public LocalTime getHorario() {
        return this.horario;
    }
    
    
    // id_agendamento
    public void setIdAgendamento(int id_agendamento) {
        if (id_agendamento < 0) {
            throw new IllegalIdException("id_remedio_agend não pode ser inferior a zero");
        } else {
            this.id_agendamento = id_agendamento;
        }
    }
    
    public int getIdAgendamento() {
        return this.id_agendamento;
    }
    
    @Override
    public String toString() {
        return String.format("ID_HR_ALIM_AGEND: %d | HORARIO: %s | ID_AGENDAMENTO: %d", 
               getId(), getHorario().toString(), getIdAgendamento());
    }
}
