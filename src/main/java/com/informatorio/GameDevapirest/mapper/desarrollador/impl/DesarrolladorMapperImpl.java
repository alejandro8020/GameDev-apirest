package com.informatorio.GameDevapirest.mapper.desarrollador.impl;

import com.informatorio.GameDevapirest.domain.Desarrollador;
import com.informatorio.GameDevapirest.mapper.desarrollador.DesarrolladorMapper;
import com.informatorio.GameDevapirest.model.DTO.desarrollador.DesarrolladorDTO;

import java.util.UUID;

public class DesarrolladorMapperImpl implements DesarrolladorMapper {
    @Override
    public Desarrollador desarrolladorDTOToDesarrollador(DesarrolladorDTO desarrolladorDTO) {
        return Desarrollador.builder()
                .uuid(UUID.randomUUID())
                .name(desarrolladorDTO.getName())
                .mail(desarrolladorDTO.getMail())
                .rol(desarrolladorDTO.getRol())
                .build();
    }

    @Override
    public DesarrolladorDTO desarrolladorToDesarrolladorDTO(Desarrollador desarrollador) {
        return DesarrolladorDTO.builder()
                .name(desarrollador.getName())
                .mail(desarrollador.getMail())
                .rol(desarrollador.getRol())
                .build();
    }
}
