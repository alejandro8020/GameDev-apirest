package com.informatorio.GameDevapirest.controller.juego;

import com.informatorio.GameDevapirest.domain.Juego;
import com.informatorio.GameDevapirest.exception.NotFoundException;
import com.informatorio.GameDevapirest.model.DTO.juego.JuegoDTO;
import com.informatorio.GameDevapirest.model.DTO.juego.JuegoResponseDTO;
import com.informatorio.GameDevapirest.model.DTO.juego.JuegoTareaDTO;
import com.informatorio.GameDevapirest.service.juego.JuegoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController //Anotacion a nivel de clase
@RequestMapping("/api/v1/juego") //Todos los endpoints comparten esta URI
@RequiredArgsConstructor
@Slf4j
public class JuegoController {
    private final JuegoService juegoService;

    @GetMapping()
    public List<JuegoDTO> getAllJuego(@RequestParam(required = false,name = "fecha") String fecha){
        log.info("Se esta haciendo una consulta por los Juegos");
        return juegoService.getAllJuego(fecha);
    }

    @PostMapping()
    public ResponseEntity createJuego(@RequestBody JuegoDTO juegoDTO){
        log.info("Creacion de un nuevo Juego");
        Juego juegoCreated = juegoService.createJuego(juegoDTO);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/author/"+ juegoCreated.getUuid());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }
    @GetMapping("/{idJuego}")
    public JuegoResponseDTO getDesarrolladoresByIdJuego(@PathVariable(value = "idJuego") UUID idJuego) throws NotFoundException {
        return juegoService.getDesarrolladoresByIdJuego(idJuego).orElseThrow(NotFoundException::new);
    }
    @GetMapping("/tarea/{idJuego}")
    public JuegoTareaDTO getTareaByIdJuego(@PathVariable(value = "idJuego") UUID idJuego) throws NotFoundException {
        return juegoService.getTareaByIdJuego(idJuego).orElseThrow(NotFoundException::new);
    }
}
