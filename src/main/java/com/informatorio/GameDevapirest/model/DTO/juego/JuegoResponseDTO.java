package com.informatorio.GameDevapirest.model.DTO.juego;

import com.informatorio.GameDevapirest.model.DTO.desarrollador.DesarrolladorDTO;
import com.informatorio.GameDevapirest.model.DTO.tarea.TareaDTO;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class JuegoResponseDTO {
    private String title;
    private String description;
    private List<DesarrolladorDTO> desarrollador = new ArrayList<>();
    private List<TareaDTO> tarea = new ArrayList<>();
    private String  fechaLanzamiento;
}
