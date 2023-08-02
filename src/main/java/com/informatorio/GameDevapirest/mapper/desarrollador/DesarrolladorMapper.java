package com.informatorio.GameDevapirest.mapper.desarrollador;

import com.informatorio.GameDevapirest.domain.Desarrollador;
import com.informatorio.GameDevapirest.model.DTO.desarrollador.DesarrolladorDTO;

public interface DesarrolladorMapper {
    Desarrollador desarrolladorDTOToDesarrollador(DesarrolladorDTO desarrolladorDTO);
    DesarrolladorDTO desarrolladorToDesarrolladorDTO(Desarrollador desarrollador);
}
