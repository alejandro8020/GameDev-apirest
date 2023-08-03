package com.informatorio.GameDevapirest.repository.desarrollador;

import com.informatorio.GameDevapirest.domain.Desarrollador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface DesarrolladorRepository extends JpaRepository<Desarrollador, UUID> {
    Optional<Desarrollador> findBookByNameEqualsIgnoreCase(String title);
}
