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

import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.NrcHorario;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.NrcHorarioPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface NrcHorarioRepository extends JpaRepository<NrcHorario, NrcHorarioPK> {

    List<NrcHorario> findByHoraInicio(Date horaInicio);
    List<NrcHorario> findByHoraFin(Date horaFin);
    List<NrcHorario> findByCodAulaAndDiaSemana(Integer codAula, String diaSemana);
    List<NrcHorario> findByCodMateria(Integer codMateria);
}