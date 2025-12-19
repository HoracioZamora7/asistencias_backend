package com.semillero.asistencias.service.impl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.semillero.asistencias.dto.response.AsistenciaResponseDto;
import com.semillero.asistencias.dto.response.HistorialAsistenciaDto;
import com.semillero.asistencias.repository.iAsistenciaRepository;
import com.semillero.asistencias.service.iAsistenciaService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AsistenciaServiceImpl implements iAsistenciaService {
    
    private final EntityManager entityManager;
    private final iAsistenciaRepository asistenciaRepository;

    public AsistenciaServiceImpl(EntityManager entityManager, iAsistenciaRepository asistenciaRepository) {
        this.entityManager =  entityManager;
        this.asistenciaRepository = asistenciaRepository;
    };

    @Override
    public AsistenciaResponseDto checkIn(Long idUsuario) {
        StoredProcedureQuery sp = entityManager.createStoredProcedureQuery("asistencias_pkg.check_in");
        
        sp.registerStoredProcedureParameter("p_id_usuario", Long.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("p_id_asistencia", Long.class, ParameterMode.OUT);

        sp.setParameter("p_id_usuario", idUsuario);
        sp.execute();

        log.info("Check-in eJECUTADO PARA USUARIO {}", idUsuario);

        Long idAsistencia = (Long) sp.getOutputParameterValue("p_id_asistencia");
        return asistenciaRepository.findDtoById(idAsistencia).orElseThrow(() -> new RuntimeException("Error al recuperar la asistencia registrada."));
    }

    @Override
    public AsistenciaResponseDto checkOut(Long idUsuario) {
        StoredProcedureQuery sp = entityManager.createStoredProcedureQuery("asistencias_pkg.check_out");

        sp.registerStoredProcedureParameter("p_id_usuario", Long.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("p_id_asistencia", Long.class, ParameterMode.OUT);

        sp.setParameter("p_id_usuario", idUsuario);
        sp.execute();

        log.info("Check-out eJECUTADO PARA USUARIO {}", idUsuario);

        Long idAsistencia = (Long) sp.getOutputParameterValue("p_id_asistencia");
        return asistenciaRepository.findDtoById(idAsistencia).orElseThrow(() -> new RuntimeException("Error al recuperar la asistencia registrada."));
    }

    @Override
    public Optional<AsistenciaResponseDto> findByIdUsuarioAndFechaActual(Long idUsuario) {
        return asistenciaRepository.findByIdUsuarioAndFechaActual(idUsuario, LocalDate.now());
    }

    @Override
    public Page<HistorialAsistenciaDto> getHistorialByIdUsuario(Long idUsuario, Integer page, Integer size, LocalDate fechaInicio, LocalDate fechaFin) {
        Pageable pageable = org.springframework.data.domain.PageRequest.of(page, size);
        return asistenciaRepository.findHistorialByUsuarioPageable(idUsuario, fechaInicio, fechaFin, pageable);
    }

}
