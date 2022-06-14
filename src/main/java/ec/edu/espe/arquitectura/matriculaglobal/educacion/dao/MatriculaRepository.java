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
package ec.edu.espe.arquitectura.matriculaglobal.educacion.dao;

import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.Matricula;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.MatriculaPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface MatriculaRepository extends JpaRepository<Matricula, MatriculaPK> {
    List<Matricula> findByTipo(String tipo);
    List<Matricula> findByFechaGreaterThan(Date fechaMatricula);
    List<Matricula> findByPkCodPersonaOrderByCodPeriodo(Integer codPersona);
    List<Matricula> findByPkCodPersonaAndCodPeriodo(Integer codPersona, Integer codPeriodo);
    List<Matricula> findByCodCarreraAndCodPeriodo(Integer codCarrera, Integer codPeriodo);
}