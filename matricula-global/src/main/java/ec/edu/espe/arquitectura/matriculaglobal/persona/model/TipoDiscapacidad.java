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
package ec.edu.espe.arquitectura.matriculaglobal.persona.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "per_tipo_discapacidad")

public class TipoDiscapacidad implements Serializable {

    private static final long serialVersionUID = 16565L;
    @Id
    @Column(name = "cod_tipo_discapacidad", nullable = false, length = 8)
    private String codTipoDiscapacidad;
    @Column(name = "nombre", nullable = false, length = 64)
    private String nombre;
    @Column(name = "aud_usuario", nullable = false, length = 30)
    private String audUsuario;
    @Column(name = "aud_fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date audFecha;
    @Column(name = "aud_ip", nullable = false, length = 30)
    private String audIp;
    @Column(name = "version", nullable = false)
    private int version;
    
    public TipoDiscapacidad() {
    }

    public TipoDiscapacidad(String codTipoDiscapacidad) {
        this.codTipoDiscapacidad = codTipoDiscapacidad;
    }

    public String getCodTipoDiscapacidad() {
        return codTipoDiscapacidad;
    }

    public void setCodTipoDiscapacidad(String codTipoDiscapacidad) {
        this.codTipoDiscapacidad = codTipoDiscapacidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAudUsuario() {
        return audUsuario;
    }

    public void setAudUsuario(String audUsuario) {
        this.audUsuario = audUsuario;
    }

    public Date getAudFecha() {
        return audFecha;
    }

    public void setAudFecha(Date audFecha) {
        this.audFecha = audFecha;
    }

    public String getAudIp() {
        return audIp;
    }

    public void setAudIp(String audIp) {
        this.audIp = audIp;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTipoDiscapacidad != null ? codTipoDiscapacidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof TipoDiscapacidad)) {
            return false;
        }
        TipoDiscapacidad other = (TipoDiscapacidad) object;
        if ((this.codTipoDiscapacidad == null && other.codTipoDiscapacidad != null) || (this.codTipoDiscapacidad != null && !this.codTipoDiscapacidad.equals(other.codTipoDiscapacidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ codTipoDiscapacidad=" + codTipoDiscapacidad + " ]";
    }
    
}
