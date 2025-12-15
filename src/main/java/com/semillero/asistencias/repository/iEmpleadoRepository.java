package com.semillero.asistencias.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.semillero.asistencias.models.EmpleadoEntity;

@Repository
public interface iEmpleadoRepository extends JpaRepository<EmpleadoEntity, Long> {

}
