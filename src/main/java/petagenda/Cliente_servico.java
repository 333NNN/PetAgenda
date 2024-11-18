/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package petagenda;

import petagenda.exception.IllegalArgumentsException;

/**
 *
 * @author kevin
 */
import petagenda.exception.*;

public final class Cliente_servico {
    private int id_servico;
    private int id_cliente;
    
    public Cliente_servico (int id_servico, int id_cliente) {
        IllegalArgumentsException exs = new IllegalArgumentsException();
        
        // id_servico
        try {
            setIdServico(id_servico);
        }
        catch (IllegalIdException ex) {
            exs.addCause(ex);
        }
        
        // id_cliente
        try {
            setIdCliente(id_cliente);
        }
        catch (IllegalIdException ex) {
            
        }
        
        if (exs.size() > 0) { // Alguma exceção ocorreu.
            throw exs;
        }
    }
    
    // id_servico
    public void setIdServico(int id_servico) {
        if (id_servico < 0) {
            throw new IllegalIdException("Id não pode ser inferior a zero.");
        }
        else {
            this.id_servico = id_servico;
        }
    }
    
    public int getIdServico() {
        return this.id_servico;
    }
    
    // id_cliente
    public void setIdCliente(int id_cliente) {
        if (id_cliente < 0) {
            throw new IllegalIdException("Id não pode ser inferior a zero.");
        }
        else {
            this.id_cliente = id_cliente;
        }
    }
    
    public int getIdCliente() {
        return this.id_cliente;
    }
    
    @Override
    public String toString() {
        return String.format("id_servico: %d | id_cliente: %d", getIdServico(), getIdCliente());
    }
}
