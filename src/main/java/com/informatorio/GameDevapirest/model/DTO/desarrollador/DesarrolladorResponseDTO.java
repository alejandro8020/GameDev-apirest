package com.informatorio.GameDevapirest.model.DTO.desarrollador;
import com.informatorio.GameDevapirest.enumeration.desarrollador.DesarrolladorEnum;
import com.informatorio.GameDevapirest.model.DTO.tarea.TareaResponseDTO;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DesarrolladorResponseDTO {
    private String name;
    private DesarrolladorEnum rol;
    private List<TareaResponseDTO> tareaResponseDTOS;
}
