package com.informatorio.GameDevapirest.controller.desarrollador;
import com.informatorio.GameDevapirest.domain.Desarrollador;
import com.informatorio.GameDevapirest.exception.NotFoundException;
import com.informatorio.GameDevapirest.model.DTO.desarrollador.DesarrolladorDTO;
import com.informatorio.GameDevapirest.service.desarrollador.DesarrolladorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController //Anotacion a nivel de clase
@RequestMapping("/api/v1/desarrollador") //Todos los endpoints comparten esta URI
@Slf4j
public class DesarrolladorController {
    DesarrolladorService desarrolladorService;

    @Autowired
    public DesarrolladorController(DesarrolladorService desarrolladorService) {
        this.desarrolladorService = desarrolladorService;
    }

    @PostMapping()
    public ResponseEntity createBook(@RequestBody DesarrolladorDTO desarrolladorDTO) throws NotFoundException {
        log.info("Creacion de un nuevo libro");
        Desarrollador desarrolladorCreated = desarrolladorService.createDesarrollador(desarrolladorDTO);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/book/"+desarrolladorCreated.getUuid());

        return new ResponseEntity(headers,HttpStatus.CREATED);
    }
}
