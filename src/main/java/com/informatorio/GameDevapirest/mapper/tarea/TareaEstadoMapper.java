package com.informatorio.GameDevapirest.mapper.tarea;

import com.informatorio.GameDevapirest.domain.Tarea;
import com.informatorio.GameDevapirest.model.DTO.tarea.TareaEstadoDTO;

public interface TareaEstadoMapper {
    Tarea tareaDTOToTarea(TareaEstadoDTO tareaDTO);
}
