package com.informatorio.GameDevapirest.mapper.juego.impl;

import com.informatorio.GameDevapirest.domain.Desarrollador;
import com.informatorio.GameDevapirest.domain.Juego;
import com.informatorio.GameDevapirest.domain.Tarea;
import com.informatorio.GameDevapirest.mapper.desarrollador.DesarrolladorResponseMapper;
import com.informatorio.GameDevapirest.mapper.juego.JuegoTareaMapper;
import com.informatorio.GameDevapirest.mapper.tarea.TareaResponseMapper;
import com.informatorio.GameDevapirest.model.DTO.desarrollador.DesarrolladorResponseDTO;
import com.informatorio.GameDevapirest.model.DTO.juego.JuegoResponseDTO;
import com.informatorio.GameDevapirest.model.DTO.juego.JuegoTareaDTO;
import com.informatorio.GameDevapirest.model.DTO.tarea.TareaResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class JuegoTareaMapperImpl implements JuegoTareaMapper {
    private final TareaResponseMapper tareaResponseMapper;
    @Override
    public JuegoTareaDTO juegoToJuegoTareaDTO(Juego juego) {
        JuegoTareaDTO juegoTareaDTO = JuegoTareaDTO.builder()
                .title(juego.getTitle())
                .description(juego.getDescription())
                .build();
        juegoTareaDTO.setTarea(getTareaDTOS(juego.getTarea()));
        return juegoTareaDTO;
    }
    private List<TareaResponseDTO> getTareaDTOS(List<Tarea> tarea){
        List<TareaResponseDTO> tareaResponseDTO = new ArrayList<>();

        for (Tarea tareas:tarea) {
            tareaResponseDTO.add(tareaResponseMapper.tareaToTareaResponseDTO(tareas));
        }
        return tareaResponseDTO;
    }
}
