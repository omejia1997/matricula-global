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

import ec.edu.espe.arquitectura.matriculaglobal.general.model.Pais;
import ec.edu.espe.arquitectura.matriculaglobal.general.model.UbicacionGeografica;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.Matricula;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "per_persona")
public class Persona implements Serializable {

    private static final long serialVersionUID = 134234L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_persona", nullable = false)
    private Integer codPersona;
    @Column(name = "codigo_alterno", nullable = false, length = 15)
    private String codigoAlterno;
    @Column(name = "cod_tipo_persona", nullable = false, length = 3)
    private String codTipoPersona;
    @Column(name = "cod_tipo_discapacidad", nullable = false, length = 8)
    private String codTipoDiscapacidad;
    @Column(name = "cod_pais_nacimiento", nullable = false, length = 2)
    private String codPaisNacimiento;
    @Column(name = "tipo_identificacion", nullable = false, length = 3)
    private String tipoIdentificacion;
    @Column(name = "identificacion", nullable = false, length = 20)
    private String identificacion;
    @Column(name = "nombre1", nullable = false, length = 32)
    private String nombre1;
    @Column(name = "nombre2", length = 32)
    private String nombre2;
    @Column(name = "apellido1", nullable = false, length = 32)
    private String apellido1;
    @Column(name = "apellido2", length = 32)
    private String apellido2;
    @Column(name = "nombre_completo", nullable = false, length = 128)
    private String nombreCompleto;
    @Column(name = "nombre_comun", length = 64)
    private String nombreComun;
    @Column(name = "genero", nullable = false, length = 3)
    private String genero;
    @Column(name = "fecha_nacimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Column(name = "estado_civil", nullable = false, length = 3)
    private String estadoCivil;
    @Column(name = "email", nullable = false, length = 128)
    private String email;
    @Column(name = "email_alterno", length = 128)
    private String emailAlterno;
    @Column(name = "estado", nullable = false, length = 3)
    private String estado;
    @Column(name = "telefono_movil", length = 20)
    private String telefonoMovil;
    @Column(name = "extranjero", nullable = false, length = 1)
    private String extranjero;
    @Column(name = "requiere_representante", nullable = false, length = 1)
    private String requiereRepresentante;
    @Column(name = "discapacidad", nullable = false, length = 1)
    private String discapacidad;
    @Column(name = "porcentaje_discapacidad")
    private Integer porcentajeDiscapacidad;
    @Column(name = "carnet_conadis", length = 10)
    private String carnetConadis;
    @Column(name = "aud_usuario", nullable = false, length = 30)
    private String audUsuario;
    @Column(name = "aud_fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date audFecha;
    @Column(name = "aud_ip", nullable = false, length = 30)
    private String audIp;
    @Column(name = "version", nullable = false)
    private Integer version;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pk.codPersona")
    private List<DireccionPersona> direccionPersonaList;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pk.codPersona")
    private List<Matricula> matriculaList;
    @JsonIgnore
    @JoinColumn(name = "cod_pais_nacimiento", referencedColumnName = "cod_pais", nullable = false, insertable = false, updatable = false)
    @ManyToOne
    private Pais paisNacimiento;
    @JsonIgnore
    @JoinColumn(name = "nacionalidad", referencedColumnName = "cod_pais")
    @ManyToOne(optional = false)
    private Pais nacionalidad;
    @JsonIgnore
    @JoinColumn(name = "lugar_nacimiento", referencedColumnName = "cod_ubicacion_geo_int", nullable = false)
    @ManyToOne(optional = false)
    private UbicacionGeografica lugarNacimiento;
    @JsonIgnore
    @JoinColumn(name = "cod_tipo_discapacidad", referencedColumnName = "cod_tipo_discapacidad", insertable = false, updatable = false)
    @ManyToOne
    private TipoDiscapacidad tipoDiscapacidad;
    @JsonIgnore
    @JoinColumn(name = "cod_tipo_persona", referencedColumnName = "cod_tipo_persona" , insertable = false, updatable = false)
    @ManyToOne
    private TipoPersona tipoPersona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pk.codPersona")
    private List<DocumentoPersona> documentoPersonaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pk.codPersona")
    private List<FamiliarPersona> familiarPersonaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pk.codPersona")
    private List<HistTipoPersona> histTipoPersonaList;

    public Persona() {
    }

    public Persona(Integer codPersona) {
        this.codPersona = codPersona;
    }

    public Integer getCodPersona() {
        return codPersona;
    }

    public void setCodPersona(Integer codPersona) {
        this.codPersona = codPersona;
    }

    public String getCodigoAlterno() {
        return codigoAlterno;
    }

    public void setCodigoAlterno(String codigoAlterno) {
        this.codigoAlterno = codigoAlterno;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getCodPaisNacimiento() {
        return codPaisNacimiento;
    }

    public void setCodPaisNacimiento(String codPaisNacimiento) {
        this.codPaisNacimiento = codPaisNacimiento;
    }
    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNombreComun() {
        return nombreComun;
    }

    public void setNombreComun(String nombreComun) {
        this.nombreComun = nombreComun;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailAlterno() {
        return emailAlterno;
    }

    public void setEmailAlterno(String emailAlterno) {
        this.emailAlterno = emailAlterno;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    public String getExtranjero() {
        return extranjero;
    }

    public void setExtranjero(String extranjero) {
        this.extranjero = extranjero;
    }

    public String getRequiereRepresentante() {
        return requiereRepresentante;
    }

    public void setRequiereRepresentante(String requiereRepresentante) {
        this.requiereRepresentante = requiereRepresentante;
    }

    public String getDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(String discapacidad) {
        this.discapacidad = discapacidad;
    }

    public Integer getPorcentajeDiscapacidad() {
        return porcentajeDiscapacidad;
    }

    public void setPorcentajeDiscapacidad(Integer porcentajeDiscapacidad) {
        this.porcentajeDiscapacidad = porcentajeDiscapacidad;
    }

    public String getCarnetConadis() {
        return carnetConadis;
    }

    public void setCarnetConadis(String carnetConadis) {
        this.carnetConadis = carnetConadis;
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
    
    public List<DireccionPersona> getDireccionPersonaList() {
        return direccionPersonaList;
    }

    public void setDireccionPersonaList(List<DireccionPersona> direccionPersonaList) {
        this.direccionPersonaList = direccionPersonaList;
    }

    public List<Matricula> getMatriculaList() {
        return matriculaList;
    }

    public void setMatriculaList(List<Matricula> matriculaList) {
        this.matriculaList = matriculaList;
    }
    public String getCodTipoPersona() {
        return codTipoPersona;
    }

    public void setCodTipoPersona(String codTipoPersona) {
        this.codTipoPersona = codTipoPersona;
    }

    public String getCodTipoDiscapacidad() {
        return codTipoDiscapacidad;
    }

    public void setCodTipoDiscapacidad(String codTipoDiscapacidad) {
        this.codTipoDiscapacidad = codTipoDiscapacidad;
    }
    
    public Pais getPaisNacimiento() {
        return paisNacimiento;
    }

    public void setPaisNacimiento(Pais paisNacimiento) {
        this.paisNacimiento = paisNacimiento;
    }

    public Pais getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(Pais nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public UbicacionGeografica getLugarNacimiento() {
        return lugarNacimiento;
    }

    public void setLugarNacimiento(UbicacionGeografica lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
    }

    public TipoDiscapacidad getTipoDiscapacidad() {
        return tipoDiscapacidad;
    }

    public void setTipoDiscapacidad(TipoDiscapacidad tipoDiscapacidad) {
        this.tipoDiscapacidad = tipoDiscapacidad;
    }

    public TipoPersona getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(TipoPersona tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public List<DocumentoPersona> getDocumentoPersonaList() {
        return documentoPersonaList;
    }

    public void setDocumentoPersonaList(List<DocumentoPersona> documentoPersonaList) {
        this.documentoPersonaList = documentoPersonaList;
    }

    public List<FamiliarPersona> getFamiliarPersonaList() {
        return familiarPersonaList;
    }

    public void setFamiliarPersonaList(List<FamiliarPersona> familiarPersonaList) {
        this.familiarPersonaList = familiarPersonaList;
    }

    public List<HistTipoPersona> getHistTipoPersonaList() {
        return histTipoPersonaList;
    }

    public void setHistTipoPersonaList(List<HistTipoPersona> histTipoPersonaList) {
        this.histTipoPersonaList = histTipoPersonaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPersona != null ? codPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.codPersona == null && other.codPersona != null) || (this.codPersona != null && !this.codPersona.equals(other.codPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ codPersona=" + codPersona + " ]";
    }    
}
