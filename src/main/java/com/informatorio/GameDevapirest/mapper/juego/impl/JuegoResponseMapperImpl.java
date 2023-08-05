package com.informatorio.GameDevapirest.mapper.juego.impl;

import com.informatorio.GameDevapirest.domain.Desarrollador;
import com.informatorio.GameDevapirest.domain.Juego;
import com.informatorio.GameDevapirest.domain.Tarea;
import com.informatorio.GameDevapirest.mapper.desarrollador.DesarrolladorResponseMapper;
import com.informatorio.GameDevapirest.mapper.juego.JuegoResponseMapper;
import com.informatorio.GameDevapirest.mapper.tarea.TareaResponseMapper;
import com.informatorio.GameDevapirest.model.DTO.desarrollador.DesarrolladorResponseDTO;
import com.informatorio.GameDevapirest.model.DTO.juego.JuegoResponseDTO;
import com.informatorio.GameDevapirest.model.DTO.tarea.TareaResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
@AllArgsConstructor
public class JuegoResponseMapperImpl implements JuegoResponseMapper {
    private final DesarrolladorResponseMapper desarrolladorResponseMapper;
    @Override
    public JuegoResponseDTO juegoToJuegoResponseDTO(Juego juego) {
        JuegoResponseDTO juegoResponseDTO = JuegoResponseDTO.builder()
                .title(juego.getTitle())
                .description(juego.getDescription())
                .build();
        juegoResponseDTO.setDesarrollador(getDesarrolladorDTOS(juego.getDesarrollador()));
        return juegoResponseDTO;
    }
    private List<DesarrolladorResponseDTO> getDesarrolladorDTOS(List<Desarrollador> desarrollador){
        List<DesarrolladorResponseDTO> desarrolladorResponseDTO = new ArrayList<>();

        for (Desarrollador desarrolladores:desarrollador) {
            desarrolladorResponseDTO.add(desarrolladorResponseMapper.DesarrolladorToDesarrolladorResponseDTO(desarrolladores));
        }
        return desarrolladorResponseDTO;
    }
}
