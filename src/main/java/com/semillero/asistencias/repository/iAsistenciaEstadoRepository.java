package com.semillero.asistencias.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.semillero.asistencias.models.AsistenciaEstadoEntity;

@Repository
public interface iAsistenciaEstadoRepository extends JpaRepository<AsistenciaEstadoEntity, Long> {

}
