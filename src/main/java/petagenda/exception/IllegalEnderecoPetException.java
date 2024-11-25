/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package petagenda.exception;

/**
 *
 * @author kevin
 */
public class IllegalEnderecoPetException extends ComparableException {
    public IllegalEnderecoPetException () {
        super("Endereço pet é inválida");
    }
    
    public IllegalEnderecoPetException(String message) {
        super(message);
    }
    
    public IllegalEnderecoPetException(String message, Throwable cause) {
        super(message, cause);
    }
}
