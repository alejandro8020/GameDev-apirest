package com.informatorio.GameDevapirest.mapper.juego;

import com.informatorio.GameDevapirest.domain.Juego;
import com.informatorio.GameDevapirest.model.DTO.juego.JuegoResponseDTO;

public interface JuegoResponseMapper {
    JuegoResponseDTO juegoToJuegoResponseDTO(Juego juego);
}
