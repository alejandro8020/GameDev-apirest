package com.informatorio.GameDevapirest.service.desarrollador;

import com.informatorio.GameDevapirest.domain.Desarrollador;
import com.informatorio.GameDevapirest.exception.NotFoundException;
import com.informatorio.GameDevapirest.model.DTO.desarrollador.DesarrolladorDTO;

public interface DesarrolladorService {
    Desarrollador createDesarrollador(DesarrolladorDTO desarrolladorDTO) throws NotFoundException;
}
