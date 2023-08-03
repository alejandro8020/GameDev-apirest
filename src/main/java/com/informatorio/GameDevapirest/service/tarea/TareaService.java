package com.informatorio.GameDevapirest.service.tarea;

import com.informatorio.GameDevapirest.domain.Tarea;
import com.informatorio.GameDevapirest.model.DTO.tarea.TareaDTO;

import java.util.List;

public interface TareaService {
    List<TareaDTO> getAllTarea();
    Tarea createTarea(TareaDTO tareaDTO);
}
