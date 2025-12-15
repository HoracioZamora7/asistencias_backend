package com.semillero.asistencias.dto.response;



import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FestivoResponseDto {

    private Long id;
    private Byte dia;
    private Byte mes;
    private Boolean mcaRepetible;
    private String descripcion;
    private String fechaEfecto;

    public FestivoResponseDto(Long id, Byte dia, Byte mes, char mcaRepetible, String descripcion, LocalDate fechaEfecto) {
        this.id = id;
        this.dia = dia;
        this.mes = mes;
        this.mcaRepetible = mcaRepetible == 'S' ? true : false;
        this.descripcion = descripcion;
        this.fechaEfecto = fechaEfecto.toString();
    }

}
