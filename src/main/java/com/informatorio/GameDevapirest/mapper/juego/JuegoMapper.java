package com.informatorio.GameDevapirest.mapper.juego;

import com.informatorio.GameDevapirest.domain.Juego;
import com.informatorio.GameDevapirest.model.DTO.juego.JuegoDTO;

public interface JuegoMapper {
    Juego juegoDTOToJuego(JuegoDTO JuegoDTO);
    JuegoDTO juegoToJuegoDTO(Juego Juego);
}
