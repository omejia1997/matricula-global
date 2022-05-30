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
import javax.persistence.*;

@Embeddable
public class DocumentoPersonaPK implements Serializable {

    @Column(name = "cod_persona", nullable = false)
    private int codPersona;
    @Column(name = "cod_tipo_documento", nullable = false, length = 16)
    private String codTipoDocumento;

    public DocumentoPersonaPK() {
    }

    public DocumentoPersonaPK(int codPersona, String codTipoDocumento) {
        this.codPersona = codPersona;
        this.codTipoDocumento = codTipoDocumento;
    }

    public int getCodPersona() {
        return codPersona;
    }

    public void setCodPersona(int codPersona) {
        this.codPersona = codPersona;
    }

    public String getCodTipoDocumento() {
        return codTipoDocumento;
    }

    public void setCodTipoDocumento(String codTipoDocumento) {
        this.codTipoDocumento = codTipoDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codPersona;
        hash += (codTipoDocumento != null ? codTipoDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof DocumentoPersonaPK)) {
            return false;
        }
        DocumentoPersonaPK other = (DocumentoPersonaPK) object;
        if (this.codPersona != other.codPersona) {
            return false;
        }
        if ((this.codTipoDocumento == null && other.codTipoDocumento != null) || (this.codTipoDocumento != null && !this.codTipoDocumento.equals(other.codTipoDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "documentoPersonaPK[ codPersona=" + codPersona + ", codTipoDocumento=" + codTipoDocumento + " ]";
    }
    
}
