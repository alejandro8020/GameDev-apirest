package com.informatorio.GameDevapirest.service.tarea;

import com.informatorio.GameDevapirest.domain.Tarea;
import com.informatorio.GameDevapirest.exception.NotFoundException;
import com.informatorio.GameDevapirest.model.DTO.desarrollador.DesarrolladorDTO;
import com.informatorio.GameDevapirest.model.DTO.tarea.TareaDTO;
import com.informatorio.GameDevapirest.model.DTO.tarea.TareaResponseDTO;

import java.util.List;
import java.util.Optional;

public interface TareaService {
    List<TareaResponseDTO> getAllTarea();
    Tarea createTarea(TareaDTO tareaDTO) throws NotFoundException;

}
