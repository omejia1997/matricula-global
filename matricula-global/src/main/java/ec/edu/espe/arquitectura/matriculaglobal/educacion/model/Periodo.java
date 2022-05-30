/*
 * Copyright 2022 User.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ec.edu.espe.arquitectura.matriculaglobal.educacion.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "edu_periodo")

public class Periodo implements Serializable {

    private static final long serialVersionUID = 12345L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_periodo", nullable = false)
    private Integer codPeriodo;
    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;
    @Column(name = "nivel", nullable = false, length = 32)
    private String nivel;
    @Column(name = "fecha_inicio", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fecha_fin", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Column(name = "parciales", nullable = false)
    private short parciales;

    public Periodo() {
    }

    public Periodo(Integer codPeriodo) {
        this.codPeriodo = codPeriodo;
    }

    public Integer getCodPeriodo() {
        return codPeriodo;
    }

    public void setCodPeriodo(Integer codPeriodo) {
        this.codPeriodo = codPeriodo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public short getParciales() {
        return parciales;
    }

    public void setParciales(short parciales) {
        this.parciales = parciales;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPeriodo != null ? codPeriodo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof Periodo)) {
            return false;
        }
        Periodo other = (Periodo) object;
        if ((this.codPeriodo == null && other.codPeriodo != null) || (this.codPeriodo != null && !this.codPeriodo.equals(other.codPeriodo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ codPeriodo=" + codPeriodo + " ]";
    }

}
