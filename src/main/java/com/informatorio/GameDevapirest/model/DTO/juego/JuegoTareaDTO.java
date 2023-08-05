package com.informatorio.GameDevapirest.model.DTO.juego;

import com.informatorio.GameDevapirest.model.DTO.desarrollador.DesarrolladorResponseDTO;
import com.informatorio.GameDevapirest.model.DTO.tarea.TareaResponseDTO;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class JuegoTareaDTO {
    private String title;
    private String description;
    private List<TareaResponseDTO> tarea = new ArrayList<>();
}
