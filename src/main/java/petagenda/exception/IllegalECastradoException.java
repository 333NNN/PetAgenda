/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package petagenda.exception;

/**
 *
 * @author kevin
 */
public class IllegalECastradoException extends ComparableException {
    public IllegalECastradoException() {
        super("cidade inválida");
        super.order_index = 9;
    }
    
    public IllegalECastradoException(String message) {
        super(message);
        super.order_index = 9;
    }
    
    public IllegalECastradoException(String message, Throwable cause) {
        super(message, cause);
    }
}