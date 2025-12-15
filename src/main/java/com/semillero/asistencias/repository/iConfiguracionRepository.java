package com.semillero.asistencias.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.semillero.asistencias.models.ConfiguracionEntity;

@Repository
public interface iConfiguracionRepository extends JpaRepository<ConfiguracionEntity, Long> {

}
