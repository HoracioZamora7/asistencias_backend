package com.semillero.asistencias.dto.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JustificacionRequestDto {
    
    @NotBlank
    private Long idUsuario;

    @NotBlank
    private LocalDateTime fecha;
    
    @NotBlank
    private Long idTipo;

    @Size(max = 200)
    private String comentario;
}
