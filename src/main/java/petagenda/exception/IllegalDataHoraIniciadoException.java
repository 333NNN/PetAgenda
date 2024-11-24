/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package petagenda.exception;

/**
 *
 * @author kevin
 */
public class IllegalDataHoraIniciadoException extends ComparableException{
    public IllegalDataHoraIniciadoException() {
        super("data e hora de inicio inválido");
    }
    
    public IllegalDataHoraIniciadoException(String message) {
        super(message);
    }
    
    public IllegalDataHoraIniciadoException(String message, Throwable cause) {
        super(message, cause);
    }
}