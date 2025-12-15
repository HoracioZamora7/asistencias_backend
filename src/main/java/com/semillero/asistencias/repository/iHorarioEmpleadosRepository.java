package com.semillero.asistencias.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.semillero.asistencias.models.HorarioEmpleadosEntity;

@Repository
public interface iHorarioEmpleadosRepository extends JpaRepository<HorarioEmpleadosEntity, Long> {

}
