package com.semillero.asistencias.service;

import java.util.Optional;

import com.semillero.asistencias.dto.response.AsistenciaResponseDto;

public interface iAsistenciaService {

    AsistenciaResponseDto checkIn(Long idUsuario);
    AsistenciaResponseDto checkOut(Long idUsuario);
    Optional<AsistenciaResponseDto> findByIdUsuarioAndFechaActual(Long idUsuario);

}
