package com.informatorio.GameDevapirest.mapper.desarrollador.impl;

import com.informatorio.GameDevapirest.domain.Desarrollador;
import com.informatorio.GameDevapirest.domain.Tarea;
import com.informatorio.GameDevapirest.mapper.desarrollador.DesarrolladorResponseMapper;
import com.informatorio.GameDevapirest.mapper.tarea.TareaResponseMapper;
import com.informatorio.GameDevapirest.model.DTO.desarrollador.DesarrolladorDTO;
import com.informatorio.GameDevapirest.model.DTO.desarrollador.DesarrolladorResponseDTO;
import com.informatorio.GameDevapirest.model.DTO.tarea.TareaDTO;
import com.informatorio.GameDevapirest.model.DTO.tarea.TareaResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class DesarrolladorResponseMapperimpl implements DesarrolladorResponseMapper {
    private final TareaResponseMapper tareaResponseMapper;
    @Override
    public DesarrolladorResponseDTO DesarrolladorToDesarrolladorResponseDTO(Desarrollador desarrollador) {

        DesarrolladorResponseDTO desarrolladorResponseDTO = DesarrolladorResponseDTO.builder()
                .name(desarrollador.getName())
                .rol(desarrollador.getRol())
                .build();
        desarrolladorResponseDTO.setTareaResponseDTOS(getTareasDTOS(desarrollador.getTarea()));
        return desarrolladorResponseDTO;

    }

    private List<TareaResponseDTO> getTareasDTOS(List<Tarea> tarea){
        List<TareaResponseDTO> tareaResponseDTO = new ArrayList<>();

        for (Tarea tareas:tarea) {
            tareaResponseDTO.add(tareaResponseMapper.tareaToTareaResponseDTO(tareas));
        }
        return tareaResponseDTO;
    }


}
