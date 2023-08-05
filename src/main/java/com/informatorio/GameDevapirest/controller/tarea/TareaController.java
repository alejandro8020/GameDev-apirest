package com.informatorio.GameDevapirest.controller.tarea;

import com.informatorio.GameDevapirest.domain.Juego;
import com.informatorio.GameDevapirest.domain.Tarea;
import com.informatorio.GameDevapirest.exception.NotFoundException;
import com.informatorio.GameDevapirest.model.DTO.desarrollador.DesarrolladorResponseDTO;
import com.informatorio.GameDevapirest.model.DTO.juego.JuegoDTO;
import com.informatorio.GameDevapirest.model.DTO.tarea.TareaDTO;
import com.informatorio.GameDevapirest.model.DTO.tarea.TareaEstadoDTO;
import com.informatorio.GameDevapirest.model.DTO.tarea.TareaResponseDTO;
import com.informatorio.GameDevapirest.service.juego.JuegoService;
import com.informatorio.GameDevapirest.service.tarea.TareaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController //Anotacion a nivel de clase
@RequestMapping("/api/v1/tarea") //Todos los endpoints comparten esta URI
@RequiredArgsConstructor
@Slf4j
public class TareaController {
    private final TareaService tareaService;

    @GetMapping()
    public List<TareaResponseDTO> getAllTarea(@RequestParam(required = false,name = "estado") String estado){
        log.info("Se esta haciendo una consulta por los Juegos");
        return tareaService.getAllTarea(estado);
    }

    @PostMapping()
    public ResponseEntity createTarea(@RequestBody TareaDTO tareaDTO) throws NotFoundException {
        log.info("Creacion de un nuevo tarea");
        Tarea tareaCreated = tareaService.createTarea(tareaDTO);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/tarea/"+ tareaCreated.getUuid());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{idTarea}")
    public ResponseEntity CambiarEstadoTarea(@PathVariable(value = "idTarea") UUID idTarea, @RequestBody TareaEstadoDTO tareaUpdated)
            throws NotFoundException {
        Optional<Tarea> tarea = tareaService.CambiarEstadoTarea(idTarea,tareaUpdated);

        if(tarea.isEmpty()){
            log.warn("Tarea no encontrada");
            throw new NotFoundException();
        }else {
            log.info("Tarea actualizado");
            return  new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/{idJuego}")
    public TareaDTO getTareaByJuegoId(@PathVariable(value = "idJuego") UUID idJuego) throws NotFoundException {
        return tareaService.getTareaByJuegoId(idJuego).orElseThrow(NotFoundException::new);
    }

}
