package ec.edu.espe.arquitectura.matriculaglobal.seguridad;

public enum EstadoRegistroSesionEnum {
    
    SATISFACTORIO("SAT", "Satisfactorio"),
    FALLIDO("FAL", "Fallido");

    private final String valor;
    private final String texto;

    private EstadoRegistroSesionEnum(String valor, String texto) {
        this.valor = valor;
        this.texto = texto;
    }

    public String getTexto() {
        return this.texto;
    }

    public String getValor() {
        return this.valor;
    }
}
