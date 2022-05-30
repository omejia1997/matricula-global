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
@Table(name = "gen_institucion")

public class InstitucionGeneral implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ruc", nullable = false, length = 13)
    private String ruc;
    @Column(name = "cod_ubicacion_geo_int", nullable = false)
    private Integer codUbicacionGeoInt;
    @Column(name = "razon_social", nullable = false, length = 128)
    private String razonSocial;
    @Column(name = "nombre_comercial", nullable = false, length = 128)
    private String nombreComercial;
    @Column(name = "direccion", nullable = false, length = 255)
    private String direccion;
    @Column(name = "dominio", nullable = false, length = 64)
    private String dominio;
    @Column(name = "url_info", length = 128)
    private String urlInfo;
    @Column(name = "url_sistema", nullable = false, length = 128)
    private String urlSistema;
    @Column(name = "version", nullable = false)
    private int version;
    @JoinColumn(name = "cod_ubicacion_geo_int", referencedColumnName = "cod_ubicacion_geo_int", insertable = false, updatable = false)
    @ManyToOne
    private UbicacionGeografica ubicacionGeoInt;

    public InstitucionGeneral() {
    }

    public InstitucionGeneral(String ruc) {
        this.ruc = ruc;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public Integer getCodUbicacionGeoInt() {
        return codUbicacionGeoInt;
    }

    public void setCodUbicacionGeoInt(Integer codUbicacionGeoInt) {
        this.codUbicacionGeoInt = codUbicacionGeoInt;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public String getUrlInfo() {
        return urlInfo;
    }

    public void setUrlInfo(String urlInfo) {
        this.urlInfo = urlInfo;
    }

    public String getUrlSistema() {
        return urlSistema;
    }

    public void setUrlSistema(String urlSistema) {
        this.urlSistema = urlSistema;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public UbicacionGeografica getUbicacionGeoInt() {
        return ubicacionGeoInt;
    }

    public void setUbicacionGeoInt(UbicacionGeografica ubicacionGeoInt) {
        this.ubicacionGeoInt = ubicacionGeoInt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ruc != null ? ruc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof InstitucionGeneral)) {
            return false;
        }
        InstitucionGeneral other = (InstitucionGeneral) object;
        if ((this.ruc == null && other.ruc != null) || (this.ruc != null && !this.ruc.equals(other.ruc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ ruc=" + ruc + " ]";
    }
    
}
