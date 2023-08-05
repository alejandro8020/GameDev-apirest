package com.informatorio.GameDevapirest.repository.tarea;


import com.informatorio.GameDevapirest.domain.Tarea;
import com.informatorio.GameDevapirest.enumeration.tarea.TareaEnum;
import com.informatorio.GameDevapirest.model.DTO.tarea.TareaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface TareaRepository extends JpaRepository<Tarea, UUID> {
    Optional<Tarea> findByDescripcionIgnoreCase(String descripcion);
    List<Tarea> findTareaByEstado(TareaEnum estado);
    @Query(value= "SELECT * FROM tarea WHERE juego_uuid = :uuid", nativeQuery = true)
    Optional<Tarea> findTareaByJuego_Uuid(@Param("uuid")UUID uuid);
    List<Tarea> findTareaByFechaLimiteAfter(LocalDateTime fecha);
}
