package com.semillero.asistencias.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.semillero.asistencias.models.FestivoEntity;

@Repository
public interface iFestivoRepository extends JpaRepository<FestivoEntity, Long> {

}
