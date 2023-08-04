package com.informatorio.GameDevapirest.mapper.desarrollador;

import com.informatorio.GameDevapirest.domain.Desarrollador;
import com.informatorio.GameDevapirest.model.DTO.desarrollador.DesarrolladorResponseDTO;

public interface DesarrolladorResponseMapper {
    DesarrolladorResponseDTO DesarrolladorToDesarrolladorResponseDTO(Desarrollador desarrollador);
}
