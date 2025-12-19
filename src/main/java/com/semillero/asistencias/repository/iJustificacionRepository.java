package com.semillero.asistencias.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.semillero.asistencias.dto.response.JustificacionResponseDto;

import com.semillero.asistencias.models.JustificacionEntity;

public interface iJustificacionRepository extends JpaRepository<JustificacionEntity, Long> {

    @Query("""
        SELECT new com.semillero.asistencias.dto.response.JustificacionResponseDto(
            j.id,
            j.fecha,
            u.id,
            u.username,
            concat(e.nombre, ' ', e.apellidoPaterno),
            e.dni,
            t.nombre,
            j.comentario,
            est.nombre,
            j.fechaRevision
        )
        FROM JustificacionEntity j
        JOIN j.usuario u
        JOIN u.empleado e
        JOIN j.tipoJustificacion t
        JOIN j.estado est
        WHERE j.id = :id
        """)
    Optional<JustificacionResponseDto> findDtoByID(@Param("id") Long id);


    @Query("""
            SELECT new com.semillero.asistencias.dto.response.JustificacionResponseDto(
                j.id,
                j.fecha,
                u.id,
                u.username,
                CONCAT(e.nombre, ' ', e.apellidoPaterno),
                e.dni,
                t.nombre,
                j.comentario,
                est.nombre,
                j.fechaRevision
            )
            FROM JustificacionEntity j
            JOIN j.usuario u
            JOIN u.empleado e
            JOIN j.tipoJustificacion t
            JOIN j.estado est
            WHERE (:idEstado IS NULL OR est.id = :idEstado)
            ORDER BY j.fecha DESC
        """)
    Page<JustificacionResponseDto> findAllDtoPageable(Pageable pageable, Long idEstado);


}
