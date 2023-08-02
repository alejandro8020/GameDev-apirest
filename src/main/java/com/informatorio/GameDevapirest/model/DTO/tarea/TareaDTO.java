package com.informatorio.GameDevapirest.model.DTO.tarea;

import com.informatorio.GameDevapirest.domain.Desarrollador;
import com.informatorio.GameDevapirest.domain.Juego;
import com.informatorio.GameDevapirest.enumeration.tarea.TareaEnum;
import com.informatorio.GameDevapirest.model.DTO.desarrollador.DesarrolladorDTO;
import com.informatorio.GameDevapirest.model.DTO.juego.JuegoDTO;

import java.time.LocalDateTime;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TareaDTO {
    private String descripcion;
    private TareaEnum estado;
    private String fechaLimite;
    private DesarrolladorDTO desarrolladorDTO;
    private JuegoDTO juegoDTO;
}
