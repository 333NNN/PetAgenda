/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package petagenda.agendamento;

import petagenda.exception.IllegalArgumentsException;
import petagenda.exception.IllegalIdException;

/**
 *
 * @author kevin
 */
public final class Pet_agendamento {
    private int id_agendamento;
    private int id_pet_agend;
    
    public Pet_agendamento(int id_agendamento, int id_pet_agend) {
        IllegalArgumentsException exs = new IllegalArgumentsException();

        // id_agendamento
        try {
            setIdAgendamento(id_agendamento);
        }
        catch (IllegalIdException ex) {
            exs.addCause(ex);
        }
        
        // id_pet
        try {
            setIdPet(id_pet_agend);
        }
        catch (IllegalIdException ex) {
            
        }
        
        if (exs.size() > 0) { // Alguma exceção ocorreu.
            throw exs;
        }
    }
    
    // id_agendamento
    public void setIdAgendamento(int id_agendamento) {
        if (id_agendamento < 0) {
            throw new IllegalIdException("Id_agendamento não pode ser inferior a zero.");
        }
        else {
            this.id_agendamento = id_agendamento;
        }
    }
    
    public int getIdAgendamento() {
        return this.id_agendamento;
    }
    
    // id_pet_agend
    public void setIdPet(int id_pet_agend) {
        if (id_pet_agend < 0) {
            throw new IllegalIdException("Id_pet não pode ser inferior a zero.");
        }
        else {
            this.id_pet_agend = id_pet_agend;
        }
    }
    
    public int getIdPet() {
        return this.id_pet_agend;
    }
    
    @Override
    public String toString() {
        return String.format("ID_AGENDAMENTO: %d | ID_PET_AGENDADO: %d", getIdAgendamento(), getIdPet());
    }
}
