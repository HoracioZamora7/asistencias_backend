package com.semillero.asistencias.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.semillero.asistencias.dto.request.JustificacionActionRequestDto;
import com.semillero.asistencias.dto.request.JustificacionRequestDto;
import com.semillero.asistencias.dto.response.JustificacionResponseDto;
import com.semillero.asistencias.service.iJustificacionService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/asistencia")
public class JustificacionController {

    private final iJustificacionService justificacionService;
    public JustificacionController(iJustificacionService justificacionService) {
        this.justificacionService = justificacionService;
    }

    @PreAuthorize("hasRole('EMPLEADO') or hasRole('ADMIN')")
    @PostMapping("justificaciones_solicitud")
    public ResponseEntity<JustificacionResponseDto> solicitar(@RequestBody JustificacionRequestDto dto) {
        log.info(dto.getFecha().toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(justificacionService.solicitar(dto));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("justificaciones_aprobar")
    public ResponseEntity<JustificacionResponseDto> aprobar(@RequestBody JustificacionActionRequestDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(justificacionService.aprobar(dto));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("justificaciones_rechazar")
    public ResponseEntity<JustificacionResponseDto> rechazar(@RequestBody JustificacionActionRequestDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(justificacionService.rechazar(dto));
    }

    @PreAuthorize("hasRole('EMPLEADO') or hasRole('ADMIN')")
    @GetMapping("/justificaciones/{id}")
    public ResponseEntity<JustificacionResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(justificacionService.getById(id));
    }

    @PreAuthorize("hasRole('EMPLEADO') or hasRole('ADMIN')")
    @GetMapping("/justificaciones")
    public ResponseEntity<Page<JustificacionResponseDto>> findAllDtoPageable(@RequestParam Integer page, @RequestParam Integer size, @RequestParam(required = false) Long idEstado) {
        return ResponseEntity.status(HttpStatus.OK).body(justificacionService.findAllDtoPageable(page, size, idEstado));
    }


}
