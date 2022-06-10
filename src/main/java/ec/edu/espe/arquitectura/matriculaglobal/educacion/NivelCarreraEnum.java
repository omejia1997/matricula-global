package ec.edu.espe.arquitectura.matriculaglobal.educacion;

public enum NivelCarreraEnum {

    PREGRADO("Pregrado"),
    SUFICIENCIA("Suficiencia"),
    LINEA("Linea");

    private final String texto;

    private NivelCarreraEnum(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return this.texto;
    }
    
}
