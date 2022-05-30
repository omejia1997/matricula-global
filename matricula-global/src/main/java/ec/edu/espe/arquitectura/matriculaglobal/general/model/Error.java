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
package ec.edu.espe.arquitectura.matriculaglobal.general.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "gen_error")

public class Error implements Serializable {

    private static final long serialVersionUID = 64751L;
    @Id
    @Column(name = "cod_error", nullable = false, length = 5)
    private String codError;
    @Column(name = "titulo", nullable = false, length = 255)
    private String titulo;
    @Column(name = "descripcion", nullable = false, length = 1000)
    private String descripcion;

    public Error() {
    }

    public Error(String codError) {
        this.codError = codError;
    }

    public String getCodError() {
        return codError;
    }

    public void setCodError(String codError) {
        this.codError = codError;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codError != null ? codError.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof Error)) {
            return false;
        }
        Error other = (Error) object;
        if ((this.codError == null && other.codError != null) || (this.codError != null && !this.codError.equals(other.codError))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ codError=" + codError + " ]";
    }
    
}
