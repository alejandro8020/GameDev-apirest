package com.informatorio.GameDevapirest.service.juego.impl;

import com.informatorio.GameDevapirest.domain.Juego;
import com.informatorio.GameDevapirest.mapper.juego.JuegoMapper;
import com.informatorio.GameDevapirest.model.DTO.juego.JuegoDTO;
import com.informatorio.GameDevapirest.repository.juego.JuegoRepository;
import com.informatorio.GameDevapirest.service.juego.JuegoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class JuegoServiceImpl implements JuegoService {
    private final JuegoMapper juegoMapper;
    private final JuegoRepository juegoRepository;
    @Override
    public List<JuegoDTO> getAllJuego() {
        List<JuegoDTO> listJuegos = new ArrayList<>();
        for (Juego juego: juegoRepository.findAll()) {
            listJuegos.add(juegoMapper.juegoToJuegoDTO(juego));
        }
        return listJuegos;
    }

    @Override
    public Juego createJuego(JuegoDTO juegoDTO) {
        Juego newJuego = juegoMapper.juegoDTOToJuego(juegoDTO);
        return juegoRepository.save(newJuego);
    }
}
