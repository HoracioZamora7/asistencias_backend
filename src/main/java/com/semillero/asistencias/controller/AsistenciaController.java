package com.semillero.asistencias.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.semillero.asistencias.dto.response.AsistenciaResponseDto;
import com.semillero.asistencias.service.iAsistenciaService;

@RestController
@RequestMapping("/asistencia")
public class AsistenciaController {

    private final iAsistenciaService asistenciaService;

    public AsistenciaController(iAsistenciaService asistenciaService) {
        this.asistenciaService = asistenciaService;
    }

    @PreAuthorize("hasRole('EMPLEADO') or hasRole('ADMIN')")
    @PostMapping("/checkin")
    public ResponseEntity<AsistenciaResponseDto> checkIn(@RequestBody Long idUsuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(asistenciaService.checkIn(idUsuario));
    }

    @PreAuthorize("hasRole('EMPLEADO') or hasRole('ADMIN')")
    @PostMapping("/checkout")
    public ResponseEntity<AsistenciaResponseDto> checkOut(@RequestBody Long idUsuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(asistenciaService.checkOut(idUsuario));
    }

    @PreAuthorize("hasRole('EMPLEADO') or hasRole('ADMIN')")
    @GetMapping("/fecha_actual/{idUsuario}")
    public ResponseEntity<Optional<AsistenciaResponseDto>> getByIdUsuarioAndFechaActual(@PathVariable Long idUsuario) {
        return ResponseEntity.status(HttpStatus.OK).body(asistenciaService.findByIdUsuarioAndFechaActual(idUsuario));
    }

}