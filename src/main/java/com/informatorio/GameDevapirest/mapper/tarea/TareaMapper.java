package com.informatorio.GameDevapirest.mapper.tarea;


import com.informatorio.GameDevapirest.domain.Tarea;
import com.informatorio.GameDevapirest.model.DTO.tarea.TareaDTO;

public interface TareaMapper {
    Tarea tareaDTOToTarea(TareaDTO tareaDTO);
    TareaDTO tareaToTareaDTO(Tarea tarea);
}
