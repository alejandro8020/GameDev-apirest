package com.informatorio.GameDevapirest.service.tarea.impl;

import com.informatorio.GameDevapirest.domain.Tarea;
import com.informatorio.GameDevapirest.mapper.tarea.TareaMapper;
import com.informatorio.GameDevapirest.model.DTO.tarea.TareaDTO;
import com.informatorio.GameDevapirest.repository.tarea.TareaRepository;
import com.informatorio.GameDevapirest.service.tarea.TareaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class TareaServicioImpl implements TareaService {
    private final TareaMapper tareaMapper;
    private final TareaRepository tareaRepository;

    @Override
    public List<TareaDTO> getAllTarea() {
        List<TareaDTO> listTarea = new ArrayList<>();
        for (Tarea tarea: tareaRepository.findAll()) {
            listTarea.add(tareaMapper.tareaToTareaDTO(tarea));
        }
        return listTarea;
    }

    @Override
    public Tarea createTarea(TareaDTO tareaDTO) {
        Tarea newTarea = tareaMapper.tareaDTOToTarea(tareaDTO);
        return tareaRepository.save(newTarea);
    }
}
