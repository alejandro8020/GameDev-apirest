package com.informatorio.GameDevapirest.model.DTO.tarea;

import com.informatorio.GameDevapirest.enumeration.tarea.TareaEnum;
import com.informatorio.GameDevapirest.model.DTO.desarrollador.DesarrolladorDTO;
import com.informatorio.GameDevapirest.model.DTO.juego.JuegoDTO;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TareaResponseDTO {
    private String descripcion;
    private TareaEnum estado;
    private String fechaLimite;
}
