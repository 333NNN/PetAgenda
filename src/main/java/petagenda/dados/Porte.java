package petagenda.dados;

/**
 *
 * @author t.baiense
 */
public enum Porte {
    PEQUENO ("Pequeno"),
    MÉDIO ("Médio"),
    GRANDE ("Grande");
    
    public final String texto;
    
    private Porte(String texto) {
        this.texto = texto;
    }
    
     @Override
    public String toString() {
        return this.texto;
    }

    public String getTexto() {
        return this.texto;
    }
}
