package com.semillero.asistencias.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.semillero.asistencias.dto.response.AsistenciaResponseDto;
import com.semillero.asistencias.models.AsistenciaEntity;

@Repository
public interface iAsistenciaRepository extends JpaRepository<AsistenciaEntity, Long> {

      @Query("""
        SELECT new com.semillero.asistencias.dto.response.AsistenciaResponseDto(
            a.id,
            u.id,
            CONCAT(e.nombre, ' ', e.apellidoPaterno),
            e.dni,
            a.fecha,
            a.horaEntrada,
            a.horaSalida,
            a.mcaJustificada,
            s.nombre
        )
        FROM AsistenciaEntity a
        JOIN a.usuario u
        JOIN u.empleado e
        JOIN a.estado s
        WHERE a.id = :id
    """)
    Optional<AsistenciaResponseDto> findDtoById(@Param("id") Long id);
    

    @Query("""
        SELECT new com.semillero.asistencias.dto.response.AsistenciaResponseDto(
            a.id,
            u.id,
            CONCAT(e.nombre, ' ', e.apellidoPaterno),
            e.dni,
            a.fecha,
            a.horaEntrada,
            a.horaSalida,
            a.mcaJustificada,
            s.nombre
        )
        FROM AsistenciaEntity a
        JOIN a.usuario u
        JOIN u.empleado e
        JOIN a.estado s
        WHERE u.id = :id_usuario AND a.fecha = :fecha_actual
    """)
    Optional<AsistenciaResponseDto> findByIdUsuarioAndFechaActual(@Param("id_usuario") Long idUsuario, @Param("fecha_actual") LocalDate fechaActual);
}
