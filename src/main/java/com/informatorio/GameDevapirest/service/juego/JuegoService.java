package com.informatorio.GameDevapirest.service.juego;

import com.informatorio.GameDevapirest.domain.Juego;
import com.informatorio.GameDevapirest.model.DTO.desarrollador.DesarrolladorResponseDTO;
import com.informatorio.GameDevapirest.model.DTO.juego.JuegoDTO;
import com.informatorio.GameDevapirest.model.DTO.juego.JuegoResponseDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface JuegoService {
    List<JuegoDTO> getAllJuego(String fecha);
    Juego createJuego(JuegoDTO juegoDTO);
    Optional<JuegoResponseDTO> getDesarrolladoresByIdJuego(UUID uuid);

}
