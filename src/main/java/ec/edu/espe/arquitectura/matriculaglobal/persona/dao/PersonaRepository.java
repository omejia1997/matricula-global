/*
 * Copyright 2022 Bryan.
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
package ec.edu.espe.arquitectura.matriculaglobal.persona.dao;

import ec.edu.espe.arquitectura.matriculaglobal.persona.model.Persona;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Integer>{
    Persona findByIdentificacion(String identificacion);
    List<Persona> findByNombreCompletoLikeOrderByApellido1(String nombreCompleto);
    List<Persona> findByGeneroOrderByApellido1(String genero);
    List<Persona> findByDiscapacidadOrderByApellido1(String discapacidad);
    List<Persona> findByFechaNacimientoGreaterThanOrderByApellido1(Date fechaNacimiento);
    Persona findByEmail(String email);
    Persona findByEmailAlterno(String emailAlterno);
    List<Persona> findByEstadoOrderByApellido1(String estado);   
}
