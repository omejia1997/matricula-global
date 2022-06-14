package ec.edu.espe.arquitectura.matriculaglobal.educacion;

public enum MatriculaTipoEnum {

    PRIMERA(1),
    SEGUNDA(2),
    TERCERA(3);

    private final Integer valor;

    private MatriculaTipoEnum(Integer valor) {
        this.valor = valor;
    }

    public Integer getValor() {
        return this.valor;
    }
    
}
