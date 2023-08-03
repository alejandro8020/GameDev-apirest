package com.informatorio.GameDevapirest.service.desarrollador.impl;

import com.informatorio.GameDevapirest.domain.Desarrollador;
import com.informatorio.GameDevapirest.domain.Juego;
import com.informatorio.GameDevapirest.mapper.desarrollador.DesarrolladorMapper;
import com.informatorio.GameDevapirest.model.DTO.desarrollador.DesarrolladorDTO;
import com.informatorio.GameDevapirest.repository.juego.JuegoRepository;
import com.informatorio.GameDevapirest.service.desarrollador.DesarrolladorService;

import java.util.Optional;
import java.util.UUID;

public class DesarrolladorServiceImpl implements DesarrolladorService {
    private final DesarrolladorRepository bookRepository;
    private final DesarrolladorMapper desarrolladorMapper;
    private final JuegoRepository juegoRepository;

    @Override
    public Desarrollador createDesarrollador(DesarrolladorDTO desarrolladorDTO) {
        Desarrollador newDesarrollador = desarrolladorMapper.desarrolladorDTOToDesarrollador(desarrolladorDTO);
        Optional<Juego> juego = juegoRepository.findById(UUID.fromString(desarrolladorDTO.getIdJuego()));

        if (juego.isPresent()){
            newDesarrollador.setJuego(juego.get());
            newDesarrollador = desarrolladorRepository.save(newBook);
        }else {
            throw new NotFoundException();
        }


        return null;
    }
}
