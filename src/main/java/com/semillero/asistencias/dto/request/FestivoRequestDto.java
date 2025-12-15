package com.semillero.asistencias.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
public class FestivoRequestDto {

    @NotBlank
    @Min(1)
    @Max(31)
    private Byte dia;

    @NotBlank
    @Min(1)
    @Max(12)
    private Byte mes;

    @NotBlank
    private Boolean mcaRepetible;

    @NotBlank
    @Size(max = 200)
    private String descripcion;

    @NotBlank
    private LocalDate fechaEfecto;
}
