package com.informatorio.GameDevapirest.mapper.tarea;

import com.informatorio.GameDevapirest.domain.Tarea;
import com.informatorio.GameDevapirest.model.DTO.tarea.TareaDTO;
import com.informatorio.GameDevapirest.model.DTO.tarea.TareaResponseDTO;

public interface TareaResponseMapper {
    TareaResponseDTO tareaToTareaResponseDTO(Tarea tarea);
}
