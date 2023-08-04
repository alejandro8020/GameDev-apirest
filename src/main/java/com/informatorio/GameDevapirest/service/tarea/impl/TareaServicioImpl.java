package com.informatorio.GameDevapirest.service.tarea.impl;

import com.informatorio.GameDevapirest.domain.Desarrollador;
import com.informatorio.GameDevapirest.domain.Juego;
import com.informatorio.GameDevapirest.domain.Tarea;
import com.informatorio.GameDevapirest.exception.NotFoundException;
import com.informatorio.GameDevapirest.mapper.tarea.TareaEstadoMapper;
import com.informatorio.GameDevapirest.mapper.tarea.TareaMapper;
import com.informatorio.GameDevapirest.mapper.tarea.TareaResponseMapper;
import com.informatorio.GameDevapirest.model.DTO.tarea.TareaDTO;
import com.informatorio.GameDevapirest.model.DTO.tarea.TareaEstadoDTO;
import com.informatorio.GameDevapirest.model.DTO.tarea.TareaResponseDTO;
import com.informatorio.GameDevapirest.repository.desarrollador.DesarrolladorRepository;
import com.informatorio.GameDevapirest.repository.juego.JuegoRepository;
import com.informatorio.GameDevapirest.repository.tarea.TareaRepository;
import com.informatorio.GameDevapirest.service.tarea.TareaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TareaServicioImpl implements TareaService {
    private final TareaMapper tareaMapper;
    private final TareaResponseMapper tareaResponserMapper;
    private final TareaEstadoMapper tareaEstadoMapper;
    private final TareaRepository tareaRepository;
    private final DesarrolladorRepository desarrolladorRepository;
    private final JuegoRepository juegoRepository;

    @Override
    public List<TareaResponseDTO> getAllTarea() {
        List<TareaResponseDTO> listTarea = new ArrayList<>();
        for (Tarea tarea: tareaRepository.findAll()) {
            listTarea.add(tareaResponserMapper.tareaToTareaResponseDTO(tarea));
        }
        return listTarea;
    }

    @Override
    public Tarea createTarea(TareaDTO tareaDTO) throws NotFoundException {
        Tarea newTarea = tareaMapper.tareaDTOToTarea(tareaDTO);
        Optional<Desarrollador> desarrollador = desarrolladorRepository.findById(UUID.fromString(tareaDTO.getIdDesarrollador()));
        if (desarrollador.isPresent()){
            newTarea.setDesarrollador(desarrollador.get());
            newTarea = tareaRepository.save(newTarea);
        }else {
            throw new NotFoundException();
        }

        Optional<Juego> juego = juegoRepository.findById(UUID.fromString(tareaDTO.getIdjuego()));
        if (juego.isPresent()){
            newTarea.setJuego(juego.get());
            newTarea = tareaRepository.save(newTarea);
        }else {
            throw new NotFoundException();
        }
        return tareaRepository.save(newTarea);
    }

    @Override
    public Optional<Tarea> CambiarEstadoTarea(UUID uuid, TareaEstadoDTO tareaDTO) {
        Optional<Tarea> tarea = tareaRepository.findById(uuid);
        if (tarea.isPresent()){
            Tarea tareaUpdated = tareaEstadoMapper.tareaDTOToTarea(tareaDTO);
            updatingAuthor(tarea.get(),tareaUpdated);
            tareaRepository.save(tarea.get());
            return tarea;
        }

        return Optional.empty();
    }
    private void updatingAuthor(Tarea tarea,Tarea tareaUpdated){
        if (!tareaUpdated.getEstado().equals(tarea.getEstado())){
            tarea.setEstado(tareaUpdated.getEstado());
        }

    }
}
