package petagenda.dados;

/**
 *
 * @author thiago
 */
public enum Sexo {
    M ("M", "Masculino"),
    F ("F", "Feminino");

    public final String PET;
    public final String HUMANO;
    
    // Tipo usado para indicar o contexto (pet ou humano)
    private String tipoExibicao;

    private Sexo(String pet, String humano) {
        this.PET = pet;
        this.HUMANO = humano;
    }

    // Definir o tipo de exibição
    public void setTipoExibicao(String tipo) {
        this.tipoExibicao = tipo;
    }

    @Override
    public String toString() {
        if ("PET".equals(tipoExibicao)) {
            return PET;  // Exibe "Macho" ou "Fêmea" para pets
        } 
        else {
            return HUMANO; // Exibe "Masculino" ou "Feminino" para humanos
        }
    }
}

