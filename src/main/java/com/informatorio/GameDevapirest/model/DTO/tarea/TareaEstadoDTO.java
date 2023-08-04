package com.informatorio.GameDevapirest.model.DTO.tarea;
import com.informatorio.GameDevapirest.enumeration.tarea.TareaEnum;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TareaEstadoDTO {
    private TareaEnum estado;
}
