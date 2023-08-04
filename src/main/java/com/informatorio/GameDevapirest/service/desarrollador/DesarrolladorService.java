package com.informatorio.GameDevapirest.service.desarrollador;

import com.informatorio.GameDevapirest.domain.Desarrollador;
import com.informatorio.GameDevapirest.exception.NotFoundException;
import com.informatorio.GameDevapirest.model.DTO.desarrollador.DesarrolladorDTO;
import com.informatorio.GameDevapirest.model.DTO.desarrollador.DesarrolladorResponseDTO;

import java.util.UUID;
import java.util.List;
import java.util.Optional;

public interface DesarrolladorService {
    Desarrollador createDesarrollador(DesarrolladorDTO desarrolladorDTO) throws NotFoundException;
    List<DesarrolladorDTO> getAllDesarrollador();
    Optional<DesarrolladorResponseDTO> getTareasByIdDesarrollador(UUID uuid);
}
