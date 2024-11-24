/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package petagenda.exception;

/**
 *
 * @author kevin
 */
public class IllegalEstadoSaudeException extends ComparableException {
    public IllegalEstadoSaudeException () {
        super("estado de saude é inválido");
    }
    
    public IllegalEstadoSaudeException(String message) {
        super(message);
    }
    
    public IllegalEstadoSaudeException(String message, Throwable cause) {
        super(message, cause);
    }
}
