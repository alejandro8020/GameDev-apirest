package com.informatorio.GameDevapirest.repository.tarea;


import com.informatorio.GameDevapirest.domain.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface TareaRepository extends JpaRepository<Tarea, UUID> {
    Optional<Tarea> findBydescripcionIgnoreCase(String descripcion);
}
