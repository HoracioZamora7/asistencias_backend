package com.semillero.asistencias.service;

import org.springframework.data.domain.Page;

import com.semillero.asistencias.dto.request.JustificacionActionRequestDto;
import com.semillero.asistencias.dto.request.JustificacionRequestDto;
import com.semillero.asistencias.dto.response.JustificacionResponseDto;

public interface iJustificacionService {

    JustificacionResponseDto solicitar(JustificacionRequestDto dto);
    JustificacionResponseDto aprobar(JustificacionActionRequestDto dto);
    JustificacionResponseDto rechazar(JustificacionActionRequestDto dto);
    JustificacionResponseDto getById(Long id);
    Page<JustificacionResponseDto> findAllDtoPageable(Integer page, Integer size, Long idEstado);

}
