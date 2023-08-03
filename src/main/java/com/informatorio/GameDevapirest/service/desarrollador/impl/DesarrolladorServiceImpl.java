package com.informatorio.GameDevapirest.service.desarrollador.impl;

import com.informatorio.GameDevapirest.domain.Desarrollador;
import com.informatorio.GameDevapirest.domain.Juego;
import com.informatorio.GameDevapirest.exception.NotFoundException;
import com.informatorio.GameDevapirest.mapper.desarrollador.DesarrolladorMapper;
import com.informatorio.GameDevapirest.model.DTO.desarrollador.DesarrolladorDTO;
import com.informatorio.GameDevapirest.model.DTO.juego.JuegoDTO;
import com.informatorio.GameDevapirest.repository.desarrollador.DesarrolladorRepository;
import com.informatorio.GameDevapirest.repository.juego.JuegoRepository;
import com.informatorio.GameDevapirest.service.desarrollador.DesarrolladorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
@AllArgsConstructor
public class DesarrolladorServiceImpl implements DesarrolladorService {
    private final DesarrolladorRepository desarrolladorRepository;
    private final DesarrolladorMapper desarrolladorMapper;
    private final JuegoRepository juegoRepository;

    @Override
    public Desarrollador createDesarrollador(DesarrolladorDTO desarrolladorDTO) throws NotFoundException {
        Desarrollador newDesarrollador = desarrolladorMapper.desarrolladorDTOToDesarrollador(desarrolladorDTO);
        Optional<Juego> juego = juegoRepository.findById(UUID.fromString(desarrolladorDTO.getIdJuego()));

        if (juego.isPresent()){
            newDesarrollador.setJuego(juego.get());
            newDesarrollador = desarrolladorRepository.save(newDesarrollador);
        }else {
            throw new NotFoundException();
        }
        return desarrolladorRepository.save(newDesarrollador);
    }

    @Override
    public List<DesarrolladorDTO> getAllDesarrollador() {
        List<DesarrolladorDTO> listDesarrollador = new ArrayList<>();
        for (Desarrollador desarrollador: desarrolladorRepository.findAll()) {
            listDesarrollador.add(desarrolladorMapper.desarrolladorToDesarrolladorDTO(desarrollador));
        }
        return listDesarrollador;
    }
}
