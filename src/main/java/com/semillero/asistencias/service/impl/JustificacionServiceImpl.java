package com.semillero.asistencias.service.impl;

import java.sql.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.semillero.asistencias.dto.request.JustificacionActionRequestDto;
import com.semillero.asistencias.dto.request.JustificacionRequestDto;
import com.semillero.asistencias.dto.response.JustificacionResponseDto;
import com.semillero.asistencias.repository.iJustificacionRepository;
import com.semillero.asistencias.service.iJustificacionService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class JustificacionServiceImpl implements iJustificacionService {

    private final EntityManager entityManager;
    private final iJustificacionRepository justificacionRepository;

    public JustificacionServiceImpl(EntityManager entityManager, iJustificacionRepository justificacionRepository) {
        this.entityManager =  entityManager;
        this.justificacionRepository = justificacionRepository;
    }

    @Override
    public JustificacionResponseDto solicitar(JustificacionRequestDto dto) {
        StoredProcedureQuery sp = entityManager.createStoredProcedureQuery("justificaciones_pkg.crear_justificacion");

        sp.registerStoredProcedureParameter("p_id_usuario", Long.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("p_fecha", Date.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("p_id_tipo", Long.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("p_comentario", String.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("p_id_justificacion", Long.class, ParameterMode.OUT);

        log.info("""
                WASHA     AAAAAAAAA
        """+ dto.getFecha().toString());
        sp.setParameter("p_id_usuario", dto.getIdUsuario());
        sp.setParameter("p_fecha", dto.getFecha());
        sp.setParameter("p_id_tipo", dto.getIdTipo());
        sp.setParameter("p_comentario", dto.getComentario());
        sp.execute();

        log.info("Justificacion SOLICITADA PARA USUARIO {}", dto.getIdUsuario());

        Long idJustificacion = (Long) sp.getOutputParameterValue("p_id_justificacion");
        return getById(idJustificacion);
    }

    

    @Override
    public JustificacionResponseDto aprobar(JustificacionActionRequestDto dto) {
        StoredProcedureQuery sp = entityManager.createStoredProcedureQuery("justificaciones_pkg.aprobar_justificacion");
        sp.registerStoredProcedureParameter("p_id_justificacion", Long.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("id_admin", Long.class, ParameterMode.IN);

        sp.setParameter("p_id_justificacion", dto.getIdJustificacion());
        sp.setParameter("id_admin", dto.getIdAdmin());
        sp.execute();

        log.info("Justificacion APROBADA CON ID {}", dto.getIdJustificacion());

        return getById(dto.getIdJustificacion());

    }

    @Override
    public JustificacionResponseDto rechazar(JustificacionActionRequestDto dto) {
        StoredProcedureQuery sp = entityManager.createStoredProcedureQuery("justificaciones_pkg.rechazar_justificacion");
        sp.registerStoredProcedureParameter("p_id_justificacion", Long.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("id_admin", Long.class, ParameterMode.IN);

        sp.setParameter("p_id_justificacion", dto.getIdJustificacion());
        sp.setParameter("id_admin", dto.getIdAdmin());
        sp.execute();

        log.info("Justificacion RECHAZADA CON ID {}", dto.getIdJustificacion());

        return getById(dto.getIdJustificacion());
    }

    @Override
    public JustificacionResponseDto getById(Long id) {
        return justificacionRepository.findDtoByID(id).orElseThrow(() -> new RuntimeException("Justificacion no encontrada con ID: " + id));
    }

    @Override
    public Page<JustificacionResponseDto> findAllDtoPageable(Integer page, Integer size, Long idEstado) {
        Pageable pageable = PageRequest.of(page, size);
        Page<JustificacionResponseDto> justificacionesPage = justificacionRepository.findAllDtoPageable(pageable, idEstado);
        return new PageImpl<>(justificacionesPage.getContent(), pageable, justificacionesPage.getTotalElements());
    };

    


    
}
