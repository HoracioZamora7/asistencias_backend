package com.semillero.asistencias.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotNull
    private LocalDate fecha;
    
    @NotBlank
    private Long idTipo;

    @Size(max = 200)
    private String comentario;

    public JustificacionRequestDto(Long idUsuario, String fecha, Long idTipo, String comentario) {
        this.idUsuario = idUsuario;
        this.fecha = LocalDate.parse(fecha);
        this.idTipo = idTipo;
        this.comentario = comentario;
    }
}
