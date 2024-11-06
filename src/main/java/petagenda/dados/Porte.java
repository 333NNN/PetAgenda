package petagenda.dados;

/**
 *
 * @author t.baiense
 */
public enum Porte {
    SEL ("SELECIONAR"),
    PEQUENO ("Pequeno (<35cm)"),
    MEDIO ("Médio (<50cm)"),
    GRANDE ("Grande (>50cm)");
    
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
