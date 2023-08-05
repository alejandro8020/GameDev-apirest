package com.informatorio.GameDevapirest.mapper.juego;

import com.informatorio.GameDevapirest.domain.Juego;
import com.informatorio.GameDevapirest.model.DTO.juego.JuegoResponseDTO;
import com.informatorio.GameDevapirest.model.DTO.juego.JuegoTareaDTO;

public interface JuegoTareaMapper {
    JuegoTareaDTO juegoToJuegoTareaDTO(Juego juego);
}
