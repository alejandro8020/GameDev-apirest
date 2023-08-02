package com.informatorio.GameDevapirest.mapper.juego.impl;

import com.informatorio.GameDevapirest.domain.Desarrollador;
import com.informatorio.GameDevapirest.domain.Juego;
import com.informatorio.GameDevapirest.mapper.juego.JuegoMapper;
import com.informatorio.GameDevapirest.model.DTO.juego.JuegoDTO;

import java.time.LocalDateTime;
import java.util.UUID;

public class JuegoMapperImpl implements JuegoMapper {

    @Override
    public Juego juegoDTOToJuego(JuegoDTO juegoDTO) {
        return Juego.builder()
                .uuid(UUID.randomUUID())
                .title(juegoDTO.getTitle())
                .description(juegoDTO.getDescription())
                .fechaLanzamiento(getLocalDateTime(juegoDTO.getFechaLanzamiento()))
                .build();
    }

    @Override
    public JuegoDTO juegoToJuegoDTO(Juego juego) {
        return JuegoDTO.builder()
                .title(juego.getTitle())
                .description(juego.getDescription())
                .fechaLanzamiento(getLocalDateTime(juego.getFechaLanzamiento()))
                .build();
    }

    private LocalDateTime getLocalDateTime(String date){
        if (!date.isBlank()){
            String[] parts = date.split("/");
            return LocalDateTime.of(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]),Integer.parseInt(parts[2]),0,0);
        }
        return null;
    }

    private String getLocalDateTime(LocalDateTime localDateTime){
        StringBuffer stringBuffer = new StringBuffer();
        return stringBuffer.append(localDateTime.getYear())
                .append("/")
                .append(localDateTime.getMonthValue())
                .append("/")
                .append(localDateTime.getDayOfYear())
                .toString();
    }

}
