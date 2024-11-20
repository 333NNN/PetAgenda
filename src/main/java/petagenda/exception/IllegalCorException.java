/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package petagenda.exception;

/**
 *
 * @author kevin
 */
public class IllegalCorException extends ComparableException{
    public IllegalCorException () {
        super("cor é inválida");
    }
    
    public IllegalCorException(String message) {
        super(message);
    }
    
    public IllegalCorException(String message, Throwable cause) {
        super(message, cause);
    }
}
