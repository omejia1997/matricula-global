package ec.edu.espe.arquitectura.matriculaglobal.educacion;

public enum TipoPersonaEnum {

    ESTUDIANTE("ESTUDIANTE", "EST"),
    DOCENTE("DOCENTE", "DOC"),
    SERVIDORPUBLICO("SERVIDORPUBLICO", "SER");

    private final String texto;
    private final String valor;

    private TipoPersonaEnum(String texto, String valor) {
        this.texto = texto;
        this.valor = valor;
    }

    public String getTexto() {
        return this.texto;
    }

    public String getValor() {
        return this.valor;
    }
}
