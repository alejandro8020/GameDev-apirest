package com.informatorio.GameDevapirest.service.juego;

import com.informatorio.GameDevapirest.domain.Juego;
import com.informatorio.GameDevapirest.model.DTO.juego.JuegoDTO;

import java.util.List;

public interface JuegoService {
    List<JuegoDTO> getAllJuego();
    Juego createJuego(JuegoDTO juegoDTO);
}
