package com.informatorio.GameDevapirest.controlador.juego;

import com.informatorio.GameDevapirest.model.DTO.juego.JuegoDTO;
import com.informatorio.GameDevapirest.service.juego.JuegoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //Anotacion a nivel de clase
@RequestMapping("/api/v1/juego") //Todos los endpoints comparten esta URI
@RequiredArgsConstructor
@Slf4j
public class JuegoController {
    private final JuegoService juegoService;

    @GetMapping()
    public List<JuegoDTO> getAllJuego(){
        log.info("Se esta haciendo una consulta por los autores");
        return juegoService.getAllJuego();
    }
}
