package com.semillero.asistencias.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.semillero.asistencias.models.HorarioDetalleEntity;

@Repository
public interface iHorarioDetalleRepository extends JpaRepository<HorarioDetalleEntity, Long> {

}
