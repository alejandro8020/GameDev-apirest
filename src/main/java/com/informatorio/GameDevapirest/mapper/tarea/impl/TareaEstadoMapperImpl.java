package com.informatorio.GameDevapirest.mapper.tarea.impl;

import com.informatorio.GameDevapirest.domain.Tarea;
import com.informatorio.GameDevapirest.mapper.tarea.TareaEstadoMapper;
import com.informatorio.GameDevapirest.model.DTO.tarea.TareaEstadoDTO;
import org.springframework.stereotype.Component;

@Component
public class TareaEstadoMapperImpl implements TareaEstadoMapper {
    @Override
    public Tarea tareaDTOToTarea(TareaEstadoDTO tareaDTO) {
        return Tarea.builder()
                .estado(tareaDTO.getEstado())
                .build();
    }
}
