package com.informatorio.GameDevapirest.service.juego.impl;

import com.informatorio.GameDevapirest.domain.Juego;
import com.informatorio.GameDevapirest.mapper.juego.JuegoMapper;
import com.informatorio.GameDevapirest.mapper.juego.JuegoResponseMapper;
import com.informatorio.GameDevapirest.mapper.juego.JuegoTareaMapper;
import com.informatorio.GameDevapirest.model.DTO.juego.JuegoDTO;
import com.informatorio.GameDevapirest.model.DTO.juego.JuegoResponseDTO;
import com.informatorio.GameDevapirest.model.DTO.juego.JuegoTareaDTO;
import com.informatorio.GameDevapirest.repository.juego.JuegoRepository;
import com.informatorio.GameDevapirest.service.juego.JuegoService;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class JuegoServiceImpl implements JuegoService {
    private final JuegoMapper juegoMapper;
    private final JuegoRepository juegoRepository;
    private final JuegoResponseMapper juegoResponseMapper;
    private final JuegoTareaMapper juegoTareaMapper;
    @Override
    public List<JuegoDTO> getAllJuego(String fecha) {
        List<Juego> JuegoPorFecha;
        List<JuegoDTO> listJuegos = new ArrayList<>();
        if (StringUtils.isNotEmpty(fecha)){

            JuegoPorFecha = juegoRepository.findJuegoByFechaLanzamientoBefore(getLocalDateTime(fecha));
        }else {
            JuegoPorFecha = juegoRepository.findAll();
        }
        for (Juego juego: JuegoPorFecha) {
            listJuegos.add(juegoMapper.juegoToJuegoDTO(juego));
        }
        return listJuegos;
    }

    @Override
    public Juego createJuego(JuegoDTO juegoDTO) {
        Juego newJuego = juegoMapper.juegoDTOToJuego(juegoDTO);
        return juegoRepository.save(newJuego);
    }

    @Override
    public Optional<JuegoResponseDTO> getDesarrolladoresByIdJuego(UUID uuid) {
        Optional<Juego> juegoOptional = juegoRepository.findById(uuid);

        if (juegoOptional.isPresent()){
            return Optional.of(juegoResponseMapper.juegoToJuegoResponseDTO(juegoOptional.get()));
        }
        return Optional.empty();
    }

    @Override
    public Optional<JuegoTareaDTO> getTareaByIdJuego(UUID uuid) {
        Optional<Juego> juegoOptional = juegoRepository.findById(uuid);

        if (juegoOptional.isPresent()){
            return Optional.of(juegoTareaMapper.juegoToJuegoTareaDTO(juegoOptional.get()));
        }
        return Optional.empty();
    }

    private LocalDateTime getLocalDateTime(String date){
        if (!date.isBlank()){
            String[] parts = date.split("/");
            return LocalDateTime.of(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]),Integer.parseInt(parts[2]),0,0,0);
        }
        return null;
    }
}
