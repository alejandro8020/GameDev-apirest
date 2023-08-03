package com.informatorio.GameDevapirest.model.DTO.desarrollador;
import com.informatorio.GameDevapirest.enumeration.desarrollador.DesarrolladorEnum;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DesarrolladorDTO {
    private String name;
    private String mail;
    private DesarrolladorEnum rol;
    private String idJuego;
}
