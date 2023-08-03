package com.informatorio.GameDevapirest.mapper.tarea.impl;

import com.informatorio.GameDevapirest.domain.Desarrollador;
import com.informatorio.GameDevapirest.domain.Tarea;
import com.informatorio.GameDevapirest.mapper.tarea.TareaMapper;
import com.informatorio.GameDevapirest.model.DTO.tarea.TareaDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;
@Component
public class TareaMapperImpl implements TareaMapper {
    @Override
    public Tarea tareaDTOToTarea(TareaDTO tareaDTO) {
        return Tarea.builder()
                .uuid(UUID.randomUUID())
                .descripcion(tareaDTO.getDescripcion())
                .estado(tareaDTO.getEstado())
                .fechaLimite(getLocalDateTime(tareaDTO.getFechaLimite()))
                .build();
    }

    @Override
    public TareaDTO tareaToTareaDTO(Tarea tarea) {
        return TareaDTO.builder()
                .descripcion(tarea.getDescripcion())
                .estado(tarea.getEstado())
                .fechaLimite(getLocalDateTime(tarea.getFechaLimite()))
                .build();
    }

    private LocalDateTime getLocalDateTime(String date){
        if (!date.isBlank()){
            String[] parts = date.split("/");
            return LocalDateTime.of(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]),Integer.parseInt(parts[2]),0,0);
        }
        return null;
    }

    private String getLocalDateTime(LocalDateTime localDateTime){
        StringBuffer stringBuffer = new StringBuffer();
        return stringBuffer.append(localDateTime.getYear())
                .append("/")
                .append(localDateTime.getMonthValue())
                .append("/")
                .append(localDateTime.getDayOfYear())
                .toString();
    }
}
