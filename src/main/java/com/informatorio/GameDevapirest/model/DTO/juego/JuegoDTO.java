package com.informatorio.GameDevapirest.model.DTO.juego;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.informatorio.GameDevapirest.domain.Desarrollador;
import com.informatorio.GameDevapirest.domain.Tarea;
import com.informatorio.GameDevapirest.model.DTO.desarrollador.DesarrolladorDTO;
import com.informatorio.GameDevapirest.model.DTO.tarea.TareaDTO;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JuegoDTO {
    private String title;
    private String description;
    //private List<DesarrolladorDTO> desarrollador = new ArrayList<>();
   // private List<TareaDTO> tarea = new ArrayList<>();
    private String  fechaLanzamiento;
}
