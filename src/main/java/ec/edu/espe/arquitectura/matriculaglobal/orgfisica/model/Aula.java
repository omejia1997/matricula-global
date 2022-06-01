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
package ec.edu.espe.arquitectura.matriculaglobal.orgfisica.model;

import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.NrcHorario;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "ofi_aula")
public class Aula implements Serializable {

    private static final long serialVersionUID = 123432L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_aula", nullable = false)
    private Integer codAula;
    @Column(name = "cod_tipo_aula", nullable = false)
    private String codTipoAula;
    @Column(name = "cod_edificio", nullable = false)
    private String codEdificio;
    @Column(name = "cod_edificio_bloque", nullable = false)
    private String codEdificioBloque;
    @Column(name = "cod_alterno", nullable = false, length = 10)
    private String codAlterno;
    @Column(name = "capacidad", nullable = false)
    private Integer capacidad;
    @Column(name = "piso", nullable = false)
    private Integer piso;
    @Column(name = "aud_usuario", nullable = false, length = 30)
    private String audUsuario;
    @Column(name = "aud_fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date audFecha;
    @Column(name = "aud_ip", nullable = false, length = 30)
    private String audIp;
    @Column(name = "version", nullable = false)
    private Integer version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aula")
    private List<NrcHorario> nrcHorarioList;
    @JoinColumn(name = "cod_edificio", referencedColumnName = "cod_edificio", nullable = false, insertable = false, updatable = false)
    @ManyToOne
    private Edificio edificio;
    @JoinColumn(name = "cod_edificio_bloque", referencedColumnName = "cod_edificio_bloque", nullable = false, insertable = false, updatable = false)
    @ManyToOne
    private EdificioBloque edificioBloque;
    @JoinColumn(name = "cod_tipo_aula", referencedColumnName = "cod_tipo_aula", nullable = false, insertable = false, updatable = false)
    @ManyToOne
    private TipoAula tipoAula;

    public Aula() {
    }

    public Aula(Integer codAula) {
        this.codAula = codAula;
    }

    public Integer getCodAula() {
        return codAula;
    }

    public void setCodAula(Integer codAula) {
        this.codAula = codAula;
    }

    public String getCodTipoAula() {
        return codTipoAula;
    }

    public void setCodTipoAula(String codTipoAula) {
        this.codTipoAula = codTipoAula;
    }
    
    public String getCodEdificio() {
        return codEdificio;
    }

    public void setCodEdificio(String codEdificio) {
        this.codEdificio = codEdificio;
    }

    public String getCodEdificioBloque() {
        return codEdificioBloque;
    }

    public void setCodEdificioBloque(String codEdificioBloque) {
        this.codEdificioBloque = codEdificioBloque;
    }
    
    
    public String getCodAlterno() {
        return codAlterno;
    }

    public void setCodAlterno(String codAlterno) {
        this.codAlterno = codAlterno;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Integer getPiso() {
        return piso;
    }

    public void setPiso(Integer piso) {
        this.piso = piso;
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public List<NrcHorario> getNrcHorarioList() {
        return nrcHorarioList;
    }

    public void setNrcHorarioList(List<NrcHorario> nrcHorarioList) {
        this.nrcHorarioList = nrcHorarioList;
    }

    public Edificio getEdificio() {
        return edificio;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }

    public EdificioBloque getEdificioBloque() {
        return edificioBloque;
    }

    public void setEdificioBloque(EdificioBloque edificioBloque) {
        this.edificioBloque = edificioBloque;
    }

    public TipoAula getTipoAula() {
        return tipoAula;
    }

    public void setTipoAula(TipoAula tipoAula) {
        this.tipoAula = tipoAula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codAula != null ? codAula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof Aula)) {
            return false;
        }
        Aula other = (Aula) object;
        if ((this.codAula == null && other.codAula != null) || (this.codAula != null && !this.codAula.equals(other.codAula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ codAula=" + codAula + " ]";
    }

}
