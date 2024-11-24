/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package petagenda.exception;

/**
 *
 * @author kevin
 */
public class IllegalCheckEntregaException extends ComparableException{
    public IllegalCheckEntregaException() {
        super("Check de entrega inválido");
    }
    
    public IllegalCheckEntregaException(String message) {
        super(message);
    }
    
    public IllegalCheckEntregaException(String message, Throwable cause) {
        super(message, cause);
    }
}
